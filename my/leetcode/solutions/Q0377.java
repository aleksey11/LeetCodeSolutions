package my.leetcode.solutions;

public class Q0377 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;

        int a = combinationSum4(nums, target);
        System.out.println(a);
    }

    static int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 1; i <= target; i++) {
            memo[i] = -1;
        }
        return f(nums, memo, target);
    }

    static int f(int[] nums, int[] memo, int target) {
        int ways = 0;
        for (int num : nums) {
            int rem = target - num;
            if (rem >= 0) {
                if (memo[rem] >= 0) {
                    ways = ways + memo[rem];
                } else {
                    ways = ways + f(nums, memo, rem);
                }
            }
        }
        memo[target] = ways;
        return ways;
    }
}
