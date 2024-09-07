package DynamicProgramming;

import java.util.Arrays;

public class _30DistinctSubse {
    static int prime = (int) (Math.pow(10, 9) + 7);

    static int countUtil(String s1,String s2,int ind1,int ind2,int [][]dp){
        //if we have exhausted s2, theres one valid subsequence in s1
        if(ind2<0)
            return 1;
        //if we have exhausted s1, theres np valid subsequence
        if(ind1<0)
            return 0;
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
    //if the character at the current position match, we can either leave one character from s1
        //or continue to the next character in s1 while staying at the same character in s2
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            int leaveone=countUtil(s1,s2,ind1-1,ind2-1,dp);
            int staty=countUtil(s1,s2,ind1-1,ind2,dp);
            return dp[ind1][ind2]=(leaveone+staty)%prime;
        }else {
            return dp[ind1][ind2]=countUtil(s1,s2,ind1-1,ind2,dp);
        }
    }
    static int subsequenceCounting(String s1, String s2, int lt, int ls) {
        // Initialize a DP array to store intermediate results
        int dp[][] = new int[lt][ls];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Call the recursive helper function to compute the count
        return countUtil(s1, s2, lt - 1, ls - 1, dp);
    }

    //tabulation
    static int subsequenceCounting2(String s1,String s2,int n,int m){
        int dp[][]=new int[n+1][m+1];//right shift by one
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
                } else {
                    // If the characters don't match, we can only exclude this character.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    //space
    static int subsequenceCounting3(String s1,String s2,int n,int m){
        int []prev=new int[m+1];
        prev[0]=1;
        int []cur=new int[m+1];
        cur[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j]=(prev[j-1]+prev[j])%prime;
                }else {
                    cur[j]=prev[j];
                }
                }
            prev=cur.clone();
            }return prev[m];
    }
    public static void main(String args[]) {
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting(s1, s2, s1.length(), s2.length()));
        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting2(s1, s2, s1.length(), s2.length()));
        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting3(s1, s2, s1.length(), s2.length()));
    }


    //using 1 array
    static int subsequenceCounting4(String s1, String s2, int n, int m) {
        // Create an array to store the counts of subsequences
        int[] prev = new int[m + 1];

        // Initialize the first element to 1 because there's one empty subsequence in any string.
        prev[0] = 1;

        // Fill the prev array using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = m; j >= 1; j--) { // Reverse direction for updating

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    prev[j] = (prev[j - 1] + prev[j]) % prime;
                } else {
                    // If the characters don't match, we can only exclude this character.
                    prev[j] = prev[j]; // This statement is not necessary, as it doesn't change the value.
                }
            }
        }

        return prev[m];
    }
}
