package io.intino.itrules;

import java.util.Iterator;

public interface Frame {
    boolean is(String type);

    Iterator<Frame> frames(String slot);

    boolean contains(String slot);

    Object value();

}
