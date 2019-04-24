import io.intino.itrules.RuleSet;
import io.intino.itrules.intellij.actions.java.TemplateRulesWriter;
import io.intino.itrules.readers.ItrRuleSetReader;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

public class TemplateGeneration {

	String expected_roster = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class RosterTemplate extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"roster\"))).output(literal(\"<roster>\\n    \")).output(mark(\"Coach\")).output(literal(\"\\n    <players>\\n        \")).output(mark(\"Player\").multiple(\"\\n\")).output(literal(\"\\n    </players>\\n</roster>\")),\n" +
			"\t\t\trule().condition((type(\"person\")), (trigger(\"coach\"))).output(literal(\"<coach name=\\\"\")).output(mark(\"Name\")).output(literal(\"\\\" year=\\\"\")).output(mark(\"Birthday\", \"Year\")).output(literal(\"\\\" country=\\\"\")).output(mark(\"Country\")).output(literal(\"\\\" />\")),\n" +
			"\t\t\trule().condition((type(\"person\")), (trigger(\"player\"))).output(literal(\"<player name=\\\"\")).output(mark(\"Name\")).output(literal(\"\\\" year=\\\"\")).output(mark(\"Birthday\", \"Year\")).output(literal(\"\\\" country=\\\"\")).output(mark(\"Country\")).output(literal(\"\\\"\")).output(expression().output(literal(\" club=\\\"\")).output(mark(\"Club\")).output(literal(\"\\\"\"))).output(literal(\"/>\"))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";

	String expected_layer = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class LayerTemplate extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"nodeimpl\"))).output(literal(\"public\\n    \")).output(expression().output(mark(\"aggregable\")).output(literal(\"\\n\")).output(literal(\"    public Definition\")).output(literal(\"[\")).output(literal(\"]\")).output(literal(\" aggregables() {\")).output(literal(\"\\n\")).output(literal(\"    }\"))),\n" +
			"\t\t\trule().condition(not(type(\"word\")), (trigger(\"node\"))).output(mark(\"name\", \"firstUpperCase\")).output(literal(\"Intention {\\n\")).output(mark(\"name\", \"firstUpperCase\")).output(literal(\"Intention[] extensions() {\"))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";

	String expected_rare_characters = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class RareCharactersTemplate extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"rare\"))).output(literal(\"Ñ ñ í ó\"))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";

	String expected_null_template = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class NullTemplate extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"rare\")))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";


	String expected_native_template = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class NativeTemplate extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"native\"))).output(literal(\"package \")).output(mark(\"projectGenerated\"))." +
			"output(literal(\";\\n\\nimport \")).output(mark(\"project\")).output(literal(\".natives.*;\\nimport \"))." +
			"output(mark(\"project\")).output(literal(\".*;\\nimport java.util.*;\\n\\npublic class \"))." +
			"output(mark(\"qn\")).output(expression().output(literal(\"_\")).output(mark(\"variable\")))." +
			"output(literal(\" \")).output(expression().output(literal(\"extends \")).output(mark(\"parent\")))." +
			"output(literal(\" \")).output(expression().output(literal(\"implements \")).output(mark(\"interface\")))." +
			"output(literal(\" {\\n\\n\\t@Override\\n\\t\")).output(mark(\"signature\")).output(literal(\" {\"))." +
			"output(literal(\"\\n\")).output(literal(\"\\t\")).output(literal(\"\\t\")).output(mark(\"return\"))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";

	String expected_example1_template = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class Example1Template extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"doublerule\")), (trigger(\"rule\"))).output(literal(\"new io.intino.tara.lang.model.rules.variable.DoubleRule(\")).output(mark(\"min\", \"cast\")).output(literal(\", \")).output(mark(\"max\", \"cast\")).output(literal(\", \\\"\")).output(mark(\"metric\")).output(literal(\"\\\")\")),\n" +
			"\t\t\trule().condition((type(\"stringrule\")), (trigger(\"rule\"))).output(literal(\"new io.intino.tara.lang.model.rules.variable.StringRule(\")).output(mark(\"regex\", \"quoted\")).output(literal(\")\")),\n" +
			"\t\t\trule().condition((attribute(\"infinity\")), (trigger(\"cast\"))).output(literal(\"Double.POSITIVE_INFINITY\")),\n" +
			"\t\t\trule().condition((attribute(\"-infinity\")), (trigger(\"cast\"))).output(literal(\"Double.NEGATIVE_INFINITY\")),\n" +
			"\t\t\trule().condition(not(attribute(\"-infinity\")), not(attribute(\"infinity\")), (trigger(\"cast\"))).output(mark(\"value\"))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";

	String expected_example2_template = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class Example2Template extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"function\",\"variable\",\"required\")), not(type(\"empty\")), not(attribute(\"values\")), not(attribute(\"wordvalues\")), (trigger(\"parameters\"))).output(mark(\"workingPackage\", \"LowerCase\")).output(literal(\".functions.\")).output(mark(\"rule\", \"interfaceClass\")).output(literal(\" \")).output(mark(\"name\", \"javaValidName\", \"FirstLowerCase\", \"javaValidWord\")),\n" +
			"\t\t\trule().condition((type(\"variable\",\"required\")), not(anytype(\"multiple\",\"empty\")), not(attribute(\"values\")), not(attribute(\"wordvalues\")), (trigger(\"assign\"))).output(literal(\"newElement.core$().set(newElement, \\\"\")).output(mark(\"name\", \"FirstLowerCase\")).output(literal(\"\\\", java.util.Collections.singletonList(\")).output(mark(\"name\", \"javaValidName\", \"FirstLowerCase\", \"javaValidWord\")).output(literal(\"));\")),\n" +
			"\t\t\trule().condition((type(\"reference\",\"owner\",\"concept\",\"variable\")), not(anytype(\"reactive\",\"inherited\",\"overriden\")), (trigger(\"set\"))).output(literal(\"if (name.equalsIgnoreCase(\\\"\")).output(mark(\"name\", \"FirstLowerCase\")).output(literal(\"\\\")) this.\")).output(mark(\"name\", \"javaValidName\", \"FirstLowerCase\", \"javaValidWord\")).output(literal(\" = (io.intino.tara.magritte.Concept) values.get(0);\"))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";
	String expected_example3_template = "package org.sample;\n" +
			"\n" +
			"import io.intino.itrules.RuleSet;\n" +
			"import io.intino.itrules.Template;\n" +
			"\n" +
			"public class Example3Template extends Template {\n" +
			"\n" +
			"\tpublic RuleSet ruleSet() {\n" +
			"\t\treturn new RuleSet().add(\n" +
			"\t\t\trule().condition((type(\"newfeatures\")), (trigger(\"new\"))).output(mark(\"workingPackage\", \"[f-> f.is(\\\"a\\\")? \\\"aaa\\\":\\\"bbb\\\"]\"))\n" +
			"\t\t);\n" +
			"\t}\n" +
			"}";

	@Test
	public void accept_generate_template_for_roster_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Roster.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_roster, new TemplateRulesWriter("Roster", "org.sample", "English", getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void accept_generate_template_for_layer_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Layer.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_layer, new TemplateRulesWriter("Layer", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void accept_generate_template_for_rare_Characters_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/RareCharacters.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_rare_characters, new TemplateRulesWriter("RareCharacters", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void null_template_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/nullTemplate.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_null_template, new TemplateRulesWriter("Null", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void native_template_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/native.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_native_template, new TemplateRulesWriter("Native", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}


	@Test
	public void itr_example_1() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Example1.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_example1_template, new TemplateRulesWriter("Example1", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void itr_example_2() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Example2.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_example2_template, new TemplateRulesWriter("Example2", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void itr_example_3() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Example3.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_example3_template, new TemplateRulesWriter("Example3", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	private String getLineSeparator(String separator) {
		return separator.contains("\r") ? "CRLF" : "LF";

	}

	private String getLocale(String locale) {
		return locale.equals("English") ? "Locale.ENGLISH" : "new Locale(\"es\", \"Spain\", \"es_ES\")";
	}
}
