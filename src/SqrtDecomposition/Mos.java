package SqrtDecomposition;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Mos {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;
        //build block array
        int sqrt = (int) Math.sqrt(n);
        int block_id = -1;
        int[] blocks = new int[sqrt + 1];
        for (int i = 0; i < n; i++) {
            if (i % sqrt == 0) {//new block is starting
                block_id++;
            }
            blocks[block_id] += arr[i];//just keep adding
        }
        System.out.println(Arrays.toString(blocks));
        System.out.println(query(blocks,arr,2,7,3));
    }
        public static int query(int[]blocks,int[]arr,int l,int r,int sqrt){
         int ans=0;
         //left part
         while(l%sqrt!=0&&l<r&&l!=0){
             ans+=arr[l];
             l++;
         }
         //middle part
         while(l+sqrt<=r){
             ans+=blocks[l/sqrt];
             l+=sqrt;
         }
         //right part
            while(l<=r){
                ans+=arr[l];
                l++;
            }
         return ans;
        }
        public void update(int[]blocks,int[]arr,int i,int val,int sqrt){
        int block_id=i/sqrt;
        blocks[block_id]+=(val-arr[i]);//block[block_id]+new value - old value
        arr[i]=val;
        }
    }
