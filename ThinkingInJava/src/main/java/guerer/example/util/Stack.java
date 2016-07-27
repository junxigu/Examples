package guerer.example.util;

import java.util.LinkedList;

public class Stack<T> {

	private LinkedList<T> stack = new LinkedList<T>();

	public void push(T v) {
		stack.addFirst(v);
	}

	public T peek() {
		return stack.getFirst();
	}

	public T pop() {
		return stack.removeFirst();
	}

	public boolean empty() {
		return stack.isEmpty();
	}

	public String toString() {
		return stack.toString();
	}
}
