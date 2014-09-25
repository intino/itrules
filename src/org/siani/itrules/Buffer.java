package org.siani.itrules;

class Buffer {
	private boolean replaced = false;
	String content = "";

	public boolean isReplaced() {
		return replaced;
	}

	public void replaced() {
		replaced = true;
	}


	public void write(Buffer buffer) {
		content += buffer;
	}

	public void write(String text) {
		content += text;
	}

	@Override
	public String toString() {
		return content;
	}
}