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

package io.intino.test.templates;

import io.intino.itrules.Engine;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;
import io.intino.itrules.template.condition.predicates.Predicates;
import io.intino.itrules.template.outputs.Outputs;

import java.util.List;

public class MessageTemplate extends Template {

/*
def type(Message)
    From: $from
    To: [$to...[, ]]
    ["$subject"?(No subject)]
        [$body...[$NL]
end
 */

	@Override
	public List<Rule> ruleSet() {
		return List.of(rule()
				.condition(Predicates.type("Message"))
				.output(Outputs.literal("From: "), Outputs.placeholder("from"), Outputs.literal("\n"))
				.output(Outputs.literal("To: "), Outputs.expression(Outputs.placeholder("to").multiple(", ")), Outputs.literal("\n"))
				.output(Outputs.expression(Outputs.literal("\""), Outputs.placeholder("subject"), Outputs.literal("\"\n")).next(Outputs.expression(Outputs.literal("(No subject)\n"))))
				.output(Outputs.literal("\t"), Outputs.expression(Outputs.placeholder("body").multiple("\n"))));
	}

	public String render(Object object) {
		return new Engine(this).render(object);
	}
}

