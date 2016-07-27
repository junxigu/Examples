package guerer.example.arrays;

import guerer.example.util.Generated;
import guerer.example.util.RandomGenerator;

import java.util.Arrays;

public class Alphabeticsearch {

	public static void main(String[] args) {
		String[] sa = Generated.array(new String[30],
				new RandomGenerator.String(5));
		Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(sa));
		int index = Arrays.binarySearch(sa, sa[10],
				String.CASE_INSENSITIVE_ORDER);
		System.out.println("Index: " + index + "\n" + sa[index]);
	}

}
