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

    public boolean indent() {
        if (inBody) return false;
        inBody= true;
        return true;
    }

    public void newLine(){
        inBody = false;
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
			setLastMode(MARK);
        }
    }
}


RULE_BEGIN          : 'defrule'                                 { setMode(RULE_SIGNATURE); setLastMode(DEFAULT_MODE);};
WL                  : (' '|'\t')* ('\r'? '\n' | '\n')           -> skip;
ID                  : LETTER(DIGIT|LETTER)*                     -> skip;
TEXT                : 'text'                                    -> skip;
BODY                : 'body'                                    -> skip;

mode RULE_SIGNATURE;
	NOT             : '!';
	RULE_FUNCTION   : LETTER(DIGIT|LETTER)*                     { setType(ID);};
	NL              : (' '|'\t')* ('\r'? '\n' | '\n')           { setLastMode(RULE_SIGNATURE); setType(BODY);} -> mode(RULE_BODY);
	WS              : SP+                                       -> skip ;
	CONDITIONS      : '(' ~(')')+ ')';
	RULE_ERROR      : .;

mode RULE_BODY;
	NULL_CHAR       : '~'                                       -> skip;
	INDENT          : '\t'                                      { if(indent()) skip(); else setType(TEXT);};
	RULE_END        : '\nendrule'                               { setMode(DEFAULT_MODE); setLastMode(RULE_BODY);};
	NEWLINE         : '\n'                                      { newLine(); setType(NL);};
	DOLLAR          : '$$'                                      { setText("$"); setType(TEXT);};
	LQ              : '$['                                      { setText("["); setType(TEXT);};
	RQ              : '$]'                                      { setText("]"); setType(TEXT);};
	MARK_KEY        : '$'                                       { setMode(MARK); setLastMode(RULE_BODY);};
	LEFT_SQ         : '['                                       { setMode(EXPRESSION); setLastMode(RULE_BODY);};
	RULE_TEXT       : ~('$'| '['  | '\n' | '~')+                { setType(TEXT);};

mode MARK;
	LIST            : '...';
	OPTION          : '+'                                       { setType(OPTION);};
    END             : '~'                                       { setMode(lastMode); setLastMode(MARK);};
	SEPARATOR       : '[' (~']')* ']'                           { setMode(lastMode); setLastMode(MARK);};
	MARK_ID         : LETTER(DIGIT|LETTER)*                     { setType(ID); exitMark();};
	MARK_ERROR      : .;

mode EXPRESSION;
	NULL_CH         : '~'                                       -> skip;
	RIGHT_SQ        : ']'                                       { setLastMode(EXPRESSION);} -> mode(RULE_BODY);
	EXPRESSION_DOLLAR  : '$$'                                   { setText("$");setType(TEXT);};
    EXPRESSION_LQ      : '$['                                   { setText("[");setType(TEXT);};
    EXPRESSION_RQ      : '$]'                                   { setText("]");setType(TEXT);};
	EXPRESSION_MARK : '$'                                       { setType(MARK_KEY); setLastMode(EXPRESSION);} -> mode(MARK);
	EXPRESSION_TEXT : ~('$'| '[' | ']' | '\n')*                 { setType(TEXT);};
	EXPRESSION_ERROR: .;

fragment
   	LN              : ('\r'? '\n' | '\n');
fragment
	SP              : (' ' | '\t');
fragment
	DIGIT           :[0-9];
fragment
	LETTER          : 'a'..'z' | 'A'..'Z';


