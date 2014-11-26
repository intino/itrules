package org.siani.itrules.lang;

import org.antlr.v4.runtime.*;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

	@Test
	public void test1() {
		ITRulesParser parser = init(TestSources.OTHER_WITH_MARK);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		ITRulesParser parser = init(TestSources.RULE_WITH_MARKS);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		ITRulesParser parser = init(TestSources.SCAPED_CHARACTERS);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test4() {
		ITRulesParser parser = init(TestSources.SIGNATURE);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {
		ITRulesParser parser = init(TestSources.TWO_RULES);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test6() {
		ITRulesParser parser = init(TestSources.XML_TARA);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test7() {
		ITRulesParser parser = init(TestSources.LITTLE_BIG_TEST);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test8() {
		ITRulesParser parser = init(TestSources.LARGE_XML);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test9() {
		ITRulesParser parser = init(TestSources.MARK);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test10() {
		ITRulesParser parser = init(TestSources.MARK_WITH_FORMAT);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ITRulesParser init(String query) {
		CharStream stream = new ANTLRInputStream(query);
		ITRulesLexer lexer = new ITRulesLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ITRulesParser parser = new ITRulesParser(tokens);
		parser.setTrace(true);
		parser.setErrorHandler(new TemplateErrorStrategy());
		return parser;
	}


	private boolean parse(ITRulesParser parser) throws Exception {
		try {
			ITRulesParser.RootContext rootContext = parser.root();
			return true;
		} catch (RecognitionException e) {
			Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			System.err.println("Syntax error in line" + token.getLine() + "at" + token.getCharPositionInLine());
			return false;
		}
	}
}