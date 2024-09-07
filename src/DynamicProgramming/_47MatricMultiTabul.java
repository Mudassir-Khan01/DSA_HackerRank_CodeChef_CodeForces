package DynamicProgramming;

import java.util.Arrays;

public class _47MatricMultiTabul {
    static int matrixMultiplication(int []arr,int n){
        int dp[][]=new int[n][n];
        for(int rpw[]:dp)
            Arrays.fill(rpw,-1);

        for(int i=1;i<n;i++){
            dp[i][i]=0;
        }
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int min=Integer.MAX_VALUE;

                for(int k=i;k<=j-1;k++){
                    int operation=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    min=Math.min(min,operation);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;

        System.out.println("The minimum number of operations are " + matrixMultiplication(arr, n));
    }
}
