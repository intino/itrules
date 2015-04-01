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

package org.siani.itrules.model;

public class Condition {

	public static final String TYPE = "type";
	public static final String TRIGGER = "trigger";
	public static final String SLOT_NAME = "slot-name";
	public static final String SLOT_TYPE = "slot-type";
	public static final String EVAL = "eval";
	private final String name;
	private String[] parameters;

	public Condition(String name, String... parameters) {
		this.name = name;
		this.parameters = parameters;
	}

	public String name() {
		return this.name;
	}

	public String[] getParameters() {
		return parameters;
	}

	public boolean is(String type) {
		return name().equals(type);
	}

	public boolean negated() {
		return false;
	}

	public static class Negated extends Condition {

		public Negated(String name, String... parameters) {
			super(name, parameters);
		}

		public boolean negated() {
			return true;
		}
	}
}
