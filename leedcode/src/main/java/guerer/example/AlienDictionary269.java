package guerer.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary269 {

	void initGraph(String[] s, int[][] graph, int[] count) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = 0; j < s[i].length() && j < s[i + 1].length(); j++) {
				char c1 = s[i].charAt(j);
				char c2 = s[i + 1].charAt(j);
				if (c1 != c2 && graph[c1 - 'a'][c2 - 'a'] == 0) {
					count[c1 - 'a'] = count[c1 - 'a'] < 0 ? 0 : count[c1 - 'a'];
					count[c2 - 'a'] = count[c2 - 'a'] <= 0 ? 1 : count[c2 - 'a'] + 1;
					graph[c1 - 'a'][c2 - 'a'] = 1;
				}
			}
		}
		printGraph(graph);
	}

	void printGraph(int[][] graph) {
		for (int[] gb : graph) {
			System.out.println(Arrays.toString(gb));
		}
	}

	String sort(int[][] graph, int[] count) {
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int c = q.poll();
			sb.append((char) (c + 'a'));
			for (int i = 0; i < graph[c].length; i++) {
				if (graph[c][i] == 1) {
					graph[c][i] = 0;
					count[i]--;
					if (count[i] == 0) {
						q.add(i);
					}
				}
			}
		}
		return sb.toString();
	}

	public String alienOrder(String[] words) {
		int[][] graph = new int[26][26];
		int[] count = new int[26];
		Arrays.fill(count, -1);
		Set<Character> set = new HashSet<Character>();

		for (String word : words) {
			for (char c : word.toCharArray()) {
				set.add(c);
			}
		}

		initGraph(words, graph, count);

		System.out.println(Arrays.toString(count));
		String s = sort(graph, count);
		return s.length() == set.size() ? s : "";
	}

	public String alienOrder2(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Map<Character, Set<Character>> suc = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> pre = new HashMap<Character, Integer>();
		HashSet<Character> charSet = new HashSet<Character>();
		String previousWord = new String("");
		for (String currentWord : words) {
			for (Character c : currentWord.toCharArray()) {
				charSet.add(c);
			}
			for (int i = 0; i < Math.min(previousWord.length(), currentWord.length()); ++i) {
				if (previousWord.charAt(i) != currentWord.charAt(i)) {
					if (!pre.containsKey(currentWord.charAt(i))) { // ----section_pre----
						pre.put(currentWord.charAt(i), 1);
					} else {
						// ERROR1: 过滤掉重复的关系 ["za","zb","ca","cb"],
						// 从输入得出的中间结论，"a->b"会重复出现两次，需要滤重。为了实现滤重，重新调整了section_pre和section_suc部分的顺序。
						if (suc.containsKey(previousWord.charAt(i))
								&& suc.get(previousWord.charAt(i)).contains(currentWord.charAt(i))) {
							continue;
						}
						pre.put(currentWord.charAt(i), pre.get(currentWord.charAt(i)) + 1);
					}
					if (!suc.containsKey(previousWord.charAt(i))) { // ----section_suc----
						suc.put(previousWord.charAt(i), new HashSet<Character>());
					}
					suc.get(previousWord.charAt(i)).add(currentWord.charAt(i));
					break; // the BEST part of this question
				}
			}
			previousWord = currentWord;
		}
		Queue<Character> queue = new LinkedList<Character>();
		for (Character each : charSet) {
			if (!pre.containsKey(each)) {
				queue.add(each);
			}
		}

		while (!queue.isEmpty()) {
			Character currentChar = queue.poll();
			sb.append(currentChar);
			// ERROR2 should check containsKey
			if (!suc.containsKey(currentChar)) {
				continue;
			}
			for (Character each : suc.get(currentChar)) {
				pre.put(each, pre.get(each) - 1);
				if (pre.get(each) == 0) {
					queue.offer(each);
				}
			}
		}
		return sb.length() == charSet.size() ? sb.toString() : "";
	}
}
