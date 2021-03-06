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
#### Example 1
```java
void foo(int[] array) {
    int sum = 0;
    int product = 1;
    for (int i = 0; i < array.length; i++) {
        sum += array[i];
    }
    for (int i = 0; i < array.length; i++) {
        product *= array[i];
    }
    System.out.println(sum + ", " + product);
}
```
- The first two lines are constant.
- The two for loops each take *O(N)* time.
- This will take *O(N)* time. Iterating through array twice makes no difference on runtime.

#### Example 2
```java
void printPairs(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[i] + ", " + array[j]);
        }
    }
}
```
- The inner for loop runs the length of the array *N* for every loop in the outer loop.
- The outer loop also spans the length of the array.
- The work done in the inner loop is constant *O(1)*.
- The total work done is *O(N<sup>2</sup>)*.

#### Example 3
```java
void printUnorderedPairs(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
            System.out.println(array[i] + ", " + array[j]);
        }
    }
}
```
- The inner loop does one less work than the previous iteration for every iteration of the outer loop.
- We can solve in several ways:
    - **Counting the Iterations**:
        - In the first iteration, *j* runs for *N* - 1 steps. The second, it's *N* - 2 steps. Then *N* - 3 steps. And so on.
        - The total steps is (*N* - 1) + (*N* - 2) + (*N* - 3) + ... + 2 + 1.
        - This equals 1 + 2 + 3 + ... + *N* - 1.
        - This is the sum from 1 to *N* - 1.
        - Sum of 1 to *N* - 1 is *N*(*N* - 1)/2.
        - Runtime is *O(N<sup>2</sup>)*.
    - **What It Means**:
        - It iterates through each pair of values (*i*, *j*) where *j* > *i*.
        - There are *N*<sup>2</sup> total pairs. Half of them will have *i* < *j* and other half *i* > *j*.
        - Code goes through about *N*<sup>2</sup>/2 pairs.
    - **Visualizing What It Does**:
        ```
        (0, 1) (0, 2) (0, 3) (0, 4) (0, 5) (0, 6) (0, 7)
               (1, 2) (1, 3) (1, 4) (1, 5) (1, 6) (1, 7)
                      (2, 3) (2, 4) (2, 5) (2, 6) (2, 7)
                             (3, 4) (3, 5) (3, 6) (3, 7)
                                    (4, 5) (4, 6) (4, 7)
                                           (5, 6) (5, 7)
                                                  (6, 7)
        ```
        - This is half a *N* x *N* matrix.
    - **Average Work**:
        - Outer loop runs *N* times.
        - Inner loop varies in each iteration, but we can think of the average iteration.
        - What is average value of 1, 2, 3, 4, 5, 6, 7, 8, 9, 10? It is 5.
        - What about for 1, 2, 3, ..., *N*? It is *N*/2.
        - Inner loop does about *N*/2 work and runs *N* times, so it's *N*<sup>2</sup>/2.

#### Example 4
```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
    for (int i = 0; i < arrayA.length; i++) {
        for (int j = 0; j < arrayB.length; j++) {
            if (arrayA[i] < arrayB[j]) {
                System.out.println(arrayA[i] + ", " + arrayB[j]);
            }
        }
    }
}
```
- The if statement in the inner loop does constant work.
- The outer loop for *A* does constant work for every element of *B*.
- The runtime is *O(AB)*.

#### Example 5
```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
    for (int i = 0; i < arrayA.length; i++) {
        for (int j = 0; j < arrayB.length; j++) {
            for (int k = 0; k < 100000; k++) {
                System.out.println(arrayA[i] + ", " + arrayB[j]);
            }
        }
    }
}
```
- The code in the inner loop is still constant because we're still always doing 100000 loops regardless of input size.
- The runtime is same as Example 4, *O(AB)*.

#### Example 6
```java
void reverse(int[] array) {
    for (int i = 0; i <  array.length / 2; i++) {
        int other = array.length - i - 1;
        int temp = array[i];
        array[i] = array[other];
        array[other] = temp;
    }
}
```
- This only goes through half of our array.
- Runtime is *O(N)*.

#### Example 7
- Which are equivalent to *O(N)*? Why?
    1. *O(N + P)*, where *P* < *N*/2.
        - Yes because *P* is going to be smaller than *N*, *N* is the dominant term.
    2. *O(2N)*.
        - Yes because we drop the coefficient/constant 2.
    3. *O(N + log N)*.
        - Yes because log *N* is smaller than *N* and *N* dominates in the long run.
    4. *O(N + M)*.
        - No because we do not know if *M* = *N*. We have no info on *M*.

#### Example 8
- We have an algorithm that takes in an array of strings, sorted each string, and then sorted the full array.
    - What is the runtime?
- Most would say this:
    1. Sorting each string is *O(N log N)*.
    2. We have to do this for each string, so *O(N * N log N)*.
    3. We have to sort the array, so that's another *O(N log N)*.
    4. Total runtime is *O(N<sup>2</sup> log N + N log N)* which is just *O(N<sup>2</sup> log N)*.
- This is wrong because *N* represents both the length of the string and length of the array!
    - They're not always equal length!!
- Let's fix this:
    1. Define *s* to be length of longest string.
    2. Define *a* to be length of array.
    3. Sorting each string is *O(s log s)*.
    4. Do this for each string in the array, so *O(a * s log s)* because there are *a* strings.
    5. Now sort strings.
    6. You need to compare the strings. Each string comparison takes *O(s)* time.
    7. There are *O(a log a)* comparisons. Therefore, *O(a * s log a)*.
    8. Add these two parts to get *O(a * s(log a + log s))*.

#### Example 9
- This code sums the values of all nodes in a Balanced Binary Search Tree.
```java
int sum(Node node) {
    if (node == null) {
        return 0;
    }
    return sum(node.left) + node.value + sum(node.right);
}
```
- Two ways to look at this:
    - **What It Means**:
        - This code touches each node in the tree.
        - This does constant work for each touch (not recursive calls).
        - The runtime will be linear in terms of the number of nodes.
        - *N* nodes means *O(N)* runtime.
    - **Recursive Pattern**:
        - We discussed pattern for recursive calls to be branches.
        - Runtime is typically *O(branches<sup>depth</sup>)*.
        - There are 2 branches at each call, so *O(2<sup>depth</sup>)*.
        - Look exponential so it looks wrong!
        - We have an exponential time algorithm but it's not as bad.
        - Consider what variable it's exponential with respect to.
        - What is depth? Tree is balanced binary search tree. If there are *N* total nodes, then depth is log *N*.
        - Therefore, *O(2<sup>log N</sup>)*.
            - Recall, 2<sup>*P*</sup> = *Q* -> log<sub>2</sub>*Q* = *P*.
            - Therefore, 2<sup>log *N*</sup> = *N*.
        - Runtime overall is *O(N)*.

#### Example 10
- This code determines if a number is prime or not.
- This is done by checking the divisibility on numbers less than *n*.
- It goes up to the square root of *n*.
    - If *n* is divisible by a number larger than *n*'s square root, then *n* is divisible by something smaller than it.
```java
boolean isPrime(int n) {
    for (int x = 2; x * x <= n; x++) {
        if (n % x == 0) {
            return false;
        }
    }
    return true;
}
```
- Work inside for loop is constant.
- Just show how many iterations our for loop goes through in the worst case.
- The for loop starts when *x* = 2 and ends when *x* * *x* = *n*.
    - Or, when *x* = *n*<sup>1/2</sup>.
- The loop is basically the same as below:
```java
boolean isPrime(int n) {
    for (int x = 2; x <= sqrt(n); x++) {
        if (n % x == 0) {
            return false;
        }
    }
    return true;
}
```
- The runtime is *O(N<sup>1/2</sup>)*.

#### Example 11
- The following code computes *n*! (n factorial). What is the time complexity?
```java
int factorial(int n) {
    if (n < 0) {
        return -1;
    } else if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}
```
- This is a straight recursion from *n* to *n* - 1 to *n* - 2 down to 1.
- This will take *O(N)* time.

#### Example 12
- This code counts all permutations of a string.
```java
void permutation(String str) {
    permutation(str, "");
}

void permutation(String str, String prefix) {
    if (str.length() == 0) {
        System.out.println(prefix);
    } else {
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            permutation(rem, prefix + str.charAt(i));
        }
    }
}
```
- Look at how many times `permutation` gets called and how long each call takes.
- Aim for tight bound.
    - **How many times does permutation get called in its base case?**:
        - If we were making a permutation, we need a character for each "slot".
        - We have 7 characters in a string.
        - Pick one character and we have 6 choices for the next slot. THen 5 for the next slot and so on.
        - So, total number of options is 7 * 6 * 5 * 4 * 3 * 2 * 1, which is 7! (7 factorial).
        - There are *n*! permutations.
        - So, `permutation` is called *n*! times in its base case when `prefix` is the full permutation.
    - **How many times does permutation get called before its base case?**:
        - We also need to find out many times the for loop is hit.
        - Imagine a large call tree representing all the calls.
        - There are *n*! leaves.
        - Each leaf is attached to a path of length *n*.
        - We know, therefore, there will be no more than *n* * *n*! nodes in this tree.
    - **How long does each function call take?**:
        - Executing the print statement takes *O(N)* time because each character needs to be printed.
        - The lines inside the for loop also takes *O(N)* time combined due to string concatenation.
        - The sum of the lengths of `rem`, `prefix`, and `str.charAt(i)` will always be *n*.
        - Each node in our tree therefore corresponds to *O(N)* work.
    - **What is the total runtime?**:
        - We are calling `permutation` *O(N * N!)* times (upper bound), and each one takes *O(N)* time.
        - The total runtime will not exceed *O(N<sup>2</sup> * N!)*.

#### Example 13
- The code below computes the Nth Fibonacci number.
```java
int fib(int n) {
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
}
```
- Use earlier pattern for recursive calls: *O(branches<sup>depth</sup>)*.
- 2 branches per call and we go as deep as *N*.
- There the runtime is *O(2<sup>N</sup>)*.

#### Example 14
- The code prints all Fibonacci numbers from 0 to *n*.
```java
void allFib(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(i + ": " + fib(i));
    }
}

int fib(int n) {
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
}
```
- Many say that because `fib(n)` takes *O(2<sup>N</sup>)* time and it's called *N* times, then it's *O(N2<sup>N</sup>)*.
- This is wrong.
- The error is that *N* is changing.
- Let's walk through each call.
```
fib(1) -> 2^1 steps
fib(2) -> 2^2 steps
fib(3) -> 2^3 steps
fib(4) -> 2^4 steps
...
fib(n) -> 2^n steps
```
- Total work is 2<sup>1</sup> + 2<sup>2</sup> + 2<sup>3</sup> + 2<sup>4</sup> + ... + 2<sup>N</sup>.
- This is 2<sup>N + 1</sup>.
- Runtime is still *O(2<sup>N</sup>)*.

#### Example 15
- This code prints all Fibonacci numbers from 0 to *n*.
- This time it stores (caches) previously computed values in an integer array.
- If it has been computed, it just returns the cache.
```java
void allFib(int n) {
    int[] memo = new int[n + 1];
    for (int i = 0; i < n; i++) {
        System.out.println(i + ": " + fib(i, memo));
    }
}

int fib(int n, int[] memo) {
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    else if (memo[n] > 0) return memo[n];

    memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    return memo[n];
}
```
- Let's walk through what happens:
```
fib(1) --> return 1
fib(2)
    fib(1) -> return 1
    fib(0) -> return 0
    store 1 at memo[2]
fib(3)
    fib(2) -> lookup memo[2] -> return 1
    fib(1) -> return 1
    store 2 at memo[3]
fib(4)
    fib(3) -> lookup memo[3] -> return 2
    fib(2) -> lookup memo[2] -> return 1
    store 3 at memo[4]
fib(5)
    fib(4) -> lookup memo[4] -> return 3
    fib(3) -> lookup memo[3] -> return 2
    store 5 at memo[5]
...
```
- At each call `fib(i)`, we already computed and stored values for `fib(i - 1)` and `fib(i - 2)`.
- Look those values up, sum them, store the new result, and return.
- This takes constant time.
- We do this constant work *N* times, so this is *O(N)* time.
- This is called **Memoization**.

#### Example 16
- The function prints the power of 2 from 1 through *n* (inclusive).
- If *n* is 4, it prints 1, 2, and 4.
```java
int powersOf2(int n) {
    if (n < 1) {
        return 0;
    } else if (n == 1) {
        System.out.println(1);
        return 1;
    } else {
        int prev = powersOf2(n / 2);
        int curr = prev * 2;
        System.out.println(curr);
        return curr;
    }
}
```
- There are several ways to compute runtime:
    - **What It Does?**:
        - Walk through a call like `powersOf2(50)`.
            ```
            -> powersOf2(50)
                -> powersOf2(25)
                    -> powersOf2(12)
                        -> powersOf2(6)
                            -> powersOf2(3)
                                -> powersOf2(1)
                                    -> print & return 1
                                print & return 2
                            print & return 4
                        print & return 8
                    print & return 16
                print & return 32
            ```
        - Runtime is the number of times we can divide 50 (or n) by 2 until we get down to the case case (1).
        - The number of times we halve *n* until we get 1 is *O(log N)*.
    - **What It Means**:
        - It's supposed to be computing the powers of 2 from 1 to *n*.
        - Calls to `powersOf2` results in one number being printed and returned.
        - If algorithm prints 13 values, `powersOf2` is called 13 times.
        - We are told that it prints all powers of 2 between 1 and *n*. So, the number of times the function is called must be the same as the number of powers of 2 between 1 and *n*.
        - There are `log N` powers of 2 between 1 and *n*.
        - Runtime is *O(log N)*.
    - **Rate of Increase**:
        - Think about how runtimes change as *n* gets bigger.
        - Number of calls to `powersOf2` increases by 1 each time *n* doubles in size.
        - The number of calls to `powersOf2` is the number of times you can double 1 until you get *n*.
        - It is *x* in the equation: 2<sup>x</sup> = *n*.
        - What is *x*? It is `log n`.
        - Runtime is *O(log N)*.