package guerer.example.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWrittiing {

	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}

	static List<Fruit> fruits = new ArrayList<Fruit>();
	static List<Apple> apples = new ArrayList<Apple>();

	static void f1() {
		writeExact(apples, new Apple());
		writeExact(fruits, new Apple()); // Here is update after SE5
	}

	static <T> void writeWithWildcard(List<? super T> list, T item) {
		list.add(item);
	}

	static void f2() {
		writeExact(apples, new Apple());
		writeExact(fruits, new Apple());
	}

	public static void main(String[] args) {
		f1();
		f2();
	}

}