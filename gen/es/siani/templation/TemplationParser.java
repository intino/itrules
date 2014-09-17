// Generated from /Users/oroncal/workspace/sandbox/templation/src/es/siani/templation/TemplationParser.g4 by ANTLR 4.4.1-dev
package es.siani.templation;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TemplationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=15, MARK_ERROR=8, SCAPED_CHAR=5, SEPARATOR=7, NOT=16, TEXT=2, 
		BLOCK_FILTER=10, LIST=3, EXPRESSION_TEXT=26, MARK_KEY=20, IF=9, TAG=4, 
		NAME=18, WS=11, BLOCK_NAME=12, BLOCK_KEY=1, BLOCK_ERROR=19, DOUBLE=14, 
		BLOCK_TEXT=23, MARK_NAME=6, NL=17, EXPRESSION_MARK=24, LEFT_SQ=21, END=22, 
		RIGHT_SQ=25, STRING=13;
	public static final String[] tokenNames = {
		"<INVALID>", "BLOCK_KEY", "TEXT", "'...'", "TAG", "SCAPED_CHAR", "MARK_NAME", 
		"SEPARATOR", "MARK_ERROR", "'if'", "BLOCK_FILTER", "' '", "BLOCK_NAME", 
		"'String'", "'Double'", "'Integer'", "'!'", "NL", "NAME", "BLOCK_ERROR", 
		"'$'", "'['", "END", "BLOCK_TEXT", "EXPRESSION_MARK", "RIGHT_SQ", "EXPRESSION_TEXT"
	};
	public static final int
		RULE_root = 0, RULE_block = 1, RULE_blockSignature = 2, RULE_blockBody = 3, 
		RULE_expression = 4, RULE_filter = 5, RULE_text = 6, RULE_mark = 7;
	public static final String[] ruleNames = {
		"root", "block", "blockSignature", "blockBody", "expression", "filter", 
		"text", "mark"
	};

	@Override
	public String getGrammarFileName() { return "TemplationParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TemplationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TemplationParser.EOF, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_la = _input.LA(1);
			if (_la==TEXT || _la==SCAPED_CHAR) {
				{
				setState(16); text();
				}
			}

			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BLOCK_KEY) {
				{
				{
				setState(19); block();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockSignatureContext blockSignature() {
			return getRuleContext(BlockSignatureContext.class,0);
		}
		public BlockBodyContext blockBody() {
			return getRuleContext(BlockBodyContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); blockSignature();
			setState(28); blockBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockSignatureContext extends ParserRuleContext {
		public TerminalNode BLOCK_FILTER() { return getToken(TemplationParser.BLOCK_FILTER, 0); }
		public TerminalNode IF() { return getToken(TemplationParser.IF, 0); }
		public TerminalNode NL() { return getToken(TemplationParser.NL, 0); }
		public TerminalNode BLOCK_KEY() { return getToken(TemplationParser.BLOCK_KEY, 0); }
		public List<TerminalNode> WS() { return getTokens(TemplationParser.WS); }
		public TerminalNode NOT() { return getToken(TemplationParser.NOT, 0); }
		public TerminalNode WS(int i) {
			return getToken(TemplationParser.WS, i);
		}
		public List<TerminalNode> BLOCK_NAME() { return getTokens(TemplationParser.BLOCK_NAME); }
		public TerminalNode BLOCK_NAME(int i) {
			return getToken(TemplationParser.BLOCK_NAME, i);
		}
		public BlockSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterBlockSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitBlockSignature(this);
		}
	}

	public final BlockSignatureContext blockSignature() throws RecognitionException {
		BlockSignatureContext _localctx = new BlockSignatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(BLOCK_KEY);
			setState(31); match(BLOCK_NAME);
			setState(34);
			_la = _input.LA(1);
			if (_la==BLOCK_FILTER) {
				{
				setState(32); match(BLOCK_FILTER);
				setState(33); match(BLOCK_NAME);
				}
			}

			setState(51);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(36); match(WS);
					}
					}
					setState(39); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(41); match(IF);
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(42); match(WS);
					}
					}
					setState(45); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(48);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(47); match(NOT);
					}
				}

				setState(50); match(BLOCK_NAME);
				}
			}

			setState(53); match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockBodyContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public MarkContext mark(int i) {
			return getRuleContext(MarkContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<MarkContext> mark() {
			return getRuleContexts(MarkContext.class);
		}
		public BlockBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterBlockBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitBlockBody(this);
		}
	}

	public final BlockBodyContext blockBody() throws RecognitionException {
		BlockBodyContext _localctx = new BlockBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blockBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(58);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(55); text();
					}
					break;
				case MARK_KEY:
					{
					setState(56); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(57); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_SQ() { return getToken(TemplationParser.RIGHT_SQ, 0); }
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public MarkContext mark(int i) {
			return getRuleContext(MarkContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<MarkContext> mark() {
			return getRuleContexts(MarkContext.class);
		}
		public TerminalNode LEFT_SQ() { return getToken(TemplationParser.LEFT_SQ, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(LEFT_SQ);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(67);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(64); text();
					}
					break;
				case MARK_KEY:
					{
					setState(65); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(66); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72); match(RIGHT_SQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TemplationParser.IF, 0); }
		public List<TerminalNode> MARK_NAME() { return getTokens(TemplationParser.MARK_NAME); }
		public TerminalNode MARK_NAME(int i) {
			return getToken(TemplationParser.MARK_NAME, i);
		}
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitFilter(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(IF);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75); match(MARK_NAME);
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MARK_NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(TemplationParser.TEXT, 0); }
		public TerminalNode SCAPED_CHAR() { return getToken(TemplationParser.SCAPED_CHAR, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !(_la==TEXT || _la==SCAPED_CHAR) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MarkContext extends ParserRuleContext {
		public TerminalNode MARK_KEY() { return getToken(TemplationParser.MARK_KEY, 0); }
		public TerminalNode SEPARATOR() { return getToken(TemplationParser.SEPARATOR, 0); }
		public TerminalNode LIST() { return getToken(TemplationParser.LIST, 0); }
		public TerminalNode TAG() { return getToken(TemplationParser.TAG, 0); }
		public List<TerminalNode> MARK_NAME() { return getTokens(TemplationParser.MARK_NAME); }
		public TerminalNode MARK_NAME(int i) {
			return getToken(TemplationParser.MARK_NAME, i);
		}
		public MarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitMark(this);
		}
	}

	public final MarkContext mark() throws RecognitionException {
		MarkContext _localctx = new MarkContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); match(MARK_KEY);
			setState(83); match(MARK_NAME);
			setState(86);
			_la = _input.LA(1);
			if (_la==TAG) {
				{
				setState(84); match(TAG);
				setState(85); match(MARK_NAME);
				}
			}

			setState(90);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(88); match(LIST);
				setState(89); match(SEPARATOR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34_\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\5\2\24\n\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4%"+
		"\n\4\3\4\6\4(\n\4\r\4\16\4)\3\4\3\4\6\4.\n\4\r\4\16\4/\3\4\5\4\63\n\4"+
		"\3\4\5\4\66\n\4\3\4\3\4\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\6\3\6\3"+
		"\6\3\6\7\6F\n\6\f\6\16\6I\13\6\3\6\3\6\3\7\3\7\6\7O\n\7\r\7\16\7P\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\5\tY\n\t\3\t\3\t\5\t]\n\t\3\t\2\2\n\2\4\6\b\n\f\16"+
		"\20\2\3\4\2\4\4\7\7f\2\23\3\2\2\2\4\35\3\2\2\2\6 \3\2\2\2\b>\3\2\2\2\n"+
		"A\3\2\2\2\fL\3\2\2\2\16R\3\2\2\2\20T\3\2\2\2\22\24\5\16\b\2\23\22\3\2"+
		"\2\2\23\24\3\2\2\2\24\30\3\2\2\2\25\27\5\4\3\2\26\25\3\2\2\2\27\32\3\2"+
		"\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\30\3\2\2\2\33\34\7\2"+
		"\2\3\34\3\3\2\2\2\35\36\5\6\4\2\36\37\5\b\5\2\37\5\3\2\2\2 !\7\3\2\2!"+
		"$\7\16\2\2\"#\7\f\2\2#%\7\16\2\2$\"\3\2\2\2$%\3\2\2\2%\65\3\2\2\2&(\7"+
		"\r\2\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+-\7\13\2\2"+
		",.\7\r\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61"+
		"\63\7\22\2\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\66\7\16\2\2"+
		"\65\'\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\23\2\28\7\3\2\2\29=\5"+
		"\16\b\2:=\5\20\t\2;=\5\n\6\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=@\3\2\2\2>"+
		"<\3\2\2\2>?\3\2\2\2?\t\3\2\2\2@>\3\2\2\2AG\7\27\2\2BF\5\16\b\2CF\5\20"+
		"\t\2DF\5\n\6\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\33\2\2K\13\3\2\2\2LN\7\13\2\2MO\7\b\2\2N"+
		"M\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\r\3\2\2\2RS\t\2\2\2S\17\3\2\2"+
		"\2TU\7\26\2\2UX\7\b\2\2VW\7\6\2\2WY\7\b\2\2XV\3\2\2\2XY\3\2\2\2Y\\\3\2"+
		"\2\2Z[\7\5\2\2[]\7\t\2\2\\Z\3\2\2\2\\]\3\2\2\2]\21\3\2\2\2\20\23\30$)"+
		"/\62\65<>EGPX\\";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}