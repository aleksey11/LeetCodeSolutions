package my.leetcode.solutions;

/*
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 */
public class Q0064 {

    public static void main(String[] args) {
        int[][] grid;
        grid
                = new int[][]{
                    {1, 3, 1},
                    {1, 5, 1},
                    {4, 2, 1}
                };
        System.out.println(minPathSum(grid));

        grid
                = new int[][]{
                    {1, 2, 3},
                    {4, 5, 6}
                };
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int[] cost = new int[grid[0].length];
        cost[0] = grid[0][0];
        for (int col = 1; col < grid[0].length; col++) {
            cost[col] = cost[col - 1] + grid[0][col];
        }

        for (int row = 1; row < grid.length; row++) {
            cost[0] = cost[0] + grid[row][0]; // 1st col
            for (int col = 1; col < grid[row].length; col++) {
                cost[col]
                        = grid[row][col] // plus min of above or left
                        + Math.min(cost[col], cost[col - 1]);
            }
        }
        return cost[cost.length - 1];
    }
}
