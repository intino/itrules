package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Tara {
	private static final String FILE_JSON = "/json/tara.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/tara.itr";

	@Test
	public void testTara() throws Exception {
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

	private static final String EXPECTED = "Enviroment('Solar_Radiation', 'temperature') Las Palmas > is Electrical(30.2, 15, 'ON')\n\n";


	private Frame buildFrame() {
		Frame frame = new Frame("model");
		frame.addSlot("node", new Frame("node") {{
			addSlot("type", "Enviroment");
			addSlot("parameter", "Solar_Radiation", "temperature");
			addSlot("name", "Las Palmas");
			addSlot("facet", new Frame("facet") {{
				addSlot("type", "electrical");
				addSlot("parameter", 30.2, 15, "ON");
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
}
