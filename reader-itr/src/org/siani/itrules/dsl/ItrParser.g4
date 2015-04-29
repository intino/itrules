parser grammar ItrParser;
options { tokenVocab=ItrLexer; }

root            : definition* EOF;
definition       : RULE_BEGIN signature body RULE_END;

signature       : condition+ BODY;
condition       : NOT? FUNCTION PARAMETERS?;

body            : (text | mark | expression)*;

expression      : LEFT_SB (text | mark | expression)* RIGHT_SB;
text            : TEXT;
mark            : TRIGGER ID option* (LIST SEPARATOR)?;
option          : OPTION ID;