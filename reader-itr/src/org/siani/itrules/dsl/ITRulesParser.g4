parser grammar ITRulesParser;
options { tokenVocab=ITRulesLexer; }

root            : itrule* EOF;
itrule          : signature body RULE_END;
signature       : RULE_BEGIN function+ NL;

function        : NOT? ID CONDITIONS;
trigger         : TRIGGER CONDITIONS;
triggerValue    : ID (OPTION ID)?;

body            : (text | mark | expression)*;

expression      : LEFT_SQ (text | mark | expression)* RIGHT_SQ;
text            : TEXT | SCAPED_CHAR | EXP_SCAPED_CHAR;
mark            : MARK_KEY ID option* (LIST SEPARATOR)?;
option          : OPTION ID;