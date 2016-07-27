package guerer.example.strings;

import guerer.example.util.Print;

import java.util.Scanner;

public class ScannerDelimiter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner("12, 42, 78, 99, 42");
		scanner.useDelimiter("\\s*,\\s*");
		while(scanner.hasNextInt()){
			Print.print(scanner.nextInt());
		}
		scanner.close();
	}

}
