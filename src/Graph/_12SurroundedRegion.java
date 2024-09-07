package Graph;

public class _12SurroundedRegion {
    static char[][] fill(int n,int m,char mat[][]){
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};
        int vis[][]=new int[n][m];
        //traverse first row and last row
        for(int j=0;j<m;j++){
            if(vis[0][j]==0&&mat[0][j]=='O'){
                dfs(0,j,vis,mat,delrow,delcol);
            }
            if(vis[n-1][j]==0&&mat[n-1][j]=='O'){
                dfs(n-1,j,vis,mat,delrow,delcol);
            }
        }
        //now for first and last col
        for(int i=0;i<n;i++){
            if(vis[i][0]==0&&mat[i][0]=='O'){
                dfs(i,0,vis,mat,delrow,delcol);
            }
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, delrow, delcol);
            }
        }
        //if unvisited O then convert to X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&mat[i][j]=='O'){
                    mat[i][j]='X';
                }
            }
        }
        return mat;
    }
    static void dfs(int row,int col,int [][]vis,char[][]mat,int delrow[],int delcol[]){
        vis[row][col]=1;
        int n=mat.length;
        int m=mat[0].length;
        //check for top right bottom left
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
          if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&mat[nrow][ncol]=='O'){
              dfs(nrow,ncol,vis,mat,delrow,delcol);
          }
        }
    }
    public static void main(String[] args)
    {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4
        _12SurroundedRegion ob = new _12SurroundedRegion();
        char[][] ans = ob.fill(5, 4, mat);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
