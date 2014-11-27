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

public class NestedFrames {
	private static final String FILE_JSON = "/json/nestedframes.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/nested_frames.itr";

	@Test
	public void testNestedFrames() throws Exception {
		RuleReader reader = new TemplateReader(getRules());
		FileWriter writer = new FileWriter(TEST);
		writer.write(RulesSaver.toJSON(reader.read()));
		writer.close();
		Frame frame = buildFrame();
		Document document = new Document();
		Rule[] rules = new JSONRuleReader(getJsonRules()).read();
		assertNotNull(rules);
		RuleEngine ruleEngine = new RuleEngine(rules);
		ruleEngine.render(frame, document);
		assertEquals(EXPECTED, document.content());
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

	private Frame buildFrame() {
		Frame frame = new Frame("Roster");
		frame.addSlot("Coach", new Frame("Person") {{
			addSlot("Name", "Juan Antonio Orenga");
			addSlot("Birthday", new DateTime("29/07/1966"));
			addSlot("Country", "Spain");
		}});
		frame.addSlot("Player", new Frame("Person") {{
			addSlot("Name", "Pau Gasol");
			addSlot("Birthday", new DateTime("06/07/1980"));
			addSlot("Country", "Spain");
		}});
		frame.addSlot("Player", new Frame("Person") {{
			addSlot("Name", "Rudy Fernandez");
			addSlot("Birthday", new DateTime("04/04/1985"));
			addSlot("Country", "Spain");
		}});
		frame.addSlot("Player", new Frame("Person") {{
			addSlot("Name", "Juan Carlos Navarro");
			addSlot("Birthday", new DateTime("17/06/1980"));
			addSlot("Country", "Spain");
		}});
		return frame;
	}

	private static final String EXPECTED = "<roster>\n" +
		"    <coach name=\"Juan Antonio Orenga\" year=\"1966\" country=\"Spain\"/>\n" +
		"\t<players>\n" +
		"\t\t<player name=\"Pau Gasol\" year=\"1980\" country=\"Spain\"/>\n" +
		"\t\t<player name=\"Rudy Fernandez\" year=\"1985\" country=\"Spain\"/>\n" +
		"\t\t<player name=\"Juan Carlos Navarro\" year=\"1980\" country=\"Spain\"/>\n" +
		"    </players>\n" +
		"</roster>";

}
