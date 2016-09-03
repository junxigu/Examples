package guerer.example;

/*
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5 
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode h = head;
		while (h != null && h.val == val) {
			h = h.next;
		}
		if (h == null) {
			return null;
		}
		ListNode p = h;
		ListNode c = h.next;
		while (c != null) {
			if (c.val == val) {
				p.next = c.next;
			} else {
				p = c;
			}
			c = c.next;
		}
		return h;
	}
}
