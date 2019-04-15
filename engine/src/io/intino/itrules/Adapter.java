package io.intino.itrules;

import io.intino.itrules.engine.Context;

public interface Adapter<T> {
    void adapt(T source, Context context);
}