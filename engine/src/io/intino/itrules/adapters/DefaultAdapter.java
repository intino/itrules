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

package io.intino.itrules.adapters;

import io.intino.itrules.Adapter;
import io.intino.itrules.FrameBuilderContext;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.lang.reflect.Modifier.isStatic;
import static java.lang.reflect.Modifier.isTransient;

public class DefaultAdapter<T> implements Adapter<T> {

	@Override
	public void adapt(T source, FrameBuilderContext context) {
		new SlotBuilder(source, context).create();
	}

	private boolean isExcluded(Field field) {
		return isStatic(field.getModifiers()) ||
				isTransient(field.getModifiers()) ||
				isContextFieldOfInnerClass(field);
	}

	@SuppressWarnings("BooleanMethodIsAlwaysInverted")
	protected boolean isProcessable(Field field) {
		return !isExcluded(field);
	}

	private boolean isContextFieldOfInnerClass(Field field) {
		return field.getName().startsWith("this$");
	}

	private static class Item {
		Object key;
		Object value;

		Item(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}

	private class SlotBuilder {
		private static final String Count = "Count";
		private FrameBuilderContext context;
		private Object source;

		SlotBuilder(Object source, FrameBuilderContext context) {
			this.context = context;
			this.source = source;
		}

		void create() {
			try {
				execute(source.getClass());
			} catch (IllegalAccessException ignored) {
			}
		}

		private void execute(Class aClass) throws IllegalAccessException {
			while (aClass != null) {
				processClass(aClass);
				aClass = aClass.getSuperclass();
			}
		}

		private void processClass(Class aClass) throws IllegalAccessException {
			for (Field field : aClass.getDeclaredFields()) {
				if (!isProcessable(field)) continue;
				processField(field);
			}
		}

		private void processField(Field field) throws IllegalAccessException {
			boolean accessibility = field.isAccessible();
			field.setAccessible(true);
			if (field.get(source) != null) processField(field.getName(), field.get(source));
			field.setAccessible(accessibility);
		}

		private void processField(String name, Object value) {
			if (isArray(value.getClass())) processArray(name, value);
			else if (isList(value.getClass())) processList(name, value);
			else if (isMap(value.getClass())) processMap(name, value);
			else context.add(name, value);
		}

		private void processArray(String name, Object value) {
			Object[] objects = (Object[]) value;
			context.add(name + Count, objects.length);
			for (Object item : objects)
				context.add(name, item);
		}

		private void processList(String name, Object value) {
			List list = (List) value;
			context.add(name + Count, list.size());
			for (Object item : list) {
				context.add(name, item);
			}
		}

		private void processMap(String name, Object value) {
			final Map map = (Map) value;
			context.add(name + Count, map.keySet().size());
			for (Object key : map.keySet())
				context.add(name, new Item(key, map.get(key)));
		}

		private boolean isMap(Class<?> aClass) {
			return Map.class.isAssignableFrom(aClass);
		}

		private boolean isList(Class<?> aClass) {
			return List.class.isAssignableFrom(aClass);
		}

		private boolean isArray(Class<?> aClass) {
			return aClass.isArray();
		}
	}

}
