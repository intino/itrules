package org.siani.itrules;

import java.io.UnsupportedEncodingException;

public final class Document {

	private StringBuilder content = new StringBuilder("");

	public void write(Buffer buffer) {
		content.append(buffer);
	}

	public String content() {
		try {
			String s = new String(content.toString().getBytes(), "UTF-8").replaceAll("\n(\t| )+\n", "\n\n");
			return s.replaceAll("(\\n(\\t| )*)+\\\\+\n", "\n").replaceAll("\\\\+\n?", "\n").replaceAll("\n(\t| )+\n", "\n\n");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
