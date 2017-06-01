package guerer.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> findLadders(String begin, String end, Set<String> wordList) {
		// Generate the map layers
		if(!generateLayers(begin, end, wordList)) {
			return new ArrayList<List<String>>();
		}
		// generate the result list
		List<List<String>> resultList = new ArrayList<List<String>>();
		List<String> subList = new ArrayList<String>();
		subList.add(begin);
		resultList.add(subList);
		
		Collections.reverse(layers);
		for(List<Map<String, Set<String>>> layer : layers) {
			List<List<String>> tmpList = new ArrayList<List<String>>();
			for(List<String> subResultList : resultList) {
				String endStr = subResultList.get(subResultList.size() - 1);
				for(Map<String, Set<String>> map : layer) {
					for(String key : map.keySet()) {
						if(map.get(key).contains(endStr)) {
							List<String> newsubResultList = new ArrayList<String>(subResultList);
							newsubResultList.add(key);
							tmpList.add(newsubResultList);
						}
					}
				}
			}
			resultList = tmpList;
		}
		return null;
	}
	
	List<List<Map<String, Set<String>>>> layers = new ArrayList<List<Map<String, Set<String>>>>();
	
	boolean generateLayers(String begin, String end, Set<String> wordList) {
		int i = 0;
		Set<String> diffSet = new HashSet<String>(wordList);
		boolean finded = false;
		while (true) {
			// init a set for layer
			Set<String> set = new HashSet<String>();
			if(i == 0) {
				set.add(begin);
			} else {
				List<Map<String, Set<String>>> layer = layers.get(i);
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
				map.put(str, nextStrSet);
				layer.add(map);
			}
			if(finded || layer.size() == 0) {
				break;
			}
			layers.add(layer);
			i++;
		}
		return finded;
	}

	int diff(String a, String b) {
		return 0;
	}
}
