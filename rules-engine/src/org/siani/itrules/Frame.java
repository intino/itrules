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

import java.util.*;

public class Frame implements AbstractFrame {

	private final List<String> types;
	private final Map<String, List<AbstractFrame>> slots;

	public Frame(String... types) {
		this.slots = new LinkedHashMap<>();
		this.types = new ArrayList<>();
		for (String type : types)
			this.types.add(type.toLowerCase());
	}

	@Override
	public boolean is(String type) {
		return this.types.contains(type.toLowerCase());
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public Iterator<AbstractFrame> getSlots(String slot) {
		return (slots.get(slot) != null) ? slots.get(slot).iterator() : Collections.<AbstractFrame>emptyList().iterator();
	}

	public Frame addSlot(String slot, Object... values) {
		if (!slots.containsKey(slot))
			slots.put(slot, new ArrayList<AbstractFrame>());
		for (Object value : values)
			slots.get(slot).add((value instanceof AbstractFrame) ? (AbstractFrame) value : new PrimitiveFrame(value));
		return this;
	}

	@Override
	public Object value() {
		return null;
	}

	@Override
	public AbstractFrame findSlot(String path) {
		String name = path.contains(".") ? path.substring(0, path.indexOf(".")) : path;
		if (!slots.containsKey(name)) return null;
		List<AbstractFrame> slot = slots.get(name);
		return name.length() >= path.length() ? slot.get(0) :
			slot.get(0).findSlot(path.substring(path.indexOf(".")));
	}

	public AbstractFrame searchByType(String type, boolean deep) {
		return is(type) ? this : searchByType(slots.values(), type, deep);
	}

	public AbstractFrame searchByName(String name, boolean deep) {
		return getSlots(name).hasNext() ? this : searchByName(slots.values(), name, deep);
	}

	private AbstractFrame searchByType(Collection<List<AbstractFrame>> slots, String type, boolean deep) {
		for (List<AbstractFrame> slot : slots)
			for (AbstractFrame frame : slot)
				if (!frame.isPrimitive() && frame.is(type)) return frame;
				else if (!frame.isPrimitive() && deep) {
					AbstractFrame foundFrame = frame.searchByType(type, true);
					if (foundFrame != null) return foundFrame;
				}
		return null;
	}

	private AbstractFrame searchByName(Collection<List<AbstractFrame>> slots, String name, boolean deep) {
		for (List<AbstractFrame> slot : slots)
			for (AbstractFrame frame : slot)
				if (!frame.isPrimitive() && frame.getSlots(name) != null) return frame;
				else if (!frame.isPrimitive() && deep) {
					AbstractFrame foundFrame = frame.searchByName(name, true);
					if (foundFrame != null) return foundFrame;
				}
		return null;
	}
}
