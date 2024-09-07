package DynamicProgramming;

import java.util.Arrays;

public class _21UnboundedKnapsack {
    static int knapsackUtil(int []wt,int []val,int ind,int w,int [][]dp){
        //base case
        if(ind==0) {
            if (w % wt[0] == 0)//infinite source
                return (w / wt[0]) * val[0];
            else
                return 0;
        }
        if(dp[ind][w]!=-1)
            return dp[ind][w];
        int nottaken=0+knapsackUtil(wt,val,ind-1,w,dp);
        int taken=Integer.MIN_VALUE;
        if(wt[ind]<=w)
            taken=val[ind]+knapsackUtil(wt,val,ind,w-wt[ind],dp);//infinite source

        return dp[ind][w]=Math.max(nottaken,taken);
    }
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][W + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the knapsackUtil function to solve the problem
        return knapsackUtil(wt, val, n - 1, W, dp);
    }

    //tabul
    static int unboundedKnapsack2(int n,int w,int []val,int []wt){
        int [][]dp=new int[n][w+1];
        //base condition
        for(int i=wt[0];i<=w;i++){
            if(i%wt[0]==0)
                dp[0][i]=(i/wt[0])*val[0];
            else
                    dp[0][i]=0;
        }
        for(int ind=1;ind<n;ind++){
            for(int cap=0;cap<=w;cap++){
                int nottaken=0+dp[ind-1][cap];
                int taken=Integer.MIN_VALUE;
                if(wt[ind]<=cap){
                    taken=val[ind]+dp[ind][cap-wt[ind]];
                }
                dp[ind][cap]=Math.max(nottaken,taken);
            }
        }
        return dp[n-1][w];
    }

    //spacde
    static int unboundedKnapsack3(int n, int W, int[] val, int[] wt) {
        // Create an array to store the maximum value for each capacity from 0 to W
        int cur[] = new int[W + 1];

        // Base condition: Initialize the cur array for the first item
        for (int i = wt[0]; i <= W; i++) {
            cur[i] = ((int) i / wt[0]) * val[0];
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = cur[cap];

                // Initialize the maximum value when the current item is taken as the minimum integer value
                int taken = Integer.MIN_VALUE;

                // If the weight of the current item is less than or equal to the current capacity (cap),
                // calculate the maximum value when the current item is taken
                if (wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];

                // Store the result in the cur array
                cur[cap] = Math.max(notTaken, taken);
            }
        }

        return cur[W]; // Return the maximum value that can be obtained with the given capacity W
    }
    public static void main(String args[]) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));
        System.out.println("The Maximum value of items the thief can steal is " + unboundedKnapsack2(n, W, val, wt));
        System.out.println("The Maximum value of items the thief can steal is " + unboundedKnapsack3(n, W, val, wt));

    }
}
