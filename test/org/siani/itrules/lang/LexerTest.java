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

package org.siani.itrules.lang;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LexerTest {


	public static String[] ruleNamesList;

	public static void setRulesNameList(String[] list) {
		ruleNamesList = list;
	}

	public static String getRulesNameList(int index) {
		return ruleNamesList[index];
	}

	public static String[] lexerTest(String query) {
		try {
			String receivedToken;
			ArrayList<String> receivedTypes = new ArrayList<>();
			CharStream stream = new ANTLRInputStream(query);
			ITRulesLexer lexer = new ITRulesLexer(stream);
			lexer.reset();
			setRulesNameList(lexer.getRuleNames());
			Token currentToken = lexer.nextToken();
			while (currentToken.getType() != Token.EOF) {
				receivedToken = getRulesNameList(currentToken.getType() - 1);
				receivedTypes.add(receivedToken);
				currentToken = lexer.nextToken();
			}
			return receivedTypes.toArray(new String[receivedTypes.size()]);
		} catch (RecognitionException error) {
			System.err.println("Error on query: " + query);
			return (new String[0]);
		}
	}

	@Test
	public void ruleBeginTest() {
		String expectedType = "RULE_BEGIN";
		String[] receivedTypes = lexerTest(TestSources.RULE_BEGIN);
		Assert.assertEquals(receivedTypes[0], (expectedType));
	}

	@Test
	public void ruleSignatureTest() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.SIGNATURE);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void textTest() {
		String[] receivedTypes = lexerTest("\'Name\'");
		Assert.assertTrue(receivedTypes.length == 0);
	}

	@Test
	public void mark() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.MARK);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void scapeCharacter() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "SCAPED_CHAR", "TEXT",
			"SCAPED_CHAR", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.SCAPED_CHARACTERS);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void OtherWithMark() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.OTHER_WITH_MARK);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void MarkWithFormat() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P",
			"TRIGGER", "LEFT_P", "ID", "OPTION", "ID", "RIGHT_P", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "OPTION", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.MARK_WITH_FORMAT);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void classWithMarks() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P",
			"TRIGGER", "LEFT_P", "ID", "OPTION", "ID", "RIGHT_P",
			"TYPE", "LEFT_P", "NOT", "ID", "RIGHT_P", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL",
			"TEXT", "MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(
			TestSources.RULE_WITH_MARKS
		);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);

	}

	@Test
	public void markWithModifiers() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.MARK_WITH_MODIFIERS);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void mediumTest() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.MEDIUM_TEST);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void twoRules() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END",
			"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.TWO_RULES);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void ruleWithEval() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P",
			"EVAL", "LEFT_P", "ID", "OPERATOR", "STRING", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END",
			"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.RULE_WITH_EVAL);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void littleBigTest() {
		String[] expectedTypes = new String[]
			{
				"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
				"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "LEFT_SQ", "MARK_KEY", "ID",
				"TEXT", "RIGHT_SQ", "MARK_KEY", "ID", "TEXT", "LEFT_SQ", "TEXT", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ",
				"LEFT_SQ", "TEXT", "MARK_KEY", "ID", "LIST", "SEPARATOR", "RIGHT_SQ", "TEXT", "MARK_KEY", "ID", "OPTION",
				"ID", "LIST", "SEPARATOR", "TEXT", "MARK_KEY", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "MARK_KEY",
				"ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID", "OPTION", "ID",
				"LIST", "SEPARATOR", "TEXT", "MARK_KEY", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TestSources.LITTLE_BIG_TEST);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void xmlTaraTest() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL",
			"TEXT", "MARK_KEY", "ID", "LIST", "SEPARATOR", "TEXT", "RULE_END",
			"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL",
			"TEXT", "MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID", "TEXT",
			"MARK_KEY", "ID", "LIST", "SEPARATOR", "TEXT", "RULE_END"
		};
		String[] receivedTypes = lexerTest(
			TestSources.XML_TARA);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void xmlSmallTest() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL",
			"TEXT", "MARK_KEY", "ID",
			"TEXT", "MARK_KEY", "ID",
			"TEXT", "MARK_KEY", "ID", "OPTION", "ID",
			"TEXT", "MARK_KEY", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "RULE_END",
			"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "TRIGGER", "LEFT_P", "ID", "OPTION", "ID", "RIGHT_P", "NL",
			"TEXT", "MARK_KEY", "ID", "TEXT", "RULE_END"
		};
		String[] receivedTypes = lexerTest(TestSources.XML_SMALL);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void xmlCompleteTest() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID",
			"TEXT", "MARK_KEY", "ID", "OPTION", "ID",
			"TEXT", "MARK_KEY", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "RULE_END",
			"RULE_BEGIN", "TRIGGER", "LEFT_P", "ID", "OPTION", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "TEXT", "RULE_END",
			"RULE_BEGIN", "TRIGGER", "LEFT_P", "ID", "OPTION", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "TEXT", "RULE_END"};

		String[] receivedTypes = lexerTest(TestSources.LARGE_XML);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void testTara() throws Exception {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID",
			"TEXT", "MARK_KEY", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "RULE_END",
			 "RULE_END"};

		String[] receivedTypes = lexerTest(TestSources.TARA);
		Assert.assertArrayEquals(expectedTypes, receivedTypes);
	}
}
