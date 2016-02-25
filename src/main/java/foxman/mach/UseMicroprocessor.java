package foxman.mach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UseMicroprocessor {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("./mach.in"));

		String line = reader.readLine();
		Memory memory;
		Microprocessor processor;

		while (line != null) {
			System.out.println();

			memory = new Memory(line);
			processor = new Microprocessor(memory);
			processor.processInstruction();
			System.out.println(processor.getInstructions());

			line = reader.readLine();

		}

		reader.close();

	}
}
