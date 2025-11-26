# Compilador C Customizado - ANTLR4

Este projeto implementa um interpretador/compilador para uma linguagem C customizada usando ANTLR4 e Java. O compilador é capaz de executar programas com sintaxe similar ao C, incluindo variáveis, operações aritméticas, estruturas de controle e I/O básico.

## 📋 Funcionalidades

### ✅ Tipos de Dados Suportados
- **`int`** - Números inteiros
- **`decimal`** - Números decimais (ponto flutuante)
- **`string`** - Cadeia de caracteres
- - **`bool`** - Booleano true/false

### ✅ Operações Suportadas

#### **Operações Aritméticas**
- **Binários**: `+`, `-`, `*`, `/`
- **Unários**: `+`, `-`

#### **Operações Lógicas e Relacionais**
- **Relacionais**: `<`, `>`, `==`

### ✅ Estruturas de Controle
- **Condicional**: `if`/`else`
- **Loops**: `while` e `do-while`

### ✅ Entrada e Saída
- **`printf`**: Impressão de texto e variáveis
  - `printf("texto");` - Imprime string literal
  - `printf(variavel);` - Imprime valor de variável
- **`scanf`**: Leitura de dados do usuário
  - `scanf(variavel);` - Lê valor para variável

### ✅ Declaração e Atribuição de Variáveis
- **Declaração**: `tipo nome;` ou `tipo nome = valor;`
- **Atribuição**: `nome = expressão;`

### ✅ Funções
- **Função principal**: `int main() { ... }`
- **Chamadas de função**: Estrutura preparada (limitação atual: só `main` é executada)

## 🗂️ Estrutura do Projeto

```
Main.java
CCompiler.g4
|-test
|-generated
```

## 📊 Arquivos Principais

### 1. `Main.java`
- **Função**: Ponto de entrada da aplicação
- **Responsabilidades**:
  - Define o código fonte a ser executado pelo path do arquivo de test no argumento
  - Inicializa o lexer e parser ANTLR
  - Exibe a árvore de parsing (para debug)

#### **Gerenciamento de Estado**
```java
Map<String, TypedValue> memoria;    // Armazena valores das variáveis
TypedValue tipos;                   // Armazena tipos das variáveis
Scanner scanner;                    // Para entrada do usuário (scanf)
```

#### **Métodos Visitor Principais**
- **`visitProg()`**: Procura e executa a função `main()`
- **`declaration`**: Declara variáveis com valores padrão
- **`assignment`**: Realiza atribuições com cast automático
- **`printf_stmt`**: Executa `printf`\
- **`do_stmt`**: Executa o do para o do-while
- **`while_stmt` **: Executa loops
- **`if_stmt`**: Executa condicionais

#### **Sistema de Tipos e Cast**
- **Cast automático** entre tipos compatíveis
- **Coerção para boolean** em expressões condicionais
- **Tratamento de erros** para tipos incompatíveis

## 🚀 Como Executar

### **Pré-requisitos**
- Projeto testado no java openjdk 21.0.9 2025-10-21
- antlr-4.13.2-complete.jar

### **Execução**
1. Clone o repositório
2. Adicione a versão java no PATH e também o executavel do java.
3. Gere os arquivos do antlr na pasta generated com o comando: `antlr4 CCompiler.g4 -o generated -package generated`
4. Compile o projeto usando o comando: `javac Main.java`
5. Execute o programa chamando o java com o path e o arquivo desejado. Exemplo: `java Main test/TestePrecedencia.c`
6. Interaja com o programa fornecendo entradas quando solicitado

### **Exemplo de Entrada/Saída**

**Código (em `TesteJogoDoDragao.c`):**
```c
int main() {
    int i = 0;         // será o número do jogador
    decimal c = 0;     // será o "poder mágico" do jogador
    string msg = "";    // será o nome do jogador

    printf("Bem-vindo ao jogo!");
    printf("Digite seu nome: ");
    scanf(msg);

    printf("Digite um inteiro entre 1 e 5: ");
    scanf(i);

    printf("Digite seu poder mágico (decimal): ");
    scanf(c);

    printf("Olá, ");
    printf(msg);
    printf("!");

    // Aumenta o número do jogador
    i = i + 2;
    c = c * 1.5;

    // Transformando em "nível"
    while (i < 10) {
        i = i + 1;
        printf("Subindo de nível: ");
        printf(i);
        printf("");
    }

    // Reduzindo pontos de energia
    do {
        printf("Energia atual: ");
        printf(i);
        printf("");
        i = i - 1;
    } while (i > 0);

    // Desafio final baseado no poder mágico
    if (c > 5.0) {
        i = i * 2;
        printf("Parabéns, ");
        printf(msg);
        printf(", você derrotou o dragão!");
    } else {
        c = c + 3.0;
        printf("Oh não, ");
        printf(msg);
        printf(", você precisa de mais treino...");
    }

    printf("Resultado final do jogo:");
    printf("Nível final: ");
    printf(i);
    printf("Poder mágico final: ");
    printf(c);
    printf("Obrigado por jogar, ");
    printf(msg);
    printf("!");
}
```

**Execução:**
```
Bem-vindo ao jogo!
Digite seu nome: 
Arthur
Digite um inteiro entre 1 e 5: 
4
Digite seu poder mágico (decimal): 
300
Olá, 
Arthur
!
Subindo de nível: 
7

Subindo de nível: 
8

Subindo de nível: 
9

Subindo de nível: 
10

Energia atual: 
10

Energia atual: 
9

Energia atual: 
8

Energia atual: 
7

Energia atual: 
6

Energia atual: 
5

Energia atual: 
4

Energia atual: 
3

Energia atual: 
2

Energia atual: 
1

Parabéns, 
Arthur
, você derrotou o dragão!
Resultado final do jogo:
Nível final: 
0
Poder mágico final: 
450.0
Obrigado por jogar, 
Arthur
!
```

## 🔧 Características Técnicas

### **Padrão Visitor**
- Implementa o padrão **Visitor** do ANTLR4
- Cada nó da árvore sintática tem um método visitor correspondente
- Permite navegação e execução da árvore de parsing

### **Tratamento de Tipos**
- **Cast automático** inteligente entre tipos
- **Detecção de erros** de tipo em tempo de execução
- **Coerção boolean** para estruturas condicionais

### **Mensagen de erro**
- **Mensagens de erro** informativas

### **Gestão de Memória**
- **HashMap** para armazenar variáveis e seus valores
- **HashMap separado** para tipos das variáveis
- **Garbage collection** automático do Java

## ⚠️ Limitações Atuais

1. **Funções definidas pelo usuário**: Apenas `main()` é executada
2. **Arrays**: Não suportados
3. **Ponteiros**: Não suportados  
4. **Estruturas**: Não suportadas
5. **Includes/Imports**: Não suportados
6. **Escopo de variáveis**: Global apenas

## 🛠️ Possíveis Melhorias

1. **Implementar funções personalizadas** com parâmetros e retorno
2. **Adicionar suporte a arrays** e estruturas de dados
3. **Implementar escopo de variáveis** (local/global)
4. **Adicionar mais tipos** (char, float, long, etc.)
5. **Melhorar mensagens de erro** com número de linha
6. **Adicionar depurador** integrado
7. **Otimizações de performance** na interpretação

## 📝 Gramática Base

O compilador é baseado em uma gramática ANTLR4 que define:
- Estruturas de declaração e atribuição
- Expressões com precedência de operadores
- Estruturas de controle (if, while, do-while)
- Comandos de I/O (printf, scanf)
- Tipos básicos e literais

## 🏆 Conclusão

Este projeto demonstra uma implementação funcional de um interpretador para uma linguagem similar ao C, showcasing conceitos importantes de:
- **Análise sintática** com ANTLR4
- **Padrão Visitor** para interpretação
- **Gestão de tipos** e casting
- **Estruturas de controle** e avaliação de expressões
- **Tratamento de erros** robusto

O compilador é totalmente funcional dentro do escopo definido e serve como base sólida para expansões futuras.
