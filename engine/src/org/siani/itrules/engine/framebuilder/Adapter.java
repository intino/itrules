package org.siani.itrules.engine.framebuilder;

import org.siani.itrules.model.Frame;

public interface Adapter <T> {

	public void adapt(Frame frame, T object, BuilderContext context);

}
