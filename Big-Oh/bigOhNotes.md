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
