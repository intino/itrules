package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.lang.RulesReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ModelCreationTest {

	@Test
	public void createSmallModel() throws Exception {
		RulesReader ruleSet = new RulesReader(stream);
	}

	String fullTemplateSource =
		"rule type(Class)\n" +
			"public class [$static ][$final ]$Name [extends $SuperClass][implements $Interface...[, ]]{\n" +
			"\t$attribute+const...[$NL]\n" +
			"\t$attribute+Field...[$NL]\n" +
			"\n" +
			"\t$attribute+Getter...[$NL]\n" +
			"\n" +
			"\tpublic $Name($attribute+Injection...[,]) {\n" +
			"\t\t$attribute:Initialize...[$NL]\n" +
			"\t}\n" +
			"}\n" +
			"^\n" +
			"\n" +
			"rule type(Attribute) for(attribute+const) with(const)\n" +
			"public static final $type $name+UC = $default;\n" +
			"^\n" +
			"\n" +
			"rule type(Attribute) for(attribute+field) with(!const,readonly)\n" +
			"private final $type $name[ = $default];\n" +
			"^\n" +
			"\n" +
			"rule Attribute +Field !$const !$readOnly\n" +
			"private $type $name[ = $default];\n" +
			"^\n" +
			"\n" +
			"rule Attribute +Getter !$const\n" +
			"public $type get$Name() {\n" +
			"\treturn $name;\n" +
			"}\n" +
			"^\n" +
			"\n" +
			"rule Attribute +Setter !$const\n" +
			"public void set$Name($type value) {\n" +
			"\t$name = value;\n" +
			"}\n" +
			"^\n" +
			"\n" +
			"rule Attribute +Injection $readOnly\n" +
			"$type $name\n" +
			"^\n" +
			"\n" +
			"rule Attribute +Initialize $readOnly\n" +
			"this.$name = $name;\n" +
			"^";

	String templateSource = ":rule Class\n" +
		"public class [$static ][$final ]$Name [extends $SuperClass][implements $Interface...[, ]]{\n" +
		"\t$attribute+Const...[$NL]\n" +
		"\t$attribute+Field...[$NL]\n" +
		"\n" +
		"\t$attribute+Getter...[$NL]\n" + ":end";

	InputStream stream = new ByteArrayInputStream(templateSource.getBytes(StandardCharsets.UTF_8));
	InputStream streamOfFull = new ByteArrayInputStream(fullTemplateSource.getBytes(StandardCharsets.UTF_8));
}
