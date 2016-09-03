package guerer.example;

/*
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode c = head;
		int n = 1;
		while (c.next != null) {
			c = c.next;
			n++;
		}
		int halfN = n / 2 + (n % 2);
		c = head;
		ListNode p = null;
		for (int i = 0; i < halfN; i++) {
			p = c;
			c = c.next;
		}

		ListNode t = null;
		while (c != null) {
			t = c.next;
			c.next = p;
			p = c;
			c = t;
		}
		c = head;
		int i = n / 2;
		for (; i > 0 && p.val == c.val; i--, p = p.next, c = c.next) {
		}
		return i == 0;
	}
}
