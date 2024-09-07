package Graph;

import java.util.ArrayList;
import java.util.List;

public class _45Island2 {
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (vis[row][col] == 1) {//if already visited no change in count
                ans.add(count);//ie if its already an island
                continue;
            }
            //if no visited
            vis[row][col] = 1;
            count++;
            //now for adjacent neighbour
            int dr[] = {-1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                if (isVaild(adjr,adjc,n,m)){
                    if(vis[adjr][adjc]==1){//to check whethere the adjacent cell is island or not if yes then we need to connect it
                        int nodeNo=row*m+col;
                        int adjNodeNo=adjr*m+adjc;
                        if(ds.findUPar(nodeNo)!= ds.findUPar(adjNodeNo)){//their parents not equals
                            count--;//they are connecting so --
                            ds.unionBySize(nodeNo,adjNodeNo);//and connect it
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;

    }
    private boolean isVaild(int adjr,int adjc,int n,int m){
        return adjr>=0&&adjc>=0&&adjr<n&&adjc<m;
    }
    public static void main (String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        _45Island2 obj = new _45Island2();
        List<Integer> ans = obj.numOfIslands(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }
}
