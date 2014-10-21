package org.siani.itrules;

import java.io.UnsupportedEncodingException;
import java.util.Stack;

class Buffer {
	private static final char NEW_LINE = '\n';
	private boolean replaced = false;
	private String content = "";
	private Stack<String> indentation = new Stack<>();

	public Buffer() {
		indentation.push("");
	}

	public boolean isUsed() {
		return replaced;
	}

	public void used() {
		replaced = true;
	}


	public void write(Buffer buffer) {
		content += buffer;
	}

	public void write(String text) {
		content += putIndents(text);
	}

	private String putIndents(String text) {
		String result = "";
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			result += chars[i];
			if (chars[i] == NEW_LINE && (i + 1 == chars.length || i + 1 < chars.length && chars[i + 1] != NEW_LINE))
				result += getAllIndentations();
		}
		return result;
	}

	private String getAllIndentations() {
		String result = "";
		for (String s : indentation) result += s;
		return result;
	}

	public void indent(String indent) {
		if (indent.length() > 0) this.indentation.push(indent);
	}

	public void dedent() {
		if (!indentation.isEmpty())
			this.indentation.pop();
	}

	public Stack<String> getIndentation() {
		return indentation;
	}

	@Override
	public String toString() {
		try {
			return new String(content.getBytes(), "UTF-8").replaceAll("\n(\t| )+\n", "\n\n").replace("\n\n\n", "\n\n");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}