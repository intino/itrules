package io.intino.itrules;

public interface FrameBuilderContext {
	FrameBuilderContext type(String type);
	boolean is(String type);

	FrameBuilderContext add(String slot, Object... objects);
	boolean contains(String slot);
	int slots();
}
