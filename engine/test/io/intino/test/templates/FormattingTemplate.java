package io.intino.test.templates;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

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
    protected RuleSet ruleSet() {
        return new RuleSet()
                .add(rule()
                    .condition(type("Person"))
                    .output(literal("Name: "), mark("Name","Uppercase"), literal("\n"))
                    .output(literal("BirthYear: "), mark("BirthDate","Year"), literal("\n"))
                    .output(literal("\n"))
                    .output(literal("Height: "), mark("Height", "Year"), literal(" ("), mark("Height", "words"),literal(") cm\n"))
                    .output(literal("Salary: $"), mark("Salary","Separators")));
    }
}

