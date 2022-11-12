package my.leetcode.solutions;

import java.util.Queue;
import java.util.LinkedList;

/*
209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class Q0209 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("min=" + minSubSum(nums, target));

        nums = new int[]{1, 4, 4};
        target = 4;
        System.out.println("min=" + minSubSum(nums, target));

        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        target = 11;
        System.out.println("min=" + minSubSum(nums, target));
    }

    private static int minSubSum(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int len = 0;
        int minLen = Integer.MAX_VALUE;

        q.add(nums[0]);
        sum = nums[0];
        len = 1;

        int i = 1;
        while (i < nums.length) {
            if (sum >= target) {
                minLen = Math.min(len, minLen);
                sum = sum - q.remove();
                len--;
            } else {
                q.add(nums[i]);
                sum = sum + nums[i];
                len++;
                i++;
            }
        }
        while (!q.isEmpty()) {
            if (sum >= target) {
                minLen = Math.min(len, minLen);
                sum = sum - q.remove();
                len--;
            } else {
                break;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
