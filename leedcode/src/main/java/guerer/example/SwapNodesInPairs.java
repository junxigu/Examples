package guerer.example;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 */

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head != null && head.next != null) {
			ListNode t = head.next;
			head.next = t.next;
			t.next = head;
			head = t;
			ListNode h = head.next;
			while(h.next != null && h.next.next != null) {
				t = h.next.next;
				h.next.next = t.next;
				t.next = h.next;
				h.next = t;
				h = t.next;
			}
		}
		return head;
	}
}
