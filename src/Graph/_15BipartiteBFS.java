package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _15BipartiteBFS {
    private boolean check(int start, int v, ArrayList<ArrayList<Integer>>adj,int color[]){
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        while (!q.isEmpty()){
            int node=q.peek();
            q.remove();
            //now traverse its adjacent node
            for(int i:adj.get(node)){
                //if the adjacent node is yet not coloured u will give the opp color of the node
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.add(i);
                }
                //if the adjacent guy having the same color
                //someone did color it on some other path
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    //this is for graph with componment
    public boolean isBipartite(int v,ArrayList<ArrayList<Integer>>adj){
        int color[]=new int[v];
        Arrays.fill(color,-1);

        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(check(i,v,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        _15BipartiteBFS obj = new _15BipartiteBFS();
        boolean ans = obj.isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }
}
