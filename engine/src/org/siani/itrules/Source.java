package org.siani.itrules;

import java.io.File;
import java.nio.charset.Charset;

public class Source extends File {

    private Charset charset;

    public Source(String pathname) {
        this(pathname, Charset.defaultCharset());
    }

    public Source(String pathname, Charset charset) {
        super(pathname);
        this.charset = charset;
    }

    public Charset charset() {
        return charset;
    }
}
