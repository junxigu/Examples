package guerer.example.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//A very simple version of the "grep" program. 
// {Args: JGrep.java "\\b[Ssct]\\w+"}

public class JGrep {

	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			Print.print("Usage: java JGrep file regex");
			return;
		}
		Matcher m = Pattern.compile(args[1]).matcher("");
		int index = 0;
		for (String line : new TextFile(args[0])) {
			m.reset(line);
			while (m.find()) {
				Print.print(index++ + ": " + m.group() + ": " + m.start());
			}
		}
	}

}
