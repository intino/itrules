package org.siani.itrules;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class PauGasol {

	@Test
	public void testPauGasol() throws Exception {
		Frame frame = new Frame("Person");
		frame.property("Name", "Pau Gasol");
		frame.property("Birthday", "06/07/1980");
		frame.property("Country", "Spain");
		String rule = "" +
			"defrule type(Person)\n" +
			"$Name was born in $Country on $Birthday\n" +
			"endrule";
		Document document = new Document();
		new RuleEngine(toInputStream(rule)).render(frame, document);
		assertEquals("Pau Gasol was born in Spain on 06/07/1980", document.content());
	}

	private ByteArrayInputStream toInputStream(String rules) {
		return new ByteArrayInputStream(rules.getBytes());
	}
}
