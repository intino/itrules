package org.siani.itrules.engine;

import org.siani.itrules.Adapter;
import org.siani.itrules.model.PrimitiveFrame;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.lang.reflect.Modifier.isStatic;
import static java.lang.reflect.Modifier.isTransient;

public class DefaultAdapter<T> implements Adapter<T> {

    private boolean isProcessable(Field field) {
        return !isExcluded(field);
    }

    private boolean isExcluded(Field field) {
        return
                isStatic(field.getModifiers()) ||
                isTransient(field.getModifiers()) ||
                isContextFieldOfInnerClass(field);
    }

    private boolean isContextFieldOfInnerClass(Field field) {
        return field.getName().startsWith("this$");
    }

    @Override
    public void adapt(T source, Context context) {
        context.frame().addSlots(new SlotBuilder(source, context).slots());
    }

    private static class Item {

        public Object key;
        public Object value;

        public Item(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private class SlotBuilder {
        private final Object source;
        private Context context;
        private SlotSet slots = SlotSet.create();
        private static final String Count = "Count";

        public SlotBuilder(Object source, Context context) {
            this.source = source;
            this.context = context;
        }

        public SlotSet slots() {
            try {
                execute(source.getClass());
            }
            catch (IllegalAccessException ignored) {
            }
            return slots;
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

        private void processField(String name, Object value) throws IllegalAccessException {
            if (isArray(value.getClass())) processArray(name, value);
            else if (isList(value.getClass())) processList(name, value);
            else if (isMap(value.getClass())) processMap(name, value);
            else slots.add(name, context.build(value));
        }

        private void processArray(String name, Object value) throws IllegalAccessException {
            Object[] objects = (Object[]) value;
            slots.add(name + Count, new PrimitiveFrame(objects.length));
            for (Object item : objects)
                slots.add(name, context.build(item));
        }

        private void processList(String name, Object value) throws IllegalAccessException {
            List list = (List) value;
            slots.add(name + Count, new PrimitiveFrame(list.size()));
            for (Object item : list)
                slots.add(name, context.build(item));
        }

        private void processMap(String name, Object value) throws IllegalAccessException {
            final Map map = (Map) value;
            slots.add(name + Count, new PrimitiveFrame(map.keySet().size()));
            for (Object key : map.keySet())
                slots.add(name, context.build(new Item(key, map.get(key))));
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
