package guerer.example.strings;

import guerer.example.util.Print;

import java.util.Arrays;

public class Splitting {
	
	public static String knights = "Then, when you have found the shrubbery, you must " +
			"cut down the mightiest tree in the forest... " +
			"with... a herring!";
	
	public static void split(String regex) {
		Print.print(Arrays.toString(knights.split(regex)));
	}

	public static void main(String[] args) {
		split(" ");
		split("\\W+");
		split("n\\W+");
	}

}
