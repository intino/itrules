package org.siani.itrules;

import org.siani.itrules.lang.model.Mark;

public final class Trigger {
	private final AbstractFrame frame;
	private Mark mark;

	public Trigger(AbstractFrame frame) {
		this.frame = frame;
	}

	public Trigger(AbstractFrame frame, Mark mark) {
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

	public Mark mark() {
		return mark;
	}
}
