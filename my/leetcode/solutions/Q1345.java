package my.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
1345. Jump Game IV

Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:
    i + 1 where: i + 1 < arr.length.
    i - 1 where: i - 1 >= 0.
    j where: arr[i] == arr[j] and i != j.

Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Example 2:
Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You don't need to jump.

Example 3:
Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

Example 4:
Input: arr = [6,1,9]
Output: 2

Example 5:
Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
Output: 3

Constraints:
    1 <= arr.length <= 5 * 104
    -108 <= arr[i] <= 108

Hint 1:
Build a graph of n nodes where nodes are the indices of the array and edges for node i are nodes i+1, i-1, j where arr[i] == arr[j].

Hint 2:
Start bfs from node 0 and keep distance, answer is the distance when you reach onode n-1.
 */
public class Q1345 {

    public static void main(String[] args) {
        int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(arr));

        arr = new int[]{7};
        System.out.println(minJumps(arr));

        arr = new int[]{7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println(minJumps(arr));

        arr = new int[]{6, 1, 9};
        System.out.println(minJumps(arr));

        arr = new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;
        int steps = 0;
        int currIdx;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize > 0) {
                currIdx = queue.remove();
                queueSize--;

                // check if we've reached the end
                // if yes, return number of steps
                if (currIdx == arr.length - 1) {
                    return steps;
                }

                // check if we can add children nodes:
                // nodes with same value
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (arr[currIdx] == arr[j] && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
                // i+1
                if (currIdx + 1 < arr.length && !visited[currIdx + 1]) {
                    queue.add(currIdx + 1);
                    visited[currIdx + 1] = true;
                }
                // i-1
                if (currIdx - 1 >= 0 && !visited[currIdx - 1]) {
                    queue.add(currIdx - 1);
                    visited[currIdx - 1] = true;
                }
            }
            steps++;
        }
        return -1; // can't reach
    }
}
