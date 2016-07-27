package guerer.example.containers;

import guerer.example.util.Print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListSortSearch {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Utilities.list);
		list.addAll(Utilities.list);
		Print.print(list);
		Collections.shuffle(list, new Random(47));
		Print.print("Shuff1ed: " + list);
		// Use a ListIterator to trim off the last elements:
		ListIterator<String> it = list.listIterator(10);
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		Print.print("Trimmed: " + list);
		Collections.sort(list);
		Print.print("Sorted: " + list);
		String key = list.get(7);
		int index = Collections.binarySearch(list, key);
		Print.print("Location o f " + key + " i s " + index + ", list.get("
				+ index + ") = " + list.get(index));
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		Print.print("Case-insensitive sorted: " + list);
		key = list.get(7);
		index = Collections.binarySearch(list, key,
				String.CASE_INSENSITIVE_ORDER);
		Print.print("Location o f " + key + " i s " + index + ". list.get("
				+ index + ") = " + list.get(index));
	}
}
