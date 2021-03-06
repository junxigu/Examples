package guerer.example;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.

 Notes:

 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

 Update (2015-06-11):
 The class name of the Java function had been updated to MyStack instead of Stack. 
 */

public class ImplementStackUsingQueues {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		int t = q1.poll();
		while (!q1.isEmpty()) {
			q2.add(t);
			t = q1.poll();
		}
		Queue<Integer> tmp = q1;
		q1 = q2;
		q2 = tmp;
	}

	// Get the top element.
	public int top() {
		int t = q1.poll();
		while (!q1.isEmpty()) {
			q2.add(t);
			t = q1.poll();
		}
		q2.add(t);
		Queue<Integer> tmp = q1;
		q1 = q2;
		q2 = tmp;
		return t;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty();
	}
}
