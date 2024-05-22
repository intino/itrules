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
	public List<Rule> ruleSet() {
		return List.of(
				rule().condition(Predicates.all(Predicates.type("Module"), Predicates.attribute("modules")))
						.output(Outputs.literal("<module name=\""), Outputs.placeholder("name"), Outputs.literal("\">\n"))
						.output(Outputs.literal("\t"), Outputs.placeholder("modules").multiple("\n"), Outputs.literal("\n"))
						.output(Outputs.literal("</module>")),
				rule().condition(Predicates.type("Module"))
						.output(Outputs.literal("<module name=\""), Outputs.placeholder("name"), Outputs.literal("\"/>")));
	}

	public String render(Object object) {
		return new Engine(this).render(object);
	}
}

