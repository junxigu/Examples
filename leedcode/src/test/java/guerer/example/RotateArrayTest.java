package guerer.example;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RotateArrayTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		new RotateArray().rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}
}
