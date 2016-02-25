package foxman.mach;

public class Microprocessor {

	private char accumulatorA;
	private char accumulatorB;
	private char[] instructions;
	private StringBuilder builder;
	private Memory memory;
	private int counter = 0;

	public Microprocessor(Memory memory) {

		this.accumulatorA = '0';
		this.accumulatorB = '0';
		this.memory = memory;
		this.instructions = this.memory.getMemory();
		this.builder = new StringBuilder();

	}

	public int convertHexToDecimal(String hex) {

		int decimal = Integer.parseInt(hex, 16);
		return decimal;
	}

	public String convertDecimalToHex(int decimal) {

		String hex = Integer.toHexString(decimal).toUpperCase();
		return hex;
	}

	public void processInstruction() {

		while (instructions[counter] != '8') {
			switch (instructions[counter]) {

			case '0':
				load();

				break;

			case '1':
				store();
				break;

			case '2':

				swap();
				break;

			case '3':

				add();
				break;

			case '4': 
				inc();

				break;

			case '5':
				dec();
				break;

			case '6':
				bz();
				break;

			case '7':
				br();
				break;

			case '8':
				return;

			}
		}

	}

	public void load() {

		int dec = setBuilder();

		accumulatorA = instructions[dec];
		counter += 3;
	}

	public void store() {

		int dec = setBuilder();

		instructions[dec] = accumulatorA;
		counter += 3;
	}

	public void swap() {
		char temp = accumulatorA;
		accumulatorA = accumulatorB;
		accumulatorB = temp;
		counter++;
	}

	public void add() {
		int dec = convertHexToDecimal(String.valueOf(accumulatorA));

		int dec2 = convertHexToDecimal(String.valueOf(accumulatorB));

		int total = dec + dec2;

		String hex = convertDecimalToHex(total);

		if (hex.length() == 2) {
			accumulatorA = hex.charAt(1);
			accumulatorB = hex.charAt(0);
		} else {
			accumulatorA = hex.charAt(0);
			accumulatorB = '0';
		}

		counter++;
	}

	public void inc() {
		if (accumulatorA == 'F') {
			accumulatorA = '0';
		} else {

			
			int dec = convertHexToDecimal(String.valueOf(accumulatorA));
			dec++;

			String hex = convertDecimalToHex(dec);
			accumulatorA = hex.charAt(0);

		}

		counter++;
	}

	public void dec() {
		if (accumulatorA == '0') {

			accumulatorA = 'F';
		} else {

			int dec = convertHexToDecimal(String.valueOf(accumulatorA));

			dec--;

			String hex = convertDecimalToHex(dec);

			accumulatorA = hex.charAt(0);
		}

		counter++;
	}

	public void bz() {

		if (accumulatorA == '0') {
			int dec = setBuilder();

			counter = dec;

		} else {
			counter += 3;
		}

	}

	public void br() {
		int dec = setBuilder();

		counter = dec;

	}

	public char[] getInstructions() {
		return this.instructions;
	}

	public int setBuilder() {
		builder.setLength(0);
		builder.append(instructions[counter + 1]);
		builder.append(instructions[counter + 2]);

		int dec = convertHexToDecimal(builder.toString());

		return dec;
	}

}
