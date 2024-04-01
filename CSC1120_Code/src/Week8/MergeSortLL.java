package Week8;

import java.util.LinkedList;

public class MergeSortLL {

    public static void main(String[] args) {
        var array = new LinkedList<Integer>();
        array.add(3);
        array.add(9);
        array.add(10);
        array.add(1);
        array.add(8);
        array.add(7);
        array.add(5);
        array.add(2);
        array = mergeSort(array);
        for (int element: array) {
            System.out.print(element + " ");
        }
    }

    public static LinkedList<Integer> mergeSort(LinkedList<Integer> array) {
        if (array == null || array.size() <= 1) {
            return array;
        }

        // Break the list in two halves
        int mid = array.size() / 2;
        LinkedList<Integer> leftArray = new LinkedList<>(array.subList(0, mid));
        LinkedList<Integer> rightArray = new LinkedList<>(array.subList(mid, array.size()));

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        return merge(leftArray, rightArray);
    }

    private static LinkedList<Integer> merge(LinkedList<Integer> leftArray, LinkedList<Integer> rightArray) {
        LinkedList<Integer> merged = new LinkedList<>();
        int i = 0, j = 0;

        // Effectively sorts left and right array
        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                merged.add(leftArray.get(i++));
            } else {
                merged.add(rightArray.get(j++));
            }
        }
        while (i < leftArray.size()) {
            merged.add(leftArray.get(i++));
        }
        while (j < rightArray.size()) {
            merged.add(rightArray.get(j++));
        }
        return merged;
    }
}