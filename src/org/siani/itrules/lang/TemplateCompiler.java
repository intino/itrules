package org.siani.itrules.lang;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.siani.itrules.model.Logger;
import org.siani.itrules.model.Rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class TemplateCompiler {

	private final Logger logger = new Log();
	private final List<Rule> rules = new ArrayList<>();


	public Rule[] compile(InputStream stream) {
		try {
			parseTemplate(new ANTLRInputStream(stream));
			return rules.toArray(new Rule[rules.size()]);
		} catch (ITRulesSyntaxError | IOException e) {
			e.printStackTrace();
			return rules.toArray(new Rule[rules.size()]);
		}
	}

	private void parseTemplate(ANTLRInputStream input) throws ITRulesSyntaxError {
		ITRulesLexer lexer = new ITRulesLexer(input);
		lexer.reset();
		lexer.setState(1);
		ITRulesParser.RootContext root = parse(new ITRulesParser(new CommonTokenStream(lexer)));
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new Interpreter(rules, logger), root);
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
