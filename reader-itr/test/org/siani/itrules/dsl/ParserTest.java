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

package org.siani.itrules.dsl;

import org.antlr.v4.runtime.*;
import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.parser.TemplateErrorStrategy;

public class ParserTest {

	@Test
	public void test1() {
		ItrParser parser = init(TestSources.OTHER_WITH_MARK);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		ItrParser parser = init(TestSources.RULE_WITH_MARKS);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		ItrParser parser = init(TestSources.ESCAPED_CHARACTERS);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test4() {
		ItrParser parser = init(TestSources.SIGNATURE);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {
		ItrParser parser = init(TestSources.TWO_RULES);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test6() {
		ItrParser parser = init(TestSources.XML_TARA);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test7() {
		ItrParser parser = init(TestSources.LITTLE_BIG_TEST);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test8() {
		ItrParser parser = init(TestSources.LARGE_XML);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test9() {
		ItrParser parser = init(TestSources.MARK);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test10() {
		ItrParser parser = init(TestSources.MARK_WITH_FORMAT);
		try {
			Assert.assertTrue(parse(parser));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	private ItrParser init(String query) {
		CharStream stream = new ANTLRInputStream(query);
		ItrLexer lexer = new ItrLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ItrParser parser = new ItrParser(tokens);
		parser.setTrace(true);
		parser.setErrorHandler(new TemplateErrorStrategy());
		return parser;
	}

	private boolean parse(ItrParser parser) throws Exception {
		try {
			ItrParser.RootContext rootContext = parser.root();
			return true;
		} catch (RecognitionException e) {
			Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			System.err.println("Syntax error in line" + token.getLine() + "at" + token.getCharPositionInLine());
			return false;
		}
	}
}