parser grammar TemplationParser;
options { tokenVocab=TemplationLexer; }

root: text? block* EOF;

block: blockSignature blockBody BLOCK_END;
blockSignature: BLOCK_BEGIN ID (OPTION ID)? tags? NL;
tags: condition+;
condition : NOT? WITH_TAG ID;

blockBody: (text | mark | expression)*;

expression: LEFT_SQ (text | mark | expression)* RIGHT_SQ;

text: TEXT | SCAPED_CHAR;
mark : MARK_KEY ID (OPTION ID)? (LIST SEPARATOR)?;
