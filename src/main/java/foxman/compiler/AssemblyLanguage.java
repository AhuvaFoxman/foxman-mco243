package foxman.compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AssemblyLanguage {

	private StringBuilder output;

	public AssemblyLanguage() throws IOException {

		output = new StringBuilder();

	}

	public String convertDecimalToHex(int decimal) {

		String hex = Integer.toHexString(decimal).toUpperCase();
		return hex;
	}

	public String convert(String con) {
		int dec = Integer.parseInt(con);
		String hex = convertDecimalToHex(dec);
		
		if(hex.length() == 1){
			return "0" + hex;
		}

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

			output.append("0");

			hex = convert(mem);
			output.append(hex);

			break;

		case "ST":
			output.append("1");

			hex = convert(mem);
			output.append(hex);

			break;

		case "SWP":
			output.append("2");

			break;

		case "ADD":
			output.append("3");

			break;

		case "INC":

			output.append("4");

			break;

		case "DEC":

			output.append("5");

			break;

		case "BZ":

			output.append("6");

			hex = convert(mem);
			output.append(hex);

			break;

		case "BR":

			output.append("7");

			hex = convert(mem);
			output.append(hex);

			break;

		case "STP":

			output.append("8");
			break;

		case "DATA":
			output.append(mem);

		}

	}

	public String getOutput() {
		return this.output.toString();
	}
}
