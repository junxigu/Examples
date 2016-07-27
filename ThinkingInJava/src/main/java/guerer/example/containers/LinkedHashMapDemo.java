package guerer.example.containers;

import guerer.example.util.CountingMapData;
import guerer.example.util.Print;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(
				new CountingMapData(9));
		Print.print(linkedMap);
		// Least-recently-used order:
		linkedMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
		linkedMap.putAll(new CountingMapData(9));
		Print.print(linkedMap);
		for (int i = 0; i < 6; i++)
			// Cause accesses:
			linkedMap.get(i);
		Print.print(linkedMap);
		linkedMap.get(0);
		Print.print(linkedMap);
		linkedMap.put(9, "9");
		Print.print(linkedMap);
	}

}
