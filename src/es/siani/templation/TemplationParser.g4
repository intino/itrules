parser grammar TemplationParser;
options { tokenVocab=TemplationLexer; }


root: block* EOF;

block: BLOCK_BEGIN filter? WS* NL blockBody;
blockBody: (text | mark | expression)*;
expression: LEFT_SQ (text | MARK | expression)* text? RIGHT_SQ;

filter: IF ID+;
text: TEXT | SCAPED_CHAR;
mark : MARK (LIST separator)?;

separator : LEFT_SQ (text | NL_SEP) RIGHT_SQ