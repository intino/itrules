package io.intino.itrules;

public interface Adapter<T> {
	void adapt(T source, FrameBuilder.Context context);

}
