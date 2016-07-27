package guerer.example.util;

import java.io.PrintStream;

public class Print {

	public static <T> void print(T t) {
		System.out.println(t);
	}

	public static void print() {
		System.out.println();
	}

	public static <T> void printnb(T t) {
		System.out.print(t);
	}

	public static PrintStream printf(String format, Object... args) {
		return System.out.printf(format, args);
	}

	public static void main(String[] args) {
		print("Availab1e from now on !");
		print(100);
		print(100L);
		print(3.14159);
		printf("%f %s", 3.4, "test");
	}
}
