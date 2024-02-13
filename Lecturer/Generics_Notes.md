# Generics Programming
- Generics are a way to make the code more reusable and type-safe.
- Generics are a way to define a class, interface, or method with a placeholder for the data type.
- Generics provides compile-time type safety.
- Generics provide better performance by removing the need for casting.

## Generics in Java
- Generics were added in Java 5.0.

## Generics Example
```java
class MyGenericClass<T> {
    T obj;
    void add(T obj) {
        this.obj = obj;
    }
    T get() {
        return obj;
    }
}
```

## Generics with Multiple Type Parameters
```java
class MyGenericClass<T, U> {
    T obj1;
    U obj2;
    void add(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    T getObj1() {
        return obj1;
    }
    U getObj2() {
        return obj2;
    }
}
```
## Generics with Bounded Type Parameters
```java
class MyGenericClass<T extends Number> {
    T obj;
    void add(T obj) {
        this.obj = obj;
    }
    T get() {
        return obj;
    }
}
```


## Generics with Method
```java
class MyGenericClass {
    <T> void display(T obj) {
        System.out.println(obj);
    }
}
```

## Generics  Type parameters naming conventions
- E - Element (used extensively by the Java Collections Framework). Example: ArrayList<E>
- K - Key (used in Map). Example: HashMap<K, V>
- N - Number (used in Number). Example: Integer, Decimal,   
- T - Type 
- V - Value 

## When to use Collection<E> instead of List<E> and vice versa
- Collection<E> is an interface that extends Iterable<E> and is the root of the collection hierarchy. It represents a group of objects known as its elements.
- List<E> is an interface that extends Collection<E> and is an ordered collection. It can contain duplicate elements.
- Use Collection<E> when you want to represent a group of objects and List<E> when you want to represent an ordered collection that can contain duplicate elements.


# ArrayList<E> vs LinkedList<E>
- ArrayList<E> is a resizable array implementation of the List<E> interface. It is faster than LinkedList<E> for random access and iteration.
- LinkedList<E> is a doubly-linked list implementation of the List<E> interface. It is faster than ArrayList<E> for adding and removing elements from the middle of the list.
- Use ArrayList<E> when you want to access elements by index and LinkedList<E> when you want to add or remove elements from the middle of the list.
- ArrayList<E> is better for read-only operations and LinkedList<E> is better for add and remove operations.
- ArrayList<E> is better for search operations and LinkedList<E> is better for insert and delete operations.
- ArrayList<E> is better for storing and accessing data and LinkedList<E> is better for manipulating data.
- ArrayList<E> is better for random access and LinkedList<E> is better for sequential access.
- ArrayList<E> is better for read-heavy applications and LinkedList<E> is better for write-heavy applications.

## ArrayList<E> Example
```java
import java.util.ArrayList;
class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("C#");
        list.add("JavaScript");
        System.out.println(list);
    }
}
```
## List of methods in ArrayList<E>, description and time complexity
- add(E e) - add element at the end of the list - O(1)
- add(int index, E element) - add element at the specified index - O(n)
- addAll(Collection<? extends E> c) - add all elements of the specified collection to the list - O(n)
-get(int index) - get element at the specified index - O(1)
- remove(int index) - remove element at the specified index - O(n)
- remove(Object o) - remove the first occurrence of the specified element - O(n)
- set(int index, E element) - replace the element at the specified index with the specified element - O(1)
- size() - return the number of elements in the list - O(1)
- clear() - remove all elements from the list - O(n)
- contains(Object o) - return true if the list contains the specified element - O(n)
- indexOf(Object o) - return the index of the first occurrence of the specified element - O(n)
- lastIndexOf(Object o) - return the index of the last occurrence of the specified element - O(n)
- isEmpty() - return true if the list is empty - O(1)
- toArray() - return an array containing all of the elements in the list - O(n)
- subList(int fromIndex, int toIndex) - return a view of the portion of the list between the specified fromIndex, inclusive, and toIndex, exclusive - O(1)
