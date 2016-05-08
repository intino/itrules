package org.siani.itrules;

import org.siani.itrules.engine.Context;
import org.siani.itrules.engine.SlotSet;

public interface Adapter<T> {
    SlotSet slotsOf(T source, Context context);
}
