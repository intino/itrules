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

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import static org.siani.itrules.Document.LineSeparator.CRLF;
import static org.siani.itrules.Document.LineSeparator.LF;

public final class Document {

	public enum LineSeparator {LF, CRLF}

	private static final String NL = "(\\r?\\n|\\r)";
	private static final String EMPTY_LINE_WITH_SLASH = "(" + NL + "(\\t| )*)\\\\+(\\t| )*" + NL;
	private static final String TAB = "(\t| )";
	private static final String EMPTY_LINE_WITH_TAB = NL + TAB + "+" + NL;
	private final Charset charset;
	private final LineSeparator lineSeparator;

	private StringBuilder content = new StringBuilder("");

	public Document() {
		this(Charset.forName("UTF-8"), LF);
	}

	public Document(Charset charset, LineSeparator lineSeparator) {
		this.charset = charset;
		this.lineSeparator = lineSeparator;
	}

	public void write(Buffer buffer) {
		content.append(buffer);
	}

	public String content() {
		try {
			String result = new String(content.toString().getBytes(), "UTF-8").replaceAll(EMPTY_LINE_WITH_TAB, "\n\n");
			String previous;
			do {
				previous = result;
				result = result.replaceAll(EMPTY_LINE_WITH_SLASH, "\n");
			} while (previous.length() > result.length());
			if (result.startsWith("\\\n") || result.startsWith("\\\r\n") || result.startsWith("\\\r")) {
				result = result.replaceFirst(NL, "");
			}
			result = result.replaceAll(NL + TAB + "+" + "\\Z", "");
			result = result.replaceAll("\\\\", "").replaceAll(EMPTY_LINE_WITH_TAB, "\n\n");
			return new String(result.getBytes(), charset).replaceAll(NL, lineSeparator == CRLF ? "\r\n" : "\n");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
