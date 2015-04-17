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
	private final Frame owner;

	public Frame(Frame owner) {
		this.types = createTypeSet();
		this.slots = createSlotMap();
		this.owner = owner;
	}

	public boolean is(String type) {
		return this.types.contains(type);
	}

	@Override
	public Frame owner() {
		return owner;
	}

	public String[] types() {
		return types.toArray(new String[types.size()]);
	}

	public String[] slots() {
		return slots.keySet().toArray(new String[slots.size()]);
	}

	public Iterator<AbstractFrame> frames(String slot) {
		return (slots.get(slot) != null) ? slots.get(slot).iterator() : Collections.<AbstractFrame>emptyList().iterator();
	}

	public Frame addTypes(String... types) {
		Collections.addAll(this.types, types);
		return this;
	}

	public Frame addFrame(String slot, AbstractFrame frame) {
		slots.get(slot).add(frame);
		return this;
	}

	public Frame addFrame(String slot, String value) {
		return addPrimitiveFrame(slot, value);
	}

	public Frame addFrame(String slot, Integer value) {
		return addPrimitiveFrame(slot, value);
	}

	public Frame addFrame(String slot, Double value) {
		return addPrimitiveFrame(slot, value);
	}

	public Frame addFrame(String slot, Date value) {
		return addPrimitiveFrame(slot, value);
	}

	private Frame addPrimitiveFrame(String slot, Object value) {
		slots.get(slot).add(new PrimitiveFrame(this, value));
		return this;
	}

	public boolean isPrimitive() {
		return false;
	}

	public Object value() {
		return null;
	}

	private static Map<String, List<AbstractFrame>> createSlotMap() {
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

	private static Set<String> createTypeSet() {
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
		return result;
	}

	@Override
	public String toString() {
		return types.toString().replace(", object","");
	}
}
