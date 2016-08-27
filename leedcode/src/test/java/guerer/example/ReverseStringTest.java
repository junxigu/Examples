package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ReverseStringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReverseString() {
		ReverseString rs = new ReverseString();

		assertEquals("", rs.reverseString(""));
		assertEquals(null, rs.reverseString(null));
		assertEquals("cba", rs.reverseString("abc"));
		assertEquals("cba", rs.reverseString("abc"));
	}

}
