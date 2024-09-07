package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _22PreRequisite {
    public boolean isPossible(int v,int [][]prerequisites){
        //form a graph
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());

        }
        int m=prerequisites.length;
        for (int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer>topo=new ArrayList<>();
        while (!q.isEmpty()){
            int node =q.peek();
            q.remove();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.add(it);
            }
        }
        if(topo.size()==v)return true;
        return false;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] prerequisites = new int[3][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;

        prerequisites[1][0] = 2;
        prerequisites[1][1] = 1;

        prerequisites[2][0] = 3;
        prerequisites[2][1] = 2;

        _22PreRequisite obj = new _22PreRequisite();
        boolean ans = obj.isPossible(N, prerequisites);
        if (ans)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
