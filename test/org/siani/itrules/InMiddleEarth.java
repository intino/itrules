package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InMiddleEarth {

	private static final String FILE_JSON = "/json/inmiddleearth.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/in_middle_earth.itr";

	@Test
	public void testInMiddleEarth() throws Exception {
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
		Frame frame = new Frame("Message");
		frame.addSlot("From", "frodo@hobbiton.me");
		frame.addSlot("To", "gandalf@elrond.me");
		frame.addSlot("To", "bilbo@hobbiton.me");
		frame.addSlot("Subject", "The ring");
		frame.addSlot("Text", "I wish the Ring had never come to me.");
		frame.addSlot("Text", "I wish none of this had happened.");
		return frame;
	}

	private static final String EXPECTED = "" +
		"From: frodo@hobbiton.me\n" +
		"To: gandalf@elrond.me, bilbo@hobbiton.me\n" +
		"The ring\n" +
		"\n" +
		"I wish the Ring had never come to me.\n" +
		"I wish none of this had happened.";

	public InputStream getRules() {
		return this.getClass().getResourceAsStream("/in_middle_earth.itr");
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
