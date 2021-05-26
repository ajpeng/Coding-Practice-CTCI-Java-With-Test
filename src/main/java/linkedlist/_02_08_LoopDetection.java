package linkedlist;

import java.util.HashSet;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * <p>
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * <p>
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C[the same C as earlier]
 * Output: C
 */
class _02_08_LoopDetection {

    LinkedListNode detect(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) return null;

        fast = head;
        while (fast != slow ) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // Has issues handling recursive cases
    LinkedListNode detect2(LinkedListNode head) {
        HashSet<LinkedListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
