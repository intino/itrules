/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.siani.itrules.dsl;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.siani.itrules.logger.DebugLogger;
import org.siani.itrules.logger.Logger;
import org.siani.itrules.model.Rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class TemplateCompiler {

	private final Logger logger = new DebugLogger();
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

}
