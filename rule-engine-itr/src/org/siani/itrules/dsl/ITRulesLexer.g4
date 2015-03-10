lexer grammar ITRulesLexer;

@lexer::members {
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

mode RULE_SIGNATURE;
	OPTION          : '+';
	LEFT_P          : '(';
	RIGHT_P         : ')';
	COMMA           : ',';
	TYPE            : 'type';
	TRIGGER         : 'trigger';
	SLOT_NAME       : 'slot-name';
	SLOT_TYPE       : 'slot-type';
	DEEP            : 'deep';
	EVAL            : 'eval'                                    { setMode(EVAL_MODE); setLastMode(RULE_SIGNATURE);};
	NOT             : '!';
	RULE_ID         : LETTER(DIGIT|LETTER)*                     { setType(ID);};
	NL              : (' '|'\t')* ('\r'? '\n' | '\n')           { setLastMode(RULE_SIGNATURE);} -> mode(RULE_BODY);
	WS              : SP+                                       -> skip ;
	RULE_ERROR      : .;

mode EVAL_MODE;
	EVAL_LEFT_P     : '('                                       { setType(LEFT_P);};
    EVAL_RIGHT_P    : ')'                                       { setType(RIGHT_P); setMode(RULE_SIGNATURE); setLastMode(EVAL);};
	EVAL_ID         : LETTER(DIGIT|LETTER)*                     { setType(ID);};
	DOT             : '.';
	NUMBER          : DIGIT+;
	STRING          : '\'' (~'\'')* '\'';
	OPERATOR        : '>' | '<' | '==' | '!=';
	E_WS            : SP+                                       -> skip ;
	EVAL_ERROR      : .;

mode RULE_BODY;
	NULL_CHAR       : '~'                                       -> skip;
	SCAPED_CHAR     : '$$'| '$[' | '$]';
	MARK_KEY        : '$'                                       {setMode(MARK); setLastMode(RULE_BODY);};
	LEFT_SQ         : '['                                       {setMode(EXPRESSION); setLastMode(RULE_BODY);};
	RULE_END        : '\u0015'                            {setMode(DEFAULT_MODE); setLastMode(RULE_BODY);};
	RULE_TEXT       : ~('$'| '[' | '\u0015' | '~')+             {setType(TEXT);};

mode MARK;
	LIST            : '...';
	MARK_OPTION     : '+'                                       { setType(OPTION);};
    END             : '~'                                       { setMode(lastMode); setLastMode(MARK);};
	SEPARATOR       : '[' (~']')* ']'                           { setMode(lastMode); setLastMode(MARK);};
	MARK_ID         : LETTER(DIGIT|LETTER)*                     { setType(ID); exitMark();};
	MARK_ERROR      : .;

mode EXPRESSION;
	NULL_CH         : '~'                                       -> skip;
	RIGHT_SQ        : ']'                                       {setLastMode(EXPRESSION);} -> mode(RULE_BODY);
	EXP_SCAPED_CHAR : '$$'| '$[' | '$]'                         {setType(SCAPED_CHAR);};
	EXPRESSION_MARK : '$'                                       {setType(MARK_KEY); setLastMode(EXPRESSION);} -> mode(MARK);
	EXPRESSION_TEXT : ~('$'| '[' | ']')*                        {setType(TEXT);};

fragment
   	LN              : ('\r'? '\n' | '\n');
fragment
	SP              : (' ' | '\t');
fragment
	DIGIT           :[0-9];
fragment
	LETTER          : 'a'..'z' | 'A'..'Z';


