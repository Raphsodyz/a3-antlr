grammar CCompiler;

// ----------------
// Parser rules (sem ações - apenas estrutura)
// ----------------

prog: main_function function* EOF;

main_function: type 'main' '(' ')' '{' function_body '}' ;
function: type ID '(' ')' '{' function_body '}' ;

function_body: statement* ;

statement
    : ifStatement
    | whileStatement
    | doWhileStatement
    | forStatement
    | block
    | declaration ';'
    | assignment ';'
    | printfStmt
    | scanfStmt
    | expr ';'
    | ';'
    ;

block: '{' statement* '}' ;

ifStatement
    : 'if' '(' condition=expr ')' thenBranch=statement ('else' elseBranch=statement)?
    ;

whileStatement
    : 'while' '(' condition=expr ')' body=statement
    ;

doWhileStatement
    : 'do' body=statement 'while' '(' condition=expr ')' ';'
    ;

forStatement
    : 'for' '(' init=forInit? ';' condition=expr? ';' update=forUpdate? ')' body=statement
    ;

forInit
    : declaration
    | simpleAssignment
    ;

forUpdate
    : simpleAssignment
    ;

declaration
    : type ID ('=' expr)?
    ;

assignment
    : ID '=' expr
    ;

simpleAssignment
    : ID '=' expr
    ;

// Expressões com precedência
expr: orExpr ;

orExpr: andExpr ('||' andExpr)* ;
andExpr: relExpr ('&&' relExpr)* ;

relExpr
    : addExpr (('<' | '>' | '<=' | '>=' | '==' | '!=') addExpr)?
    ;

addExpr
    : term (('+' | '-') term)*
    ;

term
    : factor (('*' | '/') factor)*
    ;

factor
    : INT
    | DECIMAL
    | BOOL
    | STRING
    | ID
    | '(' expr ')'
    | '-' factor
    | '!' factor
    ;

printfStmt: 'printf' '(' expr ')' ';' ;
scanfStmt: 'scanf' '(' ID ')' ';' ;

type: 'int' | 'bool' | 'decimal' | 'string' ;

// ----------------
// Lexer rules
// ----------------

DECIMAL: [0-9]+ '.' [0-9]+ ;
INT: [0-9]+ ;
BOOL: 'true' | 'false' ;
STRING: '"' ( ~["\\] | '\\' . )* '"' ;

ID: [a-zA-Z_] [a-zA-Z0-9_]* ;

WS: [ \t\r\n]+ -> skip ;
LINE_COMMENT: '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT: '/*' .*? '*/' -> skip ;