package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Rule;
import org.siani.itrules.serialization.RulesSaver;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Plural {
	private static final String FILE_JSON = "/json/plural.json";
	private static final File TEST = new File("res_test", FILE_JSON);
	private static final String FILE_ITR = "/plural.itr";

	@Test
	public void testPlural() throws Exception {
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

	private Frame buildFrame() {
		Frame frame = new Frame("Contract");
		frame.addSlot("Owner", new Frame("Person") {{
			addSlot("Name", "persona");
			addSlot("Address", "direccion");
			addSlot("City", "ciudad");
			addSlot("IdCard", "4050321");
		}});
		frame.addSlot("Pet", new Frame("Dog") {{
			addSlot("Chip", "X204512");
			addSlot("Especie", "Caniche");
			addSlot("Age", "2");
		}});
		frame.addSlot("Date", new DateTime("27/09/2014"));
		return frame;
	}

	private static final String EXPECTED = "Las Palmas de Gran de Canaria, el 27/09/2014\n" +
		"\n" +
		"personas, con DNI 4050321, con domicilio en la calle direcciones, ciudades\n" +
		"\n" +
		"declara adoptar a\n" +
		"\n" +
		"El perro con chip X204512, de la especie Caniche, de 2 años\n" +
		"\n" +
		"\n" +
		"\n" +
		"Firmado\n" +
		"personas, con DNI 4050321, con domicilio en la calle direcciones, ciudades";

}
