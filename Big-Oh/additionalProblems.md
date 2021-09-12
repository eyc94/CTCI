# Additional Problems

#### Problem 1
The following code computes the product of *a* and *b*. What is its runtime?
```java
int product(int a, int b) {
    int sum = 0;
    for (int i = 0; i < b; i++) {
        sum += a;
    }
    return sum;
}
```
- The `sum` declaration is constant work.
- The for loop iterates from 0 to *b*.
- The work inside the loop is constant as well.
- This constant work is done *b* times.
- The runtime is *O(b)*.

#### Problem 2
The code computes *a*<sup>*b*</sup>. What is its runtime?
```java
int power(int a, int b) {
    if (b < 0) {
        return 0; // error
    } else if (b == 0) {
        return 1;
    } else {
        return a * power(a, b - 1);
    }
}
```
- The first case is when the input is immediately a negative exponent. This is constant work.
- The second case is the base case of when exponent is 0.
- It is only when we get to the last case.
- We recursively call the same base and 1 less than the current exponent until we reach the base case of 0.
- We call the function `power` until the *b* reaches 0.
- So, *b* + *b* - 1 + *b* - 2 + *b* - 3 + ... + 0 is the amount of times we call `power`.
- The runtime is just *O(b)*.

#### Problem 3
The following code computes *a* % *b*. What is its runtime?
```java
int mod(int a, int b) {
    if (b <= 0) {
        return -1;
    }
    int div = a / b;
    return a - div * b;
}
```
- These are all statements that do constant work.
- There is no loop that performs the work multiple times.
- Therefore, the runtime is constant *O(1)*.

#### Problem 4
The code performs integer division. What is its runtime (assume *a* and *b* are positive)?
```java
int div(int a, int b) {
    int count = 0;
    int sum = b;
    while (sum <= a) {
        sum += b;
        count++;
    }
    return count;
}
```
- The first two lines are constant.
- The while loop runs as long as our `sum` is <= `a`.
- We do constant work in this loop until `sum` reaches `a`.
- We add *b* to `sum` in every loop.
- The runtime is *O(a/b)*. The `count` variable eventually equals *a*/*b*.
- This is how many times the while loop iterates.

#### Problem 5
The code below computes the (integer) square root of a number. If the number is not a perfect square (there is not integer square root), then it returns -1. Does this by successive guessing. If *n* is 100, it first guesses 50. Too high? Try something lower - halfway between 1 and 50. What is its runtime?
```java
int sqrt(int n) {
    return sqrt_helper(n, 1, n);
}

int sqrt_helper(int n, int min, int max) {
    if (max < min) return -1; // no square root

    int guess = (min + max) / 2;
    if (guess * guess == n) { // found it!
        return guess;
    } else if (guess * guess < n) { // too low
        return sqrt_helper(n, guess + 1, max); // try higher
    } else { // too high
        return sqrt_helper(n, min, guess - 1); // try lower
    }
}
```
- We call our helper function.
- The first line in our helper function is constant work.
- The `guess` variable is also constant work.
- The first case is constant work.
- The second and third case are recursive calls to the upper and lower half.
- We see that it's cut in half on each call.
- Overall runtime is *O(log N)*.

#### Problem 6
The following code computes the (integer) square root of a number. If number is not a perfect square (there is no integer square root), then return -1. It does this by trying increasingly large numbers until it finds the right value (or is too high). What is its runtime?
```java
int sqrt(int n) {
    for (int guess = 1; guess * guess <= n; guess++) {
        if (guess * guess == n) {
            return guess;
        }
    }
    return -1;
}
```
- The runtime is *O(N<sup>1/2</sup>)*.
- This loop stops when `guess * guess > n`.

#### Problem 7
If a binary search tree is not balanced, how long might it take (worst case) to find an element in it?
- In the worst case, the binary search tree would be a linked list.
- It would also be the leaf (last element) of the tree.
- The runtime for a worst case unbalanced binary search tree is *O(N)*.

#### Problem 8
You are looking for a specific value in a binary tree, but the tree is not a binary search tree. What is the time complexity of this?
- Without any ordering property of the nodes, we may have to search through all of them.
- The runtime is *O(N)*.

#### Problem 9
The `appendToNew` method appends a value to an array by creating a new, longer array and returning this longer array. You have used the `appendToNew` method to create a `copyArray` function that repeatedly calls `appendToNew`. How long does copying an array take?
```java
int[] copyArray(int[] array) {
    int[] copy = new int[0];
    for (int value : array) {
        copy = appendToNew(copy, value);
    }
}

int[] appendToNew(int[] array, int value) {
    // Copy all elements over to new array
    int[] bigger = new int[array.length + 1];
    for (int i = 0; i < array.length; i++) {
        bigger[i] = array[i];
    }

    // Add new element
    bigger[bigger.length - 1] = value;
    return bigger; 
}
```
- The runtime here is *O(N<sup>2</sup>)*.
- First call to `appendToNew` takes 1 copy.
- The second call takes 2 copies.
- Third call 3 copies. And so on.
- Total time is the sum of 1 to *n*, which is *O(N<sup>2</sup>)*.

#### Problem 10
The following code sums the digits in a number. What is its big O time?
```java
int sumDigits(int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}
```
- We see that *n* keeps dividing by 10 (integer division) every iteration of the while loop.
- It loses one digit after each iteration.
- The loop lasts for the duration of the number's length (number of digits).
- A number of *d* digits can have a value up to 10<sup>*d*</sup>.
- If *n* = 10<sup>*d*</sup>, then *d* = log *n*.
- The runtime is *O(log N)*.

#### Problem 11
The following code prints all strings of length *k* where the characters are in sorted order. It does this by generating all strings of length *k* and then checking if each is sorted. What is its runtime?
```java
int numChars = 26;

void printSortedStrings(int remaining) {
    printSortedStrings(remaining, "");
}

void printSortedStrings(int remaining, String prefix) {
    if (remaining == 0) {
        if (isInOrder(prefix)) {
            System.out.println(prefix);
        }
    } else {
        for (int i = 0; i < numChars; i++) {
            char c = ithLetter(i);
            printSortedStrings(remaining - 1, prefix + c);
        }
    }
}

boolean isInOrder(String s) {
    for (int i = 1; i < s.length(); i++) {
        int prev = ithLetter(s.charAt(i - 1));
        int curr = ithLetter(s.charAt(i));
        if (prev > curr) {
            return false;
        }
    }
    return true;
}

char ithLetter(int i) {
    return (char) (((int) 'a') + i);
}
```
- The runtime is *O(kc<sup>k</sup>)* where *k* is the length of the string and *c* is the number of characters in the alphabet.
- It takes *O(c<sup>k</sup>)* time to generate each string.
- Then, we need to check that each of these is sorted, taking *O(k)* time.

#### Problem 12
- This computes the intersection (number of elements in common) of two arrays. It assumes that neither array has duplicates. It computes the intersection by sorting one array (array *b*) then iterating through array *a* checking (via binary search) if each value is in *b*. What is its runtime?
```java
int intersection(int[] a, int[] b) {
    mergesort(b);
    int intersect = 0;

    for (int x : a) {
        if (binarySearch(b, x) >= 0) {
            intersect++;
        }
    }
    
    return intersect;
}
```
- The sort takes *O(b log b)* time.
- We iterate through *a* once and search each time in *b* to see if value in *a* is in *b*.
- So *O(a)* to iterate doing *O(log b)* work. So, *O(a log b)*.
- Total runtime is *O(b log b + a log b)*.