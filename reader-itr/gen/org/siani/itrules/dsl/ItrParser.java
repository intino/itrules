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
		RULE_BEGIN=1, WL=2, ID=3, TEXT=4, BODY=5, NOT=6, RULE_FUNCTION=7, NL=8, 
		WS=9, CONDITIONS=10, RULE_ERROR=11, NULL_CHAR=12, INDENT=13, RULE_END=14, 
		NEWLINE=15, ESCAPED_DOLLAR=16, ESCAPED_LQ=17, ESCAPED_RQ=18, MARK_KEY=19, 
		LEFT_SQ=20, RULE_TEXT=21, LIST=22, OPTION=23, END=24, SEPARATOR=25, MARK_ID=26, 
		MARK_ERROR=27, NULL_CH=28, RIGHT_SQ=29, EXP_ESCAPED_CHAR=30, EXPRESSION_MARK=31, 
		EXPRESSION_TEXT=32, EXPRESSION_ERROR=33;
	public static final int
		RULE_root = 0, RULE_defintion = 1, RULE_signature = 2, RULE_function = 3, 
		RULE_body = 4, RULE_line = 5, RULE_expression = 6, RULE_text = 7, RULE_mark = 8, 
		RULE_option = 9;
	public static final String[] ruleNames = {
		"root", "defintion", "signature", "function", "body", "line", "expression", 
		"text", "mark", "option"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'defrule'", null, null, "'text'", "'body'", "'!'", null, null, 
		null, null, null, null, "'\t'", "'\nendrule'", "'\n'", "'$$'", "'$['", 
		"'$]'", "'$'", "'['", null, "'...'", "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RULE_BEGIN", "WL", "ID", "TEXT", "BODY", "NOT", "RULE_FUNCTION", 
		"NL", "WS", "CONDITIONS", "RULE_ERROR", "NULL_CHAR", "INDENT", "RULE_END", 
		"NEWLINE", "ESCAPED_DOLLAR", "ESCAPED_LQ", "ESCAPED_RQ", "MARK_KEY", "LEFT_SQ", 
		"RULE_TEXT", "LIST", "OPTION", "END", "SEPARATOR", "MARK_ID", "MARK_ERROR", 
		"NULL_CH", "RIGHT_SQ", "EXP_ESCAPED_CHAR", "EXPRESSION_MARK", "EXPRESSION_TEXT", 
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
				function();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==NOT );
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ItrParser.ID, 0); }
		public TerminalNode CONDITIONS() { return getToken(ItrParser.CONDITIONS, 0); }
		public TerminalNode NOT() { return getToken(ItrParser.NOT, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ItrParserListener ) ((ItrParserListener)listener).exitFunction(this);
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

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(ItrParser.INDENT, 0); }
		public TerminalNode NEWLINE() { return getToken(ItrParser.NEWLINE, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
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
			setState(46); 
			match(INDENT);
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47); 
				line();
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0) );
			setState(52); 
			match(NEWLINE);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(57);
					switch (_input.LA(1)) {
					case TEXT:
						{
						setState(54); 
						text();
						}
						break;
					case MARK_KEY:
						{
						setState(55); 
						mark();
						}
						break;
					case LEFT_SQ:
						{
						setState(56); 
						expression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(59); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode LEFT_SQ() { return getToken(ItrParser.LEFT_SQ, 0); }
		public TerminalNode RIGHT_SQ() { return getToken(ItrParser.RIGHT_SQ, 0); }
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
			setState(61); 
			match(LEFT_SQ);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(65);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(62); 
					text();
					}
					break;
				case MARK_KEY:
					{
					setState(63); 
					mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(64); 
					expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70); 
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
			setState(72); 
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
		public TerminalNode MARK_KEY() { return getToken(ItrParser.MARK_KEY, 0); }
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
			setState(74); 
			match(MARK_KEY);
			setState(75); 
			match(ID);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION) {
				{
				{
				setState(76); 
				option();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(82); 
				match(LIST);
				setState(83); 
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
			setState(86); 
			match(OPTION);
			setState(87); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\\\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\6\4%\n"+
		"\4\r\4\16\4&\3\4\3\4\3\5\5\5,\n\5\3\5\3\5\3\5\3\6\3\6\6\6\63\n\6\r\6\16"+
		"\6\64\3\6\3\6\3\7\3\7\3\7\6\7<\n\7\r\7\16\7=\3\b\3\b\3\b\3\b\7\bD\n\b"+
		"\f\b\16\bG\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\nP\n\n\f\n\16\nS\13\n\3"+
		"\n\3\n\5\nW\n\n\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2"+
		"]\2\31\3\2\2\2\4\36\3\2\2\2\6$\3\2\2\2\b+\3\2\2\2\n\60\3\2\2\2\f;\3\2"+
		"\2\2\16?\3\2\2\2\20J\3\2\2\2\22L\3\2\2\2\24X\3\2\2\2\26\30\5\4\3\2\27"+
		"\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33"+
		"\31\3\2\2\2\34\35\7\2\2\3\35\3\3\2\2\2\36\37\7\3\2\2\37 \5\6\4\2 !\5\n"+
		"\6\2!\"\7\20\2\2\"\5\3\2\2\2#%\5\b\5\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&"+
		"\'\3\2\2\2\'(\3\2\2\2()\7\7\2\2)\7\3\2\2\2*,\7\b\2\2+*\3\2\2\2+,\3\2\2"+
		"\2,-\3\2\2\2-.\7\5\2\2./\7\f\2\2/\t\3\2\2\2\60\62\7\17\2\2\61\63\5\f\7"+
		"\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2"+
		"\2\66\67\7\21\2\2\67\13\3\2\2\28<\5\20\t\29<\5\22\n\2:<\5\16\b\2;8\3\2"+
		"\2\2;9\3\2\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\r\3\2\2\2?E\7"+
		"\26\2\2@D\5\20\t\2AD\5\22\n\2BD\5\16\b\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2"+
		"DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\37\2\2I\17\3\2"+
		"\2\2JK\7\6\2\2K\21\3\2\2\2LM\7\25\2\2MQ\7\5\2\2NP\5\24\13\2ON\3\2\2\2"+
		"PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RV\3\2\2\2SQ\3\2\2\2TU\7\30\2\2UW\7\33\2"+
		"\2VT\3\2\2\2VW\3\2\2\2W\23\3\2\2\2XY\7\31\2\2YZ\7\5\2\2Z\25\3\2\2\2\f"+
		"\31&+\64;=CEQV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}