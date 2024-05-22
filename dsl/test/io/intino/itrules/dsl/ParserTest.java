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

import io.intino.itrules.parser.Interpreter;
import io.intino.itrules.parser.TemplateErrorStrategy;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;
import io.intino.itrules.template.condition.BinaryExpression;
import io.intino.itrules.template.condition.LogicalExpression;
import io.intino.itrules.template.condition.predicates.AttributePredicate;
import io.intino.itrules.template.condition.predicates.TypePredicate;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.antlr.v4.runtime.CharStreams.fromString;
import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

	@Test
	public void test1() {
		ItrParser parser = init(TestSources.OTHER_WITH_MARK);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test2() {
		ItrParser parser = init(TestSources.RULE_WITH_MARKS);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test3() {
		ItrParser parser = init(TestSources.ESCAPED_CHARACTERS);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test4() {
		ItrParser parser = init(TestSources.SIGNATURE);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test5() {
		ItrParser parser = init(TestSources.TWO_RULES);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test6() {
		ItrParser parser = init(TestSources.XML_TARA);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test7() {
		ItrParser parser = init(TestSources.LITTLE_BIG_TEST);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test8() {
		ItrParser parser = init(TestSources.LARGE_XML);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test9() {
		ItrParser parser = init(TestSources.MARK);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test10() {
		ItrParser parser = init(TestSources.MARK_WITH_FORMAT);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test11() {
		ItrParser parser = init(TestSources.EXPRESION_WITH_NEW_LINES);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test12() {
		ItrParser parser = init(TestSources.RULE_WITH_OR_EXPRESSIONS);
		try {
			Assert.assertNotNull(parse(parser).ruleSet());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test13() {
		ItrParser parser = init(TestSources.SIGNATURE_WITH_ATTRIBUTES_1);
		try {
			List<Rule> ruleset = parse(parser).ruleSet();
			Assert.assertNotNull(ruleset);
			Assert.assertEquals(ruleset.size(), 1);
			LogicalExpression condition = ruleset.getFirst().condition();
			Assert.assertTrue(condition instanceof BinaryExpression);
			BinaryExpression expression = (BinaryExpression) condition;
			Assert.assertTrue(expression.right() instanceof AttributePredicate);
			Assert.assertEquals("a", ((AttributePredicate) expression.right()).attribute());
			Assert.assertEquals("b", ((AttributePredicate) expression.right()).value());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test14() {
		ItrParser parser = init(TestSources.SIGNATURE_WITH_ATTRIBUTES_2);
		try {
			List<Rule> rules = parse(parser).ruleSet();
			Assert.assertNotNull(rules);
			Assert.assertEquals(rules.size(), 1);
			LogicalExpression condition = rules.getFirst().condition();
			Assert.assertTrue(condition instanceof BinaryExpression);
			BinaryExpression expression = (BinaryExpression) condition;
			Assert.assertTrue(expression.right() instanceof AttributePredicate);
			Assert.assertEquals("a", ((AttributePredicate) expression.right()).attribute());
			Assert.assertNull(((AttributePredicate) expression.right()).value());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test15() {
		ItrParser parser = init(TestSources.LITTLE_BIG_TEST_2);
		try {
			List<Rule> rules = parse(parser).ruleSet();
			Assert.assertNotNull(rules);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test16() {
		ItrParser parser = init(TestSources.MARK_WITH_TARGET);
		try {
			List<Rule> rules = parse(parser).ruleSet();
			Assert.assertNotNull(rules);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test17() {
		ItrParser parser = init(TestSources.CONDITION_TEST);
		try {
			List<Rule> rules = parse(parser).ruleSet();
			Assert.assertNotNull(rules);
			LogicalExpression condition = rules.get(0).condition();
			assertThat(condition).isNotNull();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test18() {
		ItrParser parser = init(TestSources.CONDITION_2_TEST);
		try {
			List<Rule> rules = parse(parser).ruleSet();
			Assert.assertNotNull(rules);
			LogicalExpression condition = rules.get(0).condition();
			assertThat(condition).isNotNull();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testFull() throws IOException {
		ItrParser parser = init(new String(this.getClass().getResourceAsStream("/FullTemplate.itr").readAllBytes()));
		try {
			List<Rule> rules = parse(parser).ruleSet();
			Assert.assertNotNull(rules);
			LogicalExpression condition = rules.get(0).condition();
			assertThat(condition).isInstanceOf(TypePredicate.class);
			assertThat(((TypePredicate) condition).types()).isEqualTo(new String[]{"api", "service"});
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	private ItrParser init(String query) {
		ItrLexer lexer = new ItrLexer(fromString(query));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ItrParser parser = new ItrParser(tokens);
		parser.setTrace(false);
		parser.setErrorHandler(new TemplateErrorStrategy());
		return parser;
	}

	private Template parse(ItrParser parser) throws RecognitionException {
		try {
			ItrParser.RootContext root = parser.root();
			ParseTreeWalker walker = new ParseTreeWalker();
			Interpreter interpreter = new Interpreter(null);
			walker.walk(interpreter, root);
			return interpreter.template();
		} catch (RecognitionException e) {
			Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			String message = "Syntax error in line " + token.getLine() + " at " + token.getCharPositionInLine() + ". " + token.getText() + " not recognized";
			System.err.println(message);
			throw e;
		}
	}
}