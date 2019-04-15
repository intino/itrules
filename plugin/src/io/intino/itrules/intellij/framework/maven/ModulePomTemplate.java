package io.intino.itrules.intellij.framework.maven;

import io.intino.itrules.LineSeparator;
import io.intino.itrules.Template;

import java.util.Locale;

public class ModulePomTemplate extends Template {

	protected ModulePomTemplate(Locale locale, LineSeparator separator) {
		super(locale, separator);
	}

	public static Template create() {
		return new ModulePomTemplate(Locale.ENGLISH, LineSeparator.LF).define();
	}

	private Template define() {
		add(
			rule().add(condition("type", "pom")).add(literal("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
				"         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0\n" +
				"                             http://maven.apache.org/maven-v4_0_0.xsd\">\n" +
				"  <modelVersion>4.0.0</modelVersion>\n" +
				"  <version>4.0.0</version>\n")).add(literal(
				"\n" +
					"  <properties>\n" +
					"    <maven.compiler.source>1.8</maven.compiler.source>\n" +
					"    <maven.compiler.target>1.8</maven.compiler.target>\n" +
					"  </properties>\n\n" +
					"  <groupId>org.")).add(mark("module")).add(literal("</groupId>\n" +
				"  <artifactId>")).add(mark("module")).add(literal("</artifactId>\n" +
				"\n" +
				"  <dependencies>\n" +
				"    <dependency>\n" +
				"      <groupId>io.intino.itrules</groupId>\n" +
				"      <artifactId>itrules</artifactId>\n" +
				"      <version>LATEST</version>\n" +
				"    </dependency>\n" +
				"  </dependencies>\n" +
				"\n" +
				"</project>"))

		);
		return this;
	}
}
