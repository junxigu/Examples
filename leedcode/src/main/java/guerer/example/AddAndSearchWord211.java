package guerer.example;

public class AddAndSearchWord211 {

	class TrieNode {
		char node;
		String s;
		TrieNode[] next = new TrieNode[26];

		TrieNode(char node) {
			this.node = node;
		}
	}

	TrieNode root;

	/** Initialize your data structure here. */
	public AddAndSearchWord211() {
		root = new TrieNode((char) 0);
	}

	/** Inserts a word into the trie. */
	public void addWord(String word) {
		TrieNode n = root;
		for (char c : word.toCharArray()) {
			if (n.next[c - 'a'] == null) {
				n.next[c - 'a'] = new TrieNode(c);
			}
			n = n.next[c - 'a'];
		}
		n.s = word;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return search(root, word);
	}

	private boolean search(TrieNode n, String word) {
		if (word.length() == 0)
			return n.s != null;

		char c = word.charAt(0);
		boolean finded = false;
		if (c == '.') {
			for (TrieNode subN : n.next) {
				if (subN != null) {
					finded = search(subN, word.substring(1));
					if (finded) {
						break;
					}
				}
			}
		} else if (n.next[c - 'a'] != null) {
			finded = search(n.next[c - 'a'], word.substring(1));
		}
		return finded;
	}
}
