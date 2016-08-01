/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.siani.itrules;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.engine.SlotSet;
import org.siani.itrules.engine.Trigger;
import org.siani.itrules.model.*;
import org.siani.itrules.model.marks.Mark;

import java.util.*;


public class TemplateEngine_ {

	@Test
	public void should_render_hello_world() throws Exception {
		Assert.assertEquals("Hello world",
			engine().render("Hello world"));
	}

	@Test
	public void when_lines_end_in_remover_should_remove_empty_lines() throws Exception {
		Assert.assertEquals("Hello world\n", engine().render("Hello world\n"));
		Assert.assertEquals("Hello world", engine().render("Hello world\n	|>"));
		Assert.assertEquals("Hello world", engine().render("Hello world|>"));
		Assert.assertEquals("Hello world\n", engine().render("Hello world\n  "));
		Assert.assertEquals("Hello world\n", engine().render("Hello world|>\n"));
		Assert.assertEquals("Hello world\n", engine().render("Hello world|>\n	|>\n  "));
		Assert.assertEquals("Hello world\n\n", engine().render("Hello world\n	\n  "));
		Assert.assertEquals("Hello world\n\n", engine().render("Hello world\n	\n"));
		Assert.assertEquals("Hello world", engine().render("	|>\nHello world\n	|>"));
		Assert.assertEquals("\nHello world", engine().render("	|>\n\nHello world\n	|>"));
		Assert.assertEquals("\nHello world\n", engine().render("	|>\n\nHello world\n	|>\n"));
	}

	@Test
	public void should_render_an_integer() throws Exception {
		Assert.assertEquals("5000",
			engine().render(5000));
	}

	@Test
	public void should_render_a_double() throws Exception {
		Assert.assertEquals("5000.0",
			engine().render(5000.0));
	}

	@Test
	public void should_render_an_enum() throws Exception {
		Assert.assertEquals("Male",
			engine().render(Sex.Male));
	}

	@Test
	public void should_render_person_defining_a_rule() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
			renderPerson(personRule()));
	}

	@Test
	public void should_render_person_removing_empty_lines() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain\non 06/07/1980",
			renderPerson(personRuleWithMarkInDirtyLine()));
	}

	@Test
	public void should_render_person_with_null_attributes_defining_a_rule() throws Exception {
		Assert.assertEquals("Pau Gasol was born",
			renderPersonWithNullAttributes(personRuleWithExpressions()));
	}

	@Test
	public void should_render_person_with_enum() throws Exception {
		Assert.assertEquals("Pau Gasol is a man",
			renderPerson(personRuleWithSex(), sexRule()));
	}

	@Test
	public void should_render_person_defining_a_rule_with_negated_condition() throws Exception {
		Assert.assertEquals("Pau Gasol was born in - on -",
			renderPerson(personRule(), negatedConditionRule()));
	}

	@Test
	public void should_render_person_defining_a_rule_with_uppercase_tokens() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
			renderPerson(personRuleUppercase()));
	}

	@Test
	public void should_render_person_defining_a_rule_with_formatted_marks() throws Exception {
		Assert.assertEquals("PAU GASOL was born in spain on 06/07/1980",
			renderPerson(personRuleWithFormatMarks()));
	}

	@Test
	public void should_render_person_with_rule_expression() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain",
			renderPerson(personRuleWithOrExpressions()));
	}

	@Test
	public void should_render_person_defining_a_rule_with_value_function() throws Exception {
		Assert.assertEquals("*Pau Gasol* was born in Spain on 06/07/1980",
			renderPerson(personRule(), valueRule()));
	}

	@Test
	public void should_render_person_defining_rule_with_a_trigger_condition() throws Exception {
		Assert.assertEquals("*Pau Gasol* was born in Spain on 06/07/1980",
			renderPerson(personRule(), triggerConditionRule()));
	}

	@Test
	public void should_render_person_defining_rule_with_a_trigger_format_condition() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain on \"06/07/1980\"",
			renderPerson(personRule(), triggerFormatConditionRule()));
	}

	@Test
	public void should_render_person_ignoring_date_formats_if_value_is_not_date() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
			renderPerson(personRuleWithDateFormatOnString()));
	}

	@Test
	public void should_render_person_ignoring_number_formats_if_value_is_not_double() throws Exception {
		Assert.assertEquals("Pau gasol was born in spain on 06/07/1980",
			renderPerson(personRuleWithDoubleFormatOnString()));
	}

	@Test
	public void should_render_person_chaining_two_formats() throws Exception {
		Assert.assertEquals("PauGasols was born in Spain on 06/07/1980",
			renderPerson(personRuleWithTwoFormats()));
	}

	@Test
	public void should_render_person_defining_a_rule_with_a_custom_formatter() throws Exception {
		Assert.assertEquals("9 was born in 5 on 06/07/1980",
			renderPersonWithCustomFormat(personRuleWithCustomFormat()));
	}

	@Test
	public void should_render_person_defining_rule_with_a_custom_condition_function() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
			renderPersonWithCustomConditionFunction(personRuleWithCustomCondition()));
	}

	@Test
	public void should_render_person_defining_rule_with_a_custom_adapter() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain and he is 34 years old",
			renderPersonWithCustomAdapter(personRuleWithCustomAdapter()));
	}

	@Test
	public void should_render_an_array_of_objects() throws Exception {
		Assert.assertEquals("item1, item2, item3",
			new TemplateEngine().add(collectionRule()).render(new String[]{"item1", "item2", "item3"}));
	}

	@Test
	public void should_render_a_list_of_objects() throws Exception {
		Assert.assertEquals("item1, item2, item3",
			new TemplateEngine().add(collectionRule()).render(Arrays.asList("item1", "item2", "item3")));
	}

	@Test
	public void should_render_a_map_of_objects() throws Exception {
		Assert.assertEquals("string1:value1, string2:value2, string3:value3",
			new TemplateEngine().add(collectionRule(), item()).render(createMap()));
	}

	@Test
	public void should_render_a_container_including_an_engine() throws Exception {
		Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
			engine().add(containerRule()).add("rule", engine().add(personRule())).render(container()));
	}

	@Test
	public void should_render_a_container_including_an_engine_and_a_primitive_formatter() throws Exception {
		Assert.assertEquals("41",
			engine().add(containerRuleWithTwoFormatters()).add("rule", engine().add(personRule())).render(container()));
	}

	private Rule containerRule() {
		return new Rule().
			add(condition("type", "Container")).
			add(new Mark("person", "rule"));
	}

	private Rule containerRuleWithTwoFormatters() {
		return new Rule().
			add(condition("type", "Container")).
			add(new Mark("person", "rule", "length"));
	}

	private Map<String, String> createMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("string1", "value1");
		map.put("string2", "value2");
		map.put("string3", "value3");
		return map;
	}

	private Rule collectionRule() {
		return new Rule().add(new Condition("type", "Collection"), new Condition("attribute", "items")).
			add(new Mark("items").multiple(", "));
	}

	private Rule item() {
		return new Rule().add(new Condition("type", "item")).
			add(new Mark("key"), new Literal(":"), new Mark("value"));
	}

	private Adapter<Person> customAdapter() {
		return (source, context) -> context.frame().addSlots(SlotSet.create()
            .add("name", context.build(source.name))
            .add("country", context.build(source.country))
            .add("birthday", context.build(source.birthday))
            .add("age", context.build(34))
            .add("sex", context.build(source.sex)));
	}

	private Function customConditionFunction() {
		return new Function() {
			@Override
			public boolean match(Trigger trigger, String parameter) {
				return trigger.frame().is("Person") && name(trigger).contains(parameter);
			}

			private String name(Trigger trigger) {
				return (String) trigger.frame().frames("name").next().value();
			}
		};
	}

	private Literal literal(String literal) {
		return new Literal(literal);
	}

	private Expression expression(Token.Body... tokens) {
		Expression expression = new Expression();
		for (Token.Body token : tokens) expression.add(token);
		return expression;
	}

	private Condition condition(String name, String parameter) {
		return new Condition(name, parameter);
	}

	private Condition not(Condition condition) {
		return new Condition.Negated(condition);
	}

	private Mark mark(String name, String... options) {
		return new Mark(name, options);
	}

	private Formatter customFormatter() {
		return value -> value.toString().length();
	}

	private Container container() {
		return new Container(person());
	}

	private Person person() {
		return new Person("Pau Gasol", date(1980, Calendar.JULY, 6), "Spain", Sex.Male);
	}

	private Date date(int year, int month, int day) {
		return new GregorianCalendar(year, month, day).getTime();
	}

	private TemplateEngine engine() {
		return new TemplateEngine(Locale.ENGLISH, LineSeparator.LF);
	}

	private enum Sex {
		Male
	}

	private String renderPerson(Rule... rules) {
		return engine().add(rules).add("name", nameFormatter()).render(person());
	}

	private String renderPersonWithNullAttributes(Rule... rules) {
		return engine().add(rules).render(new Person("Pau Gasol", null, null, null));
	}

	private String renderPersonWithCustomFormat(Rule... rules) {
		return engine().add("Custom", customFormatter()).add(rules).render(person());
	}

	private String renderPersonWithCustomConditionFunction(Rule... rules) {
		return engine().add("Custom", customConditionFunction()).add(rules).render(person());
	}

	private String renderPersonWithCustomAdapter(Rule... rules) {
		return engine().add(Person.class, customAdapter()).add(rules).render(person());
	}

	private class Person {
		private final String name;
		private final Date birthday;
		private final String country;
		private final Sex sex;

		public Person(String name, Date birthday, String country, Sex sex) {
			this.name = name;
			this.birthday = birthday;
			this.country = country;
			this.sex = sex;
		}
	}

	private class Container {
		private final Person person;

		public Container(Person person) {
			this.person = person;
		}
	}


	private Rule valueRule() {
		return new Rule().
			add(condition("attribute", "Pau Gasol")).
			add(literal("*"), mark("value"), literal("*"));
	}

	private Rule sexRule() {
		return new Rule().
			add(condition("type", "Sex"), condition("attribute", "Male")).
			add(literal("a man"));
	}

	private Rule negatedConditionRule() {
		return new Rule().
			add(not(condition("attribute", "Pau Gasol"))).
			add(literal("-"));
	}

	private Rule triggerFormatConditionRule() {
		return new Rule().
			add(condition("Trigger", "quoted")).
			add(literal("\""), mark("value"), literal("\""));
	}

	private Rule triggerConditionRule() {
		return new Rule().
			add(condition("Trigger", "Name")).
			add(literal("*"), mark("value"), literal("*"));
	}

	private Rule triggerWithFormatter() {
		return new Rule().
			add(condition("Trigger", "Name")).
			add(mark("value", "name"));
	}

	private Formatter nameFormatter() {
		return value -> {
            final String fullName = value.toString();
            final String firstName = fullName.substring(0, fullName.indexOf(" "));
            final String surName = fullName.replace(firstName, " ").trim();
            return firstName.substring(0, 1).toUpperCase() + ". " + surName;

        };
	}

	@Test
	public void should_render_person_defining_rule_with_a_trigger_condition_and_name_formatter() throws Exception {
		Assert.assertEquals("P. Gasol was born in Spain on 06/07/1980",
			renderPerson(personRule(), triggerWithFormatter()));
	}


	private Rule personRule() {
		return new Rule().
			add(condition("type", "Person")).
			add(new Mark("name"), literal(" was born in "), new Mark("country"), literal(" on "), mark("Birthday", "quoted", "ShortDate"));
	}

	private Rule personRuleWithMarkInDirtyLine() {
		return new Rule().
			add(condition("type", "Person")).
			add(new Mark("name"), literal(" was born in "), new Mark("country"), literal("\n\t   \t "), mark("dirty"), literal("|>\n"), literal("on "), mark("Birthday", "quoted", "ShortDate"));
	}

	private Rule personRuleWithExpressions() {
		return new Rule().
			add(condition("type", "Person")).
			add(new Mark("name"), literal(" was born"), expression(new Literal(" in "), new Mark("country")), expression(literal(" on "), mark("Birthday", "ShortDate")));
	}

	private Rule personRuleWithSex() {
		return new Rule().
			add(condition("type", "Person")).
			add(new Mark("name"), literal(" is "), new Mark("Sex"));
	}

	private Rule personRuleUppercase() {
		return new Rule().
			add(condition("TYPE", "PERSON")).
			add(new Mark("NAME"), literal(" was born in "), new Mark("COUNTRY"), literal(" on "), mark("BIRTHDAY", "SHORTDATE"));
	}

	private Rule personRuleWithDateFormatOnString() {
		return new Rule().
			add(condition("Type", "Person")).
			add(mark("Name", "ShortDate"), literal(" was born in "), mark("Country"), literal(" on "), mark("Birthday", "ShortDate"));
	}


	private Rule personRuleWithDoubleFormatOnString() {
		return new Rule().
			add(condition("Type", "Person")).
			add(mark("Name", "TwoDecimals", "Capitalize"), literal(" was born in "), mark("Country", "Letters", "LowerCase"), literal(" on "), mark("Birthday", "Separators", "ShortDate"));
	}

	private Rule personRuleWithTwoFormats() {
		return new Rule().
			add(condition("Type", "Person")).
			add(mark("Name", "CamelCase", "Plural"), literal(" was born in "), mark("Country"), literal(" on "), mark("Birthday", "ShortDate"));
	}


	private Rule personRuleWithFormatMarks() {
		return new Rule().
			add(condition("Type", "Person")).
			add(mark("Name", "Uppercase"), literal(" was born in "), mark("Country", "Lowercase"), literal(" on "), mark("Birthday", "ShortDate"));
	}

	private Rule personRuleWithCustomCondition() {
		return new Rule().
			add(condition("Custom", "Gasol")).
			add(mark("Name"), literal(" was born in "), mark("Country"), literal(" on "), mark("Birthday", "ShortDate"));
	}

	private Rule personRuleWithCustomFormat() {
		return new Rule().
			add(condition("Type", "Person")).
			add(mark("Name", "Custom"), literal(" was born in "), mark("Country", "Custom"), literal(" on "), mark("Birthday", "ShortDate"));
	}

	private Rule personRuleWithCustomAdapter() {
		return new Rule().
			add(condition("Type", "Person")).
			add(mark("Name"), literal(" was born in "), mark("Country"), literal(" and he is "), mark("age"), literal(" years old"));
	}

	private Rule personRuleWithOrExpressions() {
		return new Rule().
			add(condition("Type", "Person")).
			add(mark("Name"), expression(literal("..."), mark("Nothing"), literal("...")).or(expression(literal("..."), mark("Empty"))).or(expression(literal(" was born in "), mark("Country"))));
	}

}
