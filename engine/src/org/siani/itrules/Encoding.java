package org.siani.itrules;

import java.nio.charset.Charset;

import static org.siani.itrules.Encoding.LineSeparator.*;

public class Encoding {
    private final Charset charset;
    private final LineSeparator lineSeparator;

    public static Encoding getDefault() {
        return with("UTF-8", LF);
    }

    public static Encoding with(String charset, LineSeparator lineSeparator) {
        return new Encoding(Charset.forName(charset), lineSeparator);
    }

    public static enum LineSeparator {LF, CRLF}

    public Encoding(Charset charset, LineSeparator lineSeparator) {
        this.charset = charset;
        this.lineSeparator = lineSeparator;
    }

    public Charset charset() {
        return charset;
    }

    public String lineSeparator() {
        return lineSeparator == LineSeparator.CRLF ? "\r\n" : "\n";
    }
}
