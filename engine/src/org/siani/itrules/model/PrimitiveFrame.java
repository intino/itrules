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

import java.util.Collections;
import java.util.Iterator;

public class PrimitiveFrame implements AbstractFrame {
	private final Object value;
	private final Frame container;

	public PrimitiveFrame(Frame container, Object value) {
		this.value = value;
		this.container = container;
	}

	@Override
	public boolean is(String type) {
		return type.equalsIgnoreCase(value.getClass().getSimpleName());
	}

	@Override
	public Frame owner() {
		return this.container;
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

}
