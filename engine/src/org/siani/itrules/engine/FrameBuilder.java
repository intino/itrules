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
import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.PrimitiveFrame;

import java.util.*;

import static java.util.stream.Collectors.toList;

public final class FrameBuilder implements Context {

    private final Frame frame;
    private final Map<Class, Adapter> registers;

    public FrameBuilder() {
        this(new Frame(), new HashMap<>());
    }

    private FrameBuilder(Frame frame, Map<Class,Adapter> registers) {
        this.frame = frame;
        this.registers = registers;
    }

    @Override
    public AbstractFrame build(Object object) {
        return (isPrimitive(object) ? primitiveFrame(object) :
                isCollection(object) ? frame(new Collection(object)) : frame(object));
    }

    @Override
    public <T> void register(Class<T> aClass, Adapter<T> adapter) {
        registers.put(aClass,adapter);
    }

    private PrimitiveFrame primitiveFrame(Object object) {
        return new PrimitiveFrame(object);
    }

    private Frame frame(Object object) {
        if (object instanceof Frame) return (Frame) object;
        frame.addTypes(typesOf(object)).addSlots(slotsOf(object));
        return frame;
    }

    @SuppressWarnings("unchecked")
    private SlotSet slotsOf(Object object) {
        return adapterFor(object).slotsOf(object, new Context() {
            @Override
            public AbstractFrame build(Object object) {
                return new FrameBuilder(new Frame(),registers).build(object);
            }

            @Override
            public <S> void register(Class<S> aClass, Adapter<S> adapter) {
                FrameBuilder.this.register(aClass,adapter);
            }
        });
    }

    private Adapter adapterFor(Object object) {
        List<Adapter> adapters = classesOf(object).stream().map(this::adapterFor).collect(toList());
        for (Adapter adapter : adapters) if (adapter != null) return adapter;
        return new DefaultAdapter();
    }

    private Adapter adapterFor(Class aClass) {
        return registers.containsKey(aClass) ? registers.get(aClass) : null;
    }

    private List<String> typesOf(Object object) {
        return classesOf(object).stream().map(Class::getSimpleName).collect(toList());
    }

    private List<Class> classesOf(Object object) {
        return classesOf(object.getClass());
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

    private boolean isPrimitive(Object object) {
        return isPrimitive(object.getClass());
    }

    private boolean isPrimitive(Class aClass) {
        return
                aClass.isPrimitive() ||
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

    private boolean isCollection(Object object) {
        return isCollection(object.getClass());
    }

    private boolean isCollection(Class<?> aClass) {
        return
                Map.class.isAssignableFrom(aClass) ||
                List.class.isAssignableFrom(aClass) ||
                aClass.isArray();
    }

    private class Collection {
        final Object items;

        private Collection(Object items) {
            this.items = items;
        }
    }

}
