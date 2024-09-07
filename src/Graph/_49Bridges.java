package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _49Bridges {
    private int timer=1;
    public List<List<Integer>> criticalConnections(int n,List<List<Integer>> connections){
       //first of all creating graph
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it:connections){
            int u=it.get(0);
            int v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] vis=new int[n];
        int []tin=new int[n];
        int []low=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,bridges);
        return bridges;
    }
    private void dfs(int node,int parent,int []vis,ArrayList<ArrayList<Integer>> adj,int []tin,int [] low,List<List<Integer>> bridges){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(Integer adjnode:adj.get(node)){
            if(adjnode==parent){
                continue;//if its a parent just skip it
            }
            if(vis[adjnode]==0){//if not visited call the dfs traversal
                dfs(adjnode,node,vis,adj,tin,low,bridges);
                low[node]=Math.min(low[node],low[adjnode]);//here we reach the last element and setting is low
                //now check for bridges
                if(low[adjnode]>tin[node]){//if adjnode low is greater then the arrival time of node means u cant reach the adjnode
                    bridges.add(Arrays.asList(adjnode,node));
                }
            }else {//if its visited then simply set the low of node // like in case of reaching nine and 6 was already visited so we changed the low to node to min
                low[node]=Math.min(low[node],low[adjnode]);
            }

        }
    }
    public static void main (String[] args) {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2},
                {2, 0}, {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }

        _49Bridges obj = new _49Bridges();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);

        int size = bridges.size();
        for (int i = 0; i < size; i++) {
            int u = bridges.get(i).get(0);
            int v = bridges.get(i).get(1);
            System.out.print("[" + u + ", " + v + "] ");
        }
        System.out.println("");
    }
}
