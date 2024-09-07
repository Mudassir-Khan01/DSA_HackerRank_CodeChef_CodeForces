package Graph;

import java.util.*;

public class _5NoOfProvince {
    //dfs traversal
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs,int vis[]){
        vis[node]=1;
        for (Integer i:adjLs.get(node)){
            if(vis[i]==0){
                dfs(i,adjLs,vis);
            }
        }
    }
    static int numProvince(int [][]adj,int V){
        ArrayList<ArrayList<Integer>> adjLs=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adjLs.add(new ArrayList<>());
        }
        //to change adjacency matrix to adjacency list
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                //self nodes are not considered
                if(adj[i][j]==1&&i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        //now for provinces
        int vis[]=new int[V];
        int count=0;
        for (int i=0;i<V;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adjLs,vis);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n=8,m=5;
        int adj[][]=new int[n+1][n+1];
        //edge 1--2
        adj[1][2]=1;
        adj[2][1]=1;
        //similarly for all
        adj[2][3]=1;
        adj[3][2]=1;
        adj[4][5]=1;
        adj[5][4]=1;
        adj[5][6]=1;
        adj[6][5]=1;
        adj[7][8]=1;
        adj[8][7]=1;
        _5NoOfProvince obj=new _5NoOfProvince();
        System.out.println(numProvince(adj,8)-1);
    }
}
