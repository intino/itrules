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

import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Function;
import org.siani.itrules.model.Trigger;

final class SlotTypeFunction implements Function {
	private static final int TYPE = 0;
	private final String[] parameters;

	public SlotTypeFunction(String[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean match(Trigger trigger) {
		return !trigger.frame().isPrimitive() && searchFrame(trigger) != null;
	}

	private AbstractFrame searchFrame(Trigger trigger) {
		return parameters.length == 1 ?
			trigger.frame().searchByType(parameters[TYPE]) : trigger.frame().deepSearchByType(parameters[TYPE]);
	}
}