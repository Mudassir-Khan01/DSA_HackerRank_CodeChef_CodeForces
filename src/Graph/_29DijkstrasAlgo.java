package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _29DijkstrasAlgo {//using priority queue
    static int [] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>>adj,int s){
        //create a priority queue for storing the nodes as a pair {dist,node}
        //where dist is the distance from the source to the node
        PriorityQueue<Pq>pq=new PriorityQueue<Pq>((x,y)->x.distance-y.distance);
        int []dist=new int[v];
        //initalize dist with the largest no.
        //indicate the nodes are unvistited initially
        //this list contains distance from the source to the node
        for(int i=0;i<v;i++){
            dist[i]=(int)1e9;
        }
        dist[s]=0;//initialize source node to zero
        pq.add(new Pq(0,s));
        //now pop the minimum distance node from the mi heap
        //and traverse for all its adjacent nodes
        while(!pq.isEmpty()){
            int dis=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();

            //check for all adjacent node of the popped out
            for(int i=0;i<adj.get(node).size();i++){
                int edgeweight=adj.get(node).get(i).get(1);
                int adjnode=adj.get(node).get(i).get(0);

                if(dis+edgeweight<dist[adjnode]){
                    dist[adjnode]=dis+edgeweight;
                    pq.add(new Pq(dist[adjnode],adjnode));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args)  {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.
        _29DijkstrasAlgo obj = new _29DijkstrasAlgo();
        int[] res= obj.dijkstra(V,adj,S);

        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}
class Pq{
    int node;
    int distance;
    public Pq(int distance ,int node){
        this.node=node;
        this.distance=distance;
    }
}
