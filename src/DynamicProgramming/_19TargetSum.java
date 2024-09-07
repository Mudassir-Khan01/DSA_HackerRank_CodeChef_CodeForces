package DynamicProgramming;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class _19TargetSum {//same as count Partition refer to that
    static int countPartitionsUtil(int ind,int target,int []arr,int [][]dp){
        if(ind==0){
            if(target==0&&arr[0]==0)
                return 2;
            if(target==0||target==arr[0])
                return 1;

            return 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
    int not=countPartitionsUtil(ind-1,target,arr,dp);
    int taken=0;
    if(arr[ind]<=target)
        taken=countPartitionsUtil(ind-1,target-arr[ind],arr,dp);

    return dp[ind][target]=not+taken;
    }
    static int targetSum(int n, int target,int []arr){
        int totalsum=0;
        for (int i=0;i<arr.length;i++){
            totalsum+=arr[i];
        }
        if(totalsum-target<0)
            return 0;
        if((totalsum-target)%2==1)
            return 0;
        int s2=(totalsum-target)/2;
        int[][]dp=new int[n][s2+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);


        return countPartitionsUtil(n - 1, s2, arr, dp);

    }
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 1 };
        int target = 3;

        int n = arr.length;

        // Call the targetSum function and print the result
        System.out.println("The number of ways found is " + targetSum(n, target, arr));
    }

}
