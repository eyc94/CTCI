/*
-- Sum Lists --

You have two numbers represented by a Linked List, where each node contains
a single digit. The digits are stored in reverse order, such that the 1's digit
is at the head of the list. Write a function that adds the two numbers and returns
the sum as a Linked List.

EXAMPLE:
Input:      (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
Output:     (2 -> 1 -> 9). That is, 912.
*/

public class SumLists {

    /*
     * Recursive implementation.
     * 
     * Find out iterative later.
     */

    public static Node sumLists(Node first, Node second, int carry) {
        if (first == null && second == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;
        if (first != null) {
            value += first.data;
        }

        if (second != null) {
            value += second.data;
        }

        result.data = value % 10;

        if (first != null || second != null) {
            Node more = sumLists(first == null ? null : first.next, second == null ? null : second.next,
                    value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }
}
