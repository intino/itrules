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
		RULE_BEGIN=1, WL=2, BODY=3, NOT=4, FUNCTION=5, NL=6, WS=7, PARAMETERS=8, 
		RULE_ERROR=9, RULE_END=10, NEWLINE=11, DOLLAR=12, LSB=13, RSB=14, TRIGGER=15, 
		LEFT_SB=16, TEXT=17, LIST=18, OPTION=19, NULL=20, SEPARATOR=21, ID=22, 
		MARK_ERROR=23, RIGHT_SB=24, EXPRESSION_DOLLAR=25, EXPRESSION_LSB=26, EXPRESSION_RSB=27, 
		EXPRESSION_TRIGGER=28, EXPRESSION_TEXT=29, EXPRESSION_ERROR=30;
	public static final int SIGNATURE_MODE = 1;
	public static final int BODY_MODE = 2;
	public static final int MARK_MODE = 3;
	public static final int EXPRESSION_MODE = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "SIGNATURE_MODE", "BODY_MODE", "MARK_MODE", "EXPRESSION_MODE"
	};

	public static final String[] ruleNames = {
		"RULE_BEGIN", "WL", "BODY", "NOT", "FUNCTION", "NL", "WS", "PARAMETERS", 
		"RULE_ERROR", "RULE_END", "NEWLINE", "DOLLAR", "LSB", "RSB", "TRIGGER", 
		"LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", "MARK_ERROR", 
		"RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", "EXPRESSION_TRIGGER", 
		"EXPRESSION_TEXT", "EXPRESSION_ERROR", "LN", "SP", "DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, "'body'", "'!'", null, null, null, null, null, 
		"'\nendrule'", null, null, null, null, "'$'", "'['", null, "'...'", "'+'", 
		"'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "BODY", "NOT", "FUNCTION", "NL", "WS", "PARAMETERS", 
		"RULE_ERROR", "RULE_END", "NEWLINE", "DOLLAR", "LSB", "RSB", "TRIGGER", 
		"LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", "MARK_ERROR", 
		"RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", "EXPRESSION_TRIGGER", 
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
			NL_action((RuleContext)_localctx, actionIndex); 
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
		}
	}
	private void RULE_BEGIN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 
			 setMode(SIGNATURE_MODE); setLastMode(DEFAULT_MODE); 
			break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u011d\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\3\5\3]\n\3\3\3\3\3\5\3a\n\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6q\n\6\f\6\16\6t\13"+
		"\6\3\7\7\7w\n\7\f\7\16\7z\13\7\3\7\5\7}\n\7\3\7\3\7\5\7\u0081\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u0088\n\7\3\7\3\7\3\7\3\7\3\b\6\b\u008f\n\b\r\b\16"+
		"\b\u0090\3\b\3\b\3\t\3\t\6\t\u0097\n\t\r\t\16\t\u0098\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00b0\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\6"+
		"\22\u00ca\n\22\r\22\16\22\u00cb\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\7\26\u00da\n\26\f\26\16\26\u00dd\13\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\7\27\u00e5\n\27\f\27\16\27\u00e8\13\27\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\7\36\u0108\n\36\f\36\16\36\u010b\13\36\3\36\3\36\3\37\3\37\3 \5 \u0112"+
		"\n \3 \3 \5 \u0116\n \3!\3!\3\"\3\"\3#\3#\2\2$\7\3\t\4\13\5\r\6\17\7\21"+
		"\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26"+
		"/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C\2E\2G\2I\2\7\2\3\4\5\6"+
		"\t\4\2\13\13\"\"\3\2++\6\2\f\f&&]]\u0080\u0080\3\2__\6\2\f\f&&]]__\3\2"+
		"\62;\4\2C\\c|\u0129\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\3"+
		"\17\3\2\2\2\3\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\4\31\3"+
		"\2\2\2\4\33\3\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2\2\4#\3\2\2\2\4"+
		"%\3\2\2\2\4\'\3\2\2\2\5)\3\2\2\2\5+\3\2\2\2\5-\3\2\2\2\5/\3\2\2\2\5\61"+
		"\3\2\2\2\5\63\3\2\2\2\6\65\3\2\2\2\6\67\3\2\2\2\69\3\2\2\2\6;\3\2\2\2"+
		"\6=\3\2\2\2\6?\3\2\2\2\6A\3\2\2\2\7K\3\2\2\2\tX\3\2\2\2\13d\3\2\2\2\r"+
		"k\3\2\2\2\17m\3\2\2\2\21x\3\2\2\2\23\u008e\3\2\2\2\25\u0094\3\2\2\2\27"+
		"\u009c\3\2\2\2\31\u009e\3\2\2\2\33\u00a9\3\2\2\2\35\u00b3\3\2\2\2\37\u00b8"+
		"\3\2\2\2!\u00bd\3\2\2\2#\u00c2\3\2\2\2%\u00c5\3\2\2\2\'\u00c9\3\2\2\2"+
		")\u00cd\3\2\2\2+\u00d1\3\2\2\2-\u00d4\3\2\2\2/\u00d7\3\2\2\2\61\u00e1"+
		"\3\2\2\2\63\u00eb\3\2\2\2\65\u00ed\3\2\2\2\67\u00f2\3\2\2\29\u00f7\3\2"+
		"\2\2;\u00fc\3\2\2\2=\u0101\3\2\2\2?\u0109\3\2\2\2A\u010e\3\2\2\2C\u0115"+
		"\3\2\2\2E\u0117\3\2\2\2G\u0119\3\2\2\2I\u011b\3\2\2\2KL\7f\2\2LM\7g\2"+
		"\2MN\7h\2\2NO\7t\2\2OP\7w\2\2PQ\7n\2\2QR\7g\2\2RS\3\2\2\2ST\b\2\2\2T\b"+
		"\3\2\2\2UW\t\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y`\3\2\2\2Z"+
		"X\3\2\2\2[]\7\17\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^a\7\f\2\2_a\7\f\2"+
		"\2`\\\3\2\2\2`_\3\2\2\2ab\3\2\2\2bc\b\3\3\2c\n\3\2\2\2de\7d\2\2ef\7q\2"+
		"\2fg\7f\2\2gh\7{\2\2hi\3\2\2\2ij\b\4\3\2j\f\3\2\2\2kl\7#\2\2l\16\3\2\2"+
		"\2mr\5I#\2nq\5G\"\2oq\5I#\2pn\3\2\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs"+
		"\3\2\2\2s\20\3\2\2\2tr\3\2\2\2uw\t\2\2\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2"+
		"xy\3\2\2\2y\u0080\3\2\2\2zx\3\2\2\2{}\7\17\2\2|{\3\2\2\2|}\3\2\2\2}~\3"+
		"\2\2\2~\u0081\7\f\2\2\177\u0081\7\f\2\2\u0080|\3\2\2\2\u0080\177\3\2\2"+
		"\2\u0081\u0087\3\2\2\2\u0082\u0088\7\13\2\2\u0083\u0084\7\"\2\2\u0084"+
		"\u0085\7\"\2\2\u0085\u0086\7\"\2\2\u0086\u0088\7\"\2\2\u0087\u0082\3\2"+
		"\2\2\u0087\u0083\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\b\7\4\2\u008a\u008b\3\2\2\2\u008b\u008c\b\7\5\2\u008c\22\3\2\2"+
		"\2\u008d\u008f\5E!\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\b\3\2\u0093"+
		"\24\3\2\2\2\u0094\u0096\7*\2\2\u0095\u0097\n\3\2\2\u0096\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\7+\2\2\u009b\26\3\2\2\2\u009c\u009d\13\2\2\2\u009d"+
		"\30\3\2\2\2\u009e\u009f\7\f\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7p\2\2"+
		"\u00a1\u00a2\7f\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5"+
		"\7n\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\13\6\2\u00a8"+
		"\32\3\2\2\2\u00a9\u00af\7\f\2\2\u00aa\u00b0\7\13\2\2\u00ab\u00ac\7\"\2"+
		"\2\u00ac\u00ad\7\"\2\2\u00ad\u00ae\7\"\2\2\u00ae\u00b0\7\"\2\2\u00af\u00aa"+
		"\3\2\2\2\u00af\u00ab\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\b\f\7\2\u00b2\34\3\2\2\2\u00b3\u00b4\7&\2\2\u00b4\u00b5\7&\2\2"+
		"\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\r\b\2\u00b7\36\3\2\2\2\u00b8\u00b9"+
		"\7&\2\2\u00b9\u00ba\7]\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\16\t\2\u00bc"+
		" \3\2\2\2\u00bd\u00be\7&\2\2\u00be\u00bf\7_\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\b\17\n\2\u00c1\"\3\2\2\2\u00c2\u00c3\7&\2\2\u00c3\u00c4\b\20\13"+
		"\2\u00c4$\3\2\2\2\u00c5\u00c6\7]\2\2\u00c6\u00c7\b\21\f\2\u00c7&\3\2\2"+
		"\2\u00c8\u00ca\n\4\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc(\3\2\2\2\u00cd\u00ce\7\60\2\2\u00ce"+
		"\u00cf\7\60\2\2\u00cf\u00d0\7\60\2\2\u00d0*\3\2\2\2\u00d1\u00d2\7-\2\2"+
		"\u00d2\u00d3\b\24\r\2\u00d3,\3\2\2\2\u00d4\u00d5\7\u0080\2\2\u00d5\u00d6"+
		"\b\25\16\2\u00d6.\3\2\2\2\u00d7\u00db\7]\2\2\u00d8\u00da\n\5\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7_\2\2\u00df"+
		"\u00e0\b\26\17\2\u00e0\60\3\2\2\2\u00e1\u00e6\5I#\2\u00e2\u00e5\5G\"\2"+
		"\u00e3\u00e5\5I#\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8"+
		"\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00ea\b\27\20\2\u00ea\62\3\2\2\2\u00eb\u00ec\13\2"+
		"\2\2\u00ec\64\3\2\2\2\u00ed\u00ee\7_\2\2\u00ee\u00ef\b\31\21\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f1\b\31\5\2\u00f1\66\3\2\2\2\u00f2\u00f3\7&\2\2\u00f3"+
		"\u00f4\7&\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b\32\22\2\u00f68\3\2\2\2"+
		"\u00f7\u00f8\7&\2\2\u00f8\u00f9\7]\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb"+
		"\b\33\23\2\u00fb:\3\2\2\2\u00fc\u00fd\7&\2\2\u00fd\u00fe\7_\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\b\34\24\2\u0100<\3\2\2\2\u0101\u0102\7&\2\2"+
		"\u0102\u0103\b\35\25\2\u0103\u0104\3\2\2\2\u0104\u0105\b\35\26\2\u0105"+
		">\3\2\2\2\u0106\u0108\n\6\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2"+
		"\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109"+
		"\3\2\2\2\u010c\u010d\b\36\27\2\u010d@\3\2\2\2\u010e\u010f\13\2\2\2\u010f"+
		"B\3\2\2\2\u0110\u0112\7\17\2\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2"+
		"\u0112\u0113\3\2\2\2\u0113\u0116\7\f\2\2\u0114\u0116\7\f\2\2\u0115\u0111"+
		"\3\2\2\2\u0115\u0114\3\2\2\2\u0116D\3\2\2\2\u0117\u0118\t\2\2\2\u0118"+
		"F\3\2\2\2\u0119\u011a\t\7\2\2\u011aH\3\2\2\2\u011b\u011c\t\b\2\2\u011c"+
		"J\3\2\2\2\32\2\3\4\5\6X\\`prx|\u0080\u0087\u0090\u0098\u00af\u00cb\u00db"+
		"\u00e4\u00e6\u0109\u0111\u0115\30\3\2\2\b\2\2\3\7\3\4\4\2\3\13\4\3\f\5"+
		"\3\r\6\3\16\7\3\17\b\3\20\t\3\21\n\3\24\13\3\25\f\3\26\r\3\27\16\3\31"+
		"\17\3\32\20\3\33\21\3\34\22\3\35\23\4\5\2\3\36\24";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}