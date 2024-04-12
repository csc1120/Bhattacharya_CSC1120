import java.util.Scanner;

public class MergeSort {
    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of elements : ");
//        int n = sc.nextInt();

        int arr[] = { 12, 11, 13, 5, 6 };
        int n = arr.length;
//        System.out.println("Enter " + n + " elements :");
//        for (int i = 0; i < n; i++)
//            arr[i] = sc.nextInt();

        System.out.println("The array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        mergeSort(arr, 0, n - 1);
        System.out.println("\nThe sorted array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void mergeSort(int arr[], int lower, int upper) {
        if (lower >= upper)
            return;
        int m = (lower + upper) / 2;
        mergeSort(arr, lower, m);
        mergeSort(arr, m + 1, upper);
        merge(arr, lower, upper);
    }

    private static void merge(int arr[], int lower, int upper) {
        int m = (lower + upper) / 2;
        int a[] = new int[m - lower + 1]; // left array
        int b[] = new int[upper - m]; // right array
        int i, k = 0, k1 = 0, k2 = 0; // k1 and k2 are the indices of the left and right arrays
        for (i = lower; i <= m; i++, k++) // copying the elements to the left array
            a[k] = arr[i];
        k = 0;
        for (; i <= upper; i++, k++) // copying the elements to the right array
            b[k] = arr[i];
        for (i = lower; i <= upper && k1 < m - lower + 1 && k2 < upper - m; i++) { // merging the left and right arrays
            if (a[k1] < b[k2]) {
                arr[i] = a[k1];
                k1++;
            } else {
                arr[i] = b[k2];
                k2++;
            }
        }
        for (; k1 < m - lower + 1; k1++) // copying the remaining elements of the left array
            arr[i++] = a[k1];
        for (; k2 < upper - m; k2++)
            arr[i++] = b[k2];
    }
}
