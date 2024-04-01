package Week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinarySearch {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "cheese", "orange", "ryan", "stuff" );
        System.out.println(binarySearchRec(words, "yogurt"));
        System.out.println(binarySearchRec(words, "orange"));
        System.out.println(binarySearchRec(words, "cheese"));
        System.out.println(binarySearchRec(words, "stuff"));
        System.out.println(binarySearchRec(words, "ryan"));
        System.out.println(binarySearchRec(words, "apple"));

    }


    public static boolean binarySearchRec(List<String> list, String target) {
        boolean found = false;
        if (!list.isEmpty()) {
            int middle = list.size() / 2;
            int compare = list.get(middle).compareTo(target);
            if (compare == 0) {
                found = true;
            } else if (compare < 0) {
                found = binarySearchRec(list.subList(middle + 1, list.size()), target);
            } else {
                found = binarySearchRec(list.subList(0, middle), target);
            }
        }
        return found;
    }
// List<? extends Comparable<? super T>> list, T target is a wildcard type that allows for any list of objects that are comparable to the target
    // we can use this method to search for any object in a list of objects that are comparable to the target
    //Wildcard types are useful in situations where only partial knowledge about the type parameter is required.
    // other examples of wildcard types are List<?>, List<? extends Number>, List<? super Integer>
    public static <T> boolean binarySearch(List<? extends Comparable<? super T>> list, T target) {
        int start = 0;
        int end = list.size();
        int middle = end / 2;
        boolean found = false;
        while (middle != start || middle != end) {
       // while (start < end && !found) {
            Comparable middleElement = list.get(middle);
            int compare = middleElement.compareTo(target);
            found = compare == 0;
            if (compare < 0) {
                start = middle + 1;
            } else if (compare > 0) {
                end = middle;
            }
            middle = (start + end) / 2;
        }
        return found;
    }
    // returns the index of the target in the list and boolean if the target is found

}

