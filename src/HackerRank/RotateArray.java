package HackerRank;

import java.util.Arrays;

public class RotateArray {

        public void rotate(int[] nums, int k) {
            k %= nums.length; // Handle k larger than array length
            reversee(0, nums.length - k, nums); // Reverse all but the last k elements
            reversee(nums.length - k, nums.length, nums); // Reverse the first k elements
            System.out.println(Arrays.toString(nums));

        }

        public int[] reversee(int start, int end, int [] nums){
            for(int i=start;i<end/2;i++){
                int temp=nums[i];
                nums[i]=nums[end-1-i];
                nums[end-1-i]=temp;
            }
            return nums;
        }

    public static void main(String[] args) {
        RotateArray obj=new RotateArray();
        int[]nums={1,2,3,4,5,6,7};
        int k=3;
        obj.rotate(nums,k);
    }
    }

