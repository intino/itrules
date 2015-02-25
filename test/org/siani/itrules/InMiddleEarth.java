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

public class InMiddleEarth {

	private static final String FILE_JSON = "/json/inmiddleearth.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/in_middle_earth.itr";

	static {
		TEST.getParentFile().mkdirs();
	}

	@Test
	public void testInMiddleEarth() throws Exception {
		RulesReader reader = new RuleSetReader(getRules());
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

	private Frame buildFrame() {
		Frame frame = new Frame("Message");
		frame.addFrame("From", "frodo@hobbiton.me");
		frame.addFrame("To", "gandalf@elrond.me");
		frame.addFrame("To", "bilbo@hobbiton.me");
		frame.addFrame("Subject", "The ring");
		frame.addFrame("Text", "I wish the Ring had never come to me.");
		frame.addFrame("Text", "I wish none of this had happened.");
		return frame;
	}

	private static final String EXPECTED = "" +
		"From: frodo@hobbiton.me\n" +
		"To: gandalf@elrond.me, bilbo@hobbiton.me\n" +
		"The ring\n" +
		"\n" +
		"I wish the Ring had never come to me.\n" +
		"I wish none of this had happened.";

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
