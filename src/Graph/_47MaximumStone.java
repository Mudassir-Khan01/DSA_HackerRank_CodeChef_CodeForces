package Graph;

import java.util.HashMap;
import java.util.Map;

public class _47MaximumStone {
    int maxRemove(int [][]stones,int n) {
        int maxrow =0;// where the last stone in the row and column this will also give us the dimension of the grid
        int maxcol=0;
        for (int i=0;i<n;i++){
            maxrow=Math.max(maxrow,stones[i][0]);
            maxcol=Math.max(maxcol,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(maxrow+maxcol+1);
        HashMap<Integer,Integer> stoneNodes=new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow=stones[i][0];// row and col as nodes and col staring after col
            int nodeCol=stones[i][1]+maxrow+1;
            ds.unionBySize(nodeRow,nodeCol);
            stoneNodes.put(nodeRow,1);
            stoneNodes.put(nodeCol,1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer>it:stoneNodes.entrySet()){
            if(ds.findUPar(it.getKey())== it.getKey()){//if ultimate parent is node itself then its the boss so count ++
             count++;
            }
        }
        return n-count;
    }
    public static void main (String[] args) {
        int n = 6;
        int[][] stones = {
                {0, 0}, {0, 2},
                {1, 3}, {3, 1},
                {3, 2}, {4, 3}
        };

        _47MaximumStone obj = new _47MaximumStone();
        int ans = obj.maxRemove(stones, n);
        System.out.println("The maximum number of stones we can remove is: " + ans);
    }
}
