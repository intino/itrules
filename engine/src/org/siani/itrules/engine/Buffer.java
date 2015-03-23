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

package org.siani.itrules.engine;

import java.util.Stack;

public class Buffer {
	private static final char NEW_LINE = '\n';
	private boolean replaced = false;
	private StringBuilder content = new StringBuilder("");
	private Stack<String> indentation = new Stack<>();

	public Buffer() {
		indentation.push("");
	}

	public boolean isUsed() {
		return replaced;
	}

	public void used() {
		replaced = true;
	}


	public void write(Buffer buffer) {
		content.append(buffer);
	}

	public void write(String text) {
		content.append(putIndents(text));
	}

	private String putIndents(String text) {
		String result = "";
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			result += chars[i];
			if (chars[i] == NEW_LINE && (i + 1 == chars.length || i + 1 < chars.length && chars[i + 1] != NEW_LINE))
				result += getAllIndentations();
		}
		return result;
	}

	private String getAllIndentations() {
		String result = "";
		for (String s : indentation) result += s;
		return result;
	}

	public void indent(String indent) {
		if (indent.length() > 0) this.indentation.push(indent);
	}

	public void dedent() {
		if (!indentation.isEmpty())
			this.indentation.pop();
	}

	public Stack<String> getIndentation() {
		return indentation;
	}

	@Override
	public String toString() {
		return content.toString();
	}
}