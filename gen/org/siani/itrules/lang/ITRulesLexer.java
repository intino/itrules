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
		TRIGGER=9, ATTR=10, EVAL=11, NOT=12, RULE_ID=13, NL=14, WS=15, RULE_ERROR=16, 
		EVAL_LEFT_P=17, EVAL_RIGHT_P=18, EVAL_ID=19, DOT=20, NUMBER=21, STRING=22, 
		OPERATOR=23, E_WS=24, EVAL_ERROR=25, LIST=26, MARK_OPTION=27, END=28, 
		SEPARATOR=29, MARK_ID=30, MARK_ERROR=31, SCAPED_CHAR=32, MARK_KEY=33, 
		LEFT_SQ=34, RULE_END=35, RULE_TEXT=36, RIGHT_SQ=37, EXP_SCAPED_CHAR=38, 
		EXPRESSION_MARK=39, EXPRESSION_TEXT=40;
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
		"'('"
	};
	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "ID", "TEXT", "OPTION", "LEFT_P", "RIGHT_P", "TYPE", 
		"TRIGGER", "ATTR", "EVAL", "NOT", "RULE_ID", "NL", "WS", "RULE_ERROR", 
		"EVAL_LEFT_P", "EVAL_RIGHT_P", "EVAL_ID", "DOT", "NUMBER", "STRING", "OPERATOR", 
		"E_WS", "EVAL_ERROR", "LIST", "MARK_OPTION", "END", "SEPARATOR", "MARK_ID", 
		"MARK_ERROR", "SCAPED_CHAR", "MARK_KEY", "LEFT_SQ", "RULE_END", "RULE_TEXT", 
		"RIGHT_SQ", "EXP_SCAPED_CHAR", "EXPRESSION_MARK", "EXPRESSION_TEXT", "LN", 
		"SP", "DIGIT", "LETTER"
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
		case 32: MARK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 33: LEFT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 34: RULE_END_action((RuleContext)_localctx, actionIndex); break;
		case 35: RULE_TEXT_action((RuleContext)_localctx, actionIndex); break;
		case 36: RIGHT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 37: EXP_SCAPED_CHAR_action((RuleContext)_localctx, actionIndex); break;
		case 38: EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); break;
		case 39: EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u0167\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t"+
		"\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t"+
		"(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\7\3l\n\3\f\3\16\3o\13\3\3\3\5\3r\n\3\3\3\3\3\5\3v\n\3\3\3\3\3\3"+
		"\4\3\4\3\4\7\4}\n\4\f\4\16\4\u0080\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\16\7\16\u00af\n\16\f\16\16\16\u00b2\13\16\3\16\3\16\3"+
		"\17\7\17\u00b7\n\17\f\17\16\17\u00ba\13\17\3\17\5\17\u00bd\n\17\3\17\3"+
		"\17\5\17\u00c1\n\17\3\17\3\17\3\17\3\17\3\20\6\20\u00c8\n\20\r\20\16\20"+
		"\u00c9\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\7\24\u00d9\n\24\f\24\16\24\u00dc\13\24\3\24\3\24\3\25\3\25\3\26\6\26"+
		"\u00e3\n\26\r\26\16\26\u00e4\3\27\3\27\7\27\u00e9\n\27\f\27\16\27\u00ec"+
		"\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u00f5\n\30\3\31\6\31\u00f8"+
		"\n\31\r\31\16\31\u00f9\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\7\36\u010e\n\36\f\36\16\36"+
		"\u0111\13\36\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u0119\n\37\f\37\16\37"+
		"\u011c\13\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\5!\u012a\n!\3\"\3"+
		"\"\3\"\3#\3#\3#\3$\3$\3$\3%\7%\u0136\n%\f%\16%\u0139\13%\3%\3%\3&\3&\3"+
		"&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u014c\n\'\3(\3(\3"+
		"(\3(\3(\3)\7)\u0154\n)\f)\16)\u0157\13)\3)\3)\3*\5*\u015c\n*\3*\3*\5*"+
		"\u0160\n*\3+\3+\3,\3,\3-\3-\2\2.\b\3\n\4\f\5\16\6\20\7\22\b\24\t\26\n"+
		"\30\13\32\f\34\r\36\16 \17\"\20$\21&\22(\23*\24,\25.\26\60\27\62\30\64"+
		"\31\66\328\33:\34<\35>\36@\37B D!F\"H#J$L%N&P\'R(T)V*X\2Z\2\\\2^\2\b\2"+
		"\3\4\5\6\7\n\4\2\13\13\"\"\3\2))\4\2>>@@\3\2__\5\2&&]]\u0080\u0080\5\2"+
		"&&]]__\3\2\62;\4\2C\\c|\u017c\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16"+
		"\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2\2\2\3\30\3\2"+
		"\2\2\3\32\3\2\2\2\3\34\3\2\2\2\3\36\3\2\2\2\3 \3\2\2\2\3\"\3\2\2\2\3$"+
		"\3\2\2\2\3&\3\2\2\2\4(\3\2\2\2\4*\3\2\2\2\4,\3\2\2\2\4.\3\2\2\2\4\60\3"+
		"\2\2\2\4\62\3\2\2\2\4\64\3\2\2\2\4\66\3\2\2\2\48\3\2\2\2\5:\3\2\2\2\5"+
		"<\3\2\2\2\5>\3\2\2\2\5@\3\2\2\2\5B\3\2\2\2\5D\3\2\2\2\6F\3\2\2\2\6H\3"+
		"\2\2\2\6J\3\2\2\2\6L\3\2\2\2\6N\3\2\2\2\7P\3\2\2\2\7R\3\2\2\2\7T\3\2\2"+
		"\2\7V\3\2\2\2\b`\3\2\2\2\nm\3\2\2\2\fy\3\2\2\2\16\u0083\3\2\2\2\20\u008a"+
		"\3\2\2\2\22\u008c\3\2\2\2\24\u008e\3\2\2\2\26\u0090\3\2\2\2\30\u0095\3"+
		"\2\2\2\32\u009d\3\2\2\2\34\u00a2\3\2\2\2\36\u00a9\3\2\2\2 \u00ab\3\2\2"+
		"\2\"\u00b8\3\2\2\2$\u00c7\3\2\2\2&\u00cd\3\2\2\2(\u00cf\3\2\2\2*\u00d2"+
		"\3\2\2\2,\u00d5\3\2\2\2.\u00df\3\2\2\2\60\u00e2\3\2\2\2\62\u00e6\3\2\2"+
		"\2\64\u00f4\3\2\2\2\66\u00f7\3\2\2\28\u00fd\3\2\2\2:\u00ff\3\2\2\2<\u0103"+
		"\3\2\2\2>\u0106\3\2\2\2@\u010b\3\2\2\2B\u0115\3\2\2\2D\u011f\3\2\2\2F"+
		"\u0129\3\2\2\2H\u012b\3\2\2\2J\u012e\3\2\2\2L\u0131\3\2\2\2N\u0137\3\2"+
		"\2\2P\u013c\3\2\2\2R\u014b\3\2\2\2T\u014d\3\2\2\2V\u0155\3\2\2\2X\u015f"+
		"\3\2\2\2Z\u0161\3\2\2\2\\\u0163\3\2\2\2^\u0165\3\2\2\2`a\7f\2\2ab\7g\2"+
		"\2bc\7h\2\2cd\7t\2\2de\7w\2\2ef\7n\2\2fg\7g\2\2gh\3\2\2\2hi\b\2\2\2i\t"+
		"\3\2\2\2jl\t\2\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nu\3\2\2\2o"+
		"m\3\2\2\2pr\7\17\2\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2sv\7\f\2\2tv\7\f\2\2"+
		"uq\3\2\2\2ut\3\2\2\2vw\3\2\2\2wx\b\3\3\2x\13\3\2\2\2y~\5^-\2z}\5\\,\2"+
		"{}\5^-\2|z\3\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\b\4\3\2\u0082\r\3\2\2\2\u0083"+
		"\u0084\7v\2\2\u0084\u0085\7g\2\2\u0085\u0086\7z\2\2\u0086\u0087\7v\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\u0089\b\5\3\2\u0089\17\3\2\2\2\u008a\u008b"+
		"\7-\2\2\u008b\21\3\2\2\2\u008c\u008d\7*\2\2\u008d\23\3\2\2\2\u008e\u008f"+
		"\7+\2\2\u008f\25\3\2\2\2\u0090\u0091\7v\2\2\u0091\u0092\7{\2\2\u0092\u0093"+
		"\7r\2\2\u0093\u0094\7g\2\2\u0094\27\3\2\2\2\u0095\u0096\7v\2\2\u0096\u0097"+
		"\7t\2\2\u0097\u0098\7k\2\2\u0098\u0099\7i\2\2\u0099\u009a\7i\2\2\u009a"+
		"\u009b\7g\2\2\u009b\u009c\7t\2\2\u009c\31\3\2\2\2\u009d\u009e\7c\2\2\u009e"+
		"\u009f\7v\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7t\2\2\u00a1\33\3\2\2\2\u00a2"+
		"\u00a3\7g\2\2\u00a3\u00a4\7x\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7n\2\2"+
		"\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\f\4\2\u00a8\35\3\2\2\2\u00a9\u00aa"+
		"\7#\2\2\u00aa\37\3\2\2\2\u00ab\u00b0\5^-\2\u00ac\u00af\5\\,\2\u00ad\u00af"+
		"\5^-\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b4\b\16\5\2\u00b4!\3\2\2\2\u00b5\u00b7\t\2\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00c0\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\7\17\2\2\u00bc\u00bb\3"+
		"\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\7\f\2\2\u00bf"+
		"\u00c1\7\f\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\b\17\6\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\17\7\2\u00c5"+
		"#\3\2\2\2\u00c6\u00c8\5Z+\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\20"+
		"\3\2\u00cc%\3\2\2\2\u00cd\u00ce\13\2\2\2\u00ce\'\3\2\2\2\u00cf\u00d0\7"+
		"*\2\2\u00d0\u00d1\b\22\b\2\u00d1)\3\2\2\2\u00d2\u00d3\7+\2\2\u00d3\u00d4"+
		"\b\23\t\2\u00d4+\3\2\2\2\u00d5\u00da\5^-\2\u00d6\u00d9\5\\,\2\u00d7\u00d9"+
		"\5^-\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dd\u00de\b\24\n\2\u00de-\3\2\2\2\u00df\u00e0\7\60\2\2\u00e0/\3"+
		"\2\2\2\u00e1\u00e3\5\\,\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\61\3\2\2\2\u00e6\u00ea\7)\2\2"+
		"\u00e7\u00e9\n\3\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed"+
		"\u00ee\7)\2\2\u00ee\63\3\2\2\2\u00ef\u00f5\t\4\2\2\u00f0\u00f1\7?\2\2"+
		"\u00f1\u00f5\7?\2\2\u00f2\u00f3\7#\2\2\u00f3\u00f5\7?\2\2\u00f4\u00ef"+
		"\3\2\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\65\3\2\2\2\u00f6"+
		"\u00f8\5Z+\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2"+
		"\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\31\3\2\u00fc"+
		"\67\3\2\2\2\u00fd\u00fe\13\2\2\2\u00fe9\3\2\2\2\u00ff\u0100\7\60\2\2\u0100"+
		"\u0101\7\60\2\2\u0101\u0102\7\60\2\2\u0102;\3\2\2\2\u0103\u0104\7-\2\2"+
		"\u0104\u0105\b\34\13\2\u0105=\3\2\2\2\u0106\u0107\7&\2\2\u0107\u0108\7"+
		"\u0080\2\2\u0108\u0109\3\2\2\2\u0109\u010a\b\35\f\2\u010a?\3\2\2\2\u010b"+
		"\u010f\7]\2\2\u010c\u010e\n\5\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0112\u0113\7_\2\2\u0113\u0114\b\36\r\2\u0114A\3\2\2\2"+
		"\u0115\u011a\5^-\2\u0116\u0119\5\\,\2\u0117\u0119\5^-\2\u0118\u0116\3"+
		"\2\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\b\37"+
		"\16\2\u011eC\3\2\2\2\u011f\u0120\13\2\2\2\u0120E\3\2\2\2\u0121\u0122\7"+
		"&\2\2\u0122\u012a\7&\2\2\u0123\u0124\7&\2\2\u0124\u012a\7]\2\2\u0125\u0126"+
		"\7&\2\2\u0126\u012a\7_\2\2\u0127\u0128\7&\2\2\u0128\u012a\7\u0080\2\2"+
		"\u0129\u0121\3\2\2\2\u0129\u0123\3\2\2\2\u0129\u0125\3\2\2\2\u0129\u0127"+
		"\3\2\2\2\u012aG\3\2\2\2\u012b\u012c\7&\2\2\u012c\u012d\b\"\17\2\u012d"+
		"I\3\2\2\2\u012e\u012f\7]\2\2\u012f\u0130\b#\20\2\u0130K\3\2\2\2\u0131"+
		"\u0132\7\u0080\2\2\u0132\u0133\b$\21\2\u0133M\3\2\2\2\u0134\u0136\n\6"+
		"\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\b%"+
		"\22\2\u013bO\3\2\2\2\u013c\u013d\7_\2\2\u013d\u013e\b&\23\2\u013e\u013f"+
		"\3\2\2\2\u013f\u0140\b&\7\2\u0140Q\3\2\2\2\u0141\u0142\7&\2\2\u0142\u014c"+
		"\7&\2\2\u0143\u0144\7&\2\2\u0144\u014c\7]\2\2\u0145\u0146\7&\2\2\u0146"+
		"\u014c\7_\2\2\u0147\u0148\7&\2\2\u0148\u0149\7\u0080\2\2\u0149\u014a\3"+
		"\2\2\2\u014a\u014c\b\'\24\2\u014b\u0141\3\2\2\2\u014b\u0143\3\2\2\2\u014b"+
		"\u0145\3\2\2\2\u014b\u0147\3\2\2\2\u014cS\3\2\2\2\u014d\u014e\7&\2\2\u014e"+
		"\u014f\b(\25\2\u014f\u0150\3\2\2\2\u0150\u0151\b(\26\2\u0151U\3\2\2\2"+
		"\u0152\u0154\n\7\2\2\u0153\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u0159\b)\27\2\u0159W\3\2\2\2\u015a\u015c\7\17\2\2\u015b\u015a\3\2\2\2"+
		"\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0160\7\f\2\2\u015e\u0160"+
		"\7\f\2\2\u015f\u015b\3\2\2\2\u015f\u015e\3\2\2\2\u0160Y\3\2\2\2\u0161"+
		"\u0162\t\2\2\2\u0162[\3\2\2\2\u0163\u0164\t\b\2\2\u0164]\3\2\2\2\u0165"+
		"\u0166\t\t\2\2\u0166_\3\2\2\2\"\2\3\4\5\6\7mqu|~\u00ae\u00b0\u00b8\u00bc"+
		"\u00c0\u00c9\u00d8\u00da\u00e4\u00ea\u00f4\u00f9\u010f\u0118\u011a\u0129"+
		"\u0137\u014b\u0155\u015b\u015f\30\3\2\2\b\2\2\3\f\3\3\16\4\3\17\5\4\6"+
		"\2\3\22\6\3\23\7\3\24\b\3\34\t\3\35\n\3\36\13\3\37\f\3\"\r\3#\16\3$\17"+
		"\3%\20\3&\21\3\'\22\3(\23\4\5\2\3)\24";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}