package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomFormatting {

	private static final String FILE_JSON = "/json/customformating.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String RULE = "" +
		"defrule type(Person)\n" +
		"$Name+Title nació el $Birthday+FullDate+Title\n" +
		"endrule";
	private static final String EXPECTED = "Pau Gasol nació el 06 De Julio De 1980";

	@Test
	public void testCustomFormatting() throws Exception {
		RuleReader reader = new TemplateReader(RULE);
		FileWriter writer = new FileWriter(TEST);
		writer.write(RulesSaver.toJSON(reader.read()));
		writer.close();
		Frame frame = buildFrame();
		Document document = new Document();
		Rule[] rules = new JSONRuleReader(getJsonRules()).read();
		assertNotNull(rules);
		RuleEngine ruleEngine = new RuleEngine(rules, Locale.getDefault());
		ruleEngine.register("title", new Formatter() {
			@Override
			public Object format(Object value) {
				String result = "";
				for (String s : value.toString().split(" "))
					result += " " + s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
				return result.substring(1);
			}
		});
		ruleEngine.register("FullDate", new Formatter() {
			@Override
			public Object format(Object value) {
				return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format((Date) value);
			}
		});
		ruleEngine.render(frame, document);
		assertEquals(EXPECTED, document.content());
	}

	public InputStream getJsonRules() {
		try {
			return new FileInputStream(TEST);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Frame buildFrame() {
		Frame frame = new Frame("Person");
		frame.addSlot("Name", "pau gasol");
		frame.addSlot("Birthday", new DateTime("06/07/1980"));
		frame.addSlot("Country", "Spain");
		return frame;
	}

}
