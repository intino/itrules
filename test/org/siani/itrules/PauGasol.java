package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PauGasol {

	private static final String EXPECTED = "Pau Gasol was born in Spain on 06/07/1980";
	private static final String FILE_JSON = "/json/paugasol.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String RULE = "" +
		"defrule type(Person)\n" +
		"$Name was born in $Country on $Birthday\n" +
		"endrule";

	@Test
	public void testPauGasol() throws Exception {
		RuleReader reader = new TemplateReader(RULE);
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
		Frame frame = new Frame("Person");
		frame.addSlot("Name", "Pau Gasol");
		frame.addSlot("Birthday", "06/07/1980");
		frame.addSlot("Country", "Spain");
		return frame;
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
