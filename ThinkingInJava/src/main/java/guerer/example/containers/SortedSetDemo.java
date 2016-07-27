package guerer.example.containers;

import guerer.example.util.Print;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		SortedSet<String> sortedSet = new TreeSet<String>();
		Collections.addAll(sortedSet,
				"one two three four five six seven eight".split(" "));
		Print.print(sortedSet);

		String low = sortedSet.first();
		String high = sortedSet.last();
		Print.print(low);
		Print.print(high);

		Iterator<String> it = sortedSet.iterator();
		for (int i = 0; i < 6; i++) {
			if (i == 3) {
				low = it.next();
			} else if (i == 6) {
				high = it.next();
			} else {
				it.next();
			}
		}
		Print.print(low);
		Print.print(high);

		Print.print(sortedSet.subSet(low, high));
		Print.print(sortedSet.headSet(high));
		Print.print(sortedSet.tailSet(low));
	}
}
