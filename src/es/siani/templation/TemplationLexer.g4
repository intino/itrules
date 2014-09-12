lexer grammar TemplationLexer;

LEFT_SQ:'[';
RIGHT_SQ:']';

NL: ('\r'? '\n' | '\n');
MARK_ID: MARK_KEY (ID | STRING | DOUBLE | INTEGER);
TEXT:.* (BLOCK_KEY | MARK_KEY | LEFT_SQ | RIGHT_SQ);
STRING: 'String';
DOUBLE: 'Double';
INTEGER: 'Integer';
ID: LETTER (DIGIT | LETTER)*;
MARK_KEY: '$';
BLOCK_KEY:':';
TAG:'+';
LIST:'...';
NL_SEP: '$NL';
LETTER: 'a'..'z' | 'A'..'Z';
DIGIT :[0-9];

