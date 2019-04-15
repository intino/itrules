/*
 * Copyright 2014 SIANI - ULPGC
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

import org.jetbrains.annotations.NotNull;
import io.intino.itrules.Adapter;
import io.intino.itrules.Formatter;
import io.intino.itrules.LineSeparator;
import io.intino.itrules.Template;
import io.intino.itrules.engine.RuleSet;
import io.intino.itrules.engine.SlotSet;
import io.intino.itrules.model.Frame;
import io.intino.itrules.model.Rule;

import java.net.URISyntaxException;
import java.util.Locale;

public class TemplateRulesWriter {

	private final String name;
	private final String aPackage;
	private final String locale;
	private final String lineSeparator;

	public TemplateRulesWriter(String name, String aPackage, String locale, String lineSeparator) {
		this.name = name;
		this.aPackage = aPackage;
		this.locale = locale;
		this.lineSeparator = lineSeparator;
	}

	@NotNull
	public String toJava(final RuleSet rules) throws URISyntaxException {
		Template template = JavaItrulesTemplate.create(Locale.getDefault(), lineSeparator.equals("LF") ? LineSeparator.LF : LineSeparator.CRLF);
		template.add("string", buildStringFormatter());
		template.add(RuleSet.class, buildRuleSetAdapter(rules));
		return template.format(rules);
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

	@NotNull
	private Adapter<RuleSet> buildRuleSetAdapter(final RuleSet rules) {
		return (source, context) -> {
			final Frame frame = context.frame();
			final SlotSet slotSet = SlotSet.create();
			if (!aPackage.isEmpty()) slotSet.add("package", context.build(aPackage));
			slotSet.add("name", context.build(name));
			slotSet.add("locale", context.build(locale));
			slotSet.add("lineSeparator", context.build(lineSeparator));
			for (Rule rule : rules) slotSet.add("rule", context.build(rule));
			frame.addSlots(slotSet);
		};
	}
}