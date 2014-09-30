package org.siani.itrules;

import org.siani.itrules.lang.model.AbstractMark;

public final class Trigger {
	private final AbstractFrame frame;
	private AbstractMark mark;


	public Trigger(AbstractFrame frame, AbstractMark mark) {
		this.frame = frame;
		this.mark = mark;
	}

	@Override
	public String toString() {
		return frame.toString();
	}

	public AbstractFrame frame() {
		return frame;
	}

	public AbstractMark mark() {
		return mark;
	}
}
