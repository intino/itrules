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

package org.siani.itrules.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.siani.itrules.dsl.ItrLexer;
import org.siani.itrules.dsl.ItrParser;
import org.siani.itrules.engine.logger.DebugLogger;
import org.siani.itrules.engine.logger.Logger;
import org.siani.itrules.model.Rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class TemplateParser {

	private final Logger logger = new DebugLogger();
	private final List<Rule> rules = new ArrayList<>();


	public List<Rule> parse(InputStream stream) {
		try {
			parseTemplate(new ANTLRInputStream(stream));
			return rules;
		} catch (ITRulesSyntaxError | IOException e) {
			e.printStackTrace();
			return rules;
		}
	}

	private void parseTemplate(ANTLRInputStream input) throws ITRulesSyntaxError {
		ItrLexer lexer = new ItrLexer(input);
		lexer.reset();
		lexer.setState(1);
		ItrParser.RootContext root = parse(new ItrParser(new CommonTokenStream(lexer)));
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new Interpreter(rules, logger), root);
	}

	private ItrParser.RootContext parse(ItrParser parser) throws ITRulesSyntaxError {
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
