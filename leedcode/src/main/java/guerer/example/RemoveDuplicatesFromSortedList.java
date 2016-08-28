package guerer.example;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode c = head;
		while (c != null && c.next != null) {
			if (c.val == c.next.val) {
				c.next = c.next.next;
			} else {
				c = c.next;
			}
		}
		return head;
	}
}
