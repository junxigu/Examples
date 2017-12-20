package guerer.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				return n1.val > n2.val ? 1 : n1.val == n2.val ? 0 : -1;
			}
		});
		for (ListNode n : lists) {
			if (n != null) {
				q.offer(n);
			}
		}

		ListNode h = new ListNode(0);
		ListNode t = h;
		while (!q.isEmpty()) {
			t.next = q.poll();
			t = t.next;
			if(t.next != null) {
				q.offer(t.next);
			}
		}
		return h.next;
	}
}
