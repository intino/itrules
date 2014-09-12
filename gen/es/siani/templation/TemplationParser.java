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
		INTEGER=8, MARK_ID=4, NL_SEP=14, LETTER=15, BLOCK_KEY=11, DOUBLE=7, DIGIT=16, 
		NL=3, LEFT_SQ=1, TEXT=5, ID=9, LIST=13, RIGHT_SQ=2, MARK_KEY=10, STRING=6, 
		TAG=12, MARK=17;
	public static final String[] tokenNames = {
		"<INVALID>", "'['", "']'", "NL", "MARK_ID", "TEXT", "'String'", "'Double'", 
		"'Integer'", "ID", "'$'", "':'", "'+'", "'...'", "'$NL'", "LETTER", "DIGIT", 
		"MARK"
	};
	public static final int
		RULE_root = 0, RULE_block = 1, RULE_blockBody = 2, RULE_mark = 3, RULE_separator = 4, 
		RULE_expression = 5, RULE_blockID = 6;
	public static final String[] ruleNames = {
		"root", "block", "blockBody", "mark", "separator", "expression", "blockID"
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
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); block();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BLOCK_KEY );
			setState(19); match(EOF);
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
		public TerminalNode NL() { return getToken(TemplationParser.NL, 0); }
		public BlockBodyContext blockBody() {
			return getRuleContext(BlockBodyContext.class,0);
		}
		public BlockIDContext blockID() {
			return getRuleContext(BlockIDContext.class,0);
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
			setState(21); blockID();
			setState(22); match(NL);
			setState(23); blockBody();
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TEXT(int i) {
			return getToken(TemplationParser.TEXT, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(TemplationParser.TEXT); }
		public MarkContext mark(int i) {
			return getRuleContext(MarkContext.class,i);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<MarkContext> mark() {
			return getRuleContexts(MarkContext.class);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
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
		enterRule(_localctx, 4, RULE_blockBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(29);
					switch (_input.LA(1)) {
					case TEXT:
						{
						setState(25); match(TEXT);
						}
						break;
					case MARK:
						{
						setState(26); mark();
						}
						break;
					case LEFT_SQ:
						{
						setState(27); expression();
						}
						break;
					case BLOCK_KEY:
						{
						setState(28); block();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class MarkContext extends ParserRuleContext {
		public TerminalNode MARK() { return getToken(TemplationParser.MARK, 0); }
		public List<TerminalNode> ID() { return getTokens(TemplationParser.ID); }
		public SeparatorContext separator() {
			return getRuleContext(SeparatorContext.class,0);
		}
		public TerminalNode TAG() { return getToken(TemplationParser.TAG, 0); }
		public TerminalNode LIST() { return getToken(TemplationParser.LIST, 0); }
		public TerminalNode ID(int i) {
			return getToken(TemplationParser.ID, i);
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
		enterRule(_localctx, 6, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); match(MARK);
			setState(35); match(ID);
			setState(38);
			_la = _input.LA(1);
			if (_la==TAG) {
				{
				setState(36); match(TAG);
				setState(37); match(ID);
				}
			}

			{
			setState(40); match(LIST);
			setState(41); separator();
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

	public static class SeparatorContext extends ParserRuleContext {
		public TerminalNode NL_SEP() { return getToken(TemplationParser.NL_SEP, 0); }
		public TerminalNode RIGHT_SQ() { return getToken(TemplationParser.RIGHT_SQ, 0); }
		public TerminalNode TEXT() { return getToken(TemplationParser.TEXT, 0); }
		public TerminalNode LEFT_SQ() { return getToken(TemplationParser.LEFT_SQ, 0); }
		public SeparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_separator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterSeparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitSeparator(this);
		}
	}

	public final SeparatorContext separator() throws RecognitionException {
		SeparatorContext _localctx = new SeparatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_separator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(LEFT_SQ);
			setState(44);
			_la = _input.LA(1);
			if ( !(_la==TEXT || _la==NL_SEP) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(45); match(RIGHT_SQ);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_SQ() { return getToken(TemplationParser.RIGHT_SQ, 0); }
		public TerminalNode TEXT(int i) {
			return getToken(TemplationParser.TEXT, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(TemplationParser.TEXT); }
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
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47); match(LEFT_SQ);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(51);
					switch (_input.LA(1)) {
					case TEXT:
						{
						setState(48); match(TEXT);
						}
						break;
					case MARK:
						{
						setState(49); mark();
						}
						break;
					case LEFT_SQ:
						{
						setState(50); expression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(57);
			_la = _input.LA(1);
			if (_la==TEXT) {
				{
				setState(56); match(TEXT);
				}
			}

			setState(59); match(RIGHT_SQ);
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

	public static class BlockIDContext extends ParserRuleContext {
		public TerminalNode BLOCK_KEY() { return getToken(TemplationParser.BLOCK_KEY, 0); }
		public TerminalNode ID() { return getToken(TemplationParser.ID, 0); }
		public BlockIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).enterBlockID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplationParserListener ) ((TemplationParserListener)listener).exitBlockID(this);
		}
	}

	public final BlockIDContext blockID() throws RecognitionException {
		BlockIDContext _localctx = new BlockIDContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); match(BLOCK_KEY);
			setState(62); match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4 \n\4\f\4\16\4#\13\4\3\5\3"+
		"\5\3\5\3\5\5\5)\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\66"+
		"\n\7\f\7\16\79\13\7\3\7\5\7<\n\7\3\7\3\7\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b"+
		"\n\f\16\2\3\4\2\7\7\20\20E\2\21\3\2\2\2\4\27\3\2\2\2\6!\3\2\2\2\b$\3\2"+
		"\2\2\n-\3\2\2\2\f\61\3\2\2\2\16?\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22"+
		"\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\25\3\2\2\2\25\26\7\2\2\3\26"+
		"\3\3\2\2\2\27\30\5\16\b\2\30\31\7\5\2\2\31\32\5\6\4\2\32\5\3\2\2\2\33"+
		" \7\7\2\2\34 \5\b\5\2\35 \5\f\7\2\36 \5\4\3\2\37\33\3\2\2\2\37\34\3\2"+
		"\2\2\37\35\3\2\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\7"+
		"\3\2\2\2#!\3\2\2\2$%\7\23\2\2%(\7\13\2\2&\'\7\16\2\2\')\7\13\2\2(&\3\2"+
		"\2\2()\3\2\2\2)*\3\2\2\2*+\7\17\2\2+,\5\n\6\2,\t\3\2\2\2-.\7\3\2\2./\t"+
		"\2\2\2/\60\7\4\2\2\60\13\3\2\2\2\61\67\7\3\2\2\62\66\7\7\2\2\63\66\5\b"+
		"\5\2\64\66\5\f\7\2\65\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\669\3\2\2"+
		"\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29\67\3\2\2\2:<\7\7\2\2;:\3\2\2\2"+
		";<\3\2\2\2<=\3\2\2\2=>\7\4\2\2>\r\3\2\2\2?@\7\r\2\2@A\7\13\2\2A\17\3\2"+
		"\2\2\t\23\37!(\65\67;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}