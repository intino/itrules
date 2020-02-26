package io.intino.itrules;

public interface FrameBuilderContext {
	FrameBuilderContext add(String type);
	boolean is(String type);

	FrameBuilderContext add(String slot, Object object);
	boolean contains(String slot);
	int slots();
}
