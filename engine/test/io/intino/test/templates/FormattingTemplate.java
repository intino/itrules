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

import io.intino.itrules.Template;
import io.intino.itrules.template.Rule;

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
	protected List<Rule> ruleSet() {
		return List.of(rule().condition(type("Person"))
				.output(literal("Name: "), placeholder("Name", "Uppercase"), literal("\n"))
				.output(literal("BirthYear: "), placeholder("BirthDate", "Year"), literal("\n"))
				.output(literal("\n"))
				.output(literal("Height: "), placeholder("Height", "Year"), literal(" ("), placeholder("Height", "words"), literal(") cm\n"))
				.output(literal("Salary: $"), placeholder("Salary", "Separators")));
	}
}

