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

	@Test
	public void testBox() throws Exception {
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
		"\n" +
		"            parent(Parent1);\n" +
		"\n" +
		"            def(\"definitionName2\");\n" +
		"\n" +
		"                parent(Parent2);\n" +
		"\n" +
		"            end();\n" +
		"\n" +
		"        end();\n" +
		"    }\n" +
		"}";
}
