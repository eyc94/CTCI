# Arrays and Strings
- Array and string questions are usually interchangeable.

## Hash Tables
- Data structure that maps keys to values for efficient lookup.
- There are different implementations.
- Can use an array of linked lists and a hash code function.
- To insert a key:
    1. Compute the key's hash code. Two different keys can have the same hash code.
    2. Map the hash code to an index in the array. Can be done like `hash(key) % array_length`. Two different hash codes can map to the same index.
    3. At this index, there is a list of keys and values. We use a linked list because of collisions.
- To retrieve value pair by its key, you repeat this process. Compute hash code from key and compute index from hash code. Search linked list for the value with this key.
- If number of collisions is high, the worst case running time is *O(N)* where *N* is the number of keys.
- Generally assume good implementation that keeps collision to a minimum, so lookup time is *O(1)*.
- We can also implement a hash table using a balanced binary search tree.
    - This gives us an *O(log N)* lookup time.
    - Advantage is using less space.
    - We can iterate through the keys in order.

## ArrayList & Resizable Arrays
- Arrays (often called lists) are automatically resizable.
- The array or list grows as you append items.
- Arrays in Java are fixed (size defined on creation).
- ArrayList offers dynamic resizing.
- An ArrayList is an array that resizes itself as needed while still providing *O(1)* access.
    - Like when the array is full, we double the array's size.
    - Doubling takes *O(N)* time but happens so rarely that its amortized insertion time is *O(1)*.
```java
ArrayList<String> merge(String[] words, String[] more) {
    ArrayList<String> sentence = new ArrayList<String>();
    for (String w : words) sentence.add(w);
    for (String w : more) sentence.add(w);
    return sentence;
}
```
- Essential data structure.
- Name of data structure and resizing factor varies on programming language.

#### Why is the Amortized Insertion Runtime O(1)?
- Say you have an array of size *N*.
- Work backwards to compute how many elements we copied at each capacity increase.
- When we increase the array to *K* elements, the array was half that size. So, we needed to copy *K*/2 elements.
```
final capacity increase     : n/2 elements to copy
previous capacity increase  : n/4 elements to copy
previous capacity increase  : n/8 elements to copy
previous capacity increase  : n/16 elements to copy
...
second capacity increase    : 2 elements to copy
first capacity increase     : 1 element to copy
```
- Total number of copies to insert *N* elements is roughly *N*/2 + *N*/4 + *N*/8 + ... + 2 + 1, which is just less than *N*.
- Inserting *N* elements takes *O(N)* work total.
- Each insertion is *O(1)* on average, even though some insertions take *O(N)* time in the worst case.

## StringBuilder
- Imagine concatenating a list of strings.
- What would the running time of this code be?
- Assume that the strings are all the same length (call this *x*) and that there are *n* strings.
```java
String joinWords(String[] words) {
    String sentence = "";
    for (String w : words) {
        sentence = sentence + w;
    }
    return sentence;
}
```
- On each concatention, a new copy of the string is created and the two strings are copied over, character by character.
- First iteration requires us to copy *x* characters.
- Second iteration requires copying 2*x* characters.
- Third iteration requires copying 3*x* characters and so on.
- Total time is therefore *O(x + 2x + 3x + ... + nx)*.
- This reduces to *O(xn<sup>2</sup>)*.
    - This is because 1 + 2 + ... + *n* equals *n*(*n* + 1)/2 or *O(n<sup>2</sup>)*.
- `StringBuilder` helps avoid this problem.
    - It creates resizable array of all the strings, copying them back to a string only when necessary.
```java
String joinWords(String[] words) {
    StringBuilder sentence = new StringBuilder();
    for (String w : words) {
        sentence.append(w);
    }
    return sentence.toString();
}
```