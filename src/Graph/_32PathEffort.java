package Graph;

import java.util.*;

public class _32PathEffort {
  int MinimumEffort(int height[][]){
      //create a priority queue containing pairs of cells
      //and their respective distance from the source cell in the
      //form {diff,{row of the cell,col of the cell}}
      PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>((x,y)->x.distance-y.distance);
      int n=height.length;
      int m=height[0].length;
      //create a distance matrix with initially all the cells marked as
      int [][] dist=new int[n][m];
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              dist[i][j]=(int)1e9;
          }
      }
      dist[0][0]=0;
      pq.add(new Tuple(0,0,0));
      int dr[]={-1,0,1,0};
      int dc[]={0,1,0,-1};

      while (!pq.isEmpty()){
          Tuple it=pq.peek();
          pq.remove();
          int diff=it.distance;
          int row=it.row;
          int col=it.col;
          //check if we have reached the destination cell
          //return the current value of the difference (which will be minimum).
          if(row==n-1&&col==m-1){
              return diff;
          }
          for(int i=0;i<4;i++){
              int newr=row+dr[i];
              int newc=col+dc[i];
              //check the validity of the cell
              if(newr>=0 && newc >=0 && newr < n && newc < m){
                  //effort can be calculated as the max value of the differences
                  //between the heights of the node and its adjacent nodes
                  int newEffort=Math.max(Math.abs(height[row][col]-height[newr][newc]),diff);
                  // if the calculated effort is less than the prev value
                  //we update as we need the min effort
                  if(newEffort<dist[newr][newc]){
                      dist[newr][newc]=newEffort;
                      pq.add(new Tuple(newEffort,newr,newc));
                  }
              }
          }
      }
      //if the destination is unreachable return 0
      return 0;
  }
    public static void main(String[] args) {

        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        _32PathEffort obj = new _32PathEffort();
        int ans = obj.MinimumEffort(heights);

        System.out.print(ans);
        System.out.println();
    }
}
class Tuple{
    int distance,row,col;
    public Tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
