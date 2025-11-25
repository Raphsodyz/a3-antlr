grammar CCompiler;

// -------------------------------
// PROGRAMA
// -------------------------------
prog
    : (functionDecl | statement)+ EOF   // pelo menos uma unidade
    ;

// -------------------------------
// DECLARAÇÃO DE FUNÇÃO
// -------------------------------
functionDecl
    : type ID '(' ')' block
    ;

// -------------------------------
// STATEMENTS
// -------------------------------
statement
    : varDecl
    | assignment
    | ifStmt
    | whileStmt
    | doWhileStmt
    | ioStmt
    | exprStmt
    | block
    | SEMI                           // statement vazio explícito
    ;

// bloco NÃO pode ser vazio (impede produção vazia)
block
    : LBRACE statementList RBRACE
    ;

statementList
    : statement statement*
    ;

// -------------------------------
// DECLARAÇÕES
// -------------------------------
varDecl
    : type ID '=' expression SEMI
    | type ID SEMI
    ;

type
    : INT_TYPE
    | DEC_TYPE
    | STR_TYPE
    ;

// -------------------------------
// ATRIBUIÇÃO
// -------------------------------
assignment
    : ID '=' expression SEMI
    ;

// -------------------------------
// IF / WHILE / DO-WHILE
// -------------------------------
ifStmt
    : IF LPAREN expression RPAREN block ELSE block
    | IF LPAREN expression RPAREN block              // sem else
    ;

whileStmt
    : WHILE LPAREN expression RPAREN block
    ;

doWhileStmt
    : DO block WHILE LPAREN expression RPAREN SEMI
    ;

// -------------------------------
// I/O
// -------------------------------
ioStmt
    : SCANF LPAREN addressable RPAREN SEMI
    | PRINTF LPAREN printfArgs RPAREN SEMI
    ;

printfArgs
    : STRING_LITERAL (COMMA expression)*
    | expression
    ;

addressableList
    : addressable (COMMA addressable)*
    ;

addressable
    : ID
    ;

// -------------------------------
// EXPRESSÕES
// -------------------------------
exprStmt
    : expression SEMI
    ;

expression
    : logicalOr
    ;

logicalOr
    : logicalAnd (OR logicalAnd)*
    ;

logicalAnd
    : equality (AND equality)*
    ;

equality
    : relational ((EQ | NEQ) relational)*
    ;

relational
    : additive ((LT | GT | LE | GE) additive)*
    ;

additive
    : multiplicative ((PLUS | MINUS) multiplicative)*
    ;

multiplicative
    : unary ((MUL | DIV) unary)*
    ;

unary
    : (PLUS | MINUS | NOT) unary
    | primary
    ;

primary
    : literal
    | ID
    | LPAREN expression RPAREN
    | functionCall
    ;

functionCall
    : ID LPAREN (expression (COMMA expression)*)? RPAREN
    ;

// -------------------------------
// LITERAIS
// -------------------------------
literal
    : INT_LITERAL
    | DECIMAL_LITERAL
    | STRING_LITERAL
    ;

// -------------------------------
// TOKENS
// -------------------------------
IF      : 'if';
ELSE    : 'else';
WHILE   : 'while';
DO      : 'do';
SCANF   : 'scanf';
PRINTF  : 'printf';

INT_TYPE    : 'int';
DEC_TYPE    : 'decimal';
STR_TYPE    : 'string';

PLUS    : '+';
MINUS   : '-';
MUL     : '*';
DIV     : '/';
NOT     : '!';

OR      : '||';
AND     : '&&';
EQ      : '==';
NEQ     : '!=';
LT      : '<';
GT      : '>';
LE      : '<=';
GE      : '>=';

ASSIGN  : '=';
SEMI    : ';';
COMMA   : ',';
LPAREN  : '(';
RPAREN  : ')';
LBRACE  : '{';
RBRACE  : '}';
AMP     : '&';

ID
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

INT_LITERAL
    : [0-9]+
    ;

DECIMAL_LITERAL
    : [0-9]+ '.' [0-9]+
    ;

STRING_LITERAL
    : '"' ( '\\' . | ~["\\] )* '"'
    ;

// -------------------------------
// IGNORAR ESPAÇOS
// -------------------------------
WS : [ \t\r\n]+ -> skip ;
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
