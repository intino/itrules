package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NestedInterfaces {
	private static final String FILE_JSON = "/json/nestedinterfaces.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/nested_interfaces.itr";

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

	private Frame buildFrame() {
		final Frame frame = new Frame("class");
		frame.addSlot("package", "org.sample");
		frame.addSlot("concept", new Frame("concept") {{
			addSlot("name", "Form");
			addSlot("concept", new Frame("concept", "action") {{
				addSlot("name", "Handler");
				addSlot("parent", "org.sample.Handler");
			}});
			addSlot("concept", new Frame("concept") {{
				addSlot("name", "Field");
				addSlot("concept", new Frame("concept", "action") {{
					addSlot("name", "Handler");
					addSlot("parent", "org.sample.Form.Handler");
				}});
			}});
			addSlot("concept", new Frame("concept") {{
				addSlot("name", "TextField");
				addSlot("parent", "Field");
				addSlot("concept", new Frame("concept", "action") {{
					addSlot("name", "Handler");
					addSlot("parent", "org.sample.Form.Handler");
				}});
			}});
		}});
		frame.addSlot("concept", new Frame("concept", "action", "private") {{
			addSlot("name", "Handler");
		}});
		frame.addSlot("concept", new Frame("concept") {{
			addSlot("name", "Collection");
			addSlot("concept", new Frame("concept") {{
				addSlot("name", "Item");
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

	private static final String EXPECTED = "package org.sample;\n" +
		"\n" +
		"public interface Form {\n" +
		"\n" +
		"    public interface Handler extends org.sample.Handler {\n" +
		"    }\n" +
		"    public interface Field {\n" +
		"\n" +
		"        public interface Handler extends org.sample.Form.Handler {\n" +
		"        }\n" +
		"    }\n" +
		"    public interface TextField extends Field {\n" +
		"\n" +
		"        public interface Handler extends org.sample.Form.Handler {\n" +
		"        }\n" +
		"    }\n" +
		"}\n" +
		"\n" +
		"public interface Handler {\n" +
		"}\n" +
		"\n" + "\n";
}
