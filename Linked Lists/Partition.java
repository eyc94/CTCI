/*
-- Partition --

Write code to partition a Linked List around a value 'x', such that all nodes
less than 'x' come before all nodes greater than or equal to 'x'. If 'x' is contained
within the list, the values of 'x' only need to be after the elements less than 'x'.
The partition element 'x' can appear anywhere in the "right partition"; it does not
need to appear between the left and right partitions.

EXAMPLE:
Input:      3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
Output:     3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/

public class Partition {

    /*
     * This solution is easy. We basically just create two Linked Lists. The left
     * half contains all node values less than 'x'. The right half will contain all
     * values greater than or equal to x.
     * 
     * We then merge the two lists together.
     * 
     * We keep a reference to the head and tails of both the left and right halves.
     * 
     * Time Complexity: O(N) where N is the length of the linked list.
     * 
     * Space Complexity: O(1) because we do not use additional space.
     */

    public static void partition(Node node, int x) {
        // Create pointers to the start and end nodes of the left and right halves.
        Node beforeStart = null; // Head of left half.
        Node beforeEnd = null; // Tail of left half.
        Node afterStart = null; // Head of right half.
        Node afterEnd = null; // Tail of right half.

        // Iterate while node is not null.
        while (node != null) {
            // Make a reference to the next node to look at.
            Node next = node.next;
            // Detach the current node from its list.
            node.next = null;

            // If the current node's value is less than partition value x.
            if (node.data < x) {
                // If left half is empty.
                if (beforeStart == null) {
                    // Left head points to the current node.
                    beforeStart = node;
                    // Left tail points to the current node.
                    beforeEnd = beforeStart;
                } else { // If left half is NOT empty.
                    // Left tail's next pointer points to current node.
                    beforeEnd.next = node;
                    // Left tail updates to added node.
                    beforeEnd = node;
                }
            } else { // If the current node's value is greater than or equal to partition value x.
                // If the right half is empty.
                if (afterStart == null) {
                    // Add the current node to the right half as its head.
                    afterStart = node;
                    // Update the right half tail to point to node.
                    afterEnd = afterStart;
                } else { // If the right half is NOT empty.
                    // Point the right tail's next point to the new node to add.
                    afterEnd.next = node;
                    // Update the tail to be the new node added.
                    afterEnd = node;
                }
            }
            // Move the current node to the next node to process.
            node = next;
        }

        // If our left half is empty (every node is greater than or equal to x).
        if (beforeStart == null) {
            // Return the right half.
            return afterStart;
        }

        // If our left half is NOT empty, connect left half tail to the right half head.
        beforeEnd.next = afterStart;
        // Return the head of the left half, as it is the head of the whole thing.
        return beforeStart;
    }
}
