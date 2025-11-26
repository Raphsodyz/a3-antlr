import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import generated.*;

public class Main {
    public static void main(String[] args) {
        // Validar os argumentos de execução
        ValidaArgumentosExecucao(args);

        //Obtem o arquivo de entrada
        String input = GetFile(args[0]);

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

    private static void ValidaArgumentosExecucao(String[] args) 
    {
        if (args.length == 0)
            System.err.println("The program's execution arguments have not been provided. You need to specify the path to the input file.");

        if (args.length > 1)
            System.err.println("The path to the input file was not specified.");
    }


    private static String GetFile(String path)
    {
        try 
        {
            String source = Files.readString(Path.of(path), StandardCharsets.UTF_8);
            return source;
        } 
        catch (Exception e) 
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}