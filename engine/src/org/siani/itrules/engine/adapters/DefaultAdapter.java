package org.siani.itrules.engine.adapters;

import org.siani.itrules.Adapter;
import org.siani.itrules.model.Frame;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

public class DefaultAdapter<T> implements Adapter<T> {

    @Override
    public void execute(Frame frame, Object source, FrameContext context) {
        new Filler(context).execute();
    }

    private class Filler {
        private final FrameContext context;
		private final Frame frame;
        private final Object source;
        private final String Count = "Count";

        public Filler(FrameContext context) {
            this.context = context;
            this.frame = context.frame();
            this.source = context.source();
        }

        public void execute() {
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
                if (!fieldIsProcessable(field)) continue;
                processField(field);
            }
        }

        private void processField(Field field) throws IllegalAccessException {
            boolean accessibility = field.isAccessible();
            field.setAccessible(true);
            if(field.get(source) != null)
                processField(field.getName(), field.get(source));
            field.setAccessible(accessibility);
        }

        private void processField(String name, Object value) throws IllegalAccessException {
            if (isArray(value.getClass())) processArray(name, value);
            else if (isList(value.getClass())) processList(name, value);
            else if (isMap(value.getClass())) processMap(name, value);
            else frame.addFrame(name, context.build(value));
        }

        private void processArray(String name, Object value) throws IllegalAccessException {
            Object[] objects = (Object[]) value;
            frame.addFrame(name + Count, objects.length);
            for (Object item : objects)
				frame.addFrame(name, context.build(item));
        }

        private void processList(String name, Object value) throws IllegalAccessException {
            List list = (List) value;
            frame.addFrame(name + Count, list.size());
            for (Object item : list)
				frame.addFrame(name, context.build(item));
        }

        private void processMap(String name, Object value) throws IllegalAccessException {
            final Map map = (Map) value;
            frame.addFrame(name + Count, map.keySet().size());
            for (Object key : map.keySet())
				frame.addFrame(name + "." + key.toString(), context.build(map.get(key)));
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

    protected boolean fieldIsProcessable(Field field) {
        return !(Modifier.isStatic(field.getModifiers()));
    }


}
