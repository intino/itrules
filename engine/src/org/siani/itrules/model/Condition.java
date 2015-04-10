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

	private final String name;
	private final String parameter;
    protected boolean negated;

	public Condition(String name, String parameter) {
		this.name = name;
		this.parameter = parameter;
        this.negated = false;
    }

	public String name() {
		return this.name;
	}

	public String parameter() {
		return parameter;
	}

	public boolean is(String type) {
		return name().equals(type);
	}

    public boolean negated() {
        return negated;
    }

	public static class Negated extends Condition {

        public Negated(Condition condition) {
            super(condition.name, condition.parameter);
            this.negated = !condition.negated();
        }

	}
}
