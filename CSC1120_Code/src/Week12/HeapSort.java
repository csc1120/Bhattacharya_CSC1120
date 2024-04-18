package Week12;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        System.out.println("The array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        heapSort(arr);
        System.out.println("\nThe sorted array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i); // Build heap (rearrange array)
        for (int i = n - 1; i > 0; i--) { // One by one extract an element from heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        if (l < n && arr[l] > arr[largest]) // If left child is larger than root
            largest = l;
        if (r < n && arr[r] > arr[largest]) // If right child is larger than largest so far
            largest = r;
        if (largest != i) {
            int swap = arr[i]; // Swap and continue heapifying if root is not largest
            arr[i] = arr[largest]; // Recursively heapify the affected sub-tree
            arr[largest] = swap;    // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);  // Recursively heapify the affected sub-tree
        }
    }
}
