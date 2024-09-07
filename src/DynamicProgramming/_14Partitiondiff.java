package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class _14Partitiondiff {
    //memoization
static int minSub(ArrayList<Integer> arr,int n){
    int totalsum=0;
    for(int i=0;i<n;i++){
        totalsum+=arr.get(i);
    }
    boolean[][]dp=new boolean[n][totalsum+1];
    //initalize the dp table for the first row
    for(int i=0;i<=totalsum;i++){
        dp[0][i]=(i==arr.get(0));
    }
    //fill in the dp table using bottom uo dp
    for(int ind=1;ind<n;ind++){
        for(int target=0;target<=totalsum;target++){
            boolean notaken=dp[ind-1][target];
            boolean taken =false;
            if(arr.get(ind)<=target){
                taken=dp[n-1][target-arr.get(ind)];
            }
            //update the dp table for the current element
            dp[ind][target]=notaken||taken;
        }
    }
    int mini=Integer.MAX_VALUE;
    //find the min abs diff betwwn two subsets
    for(int i=0;i<=totalsum;i++){
        if(dp[n-1][i]){//last wala row
            int diff = Math.abs(i - (totalsum- i));//s1-s2
            mini=Math.min(mini,diff);
        }
    }
    return mini;
}

//tabulation
    static int minSub2(ArrayList<Integer> arr,int n){
    int totalsum=0;
    for(int i=0;i<n;i++){
        totalsum+=arr.get(i);
    }
    boolean[][]dp=new boolean[n][totalsum+1];
    //initalize the dp table for the first row and col
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr.get(0)<=totalsum){
            dp[0][totalsum]=true;
        }
        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=totalsum;target++){
                boolean nottaken=dp[ind-1][target];
                boolean taken=false;
                if(arr.get(ind)<=target){
                    taken=dp[ind-1][target-arr.get(ind)];
                }
                //uodate
                dp[ind][target]=nottaken||taken;
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<=totalsum;i++){
            if(dp[n-1][i]){
                int diff=Math.abs(i-(totalsum-i));
                mini=Math.min(mini,diff);
            }
        }
        return mini;

    }

    //s[ace
    static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create an array to store DP results for the previous row
        boolean[] prev = new boolean[totSum + 1];

        // Initialize the DP array for the first row
        prev[0] = true;

        // Initialize the DP array for the first column
        if (arr.get(0) <= totSum) {
            prev[arr.get(0)] = true;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store DP results for the current row
            boolean[] cur = new boolean[totSum + 1];
            cur[0] = true;
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = prev[target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = prev[target - arr.get(ind)];
                }

                // Update the DP array for the current element and target sum
                cur[target] = notTaken || taken;
            }
            prev = cur;
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = arr.size();

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSub(arr, n));

        //tabul
        System.out.println("The minimum absolute difference is: " + minSub2(arr, n));
//space
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));

    }
}
