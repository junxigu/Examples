package guerer.example.generics;

import guerer.example.util.Print;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {
	public static <T, S extends Iterable<? extends T>> void apply(S seq,
			Method f, Object... args) {
		try {
			for (T t : seq)
				f.invoke(t, args);
		} catch (Exception e) {
			// Failures are programmer errors
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws Exception {
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0; i < 10; i++)
			shapes.add(new Shape());
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
		List<Square> squares = new ArrayList<Square>();
		for (int i = 0; i < 10; i++)
			squares.add(new Square());
		Apply.apply(squares, Shape.class.getMethod("rotate"));
		Apply.apply(squares, Shape.class.getMethod("resize", int.class), 5);
	}
}

class Shape {
	public void rotate() {
		Print.print(this + "rotate");
	}

	public void resize(int newsize) {
		Print.print(this + " resize " + newsize);
	}
}

class Square extends Shape {
}

class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			for (int i = 0; i < size; i++)
				// Assumes d e f a u l t constructor:
				add(type.newInstance());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
