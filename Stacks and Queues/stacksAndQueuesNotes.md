# Stacks and Queues

## Implementing a Stack
- Like a stack of data.
- Uses LIFO (last-in first-out) ordering.
    - The most recent item added to the stack is the first to be removed.
- Uses the following operations:
    - `pop()`: Remove the top item from the stack.
    - `push(item)`: Add an item to the top of the stack.
    - `peek()`: Return the top of the stack.
    - `isEmpty()`: Return true if and only if the stack is empty.
- No constant time access.
- Constant time add/removes.
- Can be implemented using array or linked list.

## Implementing a Queue
- Uses FIFO (first-in first-out) ordering.
- Like a line.
- Uses the following operations:
    - `add(item)`: Add an item to the end of the list.
    - `remove()`: Remove the first item in the list.
    - `peek()`: Return the top of the queue.
    - `isEmpty()`: Return true if and only if the queue is empty.
- Can be implemented with a linked list.
- Breadth-first search or cache implementation.