package guerer.example;

import java.util.HashMap;
import java.util.Map;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

public class LRUCache146 {
	class DlinkNode {
		int key;
		int value;
		DlinkNode pre = null;
		DlinkNode next = null;

		DlinkNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	class Dlink {
		DlinkNode head;
		DlinkNode tail;

		Dlink() {
			head = new DlinkNode(-1, -1);
			tail = new DlinkNode(-1, -1);

			head.next = tail;
			tail.pre = head;
		}

		public void removeDlinkNode(DlinkNode n) {
			n.pre.next = n.next;
			n.next.pre = n.pre;
		}

		public void addDlinkNode(DlinkNode n) {
			n.pre = head;
			n.next = head.next;

			head.next.pre = n;
			head.next = n;
		}

		public DlinkNode removeTail() {
			DlinkNode n = tail.pre;
			n.pre.next = tail;
			tail.pre = n.pre;
			return n;
		}
	}

	int count = 0;
	int capacity = 0;
	Dlink link = new Dlink();
	Map<Integer, DlinkNode> map = new HashMap<Integer, DlinkNode>();

	public LRUCache146(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		DlinkNode n = map.get(key);
		if (n != null) {
			link.removeDlinkNode(n);
			link.addDlinkNode(n);
			return n.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if(capacity <= 0) return;
		
		DlinkNode n = map.get(key);
		if (n == null) {
			n = new DlinkNode(key, value);
			link.addDlinkNode(n);
			map.put(key, n);
			count++;
			if (count > capacity) {
				DlinkNode revN = link.removeTail();
				map.remove(revN.key);
				count--;
			}
		} else {
			n.value = value;
			link.removeDlinkNode(n);
			link.addDlinkNode(n);
		}
	}
}
