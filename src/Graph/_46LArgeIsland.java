package Graph;

import java.util.HashSet;

public class _46LArgeIsland {
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }

    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        //step 1
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;//0 means we dont need to connect it
                //now traversing its 4 direction
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    //if its valid and 1 is there we need to connectb it
                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        //step 2
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;//we cant convert it if its a 1
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {//current is 0 and adjnode is 1 then add it
                            components.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);//overall size 1 is for that one chenging from 0 to 1
            }
        }
        for (int cellno = 0; cellno < n * n; cellno++) {//if all are 1 no 0 is there
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellno)));
        }
        return mx;
    }
    public static void main (String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

        _46LArgeIsland obj = new _46LArgeIsland();
        int ans = obj.MaxConnection(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }
}
