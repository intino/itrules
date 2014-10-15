package org.siani.itrules;

import java.util.Iterator;

public interface AbstractFrame {

	public boolean is(String type);

	public boolean isPrimitive();

	public Iterator<AbstractFrame> getSlots(String slot);

	public Object value();

	public AbstractFrame findSlot(String path);

	public AbstractFrame searchByType(String type, boolean deep);

	public AbstractFrame searchByName(String name, boolean deep);
}
