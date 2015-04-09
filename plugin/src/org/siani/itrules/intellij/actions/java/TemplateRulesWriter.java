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

package org.siani.itrules.intellij.actions.java;

import org.jetbrains.annotations.NotNull;
import org.siani.itrules.Adapter;
import org.siani.itrules.Formatter;
import org.siani.itrules.RuleEngine;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.Rule;
import org.siani.itrules.reader.itr.RuleSetReader;

import java.net.URISyntaxException;

public class TemplateRulesWriter {

	private final String name;
	private final String aPackage;

	public TemplateRulesWriter(String name, String aPackage) {
		this.name = name;
		this.aPackage = aPackage;
	}

	public String toJava(final RuleSet rules) throws URISyntaxException {
		RuleEngine engine = new RuleEngine().add(getRuleSet());
		engine.add("string", buildStringFormatter());
		engine.add(RuleSet.class, buildRuleSetAdapter(rules));
		return engine.render(rules).content();
	}

	@NotNull
	private Formatter buildStringFormatter() {
		return new Formatter() {
			@Override
			public Object format(Object object) {
				String value = object.toString();
				value = value.replace("\n", "\\n").replace("\t", "\\t").replace("\"", "\\\"");
				return '"' + value + '"';
			}
		};
	}

	@NotNull
	private Adapter<RuleSet> buildRuleSetAdapter(final RuleSet rules) {
		return new Adapter<RuleSet>() {
			@Override
			public void execute(Frame frame, RuleSet source, Context<RuleSet> context) {
				if (!aPackage.isEmpty()) frame.addFrame("package", context.build(aPackage));
				frame.addFrame("name", context.build(name));
				for (Rule rule : rules)
					frame.addFrame("rule", context.build(rule));
			}

		};
	}

	@NotNull
	private RuleSet getRuleSet() {
		return new RuleSetReader(this.getClass().getResourceAsStream("/templates/template.java.itr")).read();
	}
}