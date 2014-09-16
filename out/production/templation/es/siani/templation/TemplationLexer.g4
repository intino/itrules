lexer grammar TemplationLexer;

@lexer::members{
	int lastMode = 0;

	private void setLastMode(int i) {
		lastMode = i;
	}

	public int getLastMode() {
        return lastMode;
    }

    public boolean markHasParameters() {
        char c = this.getInputStream().toString().charAt(getCharIndex());
        return c != ' ' && c != '\n' && c != '~';
    }

    public void setMode(int newMode) {
        _mode = newMode;
    }

    public void exitMark() {
        if(!markHasParameters()) {
			setMode(lastMode);
			setLastMode(MARK);
        }
    }
}

BLOCK_KEY: ':'                  {setMode(BLOCK_SIGNATURE); setLastMode(DEFAULT_MODE);};
TEXT: ~(':')*;

mode MARK;
	LIST:'...';
	TAG:'+';
	MARK_NAME: LETTER(DIGIT|LETTER)*                   { exitMark();};
	SEPARATOR:'[' ~(']')*                              { setMode(lastMode); setLastMode(MARK);};

mode BLOCK_SIGNATURE;
	BLOCK_NAME: (BLOCK_ID | STRING| INTEGER | DOUBLE);
	STRING: 'String';
	DOUBLE: 'Double';
	INTEGER: 'Integer';
	NOT:'!';
    IF: 'if';
	BLOCK_ID: LETTER(DIGIT|LETTER)*;
	NL: (' '|'\t')* ('\r'? '\n' | '\n')             {setLastMode(BLOCK_SIGNATURE);} -> mode(BLOCK_BODY);

mode BLOCK_BODY;
	MARK_KEY: '$'                       {setMode(MARK); setLastMode(BLOCK_BODY);};
	LEFT_SQ: '['                        {setMode(EXPRESION); setLastMode(BLOCK_BODY);};
	END: ('\r'? '\n' | '\n') ':'        {setMode(DEFAULT_MODE); setLastMode(BLOCK_BODY);};
	BLOCK_TEXT: ~('$'| '[')*            {setType(TEXT);};

mode EXPRESION;
	SCAPED_CHAR: '$$' | '$[' | '$]';
	INSIDE_MARK: '$'                    {setType(MARK_KEY); setLastMode(EXPRESION);} -> mode(MARK);
	RIGHT_SQ: ']'                       {setLastMode(EXPRESION);} -> mode(BLOCK_BODY);
	EXPRESSION_TEXT: ~('$'| '[' | ']')* {setType(TEXT);};

fragment
DIGIT :[0-9];
fragment
LETTER: 'a'..'z' | 'A'..'Z';

