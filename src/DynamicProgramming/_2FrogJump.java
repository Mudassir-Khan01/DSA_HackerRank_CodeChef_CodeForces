package DynamicProgramming;

import java.util.Arrays;

public class _2FrogJump {
    //memoization
    static int solve(int ind,int[] height,int []dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1)return dp[ind];
        int jumpTwo=Integer.MAX_VALUE;
        int jumpOne=solve(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);
        if(ind>1){
            jumpTwo=solve(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]);

        }
        return dp[ind]=Math.min(jumpOne,jumpTwo);
    }

    public static void main(String[] args) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(solve(n-1,height,dp));


        //tabulation
        int heightt[]={30,10,60 , 10 , 60 , 50};
        int nn=heightt.length;
        int dpp[]=new int[nn];
        Arrays.fill(dpp,-1);
        dpp[0]=0;
        for(int ind=1;ind<n;ind++){
            int jumpTwoo=Integer.MAX_VALUE;
            int jumpOnee=dpp[ind-1]+Math.abs(height[ind]-height[ind-1]);
            if(ind>1)
                jumpTwoo = dp[ind-2] + Math.abs(height[ind]-height[ind-2]);

            dpp[ind]=Math.min(jumpOnee,jumpTwoo);
        }
        System.out.println(dpp[nn-1]);//ans will be at n-1


        // space optimization(no need of dp array)
        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++){
            int jumpTwo=Integer.MAX_VALUE;
            int jumpOne=prev+Math.abs(heightt[i]-heightt[i-1]);
            if(i>1)
             jumpTwo=prev2+Math.abs(heightt[i]-heightt[i-2]);

            int current=Math.min(jumpOne,jumpTwo);
            prev2=prev;
            prev=current;
        }
        System.out.println(prev);
    }
}
