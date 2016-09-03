package guerer.example;

/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:


 begin to intersect at node c1.

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 */

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ta = headA;
		ListNode tb = headB;
		int an = 0;
		int bn = 0;
		while (ta != null) {
			ta = ta.next;
			an++;
		}
		while (tb != null) {
			tb = tb.next;
			bn++;
		}
		ta = headA;
		tb = headB;
		if (an > bn) {
			for (int i = an - bn; i > 0; i--) {
				ta = ta.next;
			}
		} else {
			for (int i = bn - an; i > 0; i--) {
				tb = tb.next;
			}
		}
		while (ta != tb) {
			ta = ta.next;
			tb = tb.next;
		}
		return ta;
	}
}
