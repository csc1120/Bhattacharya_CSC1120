package Week12;

/**
 * Step 1 divide the array into the number of blocks called as runs
 * Step 2: Sort the individual elements of every run one by one using insertion sort
 * Step 3: Merges the sorted runs using the merge function
 * Step 4: doubles the size of the merged sub-array after every iteration
 */
public class TimSort {
    public  static final int MIN_RUN = 2;

    public static void main(String[] args) {
        int[] arr= {12, 14, 11, 5,6,1};
        int n= arr.length;
        timSort(arr);
        printArray(arr);

    }

    public  static  void timSort(int[] arr){
        int n = arr.length;
        for(int i= 0; i< n; i+= MIN_RUN){
            insertionSort(arr);
        }
        for(int size= MIN_RUN; size<n; size=2*size){
            for(int left= 0; left< n ; left+=2*size){
                int mid= left+size-1;
                int right= Math.min((left+2*size-1),(n-1));
                merge(arr, left, mid, right);
            }
        }
    }

    public  static  void  insertionSort(int arr[]){
        int len= arr.length, temp, j;
        for(int i = 1; i< len; i++){
            temp =arr[i];
            for(j=i; j> 0; j--) {
                if (arr[j - 1] > temp)
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j]= temp;
        }
    }


    public  static void merge(int arr[], int p, int q, int r){
        // create L ,<- A[p ... q] and M <- A[q+1... r]
        int n1 = q-p+1; // length of the left array
        int n2= r-q ; // length of the right array
        // space complexity
        int L[] = new int[n1];
        int M[] = new int[n2];
        // copy data for left and right
        for(int i= 0; i< n1; i++){
            L[i]= arr[p+i];
        }
        for (int j= 0; j< n2; j++){
            M[j]= arr[q+1+j];
        }
        // Maintain the current index of the subarray and main array
        int i, j, k; // i for left array, j for right and k is for tha main index
        i=0;
        j=0;
        k=p; // p is the starting index or the initial index of the merged subarray
        // until we either the end of L or M pick larger among the elements and
        // place them in the correct position
        while (i< n1 && j< n2){
            if(L[i]< M[j]){ // comparision and placing the lower element
                arr[k]= L[i];
                i++;
            } else{
                arr[k] = M[j];
                j++;
            }
            k++;
        }
        // when we run out the elements in L and M .. pick up the remaining element
        // and put them in the A[p.. r] arrays
        while (i< n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j< n2){
            arr[k]= M[j];
            j++;
            k++;
        }
    }
    public  static  void printArray(int arr[]){
        int n= arr.length;
        for(int i= 0; i< n; i++){
            System.out.print(arr[i] + " " );
            System.out.println();
        }
    }


}
