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
		BLOCK_KEY=1, TEXT=2, LIST=3, TAG=4, SCAPED_CHAR=5, MARK_NAME=6, SEPARATOR=7, 
		MARK_ERROR=8, IF=9, BLOCK_FILTER=10, WS=11, BLOCK_NAME=12, STRING=13, 
		DOUBLE=14, INTEGER=15, NOT=16, NL=17, NAME=18, BLOCK_ERROR=19, MARK_KEY=20, 
		LEFT_SQ=21, END=22, BLOCK_TEXT=23, EXPRESSION_MARK=24, RIGHT_SQ=25, EXPRESSION_TEXT=26;
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
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'"
	};
	public static final String[] ruleNames = {
		"BLOCK_KEY", "TEXT", "LIST", "TAG", "SCAPED_CHAR", "MARK_NAME", "SEPARATOR", 
		"MARK_ERROR", "IF", "BLOCK_FILTER", "WS", "BLOCK_NAME", "STRING", "DOUBLE", 
		"INTEGER", "NOT", "NL", "NAME", "BLOCK_ERROR", "MARK_KEY", "LEFT_SQ", 
		"END", "BLOCK_TEXT", "EXPRESSION_MARK", "RIGHT_SQ", "EXPRESSION_TEXT", 
		"DIGIT", "LETTER"
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
	        String list = "";
	        if (getCharIndex() + 3 < getInputStream().toString().length())
	            list = this.getInputStream().toString().substring(getCharIndex(), getCharIndex() + 3);
	        return c == '+' || list.equals("...");
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
		case 5: MARK_NAME_action((RuleContext)_localctx, actionIndex); break;
		case 6: SEPARATOR_action((RuleContext)_localctx, actionIndex); break;
		case 16: NL_action((RuleContext)_localctx, actionIndex); break;
		case 19: MARK_KEY_action((RuleContext)_localctx, actionIndex); break;
		case 20: LEFT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 21: END_action((RuleContext)_localctx, actionIndex); break;
		case 22: BLOCK_TEXT_action((RuleContext)_localctx, actionIndex); break;
		case 23: EXPRESSION_MARK_action((RuleContext)_localctx, actionIndex); break;
		case 24: RIGHT_SQ_action((RuleContext)_localctx, actionIndex); break;
		case 25: EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex); break;
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
	private void EXPRESSION_MARK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: setType(MARK_KEY); setLastMode(EXPRESION); break;
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
		case 6: setType(BLOCK_KEY);setMode(BLOCK_SIGNATURE); setLastMode(BLOCK_BODY); break;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00cc\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3"+
		"\2\3\3\7\3D\n\3\f\3\16\3G\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\7\7\7T\n\7\f\7\16\7W\13\7\3\7\3\7\3\b\3\b\7\b]\n\b\f\b\16\b`\13\b\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\5\rq\n\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\7\22\u008c\n\22"+
		"\f\22\16\22\u008f\13\22\3\22\5\22\u0092\n\22\3\22\3\22\5\22\u0096\n\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u009f\n\23\f\23\16\23\u00a2\13"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\7\30\u00b0"+
		"\n\30\f\30\16\30\u00b3\13\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\33\7\33\u00c2\n\33\f\33\16\33\u00c5\13\33\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\2\2\36\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27"+
		"\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31"+
		"\65\32\67\339\34;\2=\2\7\2\3\4\5\6\n\3\2<<\6\2&&<<]]__\3\2__\4\2\13\13"+
		"\"\"\5\2&&<<]]\5\2&&]]__\3\2\62;\4\2C\\c|\u00d3\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\3\13\3\2\2\2\3\r\3\2\2\2\3\17\3\2\2\2\3\21\3\2\2\2\3\23\3\2\2\2\3\25"+
		"\3\2\2\2\4\27\3\2\2\2\4\31\3\2\2\2\4\33\3\2\2\2\4\35\3\2\2\2\4\37\3\2"+
		"\2\2\4!\3\2\2\2\4#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2"+
		"\2\5-\3\2\2\2\5/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\6\65\3\2\2\2\6\67\3"+
		"\2\2\2\69\3\2\2\2\7?\3\2\2\2\tE\3\2\2\2\13H\3\2\2\2\rL\3\2\2\2\17N\3\2"+
		"\2\2\21P\3\2\2\2\23Z\3\2\2\2\25c\3\2\2\2\27e\3\2\2\2\31h\3\2\2\2\33j\3"+
		"\2\2\2\35p\3\2\2\2\37r\3\2\2\2!y\3\2\2\2#\u0080\3\2\2\2%\u0088\3\2\2\2"+
		"\'\u008d\3\2\2\2)\u009b\3\2\2\2+\u00a3\3\2\2\2-\u00a5\3\2\2\2/\u00a8\3"+
		"\2\2\2\61\u00ab\3\2\2\2\63\u00b1\3\2\2\2\65\u00b6\3\2\2\2\67\u00bb\3\2"+
		"\2\29\u00c3\3\2\2\2;\u00c8\3\2\2\2=\u00ca\3\2\2\2?@\7<\2\2@A\b\2\2\2A"+
		"\b\3\2\2\2BD\n\2\2\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\n\3\2\2"+
		"\2GE\3\2\2\2HI\7\60\2\2IJ\7\60\2\2JK\7\60\2\2K\f\3\2\2\2LM\7-\2\2M\16"+
		"\3\2\2\2NO\t\3\2\2O\20\3\2\2\2PU\5=\35\2QT\5;\34\2RT\5=\35\2SQ\3\2\2\2"+
		"SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\b\7\3\2"+
		"Y\22\3\2\2\2Z^\7]\2\2[]\n\4\2\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2"+
		"\2\2_a\3\2\2\2`^\3\2\2\2ab\b\b\4\2b\24\3\2\2\2cd\13\2\2\2d\26\3\2\2\2"+
		"ef\7k\2\2fg\7h\2\2g\30\3\2\2\2hi\7-\2\2i\32\3\2\2\2jk\7\"\2\2k\34\3\2"+
		"\2\2lq\5)\23\2mq\5\37\16\2nq\5#\20\2oq\5!\17\2pl\3\2\2\2pm\3\2\2\2pn\3"+
		"\2\2\2po\3\2\2\2q\36\3\2\2\2rs\7U\2\2st\7v\2\2tu\7t\2\2uv\7k\2\2vw\7p"+
		"\2\2wx\7i\2\2x \3\2\2\2yz\7F\2\2z{\7q\2\2{|\7w\2\2|}\7d\2\2}~\7n\2\2~"+
		"\177\7g\2\2\177\"\3\2\2\2\u0080\u0081\7K\2\2\u0081\u0082\7p\2\2\u0082"+
		"\u0083\7v\2\2\u0083\u0084\7g\2\2\u0084\u0085\7i\2\2\u0085\u0086\7g\2\2"+
		"\u0086\u0087\7t\2\2\u0087$\3\2\2\2\u0088\u0089\7#\2\2\u0089&\3\2\2\2\u008a"+
		"\u008c\t\5\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0095\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0092\7\17\2\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3"+
		"\2\2\2\u0093\u0096\7\f\2\2\u0094\u0096\7\f\2\2\u0095\u0091\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\22\5\2\u0098\u0099\3"+
		"\2\2\2\u0099\u009a\b\22\6\2\u009a(\3\2\2\2\u009b\u00a0\5=\35\2\u009c\u009f"+
		"\5;\34\2\u009d\u009f\5=\35\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1*\3\2\2\2"+
		"\u00a2\u00a0\3\2\2\2\u00a3\u00a4\13\2\2\2\u00a4,\3\2\2\2\u00a5\u00a6\7"+
		"&\2\2\u00a6\u00a7\b\25\7\2\u00a7.\3\2\2\2\u00a8\u00a9\7]\2\2\u00a9\u00aa"+
		"\b\26\b\2\u00aa\60\3\2\2\2\u00ab\u00ac\7<\2\2\u00ac\u00ad\b\27\t\2\u00ad"+
		"\62\3\2\2\2\u00ae\u00b0\n\6\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2"+
		"\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b4\u00b5\b\30\n\2\u00b5\64\3\2\2\2\u00b6\u00b7\7&\2\2\u00b7"+
		"\u00b8\b\31\13\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\31\f\2\u00ba\66\3\2"+
		"\2\2\u00bb\u00bc\7_\2\2\u00bc\u00bd\b\32\r\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\b\32\6\2\u00bf8\3\2\2\2\u00c0\u00c2\n\7\2\2\u00c1\u00c0\3\2\2\2"+
		"\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\b\33\16\2\u00c7:\3\2\2\2\u00c8"+
		"\u00c9\t\b\2\2\u00c9<\3\2\2\2\u00ca\u00cb\t\t\2\2\u00cb>\3\2\2\2\23\2"+
		"\3\4\5\6ESU^p\u008d\u0091\u0095\u009e\u00a0\u00b1\u00c3\17\3\2\2\3\7\3"+
		"\3\b\4\3\22\5\4\5\2\3\25\6\3\26\7\3\27\b\3\30\t\3\31\n\4\3\2\3\32\13\3"+
		"\33\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}