package guerer.example.containers;

import guerer.example.util.CountingMapData;
import guerer.example.util.Print;

import java.util.Iterator;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(
				new CountingMapData(10));
		Print.print(sortedMap);
		Integer low = sortedMap.firstKey();
		Integer high = sortedMap.lastKey();
		Print.print(low);
		Print.print(high);
		Iterator<Integer> it = sortedMap.keySet().iterator();
		for (int i = 0; i <= 6; i++) {
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
		Print.print(sortedMap.subMap(low, high));
		Print.print(sortedMap.headMap(high));
		Print.print(sortedMap.tailMap(low));
	}

}
