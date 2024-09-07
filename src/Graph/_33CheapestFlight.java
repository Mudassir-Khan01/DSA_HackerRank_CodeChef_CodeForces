package Graph;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class _33CheapestFlight {
    public int CheapestFLight(int n,int flights[][],int src,int dst,int K) {

        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Pairr>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pairr(flights[i][1], flights[i][2]));
        }

        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating
        // the no. of nodes between src and current node.
        Queue<Tuplee> q = new LinkedList<>();

        q.add(new Tuplee(0, src, 0));

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.
        while(!q.isEmpty()) {
            Tuplee it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // We stop the process as soon as the limit for the stops reaches.
            if(stops > K) continue;
            for(Pairr iter: adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuplee(stops + 1, adjNode, cost + edW));
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
    public static void main(String[] args) {

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        _33CheapestFlight obj = new _33CheapestFlight();
        int ans = obj.CheapestFLight(n,flights,src,dst,K);

        System.out.print(ans);
        System.out.println();
    }
}
class Tuplee {
    int first, second, third;
    Tuplee(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
