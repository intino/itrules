package io.intino.test;

import io.intino.test.templates.FormattingTemplate;
import io.intino.test.templates.MessageTemplate;
import io.intino.test.templates.RecursiveTemplate;
import io.intino.test.templates.RosterTemplate;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Templates_ {

    @Test
    public void should_render_formatting_template() {
        assertThat(new FormattingTemplate().render(new Person("Pau Gasol"))).isEqualTo(
                "Name: PAU GASOL\n" +
                "BirthYear: 1980\n" +
                "\n" +
                "Height: 208 (two hundred and eight) cm\n" +
                "Salary: $240,000");
    }

    @Test
    public void should_render_messaging_template() {
        assertThat(new MessageTemplate().render(new Message("frodo@gmail.com", to("bilbo@gmail.com","sam@yahoo.com"), "My ring", "I want my ring right now", "Otherwise I will make a new one"))).isEqualTo(
                "From: frodo@gmail.com\n" +
                "To: bilbo@gmail.com, sam@yahoo.com\n" +
                "\"My ring\"\n" +
                "\tI want my ring right now\n" +
                "\tOtherwise I will make a new one");
        assertThat(new MessageTemplate().render(new MessageTemplate().render(new Message("frodo@gmail.com", to(), null, "I want my ring right now", "Otherwise I will make a new one")))).isEqualTo(
                "From: frodo@gmail.com\n" +
                "To:\n" +
                "(No subject)\n" +
                "\tI want my ring right now\n" +
                "\tOtherwise I will make a new one");
    }

    @Test
    public void should_render_recursive_template() {
        assertThat(new RecursiveTemplate().render(composite())).isEqualTo(
                "<module name=\"X\">\n" +
                "\t<module name=\"1\">\n" +
                "\t\t<module name=\"1.1\"/>\n" +
                "\t\t<module name=\"1.2\">\n" +
                "\t\t\t<module name=\"1.2.1\"/>\n" +
                "\t\t\t<module name=\"1.2.2\"/>\n" +
                "\t\t\t<module name=\"1.2.3\"/>\n" +
                "\t\t</module>\n" +
                "\t\t<module name=\"1.3\"/>\n" +
                "\t\t<module name=\"1.4\"/>\n" +
                "\t</module>\n" +
                "\t<module name=\"2\">\n" +
                "\t\t<module name=\"2.1\"/>\n" +
                "\t\t<module name=\"2.2\"/>\n" +
                "\t\t<module name=\"2.3\"/>\n" +
                "\t\t<module name=\"2.4\"/>\n" +
                "\t\t<module name=\"2.5\"/>\n" +
                "\t\t<module name=\"2.6\"/>\n" +
                "\t</module>\n" +
                "\t<module name=\"3\">\n" +
                "\t\t<module name=\"3.1\"/>\n" +
                "\t\t<module name=\"3.2\"/>\n" +
                "\t\t<module name=\"3.3\"/>\n" +
                "\t</module>\n" +
                "\t<module name=\"4\">\n" +
                "\t\t<module name=\"4.1\"/>\n" +
                "\t\t<module name=\"4.2\"/>\n" +
                "\t</module>\n" +
                "\t<module name=\"5\"/>\n" +
                "</module>");

    }

    @Test
    public void should_render_roster_with_and_without_coach() {
        Roster roster = new Roster(
                new Person("Juan Antonio Orenga"),
                new Person("Pau Gasol"),
                new Person("Rudy Fernandez"),
                new Person("Juan Carlos Navarro")
        );
        assertThat(new RosterTemplate().render(roster)).isEqualTo(
                "<roster>\n" +
                "\t<coach name=\"Juan Antonio Orenga\"/>\n" +
                "\t<players>\n" +
                "\t\t<player name=\"Pau Gasol\"/>\n" +
                "\t\t<player name=\"Rudy Fernandez\"/>\n" +
                "\t\t<player name=\"Juan Carlos Navarro\"/>\n" +
                "\t</players>\n" +
                "</roster>");
        roster.coach = null;
        assertThat(new RosterTemplate().render(roster)).isEqualTo(
                "<roster>\n" +
                "\t<players>\n" +
                "\t\t<player name=\"Pau Gasol\"/>\n" +
                "\t\t<player name=\"Rudy Fernandez\"/>\n" +
                "\t\t<player name=\"Juan Carlos Navarro\"/>\n" +
                "\t</players>\n" +
                "</roster>");
    }

    public static class Roster {
        private Person coach;
        private Person[] players;

        public Roster(Person coach, Person... players) {
            this.coach = coach;
            this.players = players;
        }
    }    

    public static class Person {
        String name;
        LocalDate birthdate = LocalDate.of(1980, 10, 2);
        int height = 208;
        double Salary = 240000;

        public Person(String name) {
            this.name = name;
        }
    }

    public static class Message {
        private String from;
        private String[] to;
        private String subject;
        private String[] body;

        public Message(String from, String[] to, String subject, String... body) {
            this.from = from;
            this.to = to;
            this.subject = subject;
            this.body = body;
        }
    }

    private static Module composite() {
        return new Module("X",
                new Module("1",
                        new Module("1.1"),
                        new Module("1.2",
                                new Module("1.2.1"),
                                new Module("1.2.2"),
                                new Module("1.2.3")
                        ),
                        new Module("1.3"),
                        new Module("1.4")
                ),
                new Module("2",
                        new Module("2.1"),
                        new Module("2.2"),
                        new Module("2.3"),
                        new Module("2.4"),
                        new Module("2.5"),
                        new Module("2.6")

                ),
                new Module("3",
                        new Module("3.1"),
                        new Module("3.2"),
                        new Module("3.3")
                ),
                new Module("4",
                        new Module("4.1"),
                        new Module("4.2")
                ),
                new Module("5")
        );
    }

    public static class Module {
        private String name;
        private Module[] modules;

        public Module(String name, Module... modules) {
            this.name = name;
            this.modules = modules;
        }
    }

    private static String[] to(String... recipients) {
        return recipients;
    }


}
