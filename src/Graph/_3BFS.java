package Graph;

import java.util.*;

public class _3BFS {
    //fn to return bfs traversal of a given graph
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        vis[0]=true;
        while (!queue.isEmpty()){
            Integer node =queue.poll();
            bfs.add(node);
            //Get all adjcent vertices of the dequeued vertex
            //if a adjacent id not visited ,then mark it
            //visited and enqueue it
            for (Integer it:adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    queue.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        _3BFS sl = new _3BFS();
        ArrayList < Integer > ans = sl.bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
