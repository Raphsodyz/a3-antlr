package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.example.generated.*;

public class Main {
     public static void main(String[] args) throws Exception {
          // Código de teste direto (ou pode ler de arquivo)
          String code = """
                  int main() {
                       // ========== TESTE DE OPERAÇÕES ARITMÉTICAS ==========
                       printf("=== OPERACOES ARITMETICAS ===");
                      \s
                       int a = 10;
                       int b = 3;
                      \s
                       printf("a = 10, b = 3");
                      \s
                       // Soma
                       int soma = a + b;
                       printf("Soma (a + b):");
                       printf(soma);
                      \s
                       // Subtração
                       int sub = a - b;
                       printf("Subtracao (a - b):");
                       printf(sub);
                      \s
                       // Multiplicação
                       int mult = a * b;
                       printf("Multiplicacao (a * b):");
                       printf(mult);
                      \s
                       // Divisão
                       int div = a / b;
                       printf("Divisao (a / b):");
                       printf(div);
                      \s
                       // Expressão composta
                       int composta = (a + b) * 2 - 5;
                       printf("Expressao (a + b) * 2 - 5:");
                       printf(composta);

                       // ========== TESTE DE IF / ELSE ==========
                       printf("");
                       printf("=== TESTE IF / ELSE ===");
                      \s
                       int x = 15;
                      \s
                       if (x > 10) {
                           printf("x > 10: VERDADEIRO");
                       } else {
                           printf("x > 10: FALSO");
                       }
                      \s
                       if (x < 10) {
                           printf("x < 10: VERDADEIRO");
                       } else {
                           printf("x < 10: FALSO");
                       }
                      \s
                       if (x == 15) {
                           printf("x == 15: VERDADEIRO");
                       }
                      \s
                       // IF com operadores lógicos
                       int y = 5;
                       if (x > 10 && y < 10) {
                           printf("x > 10 AND y < 10: VERDADEIRO");
                       }
                      \s
                       if (x < 10 || y < 10) {
                           printf("x < 10 OR y < 10: VERDADEIRO");
                       }

                       // ========== TESTE DE WHILE ==========
                       printf("");
                       printf("=== TESTE WHILE ===");
                       printf("Contando de 0 ate 4:");
                      \s
                       int i = 0;
                       while (i < 5) {
                           printf(i);
                           i = i + 1;
                       }
                      \s
                       // While com soma acumulada
                       printf("Soma de 1 a 5:");
                       int somaTotal = 0;
                       int j = 1;
                       while (j <= 5) {
                           somaTotal = somaTotal + j;
                           j = j + 1;
                       }
                       printf(somaTotal);

                       // ========== TESTE DE FOR ==========
                       printf("");
                       printf("=== TESTE FOR ===");
                       printf("Contando de 0 ate 4:");
                      \s
                       for (int k = 0; k < 5; k = k + 1) {
                           printf(k);
                       }
                      \s
                       // For com multiplicação (tabuada do 3)
                       printf("Tabuada do 3:");
                       for (int m = 1; m <= 5; m = m + 1) {
                           int resultado = 3 * m;
                           printf(resultado);
                       }

                       // ========== TESTE DO-WHILE ==========
                       printf("");
                       printf("=== TESTE DO-WHILE ===");
                       printf("Contagem regressiva de 5 ate 1:");
                      \s
                       int n = 5;
                       do {
                           printf(n);
                           n = n - 1;
                       } while (n > 0);
     
                       // Teste de scanf com int
                                 printf("\nDigite um numero inteiro:");
                                 int numero;
                                 scanf(numero);
                                 printf("Voce digitou:");
                                 printf(numero);
                                \s
                                 // Teste com operação
                                 int dobro = numero * 2;
                                 printf("O dobro e:");
                                 printf(dobro);
                                \s
                                 // Teste de scanf com string
                                 printf("");
                                 printf("Digite seu nome:");
                                 string nome;
                                 scanf(nome);
                                 printf("Ola, " + nome + "!");
                                \s
                                 // Teste condicional com input
                                 printf("");
                                 printf("Digite sua idade:");
                                 int idade;
                                 scanf(idade);
                                \s
                                 if (idade >= 18) {
                                     printf("Voce e maior de idade!");
                                 } else {
                                     printf("Voce e menor de idade!");
                                 }

                       // ========== TESTE FINAL ==========
                       printf("");
                       printf("=== TODOS OS TESTES CONCLUIDOS ===");
                   }
            """;

          // Cria o stream de caracteres
          CharStream input = CharStreams.fromString(code);

          // Cria o Lexer
          CCompilerLexer lexer = new CCompilerLexer(input);

          // Cria o stream de tokens
          CommonTokenStream tokens = new CommonTokenStream(lexer);

          // Cria o Parser
          CCompilerParser parser = new CCompilerParser(tokens);

          // Faz o parsing começando pela regra 'prog'
          ParseTree tree = parser.prog();

          // Cria o interpretador (visitor) e executa
          CCompilerInterpreter interpreter = new CCompilerInterpreter();
          interpreter.visit(tree);

          // Imprimir a árvore
          System.out.println("\nÁrvore de parsing:");
          System.out.println(tree.toStringTree(parser));

     }
}