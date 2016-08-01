package org.siani.itrules;

import org.siani.itrules.engine.Context;

public interface Adapter<T> {
    void adapt(T source, Context context);
}
