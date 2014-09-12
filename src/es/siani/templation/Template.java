package es.siani.templation;

import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Template {
	private TemplationParser parser;
	TemplationParser.RootContext root;
	TemplationLogger logger;

	public Template(TemplationLogger logger, File template) {
		try {
			this.logger = (logger != null) ? logger : new Log();
			init(new ANTLRFileStream(template.getAbsolutePath()));
		} catch (IOException | TemplationException e) {
			if (logger != null) {
				logger.debug("Template: opening stream error \n %s\n", e.getMessage());
			}
		}
	}

	public Template(TemplationLogger logger, InputStream template) {
		try {
			this.logger = (logger != null) ? logger : new Log();
			init(new ANTLRInputStream(template));
		} catch (IOException | TemplationException e) {
			if (logger != null) {
				logger.debug("Template: opening stream error \n %s\n", e.getMessage());
			}
		}
	}

	private void init(ANTLRInputStream input) throws TemplationException {
		TemplationLexer lexer = new TemplationLexer(input);
		lexer.reset();
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new TemplationParser(tokens);
		root = parse();
	}

	private TemplationParser.RootContext parse() throws TemplationException {
		try {
			return parser.root();
		} catch (RecognitionException e) {
			Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			logger.debug("Template not well formed. Error in:" + token.getLine() + ":" + token.getCharPositionInLine());
			logger.debug(e.getMessage());
			throw new TemplationException();
		}
	}

	public static class Log implements TemplationLogger {
		@Override
		public void debug(String message, Object... args) {
			System.out.printf(message, args);
		}
	}
}
