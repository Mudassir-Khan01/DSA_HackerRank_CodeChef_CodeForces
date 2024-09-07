package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _11Nearest1 {
 public int[][]nearest(int [][]grid){
     int n=grid.length;
     int m=grid[0].length;
     int vis[][]=new int[n][m];
     int dist[][]=new int[n][m];
     //queue has coordinates and the steps
     Queue<Nodee> q=new LinkedList<>();
     for(int i=0;i<n;i++){
         for (int j=0;j<m;j++){
             if(grid[i][j]==1){
                 q.add(new Nodee(i,j,0));
                 vis[i][j]=1;
             }
             else {
                 //just mark unvisited
                 vis[i][j]=0;
             }
         }
     }
     int delrow[] = {-1, 0, +1, 0};
     int delcol[] = {0, +1, 0, -1};
     while (!q.isEmpty()){
         int row=q.peek().first;
         int col=q.peek().second;
         int steps=q.peek().third;
         q.remove();
         dist[row][col]=steps;
         //for all 4 neighbours
         for(int i=0;i<4;i++){
             int nrow = row + delrow[i];
             int ncol = col + delcol[i];
             //check for valid unvisited cell
             if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0){
                 vis[nrow][ncol]=1;
                 q.add(new Nodee(nrow,ncol,steps+1));
             }
         }
     }
     return dist;
 }
    public static void main(String[] args)
    {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };

        _11Nearest1 obj = new _11Nearest1();
        int[][] ans = obj.nearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Nodee {
    int first;
    int second;
    int third;
    Nodee(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

