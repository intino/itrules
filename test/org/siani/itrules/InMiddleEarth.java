package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InMiddleEarth {

	@Test
	public void testInMiddleEarth() throws Exception {
		Frame frame = new Frame("Message");
		frame.property("From", "frodo@hobbiton.me");
		frame.property("To", "gandalf@elrond.me");
		frame.property("To", "bilbo@hobbiton.me");
		frame.property("Subject", "The ring");
		frame.property("Text", "I wish the Ring had never come to me.");
		frame.property("Text", "I wish none of this had happened.");
		Document document = new Document();
		new RuleEngine(getRules()).render(frame, document);
		assertEquals("" +
			"From: frodo@hobbiton.me\n" +
			"To: gandalf@elrond.me, bilbo@hobbiton.me\n" +
			"The ring\n" +
			"\n" +
			"I wish the Ring had never come to me.\n" +
			"I wish none of this had happened.", document.content());
	}

	public InputStream getRules() {
		return FrameTest.class.getResourceAsStream("/in_middle_earth.itr");
	}

}
