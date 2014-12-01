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

public class JavaClass {

	private static final String FILE_JSON = "/json/javaclass.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/java_class.itr";

	static {
		TEST.getParentFile().mkdirs();
	}

	@Test
	public void testJavaClass() throws Exception {
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

	private Frame buildFrame() {
		Frame frame = new Frame("Class");
		frame.addSlot("name", "Customer");
		frame.addSlot("final", "final");
		frame.addSlot("superclass", "Client");
		frame.addSlot("interface", "Company");
		frame.addSlot("interface", "TaxPayer");
		frame.addSlot("attribute", new Frame("Attribute", "Const") {{
			addSlot("name", "CUSTOMER_NAME");
			addSlot("type", "String");
			addSlot("default", "\"CUSTOMER\"");
		}});
		frame.addSlot("attribute", new Frame("Attribute", "ReadOnly") {{
			addSlot("name", "familyName");
			addSlot("type", "String");
		}});
		frame.addSlot("attribute", new Frame("Attribute") {{
			addSlot("name", "maxAge");
			addSlot("type", "Integer");
			addSlot("default", "100");
		}});
		return frame;
	}

	private static final String EXPECTED = "public class final Customer extends Client implements Company, TaxPayer {\n" +
		"\n" +
		"\tpublic static final String CUSTOMER_NAME = \"CUSTOMER\";\n" +
		"\tprivate final String familyName;\n" +
		"\tprivate Integer maxAge = 100;\n" +
		"\n" +
		"\tpublic Customer(String familyName) {\n" +
		"\t\tthis.familyName = familyName;\n" +
		"\t}\n" +
		"\n" +
		"\tpublic String getFamilyName() {\n" +
		"\t\treturn familyName;\n" +
		"\t}\n" +
		"\n" +
		"\tpublic Integer getMaxAge() {\n" +
		"\t\treturn maxAge;\n" +
		"\t}\n" +
		"\n" +
		"\tpublic void setMaxAge(Integer value) {\n" +
		"\t\tmaxAge = value;\n" +
		"\t}\n\n" +
		"}";

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
