package org.siani.itrules;

import org.siani.itrules.lang.TemplateCompiler;
import org.siani.itrules.model.Rule;

import java.io.*;

public final class TemplateReader implements RuleReader {

	private InputStream input;

	public TemplateReader(File file) throws FileNotFoundException {
		this(new FileInputStream(file));
	}

	public TemplateReader(String stream) {
		this(new ByteArrayInputStream(stream.getBytes()));
	}

	public TemplateReader(InputStream stream) {
		input = new RuleSetInputStream(stream);
	}

	public Rule[] read() {
		return new TemplateCompiler().compile(input);
	}
}
