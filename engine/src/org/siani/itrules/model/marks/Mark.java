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

package org.siani.itrules.model.marks;

import org.siani.itrules.model.Literal;
import org.siani.itrules.model.Token;

public class Mark extends AbstractMark {
	private static final String NewLine = "\n";
	private static final String OptionSeparator = "+";

	private String name;
	private String[] options;
	private String separator = null;

	public Mark(String name, String... options) {
		this.name = name;
		this.options = options;
	}

	public Mark multiple(String separator) {
		this.separator = separator;
		return this;
	}

	@Override
	public String fullName() {
		return name + optionsText();
	}

	private String optionsText() {
		String result = "";
		for (String option : options) result += OptionSeparator + option;
		return result;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String separator() {
		return separator;
	}

	@Override
	public boolean isMultiple() {
		return separator != null;
	}

	@Override
	public String[] options() {
		return options;
	}

	@Override
	public String indentation() {
		return indentOf(previous);
	}

	private String indentOf(Token token) {
		return token == null ? "" : textOf(token).isEmpty() ? indentOf(token.previous()) : textOf(token);
	}

	private String textOf(Token token) {
		return token instanceof Literal ? extractIndent(((Literal) token).text()) : "";
	}

	private String extractIndent(String text) {
		if (text.contains(NewLine)) {
			final String[] split = text.substring(text.lastIndexOf(NewLine) + 1).split("[^\\s]");
			return split.length == 0 ? "" : split[0];
		} else return "";
	}

	@Override
	public String toString() {
		return "[" + name + (isMultiple() ? "..." : "") + "]";
	}
}
