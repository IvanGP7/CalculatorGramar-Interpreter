grammar Calculator;

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   NEWLINE                     # blank
    ;

expr
    :   expr '*' expr         # Mul
    |   expr '/' expr         # Div
    |   expr '+' expr         # Add 
    |   expr '-' expr         # Sub
    |   INT                         # int
    |   FLOAT                       # float
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

MUL:    '*' ; // define tokens
DIV:    '/' ;
ADD:    '+' ;
SUB:    '-' ;
ID:     [a-zA-Z]+ ;      // match identifiers
INT:    [0-9]+ ;         // match integers
FLOAT:  [0-9]+'.'[0-9]+ ; // match floating point numbers
NEWLINE:'\r'? '\n' ;    // return newlines to parser (is end-statement signal)
WS:     [ \t]+ -> skip ; // toss out whitespace

