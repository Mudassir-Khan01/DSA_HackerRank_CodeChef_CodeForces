package Graph;

import java.util.*;

public class _25ShortestPath {
    private void toposort(int node , ArrayList<ArrayList<Pairr>> adj,int vis[],Stack<Integer> st){
        vis[node]=1;//just like dfs
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).first;
            if(vis[v]==0){
                toposort(v,adj,vis,st);
            }
        }
        st.add(node);
    }
    public int[] shortestPath(int N,int M,int [][]edges){
        ArrayList<ArrayList<Pairr>> adj=new ArrayList<>();
        for(int i=0;i<N;i++){//for nodes
            ArrayList<Pairr> temp=new ArrayList<>();
            adj.add(temp);
        }
        //we create a graph first in the form of an adjacency list
          for (int i=0;i<M;i++){//for edges
              int u=edges[i][0];//node
              int v=edges[i][1];//adjacent node
              int wt=edges[i][2];//distance from initial node
              adj.get(u).add(new Pairr(v,wt));
          }
          int vis[]=new int[N];
          //now we perform topo sort using dfs technique
        //and store the result in the statck st
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                toposort(i,adj,vis,st);
            }
        }
        //further we declare array dist in wihich we update the value of the node
        //distance from the source vertex after relaxation of a particular node
        int dis[]=new int[N];//relaxing the nodes
        for(int i=0;i<N;i++){
            dis[i]=(int )(1e9);
        }
        dis[0]=0;//make the distance of  source node 0
        while (!st.isEmpty()){
            int node=st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).first;//v is adjacent node
                int wt=adj.get(node).get(i).second;
                if (dis[node]+wt<dis[v]){
                    dis[v]=dis[node]+wt;
                }
            }
        }
        for(int i=0;i<N;i++){
            if(dis[i]==1e9) dis[i]=-1;
        }
        return dis;
    }
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        _25ShortestPath obj = new _25ShortestPath();
        int res[] = obj.shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

}
class Pairr {
    int first, second;
    Pairr(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
