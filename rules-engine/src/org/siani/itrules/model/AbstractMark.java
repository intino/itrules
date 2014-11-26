package org.siani.itrules.model;

public abstract class AbstractMark extends Token {

	public abstract String getFullName();

	public abstract String getName();

	public abstract String getSeparator();

	public abstract boolean isMultiple();

	public abstract String[] getOptions();

	public abstract String getIndentation();
}
