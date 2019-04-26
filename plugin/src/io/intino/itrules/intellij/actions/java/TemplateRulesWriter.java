/*
 * Copyright 2014
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.intellij.actions.java;

import io.intino.itrules.*;
import io.intino.itrules.Rule.Condition;
import io.intino.itrules.TemplateEngine.Configuration;
import io.intino.itrules.parser.ParsedTemplate;
import io.intino.itrules.rules.conditions.AttributeCondition;
import io.intino.itrules.rules.conditions.NegatedCondition;
import io.intino.itrules.rules.conditions.TriggerCondition;
import io.intino.itrules.rules.conditions.TypeCondition;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator;
import static io.intino.itrules.rules.conditions.TypeCondition.Operator.Any;

public class TemplateRulesWriter {

	private final String name;
	private final String aPackage;
	private final String locale;
	private final String lineSeparator;
	private ParsedTemplate template;

	public TemplateRulesWriter(String name, String aPackage, String locale, String lineSeparator) {
		this.name = name;
		this.aPackage = aPackage;
		this.locale = locale;
		this.lineSeparator = lineSeparator;
	}

	@NotNull
	public String toJava(final ParsedTemplate template) {
		this.template = template;
		return new JavaItrulesTemplate(new Configuration(Locale.getDefault(), lineSeparator.equals("LF") ? LineSeparator.LF : LineSeparator.CRLF))
				.add("string", buildStringFormatter())
				.add(RuleSet.class, ruleSetAdapter())
				.add(Condition.class, conditionAdapter()).render(template.ruleset());
	}

	@NotNull
	private Adapter<RuleSet> ruleSetAdapter() {
		return (source, context) -> {
			context.add("name", name);
			context.add("locale", locale);
			context.add("lineSeparator", lineSeparator);
			if (!aPackage.isEmpty()) context.add("package", aPackage);
			source.forEach(r -> context.add("rule", r));
			template.formatters().forEach((key, value) -> context.add("formatter", new FrameBuilder("formatter").add("name", key).add("value", value).toFrame()));
		};
	}

	private Adapter<Condition> conditionAdapter() {
		return (condition, context) -> {
			String name = condition.getClass().getSimpleName();
			if (condition instanceof NegatedCondition) {
				name = ((NegatedCondition) condition).condition().getClass().getSimpleName();
				context.add("negated", "not");
			}
			name = name.replace("Condition", "").toLowerCase();
			context.add("parameter", parameter(condition));
			context.add("name", name);
			addOperator(condition, context);
		};
	}

	private void addOperator(Condition condition, FrameBuilder.Context context) {
		if ((condition instanceof NegatedCondition)) condition = ((NegatedCondition) condition).condition();
		if (condition instanceof TypeCondition && ((TypeCondition) condition).operator().equals(Any))
			context.add("any", "any");
	}

	private Frame parameter(Condition condition) {
		if ((condition instanceof NegatedCondition)) condition = ((NegatedCondition) condition).condition();
		if (condition instanceof AttributeCondition) {
			Object value = ((AttributeCondition) condition).value();
			FrameBuilder builder = new FrameBuilder("attribute").add("attribute", ((AttributeCondition) condition).attribute());
			if (value != null) builder.add("value", value.toString());
			return builder.toFrame();
		}
		if (condition instanceof TriggerCondition)
			return new FrameBuilder("trigger").add("value", ((TriggerCondition) condition).name()).toFrame();
		return new FrameBuilder("type").add("value", ((TypeCondition) condition).types().toArray(new String[0])).toFrame();
	}

	@NotNull
	private Formatter buildStringFormatter() {
		return object -> {
			String value = object.toString();
			if (value.contains("\r")) value = value.replace("\r", "\\r");
			value = value.replace("\n", "\\n");
			value = value.replace("\t", "\\t").replace("\"", "\\\"");
			if (value.equals("\\")) value = value.replace("\\", "\\\\");
			return '"' + value + '"';
		};
	}
}