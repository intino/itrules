/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

// Generated from /Users/oroncal/workspace/infrastructure/itrules/dsl/src/io/intino/itrules/dsl/ItrLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ItrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN_RULE=1, WL=2, BEGIN_BODY=3, COMMENT=4, NOT=5, AND=6, OR=7, NAME=8, 
		END_SIGNATURE=9, WS=10, LPAREN=11, RPAREN=12, COMMA=13, OTHER=14, END_RULE_SCAPPED=15, 
		END_RULE=16, NEWLINE=17, DOLLAR=18, LSB=19, RSB=20, EXPRESSION_LT=21, 
		TRIGGER=22, BEGIN_EXPRESSION=23, NULL_SEPARATOR=24, TEXT=25, LIST=26, 
		TARGET=27, OPTION=28, NULL=29, SEPARATOR=30, ID=31, MARK_ERROR=32, ELSE=33, 
		END_EXPRESSION=34, EXPRESSION_DOLLAR=35, EXPRESSION_LSB=36, EXPRESSION_RSB=37, 
		EXPRESSION_GT=38, EXPRESSION_NULL=39, EXPRESSION_TRIGGER=40, EXPRESSION_TEXT=41, 
		EXPRESSION_NL=42, EXPRESSION_ERROR=43;
	public static final int
		SIGNATURE_MODE=1, BODY_MODE=2, MARK_MODE=3, EXPRESSION_MODE=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "SIGNATURE_MODE", "BODY_MODE", "MARK_MODE", "EXPRESSION_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BEGIN_RULE", "WL", "BEGIN_BODY", "COMMENT", "NOT", "AND", "OR", "NAME", 
			"END_SIGNATURE", "WS", "LPAREN", "RPAREN", "COMMA", "OTHER", "END_RULE_SCAPPED", 
			"END_RULE", "NEWLINE", "DOLLAR", "LSB", "RSB", "EXPRESSION_LT", "TRIGGER", 
			"BEGIN_EXPRESSION", "NULL_SEPARATOR", "TEXT", "LIST", "TARGET", "OPTION", 
			"NULL", "SEPARATOR", "ID", "MARK_ERROR", "ELSE", "END_EXPRESSION", "EXPRESSION_DOLLAR", 
			"EXPRESSION_LSB", "EXPRESSION_RSB", "EXPRESSION_GT", "EXPRESSION_NULL", 
			"EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", "EXPRESSION_ERROR", 
			"NL", "SP", "DIGIT", "LETTER", "SCORE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", null, "'body'", null, "'NOT'", "'AND'", "'OR'", null, 
			null, null, "'('", "')'", "','", null, "'~end'", null, null, null, null, 
			null, "'<'", "'$'", "'<<'", null, null, "'...'", null, "'+'", null, null, 
			null, null, "'?'", null, null, null, null, "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGIN_RULE", "WL", "BEGIN_BODY", "COMMENT", "NOT", "AND", "OR", 
			"NAME", "END_SIGNATURE", "WS", "LPAREN", "RPAREN", "COMMA", "OTHER", 
			"END_RULE_SCAPPED", "END_RULE", "NEWLINE", "DOLLAR", "LSB", "RSB", "EXPRESSION_LT", 
			"TRIGGER", "BEGIN_EXPRESSION", "NULL_SEPARATOR", "TEXT", "LIST", "TARGET", 
			"OPTION", "NULL", "SEPARATOR", "ID", "MARK_ERROR", "ELSE", "END_EXPRESSION", 
			"EXPRESSION_DOLLAR", "EXPRESSION_LSB", "EXPRESSION_RSB", "EXPRESSION_GT", 
			"EXPRESSION_NULL", "EXPRESSION_TRIGGER", "EXPRESSION_TEXT", "EXPRESSION_NL", 
			"EXPRESSION_ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


		int lastMode = 0;
		boolean inBody = false;
		private void setLastMode(int i) {
			lastMode = i;
		}

		public int getLastMode() {
	        return lastMode;
	    }

	    public boolean markHasParameters() {
	        if (getCharIndex() == this.getInputStream().toString().length()) return false;
	        char c = this.getInputStream().toString().charAt(getCharIndex());
	        String next = "";
	        if (getCharIndex() + 3 < getInputStream().toString().length())
	            next = this.getInputStream().toString().substring(getCharIndex(), getCharIndex() + 3);
	        return (c == '+' || next.equals("..."));
	    }

	    public void setMode(int newMode) {
	        _mode = newMode;
	    }

	    public void exitMark() {
	        if(!markHasParameters()) {
				setMode(lastMode);
				setLastMode(MARK_MODE);
	        }
	    }


	public ItrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ItrLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			BEGIN_RULE_action((RuleContext)_localctx, actionIndex);
			break;
		case 8:
			END_SIGNATURE_action((RuleContext)_localctx, actionIndex);
			break;
		case 14:
			END_RULE_SCAPPED_action((RuleContext)_localctx, actionIndex);
			break;
		case 15:
			END_RULE_action((RuleContext)_localctx, actionIndex);
			break;
		case 16:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 17:
			DOLLAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 18:
			LSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 19:
			RSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 20:
			EXPRESSION_LT_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
			TRIGGER_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			BEGIN_EXPRESSION_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			OPTION_action((RuleContext)_localctx, actionIndex);
			break;
		case 28:
			NULL_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
			SEPARATOR_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			END_EXPRESSION_action((RuleContext)_localctx, actionIndex);
			break;
		case 34:
			EXPRESSION_DOLLAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 35:
			EXPRESSION_LSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 36:
			EXPRESSION_RSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 37:
			EXPRESSION_GT_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			EXPRESSION_TRIGGER_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			EXPRESSION_TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			EXPRESSION_NL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void BEGIN_RULE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setMode(SIGNATURE_MODE); setLastMode(DEFAULT_MODE);
			break;
		}
	}
	private void END_SIGNATURE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 setLastMode(SIGNATURE_MODE); setType(BEGIN_BODY);
			break;
		}
	}
	private void END_RULE_SCAPPED_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 setText("end"); setType(TEXT);
			break;
		}
	}
	private void END_RULE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 setMode(DEFAULT_MODE); setLastMode(BODY_MODE);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 setText("\n"); setType(TEXT);
			break;
		}
	}
	private void DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 setText("$"); setType(TEXT);
			break;
		}
	}
	private void LSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			 setText("<<"); setType(TEXT);
			break;
		}
	}
	private void RSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			 setText(">>"); setType(TEXT);
			break;
		}
	}
	private void EXPRESSION_LT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			 setText("<"); setType(TEXT);
			break;
		}
	}
	private void TRIGGER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			 setMode(MARK_MODE); setLastMode(BODY_MODE);
			break;
		}
	}
	private void BEGIN_EXPRESSION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			 setType(BEGIN_EXPRESSION);setMode(EXPRESSION_MODE); setLastMode(BODY_MODE);
			break;
		}
	}
	private void OPTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:
			 setType(OPTION);
			break;
		}
	}
	private void NULL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			 setMode(lastMode); setLastMode(MARK_MODE);
			break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:
			 setMode(lastMode); setLastMode(MARK_MODE);
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:
			 setType(ID); exitMark();
			break;
		}
	}
	private void END_EXPRESSION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15:
			 setType(END_EXPRESSION);setLastMode(EXPRESSION_MODE);
			break;
		}
	}
	private void EXPRESSION_DOLLAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16:
			 setText("$"); setType(TEXT);
			break;
		}
	}
	private void EXPRESSION_LSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17:
			 setText("<<"); setType(TEXT);
			break;
		}
	}
	private void EXPRESSION_RSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18:
			 setText(">>"); setType(TEXT);
			break;
		}
	}
	private void EXPRESSION_GT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19:
			 setText(">"); setType(TEXT);
			break;
		}
	}
	private void EXPRESSION_TRIGGER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20:
			 setType(TRIGGER); setLastMode(EXPRESSION_MODE);
			break;
		}
	}
	private void EXPRESSION_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 21:
			 setType(TEXT);
			break;
		}
	}
	private void EXPRESSION_NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 22:
			 setText("\n"); setType(TEXT);
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000+\u016f\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff\uffff"+
		"\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0005\u0001m\b\u0001\n\u0001\f\u0001p\t\u0001\u0001\u0001\u0003\u0001"+
		"s\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001w\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u0093\b\u0007\n\u0007\f\u0007\u0096\t\u0007\u0001\b"+
		"\u0005\b\u0099\b\b\n\b\f\b\u009c\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00a4\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0004"+
		"\t\u00ab\b\t\u000b\t\f\t\u00ac\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0003"+
		"\u000f\u00c1\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00cf\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0004\u0018\u00f4\b\u0018\u000b\u0018\f"+
		"\u0018\u00f5\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u00fe\b\u001a\n\u001a\f\u001a\u0101\t\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u010f\b\u001d\n\u001d\f\u001d\u0112\t\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e"+
		"\u011b\b\u001e\n\u001e\f\u001e\u011e\t\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0122\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		" \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0004("+
		"\u014f\b(\u000b(\f(\u0150\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0003)\u015b\b)\u0001)\u0001)\u0001*\u0001*\u0001+\u0003+\u0162"+
		"\b+\u0001+\u0001+\u0003+\u0166\b+\u0001,\u0001,\u0001-\u0001-\u0001.\u0001"+
		".\u0001/\u0001/\u0000\u00000\u0005\u0001\u0007\u0002\t\u0003\u000b\u0004"+
		"\r\u0005\u000f\u0006\u0011\u0007\u0013\b\u0015\t\u0017\n\u0019\u000b\u001b"+
		"\f\u001d\r\u001f\u000e!\u000f#\u0010%\u0011\'\u0012)\u0013+\u0014-\u0015"+
		"/\u00161\u00173\u00185\u00197\u001a9\u001b;\u001c=\u001d?\u001eA\u001f"+
		"C E!G\"I#K$M%O&Q\'S(U)W*Y+[\u0000]\u0000_\u0000a\u0000c\u0000\u0005\u0000"+
		"\u0001\u0002\u0003\u0004\b\u0002\u0000\t\t  \u0005\u0000\n\n\r\r$$<<~"+
		"~\u0001\u0000>>\u0001\u0000]]\u0002\u0000--__\u0003\u0000\n\n$$>?\u0001"+
		"\u000009\u0002\u0000AZaz\u017e\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0001\r\u0001\u0000\u0000\u0000\u0001\u000f\u0001"+
		"\u0000\u0000\u0000\u0001\u0011\u0001\u0000\u0000\u0000\u0001\u0013\u0001"+
		"\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001"+
		"\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001"+
		"\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001"+
		"\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000\u0002#\u0001\u0000\u0000"+
		"\u0000\u0002%\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000"+
		"\u0002)\u0001\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0002-"+
		"\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00021\u0001\u0000"+
		"\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000"+
		"\u00037\u0001\u0000\u0000\u0000\u00039\u0001\u0000\u0000\u0000\u0003;"+
		"\u0001\u0000\u0000\u0000\u0003=\u0001\u0000\u0000\u0000\u0003?\u0001\u0000"+
		"\u0000\u0000\u0003A\u0001\u0000\u0000\u0000\u0003C\u0001\u0000\u0000\u0000"+
		"\u0004E\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0004I"+
		"\u0001\u0000\u0000\u0000\u0004K\u0001\u0000\u0000\u0000\u0004M\u0001\u0000"+
		"\u0000\u0000\u0004O\u0001\u0000\u0000\u0000\u0004Q\u0001\u0000\u0000\u0000"+
		"\u0004S\u0001\u0000\u0000\u0000\u0004U\u0001\u0000\u0000\u0000\u0004W"+
		"\u0001\u0000\u0000\u0000\u0004Y\u0001\u0000\u0000\u0000\u0005e\u0001\u0000"+
		"\u0000\u0000\u0007n\u0001\u0000\u0000\u0000\tz\u0001\u0000\u0000\u0000"+
		"\u000b\u0081\u0001\u0000\u0000\u0000\r\u0083\u0001\u0000\u0000\u0000\u000f"+
		"\u0087\u0001\u0000\u0000\u0000\u0011\u008b\u0001\u0000\u0000\u0000\u0013"+
		"\u008e\u0001\u0000\u0000\u0000\u0015\u009a\u0001\u0000\u0000\u0000\u0017"+
		"\u00aa\u0001\u0000\u0000\u0000\u0019\u00b0\u0001\u0000\u0000\u0000\u001b"+
		"\u00b2\u0001\u0000\u0000\u0000\u001d\u00b4\u0001\u0000\u0000\u0000\u001f"+
		"\u00b6\u0001\u0000\u0000\u0000!\u00b8\u0001\u0000\u0000\u0000#\u00c0\u0001"+
		"\u0000\u0000\u0000%\u00c8\u0001\u0000\u0000\u0000\'\u00d2\u0001\u0000"+
		"\u0000\u0000)\u00d7\u0001\u0000\u0000\u0000+\u00dd\u0001\u0000\u0000\u0000"+
		"-\u00e3\u0001\u0000\u0000\u0000/\u00e6\u0001\u0000\u0000\u00001\u00e9"+
		"\u0001\u0000\u0000\u00003\u00ee\u0001\u0000\u0000\u00005\u00f3\u0001\u0000"+
		"\u0000\u00007\u00f7\u0001\u0000\u0000\u00009\u00fb\u0001\u0000\u0000\u0000"+
		";\u0104\u0001\u0000\u0000\u0000=\u0107\u0001\u0000\u0000\u0000?\u010c"+
		"\u0001\u0000\u0000\u0000A\u0116\u0001\u0000\u0000\u0000C\u0125\u0001\u0000"+
		"\u0000\u0000E\u0127\u0001\u0000\u0000\u0000G\u0129\u0001\u0000\u0000\u0000"+
		"I\u0130\u0001\u0000\u0000\u0000K\u0135\u0001\u0000\u0000\u0000M\u013b"+
		"\u0001\u0000\u0000\u0000O\u0141\u0001\u0000\u0000\u0000Q\u0144\u0001\u0000"+
		"\u0000\u0000S\u0148\u0001\u0000\u0000\u0000U\u014e\u0001\u0000\u0000\u0000"+
		"W\u0154\u0001\u0000\u0000\u0000Y\u015e\u0001\u0000\u0000\u0000[\u0165"+
		"\u0001\u0000\u0000\u0000]\u0167\u0001\u0000\u0000\u0000_\u0169\u0001\u0000"+
		"\u0000\u0000a\u016b\u0001\u0000\u0000\u0000c\u016d\u0001\u0000\u0000\u0000"+
		"ef\u0005d\u0000\u0000fg\u0005e\u0000\u0000gh\u0005f\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000ij\u0006\u0000\u0000\u0000j\u0006\u0001\u0000\u0000"+
		"\u0000km\u0007\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000ov\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qs\u0005\r\u0000\u0000rq\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tw\u0005\n\u0000\u0000uw\u0005\n\u0000\u0000vr\u0001\u0000\u0000\u0000"+
		"vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0006\u0001\u0001"+
		"\u0000y\b\u0001\u0000\u0000\u0000z{\u0005b\u0000\u0000{|\u0005o\u0000"+
		"\u0000|}\u0005d\u0000\u0000}~\u0005y\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0006\u0002\u0001\u0000\u0080\n\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\t\u0000\u0000\u0000\u0082\f\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0005N\u0000\u0000\u0084\u0085\u0005O\u0000\u0000\u0085\u0086\u0005"+
		"T\u0000\u0000\u0086\u000e\u0001\u0000\u0000\u0000\u0087\u0088\u0005A\u0000"+
		"\u0000\u0088\u0089\u0005N\u0000\u0000\u0089\u008a\u0005D\u0000\u0000\u008a"+
		"\u0010\u0001\u0000\u0000\u0000\u008b\u008c\u0005O\u0000\u0000\u008c\u008d"+
		"\u0005R\u0000\u0000\u008d\u0012\u0001\u0000\u0000\u0000\u008e\u0094\u0003"+
		"a.\u0000\u008f\u0093\u0003_-\u0000\u0090\u0093\u0003a.\u0000\u0091\u0093"+
		"\u0003c/\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u0014\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000"+
		"\u0000\u0000\u0097\u0099\u0007\u0000\u0000\u0000\u0098\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000"+
		"\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a3\u0003[+\u0000"+
		"\u009e\u00a4\u0005\t\u0000\u0000\u009f\u00a0\u0005 \u0000\u0000\u00a0"+
		"\u00a1\u0005 \u0000\u0000\u00a1\u00a2\u0005 \u0000\u0000\u00a2\u00a4\u0005"+
		" \u0000\u0000\u00a3\u009e\u0001\u0000\u0000\u0000\u00a3\u009f\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0006\b\u0002\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0006\b\u0003\u0000\u00a8\u0016\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ab\u0003],\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0006\t\u0001\u0000\u00af\u0018\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005"+
		"(\u0000\u0000\u00b1\u001a\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005)\u0000"+
		"\u0000\u00b3\u001c\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005,\u0000\u0000"+
		"\u00b5\u001e\u0001\u0000\u0000\u0000\u00b6\u00b7\t\u0000\u0000\u0000\u00b7"+
		" \u0001\u0000\u0000\u0000\u00b8\u00b9\u0005~\u0000\u0000\u00b9\u00ba\u0005"+
		"e\u0000\u0000\u00ba\u00bb\u0005n\u0000\u0000\u00bb\u00bc\u0005d\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0006\u000e\u0004"+
		"\u0000\u00be\"\u0001\u0000\u0000\u0000\u00bf\u00c1\u0003[+\u0000\u00c0"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005e\u0000\u0000\u00c3\u00c4"+
		"\u0005n\u0000\u0000\u00c4\u00c5\u0005d\u0000\u0000\u00c5\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0006\u000f\u0005\u0000\u00c7$\u0001\u0000\u0000"+
		"\u0000\u00c8\u00ce\u0003[+\u0000\u00c9\u00cf\u0005\t\u0000\u0000\u00ca"+
		"\u00cb\u0005 \u0000\u0000\u00cb\u00cc\u0005 \u0000\u0000\u00cc\u00cd\u0005"+
		" \u0000\u0000\u00cd\u00cf\u0005 \u0000\u0000\u00ce\u00c9\u0001\u0000\u0000"+
		"\u0000\u00ce\u00ca\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0006\u0010\u0006"+
		"\u0000\u00d1&\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005$\u0000\u0000\u00d3"+
		"\u00d4\u0005$\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0006\u0011\u0007\u0000\u00d6(\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005"+
		"$\u0000\u0000\u00d8\u00d9\u0005<\u0000\u0000\u00d9\u00da\u0005<\u0000"+
		"\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc\u0006\u0012\b\u0000"+
		"\u00dc*\u0001\u0000\u0000\u0000\u00dd\u00de\u0005$\u0000\u0000\u00de\u00df"+
		"\u0005>\u0000\u0000\u00df\u00e0\u0005>\u0000\u0000\u00e0\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e2\u0006\u0013\t\u0000\u00e2,\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0005<\u0000\u0000\u00e4\u00e5\u0006\u0014\n\u0000"+
		"\u00e5.\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005$\u0000\u0000\u00e7\u00e8"+
		"\u0006\u0015\u000b\u0000\u00e80\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005"+
		"<\u0000\u0000\u00ea\u00eb\u0005<\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0006\u0016\f\u0000\u00ed2\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0005~\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0006\u0017\u0001\u0000\u00f14\u0001\u0000\u0000\u0000\u00f2\u00f4"+
		"\b\u0001\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f66\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005.\u0000"+
		"\u0000\u00f8\u00f9\u0005.\u0000\u0000\u00f9\u00fa\u0005.\u0000\u0000\u00fa"+
		"8\u0001\u0000\u0000\u0000\u00fb\u00ff\u0005<\u0000\u0000\u00fc\u00fe\b"+
		"\u0002\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe\u0101\u0001"+
		"\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001"+
		"\u0000\u0000\u0000\u0100\u0102\u0001\u0000\u0000\u0000\u0101\u00ff\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0005>\u0000\u0000\u0103:\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0005+\u0000\u0000\u0105\u0106\u0006\u001b\r\u0000"+
		"\u0106<\u0001\u0000\u0000\u0000\u0107\u0108\u0005~\u0000\u0000\u0108\u0109"+
		"\u0006\u001c\u000e\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0006\u001c\u0001\u0000\u010b>\u0001\u0000\u0000\u0000\u010c\u0110\u0005"+
		"[\u0000\u0000\u010d\u010f\b\u0003\u0000\u0000\u010e\u010d\u0001\u0000"+
		"\u0000\u0000\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0113\u0001\u0000"+
		"\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0113\u0114\u0005]\u0000"+
		"\u0000\u0114\u0115\u0006\u001d\u000f\u0000\u0115@\u0001\u0000\u0000\u0000"+
		"\u0116\u011c\u0003a.\u0000\u0117\u011b\u0003_-\u0000\u0118\u011b\u0003"+
		"a.\u0000\u0119\u011b\u0007\u0004\u0000\u0000\u011a\u0117\u0001\u0000\u0000"+
		"\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u0119\u0001\u0000\u0000"+
		"\u0000\u011b\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u0121\u0001\u0000\u0000"+
		"\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0122\u0003_-\u0000\u0120"+
		"\u0122\u0003a.\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0120\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124\u0006"+
		"\u001e\u0010\u0000\u0124B\u0001\u0000\u0000\u0000\u0125\u0126\t\u0000"+
		"\u0000\u0000\u0126D\u0001\u0000\u0000\u0000\u0127\u0128\u0005?\u0000\u0000"+
		"\u0128F\u0001\u0000\u0000\u0000\u0129\u012a\u0005>\u0000\u0000\u012a\u012b"+
		"\u0005>\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012d\u0006"+
		"!\u0011\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0006!\u0003"+
		"\u0000\u012fH\u0001\u0000\u0000\u0000\u0130\u0131\u0005$\u0000\u0000\u0131"+
		"\u0132\u0005$\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0006\"\u0012\u0000\u0134J\u0001\u0000\u0000\u0000\u0135\u0136\u0005"+
		"$\u0000\u0000\u0136\u0137\u0005<\u0000\u0000\u0137\u0138\u0005<\u0000"+
		"\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0006#\u0013\u0000"+
		"\u013aL\u0001\u0000\u0000\u0000\u013b\u013c\u0005$\u0000\u0000\u013c\u013d"+
		"\u0005>\u0000\u0000\u013d\u013e\u0005>\u0000\u0000\u013e\u013f\u0001\u0000"+
		"\u0000\u0000\u013f\u0140\u0006$\u0014\u0000\u0140N\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0005>\u0000\u0000\u0142\u0143\u0006%\u0015\u0000\u0143P"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0005~\u0000\u0000\u0145\u0146\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0006&\u0001\u0000\u0147R\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0005$\u0000\u0000\u0149\u014a\u0006\'\u0016\u0000"+
		"\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0006\'\u0017\u0000\u014c"+
		"T\u0001\u0000\u0000\u0000\u014d\u014f\b\u0005\u0000\u0000\u014e\u014d"+
		"\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u014e"+
		"\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152"+
		"\u0001\u0000\u0000\u0000\u0152\u0153\u0006(\u0018\u0000\u0153V\u0001\u0000"+
		"\u0000\u0000\u0154\u015a\u0003[+\u0000\u0155\u015b\u0005\t\u0000\u0000"+
		"\u0156\u0157\u0005 \u0000\u0000\u0157\u0158\u0005 \u0000\u0000\u0158\u0159"+
		"\u0005 \u0000\u0000\u0159\u015b\u0005 \u0000\u0000\u015a\u0155\u0001\u0000"+
		"\u0000\u0000\u015a\u0156\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u015d\u0006)\u0019"+
		"\u0000\u015dX\u0001\u0000\u0000\u0000\u015e\u015f\t\u0000\u0000\u0000"+
		"\u015fZ\u0001\u0000\u0000\u0000\u0160\u0162\u0005\r\u0000\u0000\u0161"+
		"\u0160\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162"+
		"\u0163\u0001\u0000\u0000\u0000\u0163\u0166\u0005\n\u0000\u0000\u0164\u0166"+
		"\u0005\n\u0000\u0000\u0165\u0161\u0001\u0000\u0000\u0000\u0165\u0164\u0001"+
		"\u0000\u0000\u0000\u0166\\\u0001\u0000\u0000\u0000\u0167\u0168\u0007\u0000"+
		"\u0000\u0000\u0168^\u0001\u0000\u0000\u0000\u0169\u016a\u0007\u0006\u0000"+
		"\u0000\u016a`\u0001\u0000\u0000\u0000\u016b\u016c\u0007\u0007\u0000\u0000"+
		"\u016cb\u0001\u0000\u0000\u0000\u016d\u016e\u0007\u0004\u0000\u0000\u016e"+
		"d\u0001\u0000\u0000\u0000\u0019\u0000\u0001\u0002\u0003\u0004nrv\u0092"+
		"\u0094\u009a\u00a3\u00ac\u00c0\u00ce\u00f5\u00ff\u0110\u011a\u011c\u0121"+
		"\u0150\u015a\u0161\u0165\u001a\u0001\u0000\u0000\u0006\u0000\u0000\u0001"+
		"\b\u0001\u0002\u0002\u0000\u0001\u000e\u0002\u0001\u000f\u0003\u0001\u0010"+
		"\u0004\u0001\u0011\u0005\u0001\u0012\u0006\u0001\u0013\u0007\u0001\u0014"+
		"\b\u0001\u0015\t\u0001\u0016\n\u0001\u001b\u000b\u0001\u001c\f\u0001\u001d"+
		"\r\u0001\u001e\u000e\u0001!\u000f\u0001\"\u0010\u0001#\u0011\u0001$\u0012"+
		"\u0001%\u0013\u0001\'\u0014\u0002\u0003\u0000\u0001(\u0015\u0001)\u0016";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}