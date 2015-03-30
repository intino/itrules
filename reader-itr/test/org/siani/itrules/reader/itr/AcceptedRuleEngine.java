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

package org.siani.itrules.reader.itr;

import org.junit.Test;
import org.siani.itrules.Document;
import org.siani.itrules.RuleEngine;
import org.siani.itrules.engine.RuleSet;

import java.io.*;

import static org.junit.Assert.*;
import static org.siani.itrules.cases.FrameRepository.frames;
import static org.siani.itrules.cases.ObjectRepository.objects;

public class AcceptedRuleEngine {

	private static final String Template = "test.res/engine/json-templates/$case.itr";
	private static final String Expected = "test.res/engine/expected/$case.txt";

    public AcceptedRuleEngine() {
    }

    @Test
	public void should_render_frames_using_itr_reader() throws Exception {
        for (String key : frames.keySet()) {
            System.out.println(key);
            RuleEngine ruleEngine = new RuleEngine(ruleSet(key));
            Document document = ruleEngine.render(frames.get(key));
            assertEquals(read(expected(key)), document.content().trim());
        }
	}

    @Test
	public void should_render_objects_using_itr_reader() throws Exception {
        for (String key : objects.keySet()) {
            System.out.println(key);
            RuleEngine ruleEngine = new RuleEngine(ruleSet(key));
            Document document = ruleEngine.render(objects.get(key));
            assertEquals(read(expected(key)), document.content().trim());
        }
    }


    private RuleSet ruleSet(String name) throws FileNotFoundException {
        return RuleSetReader.read(new FileInputStream(template(name)));
    }

    private String template(String name) {
        return Template.replace("$case", name);
    }

    private String expected(String name) {
        return Expected.replace("$case", name);
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
