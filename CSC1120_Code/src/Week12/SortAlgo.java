
package  Week12;

/**
 * Abstract Class to perform sorts on integer arrays and collect statistics.
 * @author Paul Wolfgang
 */
public abstract class SortAlgo {

    int numComparisons;
    int numExchanges;

    /**
     * Sort an array of integers.
     * @param table The array to be sorted
     */
    public abstract void sort(int[] table);

    public abstract String getName();

    public void swap(int[] table, int i, int j) {
        numExchanges++;
        int temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    public int compare(int a, int b) {
        numComparisons++;
        return Integer.compare(a, b);
    }

    public int getNumComparisons() {
        return numComparisons;
    }

    public int getNumExchanges() {
        return numExchanges;
    }

    public void reset() {
        numComparisons = 0;
        numExchanges = 0;
    }
}
