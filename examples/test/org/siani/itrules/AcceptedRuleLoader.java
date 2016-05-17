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
import org.siani.itrules.cases.Message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import static org.siani.itrules.LineSeparator.LF;
import static org.siani.itrules.cases.Message.*;


public class AcceptedRuleLoader {

    public static final Message Message =
            new Message(
                    from("frodo@hobbiton.me"),
                    to("gandalf@elrond.me", "bilbo@hobbiton.me"),
                    subject("The ring"),
                    text("I wish the Ring had never come to me.", "I wish none of this had happened.")
            );
    private static final String Template = "templates/$case.itr";
    private static final String Expected = "res/$case.expected.txt";

    @Test
    public void should_render_template_with_multiple_marks() throws Exception {
        Assert.assertEquals(expected("Message"), templateEngine(template("Message")).render(Message));
    }

    private TemplateEngine templateEngine(String name) {
        return new TemplateEngine(Locale.ENGLISH, LF).use(new Source(name));
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
        } finally {
            reader.close();
        }
    }

    private String readLines(BufferedReader reader, String text) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) text += line + "\n";
        return text.trim();
    }


}
