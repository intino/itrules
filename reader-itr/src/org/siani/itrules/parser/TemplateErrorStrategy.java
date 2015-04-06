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

import org.antlr.v4.runtime.*;

public class TemplateErrorStrategy extends DefaultErrorStrategy {

	private void printParameters(Parser recognizer) {
		Token token = recognizer.getCurrentToken();
		String[] nameList = recognizer.getTokenNames();
		System.out.println("Line: " + token.getLine());
		System.out.println("Column: " + token.getCharPositionInLine());
		System.out.println("Text Length: " + token.getText().length());
		System.out.println("Token type: " + nameList[token.getType()]);
		System.out.println("Text: " + token.getText().replace("\n", "\\n"));
		System.out.println("Expected tokens: " + recognizer.getExpectedTokens().toString(recognizer.getTokenNames()));
	}

	@Override
	public void recover(Parser recognizer, RecognitionException e) {
		printParameters(recognizer);
		throw new RuntimeException(e);
	}

	@Override
	public Token recoverInline(Parser recognizer) throws RecognitionException {
		printParameters(recognizer);
		throw new RuntimeException(new InputMismatchException(recognizer));
	}

	@Override
	public void reportError(Parser recognizer, RecognitionException e) {
		printParameters(recognizer);
		throw new RuntimeException(e);
	}

	@Override
	public void sync(Parser recognizer) {
	}
}
