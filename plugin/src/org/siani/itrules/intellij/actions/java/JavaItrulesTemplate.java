package org.siani.itrules.intellij.actions.java;

import org.siani.itrules.Encoding;
import org.siani.itrules.Template;

import java.util.Locale;

public class JavaItrulesTemplate extends Template {


	public JavaItrulesTemplate() {
		super(Locale.getDefault(), Encoding.getDefault());
	}

	public JavaItrulesTemplate(Locale locale, Encoding encoding) {
		super(locale, encoding);
	}

	@Override
	protected void definition() {
		add(
			rule().add(condition("type", "ruleset")).add(expression().add(literal("package ")).add(mark("package")).add(literal(";"))).add(literal("\n" +
				"\n" +
				"import org.siani.itrules.*;\n" +
				"import java.util.Locale;\n" +
				"\n" +
				"import static org.siani.itrules.Encoding.LineSeparator.*;\n" +
				"\n" +
				"public class ")).add(mark("name", "FirstUpperCase")).add(literal("Template extends Template {\n" +
				"\n" +
				"public ")).add(mark("name", "FirstUpperCase")).add(literal("Template(Locale locale, Encoding encoding) {\n" +
				"\t\tsuper(locale, encoding);\n" +
				"\t}\n" +
				"\n" +
				"\tpublic static String format(Object object) {\n" +
				"\t\treturn engine().render(object);\n" +
				"\t}\n" +
				"\n" +
				"\tprivate static TemplateEngine engine() {\n" +
				"\t\treturn new TemplateEngine(")).add(mark("locale")).add(literal(", Encoding.with(\"")).add(mark("encoding")).add(literal("\", LF));\n" +
				"\t}" +
				"    @Override\n" +
				"    public void definition() {\n" +
				"        add(\n" +
				"        ")).add(mark("rule").multiple(",\n")).add(literal("\n" +
				"        );\n" +
				"    }\n" +
				"}")),
			rule().add(condition("type", "rule"), condition("trigger", "rule")).add(literal("rule()")).
				add(expression().add(literal(".add(")).add(mark("conditions").multiple(", ")).add(literal(")"))).add(mark("tokens").multiple("")),
			rule().add(condition("type", "condition"), condition("trigger", "conditions")).add(literal("condition(")).
				add(mark("name", "string")).add(literal(", ")).add(mark("parameter", "string")).add(literal(")")),
			rule().add(condition("type", "token"), condition("type", "literal"), condition("trigger", "tokens")).
				add(literal(".add(literal(")).add(mark("literal", "string")).add(literal("))")),
			rule().add(condition("type", "token"), condition("type", "mark"), condition("trigger", "tokens")).
				add(literal(".add(mark(")).add(mark("name", "string")).add(expression().add(literal(", ")).add(mark("options", "string").multiple(", "))).add(literal(")")).add(expression().add(literal(".multiple(")).add(mark("separator", "string")).add(literal(")"))).add(literal(")")),
			rule().add(condition("type", "token"), condition("type", "expression"), condition("trigger", "tokens")).add(literal(".add(expression()")).add(mark("tokens").multiple("")).add(literal(")"))
		);
	}
}
