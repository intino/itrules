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

public class Buffer {
	private static final char NEW_LINE = '\n';
	private boolean replaced = false;
	private StringBuilder content = new StringBuilder("");
	private String indentation;

	public Buffer(String indentation) {
		this.indentation = indentation;
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
		content.append(indent(text));
	}

	private String indent(String text) {
		return indent((text + "~").toCharArray());
	}

	private String indent(char[] data) {
		String result = "";
		for (int i = 0; i < data.length - 1; i++)
			result += data[i] + (data[i] == NEW_LINE && data[i + 1] != NEW_LINE ? indentation : "");
		return result;
	}

	@Override
	public String toString() {
		return content.toString();
	}
}