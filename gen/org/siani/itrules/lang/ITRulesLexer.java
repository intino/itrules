// Generated from /Users/oroncal/workspace/sandbox/itrules/src/org/siani/itrules/lang/ITRulesLexer.g4 by ANTLR 4.4.1-dev
package org.siani.itrules.lang;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ITRulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_BEGIN=1, WL=2, ID=3, TEXT=4, OPTION=5, LEFT_P=6, RIGHT_P=7, TYPE=8, 
		TRIGGER=9, ATTR=10, NOT=11, RULE_ID=12, NL=13, WS=14, RULE_ERROR=15, LIST=16, 
		MARK_OPTION=17, FORMAT=18, MARK_LEFT_P=19, MARK_RIGHT_P=20, SEPARATOR=21, 
		FORMAT_REGEX=22, MARK_ID=23, MARK_ERROR=24, SCAPED_CHAR=25, MARK_KEY=26, 
		LEFT_SQ=27, RULE_END=28, RULE_TEXT=29, RIGHT_SQ=30, EXP_SCAPED_CHAR=31, 
		EXPRESSION_MARK=32, EXPRESSION_TEXT=33;
	public static final int RULE_SIGNATURE = 1;
	public static final int MARK = 2;
	public static final int RULE_BODY = 3;
	public static final int EXPRESION = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "RULE_SIGNATURE", "MARK", "RULE_BODY", "EXPRESION"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'"
	};
	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "ID", "TEXT", "OPTION", "LEFT_P", "RIGHT_P", "TYPE", 
		"TRIGGER", "ATTR", "NOT", "RULE_ID", "NL", "WS", "RULE_ERROR", "LIST", 
		"MARK_OPTION", "FORMAT", "MARK_LEFT_P", "MARK_RIGHT_P", "SEPARATOR", "FORMAT_REGEX", 
		"MARK_ID", "MARK_ERROR", "SCAPED_CHAR", "MARK_KEY", "LEFT_SQ", "RULE_END", 
		"RULE_TEXT", "RIGHT_SQ", "EXP_SCAPED_CHAR", "EXPRESSION_MARK", "EXPRESSION_TEXT", 
		"LN", "SP", "DIGIT", "LETTER"
	};


		int lastMode = 0;
		boolean informat = false;
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
	        return (informat || c == '+' || list.equals("..."));
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
		case 11: RULE_ID_action((RuleContext)_localctx, actionIndex); break;
		case 12: NL_action((RuleContext)_localctx, actionIndex); break;
		case 16: MARK_OPTION_action((RuleContext)_localctx, actionIndex); break;
		case 17: FORMAT_action((RuleContext)_localctx, actionIndex); break;
		case 18: MARK_LEFT_P_action((RuleContext)_localctx, actionIndex); break;
		case 19: MARK_RIGHT_P_action((RuleContext)_localctx, actionIndex); break;
		case 20: SEPARATOR_action((RuleContext)_localctx, actionIndex); break;
		case 22: MARK_ID_action((RuleContext)_localctx, actionIndex); break;
		case 25: MARK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 26: LEFT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 27: RULE_END_action((RuleContext)_localctx, actionIndex); break;
		case 28: RULE_TEXT_action((RuleContext)_localctx, actionIndex); break;
		case 29: RIGHT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 30: EXP_SCAPED_CHAR_action((RuleContext)_localctx, actionIndex); break;
		case 31: EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); break;
		case 32: EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void RULE_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  setType(ID); break;
		}
	}
	private void MARK_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:  setType(ID); exitMark(); break;
		}
	}
	private void RULE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: setMode(DEFAULT_MODE); setLastMode(RULE_BODY); break;
		}
	}
	private void RULE_BEGIN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  setMode(RULE_SIGNATURE); setLastMode(DEFAULT_MODE); break;
		}
	}
	private void MARK_LEFT_P_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:  setType(LEFT_P); break;
		}
	}
	private void MARK_RIGHT_P_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:  informat = false; setType(RIGHT_P); setMode(lastMode); setLastMode(MARK); break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:  setMode(lastMode); setLastMode(MARK); break;
		}
	}
	private void EXPRESSION_MARK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: setType(MARK_KEY); setLastMode(EXPRESION); break;
		}
	}
	private void RULE_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: setType(TEXT); break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  setLastMode(RULE_SIGNATURE); break;
		}
	}
	private void FORMAT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:  informat = true; break;
		}
	}
	private void LEFT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: setMode(EXPRESION); setLastMode(RULE_BODY); break;
		}
	}
	private void RIGHT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: setLastMode(EXPRESION); break;
		}
	}
	private void MARK_OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:  setType(OPTION); break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: setType(TEXT); break;
		}
	}
	private void EXP_SCAPED_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: setType(SCAPED_CHAR); break;
		}
	}
	private void MARK_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: setMode(MARK); setLastMode(RULE_BODY); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u0134\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3]\n\3\f\3\16\3`\13\3\3\3\5\3c\n\3\3\3\3"+
		"\3\5\3g\n\3\3\3\3\3\3\4\3\4\3\4\7\4n\n\4\f\4\16\4q\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\r\7\r\u0099\n\r\f\r\16\r\u009c\13\r\3\r\3\r\3\16\7\16\u00a1\n\16\f"+
		"\16\16\16\u00a4\13\16\3\16\5\16\u00a7\n\16\3\16\3\16\5\16\u00ab\n\16\3"+
		"\16\3\16\3\16\3\16\3\17\6\17\u00b2\n\17\r\17\16\17\u00b3\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\7\26\u00d2\n\26"+
		"\f\26\16\26\u00d5\13\26\3\26\3\26\3\26\3\27\3\27\7\27\u00dc\n\27\f\27"+
		"\16\27\u00df\13\27\3\27\3\27\3\30\3\30\3\30\7\30\u00e6\n\30\f\30\16\30"+
		"\u00e9\13\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\5\32\u00f7\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36"+
		"\7\36\u0103\n\36\f\36\16\36\u0106\13\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0119\n \3!\3!\3!\3!\3!\3\"\7\""+
		"\u0121\n\"\f\"\16\"\u0124\13\"\3\"\3\"\3#\5#\u0129\n#\3#\3#\5#\u012d\n"+
		"#\3$\3$\3%\3%\3&\3&\2\2\'\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31"+
		"\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32"+
		"\67\339\34;\35=\36?\37A C!E\"G#I\2K\2M\2O\2\7\2\3\4\5\6\t\4\2\13\13\""+
		"\"\3\2__\3\2))\5\2&&]]\u0080\u0080\5\2&&]]__\3\2\62;\4\2C\\c|\u0144\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\3\21\3\2"+
		"\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2"+
		"\3\35\3\2\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2"+
		"\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2\2\2\4/\3\2\2\2\4\61\3\2\2\2\4\63\3\2\2"+
		"\2\4\65\3\2\2\2\5\67\3\2\2\2\59\3\2\2\2\5;\3\2\2\2\5=\3\2\2\2\5?\3\2\2"+
		"\2\6A\3\2\2\2\6C\3\2\2\2\6E\3\2\2\2\6G\3\2\2\2\7Q\3\2\2\2\t^\3\2\2\2\13"+
		"j\3\2\2\2\rt\3\2\2\2\17{\3\2\2\2\21}\3\2\2\2\23\177\3\2\2\2\25\u0081\3"+
		"\2\2\2\27\u0086\3\2\2\2\31\u008e\3\2\2\2\33\u0093\3\2\2\2\35\u0095\3\2"+
		"\2\2\37\u00a2\3\2\2\2!\u00b1\3\2\2\2#\u00b7\3\2\2\2%\u00b9\3\2\2\2\'\u00bd"+
		"\3\2\2\2)\u00c0\3\2\2\2+\u00c9\3\2\2\2-\u00cc\3\2\2\2/\u00cf\3\2\2\2\61"+
		"\u00d9\3\2\2\2\63\u00e2\3\2\2\2\65\u00ec\3\2\2\2\67\u00f6\3\2\2\29\u00f8"+
		"\3\2\2\2;\u00fb\3\2\2\2=\u00fe\3\2\2\2?\u0104\3\2\2\2A\u0109\3\2\2\2C"+
		"\u0118\3\2\2\2E\u011a\3\2\2\2G\u0122\3\2\2\2I\u012c\3\2\2\2K\u012e\3\2"+
		"\2\2M\u0130\3\2\2\2O\u0132\3\2\2\2QR\7f\2\2RS\7g\2\2ST\7h\2\2TU\7t\2\2"+
		"UV\7w\2\2VW\7n\2\2WX\7g\2\2XY\3\2\2\2YZ\b\2\2\2Z\b\3\2\2\2[]\t\2\2\2\\"+
		"[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_f\3\2\2\2`^\3\2\2\2ac\7\17\2"+
		"\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2dg\7\f\2\2eg\7\f\2\2fb\3\2\2\2fe\3\2\2"+
		"\2gh\3\2\2\2hi\b\3\3\2i\n\3\2\2\2jo\5O&\2kn\5M%\2ln\5O&\2mk\3\2\2\2ml"+
		"\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\b\4\3\2s"+
		"\f\3\2\2\2tu\7v\2\2uv\7g\2\2vw\7z\2\2wx\7v\2\2xy\3\2\2\2yz\b\5\3\2z\16"+
		"\3\2\2\2{|\7-\2\2|\20\3\2\2\2}~\7*\2\2~\22\3\2\2\2\177\u0080\7+\2\2\u0080"+
		"\24\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083\7{\2\2\u0083\u0084\7r\2\2\u0084"+
		"\u0085\7g\2\2\u0085\26\3\2\2\2\u0086\u0087\7v\2\2\u0087\u0088\7t\2\2\u0088"+
		"\u0089\7k\2\2\u0089\u008a\7i\2\2\u008a\u008b\7i\2\2\u008b\u008c\7g\2\2"+
		"\u008c\u008d\7t\2\2\u008d\30\3\2\2\2\u008e\u008f\7c\2\2\u008f\u0090\7"+
		"v\2\2\u0090\u0091\7v\2\2\u0091\u0092\7t\2\2\u0092\32\3\2\2\2\u0093\u0094"+
		"\7#\2\2\u0094\34\3\2\2\2\u0095\u009a\5O&\2\u0096\u0099\5M%\2\u0097\u0099"+
		"\5O&\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u009e\b\r\4\2\u009e\36\3\2\2\2\u009f\u00a1\t\2\2\2\u00a0\u009f"+
		"\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00aa\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\7\17\2\2\u00a6\u00a5\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\7\f\2\2\u00a9"+
		"\u00ab\7\f\2\2\u00aa\u00a6\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\b\16\5\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\16\6\2\u00af"+
		" \3\2\2\2\u00b0\u00b2\5K$\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\17"+
		"\3\2\u00b6\"\3\2\2\2\u00b7\u00b8\13\2\2\2\u00b8$\3\2\2\2\u00b9\u00ba\7"+
		"\60\2\2\u00ba\u00bb\7\60\2\2\u00bb\u00bc\7\60\2\2\u00bc&\3\2\2\2\u00bd"+
		"\u00be\7-\2\2\u00be\u00bf\b\22\7\2\u00bf(\3\2\2\2\u00c0\u00c1\7h\2\2\u00c1"+
		"\u00c2\7q\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7o\2\2\u00c4\u00c5\7c\2\2"+
		"\u00c5\u00c6\7v\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\23\b\2\u00c8*\3"+
		"\2\2\2\u00c9\u00ca\7*\2\2\u00ca\u00cb\b\24\t\2\u00cb,\3\2\2\2\u00cc\u00cd"+
		"\7+\2\2\u00cd\u00ce\b\25\n\2\u00ce.\3\2\2\2\u00cf\u00d3\7]\2\2\u00d0\u00d2"+
		"\n\3\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7_"+
		"\2\2\u00d7\u00d8\b\26\13\2\u00d8\60\3\2\2\2\u00d9\u00dd\7)\2\2\u00da\u00dc"+
		"\n\4\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7)"+
		"\2\2\u00e1\62\3\2\2\2\u00e2\u00e7\5O&\2\u00e3\u00e6\5M%\2\u00e4\u00e6"+
		"\5O&\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00ea\u00eb\b\30\f\2\u00eb\64\3\2\2\2\u00ec\u00ed\13\2\2\2\u00ed"+
		"\66\3\2\2\2\u00ee\u00ef\7&\2\2\u00ef\u00f7\7&\2\2\u00f0\u00f1\7&\2\2\u00f1"+
		"\u00f7\7]\2\2\u00f2\u00f3\7&\2\2\u00f3\u00f7\7_\2\2\u00f4\u00f5\7&\2\2"+
		"\u00f5\u00f7\7\u0080\2\2\u00f6\u00ee\3\2\2\2\u00f6\u00f0\3\2\2\2\u00f6"+
		"\u00f2\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f78\3\2\2\2\u00f8\u00f9\7&\2\2\u00f9"+
		"\u00fa\b\33\r\2\u00fa:\3\2\2\2\u00fb\u00fc\7]\2\2\u00fc\u00fd\b\34\16"+
		"\2\u00fd<\3\2\2\2\u00fe\u00ff\7\u0080\2\2\u00ff\u0100\b\35\17\2\u0100"+
		">\3\2\2\2\u0101\u0103\n\5\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2"+
		"\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0107\u0108\b\36\20\2\u0108@\3\2\2\2\u0109\u010a\7_\2\2\u010a"+
		"\u010b\b\37\21\2\u010b\u010c\3\2\2\2\u010c\u010d\b\37\6\2\u010dB\3\2\2"+
		"\2\u010e\u010f\7&\2\2\u010f\u0119\7&\2\2\u0110\u0111\7&\2\2\u0111\u0119"+
		"\7]\2\2\u0112\u0113\7&\2\2\u0113\u0119\7_\2\2\u0114\u0115\7&\2\2\u0115"+
		"\u0116\7\u0080\2\2\u0116\u0117\3\2\2\2\u0117\u0119\b \22\2\u0118\u010e"+
		"\3\2\2\2\u0118\u0110\3\2\2\2\u0118\u0112\3\2\2\2\u0118\u0114\3\2\2\2\u0119"+
		"D\3\2\2\2\u011a\u011b\7&\2\2\u011b\u011c\b!\23\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\b!\24\2\u011eF\3\2\2\2\u011f\u0121\n\6\2\2\u0120\u011f\3\2\2\2"+
		"\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125"+
		"\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\b\"\25\2\u0126H\3\2\2\2\u0127"+
		"\u0129\7\17\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3"+
		"\2\2\2\u012a\u012d\7\f\2\2\u012b\u012d\7\f\2\2\u012c\u0128\3\2\2\2\u012c"+
		"\u012b\3\2\2\2\u012dJ\3\2\2\2\u012e\u012f\t\2\2\2\u012fL\3\2\2\2\u0130"+
		"\u0131\t\7\2\2\u0131N\3\2\2\2\u0132\u0133\t\b\2\2\u0133P\3\2\2\2\34\2"+
		"\3\4\5\6^bfmo\u0098\u009a\u00a2\u00a6\u00aa\u00b3\u00d3\u00dd\u00e5\u00e7"+
		"\u00f6\u0104\u0118\u0122\u0128\u012c\26\3\2\2\b\2\2\3\r\3\3\16\4\4\5\2"+
		"\3\22\5\3\23\6\3\24\7\3\25\b\3\26\t\3\30\n\3\33\13\3\34\f\3\35\r\3\36"+
		"\16\3\37\17\3 \20\3!\21\4\4\2\3\"\22";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}