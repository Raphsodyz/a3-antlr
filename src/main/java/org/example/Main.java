package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.example.generated.CCompilerLexer;
import org.example.generated.CCompilerParser;

public class Main {
    static void main(String[] args) {
        String input = """
                int main() {
                    int a = 10 * 5 + 2;
                    int b = 5;
                    int c = 20 * 20;
                    printf("valor %d"+ c);
                }
                """;

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