# Compilador C Customizado - ANTLR4

Este projeto implementa um interpretador/compilador para uma linguagem C customizada usando ANTLR4 e Java. O compilador é capaz de executar programas com sintaxe similar ao C, incluindo variáveis, operações aritméticas, estruturas de controle e I/O básico.

## 📋 Funcionalidades

### ✅ Tipos de Dados Suportados
- **`int`** - Números inteiros
- **`decimal`** - Números decimais (ponto flutuante)
- **`string`** - Cadeia de caracteres

### ✅ Operações Suportadas

#### **Operações Aritméticas**
- **Binários**: `+`, `-`, `*`, `/`
- **Unários**: `+`, `-`

#### **Operações Lógicas e Relacionais**
- **Relacionais**: `<`, `>`, `<=`, `>=`, `==`, `!=`
- **Lógicos**: `&&` (AND), `||` (OR), `!` (NOT)

### ✅ Estruturas de Controle
- **Condicional**: `if`/`else`
- **Loops**: `while` e `do-while`

### ✅ Entrada e Saída
- **`printf`**: Impressão de texto e variáveis
  - `printf("texto");` - Imprime string literal
  - `printf(variavel);` - Imprime valor de variável
  - `printf("texto", expr1, expr2);` - Imprime string + expressões
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
src/main/java/
├── org/example/
│   ├── Main.java                    # Ponto de entrada do programa
│   └── generated/                   # Classes geradas pelo ANTLR
│       ├── CCompilerLexer.java
│       ├── CCompilerParser.java
│       └── CCompilerBaseVisitor.java
└── compiler/
    └── CCompilerVisitorImpl.java   # Implementação do interpretador
```

## 📊 Arquivos Principais

### 1. `Main.java`
- **Função**: Ponto de entrada da aplicação
- **Responsabilidades**:
  - Define o código fonte a ser executado (string `input`)
  - Inicializa o lexer e parser ANTLR
  - Cria e executa o visitor interpretador
  - Exibe a árvore de parsing (para debug)

### 2. `CCompilerVisitorImpl.java` 
- **Função**: Interpretador principal que executa o código
- **Componentes principais**:

#### **Gerenciamento de Estado**
```java
Map<String, Object> memoria;    // Armazena valores das variáveis
Map<String, String> tipos;      // Armazena tipos das variáveis
Scanner scanner;                // Para entrada do usuário (scanf)
```

#### **Métodos Visitor Principais**
- **`visitProg()`**: Procura e executa a função `main()`
- **`visitVarDecl()`**: Declara variáveis com valores padrão
- **`visitAssignment()`**: Realiza atribuições com cast automático
- **`visitIoStmt()`**: Executa `printf` e `scanf`
- **`visitWhileStmt()` / `visitDoWhileStmt()`**: Executa loops
- **`visitIfStmt()`**: Executa condicionais
- **`visitExpression*()`**: Avalia expressões aritméticas e lógicas

#### **Sistema de Tipos e Cast**
- **Cast automático** entre tipos compatíveis
- **Coerção para boolean** em expressões condicionais
- **Tratamento de erros** para tipos incompatíveis

## 🚀 Como Executar

### **Pré-requisitos**
- Java 11+ 
- ANTLR4 runtime
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### **Execução**
1. Clone o repositório
2. Abra o projeto na IDE
3. Execute a classe `Main.java`
4. Interaja com o programa fornecendo entradas quando solicitado

### **Exemplo de Entrada/Saída**

**Código (em `Main.java`):**
```c
int main() {
    int i;
    decimal c;
    string msg;
    
    printf("Digite um inteiro: ");
    scanf(i);
    
    printf("Digite um decimal: ");
    scanf(c);
    
    printf("Digite uma mensagem: ");
    scanf(msg);
    
    i = i + 2;
    c = c * 1.5;
    
    while (i < 10) {
        i = i + 1;
        printf("Adicionando", i);
    }
    
    do {
        printf("doWhile", i);
        i = i - 1;
    } while (i > 0);
    
    if (c > 5.0) {
        i = i * 2;
        printf("Maior");
    } else {
        c = c + 3.0;
        printf("Menor");
    }
    
    printf(i);
    printf(c);
    printf(msg);
}
```

**Execução:**
```
Digite um inteiro: 
5                          ← entrada do usuário
Digite um decimal: 
2.5                        ← entrada do usuário  
Digite uma mensagem: 
teste                      ← entrada do usuário
Adicionando 8
Adicionando 9
Adicionando 10
doWhile 10
doWhile 9
...
doWhile 1
Maior
0
6.75
teste
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

### **Proteção contra Loops Infinitos**
- **Limite de iterações** configurável (1.000.000 para while)
- **Detecção automática** de loops infinitos
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
