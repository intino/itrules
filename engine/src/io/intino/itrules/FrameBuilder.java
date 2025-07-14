/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules;

import io.intino.itrules.adapters.DefaultAdapter;

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyIterator;
import static java.util.stream.Collectors.toList;

public final class FrameBuilder implements FrameBuilderContext {
	private final List<String> types;
	private final Map<String, List<Frame>> slots;
	private static Map<String, Primitive> cache;
	private Map<Class<?>, Adapter> adapters;
	private Object value;

	public FrameBuilder() {
		this.types = new ArrayList<>();
		this.slots = new HashMap<>();
		this.adapters = new HashMap<>();
	}

	public FrameBuilder(String... types) {
		this.types = toLowerCase(asList(types));
		this.slots = new HashMap<>();
		this.adapters = new HashMap<>();
	}

	public synchronized static void startCache() {
		cache = new HashMap<>();
	}

	public synchronized static void clearCache() {
		cache.clear();
	}

	public synchronized static void stopCache() {
		if (cache != null) cache.clear();
		cache = null;
	}

	public static FrameBuilder from(FrameBuilderContext context) {
		FrameBuilder builder = new FrameBuilder();
		if (context instanceof FrameBuilder) builder.adapters = ((FrameBuilder) context).adapters;
		if (context instanceof WrapBuilder) builder.adapters = ((WrapBuilder) context).builder.adapters;
		return builder;
	}

	private static boolean isPrimitive(Object object) {
		return isPrimitive(object.getClass());
	}

	private static boolean isPrimitive(Class<?> aClass) {
		return aClass.isPrimitive() ||
				String.class.isAssignableFrom(aClass) ||
				Byte.class.isAssignableFrom(aClass) ||
				Short.class.isAssignableFrom(aClass) ||
				Integer.class.isAssignableFrom(aClass) ||
				Long.class.isAssignableFrom(aClass) ||
				Float.class.isAssignableFrom(aClass) ||
				Double.class.isAssignableFrom(aClass) ||
				Boolean.class.isAssignableFrom(aClass) ||
				Temporal.class.isAssignableFrom(aClass) ||
				Enum.class.isAssignableFrom(aClass) ||
				Character.class.isAssignableFrom(aClass);
	}

	private List<String> toLowerCase(List<String> list) {
		return list.stream().map(String::toLowerCase).collect(toList());
	}

	public boolean is(String type) {
		return types.contains(type);
	}

	public FrameBuilder add(String type) {
		types.add(type.toLowerCase());
		return this;
	}

	public boolean contains(String slot) {
		return slots.containsKey(slot.toLowerCase());
	}

	@Override
	public int slots() {
		return slots.size();
	}

	@Override
	public FrameBuilder add(String slot, Object object) {
		if (object == null) return this;
		if (object.getClass().isArray())
			objectsIn(object).forEach(o -> get(slot).add(frameOf(o)));
		else
			get(slot).add(frameOf(object));
		return this;
	}

	private Stream<Object> objectsIn(Object object) {
		return stream((Object[]) object);
	}

	public FrameBuilder append(Object object) {
		addValueOf(object);
		addTypesOf(object);
		addSlotsOf(object);
		return this;
	}

	public FrameBuilder append(Frame frame) {
		//TODO
		return this;
	}

	public <T> FrameBuilder put(Class<T> aClass, Adapter<T> adapter) {
		adapters.put(aClass, adapter);
		return this;
	}

	public FrameBuilder put(Map<Class<?>, Adapter> adapters) {
		this.adapters = adapters;
		return this;
	}

	public Frame toFrame() {
		return value != null ? new Primitive(value) : new Composite(types, slots);
	}

	private void addValueOf(Object object) {
		if (!isPrimitive(object)) return;
		this.value = object;
	}

	private void addTypesOf(Object object) {
		if (isPrimitive(object)) return;
		this.types.addAll(typesOf(object));
	}

	private void addSlotsOf(Object object) {
		if (isPrimitive(object)) return;
		adapterFor(object).adapt(object, context());
	}

	private List<Frame> get(String slot) {
		slot = slot.toLowerCase();
		if (!slots.containsKey(slot)) slots.put(slot, new ArrayList<>());
		return slots.get(slot);
	}

	private Frame frameOf(Object object) {
		if (isPrimitive(object)) {
			if (cache != null) {
				Primitive primitive = cache.get(object.toString());
				if (primitive != null) return primitive;
				cache.put(object.toString(), primitive = new Primitive(object));
				return primitive;
			} else return new Primitive(object);
		}
		if (object instanceof Frame) return (Frame) object;
		if (object instanceof FrameBuilder) return ((FrameBuilder) object).toFrame();
		return build(object);
	}

	private Frame build(Object object) {
		return new FrameBuilder().put(adapters).append(object).toFrame();
	}

	@SuppressWarnings("unchecked")
	private Adapter<Object> adapterFor(Object object) {
		List<Adapter> adapters = classesOf(object).stream().map(this::adapterFor).collect(toList());
		for (Adapter adapter : adapters)
			if (adapter != null) return adapter;
		return new DefaultAdapter<>();
	}

	private Adapter adapterFor(Class<?> aClass) {
		return adapters.getOrDefault(aClass, null);
	}

	private List<String> typesOf(Object object) {
		return classesOf(object).stream()
				.map(Class::getSimpleName)
				.map(String::toLowerCase)
				.collect(toList());
	}

	private List<Class<?>> classesOf(Object object) {
		return classesOf(object.getClass());
	}

	private FrameBuilderContext context() {
		return new WrapBuilder();
	}

	private List<Class<?>> classesOf(Class<?> aClass) {
		List<Class<?>> types = new ArrayList<>();
		if (aClass == null) return types;
		if (!aClass.getSimpleName().isEmpty()) types.add(aClass);
		types.addAll(classesOf(aClass.getSuperclass()));
		types.addAll(interfacesOf(aClass));
		return types;
	}

	private List<Class<?>> interfacesOf(Class<?> aClass) {
		List<Class<?>> interfaces = new ArrayList<>();
		for (Class<?> aInterface : aClass.getInterfaces()) interfaces.addAll(classesOf(aInterface));
		return interfaces;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	private static class Composite implements Frame {
		private final List<String> types;
		private Frame container;
		private final Map<String, List<Frame>> slots;

		public Composite(List<String> types, Map<String, List<Frame>> slots) {
			this.types = types;
			this.slots = slots;
			slots.values().forEach(s -> s.forEach(f -> f.container(Composite.this)));
		}

		@Override
		public boolean is(String type) {
			return this.types.stream().anyMatch(t -> t.equals(type));
		}

		@Override
		public boolean contains(String slot) {
			return slots.containsKey(slot.toLowerCase());
		}

		@Override
		public Frame container() {
			return container;
		}

		public void container(Frame container) {
			this.container = container;
		}

		@Override
		public Iterator<Frame> frames(String slot) {
			return contains(slot) ? slots.get(slot.toLowerCase()).iterator() : emptyIterator();
		}

		@Override
		public Object value() {
			return null;
		}

		@Override
		public int hashCode() {
			int h = types.hashCode();
			for (String slot : sortedSlots())
				h = (31 * h + hashCodeOf(slot)) >>> 1;
			return h;
		}

		private List<String> sortedSlots() {
			List<String> list = new ArrayList<>(slots.keySet());
			list.sort(Comparator.naturalOrder());
			return list;
		}

		private int hashCodeOf(String slot) {
			Iterator<Frame> frames = frames(slot);
			int h = slot.hashCode();
			while (frames.hasNext()) {
				Frame frame = frames.next();
				h = (31 * h + frame.hashCode()) >>> 1;
			}
			return h;
		}

		@Override
		public String toString() {
			return "Frame <" + join(",", slots.keySet()) + ">";
		}

	}

	static class Primitive implements Frame {
		private final Object value;
		private final String type;
		private Frame container;
		private final static Map<Class<?>, String> types = new HashMap<>();

		public Primitive(Object value) {
			this.value = value;
			this.type = typeOf(value.getClass());
		}

		private String typeOf(Class<?> aClass) {
			if (!types.containsKey(aClass))
				types.put(aClass, aClass.getSimpleName().toLowerCase());
			return types.get(aClass);
		}

		@Override
		public boolean is(String type) {
			return type.equals(this.type);
		}

		@Override
		public Iterator<Frame> frames(String slot) {
			return emptyIterator();
		}

		@Override
		public boolean contains(String slot) {
			return false;
		}

		public void container(Frame container) {
			this.container = container;
		}

		@Override
		public Frame container() {
			return container;
		}

		@Override
		public Object value() {
			return value;
		}

		@Override
		public int hashCode() {
			return type.hashCode() + 31 * (value != null ? value.hashCode() : 0);
		}

		@Override
		public String toString() {
			return "Frame <" + value + ": " + type + ">";
		}


	}

	private class WrapBuilder implements FrameBuilderContext {
		private final FrameBuilder builder = FrameBuilder.this;

		@Override
		public FrameBuilderContext add(String type) {
			builder.add(type);
			return this;
		}

		@Override
		public boolean is(String type) {
			return builder.is(type);
		}

		@Override
		public FrameBuilderContext add(String slot, Object objects) {
			builder.add(slot, objects);
			return this;
		}

		@Override
		public boolean contains(String slot) {
			return builder.contains(slot);
		}

		@Override
		public int slots() {
			return builder.slots();
		}
	}
}
