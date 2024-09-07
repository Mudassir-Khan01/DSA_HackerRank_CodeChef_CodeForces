package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class _10DetectCyDFS {
    private boolean dfs(int node, int parent , int vis[], ArrayList<ArrayList<Integer>>adj){
        vis[node]=1;
        //go to all the adjacent nodes
        for(Integer adjacentNOde:adj.get(node)){
            if(vis[adjacentNOde]==0) {
                if (dfs(adjacentNOde, node, vis, adj) == true)//if that recursion returns true a cycle is there
                    return true;
            }
                else if(adjacentNOde!=parent)
                    return true;//if adjacent node is visited but differet parent means a cycle is thereso return true
            }
            return false;
        }
        //fn to detect cycle in an undirected component graph
    public boolean isCycle(int v,ArrayList<ArrayList<Integer>>adj){
        int vis[]=new int[v];
        Arrays.fill(vis,0);
        for (int i=0;i<v;i++){
            if (vis[i]==0){
                if(dfs(i,-1,vis,adj)==true) return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(1).add(3);
        adj.get(3).add(1);

        _10DetectCyDFS obj = new _10DetectCyDFS();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

}



