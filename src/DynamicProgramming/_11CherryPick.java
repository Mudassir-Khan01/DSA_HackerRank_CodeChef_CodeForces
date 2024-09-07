package DynamicProgramming;

import java.util.Arrays;

public class _11CherryPick {
    //memoization
    static int maxCherry(int i,int j1,int j2,int n ,int m,int [][]grid,int [][][]dp){
        //check j1 and j2 are valid
        if(j1<0||j1>=m||j2<0||j2>=m)
            return (int )Math.pow(-10,9);

        //if we reacg the last row
        if(i==n-1) {
            if (j1 == j2) {//if both reach at same cell add once
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }
            if(dp[i][j1][j2]!=-1)
                return dp[i][j1][j2];

            int maxi=Integer.MIN_VALUE;
            //iterate through all possible moves
            for(int di=-1 ;di<=1;di++){
                for (int dj=-1;dj<=1;dj++){
                    int ans;
                    if(j1==j2){
                        ans=grid[i][j1]+maxCherry(i+1,j1+di,j2+dj,n,m,grid,dp);
                    }else{
                        ans=grid[i][j1]+grid[i][j2]+maxCherry(i+1,j1+di,j2+dj,n,m,grid,dp);
                    }
                    maxi=Math.max(maxi,ans);
                }
            }
            return dp[i][j1][j2]=maxi;
        }
        static int maximum(int n,int m,int [][]grid){
        int dp[][][]=new int[n][m][m];
        //intialize the dp array with -1
            for(int row1[][]:dp){
                for(int row2[]:row1){
                    Arrays.fill(row2,-1);
                }
            }
            return maxCherry(0,0,m-1,n,m,grid,dp);
        }

        //tabulation
    static int maxCherry2(int n,int m,int[][]grid){
        //craete a 3d araay
        int dp[][][]=new int[n][m][m];
        //intiazlize the dp array with values from the last row the grid
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2)
                    dp[n-1][j1][j2]=grid[n-1][j1];
                else
                    dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        //outer nested loop to traverse the dp arrayfrom the second last row to the first row
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                int maxi=Integer.MIN_VALUE;
                //inner nested loop to try out 9 options
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int ans;
                        if (j1==j2)
                            ans=grid[i][j1];
                        else
                            ans=grid[i][j1]+grid[i][j2];

                        //check if the indices are valid or not
                        if((j1+di<0||j1+di>=m)||(j2+dj<0||j2+dj>=m))
                            ans+=(int) Math.pow(-10, 9);
                        else
                            ans+=dp[i+1][j1+di][j2+dj];

                        //update the maxi
                        maxi=Math.max(maxi,ans);
                    }
                }
                    //store the result
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }

    //space
    static int maximumChocolates(int n, int m, int[][] grid) {
        // Create two 2D arrays to store computed results: front and cur
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        // Initialize the front array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the cur array
                    cur[j1][j2] = maxi;
                }
            }

            // Update the front array with the values from the cur array for the next row
            for (int a = 0; a < m; a++) {
                front[a] = cur[a].clone();
            }
        }

        // The final result is stored at the top left corner of the front array
        return front[0][m - 1];
    }
    public static void main(String args[]) {
        int matrix[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;

        // Call the maximumChocolates function and print the result
        System.out.println(maximum(n, m, matrix));//memo

        System.out.println(maxCherry2(n, m, matrix));//tabul

        //space
        System.out.println(maximumChocolates(n, m, matrix));

    }
    }
