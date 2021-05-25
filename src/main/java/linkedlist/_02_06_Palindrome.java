package linkedlist;

import java.util.Stack;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
class _02_06_Palindrome {
    // reverse and compare solutions
    boolean isPalindromeBrute(LinkedListNode head) {
        LinkedListNode reversed = reverseLL(head);
        while (head != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    static LinkedListNode reverseLL(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.val);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isPalindrome(LinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // skipping middle value of palindrome
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }


}
