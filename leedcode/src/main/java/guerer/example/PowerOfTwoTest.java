package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PowerOfTwoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println((Integer.MAX_VALUE - (Integer.MAX_VALUE >>> 1)) % 2);
	}

}
