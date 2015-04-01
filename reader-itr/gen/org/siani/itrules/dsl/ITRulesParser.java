// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ITRulesParser.g4 by ANTLR 4.5
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ITRulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_BEGIN=1, WL=2, ID=3, TEXT=4, OPTION=5, CONDITIONS=6, EVAL=7, NOT=8, 
		TRIGGER=9, RULE_FUNCTION=10, NL=11, WS=12, RULE_ERROR=13, NULL_CHAR=14, 
		SCAPED_CHAR=15, MARK_KEY=16, LEFT_SQ=17, RULE_END=18, RULE_TEXT=19, LIST=20, 
		MARK_OPTION=21, END=22, SEPARATOR=23, MARK_ID=24, MARK_ERROR=25, NULL_CH=26, 
		RIGHT_SQ=27, EXP_SCAPED_CHAR=28, EXPRESSION_MARK=29, EXPRESSION_TEXT=30;
	public static final int
		RULE_root = 0, RULE_itrule = 1, RULE_signature = 2, RULE_function = 3, 
		RULE_trigger = 4, RULE_body = 5, RULE_expression = 6, RULE_text = 7, RULE_mark = 8, 
		RULE_option = 9;
	public static final String[] ruleNames = {
		"root", "itrule", "signature", "function", "trigger", "body", "expression", 
		"text", "mark", "option"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, null, "'text'", null, null, "'eval'", "'!'", 
		"'trigger'", null, null, null, null, null, null, "'$'", "'['", "'\\u0015'", 
		null, "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "ID", "TEXT", "OPTION", "CONDITIONS", "EVAL", 
		"NOT", "TRIGGER", "RULE_FUNCTION", "NL", "WS", "RULE_ERROR", "NULL_CHAR", 
		"SCAPED_CHAR", "MARK_KEY", "LEFT_SQ", "RULE_END", "RULE_TEXT", "LIST", 
		"MARK_OPTION", "END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "NULL_CH", 
		"RIGHT_SQ", "EXP_SCAPED_CHAR", "EXPRESSION_MARK", "EXPRESSION_TEXT"
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

	@Override
	public String getGrammarFileName() { return "ITRulesParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ITRulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ITRulesParser.EOF, 0); }
		public List<ItruleContext> itrule() {
			return getRuleContexts(ItruleContext.class);
		}
		public ItruleContext itrule(int i) {
			return getRuleContext(ItruleContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RULE_BEGIN) {
				{
				{
				setState(20); 
				itrule();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26); 
			match(EOF);
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

	public static class ItruleContext extends ParserRuleContext {
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RULE_END() { return getToken(ITRulesParser.RULE_END, 0); }
		public ItruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterItrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitItrule(this);
		}
	}

	public final ItruleContext itrule() throws RecognitionException {
		ItruleContext _localctx = new ItruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_itrule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			signature();
			setState(29); 
			body();
			setState(30); 
			match(RULE_END);
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

	public static class SignatureContext extends ParserRuleContext {
		public TerminalNode RULE_BEGIN() { return getToken(ITRulesParser.RULE_BEGIN, 0); }
		public TerminalNode NL() { return getToken(ITRulesParser.NL, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitSignature(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); 
			match(RULE_BEGIN);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33); 
				function();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==NOT );
			setState(38); 
			match(NL);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public TerminalNode CONDITIONS() { return getToken(ITRulesParser.CONDITIONS, 0); }
		public TerminalNode NOT() { return getToken(ITRulesParser.NOT, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(40); 
				match(NOT);
				}
			}

			setState(43); 
			match(ID);
			setState(44); 
			match(CONDITIONS);
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

	public static class TriggerContext extends ParserRuleContext {
		public TerminalNode TRIGGER() { return getToken(ITRulesParser.TRIGGER, 0); }
		public TerminalNode CONDITIONS() { return getToken(ITRulesParser.CONDITIONS, 0); }
		public TriggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterTrigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitTrigger(this);
		}
	}

	public final TriggerContext trigger() throws RecognitionException {
		TriggerContext _localctx = new TriggerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			match(TRIGGER);
			setState(47); 
			match(CONDITIONS);
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

	public static class BodyContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<MarkContext> mark() {
			return getRuleContexts(MarkContext.class);
		}
		public MarkContext mark(int i) {
			return getRuleContext(MarkContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ) | (1L << EXP_SCAPED_CHAR))) != 0)) {
				{
				setState(52);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
				case EXP_SCAPED_CHAR:
					{
					setState(49); 
					text();
					}
					break;
				case MARK_KEY:
					{
					setState(50); 
					mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(51); 
					expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(56);
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
		public TerminalNode LEFT_SQ() { return getToken(ITRulesParser.LEFT_SQ, 0); }
		public TerminalNode RIGHT_SQ() { return getToken(ITRulesParser.RIGHT_SQ, 0); }
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<MarkContext> mark() {
			return getRuleContexts(MarkContext.class);
		}
		public MarkContext mark(int i) {
			return getRuleContext(MarkContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			match(LEFT_SQ);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ) | (1L << EXP_SCAPED_CHAR))) != 0)) {
				{
				setState(61);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
				case EXP_SCAPED_CHAR:
					{
					setState(58); 
					text();
					}
					break;
				case MARK_KEY:
					{
					setState(59); 
					mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(60); 
					expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66); 
			match(RIGHT_SQ);
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
		public TerminalNode TEXT() { return getToken(ITRulesParser.TEXT, 0); }
		public TerminalNode SCAPED_CHAR() { return getToken(ITRulesParser.SCAPED_CHAR, 0); }
		public TerminalNode EXP_SCAPED_CHAR() { return getToken(ITRulesParser.EXP_SCAPED_CHAR, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << EXP_SCAPED_CHAR))) != 0)) ) {
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
		public TerminalNode MARK_KEY() { return getToken(ITRulesParser.MARK_KEY, 0); }
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public TerminalNode LIST() { return getToken(ITRulesParser.LIST, 0); }
		public TerminalNode SEPARATOR() { return getToken(ITRulesParser.SEPARATOR, 0); }
		public MarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitMark(this);
		}
	}

	public final MarkContext mark() throws RecognitionException {
		MarkContext _localctx = new MarkContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); 
			match(MARK_KEY);
			setState(71); 
			match(ID);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION) {
				{
				{
				setState(72); 
				option();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(78); 
				match(LIST);
				setState(79); 
				match(SEPARATOR);
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

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(ITRulesParser.OPTION, 0); }
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitOption(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); 
			match(OPTION);
			setState(83); 
			match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 X\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\6\4%\n\4"+
		"\r\4\16\4&\3\4\3\4\3\5\5\5,\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\7"+
		"\7\67\n\7\f\7\16\7:\13\7\3\b\3\b\3\b\3\b\7\b@\n\b\f\b\16\bC\13\b\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\7\nL\n\n\f\n\16\nO\13\n\3\n\3\n\5\nS\n\n\3\13\3"+
		"\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\5\2\6\6\21\21\36\36X\2"+
		"\31\3\2\2\2\4\36\3\2\2\2\6\"\3\2\2\2\b+\3\2\2\2\n\60\3\2\2\2\f8\3\2\2"+
		"\2\16;\3\2\2\2\20F\3\2\2\2\22H\3\2\2\2\24T\3\2\2\2\26\30\5\4\3\2\27\26"+
		"\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31"+
		"\3\2\2\2\34\35\7\2\2\3\35\3\3\2\2\2\36\37\5\6\4\2\37 \5\f\7\2 !\7\24\2"+
		"\2!\5\3\2\2\2\"$\7\3\2\2#%\5\b\5\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3"+
		"\2\2\2\'(\3\2\2\2()\7\r\2\2)\7\3\2\2\2*,\7\n\2\2+*\3\2\2\2+,\3\2\2\2,"+
		"-\3\2\2\2-.\7\5\2\2./\7\b\2\2/\t\3\2\2\2\60\61\7\13\2\2\61\62\7\b\2\2"+
		"\62\13\3\2\2\2\63\67\5\20\t\2\64\67\5\22\n\2\65\67\5\16\b\2\66\63\3\2"+
		"\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\r"+
		"\3\2\2\2:8\3\2\2\2;A\7\23\2\2<@\5\20\t\2=@\5\22\n\2>@\5\16\b\2?<\3\2\2"+
		"\2?=\3\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2"+
		"\2DE\7\35\2\2E\17\3\2\2\2FG\t\2\2\2G\21\3\2\2\2HI\7\22\2\2IM\7\5\2\2J"+
		"L\5\24\13\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NR\3\2\2\2OM\3\2\2"+
		"\2PQ\7\26\2\2QS\7\31\2\2RP\3\2\2\2RS\3\2\2\2S\23\3\2\2\2TU\7\7\2\2UV\7"+
		"\5\2\2V\25\3\2\2\2\13\31&+\668?AMR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}