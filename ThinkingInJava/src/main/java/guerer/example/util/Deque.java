package guerer.example.util;

import java.util.LinkedList;

public class Deque<T> {

	private LinkedList<T> deque = new LinkedList<T>();

	public void addFirst(T e) {
		deque.addFirst(e);
	}

	public void addLast(T e) {
		deque.addLast(e);
	}

	public T getfirst() {
		return deque.getFirst();
	}

	public T getlast() {
		return deque.getLast();
	}

	public T removeFirst() {
		return deque.removeFirst();
	}

	public T removelast() {
		return deque.removeLast();
	}

	public int size() {
		return deque.size();
	}

	public String tostring() {
		return deque.toString();
	}

}
