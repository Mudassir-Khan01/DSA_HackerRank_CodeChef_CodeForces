package DynamicProgramming;

import java.util.Arrays;

public class _46MatrixMulti {

    //normal recursion
    static int f(int []arr,int i,int j){
        if(i==j)
            return 0;//base case

        int mini=Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int ans=f(arr,i,k)+f(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            mini=Math.min(mini,ans);
        }
        return mini;
    }
    static int matrixMultiplication(int[] arr, int N){

        int i =1;
        int j = N-1;


        return f(arr,i,j);
    }

    //Memoization
    static int f2(int []arr,int i,int j,int [][]dp){
        if(i==j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int mini=Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int ans=f(arr,i,k)+f(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            mini=Math.min(mini,ans);
        }
        return mini;
    }
    static int matrixMultiplication2(int[] arr, int N){

        int dp[][]= new int[N][N];

        for(int row[]:dp)
            Arrays.fill(row,-1);

        int i =1;
        int j = N-1;


        return f2(arr,i,j,dp);


    }
    public static void main(String args[]) {

        int arr[] = {10, 20, 30, 40, 50};

        int n = arr.length;

        System.out.println("The minimum number of operations are "+
                matrixMultiplication(arr,n));
        System.out.println("The minimum number of operations are "+
                matrixMultiplication2(arr,n));
    }
}
