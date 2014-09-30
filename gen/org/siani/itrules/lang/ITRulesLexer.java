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
		MARK_OPTION=17, END=18, SEPARATOR=19, MARK_ID=20, MARK_ERROR=21, SCAPED_CHAR=22, 
		MARK_KEY=23, LEFT_SQ=24, RULE_END=25, RULE_TEXT=26, RIGHT_SQ=27, EXP_SCAPED_CHAR=28, 
		EXPRESSION_MARK=29, EXPRESSION_TEXT=30;
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
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'"
	};
	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "ID", "TEXT", "OPTION", "LEFT_P", "RIGHT_P", "TYPE", 
		"TRIGGER", "ATTR", "NOT", "RULE_ID", "NL", "WS", "RULE_ERROR", "LIST", 
		"MARK_OPTION", "END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "SCAPED_CHAR", 
		"MARK_KEY", "LEFT_SQ", "RULE_END", "RULE_TEXT", "RIGHT_SQ", "EXP_SCAPED_CHAR", 
		"EXPRESSION_MARK", "EXPRESSION_TEXT", "LN", "SP", "DIGIT", "LETTER"
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
		case 11: RULE_ID_action((RuleContext)_localctx, actionIndex); break;
		case 12: NL_action((RuleContext)_localctx, actionIndex); break;
		case 16: MARK_OPTION_action((RuleContext)_localctx, actionIndex); break;
		case 17: END_action((RuleContext)_localctx, actionIndex); break;
		case 18: SEPARATOR_action((RuleContext)_localctx, actionIndex); break;
		case 19: MARK_ID_action((RuleContext)_localctx, actionIndex); break;
		case 22: MARK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 23: LEFT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 24: RULE_END_action((RuleContext)_localctx, actionIndex); break;
		case 25: RULE_TEXT_action((RuleContext)_localctx, actionIndex); break;
		case 26: RIGHT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 27: EXP_SCAPED_CHAR_action((RuleContext)_localctx, actionIndex); break;
		case 28: EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); break;
		case 29: EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void RULE_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  setType(ID); break;
		}
	}
	private void MARK_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:  setType(ID); exitMark(); break;
		}
	}
	private void RULE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: setMode(DEFAULT_MODE); setLastMode(RULE_BODY); break;
		}
	}
	private void RULE_BEGIN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  setMode(RULE_SIGNATURE); setLastMode(DEFAULT_MODE); break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:  setMode(lastMode); setLastMode(MARK); break;
		}
	}
	private void EXPRESSION_MARK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: setType(MARK_KEY); setLastMode(EXPRESION); break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  setLastMode(RULE_SIGNATURE); break;
		}
	}
	private void RULE_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: setType(TEXT); break;
		}
	}
	private void LEFT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: setMode(EXPRESION); setLastMode(RULE_BODY); break;
		}
	}
	private void END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:  setMode(lastMode); setLastMode(MARK); break;
		}
	}
	private void MARK_OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:  setType(OPTION); break;
		}
	}
	private void RIGHT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: setLastMode(EXPRESION); break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: setType(TEXT); break;
		}
	}
	private void EXP_SCAPED_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: setType(SCAPED_CHAR); break;
		}
	}
	private void MARK_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: setMode(MARK); setLastMode(RULE_BODY); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u011b\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\3\5\3]\n\3\3\3\3\3\5\3a\n\3\3\3\3\3"+
		"\3\4\3\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\7\r\u0093\n\r\f"+
		"\r\16\r\u0096\13\r\3\r\3\r\3\16\7\16\u009b\n\16\f\16\16\16\u009e\13\16"+
		"\3\16\5\16\u00a1\n\16\3\16\3\16\5\16\u00a5\n\16\3\16\3\16\3\16\3\16\3"+
		"\17\6\17\u00ac\n\17\r\17\16\17\u00ad\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\7\24\u00c2\n\24"+
		"\f\24\16\24\u00c5\13\24\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u00cd\n\25"+
		"\f\25\16\25\u00d0\13\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\5\27\u00de\n\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\7\33\u00ea\n\33\f\33\16\33\u00ed\13\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u0100\n\35\3\36\3\36\3\36\3\36\3\36\3\37\7\37\u0108\n\37\f\37\16\37\u010b"+
		"\13\37\3\37\3\37\3 \5 \u0110\n \3 \3 \5 \u0114\n \3!\3!\3\"\3\"\3#\3#"+
		"\2\2$\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17"+
		"!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36"+
		"?\37A C\2E\2G\2I\2\7\2\3\4\5\6\b\4\2\13\13\"\"\3\2__\5\2&&]]\u0080\u0080"+
		"\5\2&&]]__\3\2\62;\4\2C\\c|\u012a\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\3\17\3\2\2\2\3\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27"+
		"\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3\2\2"+
		"\2\3#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2\2\2"+
		"\4/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\59\3\2"+
		"\2\2\6;\3\2\2\2\6=\3\2\2\2\6?\3\2\2\2\6A\3\2\2\2\7K\3\2\2\2\tX\3\2\2\2"+
		"\13d\3\2\2\2\rn\3\2\2\2\17u\3\2\2\2\21w\3\2\2\2\23y\3\2\2\2\25{\3\2\2"+
		"\2\27\u0080\3\2\2\2\31\u0088\3\2\2\2\33\u008d\3\2\2\2\35\u008f\3\2\2\2"+
		"\37\u009c\3\2\2\2!\u00ab\3\2\2\2#\u00b1\3\2\2\2%\u00b3\3\2\2\2\'\u00b7"+
		"\3\2\2\2)\u00ba\3\2\2\2+\u00bf\3\2\2\2-\u00c9\3\2\2\2/\u00d3\3\2\2\2\61"+
		"\u00dd\3\2\2\2\63\u00df\3\2\2\2\65\u00e2\3\2\2\2\67\u00e5\3\2\2\29\u00eb"+
		"\3\2\2\2;\u00f0\3\2\2\2=\u00ff\3\2\2\2?\u0101\3\2\2\2A\u0109\3\2\2\2C"+
		"\u0113\3\2\2\2E\u0115\3\2\2\2G\u0117\3\2\2\2I\u0119\3\2\2\2KL\7f\2\2L"+
		"M\7g\2\2MN\7h\2\2NO\7t\2\2OP\7w\2\2PQ\7n\2\2QR\7g\2\2RS\3\2\2\2ST\b\2"+
		"\2\2T\b\3\2\2\2UW\t\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y`\3"+
		"\2\2\2ZX\3\2\2\2[]\7\17\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^a\7\f\2\2"+
		"_a\7\f\2\2`\\\3\2\2\2`_\3\2\2\2ab\3\2\2\2bc\b\3\3\2c\n\3\2\2\2di\5I#\2"+
		"eh\5G\"\2fh\5I#\2ge\3\2\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl"+
		"\3\2\2\2ki\3\2\2\2lm\b\4\3\2m\f\3\2\2\2no\7v\2\2op\7g\2\2pq\7z\2\2qr\7"+
		"v\2\2rs\3\2\2\2st\b\5\3\2t\16\3\2\2\2uv\7-\2\2v\20\3\2\2\2wx\7*\2\2x\22"+
		"\3\2\2\2yz\7+\2\2z\24\3\2\2\2{|\7v\2\2|}\7{\2\2}~\7r\2\2~\177\7g\2\2\177"+
		"\26\3\2\2\2\u0080\u0081\7v\2\2\u0081\u0082\7t\2\2\u0082\u0083\7k\2\2\u0083"+
		"\u0084\7i\2\2\u0084\u0085\7i\2\2\u0085\u0086\7g\2\2\u0086\u0087\7t\2\2"+
		"\u0087\30\3\2\2\2\u0088\u0089\7c\2\2\u0089\u008a\7v\2\2\u008a\u008b\7"+
		"v\2\2\u008b\u008c\7t\2\2\u008c\32\3\2\2\2\u008d\u008e\7#\2\2\u008e\34"+
		"\3\2\2\2\u008f\u0094\5I#\2\u0090\u0093\5G\"\2\u0091\u0093\5I#\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u0098\b\r\4\2\u0098\36\3\2\2\2\u0099\u009b\t\2\2\2\u009a\u0099\3\2\2"+
		"\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a4"+
		"\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\7\17\2\2\u00a0\u009f\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a5\7\f\2\2\u00a3\u00a5"+
		"\7\f\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\b\16\5\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\16\6\2\u00a9 \3\2\2"+
		"\2\u00aa\u00ac\5E!\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\17\3\2"+
		"\u00b0\"\3\2\2\2\u00b1\u00b2\13\2\2\2\u00b2$\3\2\2\2\u00b3\u00b4\7\60"+
		"\2\2\u00b4\u00b5\7\60\2\2\u00b5\u00b6\7\60\2\2\u00b6&\3\2\2\2\u00b7\u00b8"+
		"\7-\2\2\u00b8\u00b9\b\22\7\2\u00b9(\3\2\2\2\u00ba\u00bb\7&\2\2\u00bb\u00bc"+
		"\7\u0080\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\b\23\b\2\u00be*\3\2\2\2\u00bf"+
		"\u00c3\7]\2\2\u00c0\u00c2\n\3\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c7\7_\2\2\u00c7\u00c8\b\24\t\2\u00c8,\3\2\2\2"+
		"\u00c9\u00ce\5I#\2\u00ca\u00cd\5G\"\2\u00cb\u00cd\5I#\2\u00cc\u00ca\3"+
		"\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\b\25"+
		"\n\2\u00d2.\3\2\2\2\u00d3\u00d4\13\2\2\2\u00d4\60\3\2\2\2\u00d5\u00d6"+
		"\7&\2\2\u00d6\u00de\7&\2\2\u00d7\u00d8\7&\2\2\u00d8\u00de\7]\2\2\u00d9"+
		"\u00da\7&\2\2\u00da\u00de\7_\2\2\u00db\u00dc\7&\2\2\u00dc\u00de\7\u0080"+
		"\2\2\u00dd\u00d5\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d9\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\62\3\2\2\2\u00df\u00e0\7&\2\2\u00e0\u00e1\b\30\13"+
		"\2\u00e1\64\3\2\2\2\u00e2\u00e3\7]\2\2\u00e3\u00e4\b\31\f\2\u00e4\66\3"+
		"\2\2\2\u00e5\u00e6\7\u0080\2\2\u00e6\u00e7\b\32\r\2\u00e78\3\2\2\2\u00e8"+
		"\u00ea\n\4\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00ef\b\33\16\2\u00ef:\3\2\2\2\u00f0\u00f1\7_\2\2\u00f1\u00f2\b\34\17"+
		"\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b\34\6\2\u00f4<\3\2\2\2\u00f5\u00f6"+
		"\7&\2\2\u00f6\u0100\7&\2\2\u00f7\u00f8\7&\2\2\u00f8\u0100\7]\2\2\u00f9"+
		"\u00fa\7&\2\2\u00fa\u0100\7_\2\2\u00fb\u00fc\7&\2\2\u00fc\u00fd\7\u0080"+
		"\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\b\35\20\2\u00ff\u00f5\3\2\2\2\u00ff"+
		"\u00f7\3\2\2\2\u00ff\u00f9\3\2\2\2\u00ff\u00fb\3\2\2\2\u0100>\3\2\2\2"+
		"\u0101\u0102\7&\2\2\u0102\u0103\b\36\21\2\u0103\u0104\3\2\2\2\u0104\u0105"+
		"\b\36\22\2\u0105@\3\2\2\2\u0106\u0108\n\5\2\2\u0107\u0106\3\2\2\2\u0108"+
		"\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2"+
		"\2\2\u010b\u0109\3\2\2\2\u010c\u010d\b\37\23\2\u010dB\3\2\2\2\u010e\u0110"+
		"\7\17\2\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2"+
		"\u0111\u0114\7\f\2\2\u0112\u0114\7\f\2\2\u0113\u010f\3\2\2\2\u0113\u0112"+
		"\3\2\2\2\u0114D\3\2\2\2\u0115\u0116\t\2\2\2\u0116F\3\2\2\2\u0117\u0118"+
		"\t\6\2\2\u0118H\3\2\2\2\u0119\u011a\t\7\2\2\u011aJ\3\2\2\2\33\2\3\4\5"+
		"\6X\\`gi\u0092\u0094\u009c\u00a0\u00a4\u00ad\u00c3\u00cc\u00ce\u00dd\u00eb"+
		"\u00ff\u0109\u010f\u0113\24\3\2\2\b\2\2\3\r\3\3\16\4\4\5\2\3\22\5\3\23"+
		"\6\3\24\7\3\25\b\3\30\t\3\31\n\3\32\13\3\33\f\3\34\r\3\35\16\3\36\17\4"+
		"\4\2\3\37\20";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}