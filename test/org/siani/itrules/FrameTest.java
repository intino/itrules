package org.siani.itrules;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FrameTest {

	OutputStream output = new OutputStream() {
		private StringBuilder string = new StringBuilder();

		@Override
		public void write(int b) throws IOException {
			this.string.append((char) b);
		}

		public String toString() {
			return this.string.toString();
		}
	};

	@Test
	public void testObjectMapCreation() throws Exception {
		Frame frame = new Frame("Class");
		frame.attribute("name", "Customer");
		frame.attribute("final", "final");
		frame.attribute("superclass", "Client");
		frame.attribute("interface", "Company");
		frame.attribute("interface", "TaxPayer");
		frame.attribute("attribute", new Frame("Attribute", "ReadOnly") {{
			attribute("name", "name");
			attribute("type", "String");
		}});
		frame.attribute("attribute", new Frame("Attribute", "ReadOnly") {{
			attribute("name", "FamilyName");
			attribute("type", "String");
		}});
		frame.attribute("attribute", new Frame("Attribute", "ReadOnly") {{
			attribute("name", "MaxAge");
			attribute("type", "Integer");
			attribute("default", "100");
		}});

		Document document = new Document();
		RuleEngine ruleEngine = new RuleEngine(stream);
		ruleEngine.render(document, frame);
		System.out.println(document.print());
	}


	InputStream stream = new ByteArrayInputStream(TestSources.JAVA_COMPLETE.getBytes(StandardCharsets.UTF_8));
}
