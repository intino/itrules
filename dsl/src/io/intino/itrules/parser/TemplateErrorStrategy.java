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

import org.antlr.v4.runtime.*;

public class TemplateErrorStrategy extends DefaultErrorStrategy {

	private void debugParameters(Parser recognizer) {
		Token token = recognizer.getCurrentToken();
		String[] nameList = recognizer.getTokenNames();
		System.out.println("Line: " + token.getLine());
		System.out.println("Column: " + token.getCharPositionInLine());
		System.out.println("Text Length: " + token.getText().length());
		System.out.println("Token type: " + nameList[token.getType()]);
		System.out.println("Text: " + token.getText().replace("\n", "\\n"));
		System.out.println("Expected tokens: " + recognizer.getExpectedTokens().toString(VocabularyImpl.fromTokenNames(nameList)));
	}

	@Override
	public void reportError(Parser recognizer, RecognitionException e) {
		throw new RecognitionException(recognizer, recognizer.getInputStream(), recognizer.getContext());
	}

	@Override
	protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
		super.reportNoViableAlternative(recognizer, e);
		throw new RecognitionException(getMessage(recognizer), recognizer, recognizer.getInputStream(), recognizer.getContext());
	}

	@Override
	protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
		super.reportInputMismatch(recognizer, e);
		throw new RecognitionException(getMessage(recognizer), recognizer, recognizer.getInputStream(), recognizer.getContext());
	}

	@Override
	protected void reportFailedPredicate(Parser recognizer, FailedPredicateException e) {
		super.reportFailedPredicate(recognizer, e);
		throw new RecognitionException(getMessage(recognizer), recognizer, recognizer.getInputStream(), recognizer.getContext());
	}

	@Override
	protected void reportUnwantedToken(Parser recognizer) {
		super.reportUnwantedToken(recognizer);
		throw new RecognitionException(getMessage(recognizer), recognizer, recognizer.getInputStream(), recognizer.getContext());

	}

	private String getMessage(Parser recognizer) {
		return "Unwanted Token; expected " + recognizer.getExpectedTokens().toString(VocabularyImpl.fromTokenNames(recognizer.getTokenNames()));
	}

	@Override
	protected void reportMissingToken(Parser recognizer) {
		super.reportMissingToken(recognizer);
	}
}
