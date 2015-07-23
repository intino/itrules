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

package org.siani.itrules.engine.formatters;

import org.siani.itrules.Formatter;

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
		add("Capitalize", capitalize());
		add("Length", length());
	}

	private static void add(String name, Formatter formatter) {
        map.put(name.toLowerCase(), formatter);
    }

    private static Formatter upperCase() {
		return value -> value.toString().toUpperCase();
	}

	private static Formatter lowerCase() {
		return value -> value.toString().toLowerCase();
	}

	private static Formatter camelCase() {
		return value -> {
            String[] parts = value.toString().split(" ");
            String caseString = "";
            for (String part : parts) caseString = caseString + capitalize().format(part);
            return caseString;
        };
	}

	private static Formatter lowerCamelCase() {
		return value -> {
            String[] parts = value.toString().split(" ");
            String caseString = "";
            for (String part : parts)
                caseString = caseString + capitalize().format(part);
            return caseString.substring(0, 1).toLowerCase() + caseString.substring(1);
        };
	}

	private static Formatter firstUpperCase() {
		return value -> value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1);
	}

	private static Formatter firstLowerCase() {
		return value -> value.toString().substring(0, 1).toLowerCase() + value.toString().substring(1);
	}

	private static Formatter capitalize() {
		return value -> value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1).toLowerCase();
	}

	private static Formatter length() {
		return value -> String.valueOf(value.toString().length());
	}


}
