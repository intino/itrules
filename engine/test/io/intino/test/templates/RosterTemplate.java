package io.intino.test.templates;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

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
    protected RuleSet ruleSet() {
        return new RuleSet()
                .add(rule()
                    .condition(type("Roster"))
                    .output(
                            literal("<roster>\n"),
                            literal("\t"), expression(mark("coach")), literal("\n"),
                            literal("\t"), expression(
                                    literal("<players>\n"),
                                    literal("\t"), mark("players").multiple("\n"), literal("\n"),
                                    literal("</players>")),
                            literal("\n</roster>")
                    )
                )
                .add(rule()
                    .condition(type("Person"),trigger("coach"))
                    .output(
                            literal("<coach name=\""), mark("name"), literal("\">\n"),
                            literal("\t"), expression(
                                    literal("<pets>\n"),
                                    literal("\t"), mark("pets").multiple("\n"), literal("\n"),
                                    literal("</pets>")),
                            literal("\n</coach>")
                    )
                )
                .add(rule()
                    .condition(type("Person"))
                    .output(
                            literal("<player name=\""), mark("name"), literal("\">\n"),
                            literal("\t"), expression(
                                    literal("<pets>\n"),
                                    literal("\t"), mark("pets").multiple("\n"), literal("\n"),
                                    literal("</pets>")),
                            literal("\n</player>")
                    )
                )
                .add(rule()
                        .condition(trigger("Pets"))
                        .output(literal("<pet>"), mark("this"), literal("</pet>"))
                );
    }
}

