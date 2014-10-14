package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class NestedInterfaces {

	@Test
	public void testNestedFrames() throws Exception {
		Frame frame = new Frame("interface");
		frame.property("name", "Person");
		frame.property("package", "org.sample");
		frame.property("sub", new Frame("sub") {{
			property("name", "Handler");
			property("parent", "org.sample.Handler");
		}});
		frame.property("sub", new Frame("sub") {{
			property("name", "Field");
			property("sub", new Frame("sub") {{
				property("name", "Handler");
				property("parent", "org.sample.Person.Handler");
			}});
		}});

		Document document = new Document();
		new RuleEngine(getRules()).render(frame, document);
		assertEquals("package org.sample;\n" +
			"\n" +
			"public interface Person {\n" +
			"\n" +
			"    public interface Handler extends org.sample.Handler {\n" +
			"\n" +
			"\n" +
			"    }\n" +
			"\n" +
			"    public interface Field {\n" +
			"\n" +
			"        public interface Handler extends org.sample.Person.Handler {\n" +
			"\n" +
			"\n" +
			"        }\n" +
			"    }\n" +
			"}", document.content());
	}

	public InputStream getRules() {
		return Eval.class.getResourceAsStream("/nested_interfaces.itr");
	}
}
