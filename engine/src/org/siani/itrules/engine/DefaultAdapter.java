package org.siani.itrules.engine;

import org.siani.itrules.engine.framebuilder.ExclusionList;
import org.siani.itrules.engine.framebuilder.AdapterContext;
import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.PrimitiveFrame;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;
import java.util.Map;

class DefaultAdapter implements FrameBuilder.Adapter {

    private ExclusionList exclusionList;

    public DefaultAdapter(ExclusionList exclusionList) {
        this.exclusionList = exclusionList;
    }

    @Override
    public void execute(AdapterContext context) {
        new Filler(context).execute();
    }

    private class Filler {
        private final AdapterContext context;
		private final Frame frame;
        private final Object source;

        public Filler(AdapterContext context) {
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
            if (isPrimitive(aClass)) throw new RuntimeException("Object cannot be primitive");
            while (aClass != null) {
                processClass(aClass);
                aClass = aClass.getSuperclass();
            }
        }

        private void processClass(Class aClass) throws IllegalAccessException {
            for (Field field : aClass.getDeclaredFields()) {
                if (!fieldIsProcessable(field, aClass)) continue;
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
            else frame.addFrame(field.getName(), createFrame(field.get(source)));
        }

        private AbstractFrame createFrame(Object object) throws IllegalAccessException {
            return isPrimitive(object.getClass()) ? createPrimitiveFrame(object) : createComplexFrame(object);
        }

        private PrimitiveFrame createPrimitiveFrame(Object object) {
			return new PrimitiveFrame(frame, object);
        }

        private AbstractFrame createComplexFrame(Object object) {
            return context.build(object);
        }

        private void processArray(Field field) throws IllegalAccessException {
            for (Object item : (Object[]) field.get(source))
				frame.addFrame(field.getName(), createFrame(item));
        }

        private void processList(Field field) throws IllegalAccessException {
            for (Object item : (List) field.get(source))
				frame.addFrame(field.getName(), createFrame(item));
        }

        private void processMap(final Field field) throws IllegalAccessException {
            final Map map = (Map) field.get(source);
            for (Object key : map.keySet())
				frame.addFrame(field.getName() + "." + key.toString(), createFrame(map.get(key)));
        }

        private boolean fieldIsProcessable(Field field, Class<?> aClass) {
            return !(Modifier.isStatic(field.getModifiers()) || exclusionList.isExcluded(aClass, field));
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
                    Character.class.isAssignableFrom(aClass);
        }

	}

}
