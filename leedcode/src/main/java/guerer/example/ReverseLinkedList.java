package guerer.example;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode p = null;
		while (head != null) {
			ListNode n = head.next;
			head.next = p;
			p = head;
			head = n;
		}
		return p;
	}
}
