package org.siani.itrules.engine.adapters;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcludeAdapter<T> extends DefaultAdapter<T> {

    private final List<String> fields = new ArrayList<>();

    public ExcludeAdapter(String... fields) {
        Collections.addAll(this.fields, fields);
    }

    @Override
    protected boolean fieldIsProcessable(Field field) {
        return super.fieldIsProcessable(field) && !fields.contains(field.getName());
    }

}
