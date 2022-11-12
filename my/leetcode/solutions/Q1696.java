package my.leetcode.solutions;


/*
1696. Jump Game VI

You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

Return the maximum score you can get.

Example 1:
Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.

Example 2:
Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.

Example 3:
Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0

Constraints:
1 <= nums.length, k <= 105
-104 <= nums[i] <= 104

Hint 1:
Let dp[i] be "the maximum score to reach the end starting at index i". The answer for dp[i] is nums[i] + max{dp[i+j]} for 1 <= j <= k. That gives an O(n*k) solution.

Hint 2:
Instead of checking every j for every i, keep track of the largest dp[i] values in a heap and calculate dp[i] from right to left. When the largest value in the heap is out of bounds of the current index, remove it and keep checking.
 */
public class Q1696 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, -2, 4, -7, 3};
        int k = 2;
        System.out.println(hint1(nums, k));

        nums = new int[]{10, -5, -2, 4, 0, 3};
        k = 3;
        System.out.println(hint1(nums, k));

        nums = new int[]{1, -5, -20, 4, -1, 3, -6, -3};
        k = 2;
        System.out.println(hint1(nums, k));
    }

    public static int hint1(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = nums[nums.length - 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= k && i + j < dp.length; j++) {
                max = Math.max(max, dp[i + j]);
            }
            dp[i] = nums[i] + max;
        }
        return dp[0];
    }
}
