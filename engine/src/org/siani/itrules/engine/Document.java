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

package org.siani.itrules.engine;

import org.siani.itrules.Encoding;

import java.io.UnsupportedEncodingException;

public final class Document {

	private final StringBuilder content;
    private final Encoding encoding;

    public Document(Encoding encoding) {
        this.content = new StringBuilder();
        this.encoding = encoding;
    }

    public void write(Buffer buffer) {
		content.append(buffer);
	}

	public String content() {
        return content.toString();//applyFormat(cleanEscapedChars(removeEmptyLines(text())));
	}

    private String applyFormat(String result) {
        return applyLineSeparator(applyCharset(result));
    }

    private String cleanEscapedChars(String result) {
        return cleanEscapedLines(cleanEscapedTokens(cleanEscapedFirstLines(result)));
    }

    private String removeEmptyLines(String text) {
        return removeEmptyLinesWithSlash(removeEmptyLinesWithTab(text));
    }

    private String text()  {
        try {
            return new String(content.toString().getBytes(), "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            return "";
        }
    }
    private static final String NewLine = "(\\r?\\n|\\r)";
    private static final String Tab = "(\t| )";
    private static final String EmptyLineWithSlash = "(" + NewLine + "(\\t| )*)\\\\+(\\t| )*" + NewLine;
    private static final String EmptyLineWithTab = NewLine + Tab + "+" + NewLine;

    private String applyCharset(String result) {
        return new String(result.getBytes(), encoding.charset());
    }

    private String applyLineSeparator(String result) {
        return result.replaceAll(NewLine, encoding.lineSeparator());
    }

    private String cleanEscapedFirstLines(String result) {
        if (result.startsWith("\\\n") || result.startsWith("\\\r\n") || result.startsWith("\\\r")) {
            result = result.replaceFirst(NewLine, "");
        }
        return result;
    }

    private String cleanEscapedLines(String result) {
        return result.replaceAll("\\\\", "").replaceAll(EmptyLineWithTab, "\n\n");
    }

    private String cleanEscapedTokens(String result) {
        return result.replaceAll(NewLine + Tab + "+" + "\\Z", "");
    }

    private String removeEmptyLinesWithTab(String text) {
        return text.replaceAll(EmptyLineWithTab, "\n\n");
    }

    private String removeEmptyLinesWithSlash(String text) {
        while (true) {
            String result = text.replaceAll(EmptyLineWithSlash, "\n");
            if (result.length() == text.length()) return result;
        }
    }
}