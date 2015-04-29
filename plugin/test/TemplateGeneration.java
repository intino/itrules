import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.intellij.actions.java.TemplateRulesWriter;
import org.siani.itrules.readers.ItrRuleSetReader;

import java.nio.charset.Charset;

public class TemplateGeneration {

	String expected_roster = "package org.sample;\n" +
		"\n" +
		"import org.siani.itrules.*;\n" +
		"\n" +
		"import java.util.Locale;\n" +
		"\n" +
		"import static org.siani.itrules.LineSeparator.*;\n" +
		"\n" +
		"public class RosterTemplate extends Template {\n" +
		"\n" +
		"\tprotected RosterTemplate(Locale locale, LineSeparator separator) {\n" +
		"\t\tsuper(locale, separator);\n" +
		"\t}\n" +
		"\n" +
		"\tpublic static Template create() {\n" +
		"\t\treturn new RosterTemplate(English, LF).define();\n" +
		"\t}\n" +
		"\n" +
		"\tpublic Template define() {\n" +
		"\t\tadd(\n" +
		"\t\t\trule().add(condition(\"type\", \"Roster\")).add(literal(\"<roster>\\n    \")).add(mark(\"Coach\")).add(literal(\"\\n    <players>\\n        \")).add(mark(\"Player\").multiple(\"\\n\")).add(literal(\"\\n    </players>\\n</roster>\")),\n" +
		"\t\t\trule().add(condition(\"type\", \"Person\"), condition(\"trigger\", \"Coach\")).add(literal(\"<coach name=\\\"\")).add(mark(\"Name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\", \"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\" />\")),\n" +
		"\t\t\trule().add(condition(\"type\", \"Person\"), condition(\"trigger\", \"Player\")).add(literal(\"<player name=\\\"\")).add(mark(\"Name\")).add(literal(\"\\\" year=\\\"\")).add(mark(\"Birthday\", \"Year\")).add(literal(\"\\\" country=\\\"\")).add(mark(\"Country\")).add(literal(\"\\\"\")).add(expression().add(literal(\" club=\\\"\")).add(mark(\"Club\")).add(literal(\"\\\"\"))).add(literal(\"/>\"))\n" +
		"\t\t);\n" +
		"\t\treturn this;\n" +
		"\t}\n" +
		"}";

	String expected_morph = "package org.sample;\n" +
		"\n" +
		"import org.siani.itrules.*;\n" +
		"\n" +
		"import java.util.Locale;\n" +
		"\n" +
		"import static org.siani.itrules.LineSeparator.*;\n" +
		"\n" +
		"public class MorphTemplate extends Template {\n" +
		"\n" +
		"\tprotected MorphTemplate(Locale locale, LineSeparator separator) {\n" +
		"\t\tsuper(locale, separator);\n" +
		"\t}\n" +
		"\n" +
		"\tpublic static Template create() {\n" +
		"\t\treturn new MorphTemplate(new Locale(\"Spanish\", \"Spain\", \"es_ES\"), LF).define();\n" +
		"\t}\n" +
		"\n" +
		"\tpublic Template define() {\n" +
		"\t\tadd(\n" +
		"\t\t\trule().add(condition(\"type\", \"nodeimpl\")).add(literal(\"public\\n    \")).add(expression().add(mark(\"aggregable\")).add(literal(\"\\n\")).add(literal(\"    public Definition\")).add(literal(\"[\")).add(literal(\"]\")).add(literal(\" aggregables() {\")).add(literal(\"\\n\")).add(literal(\"    }\")))\n" +
		"\t\t);\n" +
		"\t\treturn this;\n" +
		"\t}\n" +
		"}";

	String expected_rare_charachters = "package org.sample;\n" +
		"\n" +
		"import org.siani.itrules.*;\n" +
		"\n" +
		"import java.util.Locale;\n" +
		"\n" +
		"import static org.siani.itrules.LineSeparator.*;\n" +
		"\n" +
		"public class RareCharactersTemplate extends Template {\n" +
		"\n" +
		"\tprotected RareCharactersTemplate(Locale locale, LineSeparator separator) {\n" +
		"\t\tsuper(locale, separator);\n" +
		"\t}\n" +
		"\n" +
		"\tpublic static Template create() {\n" +
		"\t\treturn new RareCharactersTemplate(new Locale(\"Spanish\", \"Spain\", \"es_ES\"), LF).define();\n" +
		"\t}\n" +
		"\n" +
		"\tpublic Template define() {\n" +
		"\t\tadd(\n" +
		"\t\t\trule().add(condition(\"type\", \"rare\")).add(literal(\"Ñ ñ í ó\"))\n" +
		"\t\t);\n" +
		"\t\treturn this;\n" +
		"\t}\n" +
		"}";

	@Test
	public void accept_generate_template_for_roster_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/Roster.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_roster, new TemplateRulesWriter("Roster", "org.sample", "English", getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void accept_generate_template_for_morph_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/morph.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_morph, new TemplateRulesWriter("Morph", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	@Test
	public void accept_generate_template_for_rare_Characters_itr() throws Exception {
		ItrRuleSetReader reader = new ItrRuleSetReader(TemplateGeneration.class.getResourceAsStream("/RareCharacters.itr"));
		RuleSet read = reader.read(Charset.forName("UTF-8"));
		Assert.assertEquals(expected_rare_charachters, new TemplateRulesWriter("RareCharacters", "org.sample", getLocale("Español"), getLineSeparator("\n")).toJava(read));
	}

	private String getLineSeparator(String separator) {
		return separator.contains("\r") ? "CRLF" : "LF";

	}

	private String getLocale(String locale) {
		return locale.equals("English") ? "Locale.ENGLISH" : "new Locale(\"Spanish\", \"Spain\", \"es_ES\")";
	}
}
