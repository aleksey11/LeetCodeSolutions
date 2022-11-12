package my.leetcode.solutions;

public class Q0174 {

    public static void main(String[] args) {
    }

    private static int minPathSum(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        int[] cost = new int[nCols];
        int[] health = new int[nCols];
        cost[0] = grid[0][0];

        health[0] = 1;
        cost[0] = 1; // initial

        health[0] = health[0] + grid[0][0];
        if (health[0] <= 0) {
            cost[0] = Math.abs(health[0]) + 1;
            health[0] = 1;
        }

        for (int col = 1; col < nCols; col++) {
            health[col] = health[col - 1] + grid[0][col];
            if (health[col] <= 0) {
                cost[col] = cost[col - 1] + Math.abs(health[col]) + 1;
                health[col] = 1;
            } else {
                cost[col] = cost[col - 1];
            }
        }

        for (int row = 1; row < nRows; row++) {
            health[0] = health[0] + grid[row][0];
            if (health[0] <= 0) {
//        cost[0] = cost[0] + Math.abs(health[col]) + 1;
                //      health[col] = 1;
            }

            // cost[0] = cost[0] + grid[row][0]; // 1st col
            for (int col = 1; col < nCols; col++) {
                health[col]
                        = grid[row][col] //
                        + Math.min(health[col], health[col - 1]);
                if (health[col] <= 0) {
                    //    cost[col] = 
                }
                cost[col]
                        = grid[row][col] // plus min of above or left
                        + Math.min(cost[col], cost[col - 1]);
            }
        }
        return cost[cost.length - 1];
    }
}
