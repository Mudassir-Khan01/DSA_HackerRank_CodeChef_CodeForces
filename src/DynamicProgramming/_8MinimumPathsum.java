package DynamicProgramming;

import java.util.Arrays;

public class _8MinimumPathsum {

    //memoization
    static int minsumPAth(int i,int j,int[][]matrix,int [][]dp){
        //base cases
        if(i==0&&j==0)
            return matrix[i][j];
        if(i<0||j<0)
            return (int)Math.pow(10,9);
        if(dp[i][j]!=-1)
            return dp[i][j];

        int up=matrix[i][j]+minsumPAth(i-1,j,matrix,dp);
        int left=matrix[i][j]+minsumPAth(i,j-1,matrix,dp);

        return dp[i][j]=Math.min(up,left);
    }
    static int minSumPath(int n, int m, int[][] matrix) {
        int dp[][] = new int[n][m];

        // Initialize the DP matrix with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the helper function starting from the bottom-right cell
        return minsumPAth(n - 1, m - 1, matrix, dp);
    }

    //tabulation
    static int minsum2(int n,int m,int matrix[][]){
        int dp[][]=new int[n][m];
        //itertate
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0){
                    dp[i][j]=matrix[i][j];
                }else {
                    int up=matrix[i][j];
                    if(i>0) {
                        up += dp[i - 1][j];
                    }
                    else {
                        up += (int) Math.pow(10, 9);
                    }
                    int left=matrix[i][j];
                    if(j>0) {
                        left += dp[i][j - 1];
                    }
                    else {
                        left+=(int)Math.pow(10,9);
                    }
                    dp[i][j]=Math.min(up,left);
                }
            }

        }
        return dp[n-1][m-1];
    }

    //space optimze
    static int minSum3(int n,int m,int [][]matrix){
        int prev[]=new int [m];//initazlize an array to store the previous row value
        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0&&j==0) {
                    temp[j] = matrix[i][j];
                }else {
                    int up=matrix[i][j];
                    if(i>0){
                        up+=prev[j];
                    }else {
                        up+=(int)Math.pow(10,9);
                    }
                    int left=matrix[i][j];
                    if(j>0){
                        left+=temp[j-1];
                    }else {
                        left+=(int)Math.pow(10,9);
                    }
                    temp[j]=Math.min(up,left);
                }
            }
            prev=temp;

        }
        return prev[m-1];
    }
    public static void main(String args[]) {
        // Define the matrix
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        // Calculate and print the minimum sum path in the matrix
        System.out.println(minSumPath(n, m, matrix));//memo
        System.out.println(minsum2(n, m, matrix));//tabul
        System.out.println(minSum3(n, m, matrix));

    }
}
