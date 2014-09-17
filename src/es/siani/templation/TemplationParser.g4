parser grammar TemplationParser;
options { tokenVocab=TemplationLexer; }

root: text? block* EOF;

block: blockSignature blockBody;
blockSignature: BLOCK_KEY BLOCK_NAME (BLOCK_FILTER BLOCK_NAME)? (WS+ IF WS+ NOT? BLOCK_NAME)? NL;
blockBody: (text | mark | expression)*;
expression: LEFT_SQ (text | mark | expression)* RIGHT_SQ;

filter: IF MARK_NAME+;
text: TEXT | SCAPED_CHAR;
mark : MARK_KEY MARK_NAME (TAG MARK_NAME)? (LIST SEPARATOR)?;
