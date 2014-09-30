package org.siani.itrules;

import java.util.Iterator;

public interface AbstractFrame {

	public boolean is(String type);

	public boolean isPrimitive();

	public Iterator<AbstractFrame> property(String property);

	public Object value();

	public AbstractFrame findProperty(String path);
}
