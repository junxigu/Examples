package guerer.example.strings;

import guerer.example.util.Print;

import java.util.Random;

public class UsingStringBuilder {

	public static Random rand = new Random();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < 25; i++) {
			sb.append(rand.nextInt(100)).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append("}");
		return sb.toString();
	}

	public static void main(String[] args) {
		UsingStringBuilder usb = new UsingStringBuilder();
		Print.print(usb);
	}

}
