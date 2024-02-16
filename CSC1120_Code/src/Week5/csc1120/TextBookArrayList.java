package Week5.csc1120;

import java.util.Arrays;

/**
 * A class that implements some of the methods of the Java ArrayList class for a generic data type
 */
public class TextBookArrayList<E> {
    // Data fields

    /** The initial capacity of the array */
    private static final int INITIAL_CAPACITY = 10;
    /** Array to store data */
    // E is a placeholder for the type of data that will be stored in the array

    private E[] theData;
    /** The current size of the array */
    private int size = 0;
    /** The current capacity of the array */
    private int capacity = 0;

    /**
     * Constructs an instance of the class, initializing the array with the initial capacity
     */
    public TextBookArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    /**
     * Adds an item at the specified index, shifting the other items to the right.
     * If the array is full, it will be resized before adding the item.
     *
     * @param index The index to add the item at
     * @param anEntry The item to be added
     * @throws ArrayIndexOutOfBoundsException If index is out of range
     */
    public void add (int index, E anEntry) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (size >= capacity) {
            reallocate();
        }
        for (int i = size; i > index; i--) {
            theData[i] = theData[i-1];
        }
        theData[index] = anEntry;
        size++;
    }

    /**
     * Returns the item at the specified index
     *
     * @param index The index of the item to return
     * @return The item at the specified index
     * @throws ArrayIndexOutOfBoundsException If index is out of range
     */
    public E get (int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * Replaces the item at the specified index
     *
     * @param index The index of the item to replace
     * @param newValue The item to replace with
     * @return The previous item
     * @throws ArrayIndexOutOfBoundsException If index is out of range
     */
    public E set (int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    /**
     * Removes an item at the specified index, shifting the other items to the left.
     *
     * @param index The index of the item to be removed
     * @return The removed item
     * @throws ArrayIndexOutOfBoundsException If index is out of range
     */
    public E remove (int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }
    // contains method
    public boolean contains(E anEntry) {
        for (int i = 0; i < size; i++) {
            if (theData[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Resize the array to the double of its current capacity
     */
    private void reallocate () {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

    public static void main(String[] args) {
        // Create an arraylist of Integers
        TextBookArrayList<Integer> intArray = new TextBookArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            intArray.add(i, i);
        }
        long end = System.nanoTime();
        System.out.println("Time taken to add elements to an array: " + (end - start)*1/1000000 + " miliseconds");

    // benchmark data for the following operations:
    // addToFront — Adding to the front of the arraylist

        start = System.nanoTime();
        intArray.add(0, 100);
        end = System.nanoTime();
        System.out.println("Time taken to add an element to the front of an array: " + (end - start) + " nanoseconds");

        // indexedContains — Iterating through the arraylist using an index (calling get() ) to
        // find a match
        start = System.nanoTime();
        intArray.get(100);
        end = System.nanoTime();
        System.out.println("Time taken to get an element from an array: " + (end - start) + " nanoseconds");
    }
}