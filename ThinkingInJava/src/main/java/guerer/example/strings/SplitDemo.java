package guerer.example.strings;

import guerer.example.util.Print;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {

	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		Print.print(Arrays.toString(Pattern.compile("!!").split(input)));
		Print.print(Arrays.toString(Pattern.compile("!!").split(input, 3)));
	}

}
