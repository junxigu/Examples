package guerer.example.strings;

import guerer.example.util.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {

	public final static String TEXT = "Here's a block of text to use as input to"
			+ "the regular expression matcher. Note that we'll"
			+ "first extract the block of text by looking for"
			+ "the special delimiters, then process the" + "extracted block.";

	public static void main(String[] args) {
		Print.print(TEXT);
		
		Print.print(TEXT.replaceFirst("[aeiou]", "(VOWEL1)"));
		
		StringBuffer sb = new StringBuffer();
		Matcher m = Pattern.compile("[aeiou]").matcher(TEXT);
		while(m.find()){
			m.appendReplacement(sb, m.group().toUpperCase());
		}
		m.appendTail(sb);
		Print.print(sb.toString());
	}

}
