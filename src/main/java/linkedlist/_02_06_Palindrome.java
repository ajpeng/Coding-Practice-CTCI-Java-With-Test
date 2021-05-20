package linkedlist;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
class _02_06_Palindrome {
    // reverse and compare sol
    boolean isPalindrome(LinkedListNode head) {
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


}
