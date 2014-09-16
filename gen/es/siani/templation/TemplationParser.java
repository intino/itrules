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
		RIGHT_SQUARE=7, WS=10, MARK=3, LETTER=13, SCAPED_CHAR=8, BLOCK_END=1, 
		BLOCK_KEY=5, NL=11, DIGIT=12, TEXT=9, ID=14, BLOCK_BEGIN=2, LEFT_SQUARE=6, 
		MARK_KEY=4;
	public static final String[] tokenNames = {
		"<INVALID>", "BLOCK_END", "BLOCK_BEGIN", "MARK", "'$'", "'#'", "'['", 
		"']'", "SCAPED_CHAR", "TEXT", "WS", "NL", "DIGIT", "LETTER", "ID"
	};
	public static final int
		RULE_root = 0, RULE_text = 1, RULE_expression = 2, RULE_block = 3;
	public static final String[] ruleNames = {
		"root", "text", "expression", "block"
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
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TerminalNode MARK(int i) {
			return getToken(TemplationParser.MARK, i);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(TemplationParser.EOF, 0); }
		public List<TerminalNode> MARK() { return getTokens(TemplationParser.MARK); }
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLOCK_BEGIN) | (1L << MARK) | (1L << LEFT_SQUARE) | (1L << SCAPED_CHAR) | (1L << TEXT))) != 0)) {
				{
				setState(12);
				switch (_input.LA(1)) {
				case MARK:
					{
					setState(8); match(MARK);
					}
					break;
				case LEFT_SQUARE:
					{
					setState(9); expression();
					}
					break;
				case BLOCK_BEGIN:
					{
					setState(10); block();
					}
					break;
				case SCAPED_CHAR:
				case TEXT:
					{
					setState(11); text();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17); match(EOF);
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
		enterRule(_localctx, 2, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_la = _input.LA(1);
			if ( !(_la==SCAPED_CHAR || _la==TEXT) ) {
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode MARK(int i) {
			return getToken(TemplationParser.MARK, i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_SQUARE() { return getToken(TemplationParser.LEFT_SQUARE, 0); }
		public List<TerminalNode> MARK() { return getTokens(TemplationParser.MARK); }
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public TerminalNode RIGHT_SQUARE() { return getToken(TemplationParser.RIGHT_SQUARE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
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
		enterRule(_localctx, 4, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21); match(LEFT_SQUARE);
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(25);
					switch (_input.LA(1)) {
					case SCAPED_CHAR:
					case TEXT:
						{
						setState(22); text();
						}
						break;
					case MARK:
						{
						setState(23); match(MARK);
						}
						break;
					case LEFT_SQUARE:
						{
						setState(24); expression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(31);
			_la = _input.LA(1);
			if (_la==SCAPED_CHAR || _la==TEXT) {
				{
				setState(30); text();
				}
			}

			setState(33); match(RIGHT_SQUARE);
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
		public TerminalNode MARK(int i) {
			return getToken(TemplationParser.MARK, i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public List<TerminalNode> MARK() { return getTokens(TemplationParser.MARK); }
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public TerminalNode BLOCK_BEGIN() { return getToken(TemplationParser.BLOCK_BEGIN, 0); }
		public TerminalNode BLOCK_END() { return getToken(TemplationParser.BLOCK_END, 0); }
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
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); match(BLOCK_BEGIN);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(38);
				switch (_input.LA(1)) {
				case SCAPED_CHAR:
				case TEXT:
					{
					setState(36); text();
					}
					break;
				case MARK:
					{
					setState(37); match(MARK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MARK) | (1L << SCAPED_CHAR) | (1L << TEXT))) != 0) );
			setState(42); match(BLOCK_END);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\7\4\34\n\4\f\4\16\4\37\13\4\3\4\5\4\"\n\4\3\4"+
		"\3\4\3\5\3\5\3\5\6\5)\n\5\r\5\16\5*\3\5\3\5\3\5\2\2\6\2\4\6\b\2\3\3\2"+
		"\n\13\64\2\20\3\2\2\2\4\25\3\2\2\2\6\27\3\2\2\2\b%\3\2\2\2\n\17\7\5\2"+
		"\2\13\17\5\6\4\2\f\17\5\b\5\2\r\17\5\4\3\2\16\n\3\2\2\2\16\13\3\2\2\2"+
		"\16\f\3\2\2\2\16\r\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21"+
		"\23\3\2\2\2\22\20\3\2\2\2\23\24\7\2\2\3\24\3\3\2\2\2\25\26\t\2\2\2\26"+
		"\5\3\2\2\2\27\35\7\b\2\2\30\34\5\4\3\2\31\34\7\5\2\2\32\34\5\6\4\2\33"+
		"\30\3\2\2\2\33\31\3\2\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35"+
		"\36\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2 \"\5\4\3\2! \3\2\2\2!\"\3\2\2\2"+
		"\"#\3\2\2\2#$\7\t\2\2$\7\3\2\2\2%(\7\4\2\2&)\5\4\3\2\')\7\5\2\2(&\3\2"+
		"\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\3\2\2-\t\3"+
		"\2\2\2\t\16\20\33\35!(*";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}