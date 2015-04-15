package org.siani.itrules;

import java.nio.charset.Charset;

public class File extends java.io.File {

    private Charset charset;

    public File(String pathname, Charset charset) {
        super(pathname);
        this.charset = charset;
    }

    public Charset charset() {
        return charset;
    }
}
