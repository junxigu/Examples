package guerer.example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IntersectionOfTwoArraysTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntersection() {
		System.out.println(Arrays.toString(IntersectionOfTwoArrays.intersection(new int[] { 8,
				0, 3 }, new int[] { 0, 0 })));
	}

}
