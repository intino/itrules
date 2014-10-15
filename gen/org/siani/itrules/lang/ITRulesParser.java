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
		MARK_ERROR=34, MARK_ID=33, RULE_ID=16, OPTION=5, RULE_BEGIN=1, SCAPED_CHAR=36, 
		OPERATOR=26, TRIGGER=10, EVAL_ID=22, NUMBER=24, RIGHT_P=7, RULE_ERROR=19, 
		SEPARATOR=32, RULE_TEXT=40, NOT=15, EVAL_RIGHT_P=21, TEXT=4, ID=3, LIST=29, 
		EXPRESSION_TEXT=44, EXP_SCAPED_CHAR=42, MARK_KEY=37, TYPE=9, EVAL_ERROR=28, 
		WS=18, EVAL=14, RULE_END=39, COMMA=8, DEEP=13, WL=2, SLOT_TYPE=12, EXPRESSION_MARK=43, 
		NL=17, LEFT_SQ=38, E_WS=27, SLOT_NAME=11, END=31, DOT=23, RIGHT_SQ=41, 
		MARK_OPTION=30, EVAL_LEFT_P=20, LEFT_P=6, NULL_CHAR=35, STRING=25;
	public static final String[] tokenNames = {
		"<INVALID>", "'defrule'", "WL", "ID", "'text'", "OPTION", "LEFT_P", "RIGHT_P", 
		"','", "'type'", "'trigger'", "'slot-name'", "'slot-type'", "'deep'", 
		"'eval'", "'!'", "RULE_ID", "NL", "WS", "RULE_ERROR", "EVAL_LEFT_P", "EVAL_RIGHT_P", 
		"EVAL_ID", "'.'", "NUMBER", "STRING", "OPERATOR", "E_WS", "EVAL_ERROR", 
		"'...'", "MARK_OPTION", "END", "SEPARATOR", "MARK_ID", "MARK_ERROR", "NULL_CHAR", 
		"SCAPED_CHAR", "'$'", "'['", "'~'", "RULE_TEXT", "RIGHT_SQ", "EXP_SCAPED_CHAR", 
		"EXPRESSION_MARK", "EXPRESSION_TEXT"
	};
	public static final int
		RULE_root = 0, RULE_itrule = 1, RULE_signature = 2, RULE_ruleType = 3, 
		RULE_value = 4, RULE_eval = 5, RULE_evalExpression = 6, RULE_composedID = 7, 
		RULE_trigger = 8, RULE_triggerValue = 9, RULE_slotName = 10, RULE_slotType = 11, 
		RULE_slotParm = 12, RULE_body = 13, RULE_expression = 14, RULE_text = 15, 
		RULE_mark = 16, RULE_option = 17;
	public static final String[] ruleNames = {
		"root", "itrule", "signature", "ruleType", "value", "eval", "evalExpression", 
		"composedID", "trigger", "triggerValue", "slotName", "slotType", "slotParm", 
		"body", "expression", "text", "mark", "option"
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RULE_BEGIN) {
				{
				{
				setState(36); itrule();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42); match(EOF);
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
			setState(44); signature();
			setState(45); body();
			setState(46); match(RULE_END);
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
		public TerminalNode NL() { return getToken(ITRulesParser.NL, 0); }
		public EvalContext eval(int i) {
			return getRuleContext(EvalContext.class,i);
		}
		public SlotTypeContext slotType(int i) {
			return getRuleContext(SlotTypeContext.class,i);
		}
		public TriggerContext trigger(int i) {
			return getRuleContext(TriggerContext.class,i);
		}
		public List<SlotTypeContext> slotType() {
			return getRuleContexts(SlotTypeContext.class);
		}
		public TerminalNode RULE_BEGIN() { return getToken(ITRulesParser.RULE_BEGIN, 0); }
		public List<EvalContext> eval() {
			return getRuleContexts(EvalContext.class);
		}
		public List<SlotNameContext> slotName() {
			return getRuleContexts(SlotNameContext.class);
		}
		public SlotNameContext slotName(int i) {
			return getRuleContext(SlotNameContext.class,i);
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
			setState(48); match(RULE_BEGIN);
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(54);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(49); ruleType();
					}
					break;
				case 2:
					{
					setState(50); trigger();
					}
					break;
				case 3:
					{
					setState(51); slotName();
					}
					break;
				case 4:
					{
					setState(52); slotType();
					}
					break;
				case 5:
					{
					setState(53); eval();
					}
					break;
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE) | (1L << TRIGGER) | (1L << SLOT_NAME) | (1L << SLOT_TYPE) | (1L << EVAL) | (1L << NOT))) != 0) );
			setState(58); match(NL);
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
			setState(61);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(60); match(NOT);
				}
			}

			setState(63); match(TYPE);
			setState(64); value();
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
			setState(66); match(LEFT_P);
			setState(67); match(ID);
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
			setState(70); match(EVAL);
			setState(71); match(LEFT_P);
			setState(72); evalExpression();
			setState(73); match(RIGHT_P);
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
			setState(78);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(75); composedID();
				}
				break;
			case STRING:
				{
				setState(76); match(STRING);
				}
				break;
			case NUMBER:
				{
				setState(77); match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(80); match(OPERATOR);
			setState(84);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(81); composedID();
				}
				break;
			case STRING:
				{
				setState(82); match(STRING);
				}
				break;
			case NUMBER:
				{
				setState(83); match(NUMBER);
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
			setState(86); match(ID);
			setState(89);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(87); match(DOT);
				setState(88); match(ID);
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
			setState(91); match(TRIGGER);
			setState(92); match(LEFT_P);
			setState(93); triggerValue();
			setState(94); match(RIGHT_P);
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
			setState(96); match(ID);
			setState(99);
			_la = _input.LA(1);
			if (_la==OPTION) {
				{
				setState(97); match(OPTION);
				setState(98); match(ID);
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

	public static class SlotNameContext extends ParserRuleContext {
		public TerminalNode SLOT_NAME() { return getToken(ITRulesParser.SLOT_NAME, 0); }
		public TerminalNode NOT() { return getToken(ITRulesParser.NOT, 0); }
		public SlotParmContext slotParm() {
			return getRuleContext(SlotParmContext.class,0);
		}
		public SlotNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterSlotName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitSlotName(this);
		}
	}

	public final SlotNameContext slotName() throws RecognitionException {
		SlotNameContext _localctx = new SlotNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_slotName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(101); match(NOT);
				}
			}

			setState(104); match(SLOT_NAME);
			setState(105); slotParm();
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

	public static class SlotTypeContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(ITRulesParser.NOT, 0); }
		public SlotParmContext slotParm() {
			return getRuleContext(SlotParmContext.class,0);
		}
		public TerminalNode SLOT_TYPE() { return getToken(ITRulesParser.SLOT_TYPE, 0); }
		public SlotTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterSlotType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitSlotType(this);
		}
	}

	public final SlotTypeContext slotType() throws RecognitionException {
		SlotTypeContext _localctx = new SlotTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_slotType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(107); match(NOT);
				}
			}

			setState(110); match(SLOT_TYPE);
			setState(111); slotParm();
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

	public static class SlotParmContext extends ParserRuleContext {
		public TerminalNode LEFT_P() { return getToken(ITRulesParser.LEFT_P, 0); }
		public TerminalNode RIGHT_P() { return getToken(ITRulesParser.RIGHT_P, 0); }
		public TerminalNode COMMA() { return getToken(ITRulesParser.COMMA, 0); }
		public TerminalNode ID() { return getToken(ITRulesParser.ID, 0); }
		public TerminalNode DEEP() { return getToken(ITRulesParser.DEEP, 0); }
		public SlotParmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotParm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).enterSlotParm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ITRulesParserListener ) ((ITRulesParserListener)listener).exitSlotParm(this);
		}
	}

	public final SlotParmContext slotParm() throws RecognitionException {
		SlotParmContext _localctx = new SlotParmContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_slotParm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(LEFT_P);
			setState(114); match(ID);
			setState(117);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(115); match(COMMA);
				setState(116); match(DEEP);
				}
			}

			setState(119); match(RIGHT_P);
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
		enterRule(_localctx, 26, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(124);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(121); text();
					}
					break;
				case MARK_KEY:
					{
					setState(122); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(123); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(128);
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
		enterRule(_localctx, 28, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(LEFT_SQ);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << SCAPED_CHAR) | (1L << MARK_KEY) | (1L << LEFT_SQ))) != 0)) {
				{
				setState(133);
				switch (_input.LA(1)) {
				case TEXT:
				case SCAPED_CHAR:
					{
					setState(130); text();
					}
					break;
				case MARK_KEY:
					{
					setState(131); mark();
					}
					break;
				case LEFT_SQ:
					{
					setState(132); expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138); match(RIGHT_SQ);
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
		enterRule(_localctx, 30, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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
		enterRule(_localctx, 32, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(MARK_KEY);
			setState(143); match(ID);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION) {
				{
				{
				setState(144); option();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			_la = _input.LA(1);
			if (_la==LIST) {
				{
				setState(150); match(LIST);
				setState(151); match(SEPARATOR);
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
		enterRule(_localctx, 34, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(OPTION);
			setState(155); match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u00a0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\6\49\n\4\r\4\16\4:\3\4\3\4\3\5\5\5@\n\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bQ\n\b\3\b\3\b\3\b\3"+
		"\b\5\bW\n\b\3\t\3\t\3\t\5\t\\\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5"+
		"\13f\n\13\3\f\5\fi\n\f\3\f\3\f\3\f\3\r\5\ro\n\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\5\16x\n\16\3\16\3\16\3\17\3\17\3\17\7\17\177\n\17\f\17\16\17"+
		"\u0082\13\17\3\20\3\20\3\20\3\20\7\20\u0088\n\20\f\20\16\20\u008b\13\20"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\22\7\22\u0094\n\22\f\22\16\22\u0097\13"+
		"\22\3\22\3\22\5\22\u009b\n\22\3\23\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$\2\3\4\2\6\6&&\u00a5\2)\3\2\2\2\4.\3\2\2\2"+
		"\6\62\3\2\2\2\b?\3\2\2\2\nD\3\2\2\2\fH\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2"+
		"\22]\3\2\2\2\24b\3\2\2\2\26h\3\2\2\2\30n\3\2\2\2\32s\3\2\2\2\34\u0080"+
		"\3\2\2\2\36\u0083\3\2\2\2 \u008e\3\2\2\2\"\u0090\3\2\2\2$\u009c\3\2\2"+
		"\2&(\5\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2"+
		"\2\2,-\7\2\2\3-\3\3\2\2\2./\5\6\4\2/\60\5\34\17\2\60\61\7)\2\2\61\5\3"+
		"\2\2\2\628\7\3\2\2\639\5\b\5\2\649\5\22\n\2\659\5\26\f\2\669\5\30\r\2"+
		"\679\5\f\7\28\63\3\2\2\28\64\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2"+
		"\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\23\2\2=\7\3\2\2\2>@\7\21"+
		"\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\13\2\2BC\5\n\6\2C\t\3\2\2\2DE\7"+
		"\b\2\2EF\7\5\2\2FG\7\t\2\2G\13\3\2\2\2HI\7\20\2\2IJ\7\b\2\2JK\5\16\b\2"+
		"KL\7\t\2\2L\r\3\2\2\2MQ\5\20\t\2NQ\7\33\2\2OQ\7\32\2\2PM\3\2\2\2PN\3\2"+
		"\2\2PO\3\2\2\2QR\3\2\2\2RV\7\34\2\2SW\5\20\t\2TW\7\33\2\2UW\7\32\2\2V"+
		"S\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\17\3\2\2\2X[\7\5\2\2YZ\7\31\2\2Z\\\7\5"+
		"\2\2[Y\3\2\2\2[\\\3\2\2\2\\\21\3\2\2\2]^\7\f\2\2^_\7\b\2\2_`\5\24\13\2"+
		"`a\7\t\2\2a\23\3\2\2\2be\7\5\2\2cd\7\7\2\2df\7\5\2\2ec\3\2\2\2ef\3\2\2"+
		"\2f\25\3\2\2\2gi\7\21\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\r\2\2kl\5"+
		"\32\16\2l\27\3\2\2\2mo\7\21\2\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\16\2"+
		"\2qr\5\32\16\2r\31\3\2\2\2st\7\b\2\2tw\7\5\2\2uv\7\n\2\2vx\7\17\2\2wu"+
		"\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\t\2\2z\33\3\2\2\2{\177\5 \21\2|\177\5"+
		"\"\22\2}\177\5\36\20\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2"+
		"\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\35\3\2\2\2\u0082\u0080\3\2\2"+
		"\2\u0083\u0089\7(\2\2\u0084\u0088\5 \21\2\u0085\u0088\5\"\22\2\u0086\u0088"+
		"\5\36\20\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2"+
		"\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7+\2\2\u008d\37\3\2\2\2\u008e"+
		"\u008f\t\2\2\2\u008f!\3\2\2\2\u0090\u0091\7\'\2\2\u0091\u0095\7\5\2\2"+
		"\u0092\u0094\5$\23\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009a\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0099\7\37\2\2\u0099\u009b\7\"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3"+
		"\2\2\2\u009b#\3\2\2\2\u009c\u009d\7\7\2\2\u009d\u009e\7\5\2\2\u009e%\3"+
		"\2\2\2\23)8:?PV[ehnw~\u0080\u0087\u0089\u0095\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}