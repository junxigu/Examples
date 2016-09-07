package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidPalindromeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPalindrome() {
//		new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama");
//		new ValidPalindrome().isPalindrome("race a car");
		new ValidPalindrome().isPalindrome(".,");
	}

}
