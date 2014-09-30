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
		content += text.replace(NEW_LINE, NEW_LINE + indentation.peek());
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