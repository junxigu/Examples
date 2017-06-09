package guerer.example;

/*
 * mplement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

Subscribe to see which companies asked this question.

 */

public class ImplementTrie208 {

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
	public ImplementTrie208() {
		root = new TrieNode((char)0);
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode n = root;
		for(char c : word.toCharArray()) {
			if(n.next[c - 'a'] == null) {
				n.next[c - 'a'] = new TrieNode(c);
			}
			n = n.next[c - 'a'];
		}
		n.s = word;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode n = root;
		for(char c : word.toCharArray()) {
			if(n.next[c - 'a'] == null) {
				return false;
			}
			n = n.next[c - 'a'];
		}
		return n.s != null && n.s.equals(word);
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode n = root;
		for(char c : prefix.toCharArray()) {
			if(n.next[c - 'a'] == null) {
				return false;
			}
			n = n.next[c - 'a'];
		}
		return true;
	}
}
