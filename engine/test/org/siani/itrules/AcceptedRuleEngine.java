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
import org.siani.itrules.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class AcceptedRuleEngine {

    @Test
    public void should_render_hello_world() throws Exception {
        Assert.assertEquals("Hello world",
                ruleEngine().render("Hello world").content());
    }

    @Test
    public void should_render_person_defining_a_rule() throws Exception {
        Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
                ruleEngine().add(personRule()).render(person()).content());
    }

    private Rule personRule() {
        return new Rule().
                add(condition("type", "Person")).
                add(new Mark("name"), literal(" was born in "), new Mark("country"), literal(" on "), mark("birthday", "shortdate"));
    }

    @Test
    public void should_render_person_defining_a_rule_with_uppercase_tokens() throws Exception {
        Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
                ruleEngine().add(personRuleUppercase()).render(person()).content());
    }

    private Rule personRuleUppercase() {
        return new Rule().
                add(condition("TYPE", "PERSON")).
                add(new Mark("NAME"), literal(" was born in "), new Mark("COUNTRY"), literal(" on "), mark("BIRTHDAY", "SHORTDATE"));
    }

    @Test
    public void should_render_person_defining_a_rule_with_formatted_marks() throws Exception {
        Assert.assertEquals("PAU GASOL was born in spain on 06/07/1980",
                ruleEngine().add(personRuleWithFormatMarks()).render(person()).content());
    }

    private Rule personRuleWithFormatMarks() {
        return new Rule().
                add(condition("Type", "Person")).
                add(mark("Name", "Uppercase"), literal(" was born in "), mark("Country", "Lowercase"), literal(" on "), mark("Birthday", "ShortDate"));
    }

    @Test
    public void should_render_person_defining_rule_with_a_trigger_condition() throws Exception {
        Assert.assertEquals("*Pau Gasol* was born in Spain on 06/07/1980",
                ruleEngine().add(personRule()).add(triggerConditionRule()).render(person()).content());
    }

    private Rule triggerConditionRule() {
        return new Rule().
                add(condition("Trigger", "Name")).
                add(literal("*"), mark("value"), literal("*"));
    }

    @Test
    public void should_render_person_defining_a_rule_with_a_custom_formatter() throws Exception {
        Assert.assertEquals("9 was born in 5 on 06/07/1980",
                ruleEngine().add(personRuleWithCustomFormat()).add("Custom", customFormatter()).render(person()).content());
    }

    private Rule personRuleWithCustomFormat() {
        return new Rule().
                add(condition("Type", "Person")).
                add(mark("Name", "Custom"), literal(" was born in "), mark("Country", "Custom"), literal(" on "), mark("Birthday", "ShortDate"));
    }

    @Test
    public void should_render_person_defining_rule_with_a_custom_condition_function() throws Exception {
        Assert.assertEquals("Pau Gasol was born in Spain on 06/07/1980",
                ruleEngine().add(personRuleWithCustomCondition()).add("Custom", customConditionFunction()).render(person()).content());
    }

    private Rule personRuleWithCustomCondition() {
        return new Rule().
                add(condition("Custom", "Gasol")).
                add(mark("Name", "Custom"), literal(" was born in "), mark("Country", "Custom"), literal(" on "), mark("Birthday", "ShortDate"));
    }

    @Test
    public void should_render_person_defining_rule_with_a_custom_adapter() throws Exception {
        Assert.assertEquals("Pau Gasol was born in Spain and he is 34 years old",
                ruleEngine().add(personRuleWithCustomAdapter()).add(Person.class, customAdapter()).render(person()).content());
    }

    private Rule personRuleWithCustomAdapter() {
        return new Rule().
                add(condition("Type", "Person")).
                add(mark("Name", "Custom"), literal(" was born in "), mark("Country", "Custom"), literal(" and he is "), mark("age"), literal(" years old"));
    }

    @Test
    public void should_render_person_excluding_a_field() throws Exception {
        Assert.assertEquals("Pau Gasol was born in Spain on ",
                ruleEngine().add(personRule()).exclude(Person.class, "birthday").render(person()).content());
    }

    private Adapter<Person> customAdapter() {
        return new Adapter<Person>() {
            @Override
            public void execute(Context<Person> context) {
                context.frame().addFrame("name", context.build(context.source().name));
                context.frame().addFrame("country", context.build(context.source().country));
                context.frame().addFrame("birthday", context.build(context.source().birthday));
                context.frame().addFrame("age", context.build(34));
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

    private Condition condition(String name, String parameter) {
        return new Condition(name,parameter);
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
        return new Person("Pau Gasol", date(1980, Calendar.JULY, 6), "Spain");
    }

    private Date date(int year, int month, int day) {
        return new GregorianCalendar(year,month,day).getTime();
    }

    private RuleEngine ruleEngine() {
        return new RuleEngine();
    }


    private class Person {
        private final String name;
        private final Date birthday;
        private final String country;

        public Person(String name, Date birthday, String country) {
            this.name = name;
            this.birthday = birthday;
            this.country = country;
        }
    }

}
