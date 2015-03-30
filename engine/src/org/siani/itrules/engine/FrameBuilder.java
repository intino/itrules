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

package org.siani.itrules.engine;

import org.siani.itrules.engine.framebuilder.Adapter;
import org.siani.itrules.engine.framebuilder.AdapterList;
import org.siani.itrules.engine.framebuilder.BuilderContext;
import org.siani.itrules.engine.framebuilder.ExclusionList;
import org.siani.itrules.model.Frame;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class FrameBuilder implements BuilderContext {

	private final ExclusionList exclusionList = new ExclusionList();
	private final AdapterList adapterList = new AdapterList();

	@Override
	public void exclude(String aClass, String... fields) {
		exclusionList.exclude(aClass, fields);
	}

	@Override
	public <T> void register(Class<T> aClass, Adapter<T> adapter) {
		adapterList.add(aClass, adapter);
	}

	@Override
	public Frame build(Object object) {
		if (isPrimitive(object.getClass())) throw new RuntimeException("Object cannot be primitive");
		return createFrame(object);
	}

	@Override
	public void buildIn(Frame frame, String slot, Object object) {
		if (isPrimitive(object.getClass())) throw new RuntimeException("Object cannot be primitive");
		Frame include = newFrame(frame, object);
		frame.addFrame(slot, include);
		try {
			fillSlots(object, include);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public Frame createFrame(Object object) {
		try {
			Frame toReturn = newFrame(null, object);
			fillSlots(object, toReturn);
			return toReturn;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Frame newFrame(Frame container, Object object) {
		List<String> allTypes = toString(getAllTypes(object.getClass()));
		return new Frame(container, allTypes.toArray(new String[allTypes.size()]));
	}

	private List<String> toString(List<Class<?>> allTypes) {
		List<String> result = new ArrayList<>();
		for (Class<?> allType : allTypes) result.add(allType.getSimpleName());
		return result;
	}

	private List<Class<?>> getAllTypes(final Class<?> clazz) {
		final List<Class<?>> types = new ArrayList<Class<?>>() {{
			add(clazz);
		}};
		for (Class<?> aInterface : clazz.getInterfaces()) types.addAll(getAllTypes(aInterface));
		if (clazz.getSuperclass() != null) types.addAll(getAllTypes(clazz.getSuperclass()));
		return types;
	}

	private <T> void fillSlots(T object, Frame toReturn) throws IllegalAccessException {
		Adapter<T> adapter = findAdapter(object);
		if (adapter != null) adapter.adapt(toReturn, object, this);
		else fillSlotsByDefault(object, toReturn);
	}

	private <T> Adapter<T> findAdapter(T object) {
		List<Class<?>> allTypes = getAllTypes(object.getClass());
		for (Class<?> type : allTypes) {
			if (!adapterList.contains(type)) continue;
			return adapterList.get(type);
		}
		return null;
	}

	private void fillSlotsByDefault(Object object, Frame toReturn) throws IllegalAccessException {
		Class<?> aClass = object.getClass();
		while (aClass != null) {
			fillSlotsForClass(aClass, object, toReturn);
			aClass = aClass.getSuperclass();
		}
	}

	private void fillSlotsForClass(Class<?> aClass, Object object, Frame toReturn) throws IllegalAccessException {
		if (adapterList.contains(aClass))
			adapterList.get(aClass).adapt(toReturn, object, this);
		else
			processFields(aClass, object, toReturn);
	}

	private void processFields(Class<?> aClass, Object object, Frame toReturn) throws IllegalAccessException {
		for (Field field : aClass.getDeclaredFields()) {
			if (fieldIsNotSerializable(aClass, field)) continue;
			boolean accessibility = field.isAccessible();
			field.setAccessible(true);
			processField(object, toReturn, field);
			field.setAccessible(accessibility);
		}
	}

	private boolean fieldIsNotSerializable(Class<?> aClass, Field field) {
		return Modifier.isStatic(field.getModifiers()) || exclusionList.isExcluded(aClass, field);
	}

	private void processField(Object object, Frame toReturn, Field field) throws IllegalAccessException {
		if (isArray(field.getType())) fillAsArray(object, toReturn, field);
		else if (isList(field.getType())) fillAsList(object, toReturn, field);
		else if (isMap(field.getType())) fillAsMap(object, toReturn, field);
		else if (isPrimitive(field.getType())) fillAsPrimitive(object, toReturn, field);
		else fillAsComplexObject(object, toReturn, field);
	}

	private boolean isPrimitive(Class<?> clazz) {
		return clazz.isPrimitive() ||
			String.class.isAssignableFrom(clazz) ||
			Byte.class.isAssignableFrom(clazz) ||
			Short.class.isAssignableFrom(clazz) ||
			Integer.class.isAssignableFrom(clazz) ||
			Long.class.isAssignableFrom(clazz) ||
			Float.class.isAssignableFrom(clazz) ||
			Double.class.isAssignableFrom(clazz) ||
			Boolean.class.isAssignableFrom(clazz) ||
			Date.class.isAssignableFrom(clazz) ||
			Character.class.isAssignableFrom(clazz);
	}

	private boolean isMap(Class<?> clazz) {
		return Map.class.isAssignableFrom(clazz);
	}

	private boolean isList(Class<?> clazz) {
		return List.class.isAssignableFrom(clazz);
	}

	private boolean isArray(Class<?> clazz) {
		return clazz.isArray();
	}

	private void fillAsArray(Object object, Frame toReturn, Field field) throws IllegalAccessException {
		for (Object o : (Object[]) field.get(object)) toReturn.addFrame(field.getName(), o);
	}

	private void fillAsList(Object object, Frame toReturn, Field field) throws IllegalAccessException {
		for (Object o : (List<Object>) field.get(object))
			toReturn.addFrame(field.getName(), isPrimitive(o.getClass()) ? o : createFrame(o));
	}

	private void fillAsMap(Object object, Frame toReturn, final Field field) throws IllegalAccessException {
		final Map<Object, Object> map = (Map<Object, Object>) field.get(object);
		toReturn.addFrame(field.getName(), new Frame(toReturn, field.getName()) {{
			for (Object key : map.keySet())
				addFrame(key.toString(),
					FrameBuilder.this.isPrimitive(map.get(key).getClass()) ? map.get(key) : createFrame(map.get(key)));
		}});
	}

	private void fillAsPrimitive(Object object, Frame toReturn, Field field) throws IllegalAccessException {
		toReturn.addFrame(field.getName(), field.get(object));
	}

	private void fillAsComplexObject(Object object, Frame toReturn, Field field) throws IllegalAccessException {
		Frame frame = new Frame(toReturn, field.getName());
		fillSlots(field.get(object), frame);
		toReturn.addFrame(field.getName(), frame);
	}
}
