package my.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
1306. Jump Game III

Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

Constraints:
1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length

Hint 1:
Think of BFS to solve the problem.

Hint 2:
When you reach a position with a value = 0 then return true.
 */
public class Q1306 {

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(canReach(arr, start));

        arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        start = 0;
        System.out.println(canReach(arr, start));

        arr = new int[]{3, 0, 2, 1, 2};
        start = 2;
        System.out.println(canReach(arr, start));
    }

//  private static boolean f1(int[] arr, int start,) {
    private static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int idx = queue.remove();
            int jump = arr[idx];
            if (jump == 0) {
                return true;
            }
            visited[idx] = true;

            if (idx - jump >= 0 && !visited[idx - jump]) {
                queue.add(idx - jump);
            }
            if (idx + jump < arr.length && !visited[idx + jump]) {
                queue.add(idx + jump);
            }
        }

        return false;
    }
}
