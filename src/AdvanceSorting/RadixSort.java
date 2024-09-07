package AdvanceSorting;

import java.util.Arrays;

public class RadixSort {
    public static void radixsort(int[]arr){
        int max= Arrays.stream(arr).max().getAsInt();//to find maximum value so as to get no.of digits
        //do count sort for every digit place
        for(int exp=1;max/exp>0;exp*=10){//to check every digit place thats y multiply by 10
            countSort(arr,exp);
        }
    }
    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for(int i=0; i<n; i++) {
            count[(arr[i] / exp) % 10]++;//for frequency and inner one to get the digit //jo value unit or tens place pe hai usko leke uski frequency bataega in new array
        }

        System.out.println("\nCount array for " + exp + " : " + Arrays.toString(count));

        for(int i=1; i<10; i++) {
            count[i] = count[i] + count[i-1];//simply just add current anf previous element
        }

        System.out.println("Updated count array " + Arrays.toString(count));

        for(int i=n-1; i>=0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.out.println("Output array " + Arrays.toString(output));

        System.arraycopy(output, 0, arr, 0, n);//just copy the output to the original array

    }

    public static void main(String[] args) {
        int []arr={29,83,471,36,91,8};
        System.out.println("Original array :"+Arrays.toString(arr));
        radixsort(arr);
        System.out.println("Sorted array :"+Arrays.toString(arr));
    }
}
