package linkedlist;

import java.util.LinkedList;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in normal order, such that the 1 's digit is at the tail of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is, 716 + 592.
 * Output:1 -> 4 -> 0 -> 8.That is, 1408.
 */
class _02_05_SumList {

    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        int int1 = getIntValue(l1);
        int int2 = getIntValue(l2);
        return createLL(int1 + int2);
    }

    static int getIntValue(LinkedListNode head) {
        if (head == null ) return 0;
        int val = 0;
        // get length of linkedlist
        LinkedListNode temp = head;
        int digits = 0;
        while (temp != null && temp.next != null) {
            digits++;
            temp = temp.next;
        }
        LinkedListNode cur = head;
        while (digits >= 0) {
            val += Math.pow(10, digits) * cur.val;
            digits--;
            cur = cur.next;
        }
        return val;
    }

    static LinkedListNode createLL(int val) {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedListNode head = new LinkedListNode(Integer.MIN_VALUE);
        LinkedListNode cur = head;
        while (val > 0) {
            stack.push(val % 10);
            val /= 10;
        }
        while (!stack.isEmpty()) {
            LinkedListNode tmp = new LinkedListNode(stack.pop());
            head.next = tmp;
            head = head.next;
        }
        return cur.next;
    }

}
