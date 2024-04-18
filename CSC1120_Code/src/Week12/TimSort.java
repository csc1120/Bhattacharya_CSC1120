package Week12;

/**
 * Step 1 -- divide the array into number of blocks called run
 * Step 2-- run 32 or 64
 * Step 3-- sort the individual elements of every run using insertion sort
 * Step 4-- merge the sorted runs one by one
 * Step 5-- double the size of the merged sub-array after iteration
 */
public class TimSort {
    public static int MIN_RUN= 32;

    public static void main(String[] args) {
        int arr[] ={12,11,13,5,6,1};
        timSort(arr);
        printArray(arr);
    }
    private  static  void  timSort(int[] arr){
        int n= arr.length;
        for(int i=0; i<n; i+=MIN_RUN){
            insertionSort(arr);
        }
        for (int size= MIN_RUN; size<n; size= 2*size){
            // start merging from size min_run
            for(int left =0; left<n; left+=2*size){
                int mid = left+size-1;
                int right= Math.min((left+2*size-1),(n-1));
                merge(arr, left, right);
            }
        }
    }
    static  void  insertionSort(int arr[]){
        int len= arr.length, temp, j;
        for(int i = 1; i < len; i++){
            temp =arr[i];
            for(j=i; j>0; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                }
                else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }
    private  static  void merge(int arr[], int lower, int upper){
        int m = (lower+ upper)/2;
        int a[] = new int[m- lower+1]; // left array
        int b[] = new int[upper- m]; // right array
        int i, k=0, k1= 0, k2= 0;  // k1 and k2 are indices of the left and right arrays
        // copy the element to the left side
        for(i =lower; i<= m; i++, k++)
            a[k] = arr[i];
        k=0;
        // copy elements to the right side
        for(; i<= upper; i++, k++)
            b[k] = arr[i];
        // merge the left and right array
        for(i= lower; i<= lower && k1< m-lower+1 && k2< upper-m; i++ ){
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
    public static void printArray(int arr[]){
        int n= arr.length;
        for(int i= 0; i< n ; ++i){
            System.out.print(arr[i]+ " " );
            System.out.println();
        }
    }



}
