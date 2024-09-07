package HackerRank;
import java.util.PriorityQueue;

public class MinimizeArraySumCOst {
    public static int minimizeCost(int[] arr) {
        // Create a min-heap (PriorityQueue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all elements into the min-heap
        for (int num : arr) {
            minHeap.add(num);
        }

        int totalCost = 0;

        // Continue until only one element remains in the heap
        while (minHeap.size() > 1) {
            // Extract the two smallest elements
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Calculate the cost of this operation
            int cost = first + second;
            totalCost += cost;

            // Add the result back into the heap
            minHeap.add(cost);
        }

        return totalCost;
    }
    public static void main(String[] args) {
        // Example array
        int[] arr = {25, 10, 20};
        System.out.println("Minimum cost to reduce the array: " + minimizeCost(arr));
    }
}
