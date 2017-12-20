package guerer.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.

 */
public class AllOoneDataStructure432 {
	static class DLinkNode {
		DLinkNode pre;
		DLinkNode next;
		Set<String> set = new HashSet<String>();
	}

	Map<String, Integer> map = new HashMap<String, Integer>();
	Map<Integer, DLinkNode> linkMap = new HashMap<Integer, DLinkNode>();
	DLinkNode head = new DLinkNode();
	DLinkNode tail = new DLinkNode();

	/** Initialize your data structure here. */
	public AllOoneDataStructure432() {
		head.next = tail;
		tail.pre = head;
	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {
		if (!map.containsKey(key))
			map.put(key, 0);
		int tar = map.get(key) + 1;
		map.put(key, tar);

		updateKeyFromList(key, tar - 1, tar);
	}

	void updateKeyFromList(String key, int ori, int tar) {
		if (tar > 0) {
			DLinkNode tarLink = linkMap.get(tar);
			if (tarLink == null) {
				// add key to new list
				tarLink = new DLinkNode();
				DLinkNode beforeLink = ori < tar ? (ori > 0 ? linkMap.get(ori) : head) : linkMap.get(ori).pre;
				addNodeAfterNode(beforeLink, tarLink);
				linkMap.put(tar, tarLink);
			}
			tarLink.set.add(key);
		}
		// remove key from old list
		if (ori > 0) {
			DLinkNode link = linkMap.get(ori);
			link.set.remove(key);
			if (link.set.isEmpty()) {
				link.pre.next = link.next;
				link.next.pre = link.pre;
				linkMap.remove(ori);
			}
		}
	}

	void addNodeAfterNode(DLinkNode src, DLinkNode tar) {
		tar.next = src.next;
		tar.pre = src;
		src.next.pre = tar;
		src.next = tar;
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {
		if (map.containsKey(key)) {
			int tar = map.get(key) - 1;
			if (tar == 0) {
				map.remove(key);
			} else {
				map.put(key, tar);
			}
			updateKeyFromList(key, tar + 1, tar);
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if (head.next != tail) {
			return tail.pre.set.iterator().next();
		}
		return "";
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if (head.next != tail) {
			return head.next.set.iterator().next();
		}
		return "";
	}
}
