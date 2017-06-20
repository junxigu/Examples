package guerer.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning131 {
	public List<List<String>> partition(String s) {
		List<List<String>> r = new ArrayList<List<String>>();
		if (s.length() == 0)
			return r;
		List<String> l = new ArrayList<String>();
		l.add(s.substring(0, 1));
		r.add(l);
		Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
		map.put(0, r);
		
		boolean[][] pal = new boolean[s.length()][s.length()];
		pal[0][0] = true;
		for (int i = 1; i < s.length(); i++) {
			r = new ArrayList<List<String>>();
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (j + 1 >= i - 1 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					if (j == 0) {
						l = new ArrayList<String>();
						l.add(s.substring(0, i + 1));
						r.add(l);
					} else {
						for (List<String> subL : map.get(j - 1)) {
							List<String> tmp = new ArrayList<String>(subL);
							tmp.add(s.substring(j, i + 1));
							r.add(tmp);
						}
					}
				}
			}
			map.put(i, r);
		}
		return map.get(s.length() - 1);
	}
}
