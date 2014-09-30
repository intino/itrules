package org.siani.itrules;

public interface Function {

	public static final String TYPE = "type";
	public static final String TRIGGER = "trigger";
	public static final String ATTR = "attr";

	public boolean match(Trigger trigger);
}
