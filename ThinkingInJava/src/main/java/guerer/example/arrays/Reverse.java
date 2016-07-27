package guerer.example.arrays;

import guerer.example.util.Generated;
import guerer.example.util.Print;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {

	public static void main(String[] args) {
		CompType[] a = Generated.array(new CompType[12], CompType.generator());
		Print.print("before sorting: ");
		Print.print(Arrays.toString(a));
		Arrays.sort(a, Collections.reverseOrder());
		Print.print("after sorting: ");
		Print.print(Arrays.toString(a));
	}

}
