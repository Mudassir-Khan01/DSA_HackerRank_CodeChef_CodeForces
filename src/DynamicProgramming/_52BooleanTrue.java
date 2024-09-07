package DynamicProgramming;

import java.util.stream.Stream;

public class _52BooleanTrue {
    static final int MOD = 1000000007;

    static long evaluate(String exp,int i,int j,int isTrue,Long[][][]dp){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1){
                return exp.charAt(i)=='T'?1:0;
            }else{
                return exp.charAt(i)=='F'?1:0;
            }
        }
        if (dp[i][j][isTrue] != null) {
            return dp[i][j][isTrue];
        }
        long ways=0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            long lt=evaluate(exp,i,ind-1,1,dp);
            long lf=evaluate(exp,i,ind-1,0,dp);
            long rt=evaluate(exp,ind+1,j,1,dp);
            long rf=evaluate(exp,ind+1,j,0,dp);

            char operator=exp.charAt(ind);
            if(operator=='&'){
                if (isTrue==1){
                    ways=(ways+(lt*rt)%MOD)%MOD;
                }else {
                    ways=(ways+(lf*rf)%MOD+(lf*rt)%MOD+(lt*rf)%MOD)%MOD;
                }
            }else if(operator=='|'){
                if(isTrue==1){
                    ways=(ways+(lt*rt)%MOD+(lt*rf)%MOD+(lf*rt)%MOD)%MOD;
                }else {
                    ways=(ways+(lf*rf)%MOD)%MOD;
                }
            }else {
                if(isTrue==1){
                    ways=(ways+(lf*rt)%MOD+(lt*rf)%MOD)%MOD;
                }else {
                    ways=(ways+(lt*rt)%MOD+(lf*rf)%MOD)%MOD;
                }
            }
        }
        dp[i][j][isTrue]=ways;
        return ways;
    }
    static int eva(String exp){
        int n=exp.length();
        Long[][][]dp=new Long[n][n][2];
        return (int)evaluate(exp,0,n-1,1,dp);
    }
    public static void main(String[] args) {
        String exp = "F|T^F";
        int ways = eva(exp);
        System.out.println("The total number of ways: " + ways);
    }
}
