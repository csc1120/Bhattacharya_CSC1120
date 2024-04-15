package Week12;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        int n = arr.length;
        System.out.println("The array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        quickSort(arr, 0, n - 1);
        System.out.println("\nThe sorted array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();


    }
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // If current element is smaller than the pivot
                i++;
                int temp = arr[i]; // swap arr[i] and arr[j]
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; // swap arr[i+1] and arr[high] (or pivot)
        arr[i + 1] = arr[high]; // Move pivot to its correct position
        arr[high] = temp;  // Return the position of the pivot
        return i + 1;
    }

}
