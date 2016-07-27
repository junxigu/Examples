package guerer.example.strings;

import guerer.example.util.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resetting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Matcher m = Pattern.compile("[frb][aiu][gx]").matcher(
				"fix the rug with bags");
		while(m.find()){
			Print.printnb(m.group() + " ");
		}
		Print.print();
		
		m.reset();
		while(m.find()){
			Print.printnb(m.group() + " ");
		}
		Print.print();
		
		m.reset("fix the rig with rags");
		while(m.find()){
			Print.printnb(m.group() + " ");
		}
		Print.print();
	}

}
