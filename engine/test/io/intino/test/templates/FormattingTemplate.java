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
import io.intino.itrules.template.Template;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.condition.predicates.Predicates;
import io.intino.itrules.template.outputs.Outputs;

import java.util.List;

public class FormattingTemplate extends Template {

/*
def type(Person)
    Name: $Name+Uppercase
    BirthYear: $Birthday+Year

    Height: $Height ($Height+Words) cm
    Salary: $$$Salary+Separators
end
 */

	@Override
	public List<Rule> ruleSet() {
		return List.of(rule().condition(Predicates.type("Person"))
				.output(Outputs.literal("Name: "), Outputs.placeholder("Name", "Uppercase"), Outputs.literal("\n"))
				.output(Outputs.literal("BirthYear: "), Outputs.placeholder("BirthDate", "Year"), Outputs.literal("\n"))
				.output(Outputs.literal("\n"))
				.output(Outputs.literal("Height: "), Outputs.placeholder("Height", "Year"), Outputs.literal(" ("), Outputs.placeholder("Height", "words"), Outputs.literal(") cm\n"))
				.output(Outputs.literal("Salary: $"), Outputs.placeholder("Salary", "Separators")));
	}

	public String render(Object object) {
		return new Engine(this).render(object);
	}
}

