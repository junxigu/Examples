package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicCalculator224Test {

	@Test
	public void testCalculate() {
		BasicCalculator224 bc = new BasicCalculator224();
		assertEquals(2, bc.calculate("1 + 1"));
		assertEquals(3, bc.calculate(" 2-1 + 2 "));
		assertEquals(23, bc.calculate("(1+(4+5+2)-3)+(6+8)"));
	}

}
