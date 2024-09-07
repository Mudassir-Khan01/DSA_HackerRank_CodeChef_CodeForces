package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _31BinaryMaze {
  public int shortestPath(int [][]grid,int []source,int destination[]){
      if(source[0]==destination[0]&&source[1]==destination[1]){
          return 0;
      }
      Queue<Tupleee> q=new LinkedList<>();
      int n=grid.length;
      int m=grid[0].length;
      int [][]dist=new int[n][m];
      for(int i=0;i<n;i++){
          for (int j=0;j<m;j++){
              dist[i][j]=(int)(1e9);
          }
      }
      dist[source[0]][source[1]]=0;
      q.add(new Tupleee(0,source[0],source[1]));
      //for 4 direction as we need to get its 4 neighbours
      int dr[]={-1,0,1,0};
      int dc[]={0,1,0,-1};
      //iterate through the maze by popping the elements out of the queue
      //and each index represents each adjacent node that a cell may have
      //in a direction
      while (!q.isEmpty()){
        Tupleee it=q.peek();
        q.remove();
        int dis=it.first;
        int r=it.second;
        int c=it.third;
        //for traversing its neighbours
          for(int i=0;i<4;i++){
              int newr=r+dr[i];
              int newc=c+dc[i];
              if(newr>=0&&newr<n&&newc>=0&&newc<m&&grid[newr][newc]==1&&dis+1<dist[newr][newc]){
                  dist[newr][newc]=1+dis;
                  //return the distance util the point when
                  //we encounter the destination cell
                  if(newr==destination[0]&&newc==destination[1]) {
                      return dis + 1;
                  }
                  q.add(new Tupleee(1+dis,newr,newc));
              }
          }
      }
      //if no path is found from source to destination
      return -1;
  }
    public static void main(String[] args) {

        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};

        _31BinaryMaze obj = new _31BinaryMaze();
        int res = obj.shortestPath(grid, source, destination);

        System.out.print(res);
        System.out.println();
    }
}
 class Tupleee {
    int first,second,third;
    Tupleee(int first, int second , int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
