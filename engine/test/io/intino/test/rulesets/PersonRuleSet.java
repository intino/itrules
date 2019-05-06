package io.intino.test.rulesets;

import io.intino.itrules.Rule;
import io.intino.itrules.Rule.Output;
import io.intino.itrules.RuleSet;
import io.intino.itrules.rules.conditions.AttributeCondition;
import io.intino.itrules.rules.conditions.NegatedCondition;
import io.intino.itrules.rules.conditions.TriggerCondition;
import io.intino.itrules.rules.conditions.TypeCondition;
import io.intino.itrules.rules.output.Expression;
import io.intino.itrules.rules.output.Literal;
import io.intino.itrules.rules.output.Mark;
import io.intino.test.classes.Team;

import static io.intino.itrules.rules.conditions.TypeCondition.Operator.Any;

public class PersonRuleSet extends RuleSet {
    public PersonRuleSet() {
        super();
    }

    public PersonRuleSet basic() {
        add(rule().condition(type("Person"))
                .output(mark("name"), literal(" was born in "), mark("country"), literal(" on "), mark("birthday", "quoted", "ShortDate")));
        return this;
    }

    public PersonRuleSet uppercase() {
        add(rule().condition(type("PERSON"))
                .output(new Mark("NAME"), literal(" was born in "), new Mark("COUNTRY"), literal(" on "), mark("BIRTHDAY", "SHORTDATE")));
        return this;
    }

    public PersonRuleSet customFormat() {
        add(rule().condition(type("Person"))
                .output(mark("Name", "Custom","lowercase","capitalize"), literal(" was born in "), mark("Country", "Custom","lowercase","FirstUppercase"), literal(" on "), mark("Birthday", "ShortDate"))
        );
        return this;
    }

    public PersonRuleSet gender() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal(" is "), new Mark("Gender")));
        return this;
    }

    private PersonRuleSet withGenderRule() {
        add(rule().condition(type("Gender"), attribute("", Team.Person.Gender.Male))
                .output(literal("a man")));
        return this;
    }


    public RuleSet dogs() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal(" has "), expression(literal("the following dogs:\n\t"), mark("pets").multiple("\n")).next(expression(literal("no dogs"))))
        );
        add(rule().condition(type("Pet"), attribute("animal", "dog"))
                .output(new Mark("name"))
        );
        return this;
    }

    public RuleSet noDogs() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), expression(literal(" is the owner of "), mark("pets").multiple(", ")))
        );
        add(rule().condition(type("Pet"), not(attribute("animal", "dog")))
                .output(new Mark("name"))
        );
        return this;
    }

    public PersonRuleSet withTriggerRule() {
        add(rule().condition(trigger("Name"))
                .output(literal("*"), mark(""), literal("*"))
        );
        return this;
    }

    public PersonRuleSet expression() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal(" was born"), expression(new Literal(" in "), new Mark("country")), expression(literal(" on "), mark("Birthday", "ShortDate")))
        );
        return this;
    }

    public RuleSet withMultipleAttributes() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal(" has "), mark("petsCount"), literal(" pets: "), mark("pets").multiple(", "))
        );
        add(rule().condition(type("Pet"))
                .output(new Mark("name"))
        );
        add(rule().condition(type("Integer"), trigger("PetsCount"), attribute("this",0))
                .output(literal("no"))
        );
        return this;
    }

    public RuleSet withMultipleExpression() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal(" has "), mark("petsCount"), literal(" pets"), expression(literal(": "), mark("pets").multiple(", ")))
        );
        add(rule().condition(type("Pet"))
                .output(new Mark("name"))
        );
        add(rule().condition(type("Integer"), trigger("PetsCount"), attribute("",0))
                .output(literal("no"))
        );
        return this;
    }

    public RuleSet withMultipleIndentedAttributes() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal(" has "), mark("petsCount"), literal(" pets\n\t"), mark("pets").multiple("\n\n"))
        );
        add(rule().condition(type("Pet"))
                .output(new Mark("name"), literal("\n"))
                .output(literal("\t"), new Mark("animal"))
        );
        add(rule().condition(trigger("PetsCount"), attribute("",0))
                .output(literal("no"))
        );
        return this;
    }

    public RuleSet withMultipleIndentedExpression() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal(" has "), mark("petsCount"), literal(" pets\n\t"), expression(mark("pets").multiple("\n\n")))
        );
        add(rule().condition(type("Pet"))
                .output(new Mark("name"),literal("\n\t"), new Mark("animal"))
        );
        add(rule().condition(trigger("PetsCount"), attribute("",0))
                .output(literal("no"))
        );
        return this;
    }

    public RuleSet withNestedExpressions() {
        add(rule().condition(type("Person"))
                .output(new Mark("name"), literal("\n\t"), expression(
                        expression(literal("Pets\n\t"), mark("pets").multiple("\n"), literal("\n")),
                        expression(literal("Teams\n\t"),mark("teams").multiple("\n"), literal("\n"))
                )));
        add(rule().condition(anyType("Pet","Team"))
                .output(new Mark("name"))
        );
        return this;
    }

    private Expression expression(Output... outputs) {
        return new Expression(outputs);
    }

    private Rule rule() {
        return new Rule();
    }

    private Rule.Condition type(String type) {
        return new TypeCondition(Any, type);
    }

    private Rule.Condition anyType(String... types) {
        return new TypeCondition(Any, types);
    }

    private Rule.Condition not(Rule.Condition condition) {
        return new NegatedCondition(condition);
    }

    private Rule.Condition attribute(String attribute) {
        return new AttributeCondition(attribute);
    }

    private Rule.Condition attribute(String attribute, Object value) {
        return new AttributeCondition(attribute, value);
    }

    private Rule.Condition trigger(String name) {
        return new TriggerCondition(name);
    }

    private Mark mark(String name, String... options) {
        return new Mark(name, options);
    }

    private Literal literal(String text) {
        return new Literal(text);
    }
}
