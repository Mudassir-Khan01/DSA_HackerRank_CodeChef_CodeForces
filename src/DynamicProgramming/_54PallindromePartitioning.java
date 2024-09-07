package DynamicProgramming;


import java.util.Arrays;

public class _54PallindromePartitioning {
    static boolean isPallindrom(int i,int j,String s){
        while (i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    static int f(int i,int n,String str){
        if(i==n) return 0;
        int mini=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPallindrom(i,j,str)){
                int cost=1+f(j+1,n,str);
                mini= Math.min(mini,cost);
            }
        }
        return mini;
    }
    static int palindromePartitioning(String str){
        int n=str.length();
        return f(0,n,str)-1;
    }

    //memization

    static int f(int i,int n,String str,int[]dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int mini=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPallindrom(i,j,str)){
                int cost=1+f(j+1,n,str,dp);
                mini=Math.min(mini,cost);
            }
        }
        return dp[i]=mini;
    }
    static int palindromePartitioning2(String str) {
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, n, str, dp) - 1;
    }

    //tabul
    static int palindromePartitioning3(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPallindrom(i, j, str)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }
    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int partitions = palindromePartitioning(str);
        System.out.println("The minimum number of partitions: " + partitions);

       int partitions2=palindromePartitioning2(str);
        System.out.println("The minimum number of partitions: " + partitions2);

    }
}
