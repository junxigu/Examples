package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountAndSayTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAndSay() {
		assertEquals(new CountAndSay().countAndSay(1), "1");
		assertEquals(new CountAndSay().countAndSay(2), "11");
		assertEquals(new CountAndSay().countAndSay(3), "21");
		assertEquals(new CountAndSay().countAndSay(4), "1211");
		assertEquals(new CountAndSay().countAndSay(5), "111221");
	}

}
