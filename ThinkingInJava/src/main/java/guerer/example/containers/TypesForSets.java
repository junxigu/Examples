package guerer.example.containers;

import guerer.example.util.Print;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class SetType {
	int i;

	public SetType(int i) {
		this.i = i;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof SetType && i == ((SetType) o).i;
	}

	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

class HashSetType extends SetType {

	public HashSetType(int i) {
		super(i);
	}

	@Override
	public int hashCode() {
		return i;
	}
}

class TreeSetType extends SetType implements Comparable<TreeSetType> {

	public TreeSetType(int i) {
		super(i);
	}

	public int compareTo(TreeSetType o) {
		return i < o.i ? 1 : (i == o.i ? 0 : -1);
	}

}

public class TypesForSets {

	public static <T> void fill(Set<T> set, Class<T> type) {
		for (int i = 0; i < 10; i++) {
			try {
				set.add(type.getConstructor(int.class).newInstance(i));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static <T> void test(Set<T> set, Class<T> type) {
		fill(set, type);
		fill(set, type);
		fill(set, type);
		Print.print(set);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test(new HashSet<HashSetType>(), HashSetType.class);
		test(new LinkedHashSet<HashSetType>(), HashSetType.class);
		test(new TreeSet<TreeSetType>(), TreeSetType.class);

		test(new HashSet<SetType>(), SetType.class);
		test(new HashSet<TreeSetType>(), TreeSetType.class);
		test(new LinkedHashSet<SetType>(), SetType.class);
		test(new LinkedHashSet<TreeSetType>(), TreeSetType.class);
		try {
			test(new TreeSet<SetType>(), SetType.class);
		} catch (Exception e) {
			Print.print(e.getMessage());
		}
		try {
			test(new TreeSet<HashSetType>(), HashSetType.class);
		} catch (Exception e) {
			Print.print(e.getMessage());
		}
	}

}
