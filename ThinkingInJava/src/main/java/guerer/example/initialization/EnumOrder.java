package guerer.example.initialization;

import guerer.example.util.Print;

public class EnumOrder {

	public static void main(String[] args) {
		for (Spiciness howHot : Spiciness.values()) {
			Print.print(howHot + ".ordinal " + howHot.ordinal());
		}
	}
}
