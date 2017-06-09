package guerer.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].


 */

public class WordBreakII140 {

	public List<String> wordBreak(String s, List<String> wordDict) {
		return wordBreak(s, wordDict, new HashMap<String, List<String>>());
	}

	public List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> cache) {
		if (cache.containsKey(s)) {
			return cache.get(s);
		}

		List<String> results = new ArrayList<String>();
		if (s.length() > 0) {
			for (String word : wordDict) {
				if (s.startsWith(word)) {
					List<String> subResults = wordBreak(s.substring(word.length()), wordDict, cache);
					for (String subS : subResults) {
						results.add(word + (subS.length() == 0 ? "" : " " + subS));
					}
				}
			}
		} else {
			results.add("");
		}
		cache.put(s, results);
		return results;
	}
}
