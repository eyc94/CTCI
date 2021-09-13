/*
-- Delete Middle Node --

Implement an algorithm to delete a node in the middle (i.e., any node but
the first and the last node, not necessarily the exact middle) of a singly
linked list, given only access to that node.
*/

public class DeleteMiddleNode {

    /*
     * To delete the middle node, we do NOT need reference to our previous node
     * (node before the node to remove).
     *
     * We copy the next node to the current node. Therefore, we have two nodes with
     * the same data. We just need one. So, we delete the next node because our
     * current node serves as a reference to prev. This makes it seem like we
     * deleted the middle node. We just copied the value over.
     * 
     * Time Complexity: O(1) because there was no traversal.
     * 
     * Space Complexity: O(1).
     */

    public static boolean deleteMiddleNote(Node n) {
        // If the node is empty or if the node is the last element.
        // This means that if the node given is the middle, there is nothing to remove.
        if (n == null || n.next == null) {
            return false;
        }

        // Point the next pointer to the node after given node.
        Node next = n.next;
        // Copy the next node's data to the current node's data.
        n.data = next.data;
        // Remove the next node from the linked list.
        n.next = next.next;
        // Return true to denote success.
        return true;
    }
}
