package guerer.example;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SingleNumberIIITest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSingleNumber() {
		System.out.println(Arrays.toString(new SingleNumberIII()
				.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 })));
	}

}
