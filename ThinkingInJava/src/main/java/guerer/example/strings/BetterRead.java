package guerer.example.strings;

import guerer.example.util.Print;

import java.util.Scanner;

public class BetterRead {

	public static String input = "Sir Robin of Camelot\n22 1.61803";
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(input);
		String name = stdin.nextLine();
		int age = stdin.nextInt();
		double d = stdin.nextDouble();
		
		Print.print("What's your name?");
		Print.print(name);
		
		Print.print("How old are you? What's your favorite double?");
		Print.print("(input: <age> <double>)");
		Print.printf("Hi %s.\n", name);
		Print.printf("In 5 years you will be %d.\n", age + 5);
		Print.printf("My favorite double is %f.\n", d / 2);
		stdin.close();
	}

}
