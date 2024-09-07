package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class _18EventualSafeStates
{
    private boolean dfscheck(int node, List<List<Integer>>adj,int vis[],int pathvis[],int check[]){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        //traverse the adjacent
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(dfscheck(i,adj,vis,pathvis,check)==true){
                    return true;
                }
            }else if(pathvis[i]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
    List<Integer> eventualSafeNodes(int v,List<List<Integer>>adj){
        int vis[]=new int[v];
        int pathvis[]=new int[v];
        int check[]=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfscheck(i,adj,vis,pathvis,check);
            }
        }
        List<Integer> safenodes=new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i]==1){//if no cycle then add that node which is part of it
                safenodes.add(i);
            }
        }
        return safenodes;
    }
    public static void main(String[] args) {
        int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        _18EventualSafeStates obj = new _18EventualSafeStates();
        List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
        for (int node : safeNodes) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
