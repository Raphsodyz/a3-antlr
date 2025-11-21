grammar CCompiler;

options { language = Java; }

// Imports
@parser::header {
    import java.math.BigDecimal;
    import java.util.Map;
    import java.util.HashMap;
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

// ----------------
// Parser rules
// ----------------

prog: main_function function* EOF;

main_function: type 'main' '(' ')' '{' function_body '}' ;
function: type ID '(' ')' '{' function_body '}' ;

function_body: (statement)* ;

statement
    : ifStatement
    | whileStatement
    | doWhileStatement
    | forStatement
    | block
    | declaration ';'
    | assignment ';'
    | printf_stmt
    | scanf_stmt
    | expr ';'
    | ';'
    ;

block: '{' (statement)* '}' ;

ifStatement
    : 'if' '(' expr ')' statement ( 'else' statement )?
    ;

whileStatement
    : 'while' '(' expr ')' statement
    ;

doWhileStatement
    : 'do' statement 'while' '(' expr ')' ';'
    ;

forStatement
    : 'for' '(' forInit? ';' expr? ';' forUpdate? ')' statement
    ;

forInit
    : declaration
    | simpleAssignment
    ;

forUpdate
    : simpleAssignment
    ;

declaration
    : t=type id=ID ( OP_ASS e=expr )?
    {
        String name = $id.getText();
        if (variables.containsKey(name)) {
            throw new RuntimeException("Variable already declared: '" + name
                + "' at line " + $id.getLine()
                + ":" + $id.getCharPositionInLine()
            );
        }

        TypedValue val = null;
        CCompilerParser.DeclarationContext dctx = (CCompilerParser.DeclarationContext)_localctx;
        if (dctx.e != null) val = dctx.e.value;

        if (val == null) {
            switch($t.typeKind) {
                case INT: val = new TypedValue(0); break;
                case BOOL: val = new TypedValue(false); break;
                case DECIMAL: val = new TypedValue(new BigDecimal("0")); break;
                case STRING: val = new TypedValue(""); break;
            }
        }
        else {
            if (!isAssignable($t.typeKind, val))
                throw new RuntimeException("Cannot assign " + val.kind + " to " + $t.typeKind);

            if ($t.typeKind == TypeKind.DECIMAL && val.kind == TypedValue.Kind.INT)
                val = new TypedValue(val.asBigDecimal());
        }

        variables.put($id.getText(), val);
    }
    ;

assignment
    : id=ID OP_ASS e=expr
    {
        TypedValue val = $e.value;
        if (!variables.containsKey($id.getText()))
            throw new RuntimeException("Undefined variable: " + $id.getText());

        TypedValue old = variables.get($id.getText());
        if (old.kind == TypedValue.Kind.DECIMAL && val.kind == TypedValue.Kind.INT)
            val = new TypedValue(val.asBigDecimal());

        if (!isAssignable(old.kind, val))
            throw new RuntimeException("Cannot assign " + val.kind + " to variable of type " + old.kind);

        variables.put($id.getText(), val);
    }
    ;

simpleAssignment
    : ID OP_ASS expr
    ;

/*
 Expression precedence:
   expr    -> relational (==, !=, <, >, <=, >=)
   addExpr -> +, -
   term    -> *, /
   factor  -> literals, id, '(' expr ')'
*/

expr returns [TypedValue value]
    : left=relExpr { $value = $left.value; } ;

relExpr returns [TypedValue value]
    : left=addExpr { $value = $left.value; }
      ( op=(LT | GT | LE | GE | EQ | NEQ) right=addExpr
        {
            if (!isNumeric($left.value) || !isNumeric($right.value))
                throw new RuntimeException("Relational operators require numeric operands");

            BigDecimal a = $left.value.asBigDecimal();
            BigDecimal b = $right.value.asBigDecimal();

            boolean result;
            String opname = $op.getText();
            switch (opname) {
                case "<":  result = a.compareTo(b) < 0; break;
                case ">":  result = a.compareTo(b) > 0; break;
                case "<=": result = a.compareTo(b) <= 0; break;
                case ">=": result = a.compareTo(b) >= 0; break;
                case "==": result = a.compareTo(b) == 0; break;
                case "!=": result = a.compareTo(b) != 0; break;
                default: throw new RuntimeException("Invalid relational op: " + opname);
            }

            $value = new TypedValue(result);
        }
      )?
    ;

addExpr returns [TypedValue value]
    : left=term { $value = $left.value; }
      ( op=('+'|'-') right=term
        {
            if ($op.getText().equals("+") &&
                ($value.kind == TypedValue.Kind.STRING || $right.value.kind == TypedValue.Kind.STRING)) {
                String a = $value.toString();
                String b = $right.value.toString();
                $value = new TypedValue(a + b);
            } else {
                if (!isNumeric($value) || !isNumeric($right.value))
                    throw new RuntimeException("Operator " + $op.getText() + " requires numeric operands");

                if ($value.kind == TypedValue.Kind.DECIMAL || $right.value.kind == TypedValue.Kind.DECIMAL) {
                    BigDecimal a = $value.asBigDecimal();
                    BigDecimal b = $right.value.asBigDecimal();
                    BigDecimal res = $op.getText().equals("+") ? a.add(b) : a.subtract(b);
                    $value = new TypedValue(res);
                } else {
                    int a = $value.intVal;
                    int b = $right.value.intVal;
                    int r = $op.getText().equals("+") ? (a + b) : (a - b);
                    $value = new TypedValue(r);
                }
            }
        }
      )*
    ;

term returns [TypedValue value]
    : left=factor { $value = $left.value; }
      ( op=('*'|'/') right=factor
        {
            if (!isNumeric($value) || !isNumeric($right.value))
                throw new RuntimeException("Operator " + $op.getText() + " requires numeric operands");

            if ($value.kind == TypedValue.Kind.DECIMAL || $right.value.kind == TypedValue.Kind.DECIMAL) {
                BigDecimal a = $value.asBigDecimal();
                BigDecimal b = $right.value.asBigDecimal();
                BigDecimal res;
                if ($op.getText().equals("*")) res = a.multiply(b);
                else res = a.divide(b, 18, java.math.RoundingMode.HALF_UP);
                $value = new TypedValue(res);
            } else {
                int a = $value.intVal;
                int b = $right.value.intVal;
                if ($op.getText().equals("*")) $value = new TypedValue(a * b);
                else {
                    if (b == 0) throw new RuntimeException("Division by zero");
                    $value = new TypedValue(a / b);
                }
            }
        }
      )*
    ;

printf_stmt
    : 'printf' '(' expr ')' ';'
      {
          System.out.println($expr.value);
      }
    ;

scanf_stmt
    : 'scanf' '(' ID ')' ';'
      {
          java.util.Scanner scanner = new java.util.Scanner(System.in);
          String name = $ID.getText();

          if (!variables.containsKey(name))
              throw new RuntimeException("Undefined variable: " + name);

          TypedValue old = variables.get(name);

          switch (old.kind) {
              case INT:
                  variables.put(name, new TypedValue(scanner.nextInt()));
                  break;
              case DECIMAL:
                  variables.put(name, new TypedValue(scanner.nextBigDecimal()));
                  break;
              case BOOL:
                  variables.put(name, new TypedValue(scanner.nextBoolean()));
                  break;
              case STRING:
                  variables.put(name, new TypedValue(scanner.nextLine()));
                  break;
          }
      }
    ;

factor returns [TypedValue value]
    : INT { $value = new TypedValue(Integer.parseInt($INT.getText())); }
    | DECIMAL { $value = new TypedValue(new BigDecimal($DECIMAL.getText())); }
    | BOOL { $value = new TypedValue(Boolean.parseBoolean($BOOL.getText())); }
    | STRING
      {
          String raw = $STRING.getText();
          String inner = raw.substring(1, raw.length() - 1);
          inner = inner
              .replace("\\n", "\n")
              .replace("\\t", "\t")
              .replace("\\\"", "\"")
              .replace("\\\\", "\\");

          $value = new TypedValue(inner);
      }
    | id=ID
      {
          String name = $id.getText();
          if (!variables.containsKey(name)) throw new RuntimeException("Undefined variable: " + name);
          $value = variables.get(name);
      }
    | '(' e=expr ')'
      { $value = $e.value; }
    ;

// types
type returns [TypeKind typeKind]
    : 'int'     { $typeKind = TypeKind.INT; }
    | 'bool'   { $typeKind = TypeKind.BOOL; }
    | 'decimal' { $typeKind = TypeKind.DECIMAL; }
    | 'string'  { $typeKind = TypeKind.STRING; }
    ;

// ----------------
// Lexer rules (order matters)
// ----------------

// punctuation / relational tokens first (ensure they're matched before ID/other)
LE: '<=';
GE: '>=';
EQ: '==';
NEQ: '!=';
LT: '<';
GT: '>';

// decimal before int so "1.5" matches DECIMAL
DECIMAL: [0-9]+ '.' [0-9]+ ;

// integers
INT: [0-9]+ ;

// boolean literal
BOOL: 'true' | 'false' ;

// string literal
STRING: '"' ( ~["\\] | '\\' . )* '"' ;

// keywords (place before ID)
IF: 'if';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
FOR: 'for';
PRINT: 'printf';
SCANF: 'scanf';

// assignment and operators
OP_ASS: '=';
PLUS: '+'; MINUS: '-'; MUL: '*'; DIV: '/' ;

// identifiers
ID: [a-zA-Z_] [a-zA-Z0-9_]* ;

// punctuation tokens (if you prefer named tokens; parser uses literal punctuation)
SEMI: ';';
COMMA: ',';

// whitespace/comments
WS: [ \t\r\n]+ -> skip ;
LINE_COMMENT: '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT: '/*' .*? '*/' -> skip ;
