/*
-- Remove Kth to Last --

Implement an algorithm to find the kth to last element of a singly linked list.
*/

public class ReturnKthToLast {

    /*
     * We use two pointers and spread them apart by k nodes. We first move our
     * 'first' pointer 'k' nodes forward.
     * 
     * Now, 'first' and 'second' are 'k' nodes apart. We then move them together.
     * When 'first' reaches the end of the list, our 'second' pointer will be
     * pointing to the kth to last node of the list.
     * 
     * Time Complexity: O(N) where N is the length of our Linked List.
     * 
     * Space Complexity: O(1).
     */

    public static Node returnKthToLast(Node head, int k) {
        // Create two pointers.
        Node first = head; // Moves first.
        Node second = head; // Moves second.

        // Let's first move 'first' 'k' nodes forward.
        for (int i = 0; i < k; i++) {
            // Return null if the first is empty.
            if (first == null) {
                return null;
            }
            // Move first pointer.
            first = first.next;
        }

        // Move both first and second at the same time.
        while (first != null) {
            second = second.next;
            first = first.next;
        }

        // Return the second pointer.
        return second;
    }
}
