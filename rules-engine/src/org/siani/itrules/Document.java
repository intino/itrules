package org.siani.itrules;

import java.io.UnsupportedEncodingException;

public final class Document {

	private static final String NL = "(\\r?\\n|\\r)";
	private static final String EMPTY_LINE_WITH_SLASH = "(" + NL + "(\\t| )*)\\\\(\\t| )*" + NL;
	private static final String EMPTY_LINE_WITH_TAB = NL + "(\t| )+" + NL;
	private StringBuilder content = new StringBuilder("");

	public void write(Buffer buffer) {
		content.append(buffer);
	}

	public String content() {
		try {
			String result = new String(content.toString().getBytes(), "UTF-8");
			String previous;
			do {
				previous = result;
				result = result.replaceAll(EMPTY_LINE_WITH_SLASH, "\n");
			} while (previous.length() > result.length());
			return result.replaceAll("\\\\", "").replaceAll(EMPTY_LINE_WITH_TAB, "\n\n");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
