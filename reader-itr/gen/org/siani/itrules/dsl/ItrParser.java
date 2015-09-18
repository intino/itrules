// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ItrParser.g4 by ANTLR 4.5.1
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ItrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN_RULE=1, WL=2, BEGIN_BODY=3, COMMENT=4, NOT=5, FUNCTION=6, END_SIGNATURE=7, 
		WS=8, PARAMETERS=9, RULE_ERROR=10, END_RULE=11, NEWLINE=12, DOLLAR=13, 
		LSB=14, RSB=15, TRIGGER=16, BEGIN_EXPRESSION=17, NULL_SEPARATOR=18, TEXT=19, 
		LIST=20, OPTION=21, NULL=22, SEPARATOR=23, ID=24, MARK_ERROR=25, ELSE=26, 
		END_EXPRESSION=27, EXPRESSION_DOLLAR=28, EXPRESSION_LSB=29, EXPRESSION_RSB=30, 
		EXPRESSION_NULL=31, EXPRESSION_TRIGGER=32, EXPRESSION_TEXT=33, EXPRESSION_NL=34, 
		EXPRESSION_ERROR=35;
	public static final int
		RULE_root = 0, RULE_definition = 1, RULE_signature = 2, RULE_condition = 3, 
		RULE_body = 4, RULE_expression = 5, RULE_expressionBody = 6, RULE_text = 7, 
		RULE_mark = 8, RULE_option = 9;
	public static final String[] ruleNames = {
		"root", "definition", "signature", "condition", "body", "expression", 
		"expressionBody", "text", "mark", "option"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", null, "'body'", null, "'!'", null, null, null, null, null, 
		null, null, null, null, null, "'$'", "'['", null, null, "'...'", "'+'", 
		null, null, null, null, "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN_RULE", "WL", "BEGIN_BODY", "COMMENT", "NOT", "FUNCTION", 
		"END_SIGNATURE", "WS", "PARAMETERS", "RULE_ERROR", "END_RULE", "NEWLINE", 
		"DOLLAR", "LSB", "RSB", "TRIGGER", "BEGIN_EXPRESSION", "NULL_SEPARATOR", 
		"TEXT", "LIST", "OPTION", "NULL", "SEPARATOR", "ID", "MARK_ERROR", "ELSE", 
		"END_EXPRESSION", "EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", 
		"EXPRESSION_NULL", "EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", 
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
		public List<TerminalNode> COMMENT() { return getTokens(ItrParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(ItrParser.COMMENT, i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
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
			while (_la==COMMENT) {
				{
				{
				setState(20);
				match(COMMENT);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				definition();
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT) {
					{
					{
					setState(27);
					match(COMMENT);
					}
					}
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BEGIN_RULE );
			setState(37);
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

	public static class DefinitionContext extends ParserRuleContext {
		public TerminalNode BEGIN_RULE() { return getToken(ItrParser.BEGIN_RULE, 0); }
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END_RULE() { return getToken(ItrParser.END_RULE, 0); }
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitDefinition(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(BEGIN_RULE);
			setState(40);
			signature();
			setState(41);
			body();
			setState(42);
			match(END_RULE);
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
		public TerminalNode BEGIN_BODY() { return getToken(ItrParser.BEGIN_BODY, 0); }
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
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				condition();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOT || _la==FUNCTION );
			setState(49);
			match(BEGIN_BODY);
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
		public TerminalNode NOT() { return getToken(ItrParser.NOT, 0); }
		public TerminalNode PARAMETERS() { return getToken(ItrParser.PARAMETERS, 0); }
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
			setState(52);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(51);
				match(NOT);
				}
			}

			setState(54);
			match(FUNCTION);
			setState(56);
			_la = _input.LA(1);
			if (_la==PARAMETERS) {
				{
				setState(55);
				match(PARAMETERS);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRIGGER) | (1L << BEGIN_EXPRESSION) | (1L << TEXT))) != 0)) {
				{
				setState(61);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(58);
					text();
					}
					break;
				case TRIGGER:
					{
					setState(59);
					mark();
					}
					break;
				case BEGIN_EXPRESSION:
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
		public TerminalNode BEGIN_EXPRESSION() { return getToken(ItrParser.BEGIN_EXPRESSION, 0); }
		public TerminalNode END_EXPRESSION() { return getToken(ItrParser.END_EXPRESSION, 0); }
		public List<ExpressionBodyContext> expressionBody() {
			return getRuleContexts(ExpressionBodyContext.class);
		}
		public ExpressionBodyContext expressionBody(int i) {
			return getRuleContext(ExpressionBodyContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(ItrParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(ItrParser.ELSE, i);
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
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(BEGIN_EXPRESSION);
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				expressionBody();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRIGGER) | (1L << BEGIN_EXPRESSION) | (1L << TEXT))) != 0) );
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSE) {
				{
				{
				setState(72);
				match(ELSE);
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(73);
					expressionBody();
					}
					}
					setState(76); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRIGGER) | (1L << BEGIN_EXPRESSION) | (1L << TEXT))) != 0) );
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(END_EXPRESSION);
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

	public static class ExpressionBodyContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterExpressionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitExpressionBody(this);
		}
	}

	public final ExpressionBodyContext expressionBody() throws RecognitionException {
		ExpressionBodyContext _localctx = new ExpressionBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expressionBody);
		try {
			setState(88);
			switch (_input.LA(1)) {
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				text();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				mark();
				}
				break;
			case BEGIN_EXPRESSION:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
			setState(90);
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
			setState(92);
			match(TRIGGER);
			setState(93);
			match(ID);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION) {
				{
				{
				setState(94);
				option();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(100);
				match(LIST);
				setState(101);
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
			setState(104);
			match(OPTION);
			setState(105);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%n\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\6\2$\n"+
		"\2\r\2\16\2%\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\6\4\60\n\4\r\4\16\4\61\3"+
		"\4\3\4\3\5\5\5\67\n\5\3\5\3\5\5\5;\n\5\3\6\3\6\3\6\7\6@\n\6\f\6\16\6C"+
		"\13\6\3\7\3\7\6\7G\n\7\r\7\16\7H\3\7\3\7\6\7M\n\7\r\7\16\7N\7\7Q\n\7\f"+
		"\7\16\7T\13\7\3\7\3\7\3\b\3\b\3\b\5\b[\n\b\3\t\3\t\3\n\3\n\3\n\7\nb\n"+
		"\n\f\n\16\ne\13\n\3\n\3\n\5\ni\n\n\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n"+
		"\f\16\20\22\24\2\2s\2\31\3\2\2\2\4)\3\2\2\2\6/\3\2\2\2\b\66\3\2\2\2\n"+
		"A\3\2\2\2\fD\3\2\2\2\16Z\3\2\2\2\20\\\3\2\2\2\22^\3\2\2\2\24j\3\2\2\2"+
		"\26\30\7\6\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2"+
		"\32#\3\2\2\2\33\31\3\2\2\2\34 \5\4\3\2\35\37\7\6\2\2\36\35\3\2\2\2\37"+
		"\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!$\3\2\2\2\" \3\2\2\2#\34\3\2\2\2$%\3"+
		"\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7\2\2\3(\3\3\2\2\2)*\7\3\2\2"+
		"*+\5\6\4\2+,\5\n\6\2,-\7\r\2\2-\5\3\2\2\2.\60\5\b\5\2/.\3\2\2\2\60\61"+
		"\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\5\2\2\64\7\3"+
		"\2\2\2\65\67\7\7\2\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\28:\7\b\2\2"+
		"9;\7\13\2\2:9\3\2\2\2:;\3\2\2\2;\t\3\2\2\2<@\5\20\t\2=@\5\22\n\2>@\5\f"+
		"\7\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\13\3"+
		"\2\2\2CA\3\2\2\2DF\7\23\2\2EG\5\16\b\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2H"+
		"I\3\2\2\2IR\3\2\2\2JL\7\34\2\2KM\5\16\b\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2"+
		"\2NO\3\2\2\2OQ\3\2\2\2PJ\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2"+
		"\2TR\3\2\2\2UV\7\35\2\2V\r\3\2\2\2W[\5\20\t\2X[\5\22\n\2Y[\5\f\7\2ZW\3"+
		"\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\17\3\2\2\2\\]\7\25\2\2]\21\3\2\2\2^_\7\22"+
		"\2\2_c\7\32\2\2`b\5\24\13\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dh"+
		"\3\2\2\2ec\3\2\2\2fg\7\26\2\2gi\7\31\2\2hf\3\2\2\2hi\3\2\2\2i\23\3\2\2"+
		"\2jk\7\27\2\2kl\7\32\2\2l\25\3\2\2\2\20\31 %\61\66:?AHNRZch";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}