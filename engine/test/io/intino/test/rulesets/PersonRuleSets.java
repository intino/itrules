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

package io.intino.test.rulesets;

import io.intino.itrules.template.Output;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.condition.NotExpression;
import io.intino.itrules.template.condition.Predicate;
import io.intino.itrules.template.condition.predicates.AttributePredicate;
import io.intino.itrules.template.condition.predicates.TriggerPredicate;
import io.intino.itrules.template.condition.predicates.TypePredicate;
import io.intino.itrules.template.outputs.Expression;
import io.intino.itrules.template.outputs.Literal;
import io.intino.itrules.template.outputs.Placeholder;
import io.intino.test.classes.Team;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.all;
import static io.intino.itrules.template.condition.predicates.Predicates.any;


public class PersonRuleSets {
	private PersonRuleSets() {
		super();
	}

	public static List<Rule> basic() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(placeholder("name"), literal(" was born in "), placeholder("country"), literal(" on "), placeholder("birthday", "quoted", "ShortDate")));
		rules.add(rule().condition(trigger("name"))
				.output(placeholder("this", "Uppercase")));
		return rules;
	}

	public static List<Rule> uppercase() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("PERSON"))
				.output(new Placeholder("NAME"), literal(" was born in "), new Placeholder("COUNTRY"), literal(" on "), placeholder("BIRTHDAY", "SHORTDATE")));
		return rules;
	}

	public static List<Rule> customFormat() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(placeholder("Name", "Custom", "lowercase", "capitalize"), literal(" was born in "), placeholder("Country", "Custom", "lowercase", "FirstUppercase"), literal(" on "), placeholder("Birthday", "ShortDate"))
		);
		return rules;
	}

	public static List<Rule> gender() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" is "), new Placeholder("Gender")));
		return rules;
	}

	private List<Rule> withGenderRule() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(all(type("Gender"), attribute("", Team.Person.Gender.Male)))
				.output(literal("a man")));
		return rules;
	}

	public static List<Rule> dogs() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" has "), expression(literal("the following dogs:\n\t"), placeholder("pets").multiple("\n")).next(expression(literal("no dogs"))))
		);
		rules.add(rule().condition(all(type("Pet"), attribute("animal", "dog")))
				.output(new Placeholder("name"))
		);
		return rules;
	}

	public static List<Rule> noDogs() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), expression(literal(" is the owner of "), placeholder("pets").multiple(", ")))
		);
		rules.add(rule().condition(all(type("Pet"), not(attribute("animal", "dog"))))
				.output(new Placeholder("name"))
		);
		return rules;
	}

	public static List<Rule> withTriggerRule() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(trigger("Name"))
				.output(literal("*"), placeholder(""), literal("*"))
		);
		return rules;
	}

	public static List<Rule> expression() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" was born"), expression(new Literal(" in "), new Placeholder("country")), expression(literal(" on "), placeholder("Birthday", "ShortDate")))
		);
		return rules;
	}

	public static List<Rule> withMultipleAttributes() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" has "), placeholder("petsCount"), literal(" pets: "), placeholder("pets").multiple(", "))
		);
		rules.add(rule().condition(type("Pet"))
				.output(new Placeholder("name"))
		);
		rules.add(rule().condition(all(type("Integer"), attribute("this", 0), trigger("PetsCount")))
				.output(literal("no"))
		);
		return rules;
	}

	public static List<Rule> withMultipleExpression() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" has "), placeholder("petsCount"), literal(" pets"), expression(literal(": "), placeholder("pets").multiple(", ")))
		);
		rules.add(rule().condition(type("Pet"))
				.output(new Placeholder("name"))
		);
		rules.add(rule().condition(all(type("Integer"), attribute("", 0), trigger("PetsCount")))
				.output(literal("no"))
		);
		return rules;
	}

	public static List<Rule> withMultipleIndentedAttributes() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" has "), placeholder("petsCount"), literal(" pets\n\t"), placeholder("pets").multiple("\n\n"))
		);
		rules.add(rule().condition(type("Pet"))
				.output(new Placeholder("name"), literal("\n"))
				.output(literal("\t"), new Placeholder("animal"))
		);
		rules.add(rule().condition(all(trigger("PetsCount"), attribute("", 0)))
				.output(literal("no"))
		);
		return rules;
	}

	public static List<Rule> withMultipleIndentedExpression() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" has "), placeholder("petsCount"), literal(" pets\n\t"), expression(placeholder("pets").multiple("\n\n")))
		);
		rules.add(rule().condition(type("Pet"))
				.output(new Placeholder("name"), literal("\n\t"), new Placeholder("animal"))
		);
		rules.add(rule().condition(all(trigger("PetsCount"), attribute("", 0)))
				.output(literal("no"))
		);
		return rules;
	}

	public static List<Rule> withMarkThatMatchesNoRules() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal(" has "), placeholder("petsCount"), literal(" pets\n\t"), expression(placeholder("pets").multiple("\n\n")))
		);
		rules.add(rule().condition(all(type("Pet"), trigger("x")))
				.output(new Placeholder("name"), literal("\n\t"), new Placeholder("animal"))
		);
		return rules;
	}

	public static List<Rule> withNestedExpressions() {
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(type("Person"))
				.output(new Placeholder("name"), literal("\n\t"),
						expression(
								expression(literal("Pets\n\t"), placeholder("pets").multiple("\n"), literal("\n")),
								expression(literal("Teams\n\t"), placeholder("teams").multiple("\n"), literal("\n"))
						)
				));
		rules.add(rule().condition(any(type("Pet"), type("Team")))
				.output(new Placeholder("name"))
		);
		return rules;
	}

	private static Expression expression(Output... outputs) {
		return new Expression(outputs);
	}

	private static Rule rule() {
		return new Rule();
	}

	private static Predicate type(String type) {
		return new TypePredicate(type);
	}

	private static Predicate not(Predicate condition) {
		return new NotExpression(condition);
	}

	private static Predicate attribute(String attribute) {
		return new AttributePredicate(attribute);
	}

	private static Predicate attribute(String attribute, Object value) {
		return new AttributePredicate(attribute, value);
	}

	private static Predicate trigger(String name) {
		return new TriggerPredicate(name);
	}

	private static Placeholder placeholder(String name, String... options) {
		return new Placeholder(name, options);
	}

	private static Literal literal(String text) {
		return new Literal(text);
	}
}