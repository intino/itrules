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

public class Plural {
//	private static final String FILE_JSON = "/json/plural.json";
//	private static final File TEST = new File("res_test", FILE_JSON);
//	private static final String FILE_ITR = "/plural.itr";
//
//	static {
//		TEST.getParentFile().mkdirs();
//	}
//
//	@Test
//	public void testPlural() throws Exception {
//		RulesReader reader = new RuleSetReader(getRules());
//		FileWriter writer = new FileWriter(TEST);
//		writer.write(RulesSaver.toJSON(reader.read()));
//		writer.close();
//		Frame frame = buildFrame();
//		Document document = new Document();
//		Rule[] rules = new JSONRulesReader(getJsonRules()).read();
//		assertNotNull(rules);
//		RuleEngine ruleEngine = new RuleEngine(rules);
//		ruleEngine.render(frame, document);
//		assertEquals(EXPECTED, document.content());
//	}
//
//	public InputStream getRules() {
//		return this.getClass().getResourceAsStream(FILE_ITR);
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
//
//	private Frame buildFrame() {
//		Frame frame = new Frame("Contract");
//		frame.addFrame("Owner", new Frame("Person") {{
//			addFrame("Name", "persona");
//			addFrame("Address", "direccion");
//			addFrame("City", "ciudad");
//			addFrame("IdCard", "4050321");
//		}});
//		frame.addFrame("Pet", new Frame("Dog") {{
//			addFrame("Chip", "X204512");
//			addFrame("Especie", "Caniche");
//			addFrame("Age", "2");
//		}});
//		frame.addFrame("Date", new DateTime("27/09/2014"));
//		return frame;
//	}
//
//	private static final String EXPECTED = "Las Palmas de Gran de Canaria, el 27/09/2014\n" +
//		"\n" +
//		"personas, con DNI 4050321, con domicilio en la calle direcciones, ciudades\n" +
//		"\n" +
//		"declara adoptar a\n" +
//		"\n" +
//		"El perro con chip X204512, de la especie Caniche, de 2 años\n" +
//		"\n" +
//		"\n" +
//		"\n" +
//		"Firmado\n" +
//		"personas, con DNI 4050321, con domicilio en la calle direcciones, ciudades";

}
