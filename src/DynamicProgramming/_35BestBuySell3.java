package DynamicProgramming;

import java.util.Arrays;

public class _35BestBuySell3 {
    static int getans(int []arr,int n ,int ind,int buy,int cap,int [][][]dp){
        if(ind==n||cap==0)
            return 0;
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        int profit=0;
        if(buy==0){//we can buy the stock
            profit=Math.max(0+getans(arr,n,ind+1,0,cap,dp),-arr[ind]+getans(arr,n,ind+1,1,cap,dp));
        }
        if(buy==1)//we can sell the stock
            profit=Math.max(0+getans(arr,n,ind+1,1,cap,dp),arr[ind]+getans(arr,n,ind+1,0,cap-1,dp));
     dp[ind][buy][cap]=profit;
     return profit;
    }
    static int maxProfit(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getans(prices, n, 0, 0, 2, dp);
    }

    //tabul
    static int maxProfit2(int []arr){
        int n=arr.length;
        int [][][]dp=new int[n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==0)
                        dp[ind][buy][cap]=Math.max(0+dp[ind+1][0][cap],-arr[ind]+dp[ind+1][1][cap]);
                    if(buy==1)
                        dp[ind][buy][cap]=Math.max(0+dp[ind+1][1][cap],arr[ind]+dp[ind+1][0][cap-1]);

                }
            }
        }
        return dp[0][0][2];
    }

    //space
    static int maxProfit3(int[] prices) {
        int n = prices.length;

        // Create a 2D array 'ahead' and 'cur' to store profit values
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

        // Loop through the prices array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        cur[buy][cap] = Math.max(0 + ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        cur[buy][cap] = Math.max(0 + ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }

            // Update 'ahead' with the values in 'cur'
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 3; j++) {
                    ahead[i][j] = cur[i][j];
                }
            }
        }

        // The maximum profit with 2 transactions is stored in ahead[0][2]
        return ahead[0][2];
    }
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + maxProfit(prices));
        System.out.println("The maximum profit that can be generated is " + maxProfit2(prices));
        System.out.println("The maximum profit that can be generated is " + maxProfit3(prices));

    }
}
