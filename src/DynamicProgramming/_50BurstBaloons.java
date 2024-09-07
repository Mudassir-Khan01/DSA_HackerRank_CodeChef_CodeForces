package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class _50BurstBaloons {
    static int maxCoins(int i, int j, ArrayList<Integer> a){
        if(i>j)
            return 0;

        int maxi=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int ans=a.get(i-1)*a.get(ind)*a.get(j+1)+maxCoins(i,ind-1,a)+maxCoins(ind+1,j,a);
            maxi=Math.max(maxi,ans);
        }
        return maxi;
    }
    static int maxCoins(ArrayList<Integer>a){
        int n=a.size();
        a.add(1);
        a.add(0,1);
        return maxCoins(1,n,a);
    }

    //memoizatuion
    static int maxCoins2(int i,int j,ArrayList<Integer>a ,int [][]dp){
        if (i>j)return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1)
                    + maxCoins2(i, ind - 1, a, dp) + maxCoins2(ind + 1, j, a, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j]=maxi;
    }
    static int maxCoins2(ArrayList<Integer> a) {
        int n = a.size();
        a.add(1);
        a.add(0, 1);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxCoins2(1, n, a, dp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 1, 5, 8));
//        int ans = maxCoins(a);
//        System.out.println(ans);
        //memoization
        int ans2=maxCoins2(a);
        System.out.println(ans2);

    }
}
