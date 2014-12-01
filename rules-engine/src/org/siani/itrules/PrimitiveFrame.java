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

package org.siani.itrules;

import java.util.Collections;
import java.util.Iterator;

class PrimitiveFrame implements AbstractFrame {
	private static final String VALUE = "value";
	private final Object value;

	public PrimitiveFrame(Object value) {
		this.value = value;
	}

	@Override
	public boolean is(String type) {
		return type.equalsIgnoreCase(value.getClass().getSimpleName());
	}

	@Override
	public boolean isPrimitive() {
		return true;
	}

	@Override
	public Iterator<AbstractFrame> getSlots(String slot) {
		return Collections.<AbstractFrame>emptyList().iterator();
	}

	@Override
	public Object value() {
		return value;
	}

	@Override
	public AbstractFrame findSlot(String path) {
		return path.equalsIgnoreCase(VALUE) ? this : null;
	}

	@Override
	public AbstractFrame searchByType(String type, boolean deep) {
		return null;
	}

	@Override
	public AbstractFrame searchByName(String name, boolean deep) {
		return name.equalsIgnoreCase(VALUE) ? this : null;
	}
}