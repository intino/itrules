package org.siani.itrules.cases.framebuilder;

import java.util.List;

public class SimpleObjectWithComplexList {

    private final List<Object> field1;

    public SimpleObjectWithComplexList(List<Object> field1) {
        this.field1 = field1;
    }

    public Object get(int index) {
        return field1.get(index);
    }

}
