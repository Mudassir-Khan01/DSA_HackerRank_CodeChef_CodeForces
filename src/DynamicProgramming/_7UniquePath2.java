package DynamicProgramming;

public class _7UniquePath2 {
        // Function to calculate the number of paths through the maze
        static int mazeObstacles(int n, int m, int[][] maze) {
            // Initialize the previous row of the DP matrix
            int prev[] = new int[n];

            for (int i = 0; i < n; i++) {
                // Create a temporary array for the current row
                int temp[] = new int[m];

                for (int j = 0; j < m; j++) {
                    // Base conditions
                    if (i > 0 && j > 0 && maze[i][j] == -1) {
                        temp[j] = 0; // If there's an obstacle, no paths can go through here.
                        continue;
                    }
                    if (i == 0 && j == 0) {
                        temp[j] = 1; // There's one valid path to the start cell.
                        continue;
                    }

                    int up = 0;
                    int left = 0;

                    // Check if moving up is possible
                    if (i > 0)
                        up = prev[j];

                    // Check if moving left is possible
                    if (j > 0)
                        left = temp[j - 1];

                    // Calculate the number of paths by adding paths from above and from the left
                    temp[j] = up + left;
                }

                // Update the previous row with the values of the current row
                prev = temp;
            }

            // The final result is stored in the last element of the previous row
            return prev[n - 1];
        }

        public static void main(String args[]) {
            // Define the maze
            int[][] maze = {
                    {0, 0, 0},
                    {0, -1, 0},
                    {0, 0, 0}
            };

            int n = maze.length;
            int m = maze[0].length;

            // Calculate and print the number of paths through the maze
            System.out.println(mazeObstacles(n, m, maze));
        }
    }

