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

import org.siani.itrules.Adapter;
import org.siani.itrules.Formatter;
import org.siani.itrules.RuleEngine;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.Rule;

import java.io.File;
import java.net.URISyntaxException;

public class TemplateRulesWriter {

	private final String name;
	private final String aPackage;

	public TemplateRulesWriter(String name, String aPackage) {
		this.name = name;
		this.aPackage = aPackage;
	}

	public String toJava(final RuleSet rules) throws URISyntaxException {
		RuleEngine engine = new RuleEngine().use(new File(this.getClass().getResource("/templates/template.java.itr").toURI().getPath()));
		engine.add("string", new Formatter() {
			@Override
			public Object format(Object object) {
				String value = object.toString();
				value = value.replace("\n", "\\n").replace("\t", "\\t").replace("\"", "\\\"");
				return '"' + value + '"';
			}
		});
		engine.add(RuleSet.class, new Adapter<RuleSet>() {
			@Override
			public void execute(Frame frame, RuleSet source, Context<RuleSet> context) {
				if (!aPackage.isEmpty()) frame.addFrame("package", aPackage);
				frame.addFrame("name", name);
				for (Rule rule : rules)
					frame.addFrame("rule", context.build(rule));
			}
		});
		return engine.render(rules).content();
	}
}