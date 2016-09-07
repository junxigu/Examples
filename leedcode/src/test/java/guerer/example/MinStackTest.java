package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinStackTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		assertEquals(minStack.getMin(), -3);
		minStack.pop();
		assertEquals(minStack.top(), 0);
		assertEquals(minStack.getMin(), -2);
	}

	@Test
	public void test2() {
		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		assertEquals(minStack.getMin(), 0);
		minStack.pop();
		assertEquals(minStack.getMin(), 0);
		minStack.pop();
		assertEquals(minStack.getMin(), 0);
		minStack.pop();
		assertEquals(minStack.getMin(), 2);
	}

}
