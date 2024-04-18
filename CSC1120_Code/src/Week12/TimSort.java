package Week12;

/**
 *     Step 1 - Divide the array into the number of blocks known as run.
 *     Step 2 - Consider the size of run, either 32 or 64.
 *     Step 3 - Sort the individual elements of every run one by one using insertion sort.
 *     Step 4 - Merge the sorted runs one by one using the merge function of merge sort.
 *     Step 5 - Double the size of merged sub-arrays after every iteration.
 */
public class TimSort {
    public static final int MIN_RUN = 32;
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = arr.length;
        System.out.println("The array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        timSort(arr);
        System.out.println("\nThe sorted array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void timSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i += MIN_RUN) {
            insertionSort(arr, i, Math.min((i + MIN_RUN-1), (n - 1)));
        }
        for (int size = MIN_RUN; size < n; size = 2 * size) {
            // Start merging from size MIN_RUN (or 32). It will merge to 64, 128, 256 and so on
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                merge(arr, left, mid, right);
            }
        }
    }


    private static void insertionSort(int[] arr, int i, int min) {
        for (int j = i + 1; j <= min; j++) {
            int key = arr[j];
            int k = j - 1;
            while (k >= i && arr[k] > key) {
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = key;
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


}
