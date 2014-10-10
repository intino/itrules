package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class Eval {

	@Test
	public void testEval() throws Exception {
		Frame frame = new Frame("Contract");
		frame.property("Owner", new Frame("Person") {{
			property("Name", "Tere Galvez");
			property("Address", "Pico Viento 51");
			property("City", "Las Palmas");
			property("IdCard", "4050321");
		}});
		frame.property("Pet", new Frame("Dog") {{
			property("Chip", "X204512");
			property("Especie", "Caniche");
			property("Age", "2");
		}});
		frame.property("Date", new DateTime("27/09/2014"));
		Document document = new Document();
		RuleEngine ruleEngine = new RuleEngine(getRules());
		ruleEngine.render(frame, document);
		assertEquals("Las Palmas de Gran de Canaria, el 27/09/2014\n" +
			"\n" +
			"Tere Galvez, con DNI 4050321, con domicilio en la calle Pico Viento 51, Las Palmas\n" +
			"\n" +
			"declara adoptar a\n" +
			"\n" +
			"El perro con chip X204512, de la especie Caniche, de 2 años\n" +
			"\n" +
			"\n" +
			"\n" +
			"\n" +
			"Firmado\n" +
			"Tere Galvez, con DNI 4050321, con domicilio en la calle Pico Viento 51, Las Palmas", document.content());
	}

	public InputStream getRules() {
		return Eval.class.getResourceAsStream("/eval.itr");
	}


}
