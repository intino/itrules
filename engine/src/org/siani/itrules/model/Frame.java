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

import java.util.*;

public class Frame implements AbstractFrame {

	private final Set<String> types;
	private final Map<String, List<AbstractFrame>> slots;
	private final Frame container;

	public Frame(Frame container, String... types) {
		this.types = createTypes(types);
		this.slots = createSlots();
		this.container = container;
	}

	public boolean is(String type) {
		return this.types.contains(type);
	}

	@Override
	public Frame container() {
		return container;
	}

	public String[] getTypes() {
		return types.toArray(new String[types.size()]);
	}

	public void add(String... types) {
		Collections.addAll(this.types, types);
	}

	public String[] getSlots() {
		return slots.keySet().toArray(new String[slots.size()]);
	}

	public boolean isPrimitive() {
		return false;
	}

	public Iterator<AbstractFrame> getFrames(String slot) {
		return (slots.get(slot) != null) ? slots.get(slot).iterator() : Collections.<AbstractFrame>emptyList().iterator();
	}

	public Frame addFrame(String slot, Object... values) {
//		if (containsNull(values)) throw new RuntimeException("Value of Slot '" + slot + "' has been Inserted as Null");
		for (Object value : values)
            slots.get(slot).add(frame(value));
		return this;
	}

	private AbstractFrame frame(Object value) {
		if (value instanceof Frame)
			return (Frame) value;
		return new PrimitiveFrame(this, value);
	}

	private boolean containsNull(Object[] values) {
		if (values == null) return true;
		for (Object value : values) if (value == null) return true;
		return false;
	}

	public Object value() {
		return null;
	}

	public AbstractFrame findFrame(String path) {
		String name = path.contains(".") ? path.substring(0, path.indexOf(".")) : path;
		if (!slots.containsKey(name)) return null;
		List<AbstractFrame> slot = slots.get(name);
		return name.length() >= path.length() ? slot.get(0) :
			slot.get(0).findFrame(path.substring(path.indexOf(".")));
	}

	public AbstractFrame searchByType(String type) {
		return is(type) ? this : searchByType(slots.values(), type, false);
	}

	public AbstractFrame deepSearchByType(String type) {
		return is(type) ? this : searchByType(slots.values(), type, true);
	}

	public AbstractFrame searchByName(String name) {
		return getFrames(name).hasNext() ? this : searchByName(slots.values(), name, false);
	}

	public AbstractFrame deepSearchByName(String name) {
		return getFrames(name).hasNext() ? this : searchByName(slots.values(), name, true);
	}

	private AbstractFrame searchByType(Collection<List<AbstractFrame>> slots, String type, boolean deep) {
		for (List<AbstractFrame> slot : slots)
			for (AbstractFrame frame : slot)
				if (!frame.isPrimitive() && frame.is(type)) return frame;
				else if (!frame.isPrimitive() && deep) {
					AbstractFrame foundFrame = frame.deepSearchByType(type);
					if (foundFrame != null) return foundFrame;
				}
		return null;
	}

	private AbstractFrame searchByName(Collection<List<AbstractFrame>> slots, String name, boolean deep) {
		for (List<AbstractFrame> slot : slots)
			for (AbstractFrame frame : slot)
				if (!frame.isPrimitive() && frame.getFrames(name) != null) return frame;
				else if (!frame.isPrimitive() && deep) {
					AbstractFrame foundFrame = frame.deepSearchByName(name);
					if (foundFrame != null) return foundFrame;
				}
		return null;
	}

	private static Map<String, List<AbstractFrame>> createSlots() {
		return new LinkedHashMap<String, List<AbstractFrame>>(){

			@Override
			public List<AbstractFrame> put(String key, List<AbstractFrame> value) {
				return super.put(key.toLowerCase(), value);
			}

			@Override
			public List<AbstractFrame> get(Object key) {
				if (!containsKey(key)) put(key.toString(), new ArrayList<AbstractFrame>());
				return super.get(key.toString().toLowerCase());
			}

			@Override
			public boolean containsKey(Object key) {
				return super.containsKey(key.toString().toLowerCase());
			}
		};
	}

	private static Set<String> createTypes(String[] types) {
		HashSet<String> result = new HashSet<String>() {
			@Override
			public boolean contains(Object o) {
				return super.contains(o.toString().toLowerCase());
			}

			@Override
			public boolean add(String s) {
				return super.add(s.toLowerCase());
			}
		};
		Collections.addAll(result, types);
		return result;
	}
}
