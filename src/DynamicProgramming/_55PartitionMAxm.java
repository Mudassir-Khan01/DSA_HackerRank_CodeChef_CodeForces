package DynamicProgramming;

import java.util.Arrays;

public class _55PartitionMAxm {
    static int f(int ind,int []nums,int k){
        int n=nums.length;
        if(ind==n)
            return 0;

        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;

        for(int j=ind;j<Math.min(n,ind+k);j++){
            len++;
            maxi=Math.max(maxi,nums[j]);
            int sum=(maxi*len)+f(j+1,nums,k);
            maxAns=Math.max(maxAns,sum);
        }
        return maxAns;
    }
    static int maxSumAfterPartitioning(int[] num, int k) {
        return f(0, num, k);
    }

    //memoization
    static int f(int ind,int []nums,int k,int []dp){
        int n=nums.length;
        if(ind==n){
            return 0;
        }
        if(dp[ind]!=-1)
            return dp[ind];

        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;

        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for(int j=ind;j<Math.min(n,ind+k);j++){
            len++;
            maxi=Math.max(maxi,nums[j]);
            int ans=maxi*len+f(j+1,nums,k,dp);
            maxAns=Math.max(maxAns,ans);
        }
        return dp[ind]=maxAns;
    }
    static int maxSumAfterPartitioning2(int[] num, int k) {
        int n = num.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, num, k, dp);
    }

    //tabul

    static int maxSumAfterPartitioning3(int[] num, int k) {
        int n = num.length;
        int[] dp = new int[n + 1];

        // Traverse the input array from right to left
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;

            // Iterate through the next 'k' elements or remaining elements if less than 'k'.
            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, num[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] num = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int maxSum = maxSumAfterPartitioning(num, k);
        System.out.println("The maximum sum is: " + maxSum);
        int maxSum2 = maxSumAfterPartitioning2(num, k);

        System.out.println("The maximum sum is: " + maxSum2);

        System.out.println(maxSumAfterPartitioning3(num,k));


    }
}
