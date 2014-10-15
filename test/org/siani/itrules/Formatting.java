package org.siani.itrules;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class Formatting {

	@Test
	public void testFormatting() throws Exception {
		Frame frame = new Frame("Person");
		frame.addSlot("Name", "Pau Gasol");
		frame.addSlot("Birthday", new DateTime("06/07/1980"));
		frame.addSlot("Country", "Spain");
		Document document = new Document();
		new RuleEngine(getRules()).render(frame, document);
		assertEquals("" +
			"Default: Pau Gasol\n" +
			"UpperCase: PAU GASOL\n" +
			"LowerCase: pau gasol\n" +
			"CamelCase: PauGasol\n" +
			"LowerCamelCase: pauGasol\n" +
			"\n" +
			"Default: Sun Jul 06 00:00:00 WEST 1980\n" +
			"Year: 1980\n" +
			"MonthYear: July 1980\n" +
			"ShortDate: 06/07/1980\n" +
			"FullDate: 06 July 1980\n" +
			"DayOfWeek: Sunday\n" +
			"Time: 00:00", document.content());
	}


	@Test
	public void testFormatting2() throws Exception {
		Frame frame = new Frame("Person");
		frame.addSlot("Name", "Pau Gasol");
		frame.addSlot("Height", 213);
		frame.addSlot("Salary", 19201402);
		frame.addSlot("Club", "Barcelona", "Lakers");
		Document document = new Document();
		new RuleEngine(toInputStream("defrule type(Person)\n$Name is $Height+Letters+Title cm tall, earns $$$Salary+Separators and has" +
			" played in $Club+Count basket clubs\nendrule")).render(frame, document);
		assertEquals("Pau Gasol is two hundred and thirteen cm tall, earns $19,201,402 and has played in BarcelonaLakers basket clubs", document.content());
	}

	private ByteArrayInputStream toInputStream(String rules) {
		return new ByteArrayInputStream(rules.getBytes());
	}

	public InputStream getRules() {
		return Eval.class.getResourceAsStream("/formatting.itr");
	}

}
