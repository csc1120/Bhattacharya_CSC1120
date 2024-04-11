package Week11;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PerformanceComparison {

    public static void main(String[] args) {
        int[] dataSizes = {1000, 10000, 100000, 1000000};

        for (int dataSize : dataSizes) {
            System.out.println("Data Size: " + dataSize);

            // Generate random data
            Integer[] data = generateRandomData(dataSize);

            // Test Hash Table
            testHashTable(data);

            // Test Sorted Array with Binary Search
            testSortedArray(data);

            // Test Binary Search Tree
            testBinaryTree(data);

            System.out.println();
        }
    }

    private static Integer[] generateRandomData(int size) {
        Integer[] data = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    private static void testHashTable(Integer[] data) {
        long startTime = System.nanoTime();
        Set<Integer> hashTable = new HashSet<>(data.length);
        Collections.addAll(hashTable, data);

        // Search for a random element
        int searchElement = data[new Random().nextInt(data.length)];
        boolean found = hashTable.contains(searchElement);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("  Hash Table: " + elapsedTime + " nano_s (Search: " + found + ")");
    }

    private static void testSortedArray(Integer[] data) {
        long startTime = System.nanoTime();
        Arrays.sort(data);

        // Search for a random element using binary search
        int searchElement = data[new Random().nextInt(data.length)];
        int index = Arrays.binarySearch(data, searchElement);
        boolean found = index >= 0;

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("  Sorted Array (Binary Search): " + elapsedTime + " nano_s (Search: " + found + ")");
    }

    private static void testBinaryTree(Integer[] data) {
        long startTime = System.nanoTime();
        TreeSet<Integer> binaryTree = new TreeSet<>(Arrays.asList(data));

        // Search for a random element
        int searchElement = data[new Random().nextInt(data.length)];
        boolean found = binaryTree.contains(searchElement);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("  Binary Search Tree: " + elapsedTime + " nano_s (Search: " + found + ")");
    }
}
