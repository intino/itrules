package org.siani.itrules.intellij.actions.java;

import org.siani.itrules.LineSeparator;
import org.siani.itrules.Template;

import java.util.Locale;

public class JavaItrulesTemplate extends Template {


	protected JavaItrulesTemplate(Locale locale, LineSeparator separator) {
		super(locale, separator);
	}

	public static Template create(Locale locale, LineSeparator separator) {
		return new JavaItrulesTemplate(locale, separator).define();
	}

	protected Template define() {
		add(
			rule().add(condition("type", "ruleset")).add(expression().add(literal("package ")).add(mark("package")).add(literal(";"))).add(literal("\n" +
				"\n" +
				"import org.siani.itrules.*;\n\n" +
				"import java.util.Locale;\n" +
				"\n" +
				"import static org.siani.itrules.LineSeparator.*;\n" +
				"\n" +
				"public class ")).add(mark("name", "FirstUpperCase")).add(literal("Template extends Template {\n" +
				"\n" +
				"\tprotected ")).add(mark("name", "FirstUpperCase")).add(literal("Template(Locale locale, LineSeparator separator) {\n" +
				"\t\tsuper(locale, separator);\n" +
				"\t}\n" +
				"\n" +
				"\tpublic static Template create() {\n" +
				"\t\treturn new ")).add(mark("name", "FirstUpperCase")).add(literal("Template(")).add(mark("locale")).add(literal(", ")).add(mark("lineSeparator")).add(literal(").define();\n")).add(literal("\t}\n\n" +
				"\tpublic Template define() {\n" +
				"\t\tadd(\n" +
				"\t\t\t")).add(mark("rule").multiple(",\n")).add(literal("\n" +
				"\t\t);\n" +
				"\t\treturn this;\n" +
				"\t}\n" +
				"}")),
			rule().add(condition("type", "rule"), condition("trigger", "rule")).add(literal("rule()")).
				add(expression().add(literal(".add(")).add(mark("conditions").multiple(", ")).add(literal(")"))).add(mark("tokens").multiple("")),
			rule().add(condition("type", "condition"), condition("trigger", "conditions")).add(mark("negated")).add(literal("(condition(")).
				add(mark("name", "string")).add(literal(", ")).add(mark("parameter", "string")).add(literal("))")),
			rule().add(condition("trigger", "negated"), condition("value", "true")).add(literal("not")),
			rule().add(condition("trigger", "negated")),
			rule().add(condition("type", "token"), condition("type", "literal"), condition("trigger", "tokens")).
				add(literal(".add(literal(")).add(mark("text", "string")).add(literal("))")),
			rule().add(condition("type", "token"), condition("type", "mark"), condition("trigger", "tokens")).
				add(literal(".add(mark(")).add(mark("name", "string")).add(expression().add(literal(", ")).add(mark("options", "string").multiple(", "))).add(literal(")")).add(expression().add(literal(".multiple(")).add(mark("separator", "string")).add(literal(")"))).add(literal(")")),
			rule().add(condition("type", "token"), condition("type", "expression"), condition("trigger", "tokens")).add(literal(".add(expression()")).add(mark("tokens").multiple("")).add(expression().add(literal(".or(")).add(mark("or")).add(literal(")"))).add(literal(")")),

			rule().add(condition("type", "token"), condition("type", "expression"), condition("trigger", "or")).add(literal("expression()")).add(mark("tokens").multiple("")).add(expression().add(literal(".or(")).add(mark("or")).add(literal(")"))));
		return this;
	}
}
