package es.siani.templation;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LexerTest {

	public static String[] ruleNamesList;

	@Test
	public void MarkKeyTest() {
		String expectedType = "BLOCK_KEY";
		String[] receivedTypes = lexerTest(":");
		assertEquals(receivedTypes[0], (expectedType));
	}

	@Test
	public void blockBeginTest() {
		String[] expectedTypes = new String[]{"BLOCK_KEY", "BLOCK_NAME", "NL"};
		String[] receivedTypes = lexerTest(":markca \n");
		assertArrayEquals(expectedTypes, receivedTypes);
	}


	@Test
	public void textTest() {
		String expectedType = "TEXT";
		String[] receivedTypes = lexerTest("Name");
		assertEquals(receivedTypes[0], expectedType);
	}

	@Test
	public void mark() {
		String[] expectedTypes = new String[]{"BLOCK_KEY", "BLOCK_NAME", "NL", "MARK_KEY", "MARK_NAME", "TEXT"};
		String[] receivedTypes = lexerTest(":Class \t \t   \t\t\n$m  ");
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void OtherWithMark() {
		String[] expectedTypes = new String[]{"BLOCK_KEY", "BLOCK_NAME", "NL", "TEXT",
			"MARK_KEY", "MARK_NAME", "TEXT", "MARK_KEY", "MARK_NAME", "TEXT"};
		String[] receivedTypes = lexerTest(":Class\npublic class $attri alalasda $other ");
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void markWithModifiers() {
		String[] expectedTypes = new String[]{"BLOCK_KEY", "BLOCK_NAME", "NL", "TEXT",
			"MARK_KEY", "MARK_NAME", "TAG", "MARK_NAME", "LIST", "SEPARATOR", "TEXT", "MARK_KEY", "MARK_NAME", "TEXT"};
		String[] receivedTypes = lexerTest(":Class\npublic class $attribute+Const...[$NL] alalasda $other ");
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void mediumTest() {
		String[] expectedTypes = new String[]{"BLOCK_KEY", "BLOCK_NAME", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "MARK_NAME", "TEXT", "RIGHT_SQ"};
		String[] receivedTypes = lexerTest(":Class\n" +
			"public class [$static ]");
		assertArrayEquals(expectedTypes, receivedTypes);
	}

	@Test
	public void littleBigTest() {
		String[] expectedTypes = new String[]{"BLOCK_KEY", "BLOCK_NAME", "NL", "TEXT",
			"LEFT_SQ", "MARK_KEY", "MARK_NAME", "TEXT", "RIGHT_SQ", "LEFT_SQ", "MARK_KEY", "MARK_NAME", "TEXT",
			"RIGHT_SQ", "MARK_KEY", "MARK_NAME", "TEXT", "LEFT_SQ", "TEXT", "MARK_KEY", "MARK_NAME", "TEXT", "RIGHT_SQ", "LEFT_SQ",
			"TEXT", "MARK_KEY", "MARK_NAME", "LIST", "SEPARATOR", "RIGHT_SQ", "TEXT"};
		String[] receivedTypes = lexerTest(":Class\n" +
			"public class [$static ][$final ]$Name [extends $Superclass ][implements $Interface...[, ]]{\n" +
			"\t$attribute+Const...[$NL]\n" +
			"\t$attribute+Field...[$NL]\n" +
			"\n" +
			"\t$attribute+Getter...[$NL]\n" +
			"\n" +
			"\tpublic $Name($attribute+Injection...[,]) {\n" +
			"\t\t$attribute:Initialize...[$NL]\n" +
			"\t}\n" +
			"}");
		assertArrayEquals(expectedTypes, receivedTypes);
	}


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
			TemplationLexer lexer = new TemplationLexer(stream);
			lexer.reset();
			lexer.setState(1);
			setRulesNameList(lexer.getRuleNames());
			Token currentToken = lexer.nextToken();
			while (currentToken.getType() != Token.EOF) {
				receivedToken = getRulesNameList(currentToken.getType() - 1);
				receivedTypes.add(receivedToken);
				currentToken = lexer.nextToken();
			}
			String[] list = new String[receivedTypes.size()];
			return receivedTypes.toArray(list);
		} catch (RecognitionException error) {
			System.err.println("Error on query: " + query);
			return (new String[0]);
		}
	}
}
