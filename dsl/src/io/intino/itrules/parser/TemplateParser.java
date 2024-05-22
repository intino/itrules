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

package io.intino.itrules.parser;

import io.intino.itrules.Logger;
import io.intino.itrules.dsl.ItrLexer;
import io.intino.itrules.dsl.ItrParser;
import io.intino.itrules.template.Template;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.antlr.v4.runtime.CharStreams.fromString;

public final class TemplateParser {
	private final Logger logger = new Logger();

	public Template parse(InputStream stream, Charset charset) throws ITRulesSyntaxError {
		try {
			return parse(fromString(IOUtils.toString(stream, charset).trim()));
		} catch (IOException e) {
			logger.log(e.getMessage());
			return Template.EMPTY;
		}
	}

	private Template parse(CodePointCharStream stream) throws ITRulesSyntaxError {
		ItrLexer lexer = new ItrLexer(stream);
		lexer.reset();
		lexer.setState(1);
		ItrParser parser = new ItrParser(new CommonTokenStream(lexer));
		parser.setErrorHandler(new TemplateErrorStrategy());
		ItrParser.RootContext root = parse(parser);
		parser.setErrorHandler(new TemplateErrorStrategy());
		ParseTreeWalker walker = new ParseTreeWalker();
		Interpreter interpreter = new Interpreter(logger);
		walker.walk(interpreter, root);
		return interpreter.template();
	}

	private ItrParser.RootContext parse(ItrParser parser) throws ITRulesSyntaxError {
		try {
			return parser.root();
		} catch (RecognitionException e) {
			org.antlr.v4.runtime.Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			Token currentToken = ((Parser) e.getRecognizer()).getCurrentToken();
			logger.log("Rules not well formed. Error in: " + token.getLine() + ": " + token.getCharPositionInLine());
			throw new ITRulesSyntaxError("Template not well formed. Line:" + currentToken.getLine() + "; Column: " + currentToken.getCharPositionInLine() + ": " + e.getMessage());
		}
	}
}