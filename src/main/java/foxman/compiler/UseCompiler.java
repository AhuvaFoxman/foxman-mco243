package foxman.compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UseCompiler {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(
				"./assemblyLanguage.txt"));

		String line = reader.readLine();

		AssemblyLanguage language = new AssemblyLanguage();

		while (line != null) {
			language.compileInstructions(line);
			line = reader.readLine();
		}

		System.out.println(language.getOutput());

		reader.close();

	}
}
