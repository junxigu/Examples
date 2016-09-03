package guerer.example;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
 Given n will always be valid.
 Try to do this in one pass. 
 */

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = null;
		ListNode c = head;
		// care full n time first
		for (int i = 0; i < n && c != null; i++) {
			c = c.next;
		}
		if (c == null) {
			head = head.next;
		} else {
			p = head;
			// care full the c.next not null
			for (; c.next != null; c = c.next) {
				p = p.next;
			}
			p.next = p.next.next;
		}
		return head;
	}
}
