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

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DedentInputStream extends InputStream {

	private int index = 0;
	private byte[] content;

	public DedentInputStream(InputStream inputStream) {
		content = dedent(toString(inputStream)).getBytes();
	}


	public byte[] getContent() {
		return content;
	}

	public String dedent(String content) {
		String[] rules = content.split("endrule");
		String dedentedContent = "";
		for (String rule : rules) dedentedContent += getContentToConcat(rule);
		return dedentedContent;
	}

	private String getContentToConcat(String rule) {
		if (getRuleDefinitionLine(rule.split("\\n")) == -1)
			return rule;
		return dedentRule(rule + "endrule");
	}

	private int getRuleDefinitionLine(String[] lines) {
		Pattern ruleInitializer = Pattern.compile("defrule");
		for (int i = 0; i < lines.length; i++)
			if (ruleInitializer.matcher(lines[i]).find()) return i;
		return -1;
	}

	private String dedentRule(String rule) {
		String[] lines = rule.split("\\n");
		replaceTabsForEachLine(lines);
		return copyRemplacedLines(lines);
	}

	private void replaceTabsForEachLine(String[] lines) {
		int numberOfTabs = getFirstContentLineTabsAmount(lines);
		if (numberOfTabs == 0) return;
		for (int j = 0; j < numberOfTabs; j++)
			for (int i = 0; i < lines.length; i++)
				lines[i] = lines[i].replaceFirst("    |\\t", "");
	}

	private int getFirstContentLineTabsAmount(String[] lines) {
		int ruleDefinitionLine = getRuleDefinitionLine(lines);
		return getFirstRuleContentLine(lines, ruleDefinitionLine);
	}

	private String copyRemplacedLines(String[] lines) {
		String remplacedLines = "";
		for (String line : lines) remplacedLines += line + "\n";
		return remplacedLines.substring(0, remplacedLines.length() - 1);
	}

	private int getFirstRuleContentLine(String[] lines, int ruleDefinitionLine) {
		int firstContentLine = ruleDefinitionLine + 1;
		while (lines[firstContentLine].replaceAll("    |\\t", "").equals(""))
			firstContentLine++;
		return getNumberOfTabs(lines[firstContentLine]);
	}

	private int getNumberOfTabs(String line) {
		int numberOfSpaces = 0;
		Pattern spaces = Pattern.compile("    |\\t");
		Matcher matcher = spaces.matcher(line);
		while (matcher.find()) numberOfSpaces++;
		return numberOfSpaces;
	}

	private String toString(InputStream inputStream) throws NullPointerException {
		Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
		String result = scanner.hasNext() ? scanner.next() : "";
		scanner.close();
		return result;
	}


	@Override
	public int read() throws IOException {
		return index >= content.length ? -1 : content[index++];
	}
}