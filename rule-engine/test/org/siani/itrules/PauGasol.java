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
import org.siani.itrules.serialization.JsonRulesWriter;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PauGasol {
//
//	private static final String EXPECTED = "Pau Gasol was born in Spain on 06/07/1980";
//	private static final String FILE_JSON = "/json/paugasol.json";
//	private static final File TEST = new File("res_test", FILE_JSON);
//	private static final String RULE = "" +
//		"defrule type(Person)\n" +
//		"$Name was born in $Country on $Birthday\n" +
//		"endrule";
//
//	static {
//		TEST.getParentFile().mkdirs();
//	}
//
//	@Test
//	public void testPauGasol() throws Exception {
//		RulesReader reader = new RuleSetReader(RULE);
//		FileWriter writer = new FileWriter(TEST);
//		writer.write(RulesSaver.toJSON(reader.read()));
//		writer.close();
//		Frame frame = buildFrame();
//		AbstractFrame abstractFrame = frame.searchByName("Name");
//		Document document = new Document();
//		Rule[] rules = new JSONRulesReader(getJsonRules()).read();
//		assertNotNull(rules);
//		RuleEngine ruleEngine = new RuleEngine(rules);
//		ruleEngine.render(frame, document);
//		assertEquals(EXPECTED, document.content());
//	}
//
//
//	private Frame buildFrame() {
//		Frame frame = new Frame("Person");
//		frame.addFrame("Name", "Pau Gasol");
//		frame.addFrame("Birthday", "06/07/1980");
//		frame.addFrame("Country", "Spain");
//		return frame;
//	}
//
//	public InputStream getJsonRules() {
//		try {
//			return new FileInputStream(TEST);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

}