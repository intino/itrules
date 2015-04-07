// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ItrParser.g4 by ANTLR 4.5
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
public class ItrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_BEGIN=1, WL=2, BODY=3, NOT=4, FUNCTION=5, NL=6, WS=7, PARAMETERS=8, 
		RULE_ERROR=9, INDENT=10, RULE_END=11, NEWLINE=12, DOLLAR=13, LSB=14, RSB=15, 
		TRIGGER=16, LEFT_SB=17, TEXT=18, LIST=19, OPTION=20, NULL=21, SEPARATOR=22, 
		ID=23, MARK_ERROR=24, RIGHT_SB=25, EXPRESSION_DOLLAR=26, EXPRESSION_LSB=27, 
		EXPRESSION_RSB=28, EXPRESSION_TRIGGER=29, EXPRESSION_TEXT=30, EXPRESSION_ERROR=31;
	public static final int
		RULE_root = 0, RULE_defintion = 1, RULE_signature = 2, RULE_condition = 3, 
		RULE_body = 4, RULE_line = 5, RULE_expression = 6, RULE_text = 7, RULE_mark = 8, 
		RULE_option = 9;
	public static final String[] ruleNames = {
		"root", "defintion", "signature", "condition", "body", "line", "expression", 
		"text", "mark", "option"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, "'body'", "'!'", null, null, null, null, null, 
		"'\t'", "'\nendrule'", "'\n'", null, null, null, "'$'", "'['", null, "'...'", 
		"'+'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "BODY", "NOT", "FUNCTION", "NL", "WS", "PARAMETERS", 
		"RULE_ERROR", "INDENT", "RULE_END", "NEWLINE", "DOLLAR", "LSB", "RSB", 
		"TRIGGER", "LEFT_SB", "TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", 
		"MARK_ERROR", "RIGHT_SB", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", 
		"EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_ERROR"
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
	public String getGrammarFileName() { return "ItrParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ItrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ItrParser.EOF, 0); }
		public List<DefintionContext> defintion() {
			return getRuleContexts(DefintionContext.class);
		}
		public DefintionContext defintion(int i) {
			return getRuleContext(DefintionContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitRoot(this);
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
				defintion();
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

	public static class DefintionContext extends ParserRuleContext {
		public TerminalNode RULE_BEGIN() { return getToken(ItrParser.RULE_BEGIN, 0); }
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RULE_END() { return getToken(ItrParser.RULE_END, 0); }
		public DefintionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defintion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterDefintion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitDefintion(this);
		}
	}

	public final DefintionContext defintion() throws RecognitionException {
		DefintionContext _localctx = new DefintionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_defintion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			match(RULE_BEGIN);
			setState(29); 
			signature();
			setState(30); 
			body();
			setState(31); 
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
		public TerminalNode BODY() { return getToken(ItrParser.BODY, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitSignature(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33); 
				condition();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOT || _la==FUNCTION );
			setState(38); 
			match(BODY);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(ItrParser.FUNCTION, 0); }
		public TerminalNode PARAMETERS() { return getToken(ItrParser.PARAMETERS, 0); }
		public TerminalNode NOT() { return getToken(ItrParser.NOT, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_condition);
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
			match(FUNCTION);
			setState(44); 
			match(PARAMETERS);
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
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(ItrParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ItrParser.NL, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(46); 
					line();
					setState(47); 
					match(NL);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(54); 
			line();
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

	public static class LineContext extends ParserRuleContext {
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
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRIGGER) | (1L << LEFT_SB) | (1L << TEXT))) != 0)) {
				{
				setState(59);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(56); 
					text();
					}
					break;
				case TRIGGER:
					{
					setState(57); 
					mark();
					}
					break;
				case LEFT_SB:
					{
					setState(58); 
					expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
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
		public TerminalNode LEFT_SB() { return getToken(ItrParser.LEFT_SB, 0); }
		public TerminalNode RIGHT_SB() { return getToken(ItrParser.RIGHT_SB, 0); }
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
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); 
			match(LEFT_SB);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRIGGER) | (1L << LEFT_SB) | (1L << TEXT))) != 0)) {
				{
				setState(68);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(65); 
					text();
					}
					break;
				case TRIGGER:
					{
					setState(66); 
					mark();
					}
					break;
				case LEFT_SB:
					{
					setState(67); 
					expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73); 
			match(RIGHT_SB);
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
		public TerminalNode TEXT() { return getToken(ItrParser.TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); 
			match(TEXT);
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
		public TerminalNode TRIGGER() { return getToken(ItrParser.TRIGGER, 0); }
		public TerminalNode ID() { return getToken(ItrParser.ID, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public TerminalNode LIST() { return getToken(ItrParser.LIST, 0); }
		public TerminalNode SEPARATOR() { return getToken(ItrParser.SEPARATOR, 0); }
		public MarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitMark(this);
		}
	}

	public final MarkContext mark() throws RecognitionException {
		MarkContext _localctx = new MarkContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			match(TRIGGER);
			setState(78); 
			match(ID);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION) {
				{
				{
				setState(79); 
				option();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(85); 
				match(LIST);
				setState(86); 
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
		public TerminalNode OPTION() { return getToken(ItrParser.OPTION, 0); }
		public TerminalNode ID() { return getToken(ItrParser.ID, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitOption(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			match(OPTION);
			setState(90); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!_\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\6\4%\n\4"+
		"\r\4\16\4&\3\4\3\4\3\5\5\5,\n\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\64\n\6\f\6"+
		"\16\6\67\13\6\3\6\3\6\3\7\3\7\3\7\7\7>\n\7\f\7\16\7A\13\7\3\b\3\b\3\b"+
		"\3\b\7\bG\n\b\f\b\16\bJ\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\nS\n\n\f\n"+
		"\16\nV\13\n\3\n\3\n\5\nZ\n\n\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16"+
		"\20\22\24\2\2`\2\31\3\2\2\2\4\36\3\2\2\2\6$\3\2\2\2\b+\3\2\2\2\n\65\3"+
		"\2\2\2\f?\3\2\2\2\16B\3\2\2\2\20M\3\2\2\2\22O\3\2\2\2\24[\3\2\2\2\26\30"+
		"\5\4\3\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34"+
		"\3\2\2\2\33\31\3\2\2\2\34\35\7\2\2\3\35\3\3\2\2\2\36\37\7\3\2\2\37 \5"+
		"\6\4\2 !\5\n\6\2!\"\7\r\2\2\"\5\3\2\2\2#%\5\b\5\2$#\3\2\2\2%&\3\2\2\2"+
		"&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\5\2\2)\7\3\2\2\2*,\7\6\2\2+*\3\2"+
		"\2\2+,\3\2\2\2,-\3\2\2\2-.\7\7\2\2./\7\n\2\2/\t\3\2\2\2\60\61\5\f\7\2"+
		"\61\62\7\b\2\2\62\64\3\2\2\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2"+
		"\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\5\f\7\29\13\3\2\2\2:>\5\20"+
		"\t\2;>\5\22\n\2<>\5\16\b\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3"+
		"\2\2\2?@\3\2\2\2@\r\3\2\2\2A?\3\2\2\2BH\7\23\2\2CG\5\20\t\2DG\5\22\n\2"+
		"EG\5\16\b\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2"+
		"\2IK\3\2\2\2JH\3\2\2\2KL\7\33\2\2L\17\3\2\2\2MN\7\24\2\2N\21\3\2\2\2O"+
		"P\7\22\2\2PT\7\31\2\2QS\5\24\13\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2"+
		"\2\2UY\3\2\2\2VT\3\2\2\2WX\7\25\2\2XZ\7\30\2\2YW\3\2\2\2YZ\3\2\2\2Z\23"+
		"\3\2\2\2[\\\7\26\2\2\\]\7\31\2\2]\25\3\2\2\2\f\31&+\65=?FHTY";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}