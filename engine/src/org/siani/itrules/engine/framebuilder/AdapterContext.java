package org.siani.itrules.engine.framebuilder;

import org.siani.itrules.engine.FrameBuilder;
import org.siani.itrules.model.Frame;

public interface AdapterContext<T> {
	public T source();
	public Frame frame();

	public Frame build(Object object);
	public <S> void register(Class<S> aClass, FrameBuilder.Adapter<S> adapter);
	public void exclude(String aClass, String... fields);

}
