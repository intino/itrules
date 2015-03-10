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

import org.siani.itrules.model.Function;
import org.siani.itrules.model.Condition;

public final class OperatorFactory {

	public static Function get(Condition condition) {
		String[] parameters = condition.getParameters();
		if (condition.name().equals(Function.TYPE)) return new TypeFunction(parameters);
		else if (condition.name().equals(Function.TRIGGER)) return new TriggerFunction(parameters);
		else if (condition.name().equals(Function.SLOT_NAME)) return new SlotNameFunction(parameters);
		else if (condition.name().equals(Function.SLOT_TYPE)) return new SlotTypeFunction(parameters);
		else return new EvalFunction(parameters[0], parameters[1], parameters[2]);
	}
}
