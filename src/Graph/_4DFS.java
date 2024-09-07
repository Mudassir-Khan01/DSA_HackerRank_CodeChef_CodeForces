package Graph;
import java.util.*;
public class _4DFS {
    public static void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ls){
        //marking current node as visited
        vis[node]=true;
        ls.add(node);
        //getting neighbour nodes
        for (Integer i:adj.get(node)){
            if(vis[i]==false){
                dfs(i,vis,adj,ls);
            }
        }
    }
    //function to return a list containing the Dfs traversal of the
    public ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>>adj){
        //boolean array to keep the track of the visited vertices
        boolean vis[]=new boolean[V+1];
        vis[0]=true;
        ArrayList<Integer>ls=new ArrayList<>();
        dfs(0,vis,adj,ls);
        return ls;
    }
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<5;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        _4DFS obj=new _4DFS();
        ArrayList<Integer> ans=obj.dfsOfGraph(5,adj);
        int n=ans.size();
        for(int i=0;i<n;i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
