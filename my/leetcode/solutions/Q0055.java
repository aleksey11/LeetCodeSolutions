package my.leetcode.solutions;


/*
55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
 */
public class Q0055 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean[] visited = new boolean[nums.length];
        System.out.println(recursiveWithMemo(0, nums, visited));
        System.out.println(iterativeWithTable(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        visited = new boolean[nums.length];
        System.out.println(recursiveWithMemo(0, nums, visited));
        System.out.println(iterativeWithTable(nums));
    }

    public static boolean recursiveWithMemo(int currIdx, int[] nums, boolean[] visited) {
        if (currIdx == nums.length - 1) {
            return true;
        }
        int maxJump = nums[currIdx];
        if (maxJump == 0) {
            visited[currIdx] = true;
            return false;
        }
        // go in reverse: try longer jumps first
        for (int jump = maxJump; jump > 0; jump--) {
            if (recursiveWithMemo(currIdx + jump, nums, visited) == true) {
                return true;
            }
        }
        // if we reach this far
        visited[currIdx] = true;
        return false;
    }

    public static boolean iterativeWithTable(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        visited[visited.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums[i]; j > 0; j--) {
                if (i + j < nums.length && visited[i + j] == true) {
                    visited[i] = true;
                    break; //found at least one path
                }
            }
        }
        return visited[0];
    }
}
