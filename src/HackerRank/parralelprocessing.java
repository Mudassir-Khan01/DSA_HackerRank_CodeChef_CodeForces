package HackerRank;
import java.util.*;
public class parralelprocessing {

        public static long minTime(List<Integer> files, int numCores, int limit) {
            long ans = 0;
            int k = 1;
            List<Integer> v = new ArrayList<>();

            for (int file : files) {
                if (file % numCores != 0) {
                    ans += file;
                } else {
                    v.add(file);
                }
            }

            Collections.sort(v, Collections.reverseOrder());

            for (int i = 0; i < v.size(); i++) {
                if (k <= limit) {
                    ans += (v.get(i) / numCores);
                    k++;
                } else {
                    ans += v.get(i);
                }
            }

            return ans;
        }

        public static void main(String[] args) {
            // Example usage:
            List<Integer> files = Arrays.asList(30, 40, 60, 70);
            int numCores = 2;
            int limit = 2;
            long result = minTime(files, numCores, limit);
            System.out.println(result); // Output will depend on the input
        }
    }

