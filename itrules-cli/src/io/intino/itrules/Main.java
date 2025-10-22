package io.intino.itrules;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.intino.itrules.parser.ITRulesSyntaxError;
import io.intino.itrules.template.Template;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class Main {


	public static void main(String[] args) {
		if (args.length != 3 || args[0].equals("-h") || args[0].equals("--help")) printHelp();
		else try {
			FileInputStream templateStream = new FileInputStream(args[0]);
			Template template = new TemplateReader(templateStream).read();
			JsonObject object = new Gson().fromJson(new FileReader(args[1]), JsonObject.class);
			File outputFile = new File(args[2]);
			outputFile.getParentFile().mkdirs();
			String result = new Engine(template).render(object);
			Files.writeString(outputFile.toPath(), result);
			System.out.println("File successfully generated at: " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("File read/write error: " + e.getMessage());
		} catch (ITRulesSyntaxError e) {
			System.err.println("ITRules syntax error in the template: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
	}

	private static void printHelp() {
		System.out.println("Usage: java -jar itrules-cli.jar <template.itr> <json> <output.txt>");
		System.out.println();
		System.out.println("Arguments:");
		System.out.println("  <template.itr>   ITRules template file.");
		System.out.println("  <json>           JSON string with the input data.");
		System.out.println("  <output.txt>     Path to the output file.");
		System.out.println();
		System.out.println("Example:");
		System.out.println("  java -jar itrules-cli.jar template.itr \"{\\\"name\\\":\\\"John\\\"}\" output.txt");
		System.out.println();
		System.out.println("Use -h or --help to display this message.");
	}
}
