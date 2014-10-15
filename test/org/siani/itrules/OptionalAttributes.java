package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class OptionalAttributes {

	@Test
	public void testOptionalAttributes() throws Exception {
		Frame frame = new Frame("Roster");
		frame.addSlot("Coach", new Frame("Person") {{
			addSlot("Name", "Juan Antonio Orenga");
			addSlot("Birthday", new DateTime("29/07/1966"));
			addSlot("Country", "Spain");
		}});
		frame.addSlot("Player", new Frame("Person") {{
			addSlot("Name", "Pau Gasol");
			addSlot("Birthday", new DateTime("06/07/1980"));
			addSlot("Country", "Spain");
			addSlot("Club", "L.A. Lakers");
		}});
		frame.addSlot("Player", new Frame("Person") {{
			addSlot("Name", "Rudy Fernandez");
			addSlot("Birthday", new DateTime("04/04/1985"));
			addSlot("Country", "Spain");
		}});
		frame.addSlot("Player", new Frame("Person") {{
			addSlot("Name", "Juan Carlos Navarro");
			addSlot("Birthday", new DateTime("17/06/1980"));
			addSlot("Country", "Spain");
		}});
		Document document = new Document();
		new RuleEngine(getRules()).render(frame, document);
		assertEquals("<roster>\n" +
			"  <coach name=\"Juan Antonio Orenga\" year=\"1966\" country=\"Spain\" />\n" +
			"  <players>\n" +
			"    <player name=\"Pau Gasol\" year=\"1980\" country=\"Spain\" club=\"L.A. Lakers\" />\n" +
			"    <player name=\"Rudy Fernandez\" year=\"1985\" country=\"Spain\" />\n" +
			"    <player name=\"Juan Carlos Navarro\" year=\"1980\" country=\"Spain\" />\n" +
			"  </players>\n" +
			"</roster>", document.content());
	}

	public InputStream getRules() {
		return Eval.class.getResourceAsStream("/optional_attributes.itr");
	}

}
