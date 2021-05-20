package linkedlist;

import java.util.List;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output:2 -> 1 -> 9.That is,912.
 */
class _02_05_SumListReverse {
    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null ) return l2;
        if (l2 == null ) return l1;
        int carry = 0;
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode total = dummy;
        int sum;
        while (l1 != null && l2 != null) {
             sum = carry + l1.val + l2.val;
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            total.next = new LinkedListNode(sum % 10 );
            l1 = l1.next;
            l2 = l2.next;
            total = total.next;
        }
        if (carry > 0) {
            total.next = new LinkedListNode(carry );
        }
        return dummy.next;
    }
}
