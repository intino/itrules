package org.siani.itrules;

import java.io.UnsupportedEncodingException;
import java.util.Stack;

class Buffer {
	private static final String NEW_LINE = "\n";
	private boolean replaced = false;
	String content = "";
	Stack<String> indentation = new Stack<>();

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
			if (chars[i] == '\n' &&((i + 1) == chars.length || ((i + 1) < chars.length && chars[i + 1] != '\n')))
				result += indentation.peek();
		}
		return result;
	}

	public void indent(String indent) {
		this.indentation.push(indent);
	}

	public void dedent() {
		this.indentation.pop();
	}

	@Override
	public String toString() {
		try {
			return new String(content.getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}