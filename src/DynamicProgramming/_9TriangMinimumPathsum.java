package DynamicProgramming;

import java.util.Arrays;

public class _9TriangMinimumPathsum {

    //memoization
    static int minimPath(int i,int j,int [][] triangle,int n ,int [][]dp){
        if(dp[i][j]!=-1) return dp[i][j];

        if(i==n-1)//n is row
            return triangle[i][j];

        int down=triangle[i][j]+minimPath(i+1,j,triangle,n,dp);
        int diagonal=triangle[i][j]+minimPath(i+1,j+1,triangle,n,dp);

        return dp[i][j]=Math.min(down,diagonal);
    }
    static int minimumPathSum(int[][] triangle, int n) {
        // Create a 2D array to store computed results, initialize with -1
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the utility function to find the minimum path sum starting from the top
        return minimPath(0, 0, triangle, n, dp);
    }

    //tabulation
    static int minimumPath2(int [][]triangle,int n){
        int dp[][]=new int[n][n];
        //itialize the bottom row of the dp with the values from the bottom row of the traingle
        for(int j=0;j<n;j++){//base case
            dp[n-1][j]=triangle[n-1][j];
        }
        //start from the second to last row
        for(int i=n-2;i>=0;i--){//bottom up so start from second last
            for(int j=i;j>=0;j--){
                int down=triangle[i][j]+dp[i+1][j];
                int diagonal=triangle[i][j]+dp[i+1][j+1];

                dp[i][j]=Math.min(down,diagonal);
            }
        }
        return dp[0][0];//ans will be stored at up so 0,0
    }

    //space opti
    static int minimumpath3(int [][]triangle,int n){
        //create 2 array
        //front for storing result for the current row
        //cur for result for the next row
        int front[]=new int[n];
        int cur[]=new int[n];
        //itialize the front array with the values from the bottom row
        for(int j=0;j<n;j++){
            front[j]=triangle[n-1][j];
        }
        //start from the second last row
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down=triangle[i][j]+front[j];
                int diagonal=triangle[i][j]+front[j+1];

                cur[j]=Math.min(down,diagonal);
            }
            front=cur.clone();//update front with the cur ie current with the next
        }
        return front[0];
    }
    public static void main(String args[]) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int n = triangle.length;

        // Call the minimumPathSum function and print the result
        System.out.println(minimumPathSum(triangle, n));//memo

        System.out.println(minimumPath2(triangle, n));//tabul

        //space
        System.out.println(minimumpath3(triangle, n));
    }
}
