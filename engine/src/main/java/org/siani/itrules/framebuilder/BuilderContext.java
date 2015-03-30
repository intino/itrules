package org.siani.itrules.framebuilder;

import org.siani.itrules.model.Frame;

public interface BuilderContext {
	public void exclude(String aClass, String... fields);
	public <T> void register(Class<T> aClass, Adapter<T> adapter);
	public Frame build(Object object);
	public void buildIn(Frame frame, String slot, Object object);
}
