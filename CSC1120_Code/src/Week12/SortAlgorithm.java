package Week12;

public interface SortAlgorithm {

    /** Sort an array of Comparable objects
     * @param <T> the type to be sorted, must implement Comparable
     * @param table The array of items to sort
     */
    <T extends Comparable<T>>  void sort(T[] table);
}
