package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _6Island {
    int first;
    int second;
    public _6Island(){}
    public _6Island(int first,int second){
        this.first=first;
        this.second=second;
    }
    public int numIsland(char[][]grid){
        //fn to find no. of islands
        int n=grid.length;//row
        int m=grid[0].length;//col
        int [][]vis=new int[n][m];
        int count=0;
        for(int row=0;row<n;row++){
            for (int col=0;col<m;col++){
                if(vis[row][col]==0&&grid[row][col]=='1'){
                    count++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return count;
    }
    private void bfs(int ro,int co,int[][]vis,char[][]grid){
        vis[ro][co]=1;
        Queue<_6Island> q=new LinkedList<_6Island>();
        q.add(new _6Island(ro,co));
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().first;//to get the row of first inserted (ro,co)
            int col=q.peek().second;
            q.remove();
            //traverse in the neighbours and mark them if its a land
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow=row+delrow;
                    int ncol=col+delcol;
                    //check if neighbours row and col is valid and is unvisted
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m && grid[nrow][ncol]=='1'&&vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new _6Island(nrow,ncol));
                    }
                }
            }
        }
    }
    public static void main(String[] args)
    {
        char[][] grid =  {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };

        _6Island obj = new _6Island();
        System.out.println(obj.numIsland(grid));
    }
}
