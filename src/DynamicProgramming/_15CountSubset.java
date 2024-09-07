package DynamicProgramming;
import java.util.*;
public class _15CountSubset {
    static int findWays(int ind,int target,int []arr,int[][]dp){
        //base cases
        if(target==0)
            return 1;

        if(ind==0)//if we are at oth index then its value must be equal to target to get the subset
            return arr[0]==target?1:0;

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken=findWays(ind-1,target,arr,dp);
        int taken=0;
        if(arr[ind]<=target)
            taken=findWays(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]=notTaken+taken;
    }
    static int find(int[] num, int k) {
        int n = num.length;
        int dp[][] = new int[n][k + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return findWays(n - 1, k, num, dp);
    }

    //tabulation
    static int findWays2(int []nums,int k){
        int n=nums.length;
        int dp[][]=new int[n][k+1];
        //initalize the first row of the dp array
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
       if(nums[0]<=k) {
           dp[0][nums[0]] = 1;
       }
           for(int ind=1;ind<n;ind++){
               for(int target=1;target<=k;target++){
                   int nottaken=dp[ind-1][target];

                   int taken=0;
                   if(nums[ind]<=target)
                       taken=dp[ind-1][target-nums[ind]];

                    dp[ind][target]=nottaken+taken;
               }
           }
       return dp[n-1][k];
    }

    //space
    static int findWays3(int[] num, int k) {
        int n = num.length;

        // Create an array to store the number of ways to achieve each target sum
        int[] prev = new int[k + 1];

        // Initialize the first element of the array
        prev[0] = 1;

        // Initialize the array for the first column
        if (num[0] <= k) {
            prev[num[0]] = 1;
        }

        // Fill in the array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store the number of ways for the current element
            int[] cur = new int[k + 1];

            // Initialize the first element of the current array
            cur[0] = 1;

            for (int target = 1; target <= k; target++) {
                // Calculate the number of ways when the current element is not taken
                int notTaken = prev[target];

                // Calculate the number of ways when the current element is taken
                int taken = 0;
                if (num[ind] <= target) {
                    taken = prev[target - num[ind]];
                }

                // Update the current array for the current element and target sum
                cur[target] = notTaken + taken;
            }

            // Update the previous array with the current array for the next iteration
            prev = cur;
        }

        // The result is stored in the last element of the array
        return prev[k];
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + find(arr, k));
        System.out.println("The number of subsets found are " + findWays2(arr, k));
        System.out.println("The number of subsets found are " + findWays3(arr, k));

    }

    //if 0 is there in the array then there is   a slight changes in base case
    static int findWaysUtil(int ind, int target,int[] arr, int[][] dp){

        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = findWaysUtil(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= notTaken + taken;
    }
}
