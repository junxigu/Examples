package guerer.example.containers;

import guerer.example.util.CountingMapData;
import guerer.example.util.Print;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {

	public static void printKeys(Map<Integer, String> map) {
		Print.printnb("5ize = " + map.size() + ", ");
		Print.printnb("Keys: ");
		Print.print(map.keySet()); // Produce a Set of the keys
	}

	public static void test(Map<Integer, String> map) {
		Print.print(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(25));
		// Map has 'Set' behavior for keys:
		map.putAll(new CountingMapData(25));
		printKeys(map);
		// Producing a Collection of the values:
		Print.printnb("Values: ");
		Print.print(map.values());
		Print.print(map);
		Print.print("map.containsKey(11): " + map.containsKey(11));
		Print.print("map.get(11): " + map.get(11));
		Print.print("map.containsValue(\"FO\") : " + map.containsValue("FOD"));
		Integer key = map.keySet().iterator().next();
		Print.print("First key in map: " + key);
		map.remove(key);
		printKeys(map);
		map.clear();
		Print.print("map.isEmpty(): " + map.isEmpty());
		map.putAll(new CountingMapData(25));
		// Operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		Print.print("map.isEmpty(): " + map.isEmpty());
	}

	public static void main(String[] args) {
		test(new HashMap<Integer,String>());
		test(new TreeMap<Integer,String>());
		test(new LinkedHashMap<Integer, String>());
		test(new IdentityHashMap<Integer,String>());
		test(new ConcurrentHashMap<Integer, String>());
		test(new WeakHashMap<Integer, String>());
	}

}
