package DynamicProgramming;

public class _29ShortestCommonSupersubse {
    static String shortestSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        //for printing length of shortest common supersequence n+m-len
        int len = dp[n][m];//stored the length of lcs
        int i = n;
        int j = m;
        int index = len - 1;
        String ans = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans += s1.charAt(i - 1);//if equal then store any but once
                i--;
                j--;
                index--;
            } else if (s1.charAt(i - 1) > s2.charAt(j - 1)) {
                ans += s1.charAt(i - 1);
                i--;
            } else {
                ans += s2.charAt(j - 1);
                j--;
            }
        }
        //adding remaining -only one of the below two loops will run
        while (i > 0) {
            ans += s1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            ans += s2.charAt(j - 1);
            j--;
        }
        String ans2 = new StringBuilder(ans).reverse().toString();
        return ans2;
    }
    public static void main(String args[]) {

        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Longest Common Supersequence is "+shortestSupersequence(s1,s2));
    }
}
