package DynamicProgramming;

import java.util.Arrays;

public class _27MinInsertPallin {
    static int lcs(String s1,String s2){//to find longest common subsequence
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store the LCS lengths
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }
    static int longestPalindromeSubsequence(String s){
        String reversed=new StringBuilder(s).reverse().toString();
        return lcs(s,reversed);
    }
    static int minInsertion(String s){
        int n=s.length();
        int k=longestPalindromeSubsequence(s);
        return n-k;
    }
    public static void main(String args[]) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make the string palindrome: " + minInsertion(s));
    }
}
