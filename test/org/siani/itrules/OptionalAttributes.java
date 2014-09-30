package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class OptionalAttributes {

	@Test
	public void testOptionalAttributes() throws Exception {
		Frame frame = new Frame("Roster");
		frame.property("Coach", new Frame("Person") {{
			property("Name", "Juan Antonio Orenga");
			property("Birthday", new DateTime("29/07/1966"));
			property("Country", "Spain");
		}});
		frame.property("Player", new Frame("Person") {{
			property("Name", "Pau Gasol");
			property("Birthday", new DateTime("06/07/1980"));
			property("Country", "Spain");
			property("Club", "L.A. Lakers");
		}});
		frame.property("Player", new Frame("Person") {{
			property("Name", "Rudy Fernandez");
			property("Birthday", new DateTime("04/04/1985"));
			property("Country", "Spain");
		}});
		frame.property("Player", new Frame("Person") {{
			property("Name", "Juan Carlos Navarro");
			property("Birthday", new DateTime("17/06/1980"));
			property("Country", "Spain");
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
		return FrameTest.class.getResourceAsStream("/optional_attributes.itr");
	}

}
