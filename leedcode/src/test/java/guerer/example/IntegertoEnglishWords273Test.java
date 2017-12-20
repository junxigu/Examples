package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegertoEnglishWords273Test {

	@Test
	public void testNumberToWords() {
		IntegertoEnglishWords273 iew = new IntegertoEnglishWords273();
		System.out.println(iew.numberToWords(0));
		System.out.println(iew.numberToWords(1));
		System.out.println(iew.numberToWords(19));
		System.out.println(iew.numberToWords(20));
		System.out.println(iew.numberToWords(45));
		System.out.println(iew.numberToWords(100));
		System.out.println(iew.numberToWords(219));
		System.out.println(iew.numberToWords(1335));
		System.out.println(iew.numberToWords(100000));
		System.out.println(iew.numberToWords(1102000));
		System.out.println(iew.numberToWords(1000000));
		System.out.println(iew.numberToWords(1000000000));
		System.out.println(iew.numberToWords(1001002003));
	}

}
