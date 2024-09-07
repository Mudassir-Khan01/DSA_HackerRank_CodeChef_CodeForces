package DynamicProgramming;

import java.util.Arrays;

public class _6TotalUniquePath {
    //Memoization
    static int countWays(int i,int j,int[][]dp){
        //if we reach the starting cell theres, theres one way to reach it
        if (i==0&&j==0) return 1;

        //if we go out of the boundary, theres no way to reach it
        if(i<0||j<0)
            return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        //as we are going from the bottom most
        //sp calulate the no. of ways by moving up and moving left
        int up=countWays(i-1,j,dp);
        int left=countWays(i,j-1,dp);

        //store the result in the dp array
        return dp[i][j]=up+left;
    }


    //tabulation
    static int countways2(int m,int n,int [][]dp){
        //loop ythrough each cell in the grid and base condition is inside u may write it outside
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //base condition
                if(i==0&&j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0)
                    up=dp[i-1][j];
                if(j>0)
                    left=dp[i][j-1];

                //now store it
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }


    //space optimization
    static int countways3(int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = prev[j];//prev row and current col
                if (j > 0)
                    left = temp[j - 1];//current row and prev col

                // Store the total number of ways to reach the current cell in the temporary array
                temp[j] = up + left;
            }

            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];
    }

    static int count(int m,int n){
        int dp[][]=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        //recursion start from the bottom right cell m-1 n-1
        return countWays(m-1,n-1,dp);//memoiz

        //return countways2(m,n,dp); //tablu
    }
    public static void main(String args[]) {
        int m = 3;
        int n = 2;

        // Call the countWays function and print the result
        System.out.println(count(m, n));

        //space opt
        System.out.println(countways3(m, n));

    }
}
