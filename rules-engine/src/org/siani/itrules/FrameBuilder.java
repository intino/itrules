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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FrameBuilder {

    public static AbstractFrame build(Object object) {
        try {
            if (isPrimitive(object.getClass())) throw new RuntimeException("Object cannot be primitive");
            return createFrame(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static AbstractFrame createFrame(Object object) throws IllegalAccessException {
        List<String> allTypes = getAllTypes(object.getClass());
        Frame toReturn = new Frame(allTypes.toArray(new String[allTypes.size()]));
        fillSlots(object, toReturn);
        return toReturn;
    }

    private static List<String> getAllTypes(final Class<?> clazz) {
        final List<String> types = new ArrayList<String>() {{
            add(clazz.getSimpleName());
        }};
        for (Class<?> aInterface : clazz.getInterfaces()) types.addAll(getAllTypes(aInterface));
        if (clazz.getSuperclass() != null) types.addAll(getAllTypes(clazz.getSuperclass()));
        return types;
    }

    private static void fillSlots(Object object, Frame toReturn) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            boolean accessibility = field.isAccessible();
            field.setAccessible(true);
            if (isArray(field.getType())) fillAsArray(object, toReturn, field);
            else if (isList(field.getType())) fillAsList(object, toReturn, field);
            else if (isMap(field.getType())) fillAsMap(object, toReturn, field);
            else if (isPrimitive(field.getType())) fillAsPrimitive(object, toReturn, field);
            else fillAsComplexObject(object, toReturn, field);
            field.setAccessible(accessibility);
        }
    }

    private static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() ||
                String.class.isAssignableFrom(clazz) ||
                Byte.class.isAssignableFrom(clazz) ||
                Short.class.isAssignableFrom(clazz) ||
                Integer.class.isAssignableFrom(clazz) ||
                Long.class.isAssignableFrom(clazz) ||
                Float.class.isAssignableFrom(clazz) ||
                Double.class.isAssignableFrom(clazz) ||
                Boolean.class.isAssignableFrom(clazz) ||
                Character.class.isAssignableFrom(clazz);
    }

    private static boolean isMap(Class<?> clazz) {
        return Map.class.isAssignableFrom(clazz);
    }

    private static boolean isList(Class<?> clazz) {
        return List.class.isAssignableFrom(clazz);
    }

    private static boolean isArray(Class<?> clazz) {
        return clazz.isArray();
    }

    private static void fillAsArray(Object object, Frame toReturn, Field field) throws IllegalAccessException {
        for (Object o : (Object[]) field.get(object)) toReturn.addFrame(field.getName(), o);
    }

    private static void fillAsList(Object object, Frame toReturn, Field field) throws IllegalAccessException {
        for (Object o : (List<Object>) field.get(object))
            toReturn.addFrame(field.getName(), isPrimitive(o.getClass()) ? o : createFrame(o));
    }

    private static void fillAsMap(Object object, Frame toReturn, final Field field) throws IllegalAccessException {
        final Map<Object, Object> map = (Map<Object, Object>) field.get(object);
        toReturn.addFrame(field.getName(), new Frame(field.getName()) {{
            for (Object key : map.keySet())
                addFrame(key.toString(),
                    FrameBuilder.isPrimitive(map.get(key).getClass()) ? map.get(key) : createFrame(map.get(key)));
        }});
    }

    private static void fillAsPrimitive(Object object, Frame toReturn, Field field) throws IllegalAccessException {
        toReturn.addFrame(field.getName(), field.get(object));
    }

    private static void fillAsComplexObject(Object object, Frame toReturn, Field field) throws IllegalAccessException {
        Frame frame = new Frame(field.getName());
        fillSlots(field.get(object), frame);
        toReturn.addFrame(field.getName(), frame);
    }

}
