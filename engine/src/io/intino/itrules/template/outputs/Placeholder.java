/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.template.outputs;

import io.intino.itrules.template.Output;

public class Placeholder implements Output {
	private static final String OptionSeparator = "+";
	public static final String THIS = "this";
	public static final Output This = new Placeholder("");

	private final boolean isThis;
	private final String name;
	private final String[] formatters;
	private final String[] targetPath;

	private String separator = null;

	public Placeholder(String name, String... formatters) {
		this(name, null, formatters);
	}

	public Placeholder(String name, String[] targetPath, String... formatters) {
		this.isThis = name.equals(THIS) || name.isEmpty();
		this.name = this.isThis ? "" : name;
		this.targetPath = targetPath;
		this.formatters = formatters;
	}

	public String name() {
		return name;
	}

	public String[] targetPath() {
		return targetPath;
	}

	public String[] formatters() {
		return formatters;
	}

	public String separator() {
		return separator;
	}

	public boolean isThis() {
		return isThis;
	}

	private boolean isMultiple() {
		return separator != null;
	}

	public String fullName() {
		StringBuilder result = new StringBuilder(name);
		if (targetPath != null) result.append("<").append(String.join(".", targetPath)).append(">");
		for (String formatter : formatters) result.append(OptionSeparator).append(formatter);
		return result.toString();
	}

	public Placeholder multiple(String separator) {
		this.separator = separator;
		return this;
	}

	@Override
	public String toString() {
		return "$" + fullName() + (isMultiple() ? "...[" + (separator != null ? separator : ":") + "]" : "");
	}
}