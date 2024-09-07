package DynamicProgramming;

import java.util.Arrays;

public class _34BestBuySell2 {
    static int  getMaximum(int[]arr,int ind,int buy,int n,int [][]dp){
        //base case
        if(ind==n)
            return 0;
        
        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        
        int profit = 0;
        if(buy==0){//0 means not yey bought
            profit=Math.max(0+getMaximum(arr,ind+1,0,n,dp),-arr[ind]+getMaximum(arr,ind+1,1,n,dp));
        }
        if(buy==1){//we can sell the stock
            profit=Math.max(0+getMaximum(arr,ind+1,1,n,dp),arr[ind]+getMaximum(arr,ind+1,0,n,dp));
            
        }
return profit;
    }
    static int get(int[]arr,int n){
        int [][]dp=new int[n][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        if(n==0)
            return 0;

       int  ans=getMaximum(arr,0,0,n,dp);
       return ans;

    }

    //tabul
    static int getmaximum2(int []arr,int n){
        int [][]dp=new int[n+1][2];
        //initalize the entire dp table with -1
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        //base condition if we have no stocks to buy or sell,profit is 0
        dp[n][0]=dp[n][1]=0;

        int profit=0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy==0){
                    profit=Math.max(0+dp[ind+1][0],-arr[ind]+dp[ind+1][1]);
                }
                if(buy==1){
                    profit = Math.max(0 + dp[ind + 1][1], arr[ind] + dp[ind + 1][0]);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][0];
    }

    //space
    static int getMaximumProfit(int[] Arr, int n) {
        // Create arrays 'ahead' and 'cur' to store the maximum profit ahead and current profit
        int[] ahead = new int[2];
        int[] cur = new int[2];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        ahead[0] = ahead[1] = 0;

        int profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' array with the current profit values
            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0]; // The maximum profit is stored in 'cur[0]'
    }

    public static void main(String[] args) {
        int n=6;
        int []arr={7,1,5,3,6,4};
        System.out.println(get(arr,n));
        System.out.println(getmaximum2(arr,n));

        System.out.println("The maximum profit that can be generated is " + getMaximumProfit(arr, n));

    }
}
