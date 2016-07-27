package guerer.example.strings;

import guerer.example.util.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {

	public static String input = "As long as threre is in justice, whenever a\n"
			+ "Targathian baby cries out , wherever a distress\n"
			+ "signal sounds among the stars ... We'll be there.\n"
			+ "This fine ship, and this fine crew ...\n"
			+ "Never give up! Never surrender!";

	private static class Display {
		private boolean regexPrinted = false;
		private String regex;

		Display(String regex) {
			this.regex = regex;
		}

		void display(String message) {
			if (!regexPrinted) {
				Print.print(regex);
				regexPrinted = true;
			}
			Print.print(message);
		}
	}

	static void examine(String s, String regex) {
		Display display = new Display(regex);
		Matcher m = Pattern.compile(regex).matcher(s);
		while (m.find()) {
			display.display(String.format("find() '%s' start = %d end = %d",
					m.group(), m.start(), m.end()));
		}
		if (m.lookingAt()) {
			display.display(String.format("lookingAt() start = %d end = %d",
					m.start(), m.end()));
		}
		if (m.matches()) {
			display.display(String.format("matches() start = %d end %d",
					m.start(), m.end()));
		}
	}

	public static void main(String[] args) {
		for (String s : input.split("\n")) {
			Print.print("input: " + s);
			for (String r : new String[] { "\\w*ere\\w*", "\\w*ever", "T\\w+",
					"Never.*?!" }) {
				examine(s, r);
			}
		}
	}
}
