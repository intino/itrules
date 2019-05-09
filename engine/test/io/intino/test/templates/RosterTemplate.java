package io.intino.test.templates;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class RosterTemplate extends Template {

/*
def type(Roster)
	<roster>
		[$Coach]
		<players>
			A[$Players...[$NL]]
		</players>
    </roster>
end

def type(Person) trigger(Coach)
    <coach name="$Name" year="$Birthday+Year" country="$Country"[ attribute=$NotExist>?>]
end

def type(Person)
    <player name="$Name" year="$Birthday+Year" country="$Country"[ club="$Club"]/>
end
 */

    @Override
    protected RuleSet ruleSet() {
        return new RuleSet()
                .add(rule()
                    .condition(type("Roster"))
                    .output(literal("<roster>\n"))
                    .output(literal("\t"), expression(mark("coach")), literal("\n"))
                    .output(literal("\t<players>\n"))
                    .output(literal("\t\t"), expression(mark("players").multiple("\n")), literal("\n"))
                    .output(literal("\t</players>\n"))
                    .output(literal("</roster>")))
                .add(rule()
                    .condition(type("Person"),trigger("coach"))
                    .output(literal("<coach name=\""), mark("name"), literal("\"/>")))
                .add(rule()
                    .condition(type("Person"))
                    .output(literal("<player name=\""), mark("name"), literal("\"/>")));
    }
}

