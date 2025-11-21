package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.example.generated.CCompilerLexer;
import org.example.generated.CCompilerParser;

public class Main {
    static void main(String[] args) {
        String input = """
                int main() {
                    int a = 2;
                    int b = 3;
                    int j = 0;
                    decimal c = 0.5;
                    string msg = "Valor: ";

                    int d;
                    scanf(d);

                    printf(d);

                    int i = 0;
                    while (2 < 3) {
                        i = i + 1;
                    }

                    i = 0;
                    for (i = 0; i < 10; i = i + 1) {
                        printf(i);
                    }

                    i = 0;

                    do {
                        printf(i);
                        i = i + 1;
                    } while (i < 5);
                
                    if (a + b > 4) {
                        printf(a + b);
                    } else {
                        printf(c);
                    }
                
                    int x = a * b + 1;
                    decimal y = c + 1.5;
                    string s = msg + "teste";
                    printf(x);
                    printf(y);
                    printf(s);
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