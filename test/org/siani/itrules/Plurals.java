package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class Plurals {

	@Test
	public void testPlural() throws Exception {
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
		Document document = new Document();
		RuleEngine ruleEngine = new RuleEngine(getRules(), new Locale("Spanish", "spain", "es_ES"));
		ruleEngine.render(frame, document);
		assertEquals("Las Palmas de Gran de Canaria, el 27/09/2014\n" +
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
			"personas, con DNI 4050321, con domicilio en la calle direcciones, ciudades", document.content());
	}

	public InputStream getRules() {
		return Plurals.class.getResourceAsStream("/plural.itr");
	}


}
