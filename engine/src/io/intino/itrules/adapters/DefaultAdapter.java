package io.intino.itrules.adapters;

import io.intino.itrules.Adapter;
import io.intino.itrules.FrameBuilder;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.lang.reflect.Modifier.isStatic;
import static java.lang.reflect.Modifier.isTransient;

public class DefaultAdapter<T> implements Adapter<T> {

    @Override
    public void adapt(T source, FrameBuilder.Context context) {
        new SlotBuilder(source, context).create();
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
        private FrameBuilder.Context context;
        private Object source;

        SlotBuilder(Object source, FrameBuilder.Context context) {
            this.context = context;
            this.source = source;
        }

        void create() {
            try {
                execute(source.getClass());
            }
            catch (IllegalAccessException ignored) {
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
            else context.slot(name, context.build(value));
        }

        private void processArray(String name, Object value) {
            Object[] objects = (Object[]) value;
            context.slot(name + Count, context.build(objects.length));
            for (Object item : objects)
                context.slot(name, context.build(item));
        }

        private void processList(String name, Object value) {
            List list = (List) value;
            context.slot(name + Count, context.build(list.size()));
            for (Object item : list) {
                context.slot(name, context.build(item));
            }
        }

        private void processMap(String name, Object value) {
            final Map map = (Map) value;
            context.slot(name + Count, context.build(map.keySet().size()));
            for (Object key : map.keySet())
                context.slot(name, context.build(new Item(key, map.get(key))));
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

}
