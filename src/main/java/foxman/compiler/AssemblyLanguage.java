package foxman.compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AssemblyLanguage {

	private ArrayList<String> output;
	private int counter = 0;

	public AssemblyLanguage() throws IOException {

		output = new ArrayList<String>();

	}

	public String convertDecimalToHex(int decimal) {

		String hex = Integer.toHexString(decimal).toUpperCase();
		return hex;
	}

	public String convert(String con) {
		int dec = Integer.parseInt(con);
		String hex = convertDecimalToHex(dec);

		return hex;
	}

	public void compileInstructions(String instruction) {
		String hex;
		String[] split = instruction.split(" ");
		String mem = null;
		String data = split[0];

		if (split.length == 2) {
			mem = split[1];
		}

		switch (data) {

		case "LD":

			output.add("0");

			hex = convert(mem);
			output.add(hex);

			break;

		case "ST":
			output.add("1");

			hex = convert(mem);
			output.add(hex);

			break;

		case "SWP":
			output.add("2");

			counter++;

			break;

		case "ADD":
			output.add("3");

			counter++;

			break;

		case "INC":

			output.add("4");

			counter++;

			break;

		case "DEC":

			output.add("5");
			counter++;

			break;

		case "BZ":

			output.add("6");

			hex = convert(mem);
			output.add(hex);

			break;

		case "BR":

			output.add("7");

			hex = convert(mem);
			output.add(hex);

			break;

		case "STP":

			output.add("8");
			break;

		case "DATA":
			output.add(mem);

		}

	}

	public ArrayList<String> getOutput() {
		return this.output;
	}
}
