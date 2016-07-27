package guerer.example.strings;

import guerer.example.util.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gouprs {
	static public final String POEM = "Twas brillig, and the slithy toves\n"
			+ "Did gyre and gimble in the wabe.\n"
			+ " All mimsy were the borogoves.\n"
			+ "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwock, my son.\n"
			+ "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n"
			+ "The frumious Bandersnatch.";

	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+(\\S+)\\s+(\\S+)$").matcher(
				POEM);
		while(m.find()){
			for(int i = 0; i <= m.groupCount(); i++) {
				Print.printf("[%s]", m.group(i));
			}
			Print.print();
		}
	}

}
