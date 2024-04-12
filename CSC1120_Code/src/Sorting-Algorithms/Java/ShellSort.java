import java.util.Scanner;

public class ShellSort {
    public static void main(String args[]) {
     int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;
        System.out.println("The array : ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        shellSort(arr);


        System.out.println("\nThe sorted array : ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void shellSort(int[] nums) {
        int h = 1; // h is the gap
        int n = nums.length; // n is the length of the array
        while(h < n) {
                h = h * 3 + 1; // h is calculated as 3*h + 1
        }
        h = h / 3; // h is divided by 3
        int c, j; // c is the current element and j is the index
        
        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = nums[i];
                j = i;
                while (j >= h && nums[j - h] > c) {
                    nums[j] = nums[j - h];
                    j = j - h;
                }
                nums[j] = c;
            }
            h = h / 2;
        }
    }
}
