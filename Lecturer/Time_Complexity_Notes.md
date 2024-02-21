# Algorithm Time Complexity
## 1. Introduction
- Time complexity is a measure of the amount of time an algorithm takes to run as a function of the length of the input.
- It is a way to compare the efficiency of different algorithms.
- It is often expressed using big O notation.

## 2. Space Complexity
- Space complexity is a measure of the amount of memory an algorithm uses as a function of the length of the input.

## 3. Time Complexity
- Time complexity is a measure of the amount of time an algorithm takes to run as a function of the length of the input.

## 3. Big O Notation
- Big O notation is a mathematical notation that describes the limiting behavior of a function when the argument tends towards a particular value or infinity.
- It is used to describe the upper bound of the time complexity of an algorithm.
- It is often used to describe the worst-case time complexity of an algorithm.
- For example, an algorithm with time complexity O(n) has a worst-case time complexity that grows linearly with the size of the input.
- Common time complexities include O(1), O(log n), O(n), O(n log n), O(n^2), O(2^n), and O(n!).

## 4. Common Time Complexities
- O(1): Constant time -  very efficient
- O(log n): Logarithmic time -  efficient
- O(n): Linear time -  efficient
- O(n log n): Linearithmic time -  efficient
- O(n^2): Quadratic time -  inefficient
- O(2^n): Exponential time -  very inefficient
- O(n!): Factorial time - extremely inefficient

## 5. Summary 
- The time complexity of an algorithm depends on the number of operations it performs as a function of the length of the input.
- For example, an algorithm that performs a constant number of operations regardless of the size of the input has time complexity O(1).
- operations  logarithm of the size of the input is O(log n).
-  operations proportional to the size of the input has time complexity O(n).
- Aoperations equals to the size of the input and the logarithm of the size of the input  O(n log n).
-  proportional to the square of the size of the input  O(n^2).
- number of operations proportional to an exponential function of the size of n O(2^n).
- Operations proportional to the factorial of the size of the input has time complexity O(n!).

## Linear Search
- Linear search is a simple search algorithm that checks each element in a list in order until the desired element is found.
- The time complexity of linear search is O(n) in the worst case, where n is the length of the list.
- This is because in the worst case, the algorithm must check each element in the list before finding the desired element.
- The best-case time complexity of linear search is O(1), which occurs when the desired element is the first element in the list.
- The average-case time complexity of linear search is O(n/2), which is still O(n).
 pesudo code:
 ``` for i = 0 to n-1
    if A[i] == x
        return i
    return -1
```

## Time Complexity of Common Operations for ArrayLists
- The time complexity of common operations for ArrayLists in Java is as follows:
    - Accessing an element by index: O(1)
    - Adding an element to the end of the list: O(1) on average, O(n) in the worst case
    - Adding an element to the middle of the list: O(n)
    - Removing an element from the end of the list: O(1)
    - Removing an element from the middle of the list: O(n)