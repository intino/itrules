package org.siani.itrules.lang;

import java.io.*;
import java.nio.charset.StandardCharsets;

final class RuleSetInputStream extends InputStream {

	private static final String ENDRULE_FOR_USER = "\nendrule";
	private static final String ENDRULE_FOR_LEXER = "~";
	private int index = 0;
	private byte[] content;

	public RuleSetInputStream(InputStream source) {
		content = read(source).replace(ENDRULE_FOR_USER, ENDRULE_FOR_LEXER).getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public int read() throws IOException {
		return index >= content.length ? -1 : content[index++];
	}

	private String read(InputStream source) {
		StringBuilder out = new StringBuilder();
		try {
			Reader in = new InputStreamReader(source, "UTF-8");
			try {
				while (true) {
					int rsz = in.read();
					if (rsz < 0)
						break;
					out.append((char) rsz);
				}
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(out.toString().getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
