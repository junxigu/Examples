package guerer.example;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTwoSum() {
		assertEquals(
			Arrays.toString(new TwoSum().twoSum(new int[] { 2, 7, 11, 15 }, 9)),
			"[0, 1]");
	}

}
