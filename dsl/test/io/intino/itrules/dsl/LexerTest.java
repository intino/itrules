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

package io.intino.itrules.dsl;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.util.ArrayList;

import static org.antlr.v4.runtime.CharStreams.fromString;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LexerTest {

	@Test
	public void ruleBeginTest() {
		String expectedType = "BEGIN_RULE";
		String[] receivedTypes = lexerTest(TestSources.RULE_BEGIN);
		assertEquals(receivedTypes[0], (expectedType));
	}

	@Test
	public void ruleSignatureTest() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TEXT", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.SIGNATURE);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void textTest() {
		String[] receivedTypes = lexerTest("'Name'");
		assertEquals(6, receivedTypes.length);
	}

	@Test
	public void mark() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TRIGGER", "ID", "TEXT", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.MARK);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void markWithTarget() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TRIGGER", "TARGET", "ID", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.MARK_WITH_TARGET);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void escapedCharacter() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT",
				"TEXT", "TEXT", "TEXT", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.ESCAPED_CHARACTERS);
		assertArrayEquals(expectedTypes, receivedTypes);
	}


	@Test
	public void expressionWithNewLines() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT", "TEXT", "BEGIN_EXPRESSION", "TRIGGER", "ID",
				"TEXT", "TEXT", "TEXT", "TEXT", "END_EXPRESSION", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.EXPRESION_WITH_NEW_LINES);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void noParametersFunction() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "RPAREN", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT",
				"TEXT"};
		String[] receivedTypes = lexerTest(TestSources.FUNCTION_WITHOUT_PARAMETERS);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void OtherWithMark() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TEXT",
				"TRIGGER", "ID", "TEXT", "TRIGGER", "ID", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.OTHER_WITH_MARK);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void MarkWithCurlSeparator() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TRIGGER", "ID", "OPTION", "ID", "TEXT", "TEXT", "TEXT", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.CURL_SEPARATOR);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void MarkWithFormat() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "OTHER", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "TEXT",
				"TEXT"};
		String[] receivedTypes = lexerTest(TestSources.MARK_WITH_FORMAT);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void classWithMarks() {
		String[] expectedTypes = new String[]{"BEGIN_RULE",
				"NAME", "LPAREN", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "OTHER", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TRIGGER", "ID", "TEXT", "TRIGGER", "ID", "TEXT", "TEXT"};
		String[] receivedTypes = lexerTest(
				TestSources.RULE_WITH_MARKS
		);
		assertArrayEquals(expectedTypes, receivedTypes);

	}

	@Test
	public void markWithModifiers() {
		String[] expectedTypes = new String[]{"BEGIN_RULE",
				"NAME", "LPAREN", "NAME", "RPAREN",
				"BEGIN_BODY", "TEXT",
				"TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "TRIGGER", "ID", "TEXT", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.MARK_WITH_MODIFIERS);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void mediumTest() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TEXT",
				"BEGIN_EXPRESSION", "TRIGGER", "ID", "TEXT", "END_EXPRESSION", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.MEDIUM_TEST);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void twoRules() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TEXT",
				"BEGIN_EXPRESSION", "TRIGGER", "ID", "TEXT", "END_EXPRESSION",
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TEXT",
				"BEGIN_EXPRESSION", "TRIGGER", "ID", "TEXT", "END_EXPRESSION", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.TWO_RULES);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void ruleWithEval() {
		String[] expectedTypes = new String[]{"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "OTHER", "OTHER", "OTHER", "NAME", "OTHER", "RPAREN", "BEGIN_BODY", "TEXT",
				"BEGIN_EXPRESSION", "TRIGGER", "ID", "TEXT", "END_EXPRESSION",
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY", "TEXT",
				"BEGIN_EXPRESSION", "TRIGGER", "ID", "TEXT", "END_EXPRESSION", "TEXT"};
		String[] receivedTypes = lexerTest(TestSources.RULE_WITH_EVAL);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void ruleWithListMarkInExpression() {
		String[] expectedTypes = new String[]{"BEGIN_RULE",
				"NAME", "LPAREN", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TRIGGER", "ID", "TEXT", "BEGIN_EXPRESSION", "TEXT", "TRIGGER", "ID", "LIST", "SEPARATOR", "END_EXPRESSION", "TEXT",
				"BEGIN_EXPRESSION", "TEXT", "TRIGGER", "ID", "TEXT", "END_EXPRESSION", "TEXT",
				"TEXT"};
		String[] receivedTypes = lexerTest(TestSources.ITRULES_TEST);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void littleBigTest() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "BEGIN_EXPRESSION", "TRIGGER", "ID", "TEXT", "END_EXPRESSION", "BEGIN_EXPRESSION", "TRIGGER", "ID", "TEXT", "END_EXPRESSION", "TRIGGER", "ID", "TEXT", "BEGIN_EXPRESSION", "TEXT", "TRIGGER", "ID", "TEXT", "END_EXPRESSION", "BEGIN_EXPRESSION", "TEXT", "TRIGGER", "ID", "LIST", "SEPARATOR", "END_EXPRESSION", "TEXT", "TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT",
				"TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT",
				"TEXT",
				"TEXT", "TRIGGER", "ID", "TEXT", "TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT",
				"TEXT", "TEXT",
				"TEXT",
				"TEXT"};
		String[] receivedTypes = lexerTest(TestSources.LITTLE_BIG_TEST);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void xmlTaraTest() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT",
				"TEXT", "TEXT", "TRIGGER", "ID", "LIST", "SEPARATOR", "TEXT",
				"TEXT", "TEXT",
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT", "TRIGGER", "ID", "TEXT", "TRIGGER", "ID", "TEXT", "TEXT", "TEXT",
				"TRIGGER", "ID", "LIST", "SEPARATOR", "TEXT", "TEXT",
				"TEXT",
				"TEXT",
		};
		String[] receivedTypes = lexerTest(
				TestSources.XML_TARA);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void xmlSmallTest() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT", "TRIGGER", "ID", "TEXT", "TRIGGER", "ID", "TEXT", "TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR",
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "AND",
				"NAME", "LPAREN", "NAME", "OTHER", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT", "TRIGGER", "ID", "TEXT",
				"TEXT"
		};
		String[] receivedTypes = lexerTest(TestSources.XML_SMALL);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void xmlCompleteTest() {
		String[] expectedTypes = new String[]{
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT", "TRIGGER", "ID", "TEXT", "TRIGGER", "ID", "TEXT", "TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "TEXT",
				"TEXT", "TRIGGER", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT",
				"TEXT",
				"TEXT",
				"TEXT",
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "OTHER", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT", "TRIGGER", "ID", "TEXT",
				"BEGIN_RULE", "NAME", "LPAREN", "NAME", "OTHER", "NAME", "RPAREN", "BEGIN_BODY",
				"TEXT", "TEXT", "TRIGGER", "ID", "TEXT",
				"TEXT"};

		String[] receivedTypes = lexerTest(TestSources.LARGE_XML);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	public static String[] ruleNamesList;

	public static void setRulesNameList(String[] list) {
		ruleNamesList = list;
	}

	public static String getRulesNameList(int index) {
		return ruleNamesList[index];
	}

	private static String[] lexerTest(String query) {
		try {
			String receivedToken;
			ArrayList<String> receivedTypes = new ArrayList<>();
			ItrLexer lexer = new ItrLexer(fromString(query));
			lexer.reset();
			setRulesNameList(lexer.getRuleNames());
			Token currentToken = lexer.nextToken();
			while (currentToken.getType() != Token.EOF) {
				receivedToken = getRulesNameList(currentToken.getType() - 1);
				receivedTypes.add(receivedToken);
				System.out.println(receivedToken + ": " + currentToken.getText() + ";");
				currentToken = lexer.nextToken();
			}
			System.out.println();
			System.out.println();
			System.out.println(String.join(", ", receivedTypes));
			return receivedTypes.toArray(new String[0]);
		} catch (RecognitionException error) {
			System.err.println("Error on query: " + query);
			return (new String[0]);
		}
	}
}
