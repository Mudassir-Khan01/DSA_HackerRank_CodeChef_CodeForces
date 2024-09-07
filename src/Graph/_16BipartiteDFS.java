package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class _16BipartiteDFS {
    private boolean dfs(int node, int colo, int color[], ArrayList<ArrayList<Integer>>adj){
        color[node]=colo;
        //traverse adjacent node
        for(int i:adj.get(node)){
            if(color[i]==-1){
                if(dfs(i,1-colo,color,adj)==false){
                    return false;
                }
                //if previously coloured and have the same colour
            }else if(color[i]==colo){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int v,ArrayList<ArrayList<Integer>>adj){
        int color[]=new int[v];
        Arrays.fill(color,-1);
        //for connected component
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        // V = 3, E = 2
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 3; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(0);
        adj.get(0).add(2);

        _16BipartiteDFS obj = new _16BipartiteDFS();
        boolean ans = obj.isBipartite(3, adj);
        if(ans)
            System.out.println("yeah it is bipartite");
        else System.out.println("Not bipartite");
    }
}
