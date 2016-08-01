package org.siani.itrules.engine;

import org.siani.itrules.Adapter;
import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;

public interface Context {
    Frame frame();
    AbstractFrame build(Object object);
    <S> void register(Class<S> aClass, Adapter<S> adapter);

}
