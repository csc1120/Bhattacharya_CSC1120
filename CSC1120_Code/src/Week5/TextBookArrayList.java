package Week5;

import java.util.ArrayList;
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
        // check bounds
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        // Make sure there is room
        if (size >= capacity) {
            reallocate();
        }

        // shift data
        for (int i = size; i > index; i--) {
            theData[i] = theData[i-1];
        }

        // insert item
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
//    public boolean contains(E anEntry) {
//        for (int i = 0; i < size; i++) {
//            if (theData[i].equals(anEntry)) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     *indexedContains — Iterating through the list using an index (calling get()) to find a match
     */
    public boolean indexedContains(E anEntry) {
        // use get method to iterate through the list
        for (int i = 0; i < size; i++) {
            if (theData[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }
        // contains — Determining if a value is in the list using contains()
    public boolean contains(E anEntry) {
        return Arrays.asList(theData).contains(anEntry);
    }
    // addtoFront — Adding an item to the front of the list
    public void addtoFront(E anEntry) {
        add(0, anEntry);
    }


    /**
     * Resize the array to the double of its current capacity
     */
    private void reallocate () {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

// return the arraylist
    public ArrayList shuffle() {
        for (int i = 0; i < size; i++) {
            int randomIndex = (int) (Math.random() * size);
            E temp = theData[i];
            theData[i] = theData[randomIndex];
            theData[randomIndex] = temp;
        }
        return new ArrayList(Arrays.asList(theData));
    }
    // toString method
    public String toString() {
        return Arrays.toString(theData);
    }
    // indexContains — Iterating through the list using an index (calling get()) to find a match
    public boolean indexContains(E anEntry) {
        for (int i = 0; i < size; i++) {
            if (theData[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }
    // toArray method
    public Object[] toArray() {
        return Arrays.copyOf(theData, size);
    }

}