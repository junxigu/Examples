package guerer.example.exceptions;

import guerer.example.util.Print;

public class Cleanup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("guerer\\example\\exceptions\\Cleanup.java");
			try {
				String s;
				while((s = in.getLine()) != null){
					Print.print(s);
				}
			} finally {
				in.dispose();
			}
		} catch(Exception e) {
			Print.print(e);
		}
	}
}
