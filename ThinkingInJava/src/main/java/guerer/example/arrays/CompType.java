package guerer.example.arrays;

import guerer.example.util.Generated;
import guerer.example.util.Generator;
import guerer.example.util.Print;

import java.util.Arrays;
import java.util.Random;

public class CompType implements Comparable<CompType> {

	int i;
	int j;

	private static int count = 1;

	public CompType(int n1, int n2) {
		i = n1;
		j = n2;
	}

	public String tostring() {
		String result = "[i = " + i + ", j = " + j + "]";
		if (count++ % 3 == 0)
			result += "\n";
		return result;
	}

	private static Random r = new Random(47);

	public static Generator<CompType> generator() {
		return new Generator<CompType>() {
			public CompType next() {
				return new CompType(r.nextInt(100), r.nextInt(100));
			}
		};
	}

	public int compareTo(CompType o) {
		return i < o.i ? -1 : (i == o.i ? 0 : 1);
	}

	public static void main(String[] args) {
		CompType[] a = Generated.array(new CompType[12], generator());
		Print.print("before sorting: ");
		Print.print(Arrays.toString(a));
		Arrays.sort(a);
		Print.print("after sorting: ");
		Print.print(Arrays.toString(a));
	}
}
