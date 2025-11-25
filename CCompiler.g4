grammar CCompiler;

options{
    language = Java;
}

//Imports
@parser::header {
    import java.math.BigDecimal;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.function.Supplier;
}

@parser::members{
    public static class TypedValue {
        public enum Kind { INT, BOOL, DECIMAL, STRING }

        public final Kind kind;
        public final Integer intVal;
        public final Boolean boolVal;
        public final BigDecimal decVal;
        public final String strVal;

        public TypedValue(Integer v)    { this.kind = Kind.INT;     this.intVal = v;    this.boolVal = null;    this.decVal = null;     this.strVal = null; }
        public TypedValue(Boolean v)    { this.kind = Kind.BOOL;    this.intVal = null; this.boolVal = v;       this.decVal = null;     this.strVal = null; }
        public TypedValue(BigDecimal v) { this.kind = Kind.DECIMAL; this.intVal = null; this.boolVal = null;    this.decVal = v;        this.strVal = null; }
        public TypedValue(String v)     { this.kind = Kind.STRING;  this.intVal = null; this.boolVal = null;    this.decVal = null;     this.strVal = v;    }

        @Override
        public String toString() {
            switch(kind) {
                case INT: return intVal.toString();
                case BOOL: return boolVal.toString();
                case DECIMAL: return decVal.toPlainString();
                case STRING: return strVal;
                default: return "null";
            }
        }

        public BigDecimal asBigDecimal() {
            switch(kind) {
                case INT: return new BigDecimal(intVal);
                case DECIMAL: return decVal;
                default: throw new RuntimeException("Not a numeric value: " + this);
            }
        }
    }

    private final Map<String, TypedValue> variables = new HashMap<>();

    enum TypeKind { INT, BOOL, DECIMAL, STRING }
    private boolean isNumeric(TypedValue v){
        return v.kind == TypedValue.Kind.INT || v.kind == TypedValue.Kind.DECIMAL;
    }

    private boolean isAssignable(TypeKind declared, TypedValue val) {
        switch(declared) {
            case INT: return val.kind == TypedValue.Kind.INT;
            case BOOL: return val.kind == TypedValue.Kind.BOOL;
            case DECIMAL: return val.kind == TypedValue.Kind.DECIMAL || val.kind == TypedValue.Kind.INT;
            case STRING: return val.kind == TypedValue.Kind.STRING;
            default: return false;
        }
    }

    private boolean isAssignable(TypedValue.Kind declared, TypedValue val) {
        if (declared == TypedValue.Kind.DECIMAL) {
            return val.kind == TypedValue.Kind.DECIMAL || val.kind == TypedValue.Kind.INT;
        }
        else {
            return declared == val.kind;
        }
    }
}

// Regras do parser
prog: main_function function* EOF;
main_function: type 'main' FP LP FK function_body LK;
function: type ID FP LP FK function_body LK;
statement returns [Runnable action]
    : d=declaration     { $action = $d.action; }
    | a=assignment      { $action = $a.action; }
    | p=printf_stmt     { $action = $p.action; }
    | e=expr SCOMMA     { $action = null; }
    | i=if_stmt         { $action = $i.action; }
    ;

function_body
: (st+=statement SCOMMA? )*
    {
    if ($st != null) {
        for (int i = 0; i < $st.size(); ++i) {
            Runnable r = $st.get(i).action;
            if (r != null) r.run();
        }
    }
};

block returns [java.util.List<Runnable> actions]
: FK
    {
        $actions = new java.util.ArrayList<Runnable>();
    }
    ( st+=statement SCOMMA?
        {
            if ($st.get($st.size()-1).action != null) $actions.add($st.get($st.size()-1).action);
        }
    )*
LK;

if_stmt returns [Runnable action]
: IF FP cond=expr LP thenBlock=block ( ELSE elseBlock = block )?
    {
    final Supplier<TypedValue> condSupplier = $cond.value;
    final java.util.List<Runnable> thenActions = $thenBlock.actions;
    final java.util.List<Runnable> elseActions = ($ELSE != null ? $elseBlock.actions : null);
    final int line = $IF.getLine();
    final int pos = $IF.getCharPositionInLine();

    $action = new Runnable() {
        public void run() {
            TypedValue conditionValue = condSupplier.get();
            if (conditionValue == null || conditionValue.kind != TypedValue.Kind.BOOL)
                throw new RuntimeException("if condition must be boolean at line " + line + ":" + pos);

            boolean c = conditionValue.boolVal;
            java.util.List<Runnable> toRun = c ? thenActions : elseActions;
            if (toRun != null) {
                for (Runnable r : toRun) {
                    r.run();
                }
            }
        }
    };
};

declaration returns [Runnable action]
: t = type id = ID ( OP_ASS e = expr )?
    {
    final String name = $id.getText();
    final TypeKind typeKind = $t.typeKind;
    final Supplier<TypedValue> initSupplier = ($e.value != null ? $e.value : null);
    final int line = $id.getLine();
    final int pos = $id.getCharPositionInLine();

    $action = new Runnable() {
        public void run() {
            if (variables.containsKey(name)) {
                throw new RuntimeException("Variable already declared: '" + name
                    + "' at line " + line
                    + ":" + pos
                );
            }

            TypedValue val = null;
            if (initSupplier != null) {
                val = initSupplier.get();
            }

            if (val == null) {
                switch(typeKind) {
                    case INT: val = new TypedValue(0); break;
                    case BOOL: val = new TypedValue(false); break;
                    case DECIMAL: val = new TypedValue(new BigDecimal("0")); break;
                    case STRING: val = new TypedValue(""); break;
                }
            } else {
                if (!isAssignable(typeKind, val))
                    throw new RuntimeException("Cannot assign " + val.kind + " to " + typeKind);

                if (typeKind == TypeKind.DECIMAL && val.kind == TypedValue.Kind.INT)
                    val = new TypedValue(val.asBigDecimal());
            }

            variables.put(name, val);
        }
    };
};

assignment returns [Runnable action]
: id=ID OP_ASS e=expr
{
    final String name = $id.getText();
    final Supplier<TypedValue> rvalSupplier = $e.value;
    final int line = $id.getLine();
    final int pos = $id.getCharPositionInLine();

    $action = new Runnable() {
        public void run() {
            if (!variables.containsKey(name))
                throw new RuntimeException("Undefined variable: " + name + " at line " + line + ":" + pos);

            TypedValue val = rvalSupplier.get();
            TypedValue old = variables.get(name);

            if (old.kind == TypedValue.Kind.DECIMAL && val.kind == TypedValue.Kind.INT)
                val = new TypedValue(val.asBigDecimal());

            if (!isAssignable(old.kind, val))
                throw new RuntimeException("Cannot assign " + val.kind + " to variable of type " + old.kind);

            variables.put(name, val);
        }
    };
};

printf_stmt returns [Runnable action]
: 'printf' FP e = expr LP
{
    final Supplier<TypedValue> vSupplier = $e.value;
    $action = new Runnable() {
        public void run() {
            TypedValue v = vSupplier.get();
            System.out.println(v);
        }
    };
};

expr returns [Supplier<TypedValue> value]
: left = compare
{
    $value = $left.value;
};

compare returns [Supplier<TypedValue> value]
: left = add
    {
    $value = $left.value;
    }
( op=(EQ | GT | LT) right = add
    {
    final Supplier<TypedValue> leftSup = $value;
    final Supplier<TypedValue> rightSup = $right.value;
    final String operator = $op.getText();

    $value = new Supplier<TypedValue>() {
        public TypedValue get() {
        TypedValue l = leftSup.get();
        TypedValue r = rightSup.get();

        if (operator.equals("==")) {
            if (l.kind == r.kind) {
                switch (l.kind) {
                    case INT:   return new TypedValue(l.intVal.equals(r.intVal));
                    case BOOL:  return new TypedValue(l.boolVal.equals(r.boolVal));
                    case DECIMAL: return new TypedValue(l.asBigDecimal().compareTo(r.asBigDecimal()) == 0);
                    case STRING: return new TypedValue(l.strVal.equals(r.strVal));
                }
            }

            if ((l.kind == TypedValue.Kind.INT && r.kind == TypedValue.Kind.DECIMAL) ||
                (l.kind == TypedValue.Kind.DECIMAL && r.kind == TypedValue.Kind.INT)) {
                return new TypedValue(l.asBigDecimal().compareTo(r.asBigDecimal()) == 0);
            }

            throw new RuntimeException("Operator == not supported for operands: " + l.kind + " and " + r.kind);
        }

        if (operator.equals(">") || operator.equals("<")) {
            if ( (l.kind == TypedValue.Kind.INT || l.kind == TypedValue.Kind.DECIMAL)
                && (r.kind == TypedValue.Kind.INT || r.kind == TypedValue.Kind.DECIMAL) ) {
                BigDecimal a = l.asBigDecimal();
                BigDecimal b = r.asBigDecimal();
                int cmp = a.compareTo(b);
                boolean res = operator.equals(">") ? (cmp > 0) : (cmp < 0);
                return new TypedValue(res);
            }

            if (l.kind == TypedValue.Kind.STRING && r.kind == TypedValue.Kind.STRING) {
                int cmp = l.strVal.compareTo(r.strVal);
                boolean res = operator.equals(">") ? (cmp > 0) : (cmp < 0);
                return new TypedValue(res);
            }

            throw new RuntimeException("Operator " + operator + " requires numeric or string operands");
        }

        throw new RuntimeException("Unknown comparison operator: " + operator);
        }
    };
    }
)*;

add returns [Supplier<TypedValue> value]
: left = term
{
    $value = $left.value;
}
(   op=('+'|'-') right = term
    {
        final Supplier<TypedValue> leftSup = $value;
        final Supplier<TypedValue> rightSup = $right.value;
        final String operator = $op.getText();

        $value = new Supplier<TypedValue>() {
            public TypedValue get() {
                TypedValue l = leftSup.get();
                TypedValue r = rightSup.get();

                if (operator.equals("+") &&
                    (l.kind == TypedValue.Kind.STRING || r.kind == TypedValue.Kind.STRING)) {
                    String a = l.toString();
                    String b = r.toString();
                    return new TypedValue(a + b);
                } else {
                    if (!isNumeric(l) || !isNumeric(r))
                        throw new RuntimeException("Operator " + operator + " requires numeric operands");

                    if (l.kind == TypedValue.Kind.DECIMAL || r.kind == TypedValue.Kind.DECIMAL) {
                        BigDecimal a = l.asBigDecimal();
                        BigDecimal b = r.asBigDecimal();
                        BigDecimal res = operator.equals("+") ? a.add(b) : a.subtract(b);
                        return new TypedValue(res);
                    } else {
                        int a = l.intVal;
                        int b = r.intVal;
                        int rr = operator.equals("+") ? (a + b) : (a - b);
                        return new TypedValue(rr);
                    }
                }
            }
        };
    }
)*;

term returns [Supplier<TypedValue> value]
: left = factor
{
    $value = $left.value;
}
(   op=('*'|'/') right = factor
    {
        final Supplier<TypedValue> leftSup = $value;
        final Supplier<TypedValue> rightSup = $right.value;
        final String operator = $op.getText();

        $value = new Supplier<TypedValue>() {
            public TypedValue get() {
                TypedValue l = leftSup.get();
                TypedValue r = rightSup.get();

                if (!isNumeric(l) || !isNumeric(r))
                    throw new RuntimeException("Operator " + operator + " requires numeric operands");

                if (l.kind == TypedValue.Kind.DECIMAL || r.kind == TypedValue.Kind.DECIMAL) {
                    BigDecimal a = l.asBigDecimal();
                    BigDecimal b = r.asBigDecimal();
                    BigDecimal res;
                    if (operator.equals("*")) res = a.multiply(b);
                    else res = a.divide(b, 18, java.math.RoundingMode.HALF_UP);
                    return new TypedValue(res);
                } else {
                    int a = l.intVal;
                    int b = r.intVal;
                    if (operator.equals("*")) return new TypedValue(a * b);
                    else {
                        if (b == 0) throw new RuntimeException("Division by zero!!!");
                        return new TypedValue(a / b);
                    }
                }
            }
        };
    }
)*;

factor returns [Supplier<TypedValue> value]
: INT
{
    final String txt = $INT.getText();
    $value = new Supplier<TypedValue>() {
        public TypedValue get() { return new TypedValue(Integer.parseInt(txt)); }
    };
}
| DECIMAL
{
    final String txt = $DECIMAL.getText();
    $value = new Supplier<TypedValue>() {
        public TypedValue get() { return new TypedValue(new BigDecimal(txt)); }
    };
}
| BOOL
{
    final String txt = $BOOL.getText();
    $value = new Supplier<TypedValue>() {
        public TypedValue get() { return new TypedValue(Boolean.parseBoolean(txt)); }
    };
}
| STRING
{
    final String raw = $STRING.getText();
    final String inner = raw.substring(1, raw.length() - 1)
        .replace("\\n", "\n")
        .replace("\\t", "\t")
        .replace("\\\"", "\"")
        .replace("\\\\", "\\");
    $value = new Supplier<TypedValue>() {
        public TypedValue get() { return new TypedValue(inner); }
    };
}
| id = ID
{
    final String name = $id.getText();
    $value = new Supplier<TypedValue>() {
        public TypedValue get() {
            if (!variables.containsKey(name)) throw new RuntimeException("Undefined variable: " + name);
            return variables.get(name);
        }
    };
}
| FP e = expr LP
{
    $value = $e.value;
};

type returns [TypeKind typeKind]
    : 'int'         { $typeKind = TypeKind.INT; }
    | 'bool'        { $typeKind = TypeKind.BOOL; }
    | 'decimal'     { $typeKind = TypeKind.DECIMAL; }
    | 'string'      { $typeKind = TypeKind.STRING; }
    ;

// Regras do Lexer
INT: [0-9]+;
BOOL: 'true' | 'false';
DECIMAL: [0-9]+ '.' [0-9]+ ;
STRING: '"' ( ~["\\] | '\\' . )* '"' ;
IF: 'if' ;
ELSE: 'else' ;
EQ: '==' ;
GT: '>' ;
LT: '<' ;
ID: [a-zA-Z] ([a-zA-Z] | [0-9])* ;
OP: '+' | '-' | '*' | '/' ;
FP: '(' ;
LP: ')' ;
FK: '{' ;
LK: '}' ;
OP_ASS: '=';
COMMA: ',';
SCOMMA: ';';
WS: [ \t\r\n]+ -> skip ;