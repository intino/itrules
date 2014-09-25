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
        if (getCharIndex() == this.getInputStream().toString().length()) return false;
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


BLOCK_BEGIN: ':' RULE                                   { setMode(BLOCK_SIGNATURE); setLastMode(DEFAULT_MODE);};
TEXT: ~(':')*                                           -> skip;
ID :LETTER(DIGIT|LETTER)*;


mode BLOCK_SIGNATURE;
	OPTION : '+';
	BLOCK_ID: LETTER(DIGIT|LETTER)*                     { setType(ID);};
	NOT: '!';
	WITH_TAG: '$';
	NL: (' '|'\t')* ('\r'? '\n' | '\n')                 { setLastMode(BLOCK_SIGNATURE);} -> mode(BLOCK_BODY);
	WS: SP+                                             -> skip ;
	BLOCK_ERROR:.;


mode MARK;
	LIST: '...';
	MARK_OPTION: '+'                                    { setType(OPTION);};
	SEPARATOR: '[' (~']')* ']'                          { setMode(lastMode); setLastMode(MARK);};
	MARK_ID: LETTER(DIGIT|LETTER)*                      { setType(ID); exitMark();};
	MARK_ERROR: .;

mode BLOCK_BODY;
	SCAPED_CHAR: '$$'| '$[' | '$]'| '$:';
	MARK_KEY: '$'                                       {setMode(MARK); setLastMode(BLOCK_BODY);};
	LEFT_SQ: '['                                        {setMode(EXPRESION); setLastMode(BLOCK_BODY);};
	BLOCK_END: ':end' (('\r'? '\n' | '\n') | EOF)       {setMode(DEFAULT_MODE); setLastMode(BLOCK_BODY);};
	BLOCK_TEXT: ~('$'| '['| ':')*                       {setType(TEXT);};

mode EXPRESION;
	RIGHT_SQ: ']'                                       {setLastMode(EXPRESION);} -> mode(BLOCK_BODY);
	EXP_SCAPED_CHAR: '$$'| '$[' | '$]'| '$:'           {setType(SCAPED_CHAR);};
	EXPRESSION_MARK: '$'                                {setType(MARK_KEY); setLastMode(EXPRESION);} -> mode(MARK);
	EXPRESSION_TEXT: ~('$'| '[' | ']')*                 {setType(TEXT);};

fragment
	RULE: 'rule';
	SP: (' ' | '\t');
fragment
	DIGIT :[0-9];
fragment
	LETTER: 'a'..'z' | 'A'..'Z';


