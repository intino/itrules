package es.siani.templation;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;

public class Document {

	private final Template template;
	private HashMap<String, Object> markMap;
	private final TemplationLogger logger;

	public Document(Template template) {
		if (template == null) throw new RuntimeException("Template is null");
		this.template = template;
		this.logger = template.logger;
	}

	public void fillMark(String name, Object value) {
		markMap.put(name, value);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		ParseTreeWalker walker = new ParseTreeWalker();
//		TemplationGeneratorListener extractor = new TemplationGeneratorListener(builder, markMap, logger);
//		TemplationParser.RootContext root = template.root;
//		walker.walk(extractor, root);
		return builder.toString();
	}

	public String print(){
		return toString();
	}
}
