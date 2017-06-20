package guerer.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber17 {
	public List<String> letterCombinations(String digits) {
		if(digits.length() == 0) {
			return new ArrayList<String>();
		}
		Map<Character, List<String>> map = new HashMap<Character, List<String>>();
		// map.put('0', Arrays.asList(" "));
		// map.put('1', Arrays.asList(" "));
		map.put('2', Arrays.asList("a", "b", "c"));
		map.put('3', Arrays.asList("d", "e", "f"));
		map.put('4', Arrays.asList("g", "h", "i"));
		map.put('5', Arrays.asList("j", "k", "l"));
		map.put('6', Arrays.asList("m", "n", "o"));
		map.put('7', Arrays.asList("p", "q", "r", "s"));
		map.put('8', Arrays.asList("t", "u", "v"));
		map.put('9', Arrays.asList("w", "x", "y", "z"));

		List<String> r = new ArrayList<String>();
		r.add("");
		for (char c : digits.toCharArray()) {
			List<String> tmp = new ArrayList<String>();
			for (String s : map.get(c)) {
				for (String rs : r) {
					tmp.add(rs + s);
				}
			}
			r = tmp;
		}
		return r;
	}
}
