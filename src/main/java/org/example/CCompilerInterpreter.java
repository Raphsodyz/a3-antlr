package org.example;

import org.example.generated.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CCompilerInterpreter extends CCompilerBaseVisitor<TypedValue> {

    // Pilha de escopos (cada escopo é um mapa de variáveis)
    private final Deque<Map<String, TypedValue>> scopes = new ArrayDeque<>();
    private final Scanner scanner = new Scanner(System.in);

    public CCompilerInterpreter() {
        // Cria o escopo global
        scopes.push(new HashMap<>());
    }

    // ========== MÉTODOS DE ESCOPO ==========

    private void enterScope() {
        scopes.push(new HashMap<>());
    }

    private void exitScope() {
        scopes.pop();
    }

    private void declareVariable(String name, TypedValue value) {
        // Verifica apenas no escopo atual (permite shadowing)
        if (scopes.peek().containsKey(name)) {
            throw new RuntimeException("Variável já declarada neste escopo: " + name);
        }
        scopes.peek().put(name, value);
    }

    private TypedValue getVariable(String name) {
        // Procura do escopo mais interno para o mais externo
        for (Map<String, TypedValue> scope : scopes) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        throw new RuntimeException("Variável não definida: " + name);
    }

    private void setVariable(String name, TypedValue value) {
        // Procura e atualiza no escopo onde a variável foi declarada
        for (Map<String, TypedValue> scope : scopes) {
            if (scope.containsKey(name)) {
                scope.put(name, value);
                return;
            }
        }
        throw new RuntimeException("Variável não definida: " + name);
    }

    private boolean variableExists(String name) {
        for (Map<String, TypedValue> scope : scopes) {
            if (scope.containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    // ==================== PROGRAMA ====================

    @Override
    public TypedValue visitProg(CCompilerParser.ProgContext ctx) {
        return visit(ctx.main_function());
    }

    @Override
    public TypedValue visitMain_function(CCompilerParser.Main_functionContext ctx) {
        return visit(ctx.function_body());
    }

    @Override
    public TypedValue visitFunction_body(CCompilerParser.Function_bodyContext ctx) {
        for (CCompilerParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        return null;
    }

    // ==================== STATEMENTS ====================

    @Override
    public TypedValue visitBlock(CCompilerParser.BlockContext ctx) {
        enterScope();
        for (CCompilerParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        exitScope();
        return null;
    }

    // ========== IF ==========
    @Override
    public TypedValue visitIfStatement(CCompilerParser.IfStatementContext ctx) {
        TypedValue condition = visit(ctx.condition);

        if (condition.kind != TypedValue.Kind.BOOL) {
            throw new RuntimeException("Condição do IF deve ser booleana, mas recebeu: " + condition.kind);
        }

        if (condition.boolVal) {
            visit(ctx.thenBranch);
        } else if (ctx.elseBranch != null) {
            visit(ctx.elseBranch);
        }

        return null;
    }

    // ========== WHILE ==========
    @Override
    public TypedValue visitWhileStatement(CCompilerParser.WhileStatementContext ctx) {
        while (true) {
            TypedValue condition = visit(ctx.condition);

            if (condition.kind != TypedValue.Kind.BOOL) {
                throw new RuntimeException("Condição do WHILE deve ser booleana");
            }

            if (!condition.boolVal) break;

            visit(ctx.body);
        }
        return null;
    }

    // ========== DO-WHILE ==========
    @Override
    public TypedValue visitDoWhileStatement(CCompilerParser.DoWhileStatementContext ctx) {
        do {
            visit(ctx.body);

            TypedValue condition = visit(ctx.condition);
            if (condition.kind != TypedValue.Kind.BOOL) {
                throw new RuntimeException("Condição do DO-WHILE deve ser booleana");
            }

            if (!condition.boolVal) break;
        } while (true);

        return null;
    }

    // ========== FOR ==========
    @Override
    public TypedValue visitForStatement(CCompilerParser.ForStatementContext ctx) {
        // Cria escopo para o FOR (variáveis do init ficam neste escopo)
        enterScope();

        // Inicialização
        if (ctx.init != null) {
            visit(ctx.init);
        }

        while (true) {
            // Condição (se não tiver, é true)
            if (ctx.condition != null) {
                TypedValue cond = visit(ctx.condition);
                if (cond.kind != TypedValue.Kind.BOOL) {
                    throw new RuntimeException("Condição do FOR deve ser booleana");
                }
                if (!cond.boolVal) break;
            }

            // Corpo (com seu próprio escopo se for bloco)
            visit(ctx.body);

            // Update
            if (ctx.update != null) {
                visit(ctx.update);
            }
        }

        exitScope();
        return null;
    }

    // ==================== DECLARAÇÃO E ATRIBUIÇÃO ====================

    @Override
    public TypedValue visitDeclaration(CCompilerParser.DeclarationContext ctx) {
        String name = ctx.ID().getText();
        String typeName = ctx.type().getText();

        TypedValue val;
        if (ctx.expr() != null) {
            val = visit(ctx.expr());
            // Conversão int -> decimal se necessário
            if (typeName.equals("decimal") && val.kind == TypedValue.Kind.INT) {
                val = new TypedValue(val.asBigDecimal());
            }
        } else {
            // Valores padrão
            switch (typeName) {
                case "int": val = new TypedValue(0); break;
                case "bool": val = new TypedValue(false); break;
                case "decimal": val = new TypedValue(BigDecimal.ZERO); break;
                case "string": val = new TypedValue(""); break;
                default: throw new RuntimeException("Tipo desconhecido: " + typeName);
            }
        }

        declareVariable(name, val);
        return val;
    }

    @Override
    public TypedValue visitAssignment(CCompilerParser.AssignmentContext ctx) {
        String name = ctx.ID().getText();
        TypedValue val = visit(ctx.expr());
        TypedValue old = getVariable(name);

        // Conversão int -> decimal
        if (old.kind == TypedValue.Kind.DECIMAL && val.kind == TypedValue.Kind.INT) {
            val = new TypedValue(val.asBigDecimal());
        }

        setVariable(name, val);
        return val;
    }

    @Override
    public TypedValue visitSimpleAssignment(CCompilerParser.SimpleAssignmentContext ctx) {
        String name = ctx.ID().getText();
        TypedValue val = visit(ctx.expr());
        setVariable(name, val);
        return val;
    }

    // ==================== PRINTF / SCANF ====================

    @Override
    public TypedValue visitPrintfStmt(CCompilerParser.PrintfStmtContext ctx) {
        TypedValue val = visit(ctx.expr());
        System.out.println(val);
        return null;
    }

    @Override
    public TypedValue visitScanfStmt(CCompilerParser.ScanfStmtContext ctx) {
        String name = ctx.ID().getText();
        TypedValue old = getVariable(name);
        TypedValue newVal;

        switch (old.kind) {
            case INT:
                newVal = new TypedValue(scanner.nextInt());
                scanner.nextLine(); // Limpa o \n restante
                break;
            case DECIMAL:
                newVal = new TypedValue(scanner.nextBigDecimal());
                scanner.nextLine(); // Limpa o \n restante
                break;
            case BOOL:
                newVal = new TypedValue(scanner.nextBoolean());
                scanner.nextLine(); // Limpa o \n restante
                break;
            case STRING:
                newVal = new TypedValue(scanner.nextLine());
                break;
            default:
                throw new RuntimeException("Tipo desconhecido");
        }

        setVariable(name, newVal);
        return null;
    }

    // ==================== EXPRESSÕES ====================

    @Override
    public TypedValue visitExpr(CCompilerParser.ExprContext ctx) {
        return visit(ctx.orExpr());
    }

    @Override
    public TypedValue visitOrExpr(CCompilerParser.OrExprContext ctx) {
        TypedValue result = visit(ctx.andExpr(0));

        for (int i = 1; i < ctx.andExpr().size(); i++) {
            if (result.kind != TypedValue.Kind.BOOL) {
                throw new RuntimeException("Operador || requer operandos booleanos");
            }
            // Short-circuit
            if (result.boolVal) return result;

            TypedValue right = visit(ctx.andExpr(i));
            if (right.kind != TypedValue.Kind.BOOL) {
                throw new RuntimeException("Operador || requer operandos booleanos");
            }
            result = new TypedValue(result.boolVal || right.boolVal);
        }

        return result;
    }

    @Override
    public TypedValue visitAndExpr(CCompilerParser.AndExprContext ctx) {
        TypedValue result = visit(ctx.relExpr(0));

        for (int i = 1; i < ctx.relExpr().size(); i++) {
            if (result.kind != TypedValue.Kind.BOOL) {
                throw new RuntimeException("Operador && requer operandos booleanos");
            }
            // Short-circuit
            if (!result.boolVal) return result;

            TypedValue right = visit(ctx.relExpr(i));
            if (right.kind != TypedValue.Kind.BOOL) {
                throw new RuntimeException("Operador && requer operandos booleanos");
            }
            result = new TypedValue(result.boolVal && right.boolVal);
        }

        return result;
    }

    @Override
    public TypedValue visitRelExpr(CCompilerParser.RelExprContext ctx) {
        TypedValue left = visit(ctx.addExpr(0));

        if (ctx.addExpr().size() == 1) {
            return left;
        }

        TypedValue right = visit(ctx.addExpr(1));
        String op = ctx.getChild(1).getText();

        if (!left.isNumeric() || !right.isNumeric()) {
            throw new RuntimeException("Operadores relacionais requerem operandos numéricos");
        }

        BigDecimal a = left.asBigDecimal();
        BigDecimal b = right.asBigDecimal();
        int cmp = a.compareTo(b);

        boolean result;
        switch (op) {
            case "<":  result = cmp < 0; break;
            case ">":  result = cmp > 0; break;
            case "<=": result = cmp <= 0; break;
            case ">=": result = cmp >= 0; break;
            case "==": result = cmp == 0; break;
            case "!=": result = cmp != 0; break;
            default: throw new RuntimeException("Operador inválido: " + op);
        }

        return new TypedValue(result);
    }

    @Override
    public TypedValue visitAddExpr(CCompilerParser.AddExprContext ctx) {
        TypedValue result = visit(ctx.term(0));

        for (int i = 1; i < ctx.term().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            TypedValue right = visit(ctx.term(i));

            if (op.equals("+") && (result.kind == TypedValue.Kind.STRING || right.kind == TypedValue.Kind.STRING)) {
                result = new TypedValue(result.toString() + right.toString());
            } else {
                if (!result.isNumeric() || !right.isNumeric()) {
                    throw new RuntimeException("Operador " + op + " requer operandos numéricos");
                }

                if (result.kind == TypedValue.Kind.INT && right.kind == TypedValue.Kind.INT) {
                    int r = op.equals("+") ? result.intVal + right.intVal : result.intVal - right.intVal;
                    result = new TypedValue(r);
                } else {
                    BigDecimal a = result.asBigDecimal();
                    BigDecimal b = right.asBigDecimal();
                    BigDecimal r = op.equals("+") ? a.add(b) : a.subtract(b);
                    result = new TypedValue(r);
                }
            }
        }

        return result;
    }

    @Override
    public TypedValue visitTerm(CCompilerParser.TermContext ctx) {
        TypedValue result = visit(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            TypedValue right = visit(ctx.factor(i));

            if (!result.isNumeric() || !right.isNumeric()) {
                throw new RuntimeException("Operador " + op + " requer operandos numéricos");
            }

            if (result.kind == TypedValue.Kind.INT && right.kind == TypedValue.Kind.INT) {
                if (op.equals("*")) {
                    result = new TypedValue(result.intVal * right.intVal);
                } else {
                    if (right.intVal == 0) throw new RuntimeException("Divisão por zero");
                    result = new TypedValue(result.intVal / right.intVal);
                }
            } else {
                BigDecimal a = result.asBigDecimal();
                BigDecimal b = right.asBigDecimal();
                if (op.equals("*")) {
                    result = new TypedValue(a.multiply(b));
                } else {
                    result = new TypedValue(a.divide(b, 18, RoundingMode.HALF_UP));
                }
            }
        }

        return result;
    }

    // ==================== FACTOR ====================

    @Override
    public TypedValue visitFactor(CCompilerParser.FactorContext ctx) {
        if (ctx.INT() != null) {
            return new TypedValue(Integer.parseInt(ctx.INT().getText()));
        }
        if (ctx.DECIMAL() != null) {
            return new TypedValue(new BigDecimal(ctx.DECIMAL().getText()));
        }
        if (ctx.BOOL() != null) {
            return new TypedValue(Boolean.parseBoolean(ctx.BOOL().getText()));
        }
        if (ctx.STRING() != null) {
            String raw = ctx.STRING().getText();
            String inner = raw.substring(1, raw.length() - 1)
                    .replace("\\n", "\n")
                    .replace("\\t", "\t")
                    .replace("\\\"", "\"")
                    .replace("\\\\", "\\");
            return new TypedValue(inner);
        }
        if (ctx.ID() != null) {
            String name = ctx.ID().getText();
            return getVariable(name);
        }
        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }
        if (ctx.factor() != null) {
            String op = ctx.getChild(0).getText();
            TypedValue val = visit(ctx.factor());

            if (op.equals("-")) {
                if (!val.isNumeric()) {
                    throw new RuntimeException("Operador - requer operando numérico");
                }
                if (val.kind == TypedValue.Kind.INT) {
                    return new TypedValue(-val.intVal);
                } else {
                    return new TypedValue(val.decVal.negate());
                }
            } else if (op.equals("!")) {
                if (val.kind != TypedValue.Kind.BOOL) {
                    throw new RuntimeException("Operador ! requer operando booleano");
                }
                return new TypedValue(!val.boolVal);
            }
        }

        throw new RuntimeException("Factor não reconhecido: " + ctx.getText());
    }
}