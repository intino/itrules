// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ItrLexer.g4 by ANTLR 4.5.1
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ItrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN_RULE=1, WL=2, BEGIN_BODY=3, COMMENT=4, NOT=5, FUNCTION=6, END_SIGNATURE=7, 
		WS=8, PARAMETERS=9, RULE_ERROR=10, END_RULE=11, NEWLINE=12, DOLLAR=13, 
		LSB=14, RSB=15, TRIGGER=16, BEGIN_EXPRESSION=17, NULL_SEPARATOR=18, TEXT=19, 
		LIST=20, OPTION=21, NULL=22, SEPARATOR=23, ID=24, MARK_ERROR=25, ELSE=26, 
		END_EXPRESSION=27, EXPRESSION_DOLLAR=28, EXPRESSION_LSB=29, EXPRESSION_RSB=30, 
		EXPRESSION_NULL=31, EXPRESSION_TRIGGER=32, EXPRESSION_TEXT=33, EXPRESSION_NL=34, 
		EXPRESSION_ERROR=35;
	public static final int SIGNATURE_MODE = 1;
	public static final int BODY_MODE = 2;
	public static final int MARK_MODE = 3;
	public static final int EXPRESSION_MODE = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "SIGNATURE_MODE", "BODY_MODE", "MARK_MODE", "EXPRESSION_MODE"
	};

	public static final String[] ruleNames = {
		"BEGIN_RULE", "WL", "BEGIN_BODY", "COMMENT", "NOT", "FUNCTION", "END_SIGNATURE", 
		"WS", "PARAMETERS", "RULE_ERROR", "END_RULE", "NEWLINE", "DOLLAR", "LSB", 
		"RSB", "TRIGGER", "BEGIN_EXPRESSION", "NULL_SEPARATOR", "TEXT", "LIST", 
		"OPTION", "NULL", "SEPARATOR", "ID", "MARK_ERROR", "ELSE", "END_EXPRESSION", 
		"EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", "EXPRESSION_NULL", 
		"EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", "EXPRESSION_ERROR", 
		"NL", "SP", "DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", null, "'body'", null, "'!'", null, null, null, null, null, 
		null, null, null, null, null, "'$'", "'['", null, null, "'...'", "'+'", 
		null, null, null, null, "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN_RULE", "WL", "BEGIN_BODY", "COMMENT", "NOT", "FUNCTION", 
		"END_SIGNATURE", "WS", "PARAMETERS", "RULE_ERROR", "END_RULE", "NEWLINE", 
		"DOLLAR", "LSB", "RSB", "TRIGGER", "BEGIN_EXPRESSION", "NULL_SEPARATOR", 
		"TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", "MARK_ERROR", "ELSE", 
		"END_EXPRESSION", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", 
		"EXPRESSION_NULL", "EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", 
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
			BEGIN_RULE_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			END_SIGNATURE_action((RuleContext)_localctx, actionIndex);
			break;
		case 10:
			END_RULE_action((RuleContext)_localctx, actionIndex);
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
			BEGIN_EXPRESSION_action((RuleContext)_localctx, actionIndex);
			break;
		case 20:
			OPTION_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
			NULL_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			SEPARATOR_action((RuleContext)_localctx, actionIndex);
			break;
		case 23:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		case 26:
			END_EXPRESSION_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			EXPRESSION_DOLLAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 28:
			EXPRESSION_LSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
			EXPRESSION_RSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 31:
			EXPRESSION_TRIGGER_action((RuleContext)_localctx, actionIndex);
			break;
		case 32:
			EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			EXPRESSION_NL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void BEGIN_RULE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setMode(SIGNATURE_MODE); setLastMode(DEFAULT_MODE);
			break;
		}
	}
	private void END_SIGNATURE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 setLastMode(SIGNATURE_MODE); setType(BEGIN_BODY);
			break;
		}
	}
	private void END_RULE_action(RuleContext _localctx, int actionIndex) {
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
	private void BEGIN_EXPRESSION_action(RuleContext _localctx, int actionIndex) {
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
	private void END_EXPRESSION_action(RuleContext _localctx, int actionIndex) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2%\u013a\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\7\3]\n\3\f\3\16\3`\13\3\3\3\5\3c\n\3\3\3\3\3"+
		"\5\3g\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\7\7\7y\n\7\f\7\16\7|\13\7\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\b\u008a\n\b\3\b\3\b\3\b\3\b\3\t\6\t\u0091\n\t\r\t"+
		"\16\t\u0092\3\t\3\t\3\n\3\n\6\n\u0099\n\n\r\n\16\n\u009a\3\n\3\n\3\n\5"+
		"\n\u00a0\n\n\3\13\3\13\3\f\5\f\u00a5\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00b3\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\24\6\24\u00d1\n\24\r\24\16\24\u00d2\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\7\30\u00e3"+
		"\n\30\f\30\16\30\u00e6\13\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00ef"+
		"\n\31\f\31\16\31\u00f2\13\31\3\31\3\31\5\31\u00f6\n\31\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!"+
		"\3!\3\"\6\"\u011c\n\"\r\"\16\"\u011d\3\"\3\"\3#\3#\3#\3#\3#\3#\5#\u0128"+
		"\n#\3#\3#\3$\3$\3%\5%\u012f\n%\3%\3%\5%\u0133\n%\3&\3&\3\'\3\'\3(\3(\2"+
		"\2)\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!"+
		"\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?"+
		"\37A C!E\"G#I$K%M\2O\2Q\2S\2\7\2\3\4\5\6\n\4\2\13\13\"\"\3\2++\7\2\f\f"+
		"\17\17&&]]\u0080\u0080\3\2__\4\2//aa\7\2\f\f&&AA]]__\3\2\62;\4\2C\\c|"+
		"\u014a\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\3"+
		"\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\4\33\3"+
		"\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2\2\4#\3\2\2\2\4%\3\2\2\2\4\'"+
		"\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2\5-\3\2\2\2\5/\3\2\2\2\5\61\3\2\2\2\5\63"+
		"\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\69\3\2\2\2\6;\3\2\2\2\6=\3\2\2\2\6"+
		"?\3\2\2\2\6A\3\2\2\2\6C\3\2\2\2\6E\3\2\2\2\6G\3\2\2\2\6I\3\2\2\2\6K\3"+
		"\2\2\2\7U\3\2\2\2\t^\3\2\2\2\13j\3\2\2\2\rq\3\2\2\2\17s\3\2\2\2\21u\3"+
		"\2\2\2\23\u0080\3\2\2\2\25\u0090\3\2\2\2\27\u009f\3\2\2\2\31\u00a1\3\2"+
		"\2\2\33\u00a4\3\2\2\2\35\u00ac\3\2\2\2\37\u00b6\3\2\2\2!\u00bb\3\2\2\2"+
		"#\u00c0\3\2\2\2%\u00c5\3\2\2\2\'\u00c8\3\2\2\2)\u00cb\3\2\2\2+\u00d0\3"+
		"\2\2\2-\u00d4\3\2\2\2/\u00d8\3\2\2\2\61\u00db\3\2\2\2\63\u00e0\3\2\2\2"+
		"\65\u00ea\3\2\2\2\67\u00f9\3\2\2\29\u00fb\3\2\2\2;\u00fd\3\2\2\2=\u0102"+
		"\3\2\2\2?\u0107\3\2\2\2A\u010c\3\2\2\2C\u0111\3\2\2\2E\u0115\3\2\2\2G"+
		"\u011b\3\2\2\2I\u0121\3\2\2\2K\u012b\3\2\2\2M\u0132\3\2\2\2O\u0134\3\2"+
		"\2\2Q\u0136\3\2\2\2S\u0138\3\2\2\2UV\7f\2\2VW\7g\2\2WX\7h\2\2XY\3\2\2"+
		"\2YZ\b\2\2\2Z\b\3\2\2\2[]\t\2\2\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3"+
		"\2\2\2_f\3\2\2\2`^\3\2\2\2ac\7\17\2\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2dg"+
		"\7\f\2\2eg\7\f\2\2fb\3\2\2\2fe\3\2\2\2gh\3\2\2\2hi\b\3\3\2i\n\3\2\2\2"+
		"jk\7d\2\2kl\7q\2\2lm\7f\2\2mn\7{\2\2no\3\2\2\2op\b\4\3\2p\f\3\2\2\2qr"+
		"\13\2\2\2r\16\3\2\2\2st\7#\2\2t\20\3\2\2\2uz\5S(\2vy\5Q\'\2wy\5S(\2xv"+
		"\3\2\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\22\3\2\2\2|z\3\2\2\2"+
		"}\177\t\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0089\5M%\2\u0084"+
		"\u008a\7\13\2\2\u0085\u0086\7\"\2\2\u0086\u0087\7\"\2\2\u0087\u0088\7"+
		"\"\2\2\u0088\u008a\7\"\2\2\u0089\u0084\3\2\2\2\u0089\u0085\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\b\4\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\b\b\5\2\u008e\24\3\2\2\2\u008f\u0091\5O&\2\u0090\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\b\t\3\2\u0095\26\3\2\2\2\u0096\u0098\7*\2\2"+
		"\u0097\u0099\n\3\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a0\7+\2\2\u009d"+
		"\u009e\7*\2\2\u009e\u00a0\7+\2\2\u009f\u0096\3\2\2\2\u009f\u009d\3\2\2"+
		"\2\u00a0\30\3\2\2\2\u00a1\u00a2\13\2\2\2\u00a2\32\3\2\2\2\u00a3\u00a5"+
		"\5M%\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\7g\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7f\2\2\u00a9\u00aa\3\2\2"+
		"\2\u00aa\u00ab\b\f\6\2\u00ab\34\3\2\2\2\u00ac\u00b2\5M%\2\u00ad\u00b3"+
		"\7\13\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\7\"\2\2\u00b0\u00b1\7\"\2\2"+
		"\u00b1\u00b3\7\"\2\2\u00b2\u00ad\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\r\7\2\u00b5\36\3\2\2\2\u00b6"+
		"\u00b7\7&\2\2\u00b7\u00b8\7&\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\16"+
		"\b\2\u00ba \3\2\2\2\u00bb\u00bc\7&\2\2\u00bc\u00bd\7]\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00bf\b\17\t\2\u00bf\"\3\2\2\2\u00c0\u00c1\7&\2\2\u00c1"+
		"\u00c2\7_\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b\20\n\2\u00c4$\3\2\2\2"+
		"\u00c5\u00c6\7&\2\2\u00c6\u00c7\b\21\13\2\u00c7&\3\2\2\2\u00c8\u00c9\7"+
		"]\2\2\u00c9\u00ca\b\22\f\2\u00ca(\3\2\2\2\u00cb\u00cc\7\u0080\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\b\23\3\2\u00ce*\3\2\2\2\u00cf\u00d1\n\4\2\2"+
		"\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3,\3\2\2\2\u00d4\u00d5\7\60\2\2\u00d5\u00d6\7\60\2\2\u00d6"+
		"\u00d7\7\60\2\2\u00d7.\3\2\2\2\u00d8\u00d9\7-\2\2\u00d9\u00da\b\26\r\2"+
		"\u00da\60\3\2\2\2\u00db\u00dc\7\u0080\2\2\u00dc\u00dd\b\27\16\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\b\27\3\2\u00df\62\3\2\2\2\u00e0\u00e4\7]\2"+
		"\2\u00e1\u00e3\n\5\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e8\7_\2\2\u00e8\u00e9\b\30\17\2\u00e9\64\3\2\2\2\u00ea\u00f0\5S(\2"+
		"\u00eb\u00ef\5Q\'\2\u00ec\u00ef\5S(\2\u00ed\u00ef\t\6\2\2\u00ee\u00eb"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f0\3\2"+
		"\2\2\u00f3\u00f6\5Q\'\2\u00f4\u00f6\5S(\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\b\31\20\2\u00f8\66\3\2\2\2\u00f9"+
		"\u00fa\13\2\2\2\u00fa8\3\2\2\2\u00fb\u00fc\7A\2\2\u00fc:\3\2\2\2\u00fd"+
		"\u00fe\7_\2\2\u00fe\u00ff\b\34\21\2\u00ff\u0100\3\2\2\2\u0100\u0101\b"+
		"\34\5\2\u0101<\3\2\2\2\u0102\u0103\7&\2\2\u0103\u0104\7&\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0106\b\35\22\2\u0106>\3\2\2\2\u0107\u0108\7&\2\2\u0108"+
		"\u0109\7]\2\2\u0109\u010a\3\2\2\2\u010a\u010b\b\36\23\2\u010b@\3\2\2\2"+
		"\u010c\u010d\7&\2\2\u010d\u010e\7_\2\2\u010e\u010f\3\2\2\2\u010f\u0110"+
		"\b\37\24\2\u0110B\3\2\2\2\u0111\u0112\7\u0080\2\2\u0112\u0113\3\2\2\2"+
		"\u0113\u0114\b \3\2\u0114D\3\2\2\2\u0115\u0116\7&\2\2\u0116\u0117\b!\25"+
		"\2\u0117\u0118\3\2\2\2\u0118\u0119\b!\26\2\u0119F\3\2\2\2\u011a\u011c"+
		"\n\7\2\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\b\"\27\2\u0120H\3\2\2\2"+
		"\u0121\u0127\5M%\2\u0122\u0128\7\13\2\2\u0123\u0124\7\"\2\2\u0124\u0125"+
		"\7\"\2\2\u0125\u0126\7\"\2\2\u0126\u0128\7\"\2\2\u0127\u0122\3\2\2\2\u0127"+
		"\u0123\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b#"+
		"\30\2\u012aJ\3\2\2\2\u012b\u012c\13\2\2\2\u012cL\3\2\2\2\u012d\u012f\7"+
		"\17\2\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0133\7\f\2\2\u0131\u0133\7\f\2\2\u0132\u012e\3\2\2\2\u0132\u0131\3\2"+
		"\2\2\u0133N\3\2\2\2\u0134\u0135\t\2\2\2\u0135P\3\2\2\2\u0136\u0137\t\b"+
		"\2\2\u0137R\3\2\2\2\u0138\u0139\t\t\2\2\u0139T\3\2\2\2\34\2\3\4\5\6^b"+
		"fxz\u0080\u0089\u0092\u009a\u009f\u00a4\u00b2\u00d2\u00e4\u00ee\u00f0"+
		"\u00f5\u011d\u0127\u012e\u0132\31\3\2\2\b\2\2\3\b\3\4\4\2\3\f\4\3\r\5"+
		"\3\16\6\3\17\7\3\20\b\3\21\t\3\22\n\3\26\13\3\27\f\3\30\r\3\31\16\3\34"+
		"\17\3\35\20\3\36\21\3\37\22\3!\23\4\5\2\3\"\24\3#\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}