package io.intino.test.templates;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

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
    protected RuleSet ruleSet() {
        return new RuleSet()
                .add(rule()
                    .condition(type("Module"),attribute("modules"))
                    .output(literal("<module name=\""), mark("name"), literal("\">\n"))
                    .output(literal("\t"), mark("modules").multiple("\n"), literal("\n"))
                    .output(literal("</module>")))
                .add(rule()
                    .condition(type("Module"))
                    .output(literal("<module name=\""), mark("name"), literal("\"/>")));
    }
}

