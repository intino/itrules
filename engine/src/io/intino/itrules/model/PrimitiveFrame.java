/*
 * Copyright 2014
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

package io.intino.itrules.model;

import java.util.Collections;
import java.util.Iterator;

public class PrimitiveFrame implements AbstractFrame {
	private final Object value;
	private final String simpleName;

	public PrimitiveFrame(Object value) {
		this.value = value;
		this.simpleName = value.getClass().getSimpleName().toLowerCase();
	}

	@Override
	public boolean is(String type) {
		return type.length() == simpleName.length() && type.toLowerCase().equals(simpleName);
	}

	@Override
	public boolean isPrimitive() {
		return true;
	}

	@Override
	public Iterator<AbstractFrame> frames(String slot) {
		return Collections.<AbstractFrame>emptyList().iterator();
	}

	@Override
	public Object value() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
