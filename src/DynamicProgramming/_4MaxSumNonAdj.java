package DynamicProgramming;

import java.util.Arrays;

public class _4MaxSumNonAdj {
    //memoization
    static int solve(int ind,int[]arr,int[]dp){
        if(ind<0) return 0;
        if(ind==0) return arr[ind];//if index is 0 there is only one element to consider
        if(dp[ind]!=-1) return dp[ind];

        int pick=arr[ind]+solve(ind-2,arr,dp);//pick it + dont take the adjacent one so 2
        int nonpick=0+solve(ind-1,arr,dp);
        return Math.max(pick,nonpick);
    }
    static int sol(int n,int[]arr){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        //for memoization
        return solve(n-1,arr,dp);//call the recursive solver for the last index(n-1)
   // return solve2(n,arr,dp); // for tabulation
    }
    public static void main(String args[]) {
        // Input array with elements.
        int arr[] = {2, 1, 4, 9};

        // Get the length of the array.
        int n = arr.length;

        // Call the solve function to find the maximum possible sum.
        int result = sol(n, arr);

        // Print the result.
        System.out.println(result);

        //for space optimization
        //System.out.println(solce3(n,arr));
    }

    //Tabulation
    static int solve2(int n,int[]arr,int []dp){
        dp[0]=arr[0];
        //iterate through the input array to fill the dp array
        for(int i=1;i<n;i++){
            //calculate the maximum sum by piclikng the current element and by non pickingh it
            int pick=arr[i];
            //if there are atleast two elements before the current element add gthe value from dp[i-2]
            if(i>1)
                pick=pick+dp[i-2];

            //the non pick option is to use the maximum sum from the previous elelment
            int nonpick=dp[i-1];

            dp[i]=Math.max(pick,nonpick);
        }
        return dp[n-1];

    }

    //SPACE OPTIMIZATION
    static int solce3(int n, int []arr){
        //itialize vartiables to keep track of the max sums at the current and previous position
        int prev=arr[0];
        int prev2=0;

        for(int i=1;i<n;i++){
            int pick=arr[i];
            if(i>1){
                pick+=prev2;
            }
            int nonpick=prev;

            int curr=Math.max(pick,nonpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
