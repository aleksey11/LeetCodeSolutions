package my.leetcode.solutions;


/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Example 3:
Input: m = 7, n = 3
Output: 28

Example 4:
Input: m = 3, n = 3
Output: 6
 

Constraints:
1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109
 */
public class Q0062 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 3));
    }

    private static int uniquePaths(int m, int n) {
        int shorter = Math.min(m, n);
        int longer = Math.max(m, n);
        int[] row = new int[shorter];
        for (int i = 0; i < shorter; i++) {
            row[i] = 1; //1st row is all 1's
        }
        for (int j = 1; j < longer; j++) {
            row[0] = 1;
            for (int i = 1; i < shorter; i++) {
                row[i] = row[i] + row[i - 1];
                //the recurrence equation
            }
        }
        return row[row.length - 1];
    }
}
