// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ItrLexer.g4 by ANTLR 4.5
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ItrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_BEGIN=1, WL=2, BODY=3, NOT=4, FUNCTION=5, NL=6, WS=7, PARAMETERS=8, 
		RULE_ERROR=9, INDENT=10, RULE_END=11, NEWLINE=12, DOLLAR=13, LSB=14, RSB=15, 
		TRIGGER=16, LEFT_SB=17, TEXT=18, LIST=19, OPTION=20, NULL=21, SEPARATOR=22, 
		ID=23, MARK_ERROR=24, RIGHT_SB=25, EXPRESSION_DOLLAR=26, EXPRESSION_LSB=27, 
		EXPRESSION_RSB=28, EXPRESSION_TRIGGER=29, EXPRESSION_TEXT=30, EXPRESSION_ERROR=31;
	public static final int SIGNATURE_MODE = 1;
	public static final int BODY_MODE = 2;
	public static final int MARK_MODE = 3;
	public static final int EXPRESSION_MODE = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "SIGNATURE_MODE", "BODY_MODE", "MARK_MODE", "EXPRESSION_MODE"
	};

	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "BODY", "NOT", "FUNCTION", "NL", "WS", "PARAMETERS", 
		"RULE_ERROR", "INDENT", "RULE_END", "NEWLINE", "DOLLAR", "LSB", "RSB", 
		"TRIGGER", "LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", 
		"MARK_ERROR", "RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", 
		"EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_ERROR", "LN", "SP", 
		"DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, "'body'", "'!'", null, null, null, null, null, 
		"'\t'", "'\nendrule'", "'\n'", null, null, null, "'$'", "'['", null, "'...'", 
		"'+'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "BODY", "NOT", "FUNCTION", "NL", "WS", "PARAMETERS", 
		"RULE_ERROR", "INDENT", "RULE_END", "NEWLINE", "DOLLAR", "LSB", "RSB", 
		"TRIGGER", "LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", 
		"MARK_ERROR", "RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", 
		"EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_ERROR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


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
				setLastMode(MARK_MODE);
	        }
	    }


	public ItrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ItrLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: 
			RULE_BEGIN_action((RuleContext)_localctx, actionIndex); 
			break;

		case 5: 
			NL_action((RuleContext)_localctx, actionIndex); 
			break;

		case 9: 
			INDENT_action((RuleContext)_localctx, actionIndex); 
			break;

		case 10: 
			RULE_END_action((RuleContext)_localctx, actionIndex); 
			break;

		case 11: 
			NEWLINE_action((RuleContext)_localctx, actionIndex); 
			break;

		case 12: 
			DOLLAR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 13: 
			LSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 14: 
			RSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 15: 
			TRIGGER_action((RuleContext)_localctx, actionIndex); 
			break;

		case 16: 
			LEFT_SB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 19: 
			OPTION_action((RuleContext)_localctx, actionIndex); 
			break;

		case 20: 
			NULL_action((RuleContext)_localctx, actionIndex); 
			break;

		case 21: 
			SEPARATOR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 22: 
			ID_action((RuleContext)_localctx, actionIndex); 
			break;

		case 24: 
			RIGHT_SB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 25: 
			EXPRESSION_DOLLAR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 26: 
			EXPRESSION_LSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 27: 
			EXPRESSION_RSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 28: 
			EXPRESSION_TRIGGER_action((RuleContext)_localctx, actionIndex); 
			break;

		case 29: 
			EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); 
			break;
		}
	}
	private void RULE_BEGIN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 
			 setMode(SIGNATURE_MODE); setLastMode(DEFAULT_MODE); 
			break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 
			 setLastMode(SIGNATURE_MODE); setType(BODY); 
			break;
		}
	}
	private void INDENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: 
			 if(indent()) skip(); else setType(TEXT); 
			break;
		}
	}
	private void RULE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
			 setMode(DEFAULT_MODE); setLastMode(BODY_MODE); 
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
			 newLine(); setType(NL); 
			break;
		}
	}
	private void DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
			 setText("$"); setType(TEXT); 
			break;
		}
	}
	private void LSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
			 setText("["); setType(TEXT); 
			break;
		}
	}
	private void RSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: 
			 setText("]"); setType(TEXT); 
			break;
		}
	}
	private void TRIGGER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: 
			 setMode(MARK_MODE); setLastMode(BODY_MODE); 
			break;
		}
	}
	private void LEFT_SB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: 
			 setMode(EXPRESSION_MODE); setLastMode(BODY_MODE); 
			break;
		}
	}
	private void OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: 
			 setType(OPTION); 
			break;
		}
	}
	private void NULL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: 
			 setMode(lastMode); setLastMode(MARK_MODE); 
			break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: 
			 setMode(lastMode); setLastMode(MARK_MODE); 
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: 
			 setType(ID); exitMark(); 
			break;
		}
	}
	private void RIGHT_SB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: 
			 setLastMode(EXPRESSION_MODE); 
			break;
		}
	}
	private void EXPRESSION_DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: 
			 setText("$"); setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_LSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: 
			 setText("["); setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_RSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: 
			 setText("]"); setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_TRIGGER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: 
			 setType(TRIGGER); setLastMode(EXPRESSION_MODE); 
			break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19: 
			 setType(TEXT); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u0114\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\3\5\3_\n\3\3\3\3\3\5\3c\n\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6s\n\6\f\6"+
		"\16\6v\13\6\3\7\7\7y\n\7\f\7\16\7|\13\7\3\7\5\7\177\n\7\3\7\3\7\5\7\u0083"+
		"\n\7\3\7\3\7\3\7\3\7\3\b\6\b\u008a\n\b\r\b\16\b\u008b\3\b\3\b\3\t\3\t"+
		"\6\t\u0092\n\t\r\t\16\t\u0093\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\6\23\u00c1\n\23\r\23\16\23\u00c2\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\7\27\u00d1\n\27\f\27\16\27\u00d4"+
		"\13\27\3\27\3\27\3\27\3\30\3\30\3\30\7\30\u00dc\n\30\f\30\16\30\u00df"+
		"\13\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\7\37\u00ff\n\37\f\37\16\37\u0102\13\37\3\37\3\37\3 \3"+
		" \3!\5!\u0109\n!\3!\3!\5!\u010d\n!\3\"\3\"\3#\3#\3$\3$\2\2%\7\3\t\4\13"+
		"\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23"+
		")\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\2G\2I\2"+
		"K\2\7\2\3\4\5\6\t\4\2\13\13\"\"\3\2++\6\2\f\f&&]]\u0080\u0080\3\2__\6"+
		"\2\f\f&&]]__\3\2\62;\4\2C\\c|\u011c\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\3\r\3\2\2\2\3\17\3\2\2\2\3\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27"+
		"\3\2\2\2\4\31\3\2\2\2\4\33\3\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2"+
		"\2\4#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\5+\3\2\2\2\5-\3\2\2\2"+
		"\5/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\6\67\3\2\2\2\69\3\2"+
		"\2\2\6;\3\2\2\2\6=\3\2\2\2\6?\3\2\2\2\6A\3\2\2\2\6C\3\2\2\2\7M\3\2\2\2"+
		"\tZ\3\2\2\2\13f\3\2\2\2\rm\3\2\2\2\17o\3\2\2\2\21z\3\2\2\2\23\u0089\3"+
		"\2\2\2\25\u008f\3\2\2\2\27\u0097\3\2\2\2\31\u0099\3\2\2\2\33\u009c\3\2"+
		"\2\2\35\u00a7\3\2\2\2\37\u00aa\3\2\2\2!\u00af\3\2\2\2#\u00b4\3\2\2\2%"+
		"\u00b9\3\2\2\2\'\u00bc\3\2\2\2)\u00c0\3\2\2\2+\u00c4\3\2\2\2-\u00c8\3"+
		"\2\2\2/\u00cb\3\2\2\2\61\u00ce\3\2\2\2\63\u00d8\3\2\2\2\65\u00e2\3\2\2"+
		"\2\67\u00e4\3\2\2\29\u00e9\3\2\2\2;\u00ee\3\2\2\2=\u00f3\3\2\2\2?\u00f8"+
		"\3\2\2\2A\u0100\3\2\2\2C\u0105\3\2\2\2E\u010c\3\2\2\2G\u010e\3\2\2\2I"+
		"\u0110\3\2\2\2K\u0112\3\2\2\2MN\7f\2\2NO\7g\2\2OP\7h\2\2PQ\7t\2\2QR\7"+
		"w\2\2RS\7n\2\2ST\7g\2\2TU\3\2\2\2UV\b\2\2\2V\b\3\2\2\2WY\t\2\2\2XW\3\2"+
		"\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[b\3\2\2\2\\Z\3\2\2\2]_\7\17\2\2^]"+
		"\3\2\2\2^_\3\2\2\2_`\3\2\2\2`c\7\f\2\2ac\7\f\2\2b^\3\2\2\2ba\3\2\2\2c"+
		"d\3\2\2\2de\b\3\3\2e\n\3\2\2\2fg\7d\2\2gh\7q\2\2hi\7f\2\2ij\7{\2\2jk\3"+
		"\2\2\2kl\b\4\3\2l\f\3\2\2\2mn\7#\2\2n\16\3\2\2\2ot\5K$\2ps\5I#\2qs\5K"+
		"$\2rp\3\2\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\20\3\2\2\2vt\3"+
		"\2\2\2wy\t\2\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\u0082\3\2\2"+
		"\2|z\3\2\2\2}\177\7\17\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0083\7\f\2\2\u0081\u0083\7\f\2\2\u0082~\3\2\2\2\u0082\u0081\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0085\b\7\4\2\u0085\u0086\3\2\2\2\u0086\u0087"+
		"\b\7\5\2\u0087\22\3\2\2\2\u0088\u008a\5G\"\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\b\b\3\2\u008e\24\3\2\2\2\u008f\u0091\7*\2\2\u0090\u0092"+
		"\n\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7+\2\2\u0096\26\3\2\2\2"+
		"\u0097\u0098\13\2\2\2\u0098\30\3\2\2\2\u0099\u009a\7\13\2\2\u009a\u009b"+
		"\b\13\6\2\u009b\32\3\2\2\2\u009c\u009d\7\f\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7p\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7w\2\2"+
		"\u00a2\u00a3\7n\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6"+
		"\b\f\7\2\u00a6\34\3\2\2\2\u00a7\u00a8\7\f\2\2\u00a8\u00a9\b\r\b\2\u00a9"+
		"\36\3\2\2\2\u00aa\u00ab\7&\2\2\u00ab\u00ac\7&\2\2\u00ac\u00ad\3\2\2\2"+
		"\u00ad\u00ae\b\16\t\2\u00ae \3\2\2\2\u00af\u00b0\7&\2\2\u00b0\u00b1\7"+
		"]\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\17\n\2\u00b3\"\3\2\2\2\u00b4\u00b5"+
		"\7&\2\2\u00b5\u00b6\7_\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\20\13\2\u00b8"+
		"$\3\2\2\2\u00b9\u00ba\7&\2\2\u00ba\u00bb\b\21\f\2\u00bb&\3\2\2\2\u00bc"+
		"\u00bd\7]\2\2\u00bd\u00be\b\22\r\2\u00be(\3\2\2\2\u00bf\u00c1\n\4\2\2"+
		"\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3*\3\2\2\2\u00c4\u00c5\7\60\2\2\u00c5\u00c6\7\60\2\2\u00c6"+
		"\u00c7\7\60\2\2\u00c7,\3\2\2\2\u00c8\u00c9\7-\2\2\u00c9\u00ca\b\25\16"+
		"\2\u00ca.\3\2\2\2\u00cb\u00cc\7\u0080\2\2\u00cc\u00cd\b\26\17\2\u00cd"+
		"\60\3\2\2\2\u00ce\u00d2\7]\2\2\u00cf\u00d1\n\5\2\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7_\2\2\u00d6\u00d7\b\27\20\2"+
		"\u00d7\62\3\2\2\2\u00d8\u00dd\5K$\2\u00d9\u00dc\5I#\2\u00da\u00dc\5K$"+
		"\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e1\b\30\21\2\u00e1\64\3\2\2\2\u00e2\u00e3\13\2\2\2\u00e3\66\3\2\2"+
		"\2\u00e4\u00e5\7_\2\2\u00e5\u00e6\b\32\22\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\b\32\5\2\u00e88\3\2\2\2\u00e9\u00ea\7&\2\2\u00ea\u00eb\7&\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\b\33\23\2\u00ed:\3\2\2\2\u00ee\u00ef\7&\2\2"+
		"\u00ef\u00f0\7]\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\34\24\2\u00f2<\3"+
		"\2\2\2\u00f3\u00f4\7&\2\2\u00f4\u00f5\7_\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\b\35\25\2\u00f7>\3\2\2\2\u00f8\u00f9\7&\2\2\u00f9\u00fa\b\36\26"+
		"\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\36\27\2\u00fc@\3\2\2\2\u00fd\u00ff"+
		"\n\6\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\b\37"+
		"\30\2\u0104B\3\2\2\2\u0105\u0106\13\2\2\2\u0106D\3\2\2\2\u0107\u0109\7"+
		"\17\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010d\7\f\2\2\u010b\u010d\7\f\2\2\u010c\u0108\3\2\2\2\u010c\u010b\3\2"+
		"\2\2\u010dF\3\2\2\2\u010e\u010f\t\2\2\2\u010fH\3\2\2\2\u0110\u0111\t\7"+
		"\2\2\u0111J\3\2\2\2\u0112\u0113\t\b\2\2\u0113L\3\2\2\2\30\2\3\4\5\6Z^"+
		"brtz~\u0082\u008b\u0093\u00c2\u00d2\u00db\u00dd\u0100\u0108\u010c\31\3"+
		"\2\2\b\2\2\3\7\3\4\4\2\3\13\4\3\f\5\3\r\6\3\16\7\3\17\b\3\20\t\3\21\n"+
		"\3\22\13\3\25\f\3\26\r\3\27\16\3\30\17\3\32\20\3\33\21\3\34\22\3\35\23"+
		"\3\36\24\4\5\2\3\37\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}