package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Condition;
import org.siani.itrules.model.Expression;
import org.siani.itrules.model.Literal;
import org.siani.itrules.model.Rule;
import org.siani.itrules.model.marks.Mark;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class LineCleaner {

    @Test
    public void test() throws Exception {
        assertThat(cleanEmptyLines("asd"), is("asd"));
        assertThat(cleanEmptyLines("   asd"), is("   asd"));
        assertThat(cleanEmptyLines("   \\\n"), is(""));
        assertThat(cleanEmptyLines("\t  \t    \\\n"), is(""));
        assertThat(cleanEmptyLines("asd\n\t  \t    \\\nqwe"), is("asd\nqwe"));
        assertThat(cleanEmptyLines("asd\n\t  \t    \\\n"), is("asd"));

    }

    @Test
    public void cleanEmptyLines() throws Exception {
        String expected =  "name = Pau\n" + "    name = Pau";
        assertEquals(expected, new TemplateEngine(Locale.ENGLISH, LineSeparator.LF).add(createRules()).render(new Person(new Person())));
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

    private Rule createRules() {
        return new Rule()
                .add(new Condition("type", "Person"))
                .add(new Expression().add(new Literal("name = ")).add(new Mark("name")))
                .add(new Literal("|>\n    "))
                .add(new Mark("person").multiple("\n"))
                .add(new Literal("|>"));
    }

    class Person {
        String name = "Pau";
        Person person;

        public Person() {
        }

        public Person(Person person) {
            this.person = person;
        }
    }
}
