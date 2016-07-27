package guerer.example.generics;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class Holder<T> {

	private T value;

	public Holder() {
	}

	public Holder(T value) {
		this.value = value;
	}

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}

	public boolean equals(Object obj) {
		return obj instanceof Holder && this.value == ((Holder<?>) obj).value;
	}

	public static void main(String[] args) {
		Holder<Apple> holder = new Holder<Apple>(new Apple());
		Apple apple = holder.get();
		holder.set(apple);

		// Holder<Fruit> Fruit = holder; // Cannot upcast
		Holder<? extends Fruit> fruit = holder; // ok
		Fruit p = fruit.get();
		apple = (Apple) fruit.get(); // return object

		try {
			Orange orange = (Orange) fruit.get();
		} catch (Exception e) {
			// fruit.set(new Apple()); // Cannot call set()
			// fruit.set(new Fruit()); // Cannot call set()
			System.out.println(fruit.equals(apple)); // OK
		}
	}
}
