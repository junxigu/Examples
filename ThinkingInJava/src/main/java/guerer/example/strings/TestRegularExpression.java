package guerer.example.strings;

//Allows you to easily try out regular expressions.
//{Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }

import guerer.example.util.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {

	public static void main(String[] args) {
		if (args.length < 2) {
			Print.print("Usage:\njava TestRegularExpression "
					+ "characterSequence regularExpression+");
			return;
		}
		Print.printf("Input: \"%s\"\n", args[0]);
		for (String r : args) {
			Print.print("Regular expression: \"" + r + "\"");
			Matcher m = Pattern.compile(r).matcher(args[0]);
			while (m.find()) {
				Print.printf("Match \"%s\" at positions %d - %d\n", m.group(),
						m.start(), m.end() - 1);
			}
		}
	}

}
