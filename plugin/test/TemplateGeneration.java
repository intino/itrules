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
		"public class Roster extends Template {\n" +
		"\n" +
		"    @Override\n" +
		"    public void definition() {\n" +
		"        add(rule().add(condition(\"type\", \"Roster\")).add(literal(\"<roster>\\n    \")).add(mark(\"Coach\")).add(literal(\"\\n    <players>\\n        \")).add(mark(\"Player\").multiple(\"\\n\")).add(literal(\"\\n    </players>\\n</roster>\")));\n" +
		"        add(rule().add(condition(\"type\", \"Person\")).add(condition(\"trigger\", \"Coach\")).add(literal(\"<coach name=\\\"\")).add(mark(\"Name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\", \"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\" />\")));\n" +
		"        add(rule().add(condition(\"type\", \"Person\")).add(condition(\"trigger\", \"Player\")).add(literal(\"<player name=\\\"\")).add(mark(\"Name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\", \"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\"\")).add(expression().add(literal(\" club=\\\"\")).add(mark(\"Club\")).add(literal(\"\\\"\"))).add(literal(\"/>\")));\n" +
		"    }\n" +
		"}";

	@Test
	public void accept_generate_template_for_roster_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Roster.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected, new TemplateRulesWriter("Roster", "org.sample").toJava(read));
	}
}
