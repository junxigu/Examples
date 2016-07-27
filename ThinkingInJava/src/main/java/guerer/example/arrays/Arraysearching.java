package guerer.example.arrays;

import guerer.example.util.ConvertTo;
import guerer.example.util.Generated;
import guerer.example.util.Generator;
import guerer.example.util.Print;
import guerer.example.util.RandomGenerator;

import java.util.Arrays;

public class Arraysearching {

	public static void main(String[] args) {
		Generator<Integer> gen = new RandomGenerator.Integer(1000);
		int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
		Arrays.sort(a);
		Print.print("Sorted array: " + Arrays.toString(a));
		while (true) {
			int r = gen.next();
			int location = Arrays.binarySearch(a, r);
			if (location >= 0) {
				Print.print("Location of " + r + "is " + location + ", a["
						+ location + "1 = " + a[location]);
				break; // Out of while loop
			}
		}
	}

}
