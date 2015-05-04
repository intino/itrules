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
		RULE_BEGIN=1, WL=2, BODY=3, COMMENTS=4, NOT=5, FUNCTION=6, END_SIGNATURE=7, 
		WS=8, PARAMETERS=9, RULE_ERROR=10, RULE_END=11, NEWLINE=12, DOLLAR=13, 
		LSB=14, RSB=15, TRIGGER=16, LEFT_SB=17, TEXT=18, LIST=19, OPTION=20, NULL=21, 
		SEPARATOR=22, ID=23, MARK_ERROR=24, RIGHT_SB=25, EXPRESSION_DOLLAR=26, 
		EXPRESSION_LSB=27, EXPRESSION_RSB=28, EXPRESSION_TRIGGER=29, EXPRESSION_TEXT=30, 
		EXPRESSION_NL=31, EXPRESSION_ERROR=32;
	public static final int SIGNATURE_MODE = 1;
	public static final int BODY_MODE = 2;
	public static final int MARK_MODE = 3;
	public static final int EXPRESSION_MODE = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "SIGNATURE_MODE", "BODY_MODE", "MARK_MODE", "EXPRESSION_MODE"
	};

	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "BODY", "COMMENTS", "NOT", "FUNCTION", "END_SIGNATURE", 
		"WS", "PARAMETERS", "RULE_ERROR", "RULE_END", "NEWLINE", "DOLLAR", "LSB", 
		"RSB", "TRIGGER", "LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", 
		"ID", "MARK_ERROR", "RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", 
		"EXPRESSION_RSB", "EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", 
		"EXPRESSION_ERROR", "NL", "SP", "DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", null, "'body'", null, "'!'", null, null, null, null, null, 
		null, null, null, null, null, "'$'", "'['", null, "'...'", "'+'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "BODY", "COMMENTS", "NOT", "FUNCTION", "END_SIGNATURE", 
		"WS", "PARAMETERS", "RULE_ERROR", "RULE_END", "NEWLINE", "DOLLAR", "LSB", 
		"RSB", "TRIGGER", "LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", 
		"ID", "MARK_ERROR", "RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", 
		"EXPRESSION_RSB", "EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", 
		"EXPRESSION_ERROR"
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

		case 6: 
			END_SIGNATURE_action((RuleContext)_localctx, actionIndex); 
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

		case 30: 
			EXPRESSION_NL_action((RuleContext)_localctx, actionIndex); 
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
	private void END_SIGNATURE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 
			 setLastMode(SIGNATURE_MODE); setType(BODY); 
			break;
		}
	}
	private void RULE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: 
			 setMode(DEFAULT_MODE); setLastMode(BODY_MODE); 
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
			 setText("\n"); setType(TEXT); 
			break;
		}
	}
	private void DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
			 setText("$"); setType(TEXT); 
			break;
		}
	}
	private void LSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
			 setText("["); setType(TEXT); 
			break;
		}
	}
	private void RSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
			 setText("]"); setType(TEXT); 
			break;
		}
	}
	private void TRIGGER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: 
			 setMode(MARK_MODE); setLastMode(BODY_MODE); 
			break;
		}
	}
	private void LEFT_SB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: 
			 setMode(EXPRESSION_MODE); setLastMode(BODY_MODE); 
			break;
		}
	}
	private void OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: 
			 setType(OPTION); 
			break;
		}
	}
	private void NULL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: 
			 setMode(lastMode); setLastMode(MARK_MODE); 
			break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: 
			 setMode(lastMode); setLastMode(MARK_MODE); 
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: 
			 setType(ID); exitMark(); 
			break;
		}
	}
	private void RIGHT_SB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: 
			 setLastMode(EXPRESSION_MODE); 
			break;
		}
	}
	private void EXPRESSION_DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: 
			 setText("$"); setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_LSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: 
			 setText("["); setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_RSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: 
			 setText("]"); setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_TRIGGER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: 
			 setType(TRIGGER); setLastMode(EXPRESSION_MODE); 
			break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: 
			 setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19: 
			 setText("\n"); setType(TEXT); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u0124\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\3\5\3]\n\3\3\3\3\3\5\3a\n\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\7\7s\n\7\f\7\16\7"+
		"v\13\7\3\b\7\by\n\b\f\b\16\b|\13\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0084\n"+
		"\b\3\b\3\b\3\b\3\b\3\t\6\t\u008b\n\t\r\t\16\t\u008c\3\t\3\t\3\n\3\n\6"+
		"\n\u0093\n\n\r\n\16\n\u0094\3\n\3\n\3\n\5\n\u009a\n\n\3\13\3\13\3\f\5"+
		"\f\u009f\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ad"+
		"\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\6\23\u00c7\n\23"+
		"\r\23\16\23\u00c8\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\27\3\27\7\27\u00d7\n\27\f\27\16\27\u00da\13\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\7\30\u00e2\n\30\f\30\16\30\u00e5\13\30\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\7\37\u0105"+
		"\n\37\f\37\16\37\u0108\13\37\3\37\3\37\3 \3 \3 \3 \3 \3 \5 \u0112\n \3"+
		" \3 \3!\3!\3\"\5\"\u0119\n\"\3\"\3\"\5\"\u011d\n\"\3#\3#\3$\3$\3%\3%\2"+
		"\2&\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!"+
		"\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?"+
		"\37A C!E\"G\2I\2K\2M\2\7\2\3\4\5\6\t\4\2\13\13\"\"\3\2++\7\2\f\f\17\17"+
		"&&]]\u0080\u0080\3\2__\6\2\f\f&&]]__\3\2\62;\4\2C\\c|\u0132\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\3\21\3\2\2\2\3\23"+
		"\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\4\33\3\2\2\2\4\35\3\2"+
		"\2\2\4\37\3\2\2\2\4!\3\2\2\2\4#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2"+
		"\2\2\5+\3\2\2\2\5-\3\2\2\2\5/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3"+
		"\2\2\2\6\67\3\2\2\2\69\3\2\2\2\6;\3\2\2\2\6=\3\2\2\2\6?\3\2\2\2\6A\3\2"+
		"\2\2\6C\3\2\2\2\6E\3\2\2\2\7O\3\2\2\2\tX\3\2\2\2\13d\3\2\2\2\rk\3\2\2"+
		"\2\17m\3\2\2\2\21o\3\2\2\2\23z\3\2\2\2\25\u008a\3\2\2\2\27\u0099\3\2\2"+
		"\2\31\u009b\3\2\2\2\33\u009e\3\2\2\2\35\u00a6\3\2\2\2\37\u00b0\3\2\2\2"+
		"!\u00b5\3\2\2\2#\u00ba\3\2\2\2%\u00bf\3\2\2\2\'\u00c2\3\2\2\2)\u00c6\3"+
		"\2\2\2+\u00ca\3\2\2\2-\u00ce\3\2\2\2/\u00d1\3\2\2\2\61\u00d4\3\2\2\2\63"+
		"\u00de\3\2\2\2\65\u00e8\3\2\2\2\67\u00ea\3\2\2\29\u00ef\3\2\2\2;\u00f4"+
		"\3\2\2\2=\u00f9\3\2\2\2?\u00fe\3\2\2\2A\u0106\3\2\2\2C\u010b\3\2\2\2E"+
		"\u0115\3\2\2\2G\u011c\3\2\2\2I\u011e\3\2\2\2K\u0120\3\2\2\2M\u0122\3\2"+
		"\2\2OP\7f\2\2PQ\7g\2\2QR\7h\2\2RS\3\2\2\2ST\b\2\2\2T\b\3\2\2\2UW\t\2\2"+
		"\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y`\3\2\2\2ZX\3\2\2\2[]\7\17"+
		"\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^a\7\f\2\2_a\7\f\2\2`\\\3\2\2\2`_"+
		"\3\2\2\2ab\3\2\2\2bc\b\3\3\2c\n\3\2\2\2de\7d\2\2ef\7q\2\2fg\7f\2\2gh\7"+
		"{\2\2hi\3\2\2\2ij\b\4\3\2j\f\3\2\2\2kl\13\2\2\2l\16\3\2\2\2mn\7#\2\2n"+
		"\20\3\2\2\2ot\5M%\2ps\5K$\2qs\5M%\2rp\3\2\2\2rq\3\2\2\2sv\3\2\2\2tr\3"+
		"\2\2\2tu\3\2\2\2u\22\3\2\2\2vt\3\2\2\2wy\t\2\2\2xw\3\2\2\2y|\3\2\2\2z"+
		"x\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u0083\5G\"\2~\u0084\7\13\2\2"+
		"\177\u0080\7\"\2\2\u0080\u0081\7\"\2\2\u0081\u0082\7\"\2\2\u0082\u0084"+
		"\7\"\2\2\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0086\b\b\4\2\u0086\u0087\3\2\2\2\u0087\u0088\b\b\5\2\u0088"+
		"\24\3\2\2\2\u0089\u008b\5I#\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f"+
		"\b\t\3\2\u008f\26\3\2\2\2\u0090\u0092\7*\2\2\u0091\u0093\n\3\2\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u009a\7+\2\2\u0097\u0098\7*\2\2\u0098\u009a"+
		"\7+\2\2\u0099\u0090\3\2\2\2\u0099\u0097\3\2\2\2\u009a\30\3\2\2\2\u009b"+
		"\u009c\13\2\2\2\u009c\32\3\2\2\2\u009d\u009f\5G\"\2\u009e\u009d\3\2\2"+
		"\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2"+
		"\7p\2\2\u00a2\u00a3\7f\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\f\6\2\u00a5"+
		"\34\3\2\2\2\u00a6\u00ac\5G\"\2\u00a7\u00ad\7\13\2\2\u00a8\u00a9\7\"\2"+
		"\2\u00a9\u00aa\7\"\2\2\u00aa\u00ab\7\"\2\2\u00ab\u00ad\7\"\2\2\u00ac\u00a7"+
		"\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\b\r\7\2\u00af\36\3\2\2\2\u00b0\u00b1\7&\2\2\u00b1\u00b2\7&\2\2"+
		"\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\16\b\2\u00b4 \3\2\2\2\u00b5\u00b6\7"+
		"&\2\2\u00b6\u00b7\7]\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\17\t\2\u00b9"+
		"\"\3\2\2\2\u00ba\u00bb\7&\2\2\u00bb\u00bc\7_\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\b\20\n\2\u00be$\3\2\2\2\u00bf\u00c0\7&\2\2\u00c0\u00c1\b\21\13"+
		"\2\u00c1&\3\2\2\2\u00c2\u00c3\7]\2\2\u00c3\u00c4\b\22\f\2\u00c4(\3\2\2"+
		"\2\u00c5\u00c7\n\4\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9*\3\2\2\2\u00ca\u00cb\7\60\2\2\u00cb"+
		"\u00cc\7\60\2\2\u00cc\u00cd\7\60\2\2\u00cd,\3\2\2\2\u00ce\u00cf\7-\2\2"+
		"\u00cf\u00d0\b\25\r\2\u00d0.\3\2\2\2\u00d1\u00d2\7\u0080\2\2\u00d2\u00d3"+
		"\b\26\16\2\u00d3\60\3\2\2\2\u00d4\u00d8\7]\2\2\u00d5\u00d7\n\5\2\2\u00d6"+
		"\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7_\2\2\u00dc"+
		"\u00dd\b\27\17\2\u00dd\62\3\2\2\2\u00de\u00e3\5M%\2\u00df\u00e2\5K$\2"+
		"\u00e0\u00e2\5M%\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5"+
		"\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e6\u00e7\b\30\20\2\u00e7\64\3\2\2\2\u00e8\u00e9\13\2"+
		"\2\2\u00e9\66\3\2\2\2\u00ea\u00eb\7_\2\2\u00eb\u00ec\b\32\21\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ee\b\32\5\2\u00ee8\3\2\2\2\u00ef\u00f0\7&\2\2\u00f0"+
		"\u00f1\7&\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\33\22\2\u00f3:\3\2\2\2"+
		"\u00f4\u00f5\7&\2\2\u00f5\u00f6\7]\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8"+
		"\b\34\23\2\u00f8<\3\2\2\2\u00f9\u00fa\7&\2\2\u00fa\u00fb\7_\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\b\35\24\2\u00fd>\3\2\2\2\u00fe\u00ff\7&\2\2"+
		"\u00ff\u0100\b\36\25\2\u0100\u0101\3\2\2\2\u0101\u0102\b\36\26\2\u0102"+
		"@\3\2\2\2\u0103\u0105\n\6\2\2\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2"+
		"\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0109\u010a\b\37\27\2\u010aB\3\2\2\2\u010b\u0111\5G\"\2\u010c"+
		"\u0112\7\13\2\2\u010d\u010e\7\"\2\2\u010e\u010f\7\"\2\2\u010f\u0110\7"+
		"\"\2\2\u0110\u0112\7\"\2\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\b \30\2\u0114D\3\2\2\2"+
		"\u0115\u0116\13\2\2\2\u0116F\3\2\2\2\u0117\u0119\7\17\2\2\u0118\u0117"+
		"\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011d\7\f\2\2\u011b"+
		"\u011d\7\f\2\2\u011c\u0118\3\2\2\2\u011c\u011b\3\2\2\2\u011dH\3\2\2\2"+
		"\u011e\u011f\t\2\2\2\u011fJ\3\2\2\2\u0120\u0121\t\7\2\2\u0121L\3\2\2\2"+
		"\u0122\u0123\t\b\2\2\u0123N\3\2\2\2\33\2\3\4\5\6X\\`rtz\u0083\u008c\u0094"+
		"\u0099\u009e\u00ac\u00c8\u00d8\u00e1\u00e3\u0106\u0111\u0118\u011c\31"+
		"\3\2\2\b\2\2\3\b\3\4\4\2\3\f\4\3\r\5\3\16\6\3\17\7\3\20\b\3\21\t\3\22"+
		"\n\3\25\13\3\26\f\3\27\r\3\30\16\3\32\17\3\33\20\3\34\21\3\35\22\3\36"+
		"\23\4\5\2\3\37\24\3 \25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}