package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class _17DetectCyDirectedDFS {
    private boolean dfsCheck(int node , ArrayList<ArrayList<Integer>>adj,int vis[],int pathvis[]){
        vis[node]=1;
        pathvis[node]=1;
        //traverse for adjacent node
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(dfsCheck(i,adj,vis,pathvis)==true){
                    return true;
                }
            }
            //if the ndoe has been previously visited,
            //but it has to be visited on the same path
            else if (pathvis[i]==1){//visited and path visited both then cycle is there
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
    //fn to detect cycle in a directed graph(component)
    public boolean isCyclic(int v,ArrayList<ArrayList<Integer>>adj){
        int vis[]=new int[v];
        int pathvis[]=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(dfsCheck(i,adj,vis,pathvis)==true){
                    return true;
                }
            }
        }
             return false;
    }
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        _17DetectCyDirectedDFS obj = new _17DetectCyDirectedDFS();
        boolean ans = obj.isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }
}
