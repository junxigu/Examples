package guerer.example.util;

import java.util.Random;

public class Enums {

	private static Random rand = new Random();

	public static <T extends Enum<T>> T random(Class<T> type) {
		return random(type.getEnumConstants());
	}

	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	}

}
