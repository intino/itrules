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
        String list = "";
        if (getCharIndex() + 3 < getInputStream().toString().length())
            list = this.getInputStream().toString().substring(getCharIndex(), getCharIndex() + 3);
        return c == '+' || list.equals("...");
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

BLOCK_KEY: ':'                                          {setMode(BLOCK_SIGNATURE); setLastMode(DEFAULT_MODE);};
TEXT: ~(':')*;

mode MARK;
	LIST:'...';
	TAG:'+';
	SCAPED_CHAR: '$' | '[' | ']'| ':';
	MARK_NAME: LETTER(DIGIT|LETTER)*                    { exitMark();};
	SEPARATOR:'[' ~(']')*                               { setMode(lastMode); setLastMode(MARK);};
	MARK_ERROR:.;
mode BLOCK_SIGNATURE;
    IF: 'if';
	BLOCK_FILTER : '+';
	WS:' ';
	BLOCK_NAME: (NAME | STRING| INTEGER | DOUBLE);
	STRING: 'String';
	DOUBLE: 'Double';
	INTEGER: 'Integer';
	NOT:'!';
	NL: (' '|'\t')* ('\r'? '\n' | '\n')                 {setLastMode(BLOCK_SIGNATURE);} -> mode(BLOCK_BODY);
	NAME: LETTER(DIGIT|LETTER)*;
	BLOCK_ERROR:.;

mode BLOCK_BODY;
	MARK_KEY: '$'                                       {setMode(MARK); setLastMode(BLOCK_BODY);};
	LEFT_SQ: '['                                        {setMode(EXPRESION); setLastMode(BLOCK_BODY);};
	END: ':'                                            {setType(BLOCK_KEY);setMode(BLOCK_SIGNATURE); setLastMode(BLOCK_BODY);};
	BLOCK_TEXT: ~('$'| '[' |':')*                       {setType(TEXT);};
mode EXPRESION;

	EXPRESSION_MARK: '$'                                {setType(MARK_KEY); setLastMode(EXPRESION);} -> mode(MARK);
	RIGHT_SQ: ']'                                       {setLastMode(EXPRESION);} -> mode(BLOCK_BODY);
	EXPRESSION_TEXT: ~('$'| '[' | ']')*                 {setType(TEXT);};
fragment
DIGIT :[0-9];
fragment
LETTER: 'a'..'z' | 'A'..'Z';

