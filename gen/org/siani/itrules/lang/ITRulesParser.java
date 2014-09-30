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
		MARK_ERROR=31, MARK_ID=30, RULE_ID=13, OPTION=5, RULE_BEGIN=1, SCAPED_CHAR=32, 
		OPERATOR=23, TRIGGER=9, EVAL_ID=19, NUMBER=21, RIGHT_P=7, RULE_ERROR=16, 
		SEPARATOR=29, RULE_TEXT=36, NOT=12, EVAL_RIGHT_P=18, TEXT=4, ID=3, LIST=26, 
		EXPRESSION_TEXT=40, EXP_SCAPED_CHAR=38, MARK_KEY=33, TYPE=8, EVAL_ERROR=25, 
		WS=15, EVAL=11, RULE_END=35, WL=2, EXPRESSION_MARK=39, NL=14, LEFT_SQ=34, 
		E_WS=24, END=28, DOT=20, RIGHT_SQ=37, MARK_OPTION=27, EVAL_LEFT_P=17, 
		ATTR=10, LEFT_P=6, STRING=22;
	public static final String[] tokenNames = {
		"<INVALID>", "'defrule'", "WL", "ID", "'text'", "OPTION", "LEFT_P", "RIGHT_P", 
		"'type'", "'trigger'", "'attr'", "'eval'", "'!'", "RULE_ID", "NL", "WS", 
		"RULE_ERROR", "EVAL_LEFT_P", "EVAL_RIGHT_P", "EVAL_ID", "'.'", "NUMBER", 
		"STRING", "OPERATOR", "E_WS", "EVAL_ERROR", "'...'", "MARK_OPTION", "'$~'", 
		"SEPARATOR", "MARK_ID", "MARK_ERROR", "SCAPED_CHAR", "'$'", "'['", "'~'", 
		"RULE_TEXT", "RIGHT_SQ", "EXP_SCAPED_CHAR", "EXPRESSION_MARK", "EXPRESSION_TEXT"
	};
	public static final int
		RULE_root = 0, RULE_itrule = 1, RULE_signature = 2, RULE_ruleType = 3, 
		RULE_value = 4, RULE_eval = 5, RULE_evalExpression = 6, RULE_composedID = 7, 
		RULE_trigger = 8, RULE_triggerValue = 9, RULE_attr = 10, RULE_body = 11, 
		RULE_expression = 12, RULE_text = 13, RULE_mark = 14, RULE_option = 15;
	public static final String[] ruleNames = {
		"root", "itrule", "signature", "ruleType", "value", "eval", "evalExpression", 
		"composedID", "trigger", "triggerValue", "attr", "body", "expression", 
		"text", "mark", "option"
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RULE_BEGIN) {
				{
				{
				setState(32); itrule();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38); match(EOF);
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
			setState(40); signature();
			setState(41); body();
			setState(42); match(RULE_END);
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
		public EvalContext eval(int i) {
			return getRuleContext(EvalContext.class,i);
		}
		public TriggerContext trigger(int i) {
			return getRuleContext(TriggerContext.class,i);
		}
		public AttrContext attr(int i) {
			return getRuleContext(AttrContext.class,i);
		}
		public TerminalNode RULE_BEGIN() { return getToken(ITRulesParser.RULE_BEGIN, 0); }
		public List<EvalContext> eval() {
			return getRuleContexts(EvalContext.class);
		}
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
			setState(44); match(RULE_BEGIN);
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(49);
				switch (_input.LA(1)) {
				case TYPE:
				case NOT:
					{
					setState(45); ruleType();
					}
					break;
				case TRIGGER:
					{
					setState(46); trigger();
					}
					break;
				case ATTR:
					{
					setState(47); attr();
					}
					break;
				case EVAL:
					{
					setState(48); eval();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE) | (1L << TRIGGER) | (1L << ATTR) | (1L << EVAL) | (1L << NOT))) != 0) );
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
			setState(56);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(55); match(NOT);
				}
			}

			setState(58); match(TYPE);
			setState(59); value();
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
			setState(61); match(LEFT_P);
			setState(62); match(ID);
			setState(63); match(RIGHT_P);
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

	public static class EvalContext extends ParserRuleContext {
		public TerminalNode EVAL() { return getToken(ITRulesParser.EVAL, 0); }
		public TerminalNode LEFT_P() { return getToken(ITRulesParser.LEFT_P, 0); }
		public TerminalNode RIGHT_P() { return getToken(ITRulesParser.RIGHT_P, 0); }
		public EvalExpressionContext evalExpression() {
			return getRuleContext(EvalExpressionContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_eval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(EVAL);
			setState(66); match(LEFT_P);
			setState(67); evalExpression();
			setState(68); match(RIGHT_P);
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

	public static class EvalExpressionContext extends ParserRuleContext {
		public List<ComposedIDContext> composedID() {
			return getRuleContexts(ComposedIDContext.class);
		}
		public TerminalNode STRING(int i) {
			return getToken(ITRulesParser.STRING, i);
		}
		public TerminalNode NUMBER(int i) {
			return getToken(ITRulesParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ITRulesParser.NUMBER); }
		public List<TerminalNode> STRING() { return getTokens(ITRulesParser.STRING); }
		public ComposedIDContext composedID(int i) {
			return getRuleContext(ComposedIDContext.class,i);
		}
		public TerminalNode OPERATOR() { return getToken(ITRulesParser.OPERATOR, 0); }
		public EvalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterEvalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitEvalExpression(this);
		}
	}

	public final EvalExpressionContext evalExpression() throws RecognitionException {
		EvalExpressionContext _localctx = new EvalExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_evalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(70); composedID();
				}
				break;
			case STRING:
				{
				setState(71); match(STRING);
				}
				break;
			case NUMBER:
				{
				setState(72); match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(75); match(OPERATOR);
			setState(79);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(76); composedID();
				}
				break;
			case STRING:
				{
				setState(77); match(STRING);
				}
				break;
			case NUMBER:
				{
				setState(78); match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ComposedIDContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ITRulesParser.DOT, 0); }
		public List<TerminalNode> ID() { return getTokens(ITRulesParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ITRulesParser.ID, i);
		}
		public ComposedIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composedID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterComposedID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitComposedID(this);
		}
	}

	public final ComposedIDContext composedID() throws RecognitionException {
		ComposedIDContext _localctx = new ComposedIDContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_composedID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); match(ID);
			setState(84);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(82); match(DOT);
				setState(83); match(ID);
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
		enterRule(_localctx, 16, RULE_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(TRIGGER);
			setState(87); match(LEFT_P);
			setState(88); triggerValue();
			setState(89); match(RIGHT_P);
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
		enterRule(_localctx, 18, RULE_triggerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); match(ID);
			setState(94);
			_la = _input.LA(1);
			if (_la==OPTION) {
				{
				setState(92); match(OPTION);
				setState(93); match(ID);
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
		enterRule(_localctx, 20, RULE_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(ATTR);
			setState(97); match(LEFT_P);
			setState(99);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(98); match(NOT);
				}
			}

			setState(101); match(ID);
			setState(102); match(RIGHT_P);
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
		enterRule(_localctx, 22, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(107);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(104); text();
					}
					break;
				case MARK_KEY:
					{
					setState(105); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(106); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(111);
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
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(LEFT_SQ);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(116);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(113); text();
					}
					break;
				case MARK_KEY:
					{
					setState(114); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(115); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121); match(RIGHT_SQ);
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
		enterRule(_localctx, 26, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
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
		enterRule(_localctx, 28, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(MARK_KEY);
			setState(126); match(ID);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION) {
				{
				{
				setState(127); option();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(133); match(LIST);
				setState(134); match(SEPARATOR);
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
		enterRule(_localctx, 30, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(OPTION);
			setState(138); match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u008f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4\64"+
		"\n\4\r\4\16\4\65\3\4\3\4\3\5\5\5;\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bL\n\b\3\b\3\b\3\b\3\b\5\bR\n\b\3\t\3\t"+
		"\3\t\5\tW\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13a\n\13\3\f\3\f\3"+
		"\f\5\ff\n\f\3\f\3\f\3\f\3\r\3\r\3\r\7\rn\n\r\f\r\16\rq\13\r\3\16\3\16"+
		"\3\16\3\16\7\16w\n\16\f\16\16\16z\13\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\7\20\u0083\n\20\f\20\16\20\u0086\13\20\3\20\3\20\5\20\u008a\n\20"+
		"\3\21\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2"+
		"\3\4\2\6\6\"\"\u0093\2%\3\2\2\2\4*\3\2\2\2\6.\3\2\2\2\b:\3\2\2\2\n?\3"+
		"\2\2\2\fC\3\2\2\2\16K\3\2\2\2\20S\3\2\2\2\22X\3\2\2\2\24]\3\2\2\2\26b"+
		"\3\2\2\2\30o\3\2\2\2\32r\3\2\2\2\34}\3\2\2\2\36\177\3\2\2\2 \u008b\3\2"+
		"\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'"+
		"%\3\2\2\2()\7\2\2\3)\3\3\2\2\2*+\5\6\4\2+,\5\30\r\2,-\7%\2\2-\5\3\2\2"+
		"\2.\63\7\3\2\2/\64\5\b\5\2\60\64\5\22\n\2\61\64\5\26\f\2\62\64\5\f\7\2"+
		"\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65"+
		"\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\20\2\28\7\3\2\2\29;\7\16"+
		"\2\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\n\2\2=>\5\n\6\2>\t\3\2\2\2?@\7"+
		"\b\2\2@A\7\5\2\2AB\7\t\2\2B\13\3\2\2\2CD\7\r\2\2DE\7\b\2\2EF\5\16\b\2"+
		"FG\7\t\2\2G\r\3\2\2\2HL\5\20\t\2IL\7\30\2\2JL\7\27\2\2KH\3\2\2\2KI\3\2"+
		"\2\2KJ\3\2\2\2LM\3\2\2\2MQ\7\31\2\2NR\5\20\t\2OR\7\30\2\2PR\7\27\2\2Q"+
		"N\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\17\3\2\2\2SV\7\5\2\2TU\7\26\2\2UW\7\5\2"+
		"\2VT\3\2\2\2VW\3\2\2\2W\21\3\2\2\2XY\7\13\2\2YZ\7\b\2\2Z[\5\24\13\2[\\"+
		"\7\t\2\2\\\23\3\2\2\2]`\7\5\2\2^_\7\7\2\2_a\7\5\2\2`^\3\2\2\2`a\3\2\2"+
		"\2a\25\3\2\2\2bc\7\f\2\2ce\7\b\2\2df\7\16\2\2ed\3\2\2\2ef\3\2\2\2fg\3"+
		"\2\2\2gh\7\5\2\2hi\7\t\2\2i\27\3\2\2\2jn\5\34\17\2kn\5\36\20\2ln\5\32"+
		"\16\2mj\3\2\2\2mk\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\31"+
		"\3\2\2\2qo\3\2\2\2rx\7$\2\2sw\5\34\17\2tw\5\36\20\2uw\5\32\16\2vs\3\2"+
		"\2\2vt\3\2\2\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2"+
		"\2\2{|\7\'\2\2|\33\3\2\2\2}~\t\2\2\2~\35\3\2\2\2\177\u0080\7#\2\2\u0080"+
		"\u0084\7\5\2\2\u0081\u0083\5 \21\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0089\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u0088\7\34\2\2\u0088\u008a\7\37\2\2\u0089\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\37\3\2\2\2\u008b\u008c\7\7\2\2\u008c"+
		"\u008d\7\5\2\2\u008d!\3\2\2\2\21%\63\65:KQV`emovx\u0084\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}