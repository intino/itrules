package org.siani.itrules.lang.model;

public class Mark extends Token {

	private final String name;
	private boolean list;
	private String separator;
	private String format;

	public Mark(String name) {
		this(name, false, null);
	}

	public Mark(String name, boolean list) {
		this(name, list, "");
	}

	public Mark(String name, String separator) {
		this(name, true, separator);
	}

	public Mark(String name, boolean list, String separator) {
		this.name = name;
		this.list = list;
		this.separator = separator;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}

	public String getName() {
		return name;
	}

	public String getSeparator() {
		return separator;
	}

	public boolean isList() {
		return list;
	}

}
