package io.intino.itrules.intellij.actions.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;
import io.intino.itrules.TemplateEngine;

public class JavaItrulesTemplate extends Template {

	public JavaItrulesTemplate(TemplateEngine.Configuration configuration) {
		super(configuration);
	}

	protected RuleSet ruleSet() {
		return new RuleSet().add(
				rule().condition(type("ruleset")).output(expression().output(
						literal("package "), mark("package"), literal(";")), literal("\n" +
						"\n" +
						"import io.intino.itrules.RuleSet;\n" +
						"import io.intino.itrules.Template;\n" +
						"\n" +
						"public class "), mark("name", "FirstUpperCase"), literal("Template extends Template {\n\n"),
						expression(literal("\tprotected void init(io.intino.itrules.TemplateEngine engine) {\n" +
						"\t\t"), mark("formatter").multiple("\n"), literal("\n" +
						"\t}")),
						literal("\n\n" +
						"\tpublic RuleSet ruleSet() {\n" +
						"\t\treturn new RuleSet().add(\n" +
						"\t\t\t"), mark("rule").multiple(",\n"), literal("\n" +
						"\t\t);\n" +
						"\t}\n" +
						"}")),
				rule().condition(trigger("rule")).output(literal("rule()"),
						expression().output(literal(".condition("), mark("conditions").multiple(", "), literal(")")), mark("outputs").multiple("")),
				rule().condition(trigger("conditions")).output(mark("negated")).output(literal("(")).output(mark("any")).output(mark("name")).output(literal("("))
						.output(mark("parameter"), literal("))")),
				rule().condition(type("type"), trigger("parameter")).output(mark("value", "string").multiple(",")),
				rule().condition(type("trigger"), trigger("parameter")).output(mark("value", "string")),
				rule().condition(type("attribute"), trigger("parameter")).output(mark("attribute", "string"), expression().output(literal(", "), mark("value", "string"))),
				rule().condition(trigger("formatter")).output(literal("add("), mark("name", "string"), literal(", "), mark("value"), literal(");")),

				rule().condition(type("output"), type("literal"), trigger("outputs")).
						output(literal(".output(literal(")).output(mark("value", "string")).output(literal("))")),
				rule().condition(type("output"), type("mark"), trigger("outputs")).
						output(literal(".output(mark(")).output(mark("name", "string")).output(expression().output(literal(", ")).output(mark("formatters", "string").multiple(", "))).output(literal(")")).output(expression().output(literal(".multiple(")).output(mark("separator", "string")).output(literal(")"))).output(literal(")")),
				rule().condition(type("output"), type("expression"), trigger("outputs")).output(literal(".output(expression()")).output(mark("outputs").multiple("")).output(expression().output(literal(".or(")).output(mark("or")).output(literal(")"))).output(literal(")")),
				rule().condition(type("output"), type("expression"), trigger("or")).output(literal("expression()")).output(mark("outputs").multiple("")).output(expression().output(literal(".or(")).output(mark("or")).output(literal(")"))));
	}
}
