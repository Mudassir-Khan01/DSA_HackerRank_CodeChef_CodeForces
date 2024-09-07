package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _10MinMaxFallingPathSum {
    //memoization
    static int getMax(int i,int j,int m,int [][]matrix,int [][]dp){

        if(j<0||j>=m)
            return (int )Math.pow(-10,9);//incorrevt path so return a very small value
        if(i==0)
            return matrix[0][j];//reaches the top but ans can be in any col

        if(dp[i][j]!=-1)
            return dp[i][j];

        int up=matrix[i][j]+getMax(i-1,j,m,matrix,dp);
        int leftDig=matrix[i][j]+getMax(i-1,j-1,m,matrix,dp);
        int rightDig=matrix[i][j]+getMax(i-1,j+1,m,matrix,dp);

        return dp[i][j]=Math.max(up,Math.max(leftDig,rightDig));
    }
    static int getMaxPathSum(int [][]matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int [][]dp=new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        int maxi=Integer.MIN_VALUE;
        //for each starting col, find the maximum path sum and update maxi
        for(int j=0;j<m;j++){
            int ans=getMax(n-1,j,m,matrix,dp);
            maxi=Math.max(maxi,ans);
        }
        return maxi;
    }

    //tabulation
    static int getMax2(int [][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        //itialize the first row - base condition
        for(int j=0;j<m;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){//first row initalized thats y startingfrom 1
            for(int j=0;j<m;j++){
                int up=matrix[i][j]+dp[i-1][j];
                int leftdiag=matrix[i][j];
                if(j-1>=0){//should not be -ve
                    leftdiag+=dp[i-1][j-1];
                }else {
                    leftdiag+=(int) Math.pow(-10, 9);
                }
                int rightdiag=matrix[i][j];
                if(j+1<m){//should not exceed
                    rightdiag+=dp[i-1][j+1];
                }else {
                    rightdiag+=(int) Math.pow(-10, 9);
                }
                dp[i][j]=Math.max(up,Math.max(leftdiag,rightdiag));
            }
        }
        //now u have to go through all the col of starting
        int maxi=Integer.MIN_VALUE;
        for(int j=0;j<m;j++){
            maxi=Math.max(maxi,dp[n-1][j]);
        }
        return maxi;
    }

    //space optimization
    static int getMax3(List<List<Integer>> matrix){
        int n=matrix.size();
        int m=matrix.get(0).size();

        List<Integer> prev=new ArrayList<>(Collections.nCopies(m,0));
        List<Integer> cur=new ArrayList<>(Collections.nCopies(m,0));
        //initialize the first row - base condition
        for(int j=0;j<m;j++){
            prev.set(j,matrix.get(0).get(j));
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=matrix.get(i).get(j)+prev.get(j);
                int leftdig=matrix.get(i).get(j);
                if(j-1>=0){
                    leftdig+=prev.get(j-1);
                }else {
                    leftdig+=-1e9;
                }
                int rightdig=matrix.get(i).get(j);
                if(j+1<m){
                    rightdig+=prev.get(j+1);
                }else {
                    rightdig+=-1e9;
                }
                cur.set(j,Math.max(up,Math.max(leftdig,rightdig)));
            }
            prev=new ArrayList<>(cur);
        }
        int maxi=Integer.MIN_VALUE;
        for(int j=0;j<m;j++){
            maxi=Math.max(maxi,prev.get(j));
        }
        return maxi;
    }
    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};

        // Call the getMaxPathSum function and print the result
        System.out.println(getMaxPathSum(matrix));//memo

        System.out.println(getMax2(matrix));//tabul

        //space
        List<List<Integer>> matrixx = new ArrayList<>();
        matrixx.add(Arrays.asList(1, 2, 10, 4));
        matrixx.add(Arrays.asList(100, 3, 2, 1));
        matrixx.add(Arrays.asList(1, 1, 20, 2));
        matrixx.add(Arrays.asList(1, 2, 2, 1));

        // Call the getMaxPathSum function and print the result
        System.out.println(getMax3(matrixx));

    }
}
