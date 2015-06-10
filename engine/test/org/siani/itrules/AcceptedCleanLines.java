package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.*;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AcceptedCleanLines {

    @Test
    public void testName() throws Exception {
        assertThat(cleanEmptyLines("asd"), is("asd"));
        assertThat(cleanEmptyLines("   asd"), is("   asd"));
        assertThat(cleanEmptyLines("   \\\n"), is(""));
        assertThat(cleanEmptyLines("\t  \t    \\\n"), is(""));
        assertThat(cleanEmptyLines("asd\n\t  \t    \\\nqwe"), is("asd\nqwe"));
        assertThat(cleanEmptyLines("asd\n\t  \t    \\\n"), is("asd"));

    }

    private String cleanEmptyLines(String text) {
        String[] lines = text.split("\n");
        String result = "";
        for (String line : lines) result += cleanEmptyLine(line + "\n");
        return result.isEmpty() ? "" : result.substring(0, result.lastIndexOf("\n"));
    }

    private String cleanEmptyLine(String line) {
        return line.replaceAll("^\\s*\\\\\n", "");
    }

    @Test
    public void cleanEmptyLines() throws Exception {
        System.out.println(new TemplateEngine(Locale.ENGLISH, LineSeparator.LF).add(createRules()).render(new Person(new Person())));
    }

    class Person{
        String name = "Pau";
        Person person;

        public Person(){}

        public Person(Person person) {
            this.person = person;
        }
    }

    private Rule createRules() {
        return new Rule()
                .add(new Condition("type", "Person"))
                .add(new Expression().add(new Literal("name = ")).add(new Mark("name")))
                .add(new Literal("|:\n    "))
                .add(new Mark("person").multiple("\n"))
                .add(new Literal("|:"));
    }
}
