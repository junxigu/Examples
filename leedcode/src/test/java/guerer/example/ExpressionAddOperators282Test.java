package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionAddOperators282Test {

	@Test
	public void testAddOperators() {
		ExpressionAddOperators282 eao = new ExpressionAddOperators282();

		System.out.println(eao.addOperators("123", 6));
		System.out.println(eao.addOperators("232", 8));
		System.out.println(eao.addOperators("105", 5));
		System.out.println(eao.addOperators("00", 0));
		System.out.println(eao.addOperators("3456237490", 9191));
	}

}
