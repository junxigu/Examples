package guerer.example.enumerate;

import guerer.example.util.Print;

enum Shrubbery {
	GROUND, CRAWLING, HANGING
}

public class EnumClass {

	public static void main(String[] args) {
		for (Shrubbery s : Shrubbery.values()) {
			Print.print(s + " ordinal: " + s.ordinal());
			Print.print(s.compareTo(Shrubbery.CRAWLING) + " ");
			Print.print(s.equals(Shrubbery.CRAWLING) + " ");
			Print.print(s == Shrubbery.CRAWLING);
			Print.print(s.getClass());
			Print.print(s.getDeclaringClass());
			Print.print(s.name());
			Print.print("---------------------- ");
		}
		for (String s : "GROUND CRAWLING HANGING".split(" ")) {
			Print.print(Shrubbery.valueOf(s));
			Print.print(Enum.valueOf(Shrubbery.class, s));
		}
	}

}
