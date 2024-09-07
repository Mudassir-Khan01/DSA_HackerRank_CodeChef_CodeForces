package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class _50ArticulationPoint {
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>>adj){
        int vis[]=new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];//mark which are articulation points
        for(int i=0;i<n;i++) {
            if(vis[i]==0){
                dfs(i,-1,vis,tin,low,mark,adj);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
    private int timer=-1;
    private void dfs(int node,int parent,int []vis,int tin[], int low[], int[] mark, ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        int child=0;//this is for the starting node if it has many childer then it is the articulation point
        for(Integer adjNode:adj.get(node)){
            if(adjNode==parent){//apart from parent
                continue;
            }
            if(vis[adjNode]==0){
                dfs(adjNode,node,vis,tin,low,mark,adj);
                //now reached the last node
                low[node]=Math.min(low[node],low[adjNode]);
                //for articulation point
                if(low[adjNode]>=tin[node]&&parent!=-1){
                    mark[node]=1;//mark it
                }
                child++;
            }else{//if visited
                low[node]=Math.min(low[node],tin[adjNode]);//here compare low of node to ythe time of insertion of adjacent node
            }
        }
        if(child>1&&parent==-1){//
            mark[node]=1;
        }
    }
    public static void main (String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 4},
                {2, 4}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        _50ArticulationPoint obj = new _50ArticulationPoint();
        ArrayList<Integer> nodes = obj.articulationPoints(n, adj);

        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            int node = nodes.get(i);
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
