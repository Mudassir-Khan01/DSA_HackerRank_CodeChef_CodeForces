package DynamicProgramming;

import java.util.Arrays;

public class _39LongestIncreasinfSubse {
    static int getAns(int []arr,int n,int ind,int prev,int [][]dp){
        //base cond
        if(ind==n)
            return 0;
        if (dp[ind][prev+ 1] != -1) {
            return dp[ind][prev+ 1];
        }
        int nottake=0+getAns(arr,n,ind+1,prev,dp);
        int take=0;
        if(prev==-1||arr[ind]>arr[prev]){
             take=1+getAns(arr,n,ind+1,ind,dp);
        }
        dp[ind][prev+1]=Math.max(nottake,take);
        return dp[ind][prev+1];
    }
    static int longestIncreasingSubsequence(int arr[], int n) {
        int dp[][] = new int[n][n + 1];

        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return getAns(arr, n, 0, -1, dp);
    }

    //tabuul

    static int longest(int []arr,int n){
        int dp[][]=new int[n+1][n+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int prev=ind-1;prev>=-1;prev--){
                int nottake=0+dp[ind+1][prev+1];
                int take=0;
                if(prev==-1||arr[ind]>arr[prev]){
                    take=1+dp[ind+1][ind+1];
                }
                dp[ind][prev+1]=Math.max(nottake,take);
            }
        }
        return dp[0][0];
    }

    //space
    static int longestIncreasingSubsequence3(int arr[], int n){

        int next[]=new int[n+1];
        int cur[]=new int[n+1];

        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = 0 + next[prev_index +1];

                int take = 0;

                if(prev_index == -1 || arr[ind] > arr[prev_index]){

                    take = 1 + next[ind+1];
                }

                cur[prev_index+1] = Math.max(notTake,take);
            }
            next = cur.clone();
        }

        return cur[0];
    }
    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
        System.out.println("The length of the longest increasing subsequence is " + longest(arr, n));
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence3(arr, n));

    }
//more efficient
    static int longestIncreasingSubsequence4(int arr[], int n){

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){

                if(arr[prev_index]<arr[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
                }
            }
        }

        int ans = -1;

        for(int i=0; i<=n-1; i++){
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
