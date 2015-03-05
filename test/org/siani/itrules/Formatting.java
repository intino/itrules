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

package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Formatting {
//	private static final String FILE1_JSON = "/json/formatting.json";
//	private static final String FILE2_JSON = "/json/formatting2.json";
//	private static final File TEST1 = new File("res_test", FILE1_JSON);
//	private static final File TEST2 = new File("res_test", FILE2_JSON);
//	private static final String RULES2 = "defrule type(Person)\n$Name is $Height+Letters+Title cm tall, earns $$$Salary+Separators and has" +
//		" played in $Club+Count basket clubs\nendrule";
//
//	static {
//		TEST1.getParentFile().mkdirs();
//	}
//
//	@Test
//	public void testFormatting1() throws Exception {
//		RulesReader reader = new RuleSetReader(getRules());
//		FileWriter writer = new FileWriter(TEST1);
//		writer.write(RulesSaver.toJSON(reader.read()));
//		writer.close();
//		Frame frame = buildFrame1();
//		Document document = new Document();
//		Rule[] rules = new JSONRulesReader(getJsonRules(TEST1)).read();
//		assertNotNull(rules);
//		RuleEngine ruleEngine = new RuleEngine(rules);
//		ruleEngine.render(frame, document);
//		assertEquals(EXPECTED_1, document.content());
//	}
//
//	@Test
//	public void testFormatting2() throws Exception {
//		RulesReader reader = new RuleSetReader(RULES2);
//		FileWriter writer = new FileWriter(TEST2);
//		writer.write(RulesSaver.toJSON(reader.read()));
//		writer.close();
//		Frame frame = buildFrame2();
//		Document document = new Document();
//		Rule[] rules = new JSONRulesReader(getJsonRules(TEST2)).read();
//		assertNotNull(rules);
//		RuleEngine ruleEngine = new RuleEngine(rules);
//		ruleEngine.render(frame, document);
//		assertEquals(EXPECTED_2, document.content());
//	}
//
//	private Frame buildFrame2() {
//		Frame frame = new Frame("Person");
//		frame.addFrame("Name", "Pau Gasol");
//		frame.addFrame("Height", 213);
//		frame.addFrame("Salary", 19201402);
//		frame.addFrame("Club", "Barcelona", "Lakers");
//		return frame;
//	}
//
//	private Frame buildFrame1() {
//		Frame frame = new Frame("Person");
//		frame.addFrame("Name", "Pau Gasol");
//		frame.addFrame("Birthday", new DateTime("06/07/1980"));
//		frame.addFrame("Country", "Spain");
//		return frame;
//	}
//
//	public InputStream getJsonRules(File file) {
//		try {
//			return new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public InputStream getRules() {
//		return this.getClass().getResourceAsStream("/" + this.getClass().getSimpleName().toLowerCase() + ".itr");
//	}
//
//	private static final String EXPECTED_1 = "" +
//		"Default: Pau Gasol\n" +
//		"UpperCase: PAU GASOL\n" +
//		"LowerCase: pau gasol\n" +
//		"CamelCase: PauGasol\n" +
//		"LowerCamelCase: pauGasol\n" +
//		"\n" +
//		"Default: Sun Jul 06 00:00:00 WEST 1980\n" +
//		"Year: 1980\n" +
//		"MonthYear: July 1980\n" +
//		"ShortDate: 06/07/1980\n" +
//		"FullDate: 06 July 1980\n" +
//		"DayOfWeek: Sunday\n" +
//		"Time: 00:00";
//	private static final String EXPECTED_2 =
//		"Pau Gasol is two hundred and thirteen cm tall, earns $19,201,402 and has played in BarcelonaLakers basket clubs";
}
