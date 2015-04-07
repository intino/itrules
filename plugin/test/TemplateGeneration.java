import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.intellij.actions.java.TemplateRulesWriter;
import org.siani.itrules.reader.itr.RuleSetReader;

public class TemplateGeneration {


	String expected = "package org.siani.itrules.templates;\n" +
		"\n" +
		"import org.siani.itrules.*;\n" +
		"\n" +
		"\n" +
		"public class RosterTemplate extends Template {\n" +
		"\n" +
		"    @Override\n" +
		"    public void definition() {\n" +
		"        add(rule().add(condition(\"type\", \"Roster\")).add(literal(\"<roster>\\n\\t\")).add(mark(\"Coach\")).add(literal(\"\\n\\t<players>\\n\\t\\t\")).add(mark(\"Player\", \"\").multiple(\"\\n\")).add(literal(\"\\n\\t</players>\\n</roster>\"))).\n" +
		"        add(rule().add(condition(\"type\",\"Person\")).add(condition(\"trigger\",\"Coach\")).add(literal(\"<coach name=\\\"\")).add(mark(\"name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\",\"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\" />\"))).\n" +
		"        add(rule().add(condition(\"type\", \"Person\")).add(condition(\"trigger\", \"Player\")).add(literal(\"<player name=\\\"\")).add(mark(\"name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\", \"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\"\")).add(expression(literal(\" club=\\\"\"), mark(\"Club\"), literal(\"\\\"\"))).add(literal(\"/>\")));\n" +
		"    }\n" +
		"}";

	@Test
	public void accept_generate_template_for_roster_itr() throws Exception {
		RuleSetReader reader = new RuleSetReader(TemplateGeneration.class.getResourceAsStream("/templates/template.java.itr"));
		Assert.assertEquals(expected, new TemplateRulesWriter("Roster", "org.sample").toJava(reader.read()));
	}
}
