package org.siani.itrules;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CustomFormatting {


	@Test
	public void testCustomFormatting() throws Exception {
		Frame frame = new Frame("Person");
		frame.property("Name", "pau gasol");
		frame.property("Birthday", new DateTime("06/07/1980"));
		frame.property("Country", "Spain");
		String rule = "" +
			"defrule type(Person)\n" +
			"$Name+Title nacio el $Birthday+FullDate+Title\n" +
			"endrule";
		Document document = new Document();
		RuleEngine ruleEngine = new RuleEngine(toInputStream(rule));
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
		assertEquals("Pau Gasol nacio el 06 De Julio De 1980", document.content());
	}

	private ByteArrayInputStream toInputStream(String rules) {
		return new ByteArrayInputStream(rules.getBytes());
	}

}
