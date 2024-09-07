package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _48MinCOstTocutStick {
    static int f(int i, int j, ArrayList<Integer> cuts ){
        if(i>j)
            return 0;//as i remains before j if it crosses it return 0

        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int ans=cuts.get(j+1)-cuts.get(i-1)+f(i,ind-1,cuts)+f(ind+1,j,cuts);
            mini=Math.min(ans,mini);
        }
        return mini;
    }
    static int cost(int n,int c,ArrayList<Integer>cuts ){
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        return f(1,c,cuts);
    }


    //memoization
    static int f2(int i, int j, ArrayList<Integer> cuts, int[][] dp) {
        // Base case
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cuts.get(j + 1) - cuts.get(i - 1) +
                    f2(i, ind - 1, cuts, dp) +
                    f2(ind + 1, j, cuts, dp);

            mini = Math.min(mini, ans);
        }

        return dp[i][j] = mini;
    }
    static int cost2(int n, int c, ArrayList<Integer> cuts) {
        // Modify the cuts array
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int[][] dp = new int[c + 1][c + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f2(1, c, cuts, dp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        System.out.println("The minimum cost incurred: " + cost(n, c, cuts));

        System.out.println("The minimum cost incurred: " + cost2(n, c, cuts));

    }
}
