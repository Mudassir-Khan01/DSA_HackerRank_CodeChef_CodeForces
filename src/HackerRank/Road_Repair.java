package HackerRank;
import java.util.*;
public class Road_Repair {
    public static long getMinCost(List<Integer> crewIds, List<Integer> jobIds) {
        // Sort crew and job IDs in ascending order
        crewIds.sort(Integer::compareTo);
        jobIds.sort(Integer::compareTo);

        long totalCost = 0;

        // Calculate absolute difference for each crew-job pair
        for (int i = 0; i < crewIds.size(); i++) {
            totalCost += Math.abs(crewIds.get(i) - jobIds.get(i));
        }

        return totalCost;
    }
//    public static void main(String[] args) throws IOException {
//        // Simulate reading input from a file (replace with actual reading logic)
//        String filePath = "input.txt"; // Replace with your input file path
//        List<Integer> crewIds = new ArrayList<>();
//        List<Integer> jobIds = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            int crewCount = Integer.parseInt(reader.readLine());
//
//            // Read crew IDs
//            for (int i = 0; i < crewCount; i++) {
//                crewIds.add(Integer.parseInt(reader.readLine()));
//            }
//
//            int jobCount = Integer.parseInt(reader.readLine());
//
//            // Read job IDs
//            for (int i = 0; i < jobCount; i++) {
//                jobIds.add(Integer.parseInt(reader.readLine()));
//            }
//        }
//
//        long minCost = getMinCost(crewIds, jobIds);
//        System.out.println(minCost);
//    }
}
