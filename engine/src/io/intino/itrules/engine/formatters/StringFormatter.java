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

package io.intino.itrules.engine.formatters;

import io.intino.itrules.Formatter;

import java.util.HashMap;
import java.util.Map;

public final class StringFormatter {

	private static Map<String, Formatter> map = null;

	public static Map<String, Formatter> get() {
		if (map == null) createFormatters();
		return map;
	}

	private static void createFormatters() {
		map = new HashMap<>();
		add("UpperCase", upperCase());
		add("LowerCase", lowerCase());
		add("FirstUpperCase", firstUpperCase());
		add("FirstLowerCase", firstLowerCase());
		add("Camelcase", camelCase());
		add("LowerCamelCase", lowerCamelCase());
		add("SnakeCase", snakeCase());
		add("Capitalize", capitalize());
		add("Length", length());
	}

	private static void add(String name, Formatter formatter) {
		map.put(name.toLowerCase(), formatter);
	}

	public static Formatter upperCase() {
		return value -> value.toString().toUpperCase();
	}

	public static Formatter lowerCase() {
		return value -> value.toString().toLowerCase();
	}

	public static Formatter camelCase() {
		return value -> {
			String[] parts = value.toString().split(" ");
			String result = "";
			for (String part : parts) result = result + capitalize().format(part);
			return result;
		};
	}

	public static Formatter lowerCamelCase() {
		return value -> {
			String[] parts = value.toString().split(" ");
			String result = "";
			for (String part : parts)
				result = result + capitalize().format(part);
			return result.substring(0, 1).toLowerCase() + result.substring(1);
		};
	}

	public static Formatter snakeCase() {
		return value -> value.toString().toLowerCase().replaceAll(" ", "-");
	}

	public static Formatter firstUpperCase() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1);
	}

	public static Formatter firstLowerCase() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toLowerCase() + value.toString().substring(1);
	}

	public static Formatter capitalize() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1).toLowerCase();
	}

	public static Formatter length() {
		return value -> String.valueOf(value.toString().length());
	}
}
