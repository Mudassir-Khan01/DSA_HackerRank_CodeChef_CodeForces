package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _38PrimsAlgo {
   static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>>adj){
       PriorityQueue<Prims> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
       int[]vis=new int[v];
       pq.add(new Prims(0,0));
       int sum=0;
       while (pq.size()>0){
           int wt=pq.peek().distance;
           int node=pq.peek().node;
           pq.remove();
           if(vis[node]==1){
               continue;//skip it if visited
           }
           //else add it to the mst
           vis[node]=1;
           sum=sum+wt;
           //now for adjacent node
           for (int i=0;i<adj.get(node).size();i++){
               int edw=adj.get(node).get(i).get(1);
               int adjnode=adj.get(node).get(i).get(0);
               if(vis[adjnode]==0){//if unvisited
                   pq.add(new Prims(edw,adjnode));
               }
           }
       }
       return sum;
   }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        _38PrimsAlgo obj = new _38PrimsAlgo();
        int sum = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
}
class Prims{
    int node;
    int distance;
    public Prims(int distance,int node){
        this.distance=distance;
        this.node=node;
    }
}
