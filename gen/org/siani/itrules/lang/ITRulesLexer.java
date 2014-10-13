package org.siani.itrules.lang;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ITRulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_BEGIN=1, WL=2, ID=3, TEXT=4, OPTION=5, LEFT_P=6, RIGHT_P=7, TYPE=8, 
		TRIGGER=9, ATTR=10, EVAL=11, NOT=12, RULE_ID=13, NL=14, WS=15, RULE_ERROR=16, 
		EVAL_LEFT_P=17, EVAL_RIGHT_P=18, EVAL_ID=19, DOT=20, NUMBER=21, STRING=22, 
		OPERATOR=23, E_WS=24, EVAL_ERROR=25, LIST=26, MARK_OPTION=27, END=28, 
		SEPARATOR=29, MARK_ID=30, MARK_ERROR=31, NULL_CHAR=32, SCAPED_CHAR=33, 
		MARK_KEY=34, LEFT_SQ=35, RULE_END=36, RULE_TEXT=37, RIGHT_SQ=38, EXP_SCAPED_CHAR=39, 
		EXPRESSION_MARK=40, EXPRESSION_TEXT=41;
	public static final int RULE_SIGNATURE = 1;
	public static final int EVAL_MODE = 2;
	public static final int MARK = 3;
	public static final int RULE_BODY = 4;
	public static final int EXPRESION = 5;
	public static String[] modeNames = {
		"DEFAULT_MODE", "RULE_SIGNATURE", "EVAL_MODE", "MARK", "RULE_BODY", "EXPRESION"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'"
	};
	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "ID", "TEXT", "OPTION", "LEFT_P", "RIGHT_P", "TYPE", 
		"TRIGGER", "ATTR", "EVAL", "NOT", "RULE_ID", "NL", "WS", "RULE_ERROR", 
		"EVAL_LEFT_P", "EVAL_RIGHT_P", "EVAL_ID", "DOT", "NUMBER", "STRING", "OPERATOR", 
		"E_WS", "EVAL_ERROR", "LIST", "MARK_OPTION", "END", "SEPARATOR", "MARK_ID", 
		"MARK_ERROR", "NULL_CHAR", "SCAPED_CHAR", "MARK_KEY", "LEFT_SQ", "RULE_END", 
		"RULE_TEXT", "RIGHT_SQ", "EXP_SCAPED_CHAR", "EXPRESSION_MARK", "EXPRESSION_TEXT", 
		"LN", "SP", "DIGIT", "LETTER"
	};


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
	        return (c == '+' || next.equals("...") || (next.length() >= 2 && next.substring(0,2).equals("$~")));
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


	public ITRulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ITRulesLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		case 0: RULE_BEGIN_action((RuleContext)_localctx, actionIndex); break;
		case 10: EVAL_action((RuleContext)_localctx, actionIndex); break;
		case 12: RULE_ID_action((RuleContext)_localctx, actionIndex); break;
		case 13: NL_action((RuleContext)_localctx, actionIndex); break;
		case 16: EVAL_LEFT_P_action((RuleContext)_localctx, actionIndex); break;
		case 17: EVAL_RIGHT_P_action((RuleContext)_localctx, actionIndex); break;
		case 18: EVAL_ID_action((RuleContext)_localctx, actionIndex); break;
		case 26: MARK_OPTION_action((RuleContext)_localctx, actionIndex); break;
		case 27: END_action((RuleContext)_localctx, actionIndex); break;
		case 28: SEPARATOR_action((RuleContext)_localctx, actionIndex); break;
		case 29: MARK_ID_action((RuleContext)_localctx, actionIndex); break;
		case 33: MARK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 34: LEFT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 35: RULE_END_action((RuleContext)_localctx, actionIndex); break;
		case 36: RULE_TEXT_action((RuleContext)_localctx, actionIndex); break;
		case 37: RIGHT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 38: EXP_SCAPED_CHAR_action((RuleContext)_localctx, actionIndex); break;
		case 39: EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); break;
		case 40: EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void RULE_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  setType(ID); break;
		}
	}
	private void MARK_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:  setType(ID); exitMark(); break;
		}
	}
	private void EVAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  setMode(EVAL_MODE); setLastMode(RULE_SIGNATURE); break;
		}
	}
	private void RULE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: setMode(DEFAULT_MODE); setLastMode(RULE_BODY); break;
		}
	}
	private void RULE_BEGIN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  setMode(RULE_SIGNATURE); setLastMode(DEFAULT_MODE); break;
		}
	}
	private void EVAL_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:  setType(ID); break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:  setMode(lastMode); setLastMode(MARK); break;
		}
	}
	private void EXPRESSION_MARK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: setType(MARK_KEY); setLastMode(EXPRESION); break;
		}
	}
	private void RULE_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: setType(TEXT); break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:  setLastMode(RULE_SIGNATURE); break;
		}
	}
	private void EVAL_RIGHT_P_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:  setType(RIGHT_P); setMode(RULE_SIGNATURE); setLastMode(EVAL); break;
		}
	}
	private void LEFT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: setMode(EXPRESION); setLastMode(RULE_BODY); break;
		}
	}
	private void END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:  setMode(lastMode); setLastMode(MARK); break;
		}
	}
	private void RIGHT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: setLastMode(EXPRESION); break;
		}
	}
	private void EVAL_LEFT_P_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:  setType(LEFT_P); break;
		}
	}
	private void MARK_OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:  setType(OPTION); break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: setType(TEXT); break;
		}
	}
	private void EXP_SCAPED_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: setType(SCAPED_CHAR); break;
		}
	}
	private void MARK_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: setMode(MARK); setLastMode(RULE_BODY); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u016c\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t"+
		"\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t"+
		"(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\7\3n\n\3\f\3\16\3q\13\3\3\3\5\3t\n\3\3\3\3\3\5\3x\n\3\3\3"+
		"\3\3\3\4\3\4\3\4\7\4\177\n\4\f\4\16\4\u0082\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u00b1\n\16\f\16\16\16\u00b4\13\16\3\16"+
		"\3\16\3\17\7\17\u00b9\n\17\f\17\16\17\u00bc\13\17\3\17\5\17\u00bf\n\17"+
		"\3\17\3\17\5\17\u00c3\n\17\3\17\3\17\3\17\3\17\3\20\6\20\u00ca\n\20\r"+
		"\20\16\20\u00cb\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\7\24\u00db\n\24\f\24\16\24\u00de\13\24\3\24\3\24\3\25\3\25"+
		"\3\26\6\26\u00e5\n\26\r\26\16\26\u00e6\3\27\3\27\7\27\u00eb\n\27\f\27"+
		"\16\27\u00ee\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u00f7\n\30"+
		"\3\31\6\31\u00fa\n\31\r\31\16\31\u00fb\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\7\36\u0110"+
		"\n\36\f\36\16\36\u0113\13\36\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u011b"+
		"\n\37\f\37\16\37\u011e\13\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\5\"\u012f\n\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\7&\u013b\n"+
		"&\f&\16&\u013e\13&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\5(\u0151\n(\3)\3)\3)\3)\3)\3*\7*\u0159\n*\f*\16*\u015c\13*\3*\3*"+
		"\3+\5+\u0161\n+\3+\3+\5+\u0165\n+\3,\3,\3-\3-\3.\3.\2\2/\b\3\n\4\f\5\16"+
		"\6\20\7\22\b\24\t\26\n\30\13\32\f\34\r\36\16 \17\"\20$\21&\22(\23*\24"+
		",\25.\26\60\27\62\30\64\31\66\328\33:\34<\35>\36@\37B D!F\"H#J$L%N&P\'"+
		"R(T)V*X+Z\2\\\2^\2`\2\b\2\3\4\5\6\7\n\4\2\13\13\"\"\3\2))\4\2>>@@\3\2"+
		"__\5\2&&]]\u0080\u0080\5\2&&]]__\3\2\62;\4\2C\\c|\u0180\2\b\3\2\2\2\2"+
		"\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2"+
		"\2\2\3\26\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2\3\34\3\2\2\2\3\36\3\2\2\2"+
		"\3 \3\2\2\2\3\"\3\2\2\2\3$\3\2\2\2\3&\3\2\2\2\4(\3\2\2\2\4*\3\2\2\2\4"+
		",\3\2\2\2\4.\3\2\2\2\4\60\3\2\2\2\4\62\3\2\2\2\4\64\3\2\2\2\4\66\3\2\2"+
		"\2\48\3\2\2\2\5:\3\2\2\2\5<\3\2\2\2\5>\3\2\2\2\5@\3\2\2\2\5B\3\2\2\2\5"+
		"D\3\2\2\2\6F\3\2\2\2\6H\3\2\2\2\6J\3\2\2\2\6L\3\2\2\2\6N\3\2\2\2\6P\3"+
		"\2\2\2\7R\3\2\2\2\7T\3\2\2\2\7V\3\2\2\2\7X\3\2\2\2\bb\3\2\2\2\no\3\2\2"+
		"\2\f{\3\2\2\2\16\u0085\3\2\2\2\20\u008c\3\2\2\2\22\u008e\3\2\2\2\24\u0090"+
		"\3\2\2\2\26\u0092\3\2\2\2\30\u0097\3\2\2\2\32\u009f\3\2\2\2\34\u00a4\3"+
		"\2\2\2\36\u00ab\3\2\2\2 \u00ad\3\2\2\2\"\u00ba\3\2\2\2$\u00c9\3\2\2\2"+
		"&\u00cf\3\2\2\2(\u00d1\3\2\2\2*\u00d4\3\2\2\2,\u00d7\3\2\2\2.\u00e1\3"+
		"\2\2\2\60\u00e4\3\2\2\2\62\u00e8\3\2\2\2\64\u00f6\3\2\2\2\66\u00f9\3\2"+
		"\2\28\u00ff\3\2\2\2:\u0101\3\2\2\2<\u0105\3\2\2\2>\u0108\3\2\2\2@\u010d"+
		"\3\2\2\2B\u0117\3\2\2\2D\u0121\3\2\2\2F\u0123\3\2\2\2H\u012e\3\2\2\2J"+
		"\u0130\3\2\2\2L\u0133\3\2\2\2N\u0136\3\2\2\2P\u013c\3\2\2\2R\u0141\3\2"+
		"\2\2T\u0150\3\2\2\2V\u0152\3\2\2\2X\u015a\3\2\2\2Z\u0164\3\2\2\2\\\u0166"+
		"\3\2\2\2^\u0168\3\2\2\2`\u016a\3\2\2\2bc\7f\2\2cd\7g\2\2de\7h\2\2ef\7"+
		"t\2\2fg\7w\2\2gh\7n\2\2hi\7g\2\2ij\3\2\2\2jk\b\2\2\2k\t\3\2\2\2ln\t\2"+
		"\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pw\3\2\2\2qo\3\2\2\2rt\7\17"+
		"\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2ux\7\f\2\2vx\7\f\2\2ws\3\2\2\2wv\3\2"+
		"\2\2xy\3\2\2\2yz\b\3\3\2z\13\3\2\2\2{\u0080\5`.\2|\177\5^-\2}\177\5`."+
		"\2~|\3\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\b\4\3\2\u0084"+
		"\r\3\2\2\2\u0085\u0086\7v\2\2\u0086\u0087\7g\2\2\u0087\u0088\7z\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\5\3\2\u008b\17\3\2\2\2"+
		"\u008c\u008d\7-\2\2\u008d\21\3\2\2\2\u008e\u008f\7*\2\2\u008f\23\3\2\2"+
		"\2\u0090\u0091\7+\2\2\u0091\25\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094"+
		"\7{\2\2\u0094\u0095\7r\2\2\u0095\u0096\7g\2\2\u0096\27\3\2\2\2\u0097\u0098"+
		"\7v\2\2\u0098\u0099\7t\2\2\u0099\u009a\7k\2\2\u009a\u009b\7i\2\2\u009b"+
		"\u009c\7i\2\2\u009c\u009d\7g\2\2\u009d\u009e\7t\2\2\u009e\31\3\2\2\2\u009f"+
		"\u00a0\7c\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7t\2\2"+
		"\u00a3\33\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7x\2\2\u00a6\u00a7\7"+
		"c\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\b\f\4\2\u00aa"+
		"\35\3\2\2\2\u00ab\u00ac\7#\2\2\u00ac\37\3\2\2\2\u00ad\u00b2\5`.\2\u00ae"+
		"\u00b1\5^-\2\u00af\u00b1\5`.\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2"+
		"\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5"+
		"\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\b\16\5\2\u00b6!\3\2\2\2\u00b7"+
		"\u00b9\t\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00c2\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00bf\7\17\2\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3"+
		"\2\2\2\u00c0\u00c3\7\f\2\2\u00c1\u00c3\7\f\2\2\u00c2\u00be\3\2\2\2\u00c2"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\17\6\2\u00c5\u00c6\3"+
		"\2\2\2\u00c6\u00c7\b\17\7\2\u00c7#\3\2\2\2\u00c8\u00ca\5\\,\2\u00c9\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\b\20\3\2\u00ce%\3\2\2\2\u00cf\u00d0\13\2\2"+
		"\2\u00d0\'\3\2\2\2\u00d1\u00d2\7*\2\2\u00d2\u00d3\b\22\b\2\u00d3)\3\2"+
		"\2\2\u00d4\u00d5\7+\2\2\u00d5\u00d6\b\23\t\2\u00d6+\3\2\2\2\u00d7\u00dc"+
		"\5`.\2\u00d8\u00db\5^-\2\u00d9\u00db\5`.\2\u00da\u00d8\3\2\2\2\u00da\u00d9"+
		"\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\b\24\n\2\u00e0-\3\2\2\2"+
		"\u00e1\u00e2\7\60\2\2\u00e2/\3\2\2\2\u00e3\u00e5\5^-\2\u00e4\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\61\3\2\2\2\u00e8\u00ec\7)\2\2\u00e9\u00eb\n\3\2\2\u00ea\u00e9\3\2\2\2"+
		"\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7)\2\2\u00f0\63\3\2\2\2\u00f1"+
		"\u00f7\t\4\2\2\u00f2\u00f3\7?\2\2\u00f3\u00f7\7?\2\2\u00f4\u00f5\7#\2"+
		"\2\u00f5\u00f7\7?\2\2\u00f6\u00f1\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f7\65\3\2\2\2\u00f8\u00fa\5\\,\2\u00f9\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00fe\b\31\3\2\u00fe\67\3\2\2\2\u00ff\u0100\13\2\2\2\u0100"+
		"9\3\2\2\2\u0101\u0102\7\60\2\2\u0102\u0103\7\60\2\2\u0103\u0104\7\60\2"+
		"\2\u0104;\3\2\2\2\u0105\u0106\7-\2\2\u0106\u0107\b\34\13\2\u0107=\3\2"+
		"\2\2\u0108\u0109\7&\2\2\u0109\u010a\7\u0080\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u010c\b\35\f\2\u010c?\3\2\2\2\u010d\u0111\7]\2\2\u010e\u0110\n\5\2\2"+
		"\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7_\2\2\u0115"+
		"\u0116\b\36\r\2\u0116A\3\2\2\2\u0117\u011c\5`.\2\u0118\u011b\5^-\2\u0119"+
		"\u011b\5`.\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2"+
		"\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u011c"+
		"\3\2\2\2\u011f\u0120\b\37\16\2\u0120C\3\2\2\2\u0121\u0122\13\2\2\2\u0122"+
		"E\3\2\2\2\u0123\u0124\7&\2\2\u0124\u0125\7\u0080\2\2\u0125\u0126\3\2\2"+
		"\2\u0126\u0127\b!\3\2\u0127G\3\2\2\2\u0128\u0129\7&\2\2\u0129\u012f\7"+
		"&\2\2\u012a\u012b\7&\2\2\u012b\u012f\7]\2\2\u012c\u012d\7&\2\2\u012d\u012f"+
		"\7_\2\2\u012e\u0128\3\2\2\2\u012e\u012a\3\2\2\2\u012e\u012c\3\2\2\2\u012f"+
		"I\3\2\2\2\u0130\u0131\7&\2\2\u0131\u0132\b#\17\2\u0132K\3\2\2\2\u0133"+
		"\u0134\7]\2\2\u0134\u0135\b$\20\2\u0135M\3\2\2\2\u0136\u0137\7\u0080\2"+
		"\2\u0137\u0138\b%\21\2\u0138O\3\2\2\2\u0139\u013b\n\6\2\2\u013a\u0139"+
		"\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\b&\22\2\u0140Q\3\2\2\2"+
		"\u0141\u0142\7_\2\2\u0142\u0143\b\'\23\2\u0143\u0144\3\2\2\2\u0144\u0145"+
		"\b\'\7\2\u0145S\3\2\2\2\u0146\u0147\7&\2\2\u0147\u0151\7&\2\2\u0148\u0149"+
		"\7&\2\2\u0149\u0151\7]\2\2\u014a\u014b\7&\2\2\u014b\u0151\7_\2\2\u014c"+
		"\u014d\7&\2\2\u014d\u014e\7\u0080\2\2\u014e\u014f\3\2\2\2\u014f\u0151"+
		"\b(\24\2\u0150\u0146\3\2\2\2\u0150\u0148\3\2\2\2\u0150\u014a\3\2\2\2\u0150"+
		"\u014c\3\2\2\2\u0151U\3\2\2\2\u0152\u0153\7&\2\2\u0153\u0154\b)\25\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0156\b)\26\2\u0156W\3\2\2\2\u0157\u0159\n\7\2\2"+
		"\u0158\u0157\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\b*\27\2\u015e"+
		"Y\3\2\2\2\u015f\u0161\7\17\2\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2"+
		"\u0161\u0162\3\2\2\2\u0162\u0165\7\f\2\2\u0163\u0165\7\f\2\2\u0164\u0160"+
		"\3\2\2\2\u0164\u0163\3\2\2\2\u0165[\3\2\2\2\u0166\u0167\t\2\2\2\u0167"+
		"]\3\2\2\2\u0168\u0169\t\b\2\2\u0169_\3\2\2\2\u016a\u016b\t\t\2\2\u016b"+
		"a\3\2\2\2\"\2\3\4\5\6\7osw~\u0080\u00b0\u00b2\u00ba\u00be\u00c2\u00cb"+
		"\u00da\u00dc\u00e6\u00ec\u00f6\u00fb\u0111\u011a\u011c\u012e\u013c\u0150"+
		"\u015a\u0160\u0164\30\3\2\2\b\2\2\3\f\3\3\16\4\3\17\5\4\6\2\3\22\6\3\23"+
		"\7\3\24\b\3\34\t\3\35\n\3\36\13\3\37\f\3#\r\3$\16\3%\17\3&\20\3\'\21\3"+
		"(\22\3)\23\4\5\2\3*\24";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}