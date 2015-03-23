package org.siani.itrules.cases.object2frame;

import java.util.List;

public class SimpleObjectWithList {

    private final List<String> field1;
    private final List<Double> field2;

    public SimpleObjectWithList(List<String> field1, List<Double> field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
}
