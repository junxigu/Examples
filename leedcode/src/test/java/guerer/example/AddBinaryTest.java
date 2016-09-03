package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddBinaryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBinary() {
		assertEquals(new AddBinary().addBinary("11", "1"), "100");
		assertEquals(new AddBinary().addBinary("1010", "1011"), "10101");
	}

}
