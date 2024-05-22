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

public class RosterTemplate extends Template {

/*
def type(Roster)
	<roster>
		[$Coach]
    	[<players>
    		$Players...[$NL]
    	</players>]
    </roster>
end

def type(Person) trigger(Coach)
    <coach name="$Name" year="$Birthday+Year" country="$Country"[ attribute=$NotExist>?>]
		[<pets>
			$Pets...[$NL]
		</pets>]
    </coach>
end

def type(Person)
    <player name="$Name" year="$Birthday+Year" country="$Country"[ club="$Club"]>
		[<pets>
			$Pets...[$NL]
		</pets>]
	</player>
end

def trigger(Pets)
    <pet>$this</pet>
end

 */

	@Override
	protected List<Rule> ruleSet() {
		return List.of(rule().condition(type("Roster"))
						.output(
								literal("<roster>\n"),
								literal("\t"), expression(placeholder("coach")), literal("\n"),
								literal("\t"), expression(
										literal("<players>\n"),
										literal("\t"), placeholder("players").multiple("\n"), literal("\n"),
										literal("</players>")),
								literal("\n</roster>")
						),
				rule().condition(all(type("Person"), trigger("coach")))
						.output(
								literal("<coach name=\""), placeholder("name"), literal("\">\n"),
								literal("\t"), expression(
										literal("<pets>\n"),
										literal("\t"), placeholder("pets").multiple("\n"), literal("\n"),
										literal("</pets>")),
								literal("\n</coach>")
						),
				rule().condition(type("Person"))
						.output(
								literal("<player name=\""), placeholder("name"), literal("\">\n"),
								literal("\t"), expression(
										literal("<pets>\n"),
										literal("\t"), placeholder("pets").multiple("\n"), literal("\n"),
										literal("</pets>")),
								literal("\n</player>")
						),
				rule()
						.condition(trigger("Pets"))
						.output(literal("<pet>"), placeholder("this"), literal("</pet>"))
		);
	}
}