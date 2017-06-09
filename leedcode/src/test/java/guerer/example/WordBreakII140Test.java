package guerer.example;

import java.util.Arrays;

import org.junit.Test;

public class WordBreakII140Test {

	@Test
	public void test() {
		WordBreakII140 wb = new WordBreakII140();
		System.out.println(wb.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
		System.out.println(wb.wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
						"aaaaaaaaaa")));
	}

}
