package org.siani.itrules.engine.adapters;

import org.siani.itrules.Adapter;
import org.siani.itrules.model.Frame;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

public class DefaultAdapter<T> implements Adapter<T> {

    @Override
    public void execute(Frame frame, Object source, Context context) {
        new Filler(context).execute();
    }

    private class Filler {
        private final Context context;
		private final Frame frame;
        private final Object source;
        private final String Count = "Count";

        public Filler(Context context) {
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
                processFieldByType(field);
            field.setAccessible(accessibility);
        }

        private void processFieldByType(Field field) throws IllegalAccessException {
            if (isArray(field.getType())) processArray(field);
            else if (isList(field.getType())) processList(field);
            else if (isMap(field.getType())) processMap(field);
            else frame.addFrame(field.getName(), context.build(field.get(source)));
        }

        private void processArray(Field field) throws IllegalAccessException {
            Object[] objects = (Object[]) field.get(source);
            frame.addFrame(field.getName()+ Count, objects.length);
            for (Object item : objects)
				frame.addFrame(field.getName(), context.build(item));
        }

        private void processList(Field field) throws IllegalAccessException {
            List list = (List) field.get(source);
            frame.addFrame(field.getName()+ Count, list.size());
            for (Object item : list)
				frame.addFrame(field.getName(), context.build(item));
        }

        private void processMap(final Field field) throws IllegalAccessException {
            final Map map = (Map) field.get(source);
            frame.addFrame(field.getName() + Count, map.keySet().size());
            for (Object key : map.keySet())
				frame.addFrame(field.getName() + "." + key.toString(), context.build(map.get(key)));
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
