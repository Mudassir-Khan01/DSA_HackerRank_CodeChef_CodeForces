package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class MatrixEnergy {//inital energy 100 , start from first row and reach last row
                            // subtract energy of each cell u traverse (i+1,j-1), (i+1,j) or (i+1,j+1)
 public static int maxEnergyPath(List<List<Integer>> matrix){
     int n=matrix.size();
     int [][]dp=new int[n][n];

     for(int j=0;j<n;j++){
         dp[0][j]=100-matrix.get(0).get(j);
     }

     for(int i=1;i<n;i++){
         for(int j=0;j<n;j++){
             int maxEnergyPrev=Integer.MIN_VALUE;
             if(j>0)
             maxEnergyPrev=Math.max(maxEnergyPrev,dp[i-1][j-1]);

             maxEnergyPrev=Math.max(maxEnergyPrev,dp[i-1][j]);

             if(j<n-1)
                 maxEnergyPrev=Math.max(maxEnergyPrev,dp[i-1][j+1]);

             dp[i][j]=maxEnergyPrev-matrix.get(i).get(j);
         }

     }
     //now last row
     int max=Integer.MIN_VALUE;
     for(int j=0;j<n;j++){
         max=Math.max(max,dp[n-1][j]);
     }
     return max;

 }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(4, 2, 3, 4));
        matrix.add(List.of(2, 9, 8, 7));
        matrix.add(List.of(6, 3, 4, 5));
        matrix.add(List.of(1, 7, 5, 2));

        System.out.println("Maximum energy left: " + maxEnergyPath(matrix)); // Output will depend on the values in matrix
    }
}
