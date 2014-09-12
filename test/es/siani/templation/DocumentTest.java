package es.siani.templation;

import org.junit.Test;

public class DocumentTest {
	@Test
	public void doc1() throws Exception {
		Document document = new Document(new Template(new Template.Log(), Template.class.getResourceAsStream("testFile")));
		document.fillMark("mark", "mark");
		String output = document.print();
	}
}
