parser grammar TemplationParser;
options { tokenVocab=TemplationLexer; }


root: block+ EOF;
block: blockID NL blockBody;
blockBody: (TEXT | mark | expression | block )*;

mark: MARK ID (TAG ID)? (LIST separator);
separator: LEFT_SQ (TEXT | NL_SEP)  RIGHT_SQ;

expression: LEFT_SQ (TEXT | mark | expression)* TEXT? RIGHT_SQ;

blockID : BLOCK_KEY ID;