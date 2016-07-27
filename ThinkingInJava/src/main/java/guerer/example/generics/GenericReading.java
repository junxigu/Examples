package guerer.example.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericReading {

	static <T> T readExact(List<T> list) {
		return list.get(0);
	}

	static List<Fruit> fruits = new ArrayList<Fruit>();
	static List<Apple> apples = new ArrayList<Apple>();

	static void f1() {
		Fruit f = readExact(fruits);
		f = readExact(apples);
	}

	static class Reader<T> {
		T readExact(List<T> list) {
			return list.get(0);
		}
	}

	static void f2() {
		Reader<Fruit> r = new Reader<Fruit>();
		Fruit f = r.readExact(fruits);
		// f = r.readExact(apples); // Error
	}

	static class CovariantReader<T> {
		T readCovariant(List<? extends T> list) {
			return list.get(0);
		}
	}

	public static void f3() {
		CovariantReader<Fruit> r = new CovariantReader<Fruit>();
		Fruit f = r.readCovariant(fruits);
		Fruit a = r.readCovariant(apples);
	}

	public static void main(String[] args) {
		f1();
		f2();
		f3();
	}

}
