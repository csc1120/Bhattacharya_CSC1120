# ArrayList and LinkedList
- ArrayList and LinkedList are two of the most popular data structures in Java. They are both used to store a collection of objects, but they have different performance characteristics and are used in different situations.

## ArrayList
- ArrayList is a resizable array implementation of the List interface. It is backed by an array, and it automatically grows when elements are added to it.
- ArrayList is a good choice when you need fast access to elements by index, but it is not a good choice when you need to add or remove elements frequently, especially from the middle of the list.

### Time Complexity of Common Operations for ArrayLists
- The time complexity of common operations for ArrayLists in Java is as follows:
    - Accessing an element by index: O(1)
    - Adding an element to the end of the list: O(1) on average, O(n) in the worst case
    - Adding an element to the middle of the list: O(n)
    - Removing an element from the end of the list: O(1)
    - Removing an element from the middle of the list: O(n)

## add method
- The add method in ArrayList has a time complexity of O(1) on average, but O(n) in the worst case. This is because adding an element to the end of the list is a constant-time operation when there is enough space in the underlying array, but it requires copying the entire array to a new, larger array when the underlying array is full.
- pusedo code:
```java
public void add(E element) {
    if (size == elements.length) {
        // create a new array with double the capacity
        E[] newElements = (E[]) new Object[elements.length * 2];
        // copy the elements from the old array to the new array
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        // update the reference to the new array
        elements = newElements;
    }
    // add the new element to the end of the list
    elements[size] = element;
    size++;
}
```


## remove method
- The remove method in ArrayList has a time complexity of O(n) because it requires shifting all the elements after the removed element to the left by one position.
- The remove method in LinkedList has a time complexity of O(1) because it only requires updating the references of the neighboring nodes.

pusedo code:
```java
public E remove(int index) {
    // store the element to be removed
    E removedElement = elements[index];
    // shift the elements after the removed element to the left by one position
    for (int i = index; i < size - 1; i++) {
        elements[i] = elements[i + 1];
    }
    // set the last element to null
    elements[size - 1] = null;
    // decrement the size of the list
    size--;
    return removedElement;
}
```

## Single LinkedList
- A singly linked list is a data structure that consists of a sequence of nodes, where each node contains a value and a reference to the next node in the sequence.
- LinkedList is a good choice when you need to add or remove elements frequently, especially from the middle of the list, but it is not a good choice when you need fast access to elements by index.

### Time Complexity of Common Operations for LinkedLists
- The time complexity of common operations for LinkedLists in Java is as follows:
    - Accessing an element by index: O(n)
    - Adding an element to the end of the list: O(1)
    - Adding an element to the middle of the list: O(1)
    - Removing an element from the end of the list: O(1)
    - Removing an element from the middle of the list: O(1)

## add method
- The add method in LinkedList has a time complexity of O(1) because it only requires updating the references of the neighboring nodes.
- pusedo code:
```java
public void add(E element) {
    // create a new node with the given element
    Node<E> newNode = new Node<>(element);
    // set the next reference of the last node to the new node
    lastNode.next = newNode;
    // update the last node reference to the new node
    lastNode = newNode;
    // increment the size of the list
    size++;
}
```

## remove method
- The remove method in LinkedList has a time complexity of O(1) because it only requires updating the references of the neighboring nodes.
- pusedo code:
```java
public E remove(int index) {
    // find the node at the given index
    Node<E> node = getNode(index);
    // store the element to be removed
    E removedElement = node.element;
    // update the references of the neighboring nodes
    node.previous.next = node.next;
    node.next.previous = node.previous;
    // decrement the size of the list
    size--;
    return removedElement;
}
```
## indexOf method

- The indexOf method in LinkedList has a time complexity of O(n) because it requires traversing the list to find the element with the given value.
- pusedo code:
```java
public int indexOf(E element) {
    // start at the first node
    Node<E> currentNode = firstNode;
    // traverse the list until the element is found
    for (int i = 0; i < size; i++) {
        if (currentNode.element.equals(element)) {
            return i;
        }
        currentNode = currentNode.next;
    }
    // return -1 if the element is not found
    return -1;
}
```
