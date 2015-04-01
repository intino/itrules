package org.siani.itrules;

import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;

public interface Adapter<T> {
    public void execute(Context<T> context);

	interface Context<T> {
        public T source();
        public Frame frame();

        public AbstractFrame build(Object object);
        public <S> void register(Class<S> aClass, Adapter<S> adapter);
        public void exclude(Class aClass, String... fields);

    }
}
