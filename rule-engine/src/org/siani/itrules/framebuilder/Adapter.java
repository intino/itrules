package org.siani.itrules.framebuilder;

import org.siani.itrules.model.Frame;

public interface Adapter <T> {

	public void adapt(Frame frame, T object, BuilderContext context);

}