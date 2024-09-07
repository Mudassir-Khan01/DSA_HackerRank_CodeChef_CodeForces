package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _12SubsetTarget {
    static boolean subsetSum(int ind,int target,int [] arr,int [][]dp){
        //if target is achieved
        if(target==0)
            return true;

        if(ind==0)
            return arr[0]==target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        //try not taking the current element
        boolean nottake=subsetSum(ind-1,target,arr,dp);

        //try taking the current element
        boolean take=false;
        if(arr[ind]<=target)
        take=subsetSum(ind-1,target-arr[ind],arr,dp);

        //store the result
        dp[ind][target]= nottake||take?1:0;
        return nottake||take;//dono mein ek bhi true then its true
    }
    static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][k + 1];

        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return subsetSum(n - 1, k, arr, dp);
    }

    //tabulation
    static boolean subsetSum2(int n,int k,int []arr){
        boolean dp[][]=new boolean[n][k+1];
        //initalize the first row of the dp table
        for(int i=0;i<n;i++){
            dp[i][0]=true;//agar target is 0
        }
        //intialize the first col of the dop table
        if(arr[0]<=k){
            dp[0][arr[0]]=true;
        }
        //fill the dp table using bottom up approach
        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=k;target++){
                boolean nottak=dp[ind-1][target];

                boolean taken=false;
                if(arr[ind]<=target){
                    taken=dp[ind-1][target-arr[ind]];
                }
                //store the result
                dp[ind][target]=nottak||taken;
            }
        }
        return dp[n-1][k];
    }

    //space opti
    static boolean subsetSum3(int n,int k,int[]arr){
        boolean prev[]=new boolean[k+1];
        //initialie the first rown of the dp table
        prev[0]=true;

        if(arr[0]<=k){
            prev[arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++){
            boolean cur[]=new boolean[k+1];
            cur[0]=true;//just like prev
            for (int target=1;target<=k;target++){
                boolean nottaken=prev[target];
                boolean taken=false;
                if(arr[ind]<=target){
                    taken=prev[target-arr[ind]];
                }
                cur[target]=nottaken||taken;
            }
            prev=cur;
        }
        return prev[k];
    }
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        //tabul
        if (subsetSum2(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
   //space
        if (subsetSum3(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
