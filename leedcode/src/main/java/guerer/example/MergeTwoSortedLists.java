package guerer.example;

/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 */

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode head = l1.val < l2.val ? l1 : l2;
		ListNode l = l1.val < l2.val ? l1 : l2;
		ListNode s = l1.val < l2.val ? l2 : l1;
		while(l.next != null && s != null) {
			if(l.next.val <= s.val) {
				l = l.next;
			} else {
				ListNode tmp = s.next;
				s.next = l.next;
				l.next = s;
				s = tmp;
				l = l.next;
			}
		}
		if(l.next == null) {
			l.next = s;
		}
		return head;
	}
}
