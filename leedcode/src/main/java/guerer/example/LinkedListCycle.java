package guerer.example;

/*
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}
		
		ListNode t = head.next;
		while(t != null && t != head) {
			head.next = t.next;
			t.next = head;
			t = head.next;
		}
		return t == head;
	}
}
