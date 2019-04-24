package io.intino.itrules.rules.output;

import io.intino.itrules.Rule;

public class Mark implements Rule.Output {
    private static final String OptionSeparator = "+";
    public static final Rule.Output This = new Mark("");

    private String name;
    private String[] formatters;
    private String separator = null;

    public Mark(String name, String... formatters) {
        this.name = name;
        this.formatters = formatters;
    }

    public String name() {
        return name;
    }

    public String[] formatters() {
        return formatters;
    }

    public String separator() {
        return separator;
    }

    public boolean isThis() {
        return name.isEmpty();
    }

    private boolean isMultiple() {
        return separator != null;
    }

    public String fullName() {
        StringBuilder result = new StringBuilder(name);
        for (String formatter : formatters) result.append(OptionSeparator).append(formatter);
        return result.toString();
    }

    public Mark multiple(String separator) {
        this.separator = separator;
        return this;
    }

    @Override
    public String toString() {
        return "[" + fullName() + (isMultiple() ? "..." : "") + "]";
    }

}
