package DynamicProgramming;

import java.lang.annotation.Target;
import java.util.Arrays;

public class _18MinimumCoins {
    static int minimum(int []arr,int ind,int T,int [][]dp){
        //base case
        if(ind==0){
            if(T%arr[0]==0)
                return T/arr[0];
            else
                return (int )Math.pow(10,9);
        }
        if(dp[ind][T]!=-1)
            return dp[ind][T];

        int nottaken=0+minimum(arr,ind-1,T,dp);
        int taken=(int )Math.pow(10,9);
        if(arr[ind]<=T)
            taken=1+minimum(arr,ind,T-arr[ind],dp);

        return dp[ind][T]=Math.min(taken,nottaken);
    }
    static int minimumElements(int[] arr, int T) {
        int n = arr.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Calculate the minimum number of elements to achieve the target sum
        int ans = minimum(arr, n - 1, T, dp);

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    //tabul
    static int minimum2(int []arr,int T){
        int n=arr.length;
        int dp[][]=new int[n][T+1];

        //initalize the dp array for the first elememt of the array
        for(int i=0;i<=T;i++){
            if(i%arr[0]==0)
                dp[0][i]=i/arr[0];
            else
                dp[0][i]=(int) Math.pow(10, 9);
        }
        for(int ind=1;ind<n;ind++){
            for (int target=0;target<=T;target++){
                int nottaken=0+dp[ind-1][target];
                int taken=(int) Math.pow(10, 9);
                if(arr[ind]<=target)
                    taken=1+dp[ind][target-arr[ind]];

                //store it
                dp[ind][target]=Math.min(nottaken,taken);
            }
        }
        int ans= dp[n-1][T];
        if(ans>=(int) Math.pow(10, 9))
            return -1;

        return ans;
    }

    //space
    static int minimumElementss(int[] arr, int T) {
        int n = arr.length;

        // Create two arrays to store results of subproblems: prev and cur
        int prev[] = new int[T + 1];
        int cur[] = new int[T + 1];

        // Initialize the prev array for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                prev[i] = i / arr[0];
            else
                prev[i] = (int) Math.pow(10, 9);
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = 0 + prev[target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (arr[ind] <= target)
                    take = 1 + cur[target - arr[ind]];

                // Store the minimum result in the cur array
                cur[target] = Math.min(notTake, take);
            }

            // Update prev with cur for the next iteration
            prev = cur.clone();
        }

        // Get the minimum number of elements needed for the target sum
        int ans = prev[T];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int T = 7;

        // Call the minimumElements function and print the result
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElements(arr, T));


        System.out.println("The minimum number of coins required to form the target sum is " + minimum2(arr, T));


        System.out.println("The minimum number of coins required to form the target sum is " + minimumElementss(arr, T));
    }


}
