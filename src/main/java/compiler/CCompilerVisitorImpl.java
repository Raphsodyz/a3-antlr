package compiler;

import org.example.generated.CCompilerBaseVisitor;
import org.example.generated.CCompilerParser;

import java.util.*;

public class CCompilerVisitorImpl extends CCompilerBaseVisitor<Object> {

    private final Map<String, Object> memoria = new HashMap<>();
    private final Map<String, String> tipos = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    // ============================
    // PROGRAMA (main)
    // ============================
    @Override
    public Object visitProg(CCompilerParser.ProgContext ctx) {
        // Procura por função main se houver declarações de função
        for (var f : ctx.functionDecl()) {
            if (f.ID().getText().equals("main")) {
                return visit(f.block());
            }
        }

        // Se não há função main, executa statements diretamente
        if (!ctx.functionDecl().isEmpty()) {
            throw new RuntimeException("Erro: função main() não encontrada.");
        }

        // Executa statements sequencialmente
        Object result = null;
        for (var stmt : ctx.statement()) {
            result = visit(stmt);
        }
        return result;
    }

    // ============================
    // DECLARAÇÃO DE VARIÁVEL
    // ============================
    @Override
    public Object visitVarDecl(CCompilerParser.VarDeclContext ctx) {
        String nome = ctx.ID().getText();
        String tipo = ctx.type().getText();

        tipos.put(nome, tipo);

        Object valorInicial = switch (tipo) {
            case "int" -> 0;
            case "decimal" -> 0.0;
            case "string" -> "";
            default -> null;
        };

        if (ctx.expression() != null) {
            Object raw = visit(ctx.expression());
            valorInicial = cast(valorInicial, raw, tipo);
        }

        memoria.put(nome, valorInicial);
        return null;
    }

    // ============================
    // ATRIBUIÇÃO
    // ============================
    @Override
    public Object visitAssignment(CCompilerParser.AssignmentContext ctx) {
        String nome = ctx.ID().getText();

        if (!tipos.containsKey(nome))
            throw new RuntimeException("Variável não declarada: " + nome);

        String tipo = tipos.get(nome);
        Object raw = visit(ctx.expression());
        Object castValue = cast(memoria.get(nome), raw, tipo);
        
        memoria.put(nome, castValue);
        return null;
    }

    // ============================
    // IO (PRINTF / SCANF)
    // ============================
    @Override
    public Object visitIoStmt(CCompilerParser.IoStmtContext ctx) {

        // ---------- PRINTF ----------
        if (ctx.PRINTF() != null) {
            var pArgs = ctx.printfArgs();

            // Caso: printf("texto", expr1, expr2, ...)
            if (pArgs.STRING_LITERAL() != null) {
                String raw = pArgs.STRING_LITERAL().getText();
                String cleaned = raw.substring(1, raw.length() - 1);
                System.out.print(cleaned);

                // imprime as expressões adicionais, se houver
                for (var expr : pArgs.expression()) {
                    Object v = visit(expr);
                    System.out.print(" " + v);
                }
                System.out.println();
                return null;
            }

            // Caso: printf(expr) ou printf(expr1, expr2, ...)
            if (!pArgs.expression().isEmpty()) {
                boolean first = true;
                for (var expr : pArgs.expression()) {
                    Object v = visit(expr);
                    if (!first) System.out.print(" ");
                    System.out.print(v);
                    first = false;
                }
                System.out.println();
                return null;
            }

            return null;
        }

        // ---------- SCANF ----------
        if (ctx.SCANF() != null) {
            // sua gramática aceita SCANF LPAREN ID RPAREN SEMI
            String var = ctx.addressable().ID().getText();

            if (!tipos.containsKey(var))
                throw new RuntimeException("Variável não declarada: " + var);

            String tipo = tipos.get(var);

            // ler linha não-vazia (protege contra ENTERs sobrando)
            String entrada;
            do {
                if (!scanner.hasNextLine()) throw new RuntimeException("Entrada encerrada inesperadamente");
                entrada = scanner.nextLine();
            } while (entrada.trim().isEmpty());

            entrada = entrada.trim();

            try {
                switch (tipo) {
                    case "int" -> {
                        int valor = Integer.parseInt(entrada);
                        memoria.put(var, valor);
                    }
                    case "decimal" -> {
                        double valor = Double.parseDouble(entrada.replace(",", "."));
                        memoria.put(var, valor);
                    }
                    case "string" -> {
                        memoria.put(var, entrada);
                    }
                    default -> throw new RuntimeException("Tipo não suportado no scanf: " + tipo);
                }
            } catch (NumberFormatException nfe) {
                throw new RuntimeException("Entrada inválida para variável " + var + " (" + tipo + "): '" + entrada + "'");
            }

            return null;
        }

        throw new RuntimeException("Comando IO desconhecido.");
    }

    // ============================
    // TIPAGEM E CAST AUTOMÁTICO
    // ============================
    // oldValue é usado apenas para inferência/decisão, pode ser null
    private Object cast(Object oldValue, Object newValue, String tipo) {
        if (newValue == null) {
            // valor nulo -> mantém default conforme tipo
            return switch (tipo) {
                case "int" -> 0;
                case "decimal" -> 0.0;
                case "string" -> "";
                default -> null;
            };
        }

        switch (tipo) {
            case "int" -> {
                // se já for número
                if (newValue instanceof Number n) return n.intValue();
                // se for booleano
                if (newValue instanceof Boolean b) return b ? 1 : 0;
                // se for string numérica (inteira)
                if (newValue instanceof String s) {
                    String t = s.trim();
                    // permitir inteiros como "42"
                    if (t.matches("^-?\\d+$")) return Integer.parseInt(t);
                    // permitir decimais convertendo via truncamento
                    if (t.matches("^-?\\d+[.,]\\d+$")) {
                        t = t.replace(',', '.');
                        double dd = Double.parseDouble(t);
                        return (int) dd;
                    }
                }
                throw new RuntimeException("Valor inválido para int: " + newValue);
            }
            case "decimal" -> {
                if (newValue instanceof Number n) return n.doubleValue();
                if (newValue instanceof Boolean b) return b ? 1.0 : 0.0;
                if (newValue instanceof String s) {
                    String t = s.trim().replace(',', '.');
                    if (t.matches("^-?\\d+(\\.\\d+)?$")) return Double.parseDouble(t);
                }
                throw new RuntimeException("Valor inválido para decimal: " + newValue);
            }
            case "string" -> {
                return String.valueOf(newValue);
            }
            default -> throw new RuntimeException("Tipo desconhecido: " + tipo);
        }
    }

    // ============================
    // CONTROLE DE FLUXO
    // ============================

    @Override
    public Object visitIfStmt(CCompilerParser.IfStmtContext ctx) {
        boolean cond = toBoolean(visit(ctx.expression()));
        if (cond) visit(ctx.block(0));
        else if (ctx.block().size() > 1) visit(ctx.block(1));
        return null;
    }

    @Override
    public Object visitWhileStmt(CCompilerParser.WhileStmtContext ctx) {
        int maxIterations = 1_000_000;
        int iterations = 0;

        while (toBoolean(visit(ctx.expression()))) {
            visit(ctx.block());
            iterations++;

            if (iterations >= maxIterations) {
                throw new RuntimeException("Loop infinito detectado! Mais de " + maxIterations + " iterações. " +
                        "Verifique se a variável da condição está sendo modificada dentro do loop!");
            }
        }
        return null;
    }

    @Override
    public Object visitDoWhileStmt(CCompilerParser.DoWhileStmtContext ctx) {
        int maxIterations = 10_000; // Reduzido para detectar mais rápido
        int iterations = 0;

        do {
            visit(ctx.block());
            iterations++;

            if (iterations >= maxIterations) {
                Object conditionValue = visit(ctx.expression());
                throw new RuntimeException("Loop infinito detectado! " +
                        "Do-while executou " + maxIterations + " vezes. " +
                        "Última condição avaliada: " + conditionValue + " (" + conditionValue.getClass().getSimpleName() + ")");
            }

            // Debug a cada 1000 iterações
            if (iterations % 1000 == 0) {
                Object conditionValue = visit(ctx.expression());
                System.err.println("WARNING: Do-while loop executou " + iterations + " vezes. Condição: " + conditionValue);
                // Reverte a avaliação da condição que acabamos de fazer
                iterations++; // compensa a próxima avaliação
            }

        } while (toBoolean(visit(ctx.expression())));

        return null;
    }

    // ============================
    // BLOCOS E LISTAS DE STATEMENTS
    // ============================

    @Override
    public Object visitBlock(CCompilerParser.BlockContext ctx) {
        return visit(ctx.statementList());
    }

    @Override
    public Object visitStatementList(CCompilerParser.StatementListContext ctx) {
        Object result = null;
        for (var stmt : ctx.statement()) {
            result = visit(stmt);
        }
        return result;
    }

    // ============================
    // EXPRESSÕES
    // ============================

    @Override
    public Object visitExprStmt(CCompilerParser.ExprStmtContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitPrimary(CCompilerParser.PrimaryContext ctx) {
        if (ctx.ID() != null) {
            // retorna valor declarado ou valor default conforme tipo
            String name = ctx.ID().getText();
            if (!memoria.containsKey(name)) {
                // se não declarado na memória, mantemos comportamento anterior: 0/0.0/""
                String tipo = tipos.get(name);
                return switch (tipo) {
                    case "int" -> 0;
                    case "decimal" -> 0.0;
                    case "string" -> "";
                    default -> null;
                };
            }
            return memoria.get(name);
        }

        if (ctx.literal() != null) return visit(ctx.literal());

        // parênteses, expressão ou chamada de função
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }

        if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        }

        return null;
    }

    @Override
    public Object visitFunctionCall(CCompilerParser.FunctionCallContext ctx) {
        String funcName = ctx.ID().getText();
        // Por enquanto, apenas lança erro pois não temos implementação de funções definidas pelo usuário
        throw new RuntimeException("Chamada de função não suportada: " + funcName + "()");
    }

    @Override
    public Object visitLiteral(CCompilerParser.LiteralContext ctx) {
        if (ctx.INT_LITERAL() != null) return Integer.parseInt(ctx.INT_LITERAL().getText());
        if (ctx.DECIMAL_LITERAL() != null) return Double.parseDouble(ctx.DECIMAL_LITERAL().getText());
        if (ctx.STRING_LITERAL() != null) return ctx.STRING_LITERAL().getText().replace("\"", "");
        return null;
    }

    // multiplicativo (* /)
    @Override
    public Object visitMultiplicative(CCompilerParser.MultiplicativeContext ctx) {
        Object left = visit(ctx.unary(0));

        // Se há apenas um unary, retorna diretamente
        if (ctx.unary().size() == 1) {
            return left;
        }

        for (int i = 1; i < ctx.unary().size(); i++) {
            Object right = visit(ctx.unary(i));
            String op = ctx.getChild(2 * i - 1).getText();

            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();

            left = switch (op) {
                case "*" -> l * r;
                case "/" -> l / r;
                default -> left;
            };
        }

        return left;
    }

    // unário (+, -, !)
    @Override
    public Object visitUnary(CCompilerParser.UnaryContext ctx) {
        if (ctx.primary() != null) {
            return visit(ctx.primary());
        }

        // operador unário + expressão
        String op = ctx.getChild(0).getText();
        Object value = visit(ctx.unary());

        switch (op) {
            case "+" -> {
                if (value instanceof Number n) return n;
                throw new RuntimeException("Operador + unário aplicado a não-número: " + value);
            }
            case "-" -> {
                if (value instanceof Number n) return -n.doubleValue();
                throw new RuntimeException("Operador - unário aplicado a não-número: " + value);
            }
            case "!" -> {
                return !toBoolean(value);
            }
            default -> throw new RuntimeException("Operador unário desconhecido: " + op);
        }
    }

    // aditivo (+ -)
    @Override
    public Object visitAdditive(CCompilerParser.AdditiveContext ctx) {
        Object left = visit(ctx.multiplicative(0));

        // Se há apenas um multiplicative, retorna diretamente
        if (ctx.multiplicative().size() == 1) {
            return left;
        }

        for (int i = 1; i < ctx.multiplicative().size(); i++) {
            Object right = visit(ctx.multiplicative(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (left instanceof String || right instanceof String) {
                left = String.valueOf(left) + String.valueOf(right);
                continue;
            }

            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();

            left = switch (op) {
                case "+" -> l + r;
                case "-" -> l - r;
                default -> left;
            };
        }

        return left;
    }

    // relacional (< > <= >=)
    @Override
    public Object visitRelational(CCompilerParser.RelationalContext ctx) {
        Object left = visit(ctx.additive(0));

        // Se há apenas um additive, retorna diretamente
        if (ctx.additive().size() == 1) {
            return left;
        }

        for (int i = 1; i < ctx.additive().size(); i++) {
            Object right = visit(ctx.additive(i));
            String op = ctx.getChild(2 * i - 1).getText();

            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();

            left = switch (op) {
                case "<" -> l < r;
                case ">" -> l > r;
                case "<=" -> l <= r;
                case ">=" -> l >= r;
                default -> left;
            };
        }

        return left;
    }

    // igualdade (== !=)
    @Override
    public Object visitEquality(CCompilerParser.EqualityContext ctx) {
        Object left = visit(ctx.relational(0));

        // Se há apenas um relational, retorna diretamente
        if (ctx.relational().size() == 1) {
            return left;
        }

        for (int i = 1; i < ctx.relational().size(); i++) {
            Object right = visit(ctx.relational(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (op.equals("==")) return Objects.equals(left, right);
            if (op.equals("!=")) return !Objects.equals(left, right);
        }

        return left;
    }

    // lógico AND (&&)
    @Override
    public Object visitLogicalAnd(CCompilerParser.LogicalAndContext ctx) {
        boolean result = toBoolean(visit(ctx.equality(0)));

        // Se há apenas um equality, retorna o valor original (não boolean)
        if (ctx.equality().size() == 1) {
            return visit(ctx.equality(0));
        }

        for (int i = 1; i < ctx.equality().size(); i++) {
            if (!result) return false;
            result = result && toBoolean(visit(ctx.equality(i)));
        }

        return result;
    }

    // lógico OR (||)
    @Override
    public Object visitLogicalOr(CCompilerParser.LogicalOrContext ctx) {
        boolean result = toBoolean(visit(ctx.logicalAnd(0)));

        // Se há apenas um logicalAnd, retorna o valor original
        if (ctx.logicalAnd().size() == 1) {
            return visit(ctx.logicalAnd(0));
        }

        for (int i = 1; i < ctx.logicalAnd().size(); i++) {
            if (result) return true;
            result = result || toBoolean(visit(ctx.logicalAnd(i)));
        }

        return result;
    }

    // ============================
    // UTIL: coercion para boolean
    // ============================
    private boolean toBoolean(Object v) {
        if (v instanceof Boolean b) return b;
        if (v instanceof Integer i) return i != 0;
        if (v instanceof Double d) return d != 0.0;
        if (v instanceof String s) return !s.isEmpty();
        return false;
    }
}
