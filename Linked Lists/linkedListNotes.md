# Linked Lists
- Data structure that represents a sequence of nodes.
- In a Singly Linked List, each node points to the next node in the Linked List.
- A Doubly Linked List gives each node pointers to both the next node and the previous node.
- Linked List does not provide constant time access to an index.
- If you'd like to find the Nth element in the list, you need to traverse N elements.
- Benefit is you can add or remove in constant time.

## Creating a Linked List
- Implementation of a Singly Linked List
```java
class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
```
- Access Linked List through a reference to the head `Node` of the Linked List.

## Deleting a Node from a Singly Linked List
- Given a node *n*, we find the previous node `prev` and set `prev.next` equal to `n.next`.
- If it is doubly linked, also update `n.next` to set `n.next.prev` equal to `n.prev`.
- Important to check for null pointer and update head or tail pointer as necessary.
```java
Node deleteNode(Node head, int d) {
    Node n = head;

    if (n.data == d) {
        return head.next; /* moved head */
    }

    while (n.next != null) {
        if (n.next.data == d) {
            n.next = n.next.next;
            return head; /* head didn't change */
        }
        n = n.next;
    }
    return head;
}
```