package io.intino.itrules.engine;

import io.intino.itrules.Adapter;
import io.intino.itrules.model.AbstractFrame;
import io.intino.itrules.model.Frame;

public interface Context {
    Frame frame();
    AbstractFrame build(Object object);
    <S> void register(Class<S> aClass, Adapter<S> adapter);

}
