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
	private Map<Class, Adapter> adapters;
	private Object value;

	public static FrameBuilder from(FrameBuilderContext context) {
		FrameBuilder builder = new FrameBuilder();
		if (context instanceof FrameBuilder) builder.adapters = ((FrameBuilder) context).adapters;
		if (context instanceof WrapBuilder) builder.adapters = ((WrapBuilder) context).builder.adapters;
		return builder;
	}

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

	private static boolean isPrimitive(Object object) {
		return isPrimitive(object.getClass());
	}

	private static boolean isPrimitive(Class aClass) {
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
		return types.contains(type.toLowerCase());
	}

	public FrameBuilder type(String type) {
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
		if (object.getClass().isArray())
			objectsIn(object).forEach(o->get(slot).add(frameOf(o)));
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

	public FrameBuilder put(Map<Class, Adapter> adapters) {
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
		if (isPrimitive(object)) return new Primitive(object);
		if (object instanceof Frame) return (Frame) object;
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

	private Adapter adapterFor(Class aClass) {
		return adapters.getOrDefault(aClass, null);
	}

	private List<String> typesOf(Object object) {
		return classesOf(object).stream()
				.map(Class::getSimpleName)
				.map(String::toLowerCase)
				.collect(toList());
	}

	private List<Class> classesOf(Object object) {
		return classesOf(object.getClass());
	}

	private FrameBuilderContext context() {
		return new WrapBuilder();
	}

	private List<Class> classesOf(Class aClass) {
		List<Class> types = new ArrayList<>();
		if (aClass == null) return types;
		if (!aClass.getSimpleName().isEmpty()) types.add(aClass);
		types.addAll(classesOf(aClass.getSuperclass()));
		types.addAll(interfacesOf(aClass));
		return types;
	}

	private List<Class> interfacesOf(Class aClass) {
		List<Class> interfaces = new ArrayList<>();
		for (Class aInterface : aClass.getInterfaces()) interfaces.addAll(classesOf(aInterface));
		return interfaces;
	}


	private static class Composite implements Frame {
		private final List<String> types;
		private final Map<String, List<Frame>> slots;

		public Composite(List<String> types, Map<String, List<Frame>> slots) {
			this.types = types;
			this.slots = slots;
		}

		@Override
		public boolean is(String type) {
			return checkType(type.toLowerCase());
		}

		private boolean checkType(String type) {
			return types.stream().anyMatch(t -> t.equals(type));
		}

		@Override
		public boolean contains(String slot) {
			return slots.containsKey(slot.toLowerCase());
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
		public String toString() {
			return "Frame <" + join(",", slots.keySet()) + ">";
		}

	}

	private static class Primitive implements Frame {
		private final Object value;
		private final String type;

		public Primitive(Object value) {
			this.value = value;
			this.type = value.getClass().getSimpleName().toLowerCase();
		}

		@Override
		public boolean is(String type) {
			return type.toLowerCase().equals(this.type);
		}

		@Override
		public Iterator<Frame> frames(String slot) {
			return emptyIterator();
		}

		@Override
		public boolean contains(String slot) {
			return false;
		}

		@Override
		public Object value() {
			return value;
		}

		@Override
		public String toString() {
			return "Frame <" + value + ": " + type + ">";
		}
	}

	private class WrapBuilder implements FrameBuilderContext {
		private final FrameBuilder builder = FrameBuilder.this;

		@Override
		public FrameBuilderContext type(String type) {
			builder.type(type);
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
