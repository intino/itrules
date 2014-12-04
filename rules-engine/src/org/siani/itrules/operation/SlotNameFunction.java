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

package org.siani.itrules.operation;

import org.siani.itrules.AbstractFrame;
import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

final class SlotNameFunction implements Function {

	private final String[] parameters;
	private static final int NAME = 0;

	public SlotNameFunction(String[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean match(Trigger trigger) {
		return trigger.frame().isPrimitive() ? parameters[NAME].equalsIgnoreCase("value") : searchName(trigger) != null;
	}

	private AbstractFrame searchName(Trigger trigger) {
		return parameters.length == 1 ? trigger.frame().searchByName(parameters[NAME]) : trigger.frame().deepSearchByName(parameters[NAME]);
	}
}
