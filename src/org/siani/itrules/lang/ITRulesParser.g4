parser grammar ITRulesParser;
options { tokenVocab=ITRulesLexer; }

root        : itrule* EOF;

itrule      : signature body RULE_END;

signature   : RULE_BEGIN (ruleType | trigger | attr)+ NL;

ruleType    : NOT? TYPE value;
value       : LEFT_P ID RIGHT_P;
trigger     : TRIGGER LEFT_P triggerValue RIGHT_P;
triggerValue : ID (OPTION ID)?;
attr        : ATTR LEFT_P NOT? ID RIGHT_P;

body        : (text | mark | expression)*;

expression  : LEFT_SQ (text | mark | expression)* RIGHT_SQ;
text        : TEXT | SCAPED_CHAR;
mark        : MARK_KEY ID (OPTION (ID | format))? (LIST SEPARATOR)?;
format      : FORMAT LEFT_P (FORMAT_REGEX | ID) RIGHT_P;
