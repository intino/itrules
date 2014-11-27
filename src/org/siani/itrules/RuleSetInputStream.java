/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.siani.itrules;

import java.io.*;
import java.nio.charset.StandardCharsets;

final class RuleSetInputStream extends InputStream {

	protected static final String ENDRULE_FOR_LEXER = "%%";
	private static final String ENDRULE_FOR_USER = "(\n|\r|\r\n)endrule";
	private int index = 0;
	private byte[] content;

	RuleSetInputStream(InputStream source) {
		content = read(source).replaceAll(ENDRULE_FOR_USER, ENDRULE_FOR_LEXER).getBytes(StandardCharsets.UTF_8);
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
