package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _9DetectCyBFS {
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj,int s,boolean vis[],int parent[]){
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(s,-1));//consider the parent of starting node is -1
        vis[s]=true;
        while (!q.isEmpty()){
            int node=q.peek().first;
            int par=q.peek().second;
            q.remove();
            //go to all the adjacent nodes
            for(Integer i:adj.get(node)){
                if(vis[i]==false){
                    q.add(new Node(i,node));
                    vis[i]=true;
                }
                //if adjacent node is visited and is not its own parent
                else if(par!=i)
                    return true;
            }
        }
        return false;
    }
    //fn to detect cycle in an undirected component graph means many part of graph are there
    public boolean isCycle(int v,ArrayList<ArrayList<Integer>>adj){
        boolean vis[]=new boolean[v];
        Arrays.fill(vis,false);
        int parent[]=new int[v];
        Arrays.fill(parent,-1);
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                if(checkForCycle(adj,i,vis,parent)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        _9DetectCyBFS obj = new _9DetectCyBFS();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
