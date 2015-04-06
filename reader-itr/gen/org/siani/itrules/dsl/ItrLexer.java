// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ItrLexer.g4 by ANTLR 4.5
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ItrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_BEGIN=1, WL=2, ID=3, TEXT=4, BODY=5, NOT=6, RULE_FUNCTION=7, NL=8, 
		WS=9, CONDITIONS=10, RULE_ERROR=11, NULL_CHAR=12, INDENT=13, RULE_END=14, 
		NEWLINE=15, DOLLAR=16, LQ=17, RQ=18, MARK_KEY=19, LEFT_SQ=20, RULE_TEXT=21, 
		LIST=22, OPTION=23, END=24, SEPARATOR=25, MARK_ID=26, MARK_ERROR=27, NULL_CH=28, 
		RIGHT_SQ=29, EXPRESSION_DOLLAR=30, EXPRESSION_LQ=31, EXPRESSION_RQ=32, 
		EXPRESSION_MARK=33, EXPRESSION_TEXT=34, EXPRESSION_ERROR=35;
	public static final int RULE_SIGNATURE = 1;
	public static final int RULE_BODY = 2;
	public static final int MARK = 3;
	public static final int EXPRESSION = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "RULE_SIGNATURE", "RULE_BODY", "MARK", "EXPRESSION"
	};

	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "ID", "TEXT", "BODY", "NOT", "RULE_FUNCTION", "NL", 
		"WS", "CONDITIONS", "RULE_ERROR", "NULL_CHAR", "INDENT", "RULE_END", "NEWLINE", 
		"DOLLAR", "LQ", "RQ", "MARK_KEY", "LEFT_SQ", "RULE_TEXT", "LIST", "OPTION", 
		"END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "NULL_CH", "RIGHT_SQ", "EXPRESSION_DOLLAR", 
		"EXPRESSION_LQ", "EXPRESSION_RQ", "EXPRESSION_MARK", "EXPRESSION_TEXT", 
		"EXPRESSION_ERROR", "LN", "SP", "DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, null, "'text'", "'body'", "'!'", null, null, 
		null, null, null, null, "'\t'", "'\nendrule'", "'\n'", null, null, null, 
		"'$'", "'['", null, "'...'", "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "ID", "TEXT", "BODY", "NOT", "RULE_FUNCTION", 
		"NL", "WS", "CONDITIONS", "RULE_ERROR", "NULL_CHAR", "INDENT", "RULE_END", 
		"NEWLINE", "DOLLAR", "LQ", "RQ", "MARK_KEY", "LEFT_SQ", "RULE_TEXT", "LIST", 
		"OPTION", "END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "NULL_CH", "RIGHT_SQ", 
		"EXPRESSION_DOLLAR", "EXPRESSION_LQ", "EXPRESSION_RQ", "EXPRESSION_MARK", 
		"EXPRESSION_TEXT", "EXPRESSION_ERROR"
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
				setLastMode(MARK);
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
			RULE_FUNCTION_action((RuleContext)_localctx, actionIndex); 
			break;

		case 7: 
			NL_action((RuleContext)_localctx, actionIndex); 
			break;

		case 12: 
			INDENT_action((RuleContext)_localctx, actionIndex); 
			break;

		case 13: 
			RULE_END_action((RuleContext)_localctx, actionIndex); 
			break;

		case 14: 
			NEWLINE_action((RuleContext)_localctx, actionIndex); 
			break;

		case 15: 
			DOLLAR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 16: 
			LQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 17: 
			RQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 18: 
			MARK_KEY_action((RuleContext)_localctx, actionIndex); 
			break;

		case 19: 
			LEFT_SQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 20: 
			RULE_TEXT_action((RuleContext)_localctx, actionIndex); 
			break;

		case 22: 
			OPTION_action((RuleContext)_localctx, actionIndex); 
			break;

		case 23: 
			END_action((RuleContext)_localctx, actionIndex); 
			break;

		case 24: 
			SEPARATOR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 25: 
			MARK_ID_action((RuleContext)_localctx, actionIndex); 
			break;

		case 28: 
			RIGHT_SQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 29: 
			EXPRESSION_DOLLAR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 30: 
			EXPRESSION_LQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 31: 
			EXPRESSION_RQ_action((RuleContext)_localctx, actionIndex); 
			break;

		case 32: 
			EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); 
			break;

		case 33: 
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
	private void RULE_FUNCTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 
			 setType(ID); 
			break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: 
			 setLastMode(RULE_SIGNATURE); setType(BODY); 
			break;
		}
	}
	private void INDENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
			 if(indent()) skip(); 
			break;
		}
	}
	private void RULE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
			 setMode(DEFAULT_MODE); setLastMode(RULE_BODY); 
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
			 newLine(); setType(NL); 
			break;
		}
	}
	private void DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
			 setText("$"); setType(TEXT); 
			break;
		}
	}
	private void LQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: 
			 setText("["); setType(TEXT); 
			break;
		}
	}
	private void RQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: 
			 setText("]"); setType(TEXT); 
			break;
		}
	}
	private void MARK_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: 
			 setMode(MARK); setLastMode(RULE_BODY); 
			break;
		}
	}
	private void LEFT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: 
			 setMode(EXPRESSION); setLastMode(RULE_BODY); 
			break;
		}
	}
	private void RULE_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: 
			 setType(TEXT); 
			break;
		}
	}
	private void OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: 
			 setType(OPTION); 
			break;
		}
	}
	private void END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: 
			 setMode(lastMode); setLastMode(MARK); 
			break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: 
			 setMode(lastMode); setLastMode(MARK); 
			break;
		}
	}
	private void MARK_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: 
			 setType(ID); exitMark(); 
			break;
		}
	}
	private void RIGHT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: 
			 setLastMode(EXPRESSION); 
			break;
		}
	}
	private void EXPRESSION_DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: 
			 setText("$");setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_LQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: 
			 setText("[");setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_RQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19: 
			 setText("]");setType(TEXT); 
			break;
		}
	}
	private void EXPRESSION_MARK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20: 
			 setType(MARK_KEY); setLastMode(EXPRESSION); 
			break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 21: 
			 setType(TEXT); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2%\u0139\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3a\n\3\f\3\16\3d\13\3\3\3\5"+
		"\3g\n\3\3\3\3\3\5\3k\n\3\3\3\3\3\3\4\3\4\3\4\7\4r\n\4\f\4\16\4u\13\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\b\7\b\u008c\n\b\f\b\16\b\u008f\13\b\3\b\3\b\3\t\7\t\u0094\n"+
		"\t\f\t\16\t\u0097\13\t\3\t\5\t\u009a\n\t\3\t\3\t\5\t\u009e\n\t\3\t\3\t"+
		"\3\t\3\t\3\n\6\n\u00a5\n\n\r\n\16\n\u00a6\3\n\3\n\3\13\3\13\6\13\u00ad"+
		"\n\13\r\13\16\13\u00ae\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\6\26\u00e0\n\26\r\26\16\26\u00e1"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\7\32\u00f2\n\32\f\32\16\32\u00f5\13\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\7\33\u00fd\n\33\f\33\16\33\u0100\13\33\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\7#\u0124\n#\f#\16#\u0127"+
		"\13#\3#\3#\3$\3$\3%\5%\u012e\n%\3%\3%\5%\u0132\n%\3&\3&\3\'\3\'\3(\3("+
		"\2\2)\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17"+
		"!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36"+
		"?\37A C!E\"G#I$K%M\2O\2Q\2S\2\7\2\3\4\5\6\t\4\2\13\13\"\"\3\2++\6\2\f"+
		"\f&&]]\u0080\u0080\3\2__\6\2\f\f&&]]__\3\2\62;\4\2C\\c|\u0143\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\3"+
		"\23\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\4\35\3"+
		"\2\2\2\4\37\3\2\2\2\4!\3\2\2\2\4#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3"+
		"\2\2\2\4+\3\2\2\2\4-\3\2\2\2\4/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65"+
		"\3\2\2\2\5\67\3\2\2\2\59\3\2\2\2\5;\3\2\2\2\6=\3\2\2\2\6?\3\2\2\2\6A\3"+
		"\2\2\2\6C\3\2\2\2\6E\3\2\2\2\6G\3\2\2\2\6I\3\2\2\2\6K\3\2\2\2\7U\3\2\2"+
		"\2\tb\3\2\2\2\13n\3\2\2\2\rx\3\2\2\2\17\177\3\2\2\2\21\u0086\3\2\2\2\23"+
		"\u0088\3\2\2\2\25\u0095\3\2\2\2\27\u00a4\3\2\2\2\31\u00aa\3\2\2\2\33\u00b2"+
		"\3\2\2\2\35\u00b4\3\2\2\2\37\u00b8\3\2\2\2!\u00bb\3\2\2\2#\u00c6\3\2\2"+
		"\2%\u00c9\3\2\2\2\'\u00ce\3\2\2\2)\u00d3\3\2\2\2+\u00d8\3\2\2\2-\u00db"+
		"\3\2\2\2/\u00df\3\2\2\2\61\u00e5\3\2\2\2\63\u00e9\3\2\2\2\65\u00ec\3\2"+
		"\2\2\67\u00ef\3\2\2\29\u00f9\3\2\2\2;\u0103\3\2\2\2=\u0105\3\2\2\2?\u0109"+
		"\3\2\2\2A\u010e\3\2\2\2C\u0113\3\2\2\2E\u0118\3\2\2\2G\u011d\3\2\2\2I"+
		"\u0125\3\2\2\2K\u012a\3\2\2\2M\u0131\3\2\2\2O\u0133\3\2\2\2Q\u0135\3\2"+
		"\2\2S\u0137\3\2\2\2UV\7f\2\2VW\7g\2\2WX\7h\2\2XY\7t\2\2YZ\7w\2\2Z[\7n"+
		"\2\2[\\\7g\2\2\\]\3\2\2\2]^\b\2\2\2^\b\3\2\2\2_a\t\2\2\2`_\3\2\2\2ad\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2cj\3\2\2\2db\3\2\2\2eg\7\17\2\2fe\3\2\2\2fg"+
		"\3\2\2\2gh\3\2\2\2hk\7\f\2\2ik\7\f\2\2jf\3\2\2\2ji\3\2\2\2kl\3\2\2\2l"+
		"m\b\3\3\2m\n\3\2\2\2ns\5S(\2or\5Q\'\2pr\5S(\2qo\3\2\2\2qp\3\2\2\2ru\3"+
		"\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\b\4\3\2w\f\3\2\2\2xy"+
		"\7v\2\2yz\7g\2\2z{\7z\2\2{|\7v\2\2|}\3\2\2\2}~\b\5\3\2~\16\3\2\2\2\177"+
		"\u0080\7d\2\2\u0080\u0081\7q\2\2\u0081\u0082\7f\2\2\u0082\u0083\7{\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0085\b\6\3\2\u0085\20\3\2\2\2\u0086\u0087"+
		"\7#\2\2\u0087\22\3\2\2\2\u0088\u008d\5S(\2\u0089\u008c\5Q\'\2\u008a\u008c"+
		"\5S(\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0091\b\b\4\2\u0091\24\3\2\2\2\u0092\u0094\t\2\2\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u009d\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\7\17\2\2\u0099\u0098\3"+
		"\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\7\f\2\2\u009c"+
		"\u009e\7\f\2\2\u009d\u0099\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u00a0\b\t\5\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\t\6\2\u00a2"+
		"\26\3\2\2\2\u00a3\u00a5\5O&\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2"+
		"\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9"+
		"\b\n\3\2\u00a9\30\3\2\2\2\u00aa\u00ac\7*\2\2\u00ab\u00ad\n\3\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7+\2\2\u00b1\32\3\2\2\2\u00b2\u00b3"+
		"\13\2\2\2\u00b3\34\3\2\2\2\u00b4\u00b5\7\u0080\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00b7\b\r\3\2\u00b7\36\3\2\2\2\u00b8\u00b9\7\13\2\2\u00b9\u00ba"+
		"\b\16\7\2\u00ba \3\2\2\2\u00bb\u00bc\7\f\2\2\u00bc\u00bd\7g\2\2\u00bd"+
		"\u00be\7p\2\2\u00be\u00bf\7f\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7w\2\2"+
		"\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5"+
		"\b\17\b\2\u00c5\"\3\2\2\2\u00c6\u00c7\7\f\2\2\u00c7\u00c8\b\20\t\2\u00c8"+
		"$\3\2\2\2\u00c9\u00ca\7&\2\2\u00ca\u00cb\7&\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\b\21\n\2\u00cd&\3\2\2\2\u00ce\u00cf\7&\2\2\u00cf\u00d0\7]\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\b\22\13\2\u00d2(\3\2\2\2\u00d3\u00d4\7&\2\2"+
		"\u00d4\u00d5\7_\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\23\f\2\u00d7*\3"+
		"\2\2\2\u00d8\u00d9\7&\2\2\u00d9\u00da\b\24\r\2\u00da,\3\2\2\2\u00db\u00dc"+
		"\7]\2\2\u00dc\u00dd\b\25\16\2\u00dd.\3\2\2\2\u00de\u00e0\n\4\2\2\u00df"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\26\17\2\u00e4\60\3\2\2\2\u00e5"+
		"\u00e6\7\60\2\2\u00e6\u00e7\7\60\2\2\u00e7\u00e8\7\60\2\2\u00e8\62\3\2"+
		"\2\2\u00e9\u00ea\7-\2\2\u00ea\u00eb\b\30\20\2\u00eb\64\3\2\2\2\u00ec\u00ed"+
		"\7\u0080\2\2\u00ed\u00ee\b\31\21\2\u00ee\66\3\2\2\2\u00ef\u00f3\7]\2\2"+
		"\u00f0\u00f2\n\5\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f7\7_\2\2\u00f7\u00f8\b\32\22\2\u00f88\3\2\2\2\u00f9\u00fe\5S(\2\u00fa"+
		"\u00fd\5Q\'\2\u00fb\u00fd\5S(\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2"+
		"\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\b\33\23\2\u0102:\3\2\2\2\u0103"+
		"\u0104\13\2\2\2\u0104<\3\2\2\2\u0105\u0106\7\u0080\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0108\b\35\3\2\u0108>\3\2\2\2\u0109\u010a\7_\2\2\u010a\u010b"+
		"\b\36\24\2\u010b\u010c\3\2\2\2\u010c\u010d\b\36\6\2\u010d@\3\2\2\2\u010e"+
		"\u010f\7&\2\2\u010f\u0110\7&\2\2\u0110\u0111\3\2\2\2\u0111\u0112\b\37"+
		"\25\2\u0112B\3\2\2\2\u0113\u0114\7&\2\2\u0114\u0115\7]\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\u0117\b \26\2\u0117D\3\2\2\2\u0118\u0119\7&\2\2\u0119\u011a"+
		"\7_\2\2\u011a\u011b\3\2\2\2\u011b\u011c\b!\27\2\u011cF\3\2\2\2\u011d\u011e"+
		"\7&\2\2\u011e\u011f\b\"\30\2\u011f\u0120\3\2\2\2\u0120\u0121\b\"\31\2"+
		"\u0121H\3\2\2\2\u0122\u0124\n\6\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3"+
		"\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0128\u0129\b#\32\2\u0129J\3\2\2\2\u012a\u012b\13\2\2\2"+
		"\u012bL\3\2\2\2\u012c\u012e\7\17\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3"+
		"\2\2\2\u012e\u012f\3\2\2\2\u012f\u0132\7\f\2\2\u0130\u0132\7\f\2\2\u0131"+
		"\u012d\3\2\2\2\u0131\u0130\3\2\2\2\u0132N\3\2\2\2\u0133\u0134\t\2\2\2"+
		"\u0134P\3\2\2\2\u0135\u0136\t\7\2\2\u0136R\3\2\2\2\u0137\u0138\t\b\2\2"+
		"\u0138T\3\2\2\2\32\2\3\4\5\6bfjqs\u008b\u008d\u0095\u0099\u009d\u00a6"+
		"\u00ae\u00e1\u00f3\u00fc\u00fe\u0125\u012d\u0131\33\3\2\2\b\2\2\3\b\3"+
		"\3\t\4\4\4\2\3\16\5\3\17\6\3\20\7\3\21\b\3\22\t\3\23\n\3\24\13\3\25\f"+
		"\3\26\r\3\30\16\3\31\17\3\32\20\3\33\21\3\36\22\3\37\23\3 \24\3!\25\3"+
		"\"\26\4\5\2\3#\27";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}