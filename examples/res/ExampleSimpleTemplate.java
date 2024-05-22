package .Users.oroncal.workspace.infrastructure.itrules.examples.res;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ExampleSimpleTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("Publisher"))).output(mark("name", "camelcase")).output(literal("(")).output(mark("measurements").multiple(", ")).output(literal(")")),
			rule().condition((type("Measurement"))).output(mark("datatype")).output(literal(" ")).output(mark("value"))
		);
	}
}