package guerer.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 Example:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

 */
public class MinStack {
	LinkedList<Integer> stack = new LinkedList<Integer>();
	List<Integer> sortList = new LinkedList<Integer>();
	int min = Integer.MAX_VALUE;

	public MinStack() {

	}

	public void push(int x) {
		stack.add(x);
		min = Math.min(min, x);
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int t = stack.removeLast();
			if (min == t) {
				min = stack.isEmpty() ? Integer.MAX_VALUE : Collections
						.min(stack);
			}
		}
	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.getLast();
		}
		return 0;
	}

	public int getMin() {
		return min;
	}
}
