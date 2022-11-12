package my.leetcode.solutions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,-1], k = 1
Output: [1,-1]

Example 4:
Input: nums = [9,11], k = 2
Output: [11]

Example 5:
Input: nums = [4,-2], k = 2
Output: [4]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
public class Q0239 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));

        nums = new int[]{1};
        k = 1;
        System.out.println(maxSlidingWindow(nums, k));

        nums = new int[]{1, -1};
        k = 1;
        System.out.println(maxSlidingWindow(nums, k));

        nums = new int[]{9, 11};
        k = 2;
        System.out.println(maxSlidingWindow(nums, k));

        nums = new int[]{4, -2};
        k = 2;
        System.out.println(maxSlidingWindow(nums, k));
    }

    private static LinkedList<Integer> maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int i;
        // add first k elements from nums[]
        for (i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        //process first window
        max.add(Collections.max(q));

        // now process remaining windows
        while (i < nums.length) {
            q.remove();
            q.add(nums[i]);
            max.add(Collections.max(q));
            i++;
        }

        return max;
    }
}
