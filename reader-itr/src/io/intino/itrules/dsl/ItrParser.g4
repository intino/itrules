parser grammar ItrParser;
options { tokenVocab=ItrLexer; }

root            : COMMENT* (definition COMMENT*)+ EOF;
definition      : BEGIN_RULE signature body END_RULE;

signature       : condition+ BEGIN_BODY;
condition       : NOT? FUNCTION PARAMETERS?;

body            : (text | mark | expression)*;

expression      : BEGIN_EXPRESSION expressionBody+ (ELSE expressionBody+)* END_EXPRESSION;

expressionBody  : text | mark | expression;

text            : TEXT;
mark            : TRIGGER ID option* (LIST SEPARATOR)?;
option          : lambda | (OPTION ID);
lambda          : OPTION_LAMBDA text* END_LAMBDA;