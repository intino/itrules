package org.siani.itrules;

public interface Function {

	public static final String TYPE = "type";
	public static final String TRIGGER = "trigger";
	public static final String SLOT_NAME = "slot-name";
	public static final String SLOT_TYPE = "slot-type";
	public static final String EVAL = "eval";

	public boolean match(Trigger trigger);
}
