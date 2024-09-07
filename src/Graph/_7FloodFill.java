package Graph;

public class _7FloodFill {
    public int[][] floodfill(int[][] image, int sr, int sc, int newColor) {
        //get initial color
        int inicolor = image[sr][sc];
        int[][] ans = image;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        dfs(sr, sc, ans, image, newColor, delrow, delcol, inicolor);
        return ans;
    }

    private void dfs(int row, int col, int[][] ans, int[][] image, int newcolor, int delRow[], int delcol[], int inicolor) {
        //color with newcolor
        ans[row][col] = newcolor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {//4 directions we have to take
            int nrow = row + delRow[i];
            int ncol = col + delcol[i];
            //check for valid coordinate
            //then check for same initial color and unvisited pixel
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == inicolor && ans[nrow][ncol] != newcolor) {
                dfs(nrow, ncol, ans, image, newcolor, delRow, delcol, inicolor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        // sr = 1, sc = 1, newColor = 2
        _7FloodFill obj = new _7FloodFill();
        int[][] ans = obj.floodfill(image, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
