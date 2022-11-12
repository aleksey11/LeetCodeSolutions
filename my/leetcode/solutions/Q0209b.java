package my.leetcode.solutions;

import java.util.Queue;
import java.util.LinkedList;

public class Q0209b {

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
