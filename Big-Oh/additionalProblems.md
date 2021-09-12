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
