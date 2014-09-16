// Generated from /Users/oroncal/workspace/sandbox/templation/src/es/siani/templation/TemplationLexer.g4 by ANTLR 4.4.1-dev
package es.siani.templation;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TemplationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BLOCK_KEY=1, TEXT=2, LIST=3, TAG=4, MARK_NAME=5, SEPARATOR=6, BLOCK_NAME=7, 
		STRING=8, DOUBLE=9, INTEGER=10, NOT=11, IF=12, BLOCK_ID=13, NL=14, MARK_KEY=15, 
		LEFT_SQ=16, END=17, BLOCK_TEXT=18, SCAPED_CHAR=19, INSIDE_MARK=20, RIGHT_SQ=21, 
		EXPRESSION_TEXT=22;
	public static final int MARK = 1;
	public static final int BLOCK_SIGNATURE = 2;
	public static final int BLOCK_BODY = 3;
	public static final int EXPRESION = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "MARK", "BLOCK_SIGNATURE", "BLOCK_BODY", "EXPRESION"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'"
	};
	public static final String[] ruleNames = {
		"BLOCK_KEY", "TEXT", "LIST", "TAG", "MARK_NAME", "SEPARATOR", "BLOCK_NAME", 
		"STRING", "DOUBLE", "INTEGER", "NOT", "IF", "BLOCK_ID", "NL", "MARK_KEY", 
		"LEFT_SQ", "END", "BLOCK_TEXT", "SCAPED_CHAR", "INSIDE_MARK", "RIGHT_SQ", 
		"EXPRESSION_TEXT", "DIGIT", "LETTER"
	};


		int lastMode = 0;

		private void setLastMode(int i) {
			lastMode = i;
		}

		public int getLastMode() {
	        return lastMode;
	    }

	    public boolean markHasParameters() {
	        char c = this.getInputStream().toString().charAt(getCharIndex());
	        return c == '+' | c == '\n' && c != '~';
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


	public TemplationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TemplationLexer.g4"; }

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
		case 0: BLOCK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 4: MARK_NAME_action((RuleContext)_localctx, actionIndex); break;
		case 5: SEPARATOR_action((RuleContext)_localctx, actionIndex); break;
		case 13: NL_action((RuleContext)_localctx, actionIndex); break;
		case 14: MARK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 15: LEFT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 16: END_action((RuleContext)_localctx, actionIndex); break;
		case 17: BLOCK_TEXT_action((RuleContext)_localctx, actionIndex); break;
		case 19: INSIDE_MARK_action((RuleContext)_localctx, actionIndex); break;
		case 20: RIGHT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 21: EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void INSIDE_MARK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: setType(MARK_KEY); setLastMode(EXPRESION); break;
		}
	}
	private void BLOCK_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: setType(TEXT); break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  setMode(lastMode); setLastMode(MARK); break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: setLastMode(BLOCK_SIGNATURE); break;
		}
	}
	private void MARK_NAME_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  exitMark(); break;
		}
	}
	private void LEFT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: setMode(EXPRESION); setLastMode(BLOCK_BODY); break;
		}
	}
	private void END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: setMode(DEFAULT_MODE); setLastMode(BLOCK_BODY); break;
		}
	}
	private void RIGHT_SQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: setLastMode(EXPRESION); break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: setType(TEXT); break;
		}
	}
	private void MARK_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: setMode(MARK); setLastMode(BLOCK_BODY); break;
		}
	}
	private void BLOCK_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: setMode(BLOCK_SIGNATURE); setLastMode(DEFAULT_MODE); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u00c9\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\3\2\3\2\3\2\3\3\7\3<\n\3\f\3\16\3?\13\3\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\6\3\6\3\7\3\7\7\7"+
		"S\n\7\f\7\16\7V\13\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b^\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\7\16~\n\16\f\16\16\16\u0081"+
		"\13\16\3\17\7\17\u0084\n\17\f\17\16\17\u0087\13\17\3\17\5\17\u008a\n\17"+
		"\3\17\3\17\5\17\u008e\n\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\5\22\u009b\n\22\3\22\3\22\5\22\u009f\n\22\3\22\3\22\3\22\3"+
		"\23\7\23\u00a5\n\23\f\23\16\23\u00a8\13\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u00b2\n\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\7\27\u00bf\n\27\f\27\16\27\u00c2\13\27\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\2\2\32\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f"+
		"\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\2\65\2\7\2"+
		"\3\4\5\6\t\3\2<<\3\2__\4\2\13\13\"\"\4\2&&]]\5\2&&]]__\3\2\62;\4\2C\\"+
		"c|\u00d4\2\7\3\2\2\2\2\t\3\2\2\2\3\13\3\2\2\2\3\r\3\2\2\2\3\17\3\2\2\2"+
		"\3\21\3\2\2\2\4\23\3\2\2\2\4\25\3\2\2\2\4\27\3\2\2\2\4\31\3\2\2\2\4\33"+
		"\3\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2\2\5#\3\2\2\2\5%\3\2\2\2\5"+
		"\'\3\2\2\2\5)\3\2\2\2\6+\3\2\2\2\6-\3\2\2\2\6/\3\2\2\2\6\61\3\2\2\2\7"+
		"\67\3\2\2\2\t=\3\2\2\2\13@\3\2\2\2\rD\3\2\2\2\17F\3\2\2\2\21P\3\2\2\2"+
		"\23]\3\2\2\2\25_\3\2\2\2\27f\3\2\2\2\31m\3\2\2\2\33u\3\2\2\2\35w\3\2\2"+
		"\2\37z\3\2\2\2!\u0085\3\2\2\2#\u0093\3\2\2\2%\u0096\3\2\2\2\'\u009e\3"+
		"\2\2\2)\u00a6\3\2\2\2+\u00b1\3\2\2\2-\u00b3\3\2\2\2/\u00b8\3\2\2\2\61"+
		"\u00c0\3\2\2\2\63\u00c5\3\2\2\2\65\u00c7\3\2\2\2\678\7<\2\289\b\2\2\2"+
		"9\b\3\2\2\2:<\n\2\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\n\3\2\2"+
		"\2?=\3\2\2\2@A\7\60\2\2AB\7\60\2\2BC\7\60\2\2C\f\3\2\2\2DE\7-\2\2E\16"+
		"\3\2\2\2FK\5\65\31\2GJ\5\63\30\2HJ\5\65\31\2IG\3\2\2\2IH\3\2\2\2JM\3\2"+
		"\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\b\6\3\2O\20\3\2\2\2PT\7"+
		"]\2\2QS\n\3\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3"+
		"\2\2\2WX\b\7\4\2X\22\3\2\2\2Y^\5\37\16\2Z^\5\25\t\2[^\5\31\13\2\\^\5\27"+
		"\n\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\24\3\2\2\2_`\7U\2\2`a\7"+
		"v\2\2ab\7t\2\2bc\7k\2\2cd\7p\2\2de\7i\2\2e\26\3\2\2\2fg\7F\2\2gh\7q\2"+
		"\2hi\7w\2\2ij\7d\2\2jk\7n\2\2kl\7g\2\2l\30\3\2\2\2mn\7K\2\2no\7p\2\2o"+
		"p\7v\2\2pq\7g\2\2qr\7i\2\2rs\7g\2\2st\7t\2\2t\32\3\2\2\2uv\7#\2\2v\34"+
		"\3\2\2\2wx\7k\2\2xy\7h\2\2y\36\3\2\2\2z\177\5\65\31\2{~\5\63\30\2|~\5"+
		"\65\31\2}{\3\2\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080 \3\2\2\2\u0081\177\3\2\2\2\u0082\u0084\t\4\2\2\u0083\u0082"+
		"\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u008d\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\7\17\2\2\u0089\u0088\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\7\f\2\2\u008c"+
		"\u008e\7\f\2\2\u008d\u0089\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\b\17\5\2\u0090\u0091\3\2\2\2\u0091\u0092\b\17\6\2\u0092"+
		"\"\3\2\2\2\u0093\u0094\7&\2\2\u0094\u0095\b\20\7\2\u0095$\3\2\2\2\u0096"+
		"\u0097\7]\2\2\u0097\u0098\b\21\b\2\u0098&\3\2\2\2\u0099\u009b\7\17\2\2"+
		"\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f"+
		"\7\f\2\2\u009d\u009f\7\f\2\2\u009e\u009a\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\7<\2\2\u00a1\u00a2\b\22\t\2\u00a2(\3\2\2\2"+
		"\u00a3\u00a5\n\5\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\b\23\n\2\u00aa*\3\2\2\2\u00ab\u00ac\7&\2\2\u00ac\u00b2\7&\2\2\u00ad"+
		"\u00ae\7&\2\2\u00ae\u00b2\7]\2\2\u00af\u00b0\7&\2\2\u00b0\u00b2\7_\2\2"+
		"\u00b1\u00ab\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2,\3"+
		"\2\2\2\u00b3\u00b4\7&\2\2\u00b4\u00b5\b\25\13\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\b\25\f\2\u00b7.\3\2\2\2\u00b8\u00b9\7_\2\2\u00b9\u00ba\b\26\r\2"+
		"\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\26\6\2\u00bc\60\3\2\2\2\u00bd\u00bf"+
		"\n\6\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\b\27"+
		"\16\2\u00c4\62\3\2\2\2\u00c5\u00c6\t\7\2\2\u00c6\64\3\2\2\2\u00c7\u00c8"+
		"\t\b\2\2\u00c8\66\3\2\2\2\26\2\3\4\5\6=IKT]}\177\u0085\u0089\u008d\u009a"+
		"\u009e\u00a6\u00b1\u00c0\17\3\2\2\3\6\3\3\7\4\3\17\5\4\5\2\3\20\6\3\21"+
		"\7\3\22\b\3\23\t\3\25\n\4\3\2\3\26\13\3\27\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}