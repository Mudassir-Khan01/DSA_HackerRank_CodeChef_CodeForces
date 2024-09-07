package Assignment;

import java.util.*;
public class Dijkstra {
    public static class Node {
        private int id;
        private List<Edge> edges = new ArrayList<>();
        public Node(int id) {this.id = id;}
        public int getId() {return id;}
        public void addEdge(Node neighbor, int weight) {
            edges.add(new Edge(this, neighbor, weight));
        }
        public List<Edge> getEdges() {return edges;}
    }
    public static class Edge {
        private Node source;
        private Node destination;
        private int weight;
        public Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public Node getSource() {
            return source;
        }
        public Node getDestination() {
            return destination;
        }
        public int getWeight() {
            return weight;
        }
    }
    public static Map<Node, Integer> dijkstra(Node start, List<Node> nodes) {
        Map<Node, Integer> distances = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : nodes) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0); // Distance to starting node is 0
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> distances.get(n1) - distances.get(n2));
        pq.add(start);
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getDestination();
                int newDistance = distances.get(current) + edge.getWeight();
                if (!visited.contains(neighbor) && newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    pq.add(neighbor);
                }
            }
        }
        return distances;
    }
    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node0.addEdge(node1, 4);
        node0.addEdge(node2, 2);
        node1.addEdge(node2, 3);
        node1.addEdge(node3, 1);
        node2.addEdge(node3, 4);
        Map<Node, Integer> distances = dijkstra(node0, Arrays.asList(node0, node1, node2, node3));
        for (Node node : distances.keySet()) {
            System.out.println("Distance from node0 to node" + node.getId() + ": " + distances.get(node));
        }
    }
}
