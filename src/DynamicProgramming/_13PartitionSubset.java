package DynamicProgramming;

public class _13PartitionSubset {
    static boolean canPartition(int n,int[]arr){
        int totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=arr[i];
        }
        if(totalsum%2==1)//if it is odd
            return false;
        else {
            int k=totalsum/2;//target
            boolean prev[] = new boolean[k + 1];

            // Initialize the first row of the DP table
            prev[0] = true;

            // Initialize the first column of the DP table
            if (arr[0] <= k) {
                prev[arr[0]] = true;
            }

            // Fill in the DP table using bottom-up dynamic programming
            for (int ind = 1; ind < n; ind++) {
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    // Calculate if the current element is not taken
                    boolean notTaken = prev[target];

                    // Calculate if the current element is taken
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = prev[target - arr[ind]];
                    }

                    // Update the DP table for the current element and target sum
                    cur[target] = notTaken || taken;
                }
                // Update the previous row with the current row for the next iteration
                prev = cur;
            }

            // The result is stored in the last cell of the DP table
            return prev[k];
        }
    }
    public static void main(String args[]) {
        int arr[] = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        // Check if the array can be partitioned into two equal subsets
        if (canPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }

    //memoization and tabulation here
    //https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/
}
