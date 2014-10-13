package org.siani.itrules.lang;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.siani.itrules.Logger;
import org.siani.itrules.ITRulesSyntaxError;
import org.siani.itrules.lang.model.Rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class RulesReader {

	private ANTLRInputStream input;
	private final Logger logger;
	private final List<Rule> rules;

	public RulesReader(InputStream template) {
		this.logger = new Log();
		this.rules = new ArrayList<>();
		try {
			input = new ANTLRInputStream(new RuleSetInputStream(template));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Rule> readAll() {
		try {
			ITRulesLexer lexer = new ITRulesLexer(input);
			lexer.reset();
			lexer.setState(1);
			ITRulesParser.RootContext root = parse(new ITRulesParser(new CommonTokenStream(lexer)));
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(new Interpreter(rules, logger), root);
			return rules;
		} catch (ITRulesSyntaxError e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	private ITRulesParser.RootContext parse(ITRulesParser parser) throws ITRulesSyntaxError {
		try {
			return parser.root();
		} catch (RecognitionException e) {
			org.antlr.v4.runtime.Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			logger.debug("Rules not well formed. Error in: " + token.getLine() + ": " + token.getCharPositionInLine());
			logger.debug(e.getMessage());
			throw new ITRulesSyntaxError("Template not well formed.");
		}
	}

	public static class Log implements Logger {
		@Override
		public void debug(String message, Object... args) {
			System.out.printf(message, args);
		}
	}
}
