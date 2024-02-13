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
