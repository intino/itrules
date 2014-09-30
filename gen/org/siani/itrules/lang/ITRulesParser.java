// Generated from /Users/oroncal/workspace/sandbox/itrules/src/org/siani/itrules/lang/ITRulesParser.g4 by ANTLR 4.4.1-dev
package org.siani.itrules.lang;
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
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RULE_ID=12, MARK_ID=20, MARK_ERROR=21, OPTION=5, RULE_BEGIN=1, SCAPED_CHAR=22, 
		TRIGGER=9, RIGHT_P=7, RULE_ERROR=15, SEPARATOR=19, RULE_TEXT=26, NOT=11, 
		TEXT=4, ID=3, LIST=16, EXPRESSION_TEXT=30, EXP_SCAPED_CHAR=28, MARK_KEY=23, 
		TYPE=8, WS=14, RULE_END=25, WL=2, EXPRESSION_MARK=29, NL=13, LEFT_SQ=24, 
		END=18, RIGHT_SQ=27, MARK_OPTION=17, ATTR=10, LEFT_P=6;
	public static final String[] tokenNames = {
		"<INVALID>", "'defrule'", "WL", "ID", "'text'", "OPTION", "'('", "')'", 
		"'type'", "'trigger'", "'attr'", "'!'", "RULE_ID", "NL", "WS", "RULE_ERROR", 
		"'...'", "MARK_OPTION", "'$~'", "SEPARATOR", "MARK_ID", "MARK_ERROR", 
		"SCAPED_CHAR", "'$'", "'['", "'~'", "RULE_TEXT", "RIGHT_SQ", "EXP_SCAPED_CHAR", 
		"EXPRESSION_MARK", "EXPRESSION_TEXT"
	};
	public static final int
		RULE_root = 0, RULE_itrule = 1, RULE_signature = 2, RULE_ruleType = 3, 
		RULE_value = 4, RULE_trigger = 5, RULE_triggerValue = 6, RULE_attr = 7, 
		RULE_body = 8, RULE_expression = 9, RULE_text = 10, RULE_mark = 11, RULE_option = 12;
	public static final String[] ruleNames = {
		"root", "itrule", "signature", "ruleType", "value", "trigger", "triggerValue", 
		"attr", "body", "expression", "text", "mark", "option"
	};

	@Override
	public String getGrammarFileName() { return "ITRulesParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public ItruleContext itrule(int i) {
			return getRuleContext(ItruleContext.class,i);
		}
		public List<ItruleContext> itrule() {
			return getRuleContexts(ItruleContext.class);
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RULE_BEGIN) {
				{
				{
				setState(26); itrule();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32); match(EOF);
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
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RULE_END() { return getToken(ITRulesParser.RULE_END, 0); }
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
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
			setState(34); signature();
			setState(35); body();
			setState(36); match(RULE_END);
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
		public List<AttrContext> attr() {
			return getRuleContexts(AttrContext.class);
		}
		public TerminalNode NL() { return getToken(ITRulesParser.NL, 0); }
		public TriggerContext trigger(int i) {
			return getRuleContext(TriggerContext.class,i);
		}
		public AttrContext attr(int i) {
			return getRuleContext(AttrContext.class,i);
		}
		public TerminalNode RULE_BEGIN() { return getToken(ITRulesParser.RULE_BEGIN, 0); }
		public RuleTypeContext ruleType(int i) {
			return getRuleContext(RuleTypeContext.class,i);
		}
		public List<TriggerContext> trigger() {
			return getRuleContexts(TriggerContext.class);
		}
		public List<RuleTypeContext> ruleType() {
			return getRuleContexts(RuleTypeContext.class);
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
			setState(38); match(RULE_BEGIN);
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(42);
				switch (_input.LA(1)) {
				case TYPE:
				case NOT:
					{
					setState(39); ruleType();
					}
					break;
				case TRIGGER:
					{
					setState(40); trigger();
					}
					break;
				case ATTR:
					{
					setState(41); attr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE) | (1L << TRIGGER) | (1L << ATTR) | (1L << NOT))) != 0) );
			setState(46); match(NL);
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

	public static class RuleTypeContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ITRulesParser.NOT, 0); }
		public TerminalNode TYPE() { return getToken(ITRulesParser.TYPE, 0); }
		public RuleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterRuleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitRuleType(this);
		}
	}

	public final RuleTypeContext ruleType() throws RecognitionException {
		RuleTypeContext _localctx = new RuleTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ruleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(48); match(NOT);
				}
			}

			setState(51); match(TYPE);
			setState(52); value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode LEFT_P() { return getToken(ITRulesParser.LEFT_P, 0); }
		public TerminalNode RIGHT_P() { return getToken(ITRulesParser.RIGHT_P, 0); }
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); match(LEFT_P);
			setState(55); match(ID);
			setState(56); match(RIGHT_P);
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
		public TriggerValueContext triggerValue() {
			return getRuleContext(TriggerValueContext.class,0);
		}
		public TerminalNode TRIGGER() { return getToken(ITRulesParser.TRIGGER, 0); }
		public TerminalNode LEFT_P() { return getToken(ITRulesParser.LEFT_P, 0); }
		public TerminalNode RIGHT_P() { return getToken(ITRulesParser.RIGHT_P, 0); }
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
		enterRule(_localctx, 10, RULE_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(TRIGGER);
			setState(59); match(LEFT_P);
			setState(60); triggerValue();
			setState(61); match(RIGHT_P);
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

	public static class TriggerValueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ITRulesParser.ID); }
		public TerminalNode OPTION() { return getToken(ITRulesParser.OPTION, 0); }
		public TerminalNode ID(int i) {
			return getToken(ITRulesParser.ID, i);
		}
		public TriggerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterTriggerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitTriggerValue(this);
		}
	}

	public final TriggerValueContext triggerValue() throws RecognitionException {
		TriggerValueContext _localctx = new TriggerValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_triggerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(ID);
			setState(66);
			_la = _input.LA(1);
			if (_la==OPTION) {
				{
				setState(64); match(OPTION);
				setState(65); match(ID);
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

	public static class AttrContext extends ParserRuleContext {
		public TerminalNode LEFT_P() { return getToken(ITRulesParser.LEFT_P, 0); }
		public TerminalNode RIGHT_P() { return getToken(ITRulesParser.RIGHT_P, 0); }
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public TerminalNode NOT() { return getToken(ITRulesParser.NOT, 0); }
		public TerminalNode ATTR() { return getToken(ITRulesParser.ATTR, 0); }
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitAttr(this);
		}
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(ATTR);
			setState(69); match(LEFT_P);
			setState(71);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(70); match(NOT);
				}
			}

			setState(73); match(ID);
			setState(74); match(RIGHT_P);
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
		enterRule(_localctx, 16, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(79);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(76); text();
					}
					break;
				case MARK_KEY:
					{
					setState(77); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(78); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(83);
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
		public TerminalNode RIGHT_SQ() { return getToken(ITRulesParser.RIGHT_SQ, 0); }
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
		public TerminalNode LEFT_SQ() { return getToken(ITRulesParser.LEFT_SQ, 0); }
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
		enterRule(_localctx, 18, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); match(LEFT_SQ);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(88);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(85); text();
					}
					break;
				case MARK_KEY:
					{
					setState(86); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(87); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93); match(RIGHT_SQ);
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
		enterRule(_localctx, 20, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
		public TerminalNode MARK_KEY() { return getToken(ITRulesParser.MARK_KEY, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public TerminalNode SEPARATOR() { return getToken(ITRulesParser.SEPARATOR, 0); }
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public TerminalNode LIST() { return getToken(ITRulesParser.LIST, 0); }
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
		enterRule(_localctx, 22, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(MARK_KEY);
			setState(98); match(ID);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION) {
				{
				{
				setState(99); option();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(105); match(LIST);
				setState(106); match(SEPARATOR);
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
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public TerminalNode OPTION() { return getToken(ITRulesParser.OPTION, 0); }
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
		enterRule(_localctx, 24, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); match(OPTION);
			setState(110); match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 s\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\6\4-\n\4\r\4\16\4.\3\4\3\4\3\5\5\5\64\n\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bE\n\b\3\t\3"+
		"\t\3\t\5\tJ\n\t\3\t\3\t\3\t\3\n\3\n\3\n\7\nR\n\n\f\n\16\nU\13\n\3\13\3"+
		"\13\3\13\3\13\7\13[\n\13\f\13\16\13^\13\13\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\7\rg\n\r\f\r\16\rj\13\r\3\r\3\r\5\rn\n\r\3\16\3\16\3\16\3\16\2\2\17"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\2\3\4\2\6\6\30\30t\2\37\3\2\2\2\4$\3"+
		"\2\2\2\6(\3\2\2\2\b\63\3\2\2\2\n8\3\2\2\2\f<\3\2\2\2\16A\3\2\2\2\20F\3"+
		"\2\2\2\22S\3\2\2\2\24V\3\2\2\2\26a\3\2\2\2\30c\3\2\2\2\32o\3\2\2\2\34"+
		"\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2"+
		"\2\2!\37\3\2\2\2\"#\7\2\2\3#\3\3\2\2\2$%\5\6\4\2%&\5\22\n\2&\'\7\33\2"+
		"\2\'\5\3\2\2\2(,\7\3\2\2)-\5\b\5\2*-\5\f\7\2+-\5\20\t\2,)\3\2\2\2,*\3"+
		"\2\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\7\17"+
		"\2\2\61\7\3\2\2\2\62\64\7\r\2\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65\3\2"+
		"\2\2\65\66\7\n\2\2\66\67\5\n\6\2\67\t\3\2\2\289\7\b\2\29:\7\5\2\2:;\7"+
		"\t\2\2;\13\3\2\2\2<=\7\13\2\2=>\7\b\2\2>?\5\16\b\2?@\7\t\2\2@\r\3\2\2"+
		"\2AD\7\5\2\2BC\7\7\2\2CE\7\5\2\2DB\3\2\2\2DE\3\2\2\2E\17\3\2\2\2FG\7\f"+
		"\2\2GI\7\b\2\2HJ\7\r\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\5\2\2LM\7\t"+
		"\2\2M\21\3\2\2\2NR\5\26\f\2OR\5\30\r\2PR\5\24\13\2QN\3\2\2\2QO\3\2\2\2"+
		"QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\23\3\2\2\2US\3\2\2\2V\\\7\32"+
		"\2\2W[\5\26\f\2X[\5\30\r\2Y[\5\24\13\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2["+
		"^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7\35\2\2`\25\3"+
		"\2\2\2ab\t\2\2\2b\27\3\2\2\2cd\7\31\2\2dh\7\5\2\2eg\5\32\16\2fe\3\2\2"+
		"\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2im\3\2\2\2jh\3\2\2\2kl\7\22\2\2ln\7\25"+
		"\2\2mk\3\2\2\2mn\3\2\2\2n\31\3\2\2\2op\7\7\2\2pq\7\5\2\2q\33\3\2\2\2\16"+
		"\37,.\63DIQSZ\\hm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}