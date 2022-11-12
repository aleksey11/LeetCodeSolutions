package my.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
45. Jump Game II

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
 */
public class Q0045 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(iterativeWithTable(nums));
        System.out.println(bfs(nums));

        System.out.println();

        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(iterativeWithTable(nums));
        System.out.println(bfs(nums));
    }

    public static int iterativeWithTable(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = nums[i]; j > 0; j--) {
                if (i + j < nums.length) {
                    min = Math.min(min, dp[i + j]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }

    public static int bfs(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        int steps = 0;
        int currIdx;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize > 0) {
                currIdx = queue.remove();
                queueSize--;

                // check if we've reached the end
                // if yes, return number of steps
                if (currIdx == nums.length - 1) {
                    return steps;
                }

                // add children
                for (int j = 1; j <= nums[currIdx]; j++) {
                    queue.add(currIdx + j);
                }
            }
            steps++;
        }
        return -1; // can't reach
    }
}
