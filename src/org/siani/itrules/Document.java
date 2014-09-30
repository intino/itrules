package org.siani.itrules;

public final class Document {

	private String content = "";

	public void write(Buffer buffer) {
		content += buffer;
	}

	public String content() {
		return content;
	}
}
