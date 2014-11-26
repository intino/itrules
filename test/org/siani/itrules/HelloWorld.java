package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HelloWorld {

	private static final String FILE_JSON = "/json/helloworld.json";
	private static final File TEST = new File("res_test", FILE_JSON);

	@Test
	public void testHelloWorld() throws Exception {
		RuleReader reader = new TemplateReader("");
		FileWriter writer = new FileWriter(TEST);
		writer.write(RulesSaver.toJSON(reader.read()));
		writer.close();
		Frame frame = buildFrame();
		Document document = new Document();
		Rule[] rules = new JSONRuleReader(getJsonRules()).read();
		assertNotNull(rules);
		RuleEngine ruleEngine = new RuleEngine(rules);
		ruleEngine.render(frame, document);
		assertEquals("Hello world", document.content());

	}

	private Frame buildFrame() {
		return new Frame("String").addSlot("value", "Hello world");
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
