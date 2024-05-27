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

package io.intino.itrules.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static io.intino.itrules.template.Template.Configuration.LineSeparator.CRLF;
import static io.intino.itrules.template.Template.Configuration.LineSeparator.LF;

public abstract class Template {
	private final Configuration configuration;

	public Template() {
		this(new Configuration());
	}

	public Template(Configuration configuration) {
		this.configuration = configuration;
	}

	public abstract List<Rule> ruleSet();

	public Configuration configuration() {
		return configuration;
	}

	public static Template compose(Template t, Template... templates) {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.addAll(rules);
		for (Template template : templates)
			rules.addAll(template.ruleSet());
		return new Template() {
			@Override
			public List<Rule> ruleSet() {
				return rules;
			}
		};
	}

	protected Rule rule() {
		return new Rule();
	}

	public record Configuration(Locale locale, LineSeparator separator) {
		public Configuration() {
			this(Locale.ENGLISH, LF);
		}

		public boolean isCRLF() {
			return separator() == CRLF;
		}

		public enum LineSeparator {
			LF, CRLF
		}
	}

	public static final Template EMPTY = with(List.of());

	public static Template with(List<Rule> rules) {
		return new Template() {
			@Override
			public List<Rule> ruleSet() {
				return rules;
			}
		};
	}

}
