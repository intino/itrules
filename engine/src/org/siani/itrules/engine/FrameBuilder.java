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

import org.siani.itrules.Adapter;
import org.siani.itrules.engine.adapters.DefaultAdapter;
import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.PrimitiveFrame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class FrameBuilder {

	private final Frame frame;
	private final List<Register> registerList;

	public FrameBuilder() {
		this(new Frame(null), new ArrayList<Register>());
	}

	private FrameBuilder(Frame frame, List<Register> registerList) {
		this.frame = frame;
		this.registerList = registerList;
	}

	public AbstractFrame build(Object object)  {
		return (isPrimitive(object.getClass())) ?
			primitiveFrame(object) :
			frame(object);
	}

	private PrimitiveFrame primitiveFrame(Object object) {
		return new PrimitiveFrame(null, object);
	}

	private Frame frame(Object object) {
		if (object instanceof Frame) return (Frame) object;
		fillTypes(object);
		fillSlots(object);
		return frame;
	}

	public <T> void register(final Class<T> aClass, final Adapter<T> adapter) {
		registerList.add(0, new Register() {
			@Override
			public boolean accept(Class type) {
				return type.equals(aClass);
			}

			@Override
			public Adapter adapter() {
				return adapter;
			}
		});
	}

	private void fillTypes(Object object) {
		frame.addTypes(toArray(types(object)));
	}

	@SuppressWarnings("unchecked")
	private void fillSlots(Object object) {
		Adapter.FrameContext context = createTaskContext(object);
		adapterFor(object).execute(context.frame(), context.source(), context);
	}


	private Adapter adapterFor(Object object) {
        for (Class type : types(object.getClass())) {
            Adapter adapter = adapterFor(type);
            if (adapter != null) return adapter;
        }
		return new DefaultAdapter();
	}

    private Adapter adapterFor(Class type) {
        for (Register register : registerList) {
            if (register.accept(type)) return register.adapter();
        }
        return null;
    }


	private Adapter.FrameContext createTaskContext(final Object target) {
		return new Adapter.FrameContext() {
			@Override
			public Object source() {
				return target;
			}

			@Override
			public Frame frame() {
				return frame;
			}

			@Override
			public AbstractFrame build(Object object) {
				return isPrimitive(object.getClass()) ?
					new PrimitiveFrame(frame, object):
					new FrameBuilder(new Frame(frame), registerList).frame(object);
			}

			@Override
			public void register(Class aClass, Adapter adapter) {
				FrameBuilder.this.register(aClass, adapter);
			}

		};
	}

	private String[] toArray(List<String> types) {
		return types.toArray(new String[types.size()]);
	}

	private List<String> types(Object object) {
		List<String> result = new ArrayList<>();
		for (Class type : types(object.getClass()))
			result.add(type.getSimpleName());
		return result;
	}

	private List<Class> types(Class aClass) {
		if (aClass == null) return new ArrayList<>();
		final List<Class> types = new ArrayList<>();
		types.add(aClass);
		for (Class aInterface : aClass.getInterfaces()) types.addAll(types(aInterface));
		if (aClass.getSuperclass() != null) types.addAll(types(aClass.getSuperclass()));
		return types;
	}

    private static interface Register {
        boolean accept(Class aClass);
        Adapter adapter();
    }

	private boolean isPrimitive(Class aClass) {
		return aClass.isPrimitive() ||
				String.class.isAssignableFrom(aClass) ||
				Byte.class.isAssignableFrom(aClass) ||
				Short.class.isAssignableFrom(aClass) ||
				Integer.class.isAssignableFrom(aClass) ||
				Long.class.isAssignableFrom(aClass) ||
				Float.class.isAssignableFrom(aClass) ||
				Double.class.isAssignableFrom(aClass) ||
				Boolean.class.isAssignableFrom(aClass) ||
				Date.class.isAssignableFrom(aClass) ||
				Enum.class.isAssignableFrom(aClass) ||
				Character.class.isAssignableFrom(aClass);
	}

}
