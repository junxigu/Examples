package guerer.example;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntersectionofTwoArraysIITest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntersect() {
		System.out.println(Arrays.toString(IntersectionofTwoArraysII.intersect(
			new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(IntersectionofTwoArraysII.intersect(
			new int[] { 1, 2, 2, 1 }, new int[] { 2 })));
	}

}
