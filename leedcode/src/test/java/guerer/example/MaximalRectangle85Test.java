package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximalRectangle85Test {

	@Test
	public void testMaximalRectangle() {
		MaximalRectangle85 mr = new MaximalRectangle85();
		assertEquals(6, mr.maximalRectangle(new char[][]{
			new char[]{'1', '0', '1', '0', '0'},
			new char[]{'1', '0', '1', '1', '1'},
			new char[]{'1', '1', '1', '1', '1'},
			new char[]{'1', '0', '0', '1', '0'},
		}));
		assertEquals(1, mr.maximalRectangle(new char[][]{
			new char[]{'1'},
		}));
		assertEquals(1, mr.maximalRectangle(new char[][]{
			new char[]{'0', '1'},
		}));
	}
}
