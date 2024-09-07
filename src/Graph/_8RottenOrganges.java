package Graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _8RottenOrganges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //if cell contains rotten oramge
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));//time starts from 0
                    vis[i][j] = 2;//mark it rotten in visited array
                } else {
                    vis[i][j] = 0;//if not rotten then initalize it to 0
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        int tm = 0;
        //delta row and col
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        int cnt = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm= Math.max(tm,t);
            q.remove();
            //exact 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                //now check for valid coordinates
                //then for unvisited fresh oranges grid mein fresh hai but visited nhi hai
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    //push in queue with time increased
                    q.add(new Pair(nrow, ncol, t + 1));
                    //mark it visited
                    vis[nrow][ncol] = 2;
                    cnt++;//this counter for keeping the track of fresh orange(1) which are neighbour
                }
            }
        }
        if (cnt != cntFresh) {
            return -1;//if any fresh orange is still there
        }
        return tm;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};

        _8RottenOrganges obj = new _8RottenOrganges();
        int ans = obj.orangesRotting(grid);
        System.out.println(ans);
    }
}
class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
    Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
