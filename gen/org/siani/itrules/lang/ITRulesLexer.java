// Generated from /Users/oroncal/workspace/itrules/src/org/siani/itrules/lang/ITRulesLexer.g4 by ANTLR 4.4.1-dev
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
		RULE_BEGIN=1, WL=2, ID=3, TEXT=4, OPTION=5, LEFT_P=6, RIGHT_P=7, COMMA=8, 
		TYPE=9, TRIGGER=10, SLOT_NAME=11, SLOT_TYPE=12, DEEP=13, EVAL=14, NOT=15, 
		RULE_ID=16, NL=17, WS=18, RULE_ERROR=19, EVAL_LEFT_P=20, EVAL_RIGHT_P=21, 
		EVAL_ID=22, DOT=23, NUMBER=24, STRING=25, OPERATOR=26, E_WS=27, EVAL_ERROR=28, 
		LIST=29, MARK_OPTION=30, END=31, SEPARATOR=32, MARK_ID=33, MARK_ERROR=34, 
		NULL_CHAR=35, SCAPED_CHAR=36, MARK_KEY=37, LEFT_SQ=38, RULE_END=39, RULE_TEXT=40, 
		RIGHT_SQ=41, EXP_SCAPED_CHAR=42, EXPRESSION_MARK=43, EXPRESSION_TEXT=44;
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
		"'('", "')'", "'*'", "'+'", "','"
	};
	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "ID", "TEXT", "OPTION", "LEFT_P", "RIGHT_P", "COMMA", 
		"TYPE", "TRIGGER", "SLOT_NAME", "SLOT_TYPE", "DEEP", "EVAL", "NOT", "RULE_ID", 
		"NL", "WS", "RULE_ERROR", "EVAL_LEFT_P", "EVAL_RIGHT_P", "EVAL_ID", "DOT", 
		"NUMBER", "STRING", "OPERATOR", "E_WS", "EVAL_ERROR", "LIST", "MARK_OPTION", 
		"END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "NULL_CHAR", "SCAPED_CHAR", 
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
		case 13: EVAL_action((RuleContext)_localctx, actionIndex); break;
		case 15: RULE_ID_action((RuleContext)_localctx, actionIndex); break;
		case 16: NL_action((RuleContext)_localctx, actionIndex); break;
		case 19: EVAL_LEFT_P_action((RuleContext)_localctx, actionIndex); break;
		case 20: EVAL_RIGHT_P_action((RuleContext)_localctx, actionIndex); break;
		case 21: EVAL_ID_action((RuleContext)_localctx, actionIndex); break;
		case 29: MARK_OPTION_action((RuleContext)_localctx, actionIndex); break;
		case 30: END_action((RuleContext)_localctx, actionIndex); break;
		case 31: SEPARATOR_action((RuleContext)_localctx, actionIndex); break;
		case 32: MARK_ID_action((RuleContext)_localctx, actionIndex); break;
		case 36: MARK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 37: LEFT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 38: RULE_END_action((RuleContext)_localctx, actionIndex); break;
		case 39: RULE_TEXT_action((RuleContext)_localctx, actionIndex); break;
		case 40: RIGHT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 41: EXP_SCAPED_CHAR_action((RuleContext)_localctx, actionIndex); break;
		case 42: EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); break;
		case 43: EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u0188\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t"+
		"\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t"+
		"(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3t\n\3\f\3\16\3w\13\3\3\3\5\3"+
		"z\n\3\3\3\3\3\5\3~\n\3\3\3\3\3\3\4\3\4\3\4\7\4\u0085\n\4\f\4\16\4\u0088"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\7\21\u00cd\n\21\f\21\16\21\u00d0\13\21\3\21\3\21"+
		"\3\22\7\22\u00d5\n\22\f\22\16\22\u00d8\13\22\3\22\5\22\u00db\n\22\3\22"+
		"\3\22\5\22\u00df\n\22\3\22\3\22\3\22\3\22\3\23\6\23\u00e6\n\23\r\23\16"+
		"\23\u00e7\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\7\27\u00f7\n\27\f\27\16\27\u00fa\13\27\3\27\3\27\3\30\3\30\3\31"+
		"\6\31\u0101\n\31\r\31\16\31\u0102\3\32\3\32\7\32\u0107\n\32\f\32\16\32"+
		"\u010a\13\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u0113\n\33\3\34\6"+
		"\34\u0116\n\34\r\34\16\34\u0117\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\7!\u012c\n!\f!\16!\u012f\13!\3!\3"+
		"!\3!\3\"\3\"\3\"\7\"\u0137\n\"\f\"\16\"\u013a\13\"\3\"\3\"\3#\3#\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3%\3%\5%\u014b\n%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3"+
		"(\3)\7)\u0157\n)\f)\16)\u015a\13)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\5+\u016d\n+\3,\3,\3,\3,\3,\3-\7-\u0175\n-\f-\16-\u0178"+
		"\13-\3-\3-\3.\5.\u017d\n.\3.\3.\5.\u0181\n.\3/\3/\3\60\3\60\3\61\3\61"+
		"\2\2\62\b\3\n\4\f\5\16\6\20\7\22\b\24\t\26\n\30\13\32\f\34\r\36\16 \17"+
		"\"\20$\21&\22(\23*\24,\25.\26\60\27\62\30\64\31\66\328\33:\34<\35>\36"+
		"@\37B D!F\"H#J$L%N&P\'R(T)V*X+Z,\\-^.`\2b\2d\2f\2\b\2\3\4\5\6\7\n\4\2"+
		"\13\13\"\"\3\2))\4\2>>@@\3\2__\5\2&&]]\u0080\u0080\5\2&&]]__\3\2\62;\4"+
		"\2C\\c|\u019c\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\3\20\3"+
		"\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2"+
		"\2\3\34\3\2\2\2\3\36\3\2\2\2\3 \3\2\2\2\3\"\3\2\2\2\3$\3\2\2\2\3&\3\2"+
		"\2\2\3(\3\2\2\2\3*\3\2\2\2\3,\3\2\2\2\4.\3\2\2\2\4\60\3\2\2\2\4\62\3\2"+
		"\2\2\4\64\3\2\2\2\4\66\3\2\2\2\48\3\2\2\2\4:\3\2\2\2\4<\3\2\2\2\4>\3\2"+
		"\2\2\5@\3\2\2\2\5B\3\2\2\2\5D\3\2\2\2\5F\3\2\2\2\5H\3\2\2\2\5J\3\2\2\2"+
		"\6L\3\2\2\2\6N\3\2\2\2\6P\3\2\2\2\6R\3\2\2\2\6T\3\2\2\2\6V\3\2\2\2\7X"+
		"\3\2\2\2\7Z\3\2\2\2\7\\\3\2\2\2\7^\3\2\2\2\bh\3\2\2\2\nu\3\2\2\2\f\u0081"+
		"\3\2\2\2\16\u008b\3\2\2\2\20\u0092\3\2\2\2\22\u0094\3\2\2\2\24\u0096\3"+
		"\2\2\2\26\u0098\3\2\2\2\30\u009a\3\2\2\2\32\u009f\3\2\2\2\34\u00a7\3\2"+
		"\2\2\36\u00b1\3\2\2\2 \u00bb\3\2\2\2\"\u00c0\3\2\2\2$\u00c7\3\2\2\2&\u00c9"+
		"\3\2\2\2(\u00d6\3\2\2\2*\u00e5\3\2\2\2,\u00eb\3\2\2\2.\u00ed\3\2\2\2\60"+
		"\u00f0\3\2\2\2\62\u00f3\3\2\2\2\64\u00fd\3\2\2\2\66\u0100\3\2\2\28\u0104"+
		"\3\2\2\2:\u0112\3\2\2\2<\u0115\3\2\2\2>\u011b\3\2\2\2@\u011d\3\2\2\2B"+
		"\u0121\3\2\2\2D\u0124\3\2\2\2F\u0129\3\2\2\2H\u0133\3\2\2\2J\u013d\3\2"+
		"\2\2L\u013f\3\2\2\2N\u014a\3\2\2\2P\u014c\3\2\2\2R\u014f\3\2\2\2T\u0152"+
		"\3\2\2\2V\u0158\3\2\2\2X\u015d\3\2\2\2Z\u016c\3\2\2\2\\\u016e\3\2\2\2"+
		"^\u0176\3\2\2\2`\u0180\3\2\2\2b\u0182\3\2\2\2d\u0184\3\2\2\2f\u0186\3"+
		"\2\2\2hi\7f\2\2ij\7g\2\2jk\7h\2\2kl\7t\2\2lm\7w\2\2mn\7n\2\2no\7g\2\2"+
		"op\3\2\2\2pq\b\2\2\2q\t\3\2\2\2rt\t\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2"+
		"\2uv\3\2\2\2v}\3\2\2\2wu\3\2\2\2xz\7\17\2\2yx\3\2\2\2yz\3\2\2\2z{\3\2"+
		"\2\2{~\7\f\2\2|~\7\f\2\2}y\3\2\2\2}|\3\2\2\2~\177\3\2\2\2\177\u0080\b"+
		"\3\3\2\u0080\13\3\2\2\2\u0081\u0086\5f\61\2\u0082\u0085\5d\60\2\u0083"+
		"\u0085\5f\61\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u008a\b\4\3\2\u008a\r\3\2\2\2\u008b\u008c\7v\2\2"+
		"\u008c\u008d\7g\2\2\u008d\u008e\7z\2\2\u008e\u008f\7v\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0091\b\5\3\2\u0091\17\3\2\2\2\u0092\u0093\7-\2\2\u0093"+
		"\21\3\2\2\2\u0094\u0095\7*\2\2\u0095\23\3\2\2\2\u0096\u0097\7+\2\2\u0097"+
		"\25\3\2\2\2\u0098\u0099\7.\2\2\u0099\27\3\2\2\2\u009a\u009b\7v\2\2\u009b"+
		"\u009c\7{\2\2\u009c\u009d\7r\2\2\u009d\u009e\7g\2\2\u009e\31\3\2\2\2\u009f"+
		"\u00a0\7v\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7i\2\2"+
		"\u00a3\u00a4\7i\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7t\2\2\u00a6\33\3\2"+
		"\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab"+
		"\7v\2\2\u00ab\u00ac\7/\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00af\7o\2\2\u00af\u00b0\7g\2\2\u00b0\35\3\2\2\2\u00b1\u00b2\7u\2\2\u00b2"+
		"\u00b3\7n\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7/\2\2"+
		"\u00b6\u00b7\7v\2\2\u00b7\u00b8\7{\2\2\u00b8\u00b9\7r\2\2\u00b9\u00ba"+
		"\7g\2\2\u00ba\37\3\2\2\2\u00bb\u00bc\7f\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be"+
		"\7g\2\2\u00be\u00bf\7r\2\2\u00bf!\3\2\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2"+
		"\7x\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\b\17\4\2\u00c6#\3\2\2\2\u00c7\u00c8\7#\2\2\u00c8%\3\2\2\2\u00c9"+
		"\u00ce\5f\61\2\u00ca\u00cd\5d\60\2\u00cb\u00cd\5f\61\2\u00cc\u00ca\3\2"+
		"\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\b\21"+
		"\5\2\u00d2\'\3\2\2\2\u00d3\u00d5\t\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00de\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d9\u00db\7\17\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3"+
		"\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00df\7\f\2\2\u00dd\u00df\7\f\2\2\u00de"+
		"\u00da\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b\22"+
		"\6\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\22\7\2\u00e3)\3\2\2\2\u00e4\u00e6"+
		"\5b/\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\23\3\2\u00ea+\3\2\2\2"+
		"\u00eb\u00ec\13\2\2\2\u00ec-\3\2\2\2\u00ed\u00ee\7*\2\2\u00ee\u00ef\b"+
		"\25\b\2\u00ef/\3\2\2\2\u00f0\u00f1\7+\2\2\u00f1\u00f2\b\26\t\2\u00f2\61"+
		"\3\2\2\2\u00f3\u00f8\5f\61\2\u00f4\u00f7\5d\60\2\u00f5\u00f7\5f\61\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb"+
		"\u00fc\b\27\n\2\u00fc\63\3\2\2\2\u00fd\u00fe\7\60\2\2\u00fe\65\3\2\2\2"+
		"\u00ff\u0101\5d\60\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\67\3\2\2\2\u0104\u0108\7)\2\2\u0105"+
		"\u0107\n\3\2\2\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010c\7)\2\2\u010c9\3\2\2\2\u010d\u0113\t\4\2\2\u010e\u010f\7?\2\2\u010f"+
		"\u0113\7?\2\2\u0110\u0111\7#\2\2\u0111\u0113\7?\2\2\u0112\u010d\3\2\2"+
		"\2\u0112\u010e\3\2\2\2\u0112\u0110\3\2\2\2\u0113;\3\2\2\2\u0114\u0116"+
		"\5b/\2\u0115\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\b\34\3\2\u011a=\3\2\2\2"+
		"\u011b\u011c\13\2\2\2\u011c?\3\2\2\2\u011d\u011e\7\60\2\2\u011e\u011f"+
		"\7\60\2\2\u011f\u0120\7\60\2\2\u0120A\3\2\2\2\u0121\u0122\7-\2\2\u0122"+
		"\u0123\b\37\13\2\u0123C\3\2\2\2\u0124\u0125\7&\2\2\u0125\u0126\7\u0080"+
		"\2\2\u0126\u0127\3\2\2\2\u0127\u0128\b \f\2\u0128E\3\2\2\2\u0129\u012d"+
		"\7]\2\2\u012a\u012c\n\5\2\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u0130\u0131\7_\2\2\u0131\u0132\b!\r\2\u0132G\3\2\2\2\u0133\u0138"+
		"\5f\61\2\u0134\u0137\5d\60\2\u0135\u0137\5f\61\2\u0136\u0134\3\2\2\2\u0136"+
		"\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\b\"\16\2\u013c"+
		"I\3\2\2\2\u013d\u013e\13\2\2\2\u013eK\3\2\2\2\u013f\u0140\7&\2\2\u0140"+
		"\u0141\7\u0080\2\2\u0141\u0142\3\2\2\2\u0142\u0143\b$\3\2\u0143M\3\2\2"+
		"\2\u0144\u0145\7&\2\2\u0145\u014b\7&\2\2\u0146\u0147\7&\2\2\u0147\u014b"+
		"\7]\2\2\u0148\u0149\7&\2\2\u0149\u014b\7_\2\2\u014a\u0144\3\2\2\2\u014a"+
		"\u0146\3\2\2\2\u014a\u0148\3\2\2\2\u014bO\3\2\2\2\u014c\u014d\7&\2\2\u014d"+
		"\u014e\b&\17\2\u014eQ\3\2\2\2\u014f\u0150\7]\2\2\u0150\u0151\b\'\20\2"+
		"\u0151S\3\2\2\2\u0152\u0153\7\u0080\2\2\u0153\u0154\b(\21\2\u0154U\3\2"+
		"\2\2\u0155\u0157\n\6\2\2\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2"+
		"\2\2\u015b\u015c\b)\22\2\u015cW\3\2\2\2\u015d\u015e\7_\2\2\u015e\u015f"+
		"\b*\23\2\u015f\u0160\3\2\2\2\u0160\u0161\b*\7\2\u0161Y\3\2\2\2\u0162\u0163"+
		"\7&\2\2\u0163\u016d\7&\2\2\u0164\u0165\7&\2\2\u0165\u016d\7]\2\2\u0166"+
		"\u0167\7&\2\2\u0167\u016d\7_\2\2\u0168\u0169\7&\2\2\u0169\u016a\7\u0080"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\u016d\b+\24\2\u016c\u0162\3\2\2\2\u016c"+
		"\u0164\3\2\2\2\u016c\u0166\3\2\2\2\u016c\u0168\3\2\2\2\u016d[\3\2\2\2"+
		"\u016e\u016f\7&\2\2\u016f\u0170\b,\25\2\u0170\u0171\3\2\2\2\u0171\u0172"+
		"\b,\26\2\u0172]\3\2\2\2\u0173\u0175\n\7\2\2\u0174\u0173\3\2\2\2\u0175"+
		"\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2"+
		"\2\2\u0178\u0176\3\2\2\2\u0179\u017a\b-\27\2\u017a_\3\2\2\2\u017b\u017d"+
		"\7\17\2\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2"+
		"\u017e\u0181\7\f\2\2\u017f\u0181\7\f\2\2\u0180\u017c\3\2\2\2\u0180\u017f"+
		"\3\2\2\2\u0181a\3\2\2\2\u0182\u0183\t\2\2\2\u0183c\3\2\2\2\u0184\u0185"+
		"\t\b\2\2\u0185e\3\2\2\2\u0186\u0187\t\t\2\2\u0187g\3\2\2\2\"\2\3\4\5\6"+
		"\7uy}\u0084\u0086\u00cc\u00ce\u00d6\u00da\u00de\u00e7\u00f6\u00f8\u0102"+
		"\u0108\u0112\u0117\u012d\u0136\u0138\u014a\u0158\u016c\u0176\u017c\u0180"+
		"\30\3\2\2\b\2\2\3\17\3\3\21\4\3\22\5\4\6\2\3\25\6\3\26\7\3\27\b\3\37\t"+
		"\3 \n\3!\13\3\"\f\3&\r\3\'\16\3(\17\3)\20\3*\21\3+\22\3,\23\4\5\2\3-\24";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}