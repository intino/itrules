package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class NestedInterfaces {

	@Test
	public void testNestedFrames() throws Exception {
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
		Document document = new Document();
		RuleEngine engine = new RuleEngine(getRules());
		engine.render(frame, document);
		assertEquals("package org.sample;\n" +
			"\n" +
			"public interface Form {\n" +
			"\n" +
			"    public interface Handler extends org.sample.Handler {\n" +
			"\n" +
			"    }\n" +
			"    public interface Field {\n" +
			"\n" +
			"        public interface Handler extends org.sample.Form.Handler {\n" +
			"\n" +
			"        }\n" +
			"    }\n" +
			"    public interface TextField extends Field {\n" +
			"\n" +
			"        public interface Handler extends org.sample.Form.Handler {\n" +
			"\n" +
			"        }\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"public interface Handler {\n" +
			"\n" +
			"}\n" +
			"\n" + "\n", document.content());
	}

	public InputStream getRules() {
		return Eval.class.getResourceAsStream("/nested_interfaces.itr");
	}
}
