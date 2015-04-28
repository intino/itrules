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
import org.siani.itrules.engine.Trigger;
import org.siani.itrules.engine.adapters.ExcludeAdapter;
import org.siani.itrules.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class AcceptedRuleEngine {

    @Test
    public void should_render_null() throws Exception {
        Assert.assertEquals("Hello world",
                ruleEngine().render(null));
    }

    @Test
    public void should_render_hello_world() throws Exception {
        Assert.assertEquals("Hello world",
                ruleEngine().render("Hello world"));
    }

    @Test
    public void should_render_an_integer() throws Exception {
        Assert.assertEquals("5000",
                ruleEngine().render(5000));
    }

    @Test
    public void should_render_a_double() throws Exception {
        Assert.assertEquals("5000.0",
                ruleEngine().render(5000.0));
    }

    @Test
    public void should_render_an_enum() throws Exception {
        Assert.assertEquals("Male",
                ruleEngine().render(Sex.Male));
    }

    @Test
    public void should_render_person_defining_a_rule() throws Exception {
        Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
                renderPerson(personRule()));
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
        Assert.assertEquals("Pau Gasol was born in Spain on -",
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
    public void should_render_person_excluding_a_field() throws Exception {
        Assert.assertEquals("Pau Gasol was born in Spain on ",
                renderPersonExcludingField(personRule()));
    }

    private Adapter<Person> customAdapter() {
        return new Adapter<Person>() {
            @Override
            public void execute(Frame frame, Person source, FrameContext<Person> context) {
                context.frame().addFrame("name", context.build(context.source().name));
                context.frame().addFrame("country", context.build(context.source().country));
                context.frame().addFrame("birthday", context.build(context.source().birthday));
                context.frame().addFrame("age", context.build(34));
                context.frame().addFrame("sex", context.build(context.source().sex));
            }
        };
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
        return new Condition(name,parameter);
    }

    private Condition not(Condition condition) {
        return new Condition.Negated(condition);
    }

    private Mark mark(String name, String... options) {
        return new Mark(name, options);
    }

    private Formatter customFormatter() {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return value.toString().length();
            }
        };
    }

    private Person person() {
        return new Person("Pau Gasol", date(1980, Calendar.JULY, 6), "Spain", Sex.Male);
    }

    private Date date(int year, int month, int day) {
        return new GregorianCalendar(year,month,day).getTime();
    }

    private TemplateEngine ruleEngine() {
        return new TemplateEngine(Locale.ENGLISH, LineSeparator.LF);
    }

    private enum Sex {
        Male
    }
    
    private String renderPerson(Rule... rules) {
        return ruleEngine().add(rules).render(person());
    }

    private String renderPersonWithNullAttributes(Rule... rules) {
        return ruleEngine().add(rules).render(new Person("Pau Gasol",null,null,null));
    }

    private String renderPersonWithCustomFormat(Rule... rules) {
        return ruleEngine().add("Custom", customFormatter()).add(rules).render(person());
    }

    private String renderPersonWithCustomConditionFunction(Rule... rules) {
        return ruleEngine().add("Custom", customConditionFunction()).add(rules).render(person());
    }

    private String renderPersonWithCustomAdapter(Rule... rules) {
        return ruleEngine().add(Person.class, customAdapter()).add(rules).render(person());
    }

    private String renderPersonExcludingField(Rule... rules) {
        return ruleEngine().add(Person.class, new ExcludeAdapter("birthday")).add(rules).render(person());
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


    private Rule valueRule() {
        return new Rule().
                add(condition("value", "Pau Gasol")).
                add(literal("*"), mark("value"), literal("*"));
    }

    private Rule sexRule() {
        return new Rule().
                add(condition("type", "Sex"), condition("value", "Male")).
                add(literal("a man"));
    }

    private Rule negatedConditionRule() {
        return new Rule().
                add(not(condition("type", "String"))).
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

    private Rule personRule() {
        return new Rule().
                add(condition("type", "Person")).
                add(new Mark("name"), literal(" was born in "), new Mark("country"), literal(" on "), mark("Birthday", "quoted", "ShortDate"));
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
                add(mark("Name","ShortDate"), literal(" was born in "), mark("Country"), literal(" on "), mark("Birthday", "ShortDate"));
    }


    private Rule personRuleWithDoubleFormatOnString() {
        return new Rule().
                add(condition("Type", "Person")).
                add(mark("Name","TwoDecimals", "Capitalize"), literal(" was born in "), mark("Country", "Letters", "LowerCase"), literal(" on "), mark("Birthday", "Separators", "ShortDate"));
    }

    private Rule personRuleWithTwoFormats() {
        return new Rule().
                add(condition("Type", "Person")).
                add(mark("Name","CamelCase","Plural"), literal(" was born in "), mark("Country"), literal(" on "), mark("Birthday", "ShortDate"));
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

}
