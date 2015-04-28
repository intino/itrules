import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.intellij.actions.java.TemplateRulesWriter;
import org.siani.itrules.readers.ItrRuleSetReader;

import java.nio.charset.Charset;

public class TemplateGeneration {

	String expected = "package org.sample;\n" +
		"\n" +
		"import org.siani.itrules.*;\n" +
		"\n" +
		"import java.util.Locale;\n" +
		"\n" +
		"import static org.siani.itrules.Encoding.LineSeparator.*;\n" +
		"\n" +
		"public class RosterTemplate extends Template {\n" +
		"\n" +
		"\tpublic static final Template This = new RosterTemplate(Spanish, Encoding.with(\"UTF-8\", LF));\n" +
		"\n" +
		"\tpublic RosterTemplate(Locale locale, Encoding encoding) {\n" +
		"\t\tsuper(locale, encoding);\n" +
		"\t}\n" +
		"\n" +
		"    @Override\n" +
		"    public void definition() {\n" +
		"        add(\n" +
		"            rule().add(condition(\"type\", \"Roster\")).add(literal(\"<roster>\\n    \")).add(mark(\"Coach\")).add(literal(\"\\n    <players>\\n        \")).add(mark(\"Player\").multiple(\"\\n\")).add(literal(\"\\n    </players>\\n</roster>\")),\n" +
		"            rule().add(condition(\"type\", \"Person\"), condition(\"trigger\", \"Coach\")).add(literal(\"<coach name=\\\"\")).add(mark(\"Name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\", \"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\" />\")),\n" +
		"            rule().add(condition(\"type\", \"Person\"), condition(\"trigger\", \"Player\")).add(literal(\"<player name=\\\"\")).add(mark(\"Name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\", \"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\"\")).add(expression().add(literal(\" club=\\\"\")).add(mark(\"Club\")).add(literal(\"\\\"\"))).add(literal(\"/>\"))\n" +
		"        );\n" +
		"    }\n" +
		"}";

	@Test
	public void accept_generate_template_for_roster_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Roster.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected, new TemplateRulesWriter("Roster", "org.sample", "Spanish", "UTF-8").toJava(read));
	}

	@Test
	public void accept_generate_template_for_morph_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/morph.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected, new TemplateRulesWriter("Morph", "org.sample", "Spanish", "UTF-8").toJava(read));
	}
}
