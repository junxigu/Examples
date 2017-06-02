package guerer.example;

import java.util.ArrayList;
import java.util.Collections;
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

//	Map<String, Map<Set<String>, List<List<String>>>> results = new HashMap<String, Map<Set<String>, List<List<String>>>>();

//	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//		List<List<String>> result = findMinLenLadders(beginWord, endWord, new HashSet<String>(wordList));
//		return result == null ? new ArrayList<List<String>>() : result;
//	}

//	public boolean mapContainSetKey(Map<Set<String>, List<List<String>>> map, Set<String> wordSet) {
//		for (Set<String> s : map.keySet()) {
//			if (wordSet.containsAll(s)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public void addResults(String beginWord, Set<String> wordSet, List<List<String>> list) {
//		Map<Set<String>, List<List<String>>> subMap = results.get(beginWord);
//		if(subMap == null) {
//			subMap = new HashMap<Set<String>, List<List<String>>>();
//		}
//		subMap.put(wordSet, list);
//		results.put(beginWord, subMap);
//	}
//	
//	public List<List<String>> findMinLenLadders(String beginWord, String endWord, Set<String> wordSet) {
//		// if not cached then findLadders and cache results
//		if (!results.containsKey(beginWord) || !mapContainSetKey(results.get(beginWord), wordSet)) {
//			List<String> oneStrDiffStrList = new ArrayList<String>();
//
//			// find the nearst words for beginword
//			for (String s : wordSet) {
//				if (diff(beginWord, s) == 1) {
//					oneStrDiffStrList.add(s);
//				}
//			}
//			// if endword belong to oneCharDiffStrList then cache and return the
//			// list
//			if (oneStrDiffStrList.contains(endWord)) {
//				List<List<String>> result = new ArrayList<List<String>>();
//				List<String> tmp = new ArrayList<String>();
//				tmp.add(beginWord);
//				tmp.add(endWord);
//				result.add(tmp);
//				
//				addResults(beginWord, wordSet, result);
//			}
//			// else findLadders for nearst words and cache them
//			else if (oneStrDiffStrList.size() > 0) {
//				// for each word s in oneCharDiffStrList, findLadders and cached
//				// it
//				// and find the min-length ladders for oneCharDiffStrList
//				int len = Integer.MAX_VALUE;
//				for (String s : oneStrDiffStrList) {
//					Set<String> newWordList = new HashSet<String>(wordSet);
//					newWordList.remove(s);
//					
//					List<List<String>> tmpResults = findMinLenLadders(s, endWord, newWordList);
//					if(tmpResults != null) {
//						len = Math.min(len, tmpResults.get(0).size());
//					}
//				}
//				
//				// create ladders with beginword and cache it with shortest string with oneCharDiffStrList
//				if(len < Integer.MAX_VALUE) {
//					for (String s : oneStrDiffStrList) {
//						Map<Set<String>, List<List<String>>> subMap = results.get(s);
//						if(subMap != null) {
//							for(Set<String> resultsSet : subMap.keySet()) {
//								Set<String> newResultsSet = new HashSet<String>(resultsSet);
//								newResultsSet.add(beginWord);
//								
//								List<List<String>> newResultsList = new ArrayList<List<String>>();
//								for(List<String> l : subMap.get(resultsSet)) {
//									l.add(0, beginWord);
//									newResultsList.add(l);
//								}
//								Map<Set<String>, List<List<String>>> resultMap = new HashMap<Set<String>, List<List<String>>>();
//								resultMap.put(newResultsSet, newResultsList);
//								results.put(beginWord, resultMap);
//							}
//						}
//					}
//				}
//			}
//		}
//		List<List<String>> resultsList = null;
//		if(results.get(beginWord) != null) {
//			resultsList = new ArrayList<List<String>>();
//			for(List<List<String>> l : results.get(beginWord).values()) {
//				resultsList.addAll(l);
//			}
//		}
//		return resultsList;
//	}

	public int diff(String a, String b) {
		int result = 0;
		for (int i = 0; i < a.length(); i++) {
			result += a.charAt(i) != b.charAt(i) ? 1 : 0;
		}
		return result;
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		String begin = beginWord;
		String end = endWord;
		List<List<Map<String, Set<String>>>> layers = new ArrayList<List<Map<String, Set<String>>>>();
		// Generate the map layers
		if(!generateLayers(layers, begin, end, new HashSet<String>(wordList))) {
			return new ArrayList<List<String>>();
		}
//		System.out.println("Layers: " + layers);
		// generate the result list
		List<List<String>> resultList = new ArrayList<List<String>>();
		List<String> subList = new ArrayList<String>();
		subList.add(end);
		resultList.add(subList);
		
		Collections.reverse(layers);
		for(List<Map<String, Set<String>>> layer : layers) {
			List<List<String>> tmpList = new ArrayList<List<String>>();
			for(List<String> subResultList : resultList) {
				String endStr = subResultList.get(0);
//				System.out.println(endStr);
				for(Map<String, Set<String>> map : layer) {
					for(String key : map.keySet()) {
						if(map.get(key).contains(endStr)) {
							List<String> newsubResultList = new ArrayList<String>(subResultList);
							newsubResultList.add(0, key);
							tmpList.add(newsubResultList);
						}
					}
				}
			}
			resultList = tmpList;
		}
		return resultList;
	}
	
	public boolean generateLayers(List<List<Map<String, Set<String>>>> layers, String begin, String end, Set<String> wordList) {
		int i = 0;
		Set<String> diffSet = new HashSet<String>(wordList);
		boolean finded = false;
		while (true) {
			// init a set for layer
			Set<String> set = new HashSet<String>();
			if(i == 0) {
				set.add(begin);
			} else {
				List<Map<String, Set<String>>> layer = layers.get(i - 1);
				for(Map<String, Set<String>> map : layer) {
					for(Set<String> tmpSet : map.values()) {
						set.addAll(tmpSet);
					}
				}
			}
			
			// foreach str in set to generate a map and put in the layer list
			List<Map<String, Set<String>>> layer = new ArrayList<Map<String, Set<String>>>();
			diffSet.removeAll(set);
			
			for(String str : set) {
				Map<String, Set<String>> map = new HashMap<String, Set<String>>();
				Set<String> nextStrSet = new HashSet<String>();
				
				for(String s : diffSet) {
					if(diff(str, s) == 1) {
						if(s == end) {
							finded = true;
						}
						nextStrSet.add(s);
					}
				}
				if(nextStrSet.size() > 0) {
					map.put(str, nextStrSet);
					layer.add(map);
				}
			}
			if(layer.size() > 0) {
				layers.add(layer);
			} else {
				break;
			}
			if(finded) {
				break;
			}
			i++;
		}
		return finded;
	}
}
