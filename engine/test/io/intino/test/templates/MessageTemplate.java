package io.intino.test.templates;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class MessageTemplate extends Template {

/*
def type(Message)
    From: $from
    To: [$to...[, ]]
    ["$subject"?(No subject)]
        $body...[$NL]
end
 */

    @Override
    protected RuleSet ruleSet() {
        return new RuleSet()
                .add(rule()
                    .condition(type("Message"))
                    .output(literal("From: "), mark("from"), literal("\n"))
                    .output(literal("To: "), expression(mark("to").multiple(", ")), literal("\n"))
                    .output(expression(literal("\""),mark("subject"),literal("\"\n")).next(expression(literal("(No subject)\n"))))
                    .output(literal("\t"),mark("body").multiple("\n")));
    }
}

