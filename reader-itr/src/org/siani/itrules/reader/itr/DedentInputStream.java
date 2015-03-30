/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 * Ronni Ancorini
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

class DedentInputStream extends InputStream {

	private int index = 0;
	private byte[] content;

	public DedentInputStream(InputStream inputStream) {
		content = dedent(toString(inputStream)).getBytes();
	}

	public String dedent(String content) {
		String[] rules = content.split("endrule");
		String dedentedContent = "";
		for (String rule : rules) dedentedContent += getContentToConcat(rule);
		return dedentedContent;
	}

	private String getContentToConcat(String rule) {
		if (!hasDefRuleLine(rule.split("\\n"))) return rule;
		rule = rule + "endrule";
		return (areAtLeastOneIndentationInAllLines(rule)) ? dedentRule(rule) : rule;
	}

	private boolean areAtLeastOneIndentationInAllLines(String rule) {
		for (String line : rule.split("\\n"))
			if (isPossibleDeleteTabInLine(line)) return false;
		return true;
	}

	private boolean isPossibleDeleteTabInLine(String line) {
		if (isNotAnEmptyLineOrDefinitionLine(line))
			if (!doLineStartWithTab(line)) return true;
		return false;
	}

	private boolean doLineStartWithTab(String line) {
		return line.startsWith("    ") || line.startsWith("\t");
	}

	private boolean isNotAnEmptyLineOrDefinitionLine(String line) {
		return !line.startsWith("defrule") && !line.startsWith("endrule") && !line.equals("");
	}

	private boolean hasDefRuleLine(String[] lines) {
		Pattern ruleInitializer = Pattern.compile("defrule");
		for (String line : lines)
			if (ruleInitializer.matcher(line).find()) return true;
		return false;
	}

	private String dedentRule(String rule) {
		String[] lines = rule.split("\\n");
		replaceTabsForEachLine(lines);
		return copyRemplacedLines(lines);
	}

	private void replaceTabsForEachLine(String[] lines) {
		for (int i = 0; i < lines.length; i++)
			lines[i] = lines[i].replaceFirst("    |\\t", "");
	}

	private String copyRemplacedLines(String[] lines) {
		String remplacedLines = "";
		for (String line : lines) remplacedLines += line + "\n";
		return remplacedLines.substring(0, remplacedLines.length() - 1);
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