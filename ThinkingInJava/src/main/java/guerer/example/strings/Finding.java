package guerer.example.strings;

import guerer.example.util.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {

	public static void main(String[] args) {
		Matcher m = Pattern.compile("\\w+").matcher(
				"Evening is full of the linnet's wings");
		while(m.find()){
			Print.printnb(m.group() + " ");
		}
		Print.print();
		
		int i = 0;
		while(m.find(i)){
			Print.printnb(m.group() + " ");
			i++;
		}
	}

}
