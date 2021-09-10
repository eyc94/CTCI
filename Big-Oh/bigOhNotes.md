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