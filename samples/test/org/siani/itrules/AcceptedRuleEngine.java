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
import org.siani.itrules.samples.Message;
import org.siani.itrules.samples.Person;
import org.siani.itrules.samples.Roster;

import java.io.*;

import static java.util.Calendar.APRIL;
import static java.util.Calendar.JULY;
import static java.util.Calendar.JUNE;
import static org.siani.itrules.samples.Message.*;
import static org.siani.itrules.samples.Person.birthday;
import static org.siani.itrules.samples.Roster.players;


public class AcceptedRuleEngine {

	private static final String Template = "res/engine/templates/$case.itr";
	private static final String Expected = "res/engine/expected/$case.txt";

    public static final Person Gasol = new Person("Pau Gasol", "Spain", birthday(1980, JULY, 6));
    public static final Person Orenga = new Person("Juan Antonio Orenga", "Spain", birthday(1966, JULY, 29));
    public static final Person Rudy = new Person("Rudy Fernandez", "Spain", birthday(1985, APRIL, 4));
    public static final Person Navarro = new Person("Juan Carlos Navarro", "Spain", birthday(1908, JUNE, 17));


    public static final Message Frodo =
            new Message(
                    from("frodo@hobbiton.me"),
                    to("gandalf@elrond.me","bilbo@hobbiton.me"),
                    subject("The ring"),
                    text("I wish the Ring had never come to me.","I wish none of this had happened.")
            );

    public static final Roster Spain = new Roster(Orenga, players(Gasol, Rudy, Navarro));


    @Test
    public void should_render_template_with_marks_and_formatters() throws Exception {
        Assert.assertEquals(expected("Person"), ruleEngine(template("Person")).render(Gasol).content());
    }

    @Test
    public void should_render_template_with_multiple_marks() throws Exception {
        Assert.assertEquals(expected("Message"), ruleEngine(template("Message")).render(Frodo).content());
    }

    @Test
    public void should_render_template_with_uppercase_marks_and_multiple_formatters() throws Exception {
        Assert.assertEquals(expected("Formatting"), ruleEngine(template("Formatting")).render(Gasol).content());
    }

    @Test
    public void should_render_template_with_optional_attributes() throws Exception {
        Assert.assertEquals(expected("OptionalAttributes"), ruleEngine(template("OptionalAttributes")).render(Spain).content());
    }

    private RuleEngine ruleEngine(String name) {
        return new RuleEngine().use(name);
    }

    private String jsonTemplate(String name) {
        return template(name) + ".json";
    }

    private String template(String name) {
        return Template.replace("$case", name);
    }

    private String expected(String name) throws IOException {
        return read(Expected.replace("$case", name));
    }

    private String read(String filename) throws IOException {
        return read(new BufferedReader(new FileReader(filename)));
    }

    private String read(BufferedReader reader) throws IOException {
        try {
            return readLines(reader, "");
        }
        finally {
            reader.close();
        }
    }

    private String readLines(BufferedReader reader, String text) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) text += line + "\n";
        return text.trim();
    }

}
