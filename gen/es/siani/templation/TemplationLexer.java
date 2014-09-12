// Generated from /Users/oroncal/workspace/sandbox/templation/src/es/siani/templation/TemplationLexer.g4 by ANTLR 4.4.1-dev
package es.siani.templation;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TemplationLexer extends Lexer {
	static {
		RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_SQ = 1, RIGHT_SQ = 2, NL = 3, MARK_ID = 4, TEXT = 5, STRING = 6, DOUBLE = 7, INTEGER = 8,
		ID = 9, MARK_KEY = 10, BLOCK_KEY = 11, TAG = 12, LIST = 13, NL_SEP = 14, LETTER = 15,
		DIGIT = 16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'",
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'",
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'"
	};
	public static final String[] ruleNames = {
		"LEFT_SQ", "RIGHT_SQ", "NL", "MARK_ID", "TEXT", "STRING", "DOUBLE", "INTEGER",
		"ID", "MARK_KEY", "BLOCK_KEY", "TAG", "LIST", "NL_SEP", "LETTER", "DIGIT"
	};


	public TemplationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	public String getGrammarFileName() {
		return "TemplationLexer.g4";
	}

	@Override
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22q\b\1\4\2\t\2\4" +
			"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
			"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3" +
			"\3\3\3\3\4\5\4)\n\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\5\5\5\64\n\5\3" +
			"\6\7\6\67\n\6\f\6\16\6:\13\6\3\6\3\6\3\6\3\6\5\6@\n\6\3\7\3\7\3\7\3\7" +
			"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3" +
			"\t\3\n\3\n\3\n\7\n[\n\n\f\n\16\n^\13\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16" +
			"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\2\2\22\3\3\5\4" +
			"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22" +
			"\3\2\4\4\2C\\c|\3\2\62;{\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2" +
			"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25" +
			"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2" +
			"\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7,\3\2\2\2\t.\3\2\2\2\138\3\2\2" +
			"\2\rA\3\2\2\2\17H\3\2\2\2\21O\3\2\2\2\23W\3\2\2\2\25_\3\2\2\2\27a\3\2" +
			"\2\2\31c\3\2\2\2\33e\3\2\2\2\35i\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#$\7]\2" +
			"\2$\4\3\2\2\2%&\7_\2\2&\6\3\2\2\2\')\7\17\2\2(\'\3\2\2\2()\3\2\2\2)*\3" +
			"\2\2\2*-\7\f\2\2+-\7\f\2\2,(\3\2\2\2,+\3\2\2\2-\b\3\2\2\2.\63\5\25\13" +
			"\2/\64\5\23\n\2\60\64\5\r\7\2\61\64\5\17\b\2\62\64\5\21\t\2\63/\3\2\2" +
			"\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\n\3\2\2\2\65\67\13\2\2" +
			"\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29?\3\2\2\2:8\3\2\2\2" +
			";@\5\27\f\2<@\5\25\13\2=@\5\3\2\2>@\5\5\3\2?;\3\2\2\2?<\3\2\2\2?=\3\2" +
			"\2\2?>\3\2\2\2@\f\3\2\2\2AB\7U\2\2BC\7v\2\2CD\7t\2\2DE\7k\2\2EF\7p\2\2" +
			"FG\7i\2\2G\16\3\2\2\2HI\7F\2\2IJ\7q\2\2JK\7w\2\2KL\7d\2\2LM\7n\2\2MN\7" +
			"g\2\2N\20\3\2\2\2OP\7K\2\2PQ\7p\2\2QR\7v\2\2RS\7g\2\2ST\7i\2\2TU\7g\2" +
			"\2UV\7t\2\2V\22\3\2\2\2W\\\5\37\20\2X[\5!\21\2Y[\5\37\20\2ZX\3\2\2\2Z" +
			"Y\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\24\3\2\2\2^\\\3\2\2\2_`\7&" +
			"\2\2`\26\3\2\2\2ab\7<\2\2b\30\3\2\2\2cd\7-\2\2d\32\3\2\2\2ef\7\60\2\2" +
			"fg\7\60\2\2gh\7\60\2\2h\34\3\2\2\2ij\7&\2\2jk\7P\2\2kl\7N\2\2l\36\3\2" +
			"\2\2mn\t\2\2\2n \3\2\2\2op\t\3\2\2p\"\3\2\2\2\n\2(,\638?Z\\\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}