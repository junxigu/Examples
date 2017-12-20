package guerer.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 */

public class InsertDeleteGetRandomDuplicatesallowed381 {
	List<Integer> list = new ArrayList<Integer>();
	Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
	Random r = new Random();

	/** Initialize your data structure here. */
	public InsertDeleteGetRandomDuplicatesallowed381() {

	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		Set<Integer> set = map.get(val);
		boolean notContain = set == null || set.isEmpty();
		if (set == null) {
			set = new LinkedHashSet<Integer>();
			map.put(val, set);
		}
		set.add(list.size());

		list.add(val);
		return notContain;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		Set<Integer> set = map.get(val);
		if (set != null && !set.isEmpty()) {
			int i = set.iterator().next();
			set.remove(i);
			if (i < list.size() - 1) {
				list.set(i, list.get(list.size() - 1));
				set = map.get(list.get(list.size() - 1));
				set.remove(list.size() - 1);
				set.add(i);
			}
			list.remove(list.size() - 1);
			return true;
		}
		return false;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return list.get(r.nextInt(list.size()));
	}
}
