package Week5;

import java.util.List;

import java.util.ArrayList;
import java.util.LinkedList;


//     // Determine the asymptotic time complexity of the following methods from the ArrayList<E> class: add(E), add(int, E), clear(), contains(Object), get(int), indexOf(Object), isEmpty(), remove(int), remove(Object), set(int, E), and size()
//
//        // add(int, E) - O(n)
//        // clear() - O(n)
//        // contains(Object) - O(n)
//        // get(int) - O(1)
//        // indexOf(Object) - O(n)
//        // isEmpty() - O(1)
//        // remove(int) - O(n)
//        // remove(Object) - O(n)
//        // set(int, E) - O(1)
//        // size() - O(1)
public class TimeComplixity {
    public static void main(String[] args) {
        // Create an arraylist of Integers
        ArrayList<Integer> intArray = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            intArray.add(i);
        }
        long end = System.nanoTime();
        System.out.println("Time taken to add elements to an array: " + (end - start)*1/1000000 + " miliseconds");


        // random position to insert element
        int position = (int)Math.random()*1000000;
        start = System.nanoTime();
        intArray.add(position, 100);
        intArray.add((int) intArray.size()/2, 200);

        end = System.nanoTime();
        System.out.println("Time taken to insert an element to an array: " + (end - start) + " nanoseconds");
        // add(E) - O(1)
        long startArray = System.nanoTime();
        intArray.add(position, 100);
        long endArray = System.nanoTime();
        System.out.println("Time taken to insert an element to a linked list: " + (endArray - startArray) + " nanoseconds");
        long start_List = System.nanoTime();
        intArray.add((int) intArray.size()/2, 200);
        long end_List = System.nanoTime();
        System.out.println("Time taken to insert an element to a linked list: " + (end_List - start_List) + " nanoseconds");


        start = System.nanoTime();
        intArray.contains(100);
        end = System.nanoTime();
        System.out.println("Time taken to check if a linked list contains an element: " + (end - start) + " nanoseconds");
        // get(int) - O(1)
        start = System.nanoTime();
        intArray.get(100);
        end = System.nanoTime();
        System.out.println("Time taken to get an element from a linked list: " + (end - start) + " nanoseconds");
        // indexOf(Object) - O(n)
        start = System.nanoTime();
        intArray.indexOf(100);
        end = System.nanoTime();
        System.out.println("Time taken to get the index of an element from a linked list: " + (end - start) + " nanoseconds");
        // isEmpty() - O(1)
        start = System.nanoTime();
        intArray.isEmpty();
        end = System.nanoTime();
        System.out.println("Time taken to check if a linked list is empty: " + (end - start) + " nanoseconds");
        // remove(int) - O(n)
        start = System.nanoTime();
        intArray.remove(100);
        end = System.nanoTime();
        System.out.println("Time taken to remove an element from a linked list: " + (end - start) + " nanoseconds");
        // remove(Object) - O(n)
        start = System.nanoTime();
        intArray.remove((Integer)100);
        end = System.nanoTime();
        System.out.println("Time taken to remove an element from a linked list: " + (end - start) + " nanoseconds");
        // set(int, E) - O(1)
        start = System.nanoTime();
        intArray.set(100, 100);
        end = System.nanoTime();
        System.out.println("Time taken to set an element in a linked list: " + (end - start) + " nanoseconds");
        // size() - O(1)
        start = System.nanoTime();
        intArray.size();
        end = System.nanoTime();
        System.out.println("Time taken to get the size of a linked list: " + (end - start) + " nanoseconds");

// clear() - O(n)
        start = System.nanoTime();
        intArray.clear();
        end = System.nanoTime();
        System.out.println("Time taken to clear a linked list: " + (end - start) + " nanoseconds");
        // contains(Object) - O(n)

    }
}
