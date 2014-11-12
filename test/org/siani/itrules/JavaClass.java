package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class JavaClass {

	@Test
	public void testJavaClass() throws Exception {
		Frame frame = new Frame("Class");
		frame.addSlot("name", "Customer");
		frame.addSlot("final", "final");
		frame.addSlot("superclass", "Client");
		frame.addSlot("interface", "Company");
		frame.addSlot("interface", "TaxPayer");
		frame.addSlot("attribute", new Frame("Attribute", "Const") {{
			addSlot("name", "CUSTOMER_NAME");
			addSlot("type", "String");
			addSlot("default", "\"CUSTOMER\"");
		}});
		frame.addSlot("attribute", new Frame("Attribute", "ReadOnly") {{
			addSlot("name", "familyName");
			addSlot("type", "String");
		}});
		frame.addSlot("attribute", new Frame("Attribute") {{
			addSlot("name", "maxAge");
			addSlot("type", "Integer");
			addSlot("default", "100");
		}});
		Document document = new Document();
		RuleEngine ruleEngine = new RuleEngine(getClassRules());
		ruleEngine.render(frame, document);
		assertEquals("public class final Customer extends Client implements Company, TaxPayer {\n" +
			"\n" +
			"\tpublic static final String CUSTOMER_NAME = \"CUSTOMER\";\n" +
			"\tprivate final String familyName;\n" +
			"\tprivate Integer maxAge = 100;\n" +
			"\n" +
			"\tpublic Customer(String familyName) {\n\n" +
			"\t\tthis.familyName = familyName;\n" +
			"\t}\n" +
			"\n" +
			"\tpublic String getFamilyName() {\n" +
			"\t\treturn familyName;\n" +
			"\t}\n" +
			"\n" +
			"\tpublic Integer getMaxAge() {\n" +
			"\t\treturn maxAge;\n" +
			"\t}\n" +
			"\n" +
			"\tpublic void setMaxAge(Integer value) {\n" +
			"\t\tmaxAge = value;\n" +
			"\t}\n" +
			"}", document.content());
	}

	public InputStream getClassRules() {
		return Eval.class.getResourceAsStream("/java_class.itr");
	}
}
