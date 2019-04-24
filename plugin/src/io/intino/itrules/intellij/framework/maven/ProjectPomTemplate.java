package io.intino.itrules.intellij.framework.maven;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ProjectPomTemplate extends Template {


	@Override
	protected RuleSet ruleSet() {
		return new RuleSet().add(
				rule().condition(type("pom")).output(literal("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
						"<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
						"         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
						"         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
						"  <modelVersion>4.0.0</modelVersion>\n" +
						"\n" +
						"  <groupId>org.")).output(mark("project")).
						output(literal("</groupId>\n" + "  <artifactId>")).output(mark("project")).output(literal("</artifactId>\n" +
						"  <packaging>pom</packaging>\n" +
						"  <version>1.0</version>\n" +
						"  <name>")).output(mark("project")).output(literal(" Project</name>\n" +
						"\n" +
						"  <properties>\n" +
						"    <maven.compiler.source>1.8</maven.compiler.source>\n" +
						"    <maven.compiler.target>1.8</maven.compiler.target>\n" +
						"  </properties>\n" +
						"\n" +
						"</project>"))
		);
	}
}
