package DynamicProgramming;

import java.util.Arrays;

public class _20CoinChange {

    static long countWaysToMakeChangeUtil(int []arr,int ind,int T,long [][]dp){
        if(ind==0){
            if(T%arr[0]==0)
                return 1;
            else
                return 0;
        }
        if (dp[ind][T] != -1)
            return dp[ind][T];

        long nottaken=countWaysToMakeChangeUtil(arr,ind-1,T,dp);
        long take=0;
        if(arr[ind]<=T)
         take=countWaysToMakeChangeUtil(arr,ind,T-arr[ind],dp);

        return dp[ind][T]=nottaken+take;
    }
    static long countWaysToMakeChange(int[] arr, int n, int T) {
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (long row[] : dp)
            Arrays.fill(row, -1);

        // Call the countWaysToMakeChangeUtil function to calculate the number of ways
        return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
    }

    //tabulation
    static long countWaysToMakeChange2(int []arr,int n,int T){
        long dp[][]=new long[n][T+1];
        //initalize base cond for the first element of the array
        for(int i=0;i<=T;i++){
            if(1%arr[0]==0)
                dp[0][i]=1;
        }
        for(int ind=1;ind<n;ind++){
            for (int target=0;target<=T;target++){
                long notTaken = dp[ind - 1][target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }
        return dp[n-1][T];
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));


        System.out.println("The total number of ways is " + countWaysToMakeChange2(arr, n, target));
    }
}
