package linkedlist;

import java.util.Objects;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is de ned based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */
class  _02_07_Intersection {

    boolean intersects(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null || l2 == null) return false;
        LinkedListNode h1 = l1;
        LinkedListNode h2 = l2;

        while (!h1.equals(h2)) {
            h1 = h1.next;
            h2 = h2.next;

            if ( h1 == null && h2 == null) {
                return false;
            }

            if (h1 == h2) {
                return true;
            }

            if (h1 == null ) {
                h1 = l2;
            }

            if (h2 == null) {
                h2 = l1;
            }
        }
        return false;
    }
}
