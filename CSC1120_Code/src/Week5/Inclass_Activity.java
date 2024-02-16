package Week5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections.sort() can be used to sort a list
 * Create an ArrayList of 1 million randomly-generated integers
 * Use lambda expressions with Collections.sort() to:
 * Sort the numbers from largest to smallest
 * Sort the numbers from smallest to largest
 * Find the min
 * Find the max
 * Refer to the Comparator interface Javadocs as needed
 */
public class Inclass_Activity {
    public static void main(String[] args) {
        // Create an ArrayList of 1 million randomly-generated integers
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            intList.add((int) (Math.random() * 1000000));
        }
        // Sort the numbers from largest to smallest
        // record the time taken to sort the numbers from largest to smallest
        long start = System.nanoTime();
        Collections.sort(intList, (a, b) -> b - a);
        long end = System.nanoTime();
        System.out.println("Time taken to sort the numbers from largest to smallest: " + (end - start) + " nanoseconds");
        System.out.println("The largest number is: " + intList.get(0));
        System.out.println("The smallest number is: " + intList.get(intList.size() - 1));
        // Sort the numbers from smallest to largest
        // record the time taken to sort the numbers from smallest to largest
        start = System.nanoTime();
        Collections.sort(intList, (a, b) -> a - b);
        end = System.nanoTime();
        System.out.println("Time taken to sort the numbers from smallest to largest: " + (end - start) + " nanoseconds");
        System.out.println("The smallest number is: " + intList.get(0));
        System.out.println("The largest number is: " + intList.get(intList.size() - 1));

        // benchmark the time taken to find the min and max
//        benchmark data for the following operations:
//        addToFront — Adding to the front of the arraylist
//        indexedContains — Iterating through the arraylist using an index (calling get() ) to
//        find a match
//        contains — Determining if a value is in the arraylist using contains()
//        remove — Removing an element from the arraylist

        int[] size = {100000, 1000000, 10000000};
        for (int n : size) {
            // Create an array of Integers
            int[] intArray = new int[n];
            long start1 = System.nanoTime();
            addElementsToArray(intArray, n);
            long end1 = System.nanoTime();
            System.out.println("Time taken to add elements to an array of size " + n + ": " + (end1 - start1) + " nanoseconds");
        }
        // Create an  arraylist of Integers
        for (int n : size) {
            ArrayList<Integer> intList1 = new ArrayList<>();
            long start1 = System.nanoTime();
            addElementsToArrayList(intList1, n);
            long end1 = System.nanoTime();
            System.out.println("Time taken to add elements to a arraylist  of size " + n + ": " + (end1 - start1) + " nanoseconds");
        }
        System.out.println("****************************************************************************************************");
        // difference between insert and add is that insert is used to insert an element at a specific position
        // while add is used to add an element to the end of the list


        // Time taken to insert elements to an array
        // Time taken to insert elements to a arraylist
        int[] element_size1= {100, 1000, 10000, 100000};
        for (int n : element_size1) {
            // Create an array of Integers
            int[] intArray = new int[1000000];
            long start1 = System.nanoTime();
            insertElementsToArray(intArray, randomElements(n));
            long end1 = System.nanoTime();
            // print the time taken to insert n random elements to an array
            System.out.println("Time taken to insert random "+randomElements(n).length +" elements to an array  " + (end1 - start1) + " nanoseconds");
        }

        // insert elements to an arraylist
        for (int n : element_size1) {
            ArrayList<Integer> intList1 = new ArrayList<>();
            long start1 = System.nanoTime();
            insertElementsToArrayList(intList1, randomElements(n));
            long end1 = System.nanoTime();
            System.out.println("Time taken to insert random "+randomElements(n).length +" elements to an arraylist : " + (end1 - start1) + " nanoseconds");
        }


    }

    private static void insertElementsToArrayList(ArrayList<Integer> intList1, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            intList1.add(ints[i]);
        }
    }

    private static void insertElementsToArray(int[] intArray, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            intArray[i] = ints[i];
        }
    }

    private static int[] randomElements(int n) {
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = (int) (Math.random() * 1000000);
        }
        return elements;
    }

    private static void addElementsToArrayList(ArrayList<Integer> intList1, int n) {
        for (int i = 0; i < n; i++) {
            intList1.add(i);
        }
    }

    private static void addElementsToArray(int[] intArray, int n) {
        for (int i = 0; i < n; i++) {
            intArray[i] = i;
        }
    }
    // add to front of the arraylist
    public static void addToFront(ArrayList<Integer> intList, int n){
        for (int i = 0; i < n; i++) {
            intList.add(0, i);
        }
    }
    // indexedContains
    public static void indexedContains(ArrayList<Integer> intList, int n){
        for (int i = 0; i < n; i++) {
            intList.get(i);
        }
    }
    // contains
    public static void contains(ArrayList<Integer> intList, int n){
        for (int i = 0; i < n; i++) {
            intList.contains(i);
        }
    }
    // remove
    public static void remove(ArrayList<Integer> intList, int n){
        for (int i = 0; i < n; i++) {
            intList.remove(i);
        }
    }



}
