parser grammar TemplationParser;
options { tokenVocab=TemplationLexer; }


root: text EOF;
text: (OTHER | mark | expression | block )*;

mark: MARK ID;

expression: LEFT_SQUARE (OTHER | mark | expression)* OTHER? RIGHT_SQUARE;
block: NL BLOCK ID NL text NL BLOCK_END;