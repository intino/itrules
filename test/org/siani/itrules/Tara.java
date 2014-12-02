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

public class Tara {
	private static final String FILE_JSON = "/json/tara.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/tara.itr";

	static {
		TEST.getParentFile().mkdirs();
	}

	@Test
	public void testTara() throws Exception {
		RulesReader reader = new TemplateReader(getRules());
		FileWriter writer = new FileWriter(TEST);
		writer.write(RulesSaver.toJSON(reader.read()));
		writer.close();
		Frame frame = buildFrame();
		Document document = new Document();
		Rule[] rules = new JSONRulesReader(getJsonRules()).read();
		assertNotNull(rules);
		RuleEngine ruleEngine = new RuleEngine(rules);
		ruleEngine.render(frame, document);
		assertEquals(EXPECTED, document.content());
	}

	private static final String EXPECTED = "Environment('Solar_Radiation', 'temperature') Las Palmas > is Electrical(30.2, 15, 'ON')";


	private Frame buildFrame() {
		Frame frame = new Frame("model");
		frame.addFrame("node", new Frame("node") {{
			addFrame("type", "Environment");
			addFrame("parameter", "Solar_Radiation", "temperature");
			addFrame("name", "Las Palmas");
			addFrame("facet", new Frame("facet") {{
				addFrame("type", "electrical");
				addFrame("parameter", 30.2, 15, "ON");
			}});
		}});
		return frame;
	}

	public InputStream getRules() {
		return this.getClass().getResourceAsStream(FILE_ITR);
	}

	public InputStream getJsonRules() {
		try {
			return new FileInputStream(TEST);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
