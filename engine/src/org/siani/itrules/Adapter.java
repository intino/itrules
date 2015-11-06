package org.siani.itrules;

import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;

public interface Adapter<T> {
    void execute(Frame frame, T source, FrameContext<T> context);

    interface FrameContext<T> {
        T source();

        Frame frame();

        AbstractFrame build(Object object);

        <S> void register(Class<S> aClass, Adapter<S> adapter);

    }
}
