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
		RULE_BEGIN=1, WL=2, BODY=3, NOT=4, FUNCTION=5, END_SIGNATURE=6, WS=7, 
		PARAMETERS=8, RULE_ERROR=9, RULE_END=10, NEWLINE=11, DOLLAR=12, LSB=13, 
		RSB=14, TRIGGER=15, LEFT_SB=16, TEXT=17, LIST=18, OPTION=19, NULL=20, 
		SEPARATOR=21, ID=22, MARK_ERROR=23, RIGHT_SB=24, EXPRESSION_DOLLAR=25, 
		EXPRESSION_LSB=26, EXPRESSION_RSB=27, EXPRESSION_TRIGGER=28, EXPRESSION_TEXT=29, 
		EXPRESSION_NL=30, EXPRESSION_ERROR=31;
	public static final int SIGNATURE_MODE = 1;
	public static final int BODY_MODE = 2;
	public static final int MARK_MODE = 3;
	public static final int EXPRESSION_MODE = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "SIGNATURE_MODE", "BODY_MODE", "MARK_MODE", "EXPRESSION_MODE"
	};

	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "BODY", "NOT", "FUNCTION", "END_SIGNATURE", "WS", 
		"PARAMETERS", "RULE_ERROR", "RULE_END", "NEWLINE", "DOLLAR", "LSB", "RSB", 
		"TRIGGER", "LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", 
		"MARK_ERROR", "RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", 
		"EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", "EXPRESSION_ERROR", 
		"NL", "SP", "DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, "'body'", "'!'", null, null, null, null, null, 
		null, null, null, null, null, "'$'", "'['", null, "'...'", "'+'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "BODY", "NOT", "FUNCTION", "END_SIGNATURE", 
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

		case 5: 
			END_SIGNATURE_action((RuleContext)_localctx, actionIndex); 
			break;

		case 9: 
			RULE_END_action((RuleContext)_localctx, actionIndex); 
			break;

		case 10: 
			NEWLINE_action((RuleContext)_localctx, actionIndex); 
			break;

		case 11: 
			DOLLAR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 12: 
			LSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 13: 
			RSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 14: 
			TRIGGER_action((RuleContext)_localctx, actionIndex); 
			break;

		case 15: 
			LEFT_SB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 18: 
			OPTION_action((RuleContext)_localctx, actionIndex); 
			break;

		case 19: 
			NULL_action((RuleContext)_localctx, actionIndex); 
			break;

		case 20: 
			SEPARATOR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 21: 
			ID_action((RuleContext)_localctx, actionIndex); 
			break;

		case 23: 
			RIGHT_SB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 24: 
			EXPRESSION_DOLLAR_action((RuleContext)_localctx, actionIndex); 
			break;

		case 25: 
			EXPRESSION_LSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 26: 
			EXPRESSION_RSB_action((RuleContext)_localctx, actionIndex); 
			break;

		case 27: 
			EXPRESSION_TRIGGER_action((RuleContext)_localctx, actionIndex); 
			break;

		case 28: 
			EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); 
			break;

		case 29: 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u0128\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\3\5\3_\n\3\3\3\3\3\5\3c\n\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6s\n\6\f\6"+
		"\16\6v\13\6\3\7\7\7y\n\7\f\7\16\7|\13\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0084"+
		"\n\7\3\7\3\7\3\7\3\7\3\b\6\b\u008b\n\b\r\b\16\b\u008c\3\b\3\b\3\t\3\t"+
		"\6\t\u0093\n\t\r\t\16\t\u0094\3\t\3\t\3\t\5\t\u009a\n\t\3\n\3\n\3\13\5"+
		"\13\u009f\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00b1\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\6\22\u00cb\n\22\r\22\16\22\u00cc\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\26\3\26\7\26\u00db\n\26\f\26\16\26\u00de\13\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\7\27\u00e6\n\27\f\27\16\27\u00e9\13\27\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\7\36\u0109\n\36\f\36\16\36\u010c\13\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\5\37\u0116\n\37\3\37\3\37\3 \3 \3!\5!\u011d\n!\3!\3"+
		"!\5!\u0121\n!\3\"\3\"\3#\3#\3$\3$\2\2%\7\3\t\4\13\5\r\6\17\7\21\b\23\t"+
		"\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61"+
		"\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\2G\2I\2K\2\7\2\3\4\5\6\t\4"+
		"\2\13\13\"\"\3\2++\7\2\f\f\17\17&&]]\u0080\u0080\3\2__\6\2\f\f&&]]__\3"+
		"\2\62;\4\2C\\c|\u0136\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2"+
		"\3\17\3\2\2\2\3\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\4\31"+
		"\3\2\2\2\4\33\3\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2\2\4#\3\2\2\2"+
		"\4%\3\2\2\2\4\'\3\2\2\2\5)\3\2\2\2\5+\3\2\2\2\5-\3\2\2\2\5/\3\2\2\2\5"+
		"\61\3\2\2\2\5\63\3\2\2\2\6\65\3\2\2\2\6\67\3\2\2\2\69\3\2\2\2\6;\3\2\2"+
		"\2\6=\3\2\2\2\6?\3\2\2\2\6A\3\2\2\2\6C\3\2\2\2\7M\3\2\2\2\tZ\3\2\2\2\13"+
		"f\3\2\2\2\rm\3\2\2\2\17o\3\2\2\2\21z\3\2\2\2\23\u008a\3\2\2\2\25\u0099"+
		"\3\2\2\2\27\u009b\3\2\2\2\31\u009e\3\2\2\2\33\u00aa\3\2\2\2\35\u00b4\3"+
		"\2\2\2\37\u00b9\3\2\2\2!\u00be\3\2\2\2#\u00c3\3\2\2\2%\u00c6\3\2\2\2\'"+
		"\u00ca\3\2\2\2)\u00ce\3\2\2\2+\u00d2\3\2\2\2-\u00d5\3\2\2\2/\u00d8\3\2"+
		"\2\2\61\u00e2\3\2\2\2\63\u00ec\3\2\2\2\65\u00ee\3\2\2\2\67\u00f3\3\2\2"+
		"\29\u00f8\3\2\2\2;\u00fd\3\2\2\2=\u0102\3\2\2\2?\u010a\3\2\2\2A\u010f"+
		"\3\2\2\2C\u0119\3\2\2\2E\u0120\3\2\2\2G\u0122\3\2\2\2I\u0124\3\2\2\2K"+
		"\u0126\3\2\2\2MN\7f\2\2NO\7g\2\2OP\7h\2\2PQ\7t\2\2QR\7w\2\2RS\7n\2\2S"+
		"T\7g\2\2TU\3\2\2\2UV\b\2\2\2V\b\3\2\2\2WY\t\2\2\2XW\3\2\2\2Y\\\3\2\2\2"+
		"ZX\3\2\2\2Z[\3\2\2\2[b\3\2\2\2\\Z\3\2\2\2]_\7\17\2\2^]\3\2\2\2^_\3\2\2"+
		"\2_`\3\2\2\2`c\7\f\2\2ac\7\f\2\2b^\3\2\2\2ba\3\2\2\2cd\3\2\2\2de\b\3\3"+
		"\2e\n\3\2\2\2fg\7d\2\2gh\7q\2\2hi\7f\2\2ij\7{\2\2jk\3\2\2\2kl\b\4\3\2"+
		"l\f\3\2\2\2mn\7#\2\2n\16\3\2\2\2ot\5K$\2ps\5I#\2qs\5K$\2rp\3\2\2\2rq\3"+
		"\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\20\3\2\2\2vt\3\2\2\2wy\t\2\2\2x"+
		"w\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u0083\5E"+
		"!\2~\u0084\7\13\2\2\177\u0080\7\"\2\2\u0080\u0081\7\"\2\2\u0081\u0082"+
		"\7\"\2\2\u0082\u0084\7\"\2\2\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\7\4\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\b\7\5\2\u0088\22\3\2\2\2\u0089\u008b\5G\"\2\u008a\u0089\3\2\2\2"+
		"\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008f\b\b\3\2\u008f\24\3\2\2\2\u0090\u0092\7*\2\2\u0091"+
		"\u0093\n\3\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009a\7+\2\2\u0097"+
		"\u0098\7*\2\2\u0098\u009a\7+\2\2\u0099\u0090\3\2\2\2\u0099\u0097\3\2\2"+
		"\2\u009a\26\3\2\2\2\u009b\u009c\13\2\2\2\u009c\30\3\2\2\2\u009d\u009f"+
		"\5E!\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\7g\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7f\2\2\u00a3\u00a4\7t\2\2"+
		"\u00a4\u00a5\7w\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a9\b\13\6\2\u00a9\32\3\2\2\2\u00aa\u00b0\5E!\2\u00ab"+
		"\u00b1\7\13\2\2\u00ac\u00ad\7\"\2\2\u00ad\u00ae\7\"\2\2\u00ae\u00af\7"+
		"\"\2\2\u00af\u00b1\7\"\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\f\7\2\u00b3\34\3\2\2"+
		"\2\u00b4\u00b5\7&\2\2\u00b5\u00b6\7&\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8"+
		"\b\r\b\2\u00b8\36\3\2\2\2\u00b9\u00ba\7&\2\2\u00ba\u00bb\7]\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\b\16\t\2\u00bd \3\2\2\2\u00be\u00bf\7&\2\2"+
		"\u00bf\u00c0\7_\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\b\17\n\2\u00c2\"\3"+
		"\2\2\2\u00c3\u00c4\7&\2\2\u00c4\u00c5\b\20\13\2\u00c5$\3\2\2\2\u00c6\u00c7"+
		"\7]\2\2\u00c7\u00c8\b\21\f\2\u00c8&\3\2\2\2\u00c9\u00cb\n\4\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd(\3\2\2\2\u00ce\u00cf\7\60\2\2\u00cf\u00d0\7\60\2\2\u00d0\u00d1"+
		"\7\60\2\2\u00d1*\3\2\2\2\u00d2\u00d3\7-\2\2\u00d3\u00d4\b\24\r\2\u00d4"+
		",\3\2\2\2\u00d5\u00d6\7\u0080\2\2\u00d6\u00d7\b\25\16\2\u00d7.\3\2\2\2"+
		"\u00d8\u00dc\7]\2\2\u00d9\u00db\n\5\2\2\u00da\u00d9\3\2\2\2\u00db\u00de"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e0\7_\2\2\u00e0\u00e1\b\26\17\2\u00e1\60\3\2\2"+
		"\2\u00e2\u00e7\5K$\2\u00e3\u00e6\5I#\2\u00e4\u00e6\5K$\2\u00e5\u00e3\3"+
		"\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\b\27"+
		"\20\2\u00eb\62\3\2\2\2\u00ec\u00ed\13\2\2\2\u00ed\64\3\2\2\2\u00ee\u00ef"+
		"\7_\2\2\u00ef\u00f0\b\31\21\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\31\5\2"+
		"\u00f2\66\3\2\2\2\u00f3\u00f4\7&\2\2\u00f4\u00f5\7&\2\2\u00f5\u00f6\3"+
		"\2\2\2\u00f6\u00f7\b\32\22\2\u00f78\3\2\2\2\u00f8\u00f9\7&\2\2\u00f9\u00fa"+
		"\7]\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\33\23\2\u00fc:\3\2\2\2\u00fd"+
		"\u00fe\7&\2\2\u00fe\u00ff\7_\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\b\34"+
		"\24\2\u0101<\3\2\2\2\u0102\u0103\7&\2\2\u0103\u0104\b\35\25\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0106\b\35\26\2\u0106>\3\2\2\2\u0107\u0109\n\6\2\2\u0108"+
		"\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2"+
		"\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\b\36\27\2\u010e"+
		"@\3\2\2\2\u010f\u0115\5E!\2\u0110\u0116\7\13\2\2\u0111\u0112\7\"\2\2\u0112"+
		"\u0113\7\"\2\2\u0113\u0114\7\"\2\2\u0114\u0116\7\"\2\2\u0115\u0110\3\2"+
		"\2\2\u0115\u0111\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0118\b\37\30\2\u0118B\3\2\2\2\u0119\u011a\13\2\2\2\u011aD\3\2\2\2\u011b"+
		"\u011d\7\17\2\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3"+
		"\2\2\2\u011e\u0121\7\f\2\2\u011f\u0121\7\f\2\2\u0120\u011c\3\2\2\2\u0120"+
		"\u011f\3\2\2\2\u0121F\3\2\2\2\u0122\u0123\t\2\2\2\u0123H\3\2\2\2\u0124"+
		"\u0125\t\7\2\2\u0125J\3\2\2\2\u0126\u0127\t\b\2\2\u0127L\3\2\2\2\33\2"+
		"\3\4\5\6Z^brtz\u0083\u008c\u0094\u0099\u009e\u00b0\u00cc\u00dc\u00e5\u00e7"+
		"\u010a\u0115\u011c\u0120\31\3\2\2\b\2\2\3\7\3\4\4\2\3\13\4\3\f\5\3\r\6"+
		"\3\16\7\3\17\b\3\20\t\3\21\n\3\24\13\3\25\f\3\26\r\3\27\16\3\31\17\3\32"+
		"\20\3\33\21\3\34\22\3\35\23\4\5\2\3\36\24\3\37\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}