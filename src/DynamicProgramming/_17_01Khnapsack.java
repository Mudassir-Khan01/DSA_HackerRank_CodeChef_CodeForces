package DynamicProgramming;

import java.util.Arrays;

public class _17_01Khnapsack {
    static int knapscak(int []wt,int []val,int ind ,int w,int dp[][]){
        //base condition
        if(ind==0){
            if(wt[ind]<=w)
                return val[0];
            else
                return 0;
        }
        if(dp[ind][w]!=-1)
            return dp[ind][w];

        int nottaken=0+knapscak(wt,val,ind-1,w,dp);
        int taken =Integer.MIN_VALUE;
        if(wt[ind]<=w){
            taken=val[ind]+knapscak(wt,val,ind-1,w-wt[ind],dp);
        }

        return dp[ind][w]=Math.max(nottaken,taken);
    }
    static int knapsack(int[] wt, int[] val, int n, int W) {
        // Create a 2D DP array to store the maximum value for each subproblem
        int dp[][] = new int[n][W + 1];

        // Initialize the DP array with -1 to indicate that subproblems are not solved
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive knapsackUtil function to solve the problem
        return knapscak(wt, val, n - 1, W, dp);
    }


    //tabul
    static int knapsack2(int []wt,int[]val,int n,int w){
        int dp[][]=new int[n][w+1];
        //base condition
        for(int i=wt[0];i<=w;i++) {
            dp[0][i] = val[0];
        }
        for(int ind=1;ind<n;ind++){
            for(int cap=0;cap<=w;cap++){
                int nottaken =dp[ind-1][cap];
                int taken =Integer.MIN_VALUE;
                if(wt[ind]<=cap){
                    taken=val[ind]+dp[ind-1][cap-wt[ind]];
                }
                dp[ind][cap]=Math.max(nottaken,taken);

            }

        }
        return dp[n-1][w];
    }

    //space
    static int knapsack3(int []wt,int []val,int n,int w){
        int prev[]=new int[w+1];
        for(int i=wt[0];i<=w;i++){
            prev[i]=val[0];
        }
        for(int ind=1;ind<n;ind++){
            int cur[]=new int[w+1];
            for(int cap=0;cap<=w;cap++){
                int nottaken=0+prev[cap];
                int taken=Integer.MIN_VALUE;
                if(wt[ind]<=cap){
                    taken=val[ind]+prev[cap-wt[ind]];
                }
                cur[cap]=Math.max(nottaken,taken);
            }
            prev=cur;
        }
        return prev[w];
    }
    public static void main(String args[]) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        // Calculate and print the maximum value of items the thief can steal
        System.out.println("The Maximum value of items the thief can steal is " + knapsack(wt, val, n, W));


        System.out.println("The Maximum value of items the thief can steal is " + knapsack2(wt, val, n, W));

        System.out.println("The Maximum value of items the thief can steal is " + knapsack3(wt, val, n, W));

        System.out.println("The Maximum value of items the thief can steal is " + knap(wt, val, n, W));

    }

    //more optimized
    static int knap(int[] wt, int[] val, int n, int W) {
        // Create an array to store the maximum value for each capacity (previous row)
        int prev[] = new int[W + 1];

        // Base Condition: Initialize the first row of the array
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind < n; ind++) {
            for (int cap = W; cap >= 0; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }

                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last element of the array
        return prev[W];
    }
}
