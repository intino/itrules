parser grammar ItrParser;
options { tokenVocab=ItrLexer; }

root            : defintion* EOF;
defintion       : RULE_BEGIN signature body RULE_END;

signature       : function+ BODY;
function        : NOT? ID CONDITIONS;

body            : (line NL)* line;
line            : (text | mark | expression)*;

expression      : LEFT_SQ (text | mark | expression)* RIGHT_SQ;
text            : TEXT;
mark            : MARK_KEY ID option* (LIST SEPARATOR)?;
option          : OPTION ID;