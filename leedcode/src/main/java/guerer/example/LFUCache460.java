package guerer.example;

import java.util.HashMap;
import java.util.Map;

public class LFUCache460 {

	class Node {
		int val;
		int freq;
		int key;
		Node next;
		Node prev;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
			freq = 1;
		}

		void removeFromList() {
			next.prev = prev;
			prev.next = next;
		}
		
		public String toString() {
			return "(key: " + key + ", freq: " + freq + ", value: " + val + ")";
		}
	}

	class DList {
		Node head;
		Node tail;

		DList next;
		DList prev;

		DList() {
			head = new Node(-1, -1);
			tail = new Node(-1, -1);

			head.next = tail;
			tail.prev = head;
		}

		void addToHead(Node n) {
			n.next = head.next;
			n.prev = head;

			head.next.prev = n;
			head.next = n;
		}

		boolean isEmpty() {
			return head.next == tail;
		}

		void removeFromList() {
			next.prev = prev;
			prev.next = next;
		}

		public Node removeLFNode() {
			Node n = tail.prev;
			tail.prev.removeFromList();
			return n;
		}
		
		public void addListAfterSelf(DList l) {
			l.next = next;
			l.prev = this;
			
			next.prev = l;
			next = l;
		}
		
		public void addListBeforeSelf(DList l) {
			l.prev = prev;
			l.next = this;
			
			prev.next = l;
			prev = l;
//			System.out.println("addListBeforeSelf: " + dListList);
		}
		
		public String toString() {
			Node l = head.next;
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			while(l != tail) {
				sb.append(l).append(" -> ");
				l = l.next;
			}
			sb.append("]");
			return sb.toString();
		}
	}

	class DListList {
		DList head;
		DList tail;
		
		DListList() {
			head = new DList();
			tail = new DList();
			
			head.next = tail;
			tail.prev = head;
		}
		
		void removeLFNodeFromLFDList() {
			DList l = tail.prev;
			Node n = l.removeLFNode();
			map.remove(n.key);
			count--;
			if(l.isEmpty()) {
				l.removeFromList();
				freqMap.remove(n.freq);
			}
//			System.out.println("removeLFNodeFromLFDList: " + dListList);
		}
		
		public String toString() {
			DList l = head.next;
			StringBuilder sb = new StringBuilder();
			sb.append("{\n");
			while(l != tail) {
				sb.append(l).append("\n");
				l = l.next;
			}
			sb.append("}");
			return sb.toString();
		}
	}

	int capacity;
	int count = 0;
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	Map<Integer, DList> freqMap = new HashMap<Integer, DList>();
	DListList dListList = new DListList();
	
	public LFUCache460(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Node n = map.get(key);
		if (n != null) {
			updateFreqAndList(n);
//			System.out.println(dListList);
			return n.val;
		}
//		System.out.println(dListList);
		return -1;
	}

	public void put(int key, int value) {
		if(capacity <= 0) return;
		
		Node n = map.get(key);
		if (n == null) {
			if (count >= capacity) {
				dListList.removeLFNodeFromLFDList();
			}
			
			count++;
			n = new Node(key, value);
			map.put(key, n);
			DList list = freqMap.get(n.freq);
			if (list == null) {
				list = new DList();
				freqMap.put(n.freq, list);
				dListList.tail.addListBeforeSelf(list);
			}
			list.addToHead(n);
		} else {
			n.val = value;
			updateFreqAndList(n);
		}
//		System.out.println(dListList);
	}

	private void updateFreqAndList(Node n) {
		// update n freq
		n.freq++;
		// move n from DList to DList
			// remove n from source DList
		n.removeFromList();
		DList sourceList = freqMap.get(n.freq - 1);
		// if source DList length == 0
		if(sourceList.isEmpty()) {
			// remove source DList from freqMap and DListList
			sourceList.removeFromList();
			freqMap.remove(n.freq - 1);
		}
			// move n to target Dlist
		DList list = freqMap.get(n.freq);
			// if not exist target Dlist
		if (list == null) {
			list = new DList();
				// add DList to freqMap and DlistList
			freqMap.put(n.freq, list);
			sourceList.prev.addListAfterSelf(list);
		}
		// add n to DList
		list.addToHead(n);
	}
}
