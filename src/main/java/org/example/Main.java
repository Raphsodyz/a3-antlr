package org.example;

import compiler.CCompilerVisitorImpl;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.example.generated.CCompilerLexer;
import org.example.generated.CCompilerParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String input;
        
        if (args.length > 0) {
            input = Files.readString(Paths.get(args[0]));
        } else {
            System.out.println("Por favor, forneça o caminho do arquivo de entrada como argumento.");
            return;
        }

        CharStream charStream = CharStreams.fromString(input);
        CCompilerLexer lexer = new CCompilerLexer(charStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CCompilerParser parser = new CCompilerParser(tokens);

        ParseTree tree = parser.prog();

        CCompilerVisitorImpl executor = new CCompilerVisitorImpl();
        executor.visit(tree);
    }
}