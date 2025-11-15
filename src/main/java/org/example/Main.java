package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) {
        String input = "int main() { int a = 10 * 5 + 2; int b = 5; int c = 20 * 20; printf(\"valor\" + \" \" + c); }";

        // Criar o lexer
        CharStream charStream = CharStreams.fromString(input);
        org.example.generated.CCompilerLexer lexer = new org.example.generated.CCompilerLexer(charStream);

        // Criar os tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Criar o parser
        org.example.generated.CCompilerParser parser = new org.example.generated.CCompilerParser(tokens);

        // Iniciar o parsing na regra 'prog'
        ParseTree tree = parser.prog();

        // Imprimir a árvore
        System.out.println("Árvore de parsing:");
        System.out.println(tree.toStringTree(parser));
    }
}