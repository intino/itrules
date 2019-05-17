/*
 * Copyright 2014
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

package io.intino.itrules.dsl;

import io.intino.itrules.Rule;
import io.intino.itrules.RuleSet;
import io.intino.itrules.parser.Interpreter;
import io.intino.itrules.parser.ParsedTemplate;
import io.intino.itrules.parser.TemplateErrorStrategy;
import io.intino.itrules.rules.conditions.AttributeCondition;
import io.intino.itrules.rules.output.Mark;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.CharStreams.fromString;


public class ParserTest {

	@Test
	public void test1() {
		ItrParser parser = init(TestSources.OTHER_WITH_MARK);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		ItrParser parser = init(TestSources.RULE_WITH_MARKS);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		ItrParser parser = init(TestSources.ESCAPED_CHARACTERS);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test4() {
		ItrParser parser = init(TestSources.SIGNATURE);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {
		ItrParser parser = init(TestSources.TWO_RULES);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test6() {
		ItrParser parser = init(TestSources.XML_TARA);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test7() {
		ItrParser parser = init(TestSources.LITTLE_BIG_TEST);
		try {
			RuleSet ruleset = parse(parser).ruleset();
			Assert.assertNotNull(ruleset);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test8() {
		ItrParser parser = init(TestSources.LARGE_XML);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test9() {
		ItrParser parser = init(TestSources.MARK);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test10() {
		ItrParser parser = init(TestSources.MARK_WITH_FORMAT);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test11() {
		ItrParser parser = init(TestSources.EXPRESION_WITH_NEW_LINES);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test12() {
		ItrParser parser = init(TestSources.RULE_WITH_OR_EXPRESSIONS);
		try {
			Assert.assertNotNull(parse(parser).ruleset());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}


	@Test
	public void test13() {
		ItrParser parser = init(TestSources.LAMBDA_TEST);
		try {
			ParsedTemplate template = parse(parser);
			RuleSet ruleset = template.ruleset();
			Assert.assertNotNull(ruleset);
			Mark mark = (Mark) ruleset.iterator().next().outputs().filter(o -> o instanceof Mark).findFirst().orElse(null);
			Assert.assertNotNull(mark);
			Assert.assertNotNull(template.formatters().get(mark.formatters()[0]));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test14() {
		ItrParser parser = init(TestSources.SIGNATURE_WITH_ATTRIBUTES_1);
		try {
			RuleSet ruleset = parse(parser).ruleset();
			Assert.assertNotNull(ruleset);
			List<Rule.Condition> conditions = ruleset.iterator().next().conditions().collect(Collectors.toList());
			Assert.assertEquals(2, conditions.size());
			Assert.assertTrue(conditions.get(1) instanceof AttributeCondition);
			Assert.assertEquals("a", ((AttributeCondition) conditions.get(1)).attribute());
			Assert.assertEquals("b", ((AttributeCondition) conditions.get(1)).value());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test15() {
		ItrParser parser = init(TestSources.SIGNATURE_WITH_ATTRIBUTES_2);
		try {
			RuleSet ruleset = parse(parser).ruleset();
			Assert.assertNotNull(ruleset);
			List<Rule.Condition> conditions = ruleset.iterator().next().conditions().collect(Collectors.toList());
			Assert.assertEquals(2, conditions.size());
			Assert.assertTrue(conditions.get(1) instanceof AttributeCondition);
			Assert.assertEquals("a", ((AttributeCondition) conditions.get(1)).attribute());
			Assert.assertNull(((AttributeCondition) conditions.get(1)).value());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test16() {
		ItrParser parser = init(TestSources.LITTLE_BIG_TEST_2);
		try {
			RuleSet ruleset = parse(parser).ruleset();
			Assert.assertNotNull(ruleset);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	private ItrParser init(String query) {
		ItrLexer lexer = new ItrLexer(fromString(query));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ItrParser parser = new ItrParser(tokens);
		parser.setTrace(true);
		parser.setErrorHandler(new TemplateErrorStrategy());
		return parser;
	}

	private ParsedTemplate parse(ItrParser parser) {
		try {
			ParsedTemplate template = new ParsedTemplate();
			ItrParser.RootContext root = parser.root();
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(new Interpreter(template, null), root);
			return template;
		} catch (RecognitionException e) {
			Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			System.err.println("Syntax error in line" + token.getLine() + "at" + token.getCharPositionInLine());
			return null;
		}
	}
}