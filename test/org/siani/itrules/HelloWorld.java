package org.siani.itrules;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class HelloWorld {

	@Test
	public void testHelloWorld() throws Exception {
		Document document = new Document();
		PrimitiveFrame frame = new PrimitiveFrame("Hello world");
		new RuleEngine(toInputStream("")).render(frame, document);
		assertEquals("Hello world", document.content());
	}

	private ByteArrayInputStream toInputStream(String rules) {
		return new ByteArrayInputStream(rules.getBytes());
	}
}
