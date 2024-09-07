package DynamicProgramming;

import java.util.Arrays;

public class _3FrogJumpK {
    //memoization
    static int solveUtil(int ind,int [] height,int[]dp,int k){
        if(ind==0){//base case
            return 0;
        }
        if(dp[ind]!=-1) return dp[ind];//if result has been previously craeted ,return it

        int minSteps=Integer.MAX_VALUE;
        //loop to try all the possible jumps from 1 to k

        for(int j=1;j<=k;j++){
            //ensure that we dont ju,p beyond the begining of the array
            if(ind-j>=0){
                // calc the cost of the jump and update the min steps
                int jump=solveUtil(ind-j,height,dp,k)+Math.abs(height[ind]-height[ind-j]);
                minSteps=Math.min(minSteps,jump);
            }
        }
        return dp[ind]=minSteps;
    }
    static int solve(int n,int[]height,int k){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        //for memoization
        //return solveUtil(n-1,height,dp,k);//start the recursion from the last index

        //for tabulation
       return solveTabu(n,height,dp,k);
    }

    public static void main(String[] args) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k));
    }

    static int solveTabu(int n,int height[],int []dp,int k){
     dp[0]=0;
     //loop through the array to fill in the dp array
        for (int i=1;i<n;i++){
            int minsteps=Integer.MAX_VALUE;

            //loop to try all the posssible jumps frpm 1 to k
            for(int j=1;j<=k;j++){
                if (i - j >= 0) {
                    int jump=dp[i-j]+Math.abs(height[i]-height[i-j]);
                    minsteps=Math.min(jump,minsteps);
                }
            }
            dp[i]=minsteps;
        }
        return dp[n-1];//in this the result is stored in the last element of dp
    }
}
