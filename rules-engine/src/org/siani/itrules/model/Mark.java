package org.siani.itrules.model;

public class Mark extends AbstractMark {
	private static final String NEW_LINE = "\n";
	private static final String OPTION_TOKEN = "+";
	private String name;
	private String[] options;
	private boolean multiple;
	private String separator;

	public Mark(String name) {
		this(name, null, false, null);
	}

	public Mark(String name, String[] options, boolean multiple, String separator) {
		this.name = name;
		this.options = (options != null) ? options : new String[0];
		this.multiple = multiple;
		this.separator = separator;
	}

	@Override
	public String getFullName() {
		return name + optionsToString();
	}

	private String optionsToString() {
		String result = "";
		for (String option : options) result += OPTION_TOKEN + option;
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSeparator() {
		return separator;
	}

	@Override
	public boolean isMultiple() {
		return multiple;
	}

	@Override
	public String[] getOptions() {
		return options;
	}

	@Override
	public String getIndentation() {
		return prevToken() instanceof Literal ? calculateIndentation(prevToken()) : "";
	}

	private String calculateIndentation(Token token) {
		int i = token.as(Literal.class).literal().lastIndexOf(NEW_LINE);
		if (i < 0) return "";
		String[] split = ((Literal) token).literal().substring(i).split(NEW_LINE);
		return split.length > 1 ? split[1] : "";
	}

	@Override
	public String toString() {
		return name + (multiple ? "List" : "");
	}
}
