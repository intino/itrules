lexer grammar ItrLexer;

@lexer::members {
	int lastMode = 0;
	boolean inBody = false;
	private void setLastMode(int i) {
		lastMode = i;
	}

	public int getLastMode() {
        return lastMode;
    }

    public boolean markHasParameters() {
        if (getCharIndex() == this.getInputStream().toString().length()) return false;
        char c = this.getInputStream().toString().charAt(getCharIndex());
        String next = "";
        if (getCharIndex() + 3 < getInputStream().toString().length())
            next = this.getInputStream().toString().substring(getCharIndex(), getCharIndex() + 3);
        return (c == '+' || next.equals("..."));
    }

    public void setMode(int newMode) {
        _mode = newMode;
    }

    public void exitMark() {
        if(!markHasParameters()) {
			setMode(lastMode);
			setLastMode(MARK_MODE);
        }
    }
}


RULE_BEGIN          : 'def'                                     { setMode(SIGNATURE_MODE); setLastMode(DEFAULT_MODE);};
WL                  : (' '|'\t')* ('\r'? '\n' | '\n')           -> skip;
BODY                : 'body'                                    -> skip;
COMMENTS            : .*                                        -> skip;
mode SIGNATURE_MODE;
	NOT             : '!';
	FUNCTION        : LETTER(DIGIT|LETTER)*;
	END_SIGNATURE   : (' '|'\t')* NL ('\t' | '    ')?           { setLastMode(SIGNATURE_MODE); setType(BODY);} -> mode(BODY_MODE);
	WS              : SP+                                       -> skip;
	PARAMETERS      : ('(' ~(')')+ ')')| ('('')');
	RULE_ERROR      : .;

mode BODY_MODE;
	RULE_END        : NL? 'end'                                 { setMode(DEFAULT_MODE); setLastMode(BODY_MODE);};
	NEWLINE         : NL ('\t' | '    ')?                       { setText("\n"); setType(TEXT);};
	DOLLAR          : '$$'                                      { setText("$"); setType(TEXT);};
	LSB             : '$['                                      { setText("["); setType(TEXT);};
	RSB             : '$]'                                      { setText("]"); setType(TEXT);};
	TRIGGER         : '$'                                       { setMode(MARK_MODE); setLastMode(BODY_MODE);};
	LEFT_SB         : '['                                       { setMode(EXPRESSION_MODE); setLastMode(BODY_MODE);};
	TEXT            : ~('$'| '['  | '\r' | '\n' | '~')+;

mode MARK_MODE;
	LIST            : '...';
	OPTION          : '+'                                       { setType(OPTION);};
    NULL            : '~'                                       { setMode(lastMode); setLastMode(MARK_MODE);};
	SEPARATOR       : '[' (~']')* ']'                           { setMode(lastMode); setLastMode(MARK_MODE);};
	ID              : LETTER(DIGIT|LETTER)*                     { setType(ID); exitMark();};
	MARK_ERROR      : .;

mode EXPRESSION_MODE;
	RIGHT_SB           : ']'                                    { setLastMode(EXPRESSION_MODE);} -> mode(BODY_MODE);
	EXPRESSION_DOLLAR  : '$$'                                   { setText("$"); setType(TEXT);};
    EXPRESSION_LSB     : '$['                                   { setText("["); setType(TEXT);};
    EXPRESSION_RSB     : '$]'                                   { setText("]"); setType(TEXT);};
	EXPRESSION_TRIGGER : '$'                                    { setType(TRIGGER); setLastMode(EXPRESSION_MODE);} -> mode(MARK_MODE);
	EXPRESSION_TEXT    : ~('$'| '[' | ']' | '\n')*              { setType(TEXT);};
	EXPRESSION_NL      : NL ('\t' | '    ')?                     { setText("\n"); setType(TEXT);};
	EXPRESSION_ERROR   : .;

fragment
   	NL              : ('\r'? '\n' | '\n');
fragment
	SP              : (' ' | '\t');
fragment
	DIGIT           :[0-9];
fragment
	LETTER          : 'a'..'z' | 'A'..'Z';


