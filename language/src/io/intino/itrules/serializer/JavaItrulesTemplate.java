/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.serializer;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;
import io.intino.itrules.template.outputs.Expression;

import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class JavaItrulesTemplate extends Template {

	public JavaItrulesTemplate(Configuration configuration) {
		super(configuration);
	}

	public List<Rule> ruleSet() {
		return List.of(rule().condition(type("template")).output(expression().output(
								literal("package "), placeholder("package"), literal(";\n")), literal("""

								import io.intino.itrules.template.Rule;
								import io.intino.itrules.template.Template;

								import java.util.ArrayList;
								import java.util.List;

								import static io.intino.itrules.template.condition.predicates.Predicates.*;
								import static io.intino.itrules.template.outputs.Outputs.*;

								public class\s"""), placeholder("name", "FirstUpperCase"), literal("Template extends Template {\n\n"),

						literal("\tpublic List<Rule> ruleSet() {\n" +
								"\t\tList<Rule> rules = new ArrayList<>();\n\t\t"),
						placeholder("rule").multiple("\n"),
						literal("""
								\n\t\treturn rules;
								\t}
								\n\tpublic String render(Object object) {
								\t\treturn new io.intino.itrules.Engine(this).render(object);
								\t}
								\n\tpublic String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
								\t\treturn new io.intino.itrules.Engine(this).addAll(formatters).render(object);
								\t}
								}""")),
				rule().condition(trigger("rule")).output(literal("rules.add(rule()"),expression().output(literal(".condition("), placeholder("condition"), literal(")")), placeholder("outputs").multiple("")).output(literal(");")),
				rule().condition(all(type("output"), type("literal"), trigger("outputs"))).
						output(literal(".output(literal(")).output(placeholder("value", "string")).output(literal("))")),
				rule().condition(all(type("output"), type("placeholder"), trigger("outputs"))).
						output(literal(".output(placeholder(")).output(placeholder("name", "string")).output(templatePath()).output(formatters()).output(literal(")")).output(expression().output(literal(".multiple(")).output(placeholder("separator", "string")).output(literal(")"))).output(literal(")")),
				rule().condition(all(type("output"), type("expression"), trigger("outputs")))
						.output(literal(".output(expression()"))
						.output(placeholder("outputs").multiple(""))
						.output(expression().output(literal(".next(")).output(placeholder("next")).output(literal(")")))
						.output(literal(")")),
				rule().condition(all(type("output"), type("expression"), trigger("next")))
						.output(literal("expression()"))
						.output(placeholder("outputs").multiple(""))
						.output(expression().output(literal(".next(")).output(placeholder("next")).output(literal(")")))
		);
	}

	private Expression templatePath() {
		return expression().output(literal(", ")).output(placeholder("templatePath", "string").multiple(", "));
	}

	private static Expression formatters() {
		return expression().output(literal(", ")).output(placeholder("formatters", "string").multiple(", "));
	}
}