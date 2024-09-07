package DynamicProgramming;

import java.util.Arrays;

public class _32WildcardMatching {
    static boolean isAllStars(String s1, int i) {
        for (int j = 0; j <= i; j++) {
            if (s1.charAt(j) != '*')
                return false;
        }
        return true;
    }

    static int wildcard(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;//both string empty and the pattern matches.
        if (i < 0 && j >= 0)
            return 0;
        if (j < 0 && i >= 0)
            return isAllStars(s1, i) ? 1 : 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
            return dp[i][j] = wildcard(s1, s2, i - 1, j - 1, dp);
        else {
            if (s1.charAt(i) == '*') {
                // Two possibilities when encountering '*':
                // 1. '*' matches one or more characters in S2.
                // 2. '*' matches zero characters in S2.
                return dp[i][j] = (wildcard(s1, s2, i - 1, j, dp) == 1 || wildcard(s1, s2, i, j - 1, dp) == 1) ? 1 : 0;
            } else {//characters dont match and s1[i] is not *
                return 0;
            }
        }
    }

    static int wildcardMatching(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return wildcard(S1, S2, n - 1, m - 1, dp);
    }

    static boolean isAllStars2(String s1, int i) {
        for (int j = 1; j <= i; j++) {
            if (s1.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    static boolean wildcard2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(s1, i);
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (s1.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[n][m];
    }
    static boolean wildcard3(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // Create two boolean arrays to store the matching results for the current and previous rows
        boolean[] prev = new boolean[m + 1];
        boolean[] cur = new boolean[m + 1];

        // Initialize the first element of prev as true
        prev[0] = true;

        // Iterate through S1 and S2 to fill the cur array
        for (int i = 1; i <= n; i++) {
            // Initialize the first element of cur based on whether S1 contains '*'
            cur[0] = isAllStars(S1, i);
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
                    cur[j] = prev[j - 1]; // Characters match or '?' is encountered.
                } else {
                    if (S1.charAt(i - 1) == '*') {
                        cur[j] = prev[j] || cur[j - 1]; // '*' matches one or more characters.
                    } else {
                        cur[j] = false; // Characters don't match, and S1[i-1] is not '*'.
                    }
                }
            }
            // Update prev array to store the current values
            prev = cur.clone();
        }

        return prev[m]; // The final result indicates whether S1 matches S2.
    }

    public static void main(String args[]) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2) == 1)
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");


        //tabul
        if (wildcard2(S1, S2))
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");

   // space
        if (wildcard3(S1, S2))
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");}
}

