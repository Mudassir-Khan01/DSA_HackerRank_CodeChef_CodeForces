package DynamicProgramming;

import java.util.Arrays;

public class _23LongCommonSubse {
    static int lscUtil(String s1,String s2,int ind1,int ind2,int [][]dp){
        if(ind1<0||ind2<0)
            return 0;

        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];

        //if the character at the current indices are the same,then increnmt the lsc and decreases bith indices
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return dp[ind1][ind2]=1+lscUtil(s1,s2,ind1-1,ind2-1,dp);
        //if the vharacter atre different choose the maximum Lcs length by either
        //skipping a character in s1 or s2
        else
            return dp[ind1][ind2]=0+Math.max(lscUtil(s1,s2,ind1,ind2-1,dp),lscUtil(s1,s2,ind1-1,ind2,dp));
    }
    static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][m];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        return lscUtil(s1,s2,n-1,m-1,dp);
    }

    //tabulation
    static int lcs2(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        //initalize the first row and first col with zeroes since LCS with an empty string is zero
        for(int i=0;i<=n;i++){//n and m has shifted so at 0 it means -1 so we make it equal to 0
            dp[i][0]=0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
        //fill the dp array using dynamic programming
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))//indices are shifted to left so 0 means -1 ...n means n-1
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2]=0+Math.max(dp[ind1][ind2-1],dp[ind1-1][ind2]);
            }
        }
        return dp[n][m];//shifted so called n , m instead of n-1 ,m-1
    }

    //space
    static int lcs3(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        //create arrays tostire the lcs length
        int prev[]=new int[m+1];
        int cur[]=new int[m+1];

        for(int j=0;j<=m;j++){
            prev[j]=0;
        }
        for(int ind1=1;ind1<=n;ind1++){
            for (int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    cur[ind2]=1+prev[ind2-1];
                else
                    cur[ind2]=Math.max(prev[ind2],cur[ind2-1]);
            }
            prev=(int [])(cur.clone());
        }
        return prev[m];
    }
    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
        System.out.println("The Length of Longest Common Subsequence is " + lcs2(s1, s2));
        System.out.println("The Length of Longest Common Subsequence is " + lcs3(s1, s2));

    }

}
