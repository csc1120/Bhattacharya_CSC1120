# Functional Programming
## What is Functional Programming?
- Functional programming is a programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data.
- Programs are constructed by applying and composing functions.
- It is a declarative programming paradigm in which function definitions are trees of expressions that each return a value, rather than a sequence of imperative statements which change the state of the program.
- Treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data.

## Functional Programming Characteristics

- Conceptually, we can think of functional programming as if each method acted like a mathematical function. For a fixed set of inputs, the function returns the same value each time it is called. This results in the following constraints:
- The function call can be replaced by the result. 
- Functions are not allowed to have side effects. 
- The compiler is allowed to rearrange the function invocations or run them on different threads without changing the result. 
- Program flow is driven by data dependencies rather than the sequence of instructions.

## First-Class Functions

- Functional programming involves first-class functions. Put simply, we are able to treat a function like we would data. Specifically:
- Functions can be assigned to variables. 
- Functions can be passed as arguments to another function. 
- Functions can be returned by other functions.

## Why Functional Programming?
- Functional programming can increase the reusability of code, improve readability and testability, and enable the use of powerful programming techniques such as concurrency and parallelization.
- It leads to programs that are more modular and easier to reason about, since functions are designed to not produce side effects.
- It enables developers to write more declarative code, which can be more understandable than imperative code.

## Lambda Expression
- Lambda expression is an anonymous function without a name and access modifier.


## Predicate Interface

- One common type of function that is passed to higher-order functions is a predicate function -- a function that evaluates to a boolean value. Java provides a functional interface to help: Predicate<T>.

- We can create a predicate function by implementing this interface with a lambda expression. The following defines a predicate function that returns true whenever the string on which the predicate is evaluated is longer than nine characters:
The Stream interface declares these higher-order functions that require a predicate function:
- 
```Predicate<String> longerThanNine = (word -> word!=null && word.length()>9);```
- ```allMatch(Predicate<? super T> predicate)``` -- returns true if all elements in this stream match the predicate.
- ```anyMatch(Predicate<? super T> predicate)``` -- returns true if any elements in this stream match the predicate.
- ```noneMatch(Predicate<? super T> predicate)``` -- returns true if none of the elements in this stream match the predicate.
- ```filter(Predicate<? super T> predicate)``` -- returns a stream consisting of the elements of this stream that match the given predicate.
