package DynamicProgramming;

import java.util.Arrays;

public class _22RodCutting  {
    static int rod(int N,int price[],int ind,int [][]dp){
        int rodlength=ind+1;
        //base case
        if(ind==0){
            return price[ind]*N;
        }
        int nottaken=0+rod(N,price,ind-1,dp);
        int taken=Integer.MIN_VALUE;
        if(rodlength<=N)
            taken=price[ind]+rod(N-rodlength,price,ind,dp);

        return dp[ind][N]=Math.max(taken,nottaken);
    }
    static int roddd(int n, int price[],int N){
        int dp[][]=new int[n][N+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return rod(N,price,n-1,dp);
    }

    public static void main(String[] args) {
        int price[]={2,5,7,8,10};
        int n=price.length;
        int N=5;
        System.out.println(roddd(n,price,N));
    }
}
