package AdvanceSorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountSort {
    public static void countsort(int []arr){
        if(arr==null||arr.length<=1){
            return;
        }
        //to find largest element in the array
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
           if(num>max){
               max=num;
           }
        }
        //now create a arr of length max+1 and write in order of frequecy with indexes depicting actual elements
        int[]countArray=new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            int nums = arr[i];
            countArray[nums]++;//for finding FREQUENCY
        }
        //now update the original array ek ek karke occuence likho
        int index=0;
        for (int i=0;i<=max;i++){//original array
            while (countArray[i]>0){//kitni occurence hai
                arr[index]=i;
                index++;
                countArray[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int []arr={6,3,10,9,2,4,9,7};
        countsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
