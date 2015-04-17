package org.siani.itrules.intellij.framework.maven;

import org.siani.itrules.Encoding;
import org.siani.itrules.Template;

import java.util.Locale;

public class ModulePomTemplate extends Template {

	public ModulePomTemplate(Locale locale, Encoding encoding) {
		super(locale, encoding);
	}

	public ModulePomTemplate() {
		super(Locale.getDefault(), Encoding.getDefault());
	}

	@Override
	protected void definition() {
		add(
			rule().add(condition("type", "pom")).add(literal("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
				"         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0\n" +
				"                             http://maven.apache.org/maven-v4_0_0.xsd\">\n" +
				"  <modelVersion>4.0.0</modelVersion>\n" +
				"\n" +
				"  <parent>\n" +
				"    <groupId>org.")).add(mark("project")).
				add(literal("</groupId>\n" + "  <artifactId>")).add(mark("project")).add(literal("</artifactId>\n" +
				"  <version>1.0</version>\n" +
				"  </parent>\n" +
				"\n" +
				"  <artifactId>")).add(mark("module")).add(literal("</artifactId>\n" +
				"\n" +
				"  <dependencies>\n" +
				"    <dependency>\n" +
				"      <groupId>org.siani.itrules</groupId>\n" +
				"      <artifactId>itrules</artifactId>\n" +
				"      <version>LATEST</version>\n" +
				"    </dependency>\n" +
				"  </dependencies>\n" +
				"\n" +
				"</project>"))
		);
	}
}