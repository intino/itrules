package org.siani.itrules.lang;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.siani.itrules.TestSources.*;

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
		String[] receivedTypes = lexerTest(RULE_BEGIN);
		assertEquals(receivedTypes[0], (expectedType));
	}

	@Test
	public void ruleSignatureTest() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "RULE_END"};
		String[] receivedTypes = lexerTest(SIGNATURE);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void textTest() {
		String[] receivedTypes = lexerTest("\'Name\'");
		assertTrue(receivedTypes.length == 0);
	}

	@Test
	public void mark() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(MARK);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void scapeCharacter() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "SCAPED_CHAR", "TEXT",
			"SCAPED_CHAR", "TEXT", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(SCAPED_CHARACTERS);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void OtherWithMark() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(OTHER_WITH_MARK);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void MarkWithFormat() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P",
			"TRIGGER", "LEFT_P", "ID", "OPTION", "ID", "RIGHT_P", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "OPTION", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(MARK_WITH_FORMAT);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void classWithMarks() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P",
			"TRIGGER", "LEFT_P", "ID", "OPTION", "ID", "RIGHT_P",
			"TYPE", "LEFT_P", "NOT", "ID", "RIGHT_P", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL",
			"TEXT", "MARK_KEY", "ID", "TEXT", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(
			RULE_WITH_MARKS
		);
		assertArrayEquals(expectedTypes, receivedTypes);

	}

	@Test
	public void markWithModifiers() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"MARK_KEY", "ID", "OPTION", "ID", "LIST", "SEPARATOR", "TEXT", "MARK_KEY", "ID", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(MARK_WITH_MODIFIERS);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void mediumTest() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(MEDIUM_TEST);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void twoRules() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END",
			"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(TWO_RULES);
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void ruleWithEval() {
		String[] expectedTypes = new String[]{"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P",
			"EVAL", "LEFT_P", "ID", "OPERATOR", "STRING", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END",
			"RULE_BEGIN", "TYPE", "LEFT_P", "ID", "RIGHT_P", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "ID", "TEXT", "RIGHT_SQ", "TEXT", "RULE_END"};
		String[] receivedTypes = lexerTest(RULE_WITH_EVAL);
		assertArrayEquals(expectedTypes, receivedTypes);
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
		String[] receivedTypes = lexerTest(LITTLE_BIG_TEST);
		assertArrayEquals(expectedTypes, receivedTypes);
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
			XML_TARA);
		assertArrayEquals(expectedTypes, receivedTypes);
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
		String[] receivedTypes = lexerTest(XML_SMALL);
		assertArrayEquals(expectedTypes, receivedTypes);
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

		String[] receivedTypes = lexerTest(LARGE_XML);
		assertArrayEquals(expectedTypes, receivedTypes);
	}
}
