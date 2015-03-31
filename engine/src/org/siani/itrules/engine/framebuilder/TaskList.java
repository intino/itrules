package org.siani.itrules.engine.framebuilder;

import org.siani.itrules.engine.FrameBuilder;

import java.util.ArrayList;
import java.util.List;

public final class TaskList {

    private List<FrameBuilder.Adapter> adapters;

    public TaskList(FrameBuilder.Adapter defaultAdapter) {
        this.adapters = new ArrayList<>();
        this.adapters.add(defaultAdapter);
    }

    public void add(FrameBuilder.Adapter adapter) {
        adapters.add(0, adapter);
    }

    public FrameBuilder.Adapter get(int index) {
        return adapters.get(index);
    }
}
