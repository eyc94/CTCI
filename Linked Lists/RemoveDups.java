/*
-- Remove Dups --

Write code to remove duplicates from an unsorted Linked List.
*/

import java.util.HashSet;

public class RemoveDups {

    /*
     * The idea here is to use a Hash Set to keep track of what number (data) we
     * have seen so far. Once we find a node we have seen before, we need to prepare
     * to remove this node.
     * 
     * Removal of this node is done by rearranging pointers. So, we must keep a
     * reference to our previous node (before current).
     * 
     * We iterate our current pointer until it reaches the end of the Linked List
     * (null). While iterating, we check whether we have seen the node's data or
     * not.
     * 
     * If we have not seen it, add the data to the Hash Set. Point prev pointer to
     * our current node to prepare for the next iteration.
     * 
     * If we have seen it, we need to remove it. Point the next pointer of our prev
     * node to the next node after our current node. This breaks any reference to
     * the current node, thereby removing the node from our Linked List.
     * 
     * 
     * Time Complexity: O(N) where N is the length of our Linked List.
     * 
     * Space Complexity: O(N) where N is the length of our Linked List.
     */

    public static void removeDups(Node n) {
        // Create a Hash Set.
        HashSet<Integer> set = new HashSet<>();
        // Create a pointer to previous node.
        Node prev = null;
        // Iterate while our n pointer is not null (reach end of list).
        while (n != null) {
            // If our current node's data was already seen, it's a duplicate.
            if (set.contains(n.data)) {
                // Point the next pointer of the previous node to the next node after current.
                prev.next = n.next;
            } else { // If it is our first time seeing this node.
                // Add the data to the Hash Set.
                set.add(n.data);
                prev = n; // Update the previous pointer before iterating n.
            }
        }
    }
}
