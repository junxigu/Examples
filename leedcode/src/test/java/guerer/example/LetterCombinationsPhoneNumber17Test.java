package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class LetterCombinationsPhoneNumber17Test {

	@Test
	public void testLetterCombinations() {
		LetterCombinationsPhoneNumber17 lcp = new LetterCombinationsPhoneNumber17();
		System.out.println(lcp.letterCombinations("23"));
		System.out.println(lcp.letterCombinations(""));
	}

}
