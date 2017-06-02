package guerer.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */

public class WordLadderII126 {

	public int diff(String a, String b) {
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		
		int result = 0;
		for (int i = 0; i < a.length(); i++) {
			result += ac[i] != bc[i] ? 1 : 0;
		}
		return result;
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		wordList = new ArrayList<String>(wordList);
		wordList.remove(beginWord);
		// generate a tree by map, whose last level contain endWord
		Map<String, List<String>> tree = new HashMap<String, List<String>>();
		if(BFS(beginWord, endWord, new HashSet<String>(wordList), tree)) {
			// DFS tree to create the result list
			DFS(endWord, res, new ArrayList<String>(Arrays.asList(beginWord)), tree);
		}
		return res;
	}
	
	public void DFS(String endWord, List<List<String>> res, List<String> currList, Map<String, List<String>> tree) {
		// if find the endword put a new result in the res
		if(currList.contains(endWord)) {
			res.add(new ArrayList<String>(currList));
		}
		// else
		else {
			// for each sub str of last word in currList
			List<String> subStrs = tree.get(currList.get(currList.size() - 1));
			if(subStrs != null) {
				for(String subStr : subStrs) {
					// put it in currList
					currList.add(subStr);
					// recursive the find result
					DFS(endWord, res, currList, tree);
					// remove it from currList
					currList.remove(subStr);
				}
			}
		}
	}
	
	public boolean BFS(String beginWord, String endWord, Set<String> words, Map<String, List<String>> tree) {
		Set<String> currLevel = new HashSet<String>();
		currLevel.add(beginWord);
		// for each level whose size > 0 and don't contain endword
		while(currLevel.size() > 0 && !currLevel.contains(endWord)) {
			Set<String> currWords = new HashSet<String>(words);
			Set<String> nextLevel = new HashSet<String>();
			// for each str in latest level
			for(String str : currLevel) {
				// find sub-strs in currWords
				List<String> subStrs = findSubStrs(str, currWords);
				// put it in the tree 
				tree.put(str, subStrs);
				// put the sub-strs in next level
				nextLevel.addAll(subStrs);
				// remove the sub-strs from words
				words.removeAll(subStrs);
			}
			currLevel = nextLevel;
		}
		return currLevel.contains(endWord);
	}

	private List<String> findSubStrs(String str, Set<String> words) {
		List<String> level = new ArrayList<String>();
		for(String s : words) {
			if(diff(s, str) == 1) {
				level.add(s);
			}
		}
		return level;
	}
}
