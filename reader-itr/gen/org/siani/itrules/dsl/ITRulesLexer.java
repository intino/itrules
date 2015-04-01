// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ITRulesLexer.g4 by ANTLR 4.5
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
public class ITRulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_BEGIN=1, WL=2, ID=3, TEXT=4, CONDITIONS=5, EVAL=6, NOT=7, TRIGGER=8, 
		RULE_FUNCTION=9, NL=10, WS=11, RULE_ERROR=12, NULL_CHAR=13, SCAPED_CHAR=14, 
		MARK_KEY=15, LEFT_SQ=16, RULE_END=17, RULE_TEXT=18, LIST=19, MARK_OPTION=20, 
		END=21, SEPARATOR=22, MARK_ID=23, MARK_ERROR=24, NULL_CH=25, RIGHT_SQ=26, 
		EXP_SCAPED_CHAR=27, EXPRESSION_MARK=28, EXPRESSION_TEXT=29;
	public static final int RULE_SIGNATURE = 1;
	public static final int RULE_BODY = 2;
	public static final int MARK = 3;
	public static final int EXPRESSION = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "RULE_SIGNATURE", "RULE_BODY", "MARK", "EXPRESSION"
	};

	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "ID", "TEXT", "CONDITIONS", "EVAL", "NOT", "TRIGGER", 
		"RULE_FUNCTION", "NL", "WS", "RULE_ERROR", "NULL_CHAR", "SCAPED_CHAR", 
		"MARK_KEY", "LEFT_SQ", "RULE_END", "RULE_TEXT", "LIST", "MARK_OPTION", 
		"END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "NULL_CH", "RIGHT_SQ", "EXP_SCAPED_CHAR", 
		"EXPRESSION_MARK", "EXPRESSION_TEXT", "LN", "SP", "DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, null, "'text'", null, "'eval'", "'!'", "'trigger'", 
		null, null, null, null, null, null, "'$'", "'['", "'\\u0015'", null, "'...'", 
		"'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "ID", "TEXT", "CONDITIONS", "EVAL", "NOT", "TRIGGER", 
		"RULE_FUNCTION", "NL", "WS", "RULE_ERROR", "NULL_CHAR", "SCAPED_CHAR", 
		"MARK_KEY", "LEFT_SQ", "RULE_END", "RULE_TEXT", "LIST", "MARK_OPTION", 
		"END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "NULL_CH", "RIGHT_SQ", "EXP_SCAPED_CHAR", 
		"EXPRESSION_MARK", "EXPRESSION_TEXT"
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


	public ITRulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ITRulesLexer.g4"; }

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
			EVAL_action((RuleContext)_localctx, actionIndex); 
			break;

		case 8: 
			RULE_FUNCTION_action((RuleContext)_localctx, actionIndex); 
			break;

		case 9: 
			NL_action((RuleContext)_localctx, actionIndex); 
			break;

		case 14: 
			MARK_KEY_action((RuleContext)_localctx, actionIndex); 
			break;

		case 15: 
			LEFT_SQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 16: 
			RULE_END_action((RuleContext)_localctx, actionIndex); 
			break;

		case 17: 
			RULE_TEXT_action((RuleContext)_localctx, actionIndex); 
			break;

		case 19: 
			MARK_OPTION_action((RuleContext)_localctx, actionIndex); 
			break;

		case 20: 
			END_action((RuleContext)_localctx, actionIndex); 
			break;

		case 21: 
			SEPARATOR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 22: 
			MARK_ID_action((RuleContext)_localctx, actionIndex); 
			break;

		case 25: 
			RIGHT_SQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 26: 
			EXP_SCAPED_CHAR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 27: 
			EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); 
			break;

		case 28: 
			EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); 
			break;
		}
	}
	private void RULE_BEGIN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 
			 setMode(RULE_SIGNATURE); setLastMode(DEFAULT_MODE); 
			break;
		}
	}
	private void EVAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 
			 setMode(EVAL_MODE); setLastMode(RULE_SIGNATURE); 
			break;
		}
	}
	private void RULE_FUNCTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: 
			 setType(ID); 
			break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
			 setLastMode(RULE_SIGNATURE); 
			break;
		}
	}
	private void MARK_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
			setMode(MARK); setLastMode(RULE_BODY); 
			break;
		}
	}
	private void LEFT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
			setMode(EXPRESSION); setLastMode(RULE_BODY); 
			break;
		}
	}
	private void RULE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
			setMode(DEFAULT_MODE); setLastMode(RULE_BODY); 
			break;
		}
	}
	private void RULE_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: 
			setType(TEXT); 
			break;
		}
	}
	private void MARK_OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: 
			 setType(OPTION); 
			break;
		}
	}
	private void END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: 
			 setMode(lastMode); setLastMode(MARK); 
			break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: 
			 setMode(lastMode); setLastMode(MARK); 
			break;
		}
	}
	private void MARK_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: 
			 setType(ID); exitMark(); 
			break;
		}
	}
	private void RIGHT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: 
			setLastMode(EXPRESSION); 
			break;
		}
	}
	private void EXP_SCAPED_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: 
			setType(SCAPED_CHAR); 
			break;
		}
	}
	private void EXPRESSION_MARK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: 
			setType(MARK_KEY); setLastMode(EXPRESSION); 
			break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: 
			setType(TEXT); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u0114\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\7\3U\n\3\f\3\16\3X\13\3\3\3\5\3[\n\3\3\3\3\3\5\3_\n\3\3\3\3\3\3\4"+
		"\3\4\3\4\7\4f\n\4\f\4\16\4i\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\7\n\u008b\n\n\f\n\16\n\u008e\13\n\3\n\3\n\3\13\7"+
		"\13\u0093\n\13\f\13\16\13\u0096\13\13\3\13\5\13\u0099\n\13\3\13\3\13\5"+
		"\13\u009d\n\13\3\13\3\13\3\13\3\13\3\f\6\f\u00a4\n\f\r\f\16\f\u00a5\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00b6\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\6\23\u00c2"+
		"\n\23\r\23\16\23\u00c3\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\3\27\7\27\u00d4\n\27\f\27\16\27\u00d7\13\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\7\30\u00df\n\30\f\30\16\30\u00e2\13\30\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u00f9\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\7\36\u0101\n\36\f\36\16\36\u0104\13\36\3\36\3\36\3\37\5\37\u0109"+
		"\n\37\3\37\3\37\5\37\u010d\n\37\3 \3 \3!\3!\3\"\3\"\2\2#\7\3\t\4\13\5"+
		"\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23"+
		")\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A\2C\2E\2G\2\7"+
		"\2\3\4\5\6\t\4\2\13\13\"\"\3\2++\6\2\27\27&&]]\u0080\u0080\3\2__\5\2&"+
		"&]]__\3\2\62;\4\2C\\c|\u0121\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\3\17\3\2\2\2\3\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27\3\2"+
		"\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2\2\4"+
		"#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\5+\3\2\2\2\5-\3\2\2\2\5/\3"+
		"\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\6\67\3\2\2\2\69\3\2\2\2"+
		"\6;\3\2\2\2\6=\3\2\2\2\6?\3\2\2\2\7I\3\2\2\2\tV\3\2\2\2\13b\3\2\2\2\r"+
		"l\3\2\2\2\17s\3\2\2\2\21v\3\2\2\2\23}\3\2\2\2\25\177\3\2\2\2\27\u0087"+
		"\3\2\2\2\31\u0094\3\2\2\2\33\u00a3\3\2\2\2\35\u00a9\3\2\2\2\37\u00ab\3"+
		"\2\2\2!\u00b5\3\2\2\2#\u00b7\3\2\2\2%\u00ba\3\2\2\2\'\u00bd\3\2\2\2)\u00c1"+
		"\3\2\2\2+\u00c7\3\2\2\2-\u00cb\3\2\2\2/\u00ce\3\2\2\2\61\u00d1\3\2\2\2"+
		"\63\u00db\3\2\2\2\65\u00e5\3\2\2\2\67\u00e7\3\2\2\29\u00eb\3\2\2\2;\u00f8"+
		"\3\2\2\2=\u00fa\3\2\2\2?\u0102\3\2\2\2A\u010c\3\2\2\2C\u010e\3\2\2\2E"+
		"\u0110\3\2\2\2G\u0112\3\2\2\2IJ\7f\2\2JK\7g\2\2KL\7h\2\2LM\7t\2\2MN\7"+
		"w\2\2NO\7n\2\2OP\7g\2\2PQ\3\2\2\2QR\b\2\2\2R\b\3\2\2\2SU\t\2\2\2TS\3\2"+
		"\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W^\3\2\2\2XV\3\2\2\2Y[\7\17\2\2ZY\3"+
		"\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\_\7\f\2\2]_\7\f\2\2^Z\3\2\2\2^]\3\2\2\2_"+
		"`\3\2\2\2`a\b\3\3\2a\n\3\2\2\2bg\5G\"\2cf\5E!\2df\5G\"\2ec\3\2\2\2ed\3"+
		"\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\b\4\3\2k\f"+
		"\3\2\2\2lm\7v\2\2mn\7g\2\2no\7z\2\2op\7v\2\2pq\3\2\2\2qr\b\5\3\2r\16\3"+
		"\2\2\2st\7*\2\2tu\n\3\2\2u\20\3\2\2\2vw\7g\2\2wx\7x\2\2xy\7c\2\2yz\7n"+
		"\2\2z{\3\2\2\2{|\b\7\4\2|\22\3\2\2\2}~\7#\2\2~\24\3\2\2\2\177\u0080\7"+
		"v\2\2\u0080\u0081\7t\2\2\u0081\u0082\7k\2\2\u0082\u0083\7i\2\2\u0083\u0084"+
		"\7i\2\2\u0084\u0085\7g\2\2\u0085\u0086\7t\2\2\u0086\26\3\2\2\2\u0087\u008c"+
		"\5G\"\2\u0088\u008b\5E!\2\u0089\u008b\5G\"\2\u008a\u0088\3\2\2\2\u008a"+
		"\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\b\n\5\2\u0090"+
		"\30\3\2\2\2\u0091\u0093\t\2\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u009c\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\u0099\7\17\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009d\7\f\2\2\u009b\u009d\7\f\2\2\u009c\u0098"+
		"\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\b\13\6\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\13\7\2\u00a1\32\3\2\2\2\u00a2\u00a4"+
		"\5C \2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\f\3\2\u00a8\34\3\2\2"+
		"\2\u00a9\u00aa\13\2\2\2\u00aa\36\3\2\2\2\u00ab\u00ac\7\u0080\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\b\16\3\2\u00ae \3\2\2\2\u00af\u00b0\7&\2\2"+
		"\u00b0\u00b6\7&\2\2\u00b1\u00b2\7&\2\2\u00b2\u00b6\7]\2\2\u00b3\u00b4"+
		"\7&\2\2\u00b4\u00b6\7_\2\2\u00b5\u00af\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\"\3\2\2\2\u00b7\u00b8\7&\2\2\u00b8\u00b9\b\20\b\2"+
		"\u00b9$\3\2\2\2\u00ba\u00bb\7]\2\2\u00bb\u00bc\b\21\t\2\u00bc&\3\2\2\2"+
		"\u00bd\u00be\7\27\2\2\u00be\u00bf\b\22\n\2\u00bf(\3\2\2\2\u00c0\u00c2"+
		"\n\4\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\b\23\13\2\u00c6*\3\2\2"+
		"\2\u00c7\u00c8\7\60\2\2\u00c8\u00c9\7\60\2\2\u00c9\u00ca\7\60\2\2\u00ca"+
		",\3\2\2\2\u00cb\u00cc\7-\2\2\u00cc\u00cd\b\25\f\2\u00cd.\3\2\2\2\u00ce"+
		"\u00cf\7\u0080\2\2\u00cf\u00d0\b\26\r\2\u00d0\60\3\2\2\2\u00d1\u00d5\7"+
		"]\2\2\u00d2\u00d4\n\5\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d8\u00d9\7_\2\2\u00d9\u00da\b\27\16\2\u00da\62\3\2\2\2\u00db\u00e0"+
		"\5G\"\2\u00dc\u00df\5E!\2\u00dd\u00df\5G\"\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\b\30\17\2\u00e4"+
		"\64\3\2\2\2\u00e5\u00e6\13\2\2\2\u00e6\66\3\2\2\2\u00e7\u00e8\7\u0080"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\32\3\2\u00ea8\3\2\2\2\u00eb\u00ec"+
		"\7_\2\2\u00ec\u00ed\b\33\20\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b\33\7\2"+
		"\u00ef:\3\2\2\2\u00f0\u00f1\7&\2\2\u00f1\u00f9\7&\2\2\u00f2\u00f3\7&\2"+
		"\2\u00f3\u00f9\7]\2\2\u00f4\u00f5\7&\2\2\u00f5\u00f6\7_\2\2\u00f6\u00f7"+
		"\3\2\2\2\u00f7\u00f9\b\34\21\2\u00f8\u00f0\3\2\2\2\u00f8\u00f2\3\2\2\2"+
		"\u00f8\u00f4\3\2\2\2\u00f9<\3\2\2\2\u00fa\u00fb\7&\2\2\u00fb\u00fc\b\35"+
		"\22\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\b\35\23\2\u00fe>\3\2\2\2\u00ff\u0101"+
		"\n\6\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\b\36"+
		"\24\2\u0106@\3\2\2\2\u0107\u0109\7\17\2\2\u0108\u0107\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010d\7\f\2\2\u010b\u010d\7\f\2\2\u010c"+
		"\u0108\3\2\2\2\u010c\u010b\3\2\2\2\u010dB\3\2\2\2\u010e\u010f\t\2\2\2"+
		"\u010fD\3\2\2\2\u0110\u0111\t\7\2\2\u0111F\3\2\2\2\u0112\u0113\t\b\2\2"+
		"\u0113H\3\2\2\2\33\2\3\4\5\6VZ^eg\u008a\u008c\u0094\u0098\u009c\u00a5"+
		"\u00b5\u00c3\u00d5\u00de\u00e0\u00f8\u0102\u0108\u010c\25\3\2\2\b\2\2"+
		"\3\7\3\3\n\4\3\13\5\4\4\2\3\20\6\3\21\7\3\22\b\3\23\t\3\25\n\3\26\13\3"+
		"\27\f\3\30\r\3\33\16\3\34\17\3\35\20\4\5\2\3\36\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}