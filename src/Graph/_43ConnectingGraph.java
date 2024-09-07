package Graph;

public class _43ConnectingGraph {
    public int Solve(int n,int [][]edges){
        DisjointSet ds=new DisjointSet(n);
        int countExtra=0;
        int m=edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(ds.findUPar(u)==ds.findUPar(v)){//if same parent means there an extra edge
                countExtra++;
            }else {
                ds.unionBySize(u,v);
            }
        }
        int countC=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                countC++;
            }
        }
        int ans=countC-1;//minimum edges required
        if(countExtra>=ans){
            return ans;
        }
        return -1;
    }
    public static void main (String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        _43ConnectingGraph obj = new _43ConnectingGraph();
        int ans = obj.Solve(V, edge);
        System.out.println("The number of operations needed: " + ans);

    }
}
