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