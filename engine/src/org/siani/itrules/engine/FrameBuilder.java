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

import org.siani.itrules.engine.framebuilder.ExclusionList;
import org.siani.itrules.engine.framebuilder.AdapterContext;
import org.siani.itrules.model.Frame;

import java.util.ArrayList;
import java.util.List;

public final class FrameBuilder {

	private final Frame frame;
	private final ExclusionList exclusionList;
	private final List<AdapterRegister> adapterRegisterList;

	public static interface Adapter<T> {
		public void execute(AdapterContext<T> context);
	}

	private static interface AdapterRegister {
		boolean accept(Object object);
		Adapter adapter();
	}

	public FrameBuilder() {
		this(new Frame(null), new ExclusionList(), new ArrayList<AdapterRegister>());
	}

	private FrameBuilder(Frame frame, ExclusionList exclusionList, List<AdapterRegister> adapterRegisterList) {
		this.frame = frame;
		this.exclusionList = exclusionList;
		this.adapterRegisterList = adapterRegisterList;
	}

	public Frame build(Object object)  {
		fillTypes(object);
		fillSlots(object);
		return frame;
	}

	public <T> void register(final Class<T> aClass, final Adapter<T> adapter) {
		adapterRegisterList.add(0, new AdapterRegister() {
			@Override
			public boolean accept(Object object) {
				return aClass.equals(object.getClass());
			}

			@Override
			public Adapter adapter() {
				return adapter;
			}
		});
	}

	public void exclude(String aClass, String... fields) {
		exclusionList.exclude(aClass, fields);
	}

	private void fillTypes(Object object) {
		frame.addTypes(toArray(types(object)));
	}

	@SuppressWarnings("unchecked")
	private void fillSlots(Object object) {
		adapterFor(object).execute(createTaskContext(object));
	}

	private Adapter adapterFor(Object object) {
		//object.getClass()
		//object.getInterface();
		//object.super...
		return new DefaultAdapter(exclusionList);
	}

	private AdapterContext createTaskContext(final Object target) {
		return new AdapterContext() {
			@Override
			public Object source() {
				return target;
			}

			@Override
			public Frame frame() {
				return frame;
			}

			@Override
			public Frame build(Object object) {
				return new FrameBuilder(new Frame(frame), exclusionList, adapterRegisterList).build(object);
			}

			@Override
			public void register(Class aClass, FrameBuilder.Adapter adapter) {
				FrameBuilder.this.register(aClass, adapter);
			}

			@Override
			public void exclude(String aClass, String... fields) {
				FrameBuilder.this.exclude(aClass, fields);
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
		List<Class> types = new ArrayList<>();
		if (aClass == null) return types;
		types.add(aClass);
		types.addAll(types(aClass.getSuperclass()));
		for (Class aInterface : aClass.getInterfaces())
			types.addAll(types(aInterface));
		return types;
	}

}
