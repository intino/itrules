package org.siani.itrules;

public final class Document {

	String content = "";

	public void write(Buffer buffer) {
		content += buffer;
	}

	public String print() {
		return content;
	}
}
