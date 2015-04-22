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

package org.siani.itrules.readers;

import org.siani.itrules.engine.logger.Logger;

import java.io.*;
import java.nio.charset.Charset;

final class RuleSetInputStream extends InputStream {

	private int index = 0;
	private byte[] content;

	public RuleSetInputStream(InputStream source, Charset charset) {
		try {
			content = read(source, charset).getBytes(charset);
		} catch (IOException e) {
			new Logger().log(e.getMessage());
			content = new byte[0];
		}
	}

	@Override
	public int read() throws IOException {
		return index >= content.length ? -1 : content[index++];
	}

	private String read(InputStream source, Charset charset) throws IOException {
		StringBuilder out = new StringBuilder();
		try (Reader in = new InputStreamReader(source, charset)) {
			read(in, out);
		}
		return new String(out.toString().getBytes(), charset);
	}

	private void read(Reader in, StringBuilder out) throws IOException {
		while (true) {
			int code = in.read();
			if (code < 0) break;
			out.append((char) code);
		}
	}

}
