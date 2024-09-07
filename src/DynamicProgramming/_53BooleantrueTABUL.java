package DynamicProgramming;

public class _53BooleantrueTABUL {
    static final int MOD = 1000000007;

    static int evaluateExp(String exp){
        int n=exp.length();
        long[][][] dp=new long[n][n][2];

        //initalizing the dp array
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=n-1;j++){
                if(i>j) continue;
                for(int isTrue=0;isTrue<=1;isTrue++){
                    //base case
                    if(i==j){
                        if(isTrue==1)
                            dp[i][j][isTrue]=exp.charAt(i)=='T'?1:0;
                        else
                            dp[i][j][isTrue]=exp.charAt(i)=='F'?1:0;
                      continue;
                    }
                    long ways=0;
                    for(int ind=i+1;ind<=j-1;ind+=2){
                        long lT=dp[i][ind-1][1];
                        long lF = dp[i][ind - 1][0];
                        long rT = dp[ind + 1][j][1];
                        long rF = dp[ind + 1][j][0];

                        char operator=exp.charAt(ind);
                        if (operator == '&') {
                            if (isTrue == 1) ways = (ways + (lT * rT) % MOD) % MOD;
                            else ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                        } else if (operator == '|') {
                            if (isTrue == 1) ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                            else ways = (ways + (lF * rF) % MOD) % MOD;
                        } else {
                            if (isTrue == 1) ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                            else ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                        }
                    }
                    dp[i][j][isTrue]=ways;
                    }
                }
            }
        return (int )dp[0][n-1][1];
        }
    public static void main(String[] args) {
        String exp = "F|T^F";
        int ways = evaluateExp(exp);
        System.out.println("The total number of ways: " + ways);
    }
    }
