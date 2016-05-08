package org.siani.itrules.engine;

import org.siani.itrules.Adapter;
import org.siani.itrules.model.AbstractFrame;

public interface Context {
    AbstractFrame build(Object object);
    <S> void register(Class<S> aClass, Adapter<S> adapter);

}
