package guerer.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
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
}
