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

import io.intino.itrules.Engine;
import io.intino.itrules.Formatter;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.Output;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;
import io.intino.itrules.template.Template.Configuration;
import io.intino.itrules.template.Template.Configuration.LineSeparator;
import io.intino.itrules.template.condition.BinaryExpression;
import io.intino.itrules.template.condition.BinaryOperator;
import io.intino.itrules.template.condition.LogicalExpression;
import io.intino.itrules.template.condition.NotExpression;
import io.intino.itrules.template.condition.predicates.AttributePredicate;
import io.intino.itrules.template.condition.predicates.TriggerPredicate;
import io.intino.itrules.template.condition.predicates.TypePredicate;
import io.intino.itrules.template.outputs.Expression;
import io.intino.itrules.template.outputs.Literal;
import io.intino.itrules.template.outputs.Placeholder;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TemplateSerializer {
	private final String name;
	private final String aPackage;
	private final Locale locale;
	private final LineSeparator lineSeparator;

	public TemplateSerializer(String name, String aPackage, Locale locale, LineSeparator lineSeparator) {
		this.name = name;
		this.aPackage = aPackage;
		this.locale = locale;
		this.lineSeparator = lineSeparator;
	}

	public String toJava(final Template template) {
		return new Engine(new JavaItrulesTemplate(new Configuration(locale, lineSeparator)))
				.add("string", buildStringFormatter())
				.render(frameOf(template));
	}

	private Frame frameOf(Template template) {
		FrameBuilder builder = new FrameBuilder("template");
		builder.add("name", name);
		builder.add("locale", locale);
		builder.add("lineSeparator", lineSeparator);
		if (!aPackage.isEmpty()) builder.add("package", aPackage);
		template.ruleSet().forEach(r -> builder.add("rule", frameOf(r)));
		return builder.toFrame();
	}

	private Frame frameOf(Rule r) {
		FrameBuilder builder = new FrameBuilder("rule");
		builder.add("condition", toString(r.condition()));
		builder.add("outputs", frameOf(r.outputs()));
		return builder.toFrame();
	}

	private Frame[] frameOf(Stream<Output> outputs) {
		return outputs.map(this::map).toArray(Frame[]::new);
	}

	private Frame map(Output o) {
		if (o instanceof Literal l) return new FrameBuilder("output", "literal").add("value", l.toString()).toFrame();
		if (o instanceof Placeholder p) {
			FrameBuilder builder = new FrameBuilder("output", "placeholder").add("name", p.name());
			if (p.targetPath() != null) builder.add("targetPath", p.targetPath());
			if (p.separator() != null) builder.add("separator", p.separator());
			if (p.formatters() != null) builder.add("formatters", p.formatters());
			return builder.toFrame();
		}
		if (o instanceof Expression e) {
			FrameBuilder builder = new FrameBuilder("output", "expression");
			e.outputs().forEach(op -> builder.add("outputs", map(op)));
			if (e.next() != null) builder.add("next", map(e.next()));
			return builder.toFrame();
		}
		return null;
	}

	private String toString(LogicalExpression source) {
		if (source instanceof BinaryExpression b)
			return (b.operator().equals(BinaryOperator.AND) ? "all(" : "any(") + toString(b.left()) + ", " + toString(b.right()) + ")";
		if (source instanceof NotExpression n) return "not(" + toString(n.expression()) + ")";
		if (source instanceof TypePredicate t)
			return "allTypes(" + Arrays.stream(t.types()).map(this::quoted).collect(Collectors.joining(", ")) + ")";
		if (source instanceof AttributePredicate a)
			return "attribute(" + quoted(a.attribute()) + (a.value() != null ? "," + quoted(a.value().toString()) : "") + ")";
		if (source instanceof TriggerPredicate t)
			return "trigger(" + quoted(t.name()) + ")";
		return "";
	}

	private String quoted(String value) {
		return "\"" + value + "\"";
	}

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