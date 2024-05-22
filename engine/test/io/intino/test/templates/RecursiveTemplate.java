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

import static io.intino.itrules.template.condition.BinaryExpression.all;

public class RecursiveTemplate extends Template {

/*
def type(Module) attribute(modules)
	<module name="$name">
	    $modules...[$NL]
    </module>
end

def type(Module)
	<module name="$name"/>
end
 */

	@Override
	protected List<Rule> ruleSet() {
		return List.of(
				rule().condition(all(type("Module"), attribute("modules")))
						.output(literal("<module name=\""), placeholder("name"), literal("\">\n"))
						.output(literal("\t"), placeholder("modules").multiple("\n"), literal("\n"))
						.output(literal("</module>")),
				rule().condition(type("Module"))
						.output(literal("<module name=\""), placeholder("name"), literal("\"/>")));
	}

}

