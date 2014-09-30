package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class Formatting {

	@Test
	public void testFormatting() throws Exception {
		Frame frame = new Frame("Person");
		frame.property("Name", "Pau Gasol");
		frame.property("Birthday", new DateTime("06/07/1980"));
		frame.property("Country", "Spain");
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


	public InputStream getRules() {
		return FrameTest.class.getResourceAsStream("/formatting.itr");
	}

}
