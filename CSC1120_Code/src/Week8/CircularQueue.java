package Week8;

import java.util.NoSuchElementException;

public class CircularQueue<E> implements PureQueue<E> {
    private final Object[] buffer;
    public static final int DEFAULT_CAPACITY = 5;
    private int frontIndex;
    private int backIndex;
    private boolean isEmpty;

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int capacity) {
        buffer = new Object[capacity]; // buffer is an array of Object references with a length of capacity
        frontIndex = 0; // frontIndex is the index of the first element in the queue
        backIndex = 0; // backIndex is the index of the next available slot in the queue
        isEmpty = true; // isEmpty is true if the queue is empty
    }

    /*
        * Method to add an item to the queue.
        * @param item The item to be added to the queue.
        * @throws IllegalStateException if the queue is already full.
     */
    @Override
    public void offer(E item) {
        if (backIndex == frontIndex && !isEmpty) {
            throw new IllegalStateException("Queue is already full");
        }
        buffer[backIndex] = item;
        backIndex = (backIndex + 1) % buffer.length;
        isEmpty = false;
    }

    /*
        * Method to remove an item from the queue.
        * @return The item removed from the queue.
        * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public E poll() {
        if (isEmpty) {
            throw new NoSuchElementException("No elements left");
        }
        E data = (E) buffer[frontIndex];
        buffer[frontIndex] = null;
        frontIndex = (frontIndex + 1) % buffer.length;
        isEmpty = frontIndex == backIndex;
        return data;
    }
/*
        * Method to return the item at the front of the queue without removing it.
        * @return The item at the front of the queue.
        * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public E peek() {
        if (isEmpty) {
            throw new NoSuchElementException("No elements left");
        }
        // return the item at the front of the queue
        return (E) buffer[frontIndex];
    }

    @Override
    public int size() {
        return (backIndex + buffer.length - frontIndex) % buffer.length;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
    // toString method to display the contents of the queue
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = frontIndex; i != backIndex; i = (i + 1) % buffer.length) {
            sb.append(buffer[i]);
            if ((i + 1) % buffer.length != backIndex) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
