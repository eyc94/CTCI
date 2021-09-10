# Big Oh
- Big O time is the language and metric used to describe the efficiency of algorithms.

## An Analogy
- Transferring files can be fast or slow.
- If you had a small file, it makes sense to send via email, FTP, or other means of electronic transfer.
- If the file is really big, it's faster to just fly by plane and drive by car to deliver.

## Time Complexity
- Describe data transfer runtime as:
    - Electronic Transfer: *O(s)* where *s* is the size of the file. Time to transfer file increases linearly with the size of the file.
    - Airplane Transfer: *O(1)* with respect to the size of the file. Time to transfer is independent on the size of the file. No matter how big the size, it still takes the same amount of time to reach destination via plane.
- Linear surpasses constant at some point in the graph.
- There are other runtimes:
    - *O(log N)*
    - *O(N log N)*
    - *O(N)*
    - *O(N<sup>2</sup>)*
    - *O(2<sup>N</sup>)*
    - There are many more.
- Can have more than one variable (dependency) in your runtime as well.

## Big O, Big Theta, and Big Omega
- Academics use big O, big &Theta; (theta), and big &Omega; (omega) to describe runtimes.
    - **O (big O)**: Describes an upper bound.
    - **&Omega; (big omega)**: Describes a lower bound.
    - **&Theta; (big theta)**: Describes a tight bound. &Theta; means both O and &Omega;.
- Industry uses O just like academics use &Theta;.

## Best Case, Worst Case, and Expected Case
- Describe our runtime for an algorithm in three different ways.
- Look at a Quick Sort example.
    - **Best Case**: If elements are equal, quick sort will traverse array once. This is *O(N)*.
    - **Worst Case**: If pivot is repeatedly the biggest element in array. This is *O(N<sup>2</sup>)* runtime.
    - **Expected Case**: Sometimes the best and worst does not happen. On average, it is *O(N log N)* runtime.
- Best case is useless.
- We deal with worst and expected more.

## Space Complexity
- We also care about the amount of space (or memory) required by an algorithm.
- Creating an array of size *n* requires *O(n)* space.
- If we need 2-D array of size *n* x *n*, it requires *O(n<sup>2</sup>)* space.
- Stack space in recursive calls count as well.
```java
int sum(int n) { /* Ex 1. */
    if (n <= 0) {
        return 0;
    }
    return n + sum(n - 1);
}
```
- Each call adds a level to the stack:
```
sum(4)
    -> sum(3)
        -> sum(2)
            -> sum(1)
                -> sum(0)
```
- These calls stack up and take up memory.
- Sometimes just because you have *n* calls total does not mean it takes *O(n)* space.
- The function below adds adjacent elements between 0 and *n*.
```java
int pairSumSequence(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += pairSum(i, i + 1);
    }
    return sum;
}

int pairSum(int a, int b) {
    return a + b;
}
```
- There will be *O(n)* calls to `pairSum`.
- Those calls do not exist at the same time on the call stack, so you only need *O(1)* space.

## Drop the Constants
- Sometimes *O(N)* code runs faster than *O(1)* for some inputs.
- Drop constants because we focus on rate of increase.
- *O(2N)* is the same as *O(N)*.
- Consider the two codes:
```java
int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;
for (int x : array) {
    if (x < min) min = x;
    if (x > max) max = x;
}
```
```java
int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;
for (int x : array) {
    if (x < min) min = x;
}
for (int x : array) {
    if (x > max) max = x;
}
```
- Which is faster?
- First code has one for loop and two lines of code.
- Second code has two for loops and one line of code per loop.
- Big O allows us to express how the runtime scales.

## Drop the Non-Dominant Terms
- What do you do when it's *O(N<sup>2</sup> + N)*?
- Second *N* isn't really important.
- Drop non-dominant terms.
    - *O(N<sup>2</sup> + N)* becomes *O(N<sup>2</sup>)*.
    - *O(N + log N)* becomes *O(N)*.
    - *O(5 * 2<sup>N</sup> + 1000N<sup>100</sup>)* becomes *O(2<sup>N</sup>)*.

## Multi-Part Algorithms: Add vs. Multiply
- Suppose you have an algorithm that has two steps.
- When do you add? When do you multiply the runtimes?
- Add the runtimes: *O(A + B)*
```java
for (int a : arrA) {
    print(a);
}

for (int b : arrB) {
    print(b);
}
```
- Multiply the runtimes: *O(A * B)*
```java
for (int a : arrA) {
    for (int b : arrB) {
        print(a + "," + b);
    }
}
```
- In the first code, we do *A* amount of work then *B* amount of work.
- In the second code, we do *B* amount of work for each element in *A*.

## Amortized Time
- An `ArrayList`, or a dynamically resizing array, allows you to have benefits of an array while being any size it wants.
- You cannot run out of space.
- When it reaches capacity, the `ArrayList` will create a new array with double the size of the old and copy over the old to the new array.
- If array is full, insertion takes *O(N)* time.
- Majority of the time, insertion will take *O(1)* time because it's not full.
- Amortized time takes both into account.
- We double capacity at 1, 2, 4, 8, 16, 32, ... X. It also takes that many copies in the worst case.
- Amortized time for insertion is *O(1)*.

## Log N Runtimes
- Look at Binary Search.
- We look for a value *X* in an *N*-element sorted array.
- Check if midpoint is equal to *X*.
- If it is, we found it. If it is greater, look at left half. It it is less, look at right half.
```
search 9 within {1, 5, 8, 9, 11, 13, 15, 19, 21}
    compare 9 to 11 -> smaller.
    search 9 within {1, 5, 8, 9, 11}
        compare 9 to 8 -> bigger
        search 9 within {9, 11}
            compare 9 to 9
            return
```
- We start with *N* element array. It is then cut to *N*/2 elements. Then to *N*/4 elements.
- We stop when we find the element or when we're down to just one element.
- Total runtime is just how many divides by 2 we can do to *N* until we reach 1.
```java
N = 16
N = 8
N = 4
N = 2
N = 1
```
- What is *k* in *2<sup>k</sup>* = *N*.
- *log<sub>2</sub>N* = *k* -> *2<sup>k</sup>* = *N*.
- When a problem gets halved every time, it's usually *O(log N)* runtime.
- Finding an element in a Balanced Binary Search Tree is *O(log N)*.

## Recursive Runtimes
```java
int f(int n) {
    if (n <= 1) {
        return 1;
    }
    return f(n - 1) + f(n - 1);
}
```
- What is the runtime of the above?
- People would say *O(N<sup>2</sup>)* because we call f twice.
    - Not correct!
- We can walk through the code.
- We can represent recursive calls with a resursive tree.
- How many calls are in the tree?
- The tree have a depth of *N*. Each node has two children. Each level will have twice as many calls as the one above it.

Level | # Nodes | Also expressed as... | Or...
---|---|---|---
0|1||2<sup>0</sup>
1|2|2 * previous level = 2|2<sup>1</sup>
2|4|2 * previous level = 2 * 2<sup>1</sup> = 2<sup>2</sup>|2<sup>2</sup>
3|8|2 * previous level = 2 * 2<sup>2</sup> = 2<sup>3</sup>|2<sup>3</sup>
4|16|2 * previous level = 2 * 2<sup>3</sup> = 2<sup>4</sup>|2<sup>4</sup>

- There will be 2<sup>0</sup> + 2<sup>1</sup> + 2<sup>2</sup> + 2<sup>3</sup> + ... + 2<sup>N</sup> (which is 2<sup>N + 1</sup> - 1) nodes.
- Remember this pattern:
    - When you have a recursive function that makes multiple calls, the runtime will often look like O(branches<sup>depth</sup>), where branches is the number of times each recursive call branches.
    - In this case, *O(2<sup>N</sup>)*.
- Base of an exponent matters.
    - Compare 2<sup>*N*</sup> with 8<sup>*N*</sup>.
    - If you expand 8<sup>*N*</sup>, you get (2<sup>3</sup>)<sup>*N*</sup> which is 2<sup>*3N*</sup>.
    - This then equals 2<sup>2*N*</sup> * 2<sup>*N*</sup>.
    - Different by a factor of 2<sup>2*N*</sup>. This is **not** a constant factor! So, we cannot ignore this.
- Space complexity will be *O(N)*.
    - We have *O(2<sup>N</sup>)* nodes in the tree total but only *O(N)* exists at a given time.

## Examples and Exercises