parser grammar ITRulesParser;
options { tokenVocab=ITRulesLexer; }

root            : itrule* EOF;
itrule          : signature body RULE_END;
signature       : RULE_BEGIN (ruleType | trigger | attr | eval)+ NL;

ruleType        : NOT? TYPE value;
value           : LEFT_P ID RIGHT_P;
eval            : EVAL LEFT_P evalExpression RIGHT_P;
evalExpression  : (composedID | STRING | NUMBER) OPERATOR (composedID | STRING | NUMBER) ;
composedID      : ID (DOT ID)?;
trigger         : TRIGGER LEFT_P triggerValue RIGHT_P;
triggerValue    : ID (OPTION ID)?;
attr            : ATTR LEFT_P NOT? ID RIGHT_P;

body            : (text | mark | expression)*;

expression      : LEFT_SQ (text | mark | expression)* RIGHT_SQ;
text            : TEXT | SCAPED_CHAR;
mark            : MARK_KEY ID option* (LIST SEPARATOR)?;
option          : OPTION ID;