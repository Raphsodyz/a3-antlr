import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import generated.*;

public class Main {
    public static void main(String[] args) {
        String input = "int main() { int i = 0; do { printf(i); i = i + 1; } while (i < 3); }";

        // Criar o lexer
        CharStream charStream = CharStreams.fromString(input);
        CCompilerLexer lexer = new CCompilerLexer(charStream);

        // Criar os tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Criar o parser
        CCompilerParser parser = new CCompilerParser(tokens);

        // Iniciar o parsing na regra 'prog'
        ParseTree tree = parser.prog();

        // Imprimir a árvore
        System.out.println("Árvore de parsing:");
        System.out.println(tree.toStringTree(parser));
    }
}