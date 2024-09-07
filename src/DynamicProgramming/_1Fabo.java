package DynamicProgramming;

import java.util.Arrays;

public class _1Fabo {
    static int f(int n,int[]dp){
        if(n<=1) return n;

        if(dp[n]!=-1) return dp[n];
        return dp[n]=f(n-1,dp)+f(n-2,dp);
    }

    public static void main(String[] args) {
        int n=6;
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(f(n,dp));

        //tabulation
        dp[0]=0;//basic
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);

        //now space optimization
        int prev2=0;
        int prev=1;
        for(int i=2;i<=n;i++){
            int cur_i=prev+prev2;
            prev2=prev;
            prev=cur_i;
        }
        System.out.println(prev);
    }
}
