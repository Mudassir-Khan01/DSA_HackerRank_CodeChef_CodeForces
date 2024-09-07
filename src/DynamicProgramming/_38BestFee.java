package DynamicProgramming;

import java.util.Arrays;

public class _38BestFee {
    static int get(int []arr,int ind,int buy,int n,int fee,int [][]dp){
        if(ind==n)
            return 0;
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int profit=0;
        if(buy==0){
            profit=Math.max(0+get(arr,ind+1,0,n,fee,dp),-arr[ind]+get(arr,ind+1,1,n,fee,dp));
        }
        if(buy==1){
            profit = Math.max(0 + get(arr, ind + 1, 1, n, fee, dp), arr[ind] - fee + get(arr, ind + 1, 0, n, fee, dp));
        }
        dp[ind][buy]=profit;
        return profit;
    }
    static int maximumProfit(int n, int fee, int[] Arr) {
        int dp[][] = new int[n][2];

        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        if (n == 0) {
            return 0;
        }

        int ans = get(Arr, 0, 0, n, fee, dp);
        return ans;
    }

    //tabul
    static int maximumProfit2(int n, int fee, int[] Arr) {
        // Handle the base case when n is 0
        if (n == 0) {
            return 0;
        }

        int dp[][] = new int[n + 1][2];

        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], Arr[ind] - fee + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        // The maximum profit is stored in dp[0][0]
        return dp[0][0];
    }

    //space
    static long maximumProfit3(int n, int fee, int[] Arr) {
        // Handle the base case when n is 0
        if (n == 0) {
            return 0;
        }

        long ahead[] = new long[2];
        long cur[] = new long[2];

        // Initialize base conditions
        ahead[0] = ahead[1] = 0;
        long profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] - fee + ahead[0]);
                }
                cur[buy] = profit;
            }

            ahead = (cur.clone());
        }
        return cur[0];
    }

    public static void main(String args[]) {
        int prices[] = {1, 3, 2, 8, 4, 9};
        int n = prices.length;
        int fee = 2;

        System.out.println("The maximum profit that can be generated is " + maximumProfit(n, fee, prices));
        System.out.println("The maximum profit that can be generated is " + maximumProfit2(n, fee, prices));
        System.out.println("The maximum profit that can be generated is " + maximumProfit3(n, fee, prices));

    }
}
