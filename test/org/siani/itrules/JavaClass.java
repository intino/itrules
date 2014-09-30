package org.siani.itrules;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class JavaClass {

	@Test
	public void testJavaClass() throws Exception {
		Frame frame = new Frame("Class");
		frame.property("name", "Customer");
		frame.property("final", "final");
		frame.property("superclass", "Client");
		frame.property("interface", "Company");
		frame.property("interface", "TaxPayer");
		frame.property("attribute", new Frame("Attribute", "Const") {{
			property("name", "CUSTOMER_NAME");
			property("type", "String");
			property("default", "\"CUSTOMER\"");
		}});
		frame.property("attribute", new Frame("Attribute", "ReadOnly") {{
			property("name", "familyName");
			property("type", "String");
		}});
		frame.property("attribute", new Frame("Attribute") {{
			property("name", "maxAge");
			property("type", "Integer");
			property("default", "100");
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
			"\tpublic Customer(String familyName) {\n" +
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
			"\n" +
			"}", document.content());
	}

	public InputStream getClassRules() {
		return Eval.class.getResourceAsStream("/java_class.itr");
	}
}
