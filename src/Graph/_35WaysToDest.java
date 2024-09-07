package Graph;

import java.util.*;
import java.util.List;
import java.util.PriorityQueue;

public class _35WaysToDest {
    static int countPaths(int n, List<List<Integer>> roads) {
        //creating an adjacency list for the given graph
        ArrayList<ArrayList<Pairr>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m=roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0)).add(new Pairr(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pairr(roads.get(i).get(0), roads.get(i).get(2)));

        }
        //defining a priority queue (min heap)
        PriorityQueue<Pairr> pq = new PriorityQueue<Pairr>((x,y)->x.first-y.first);
        int dis[] = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dis[0] = 0;
        ways[0] = 1;
        pq.add(new Pairr(0, 0));//distance, node
        //define modulo value
        int mod = (int) (1e9 + 7);
        while (pq.size() != 0) {
            int dist = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            //for adjacent
            for (Pairr it : adj.get(node)) {
                int adjnode = it.first;
                int edw = it.second;
                if (dist + edw < dis[adjnode]) {
                    dis[adjnode] = dist + edw;
                    pq.add(new Pairr(dist + edw, adjnode));
                    ways[adjnode] = ways[node];
                }
                //if we again encounter a node with the same short distance
                //as before we simply increment the no. of ways
                else if (dist + edw == dis[adjnode]) {
                    ways[adjnode] = (ways[adjnode] + ways[node]) % mod;
                }
            }
        }
        //finally we return the no. od ways to reach
        return ways[n - 1] % mod;
    }
    public static void main(String[] args) {

        int n = 7;
        List < List < Integer >> roads = new ArrayList < > () {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 6, 7)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 3, 3)));
                add(new ArrayList<Integer>(Arrays.asList(6, 3, 3)));
                add(new ArrayList<Integer>(Arrays.asList(3, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 4, 5)));
                add(new ArrayList<Integer>(Arrays.asList(4, 6, 2)));

            }
        };
        _35WaysToDest obj = new _35WaysToDest();
        int ans = obj.countPaths(n, roads);

        System.out.print(ans);
        System.out.println();
    }
}
