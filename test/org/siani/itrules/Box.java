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

public class Box {

	private static final String FILE_JSON = "/json/box.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/box.itr";

	static {
		TEST.getParentFile().mkdirs();
	}

	@Test
	public void testBox() throws Exception {
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
		Frame frame = new Frame("Box");
		frame.addSlot("name", "Tara");
		frame.addSlot("import", new Frame("import") {{
			addSlot("value", "import0");
		}});
		frame.addSlot("import", new Frame("import") {{
			addSlot("value", "import1");
		}});
		frame.addSlot("definition", new Frame("Definition") {{
			addSlot("name", "definitionName");
			addSlot("typeId", new Frame("typeId") {{
				addSlot("value", "definitionType");
			}});
			addSlot("parent", new Frame("parent") {{
				addSlot("value", "Parent1");
			}});
			addSlot("definition", new Frame("Definition") {{
				addSlot("name", "definitionName2");
				addSlot("typeId", new Frame("type2") {{
					addSlot("value", "definitionType2");
				}});
				addSlot("parent", new Frame("parent") {{
					addSlot("value", "Parent2");
				}});
			}});
		}});
		frame.addSlot("Pet", new Frame("Dog") {{
			addSlot("Chip", "X204512");
			addSlot("Especie", "Caniche");
			addSlot("Age", "2");
		}});
		frame.addSlot("Date", new DateTime("27/09/2014"));
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

	@SuppressWarnings("FieldCanBeLocal")
	private final String EXPECTED = "package schema;\n" +
		"\n" +
		"import magritte.model.Model;\n" +
		"\n" +
		"public class TaraBox extends Box {\n" +
		"    protected TaraBox(Model model) {\n" +
		"        super(model);\n" +
		"    }\n" +
		"\n" +
		"    public static void load(Model model) {\n" +
		"        new TaraBox(model);\n" +
		"    }\n" +
		"\n" +
		"    @Override\n" +
		"    protected void loadImports() {\n" +
		"        import0Box.load(model());\n" +
		"        import1Box.load(model());\n" +
		"    }\n" +
		"\n" +
		"    @Override\n" +
		"    protected void loadNodes() {\n" +
		"        def(\"definitionName\");\n" +
		"            parent(Parent1);\n" +
		"            def(\"definitionName2\");\n" +
		"                parent(Parent2);\n" +
		"            end();\n" +
		"        end();\n" +
		"    }\n" +
		"}";
}
