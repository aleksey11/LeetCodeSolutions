package my.leetcode.solutions;


/*
1340. Jump Game V

Given an array of integers arr and an integer d. In one step you can jump from index i to index:

i + x where: i + x < arr.length and 0 < x <= d.
i - x where: i - x >= 0 and 0 < x <= d.

In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).

You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
Output: 4
Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because 13 > 9. You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
Similarly You cannot jump from index 3 to index 2 or index 1.

Example 2:
Input: arr = [3,3,3,3,3], d = 3
Output: 1
Explanation: You can start at any index. You always cannot jump to any index.

Example 3:
Input: arr = [7,6,5,4,3,2,1], d = 1
Output: 7
Explanation: Start at index 0. You can visit all the indicies.

Example 4:
Input: arr = [7,1,7,1,7,1], d = 2
Output: 2

Example 5:
Input: arr = [66], d = 1
Output: 1


Constraints:
1 <= arr.length <= 1000
1 <= arr[i] <= 10^5
1 <= d <= arr.length

Hint 1;
Use dynamic programming. dp[i] is max jumps you can do starting from index i. Answer is max(dp[i]).

Hint 2:
dp[i] = 1 + max (dp[j]) where j is all indices you can reach from i.
 */
public class Q1340b {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        //  arr = new int[]{7,6,5,4,3,2,1};
        int d = 2;
        int[] memo = new int[arr.length];

        for (int i = 0; i < memo.length; i++) {
            //  System.out.println("i=" + i + " memo=" + memo[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            f(arr, memo, d, i);
        }

        //  int max = Collections.max(Arrays.asList(memo));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < memo.length; i++) {
            System.out.println("i=" + i + "\t\t\tarr[i]=" + arr[i] + "\t\t\tmemo=" + memo[i]);
            //  System.out.println(memo[i]);
            //  max = Math.max(max, memo[i]);
        }
        System.out.println("max=" + max);
    }

    private static void f(int[] arr, int[] memo, int d, int i) {
        if (memo[i] != 0) {
            return; // this step is done
        }

        int max = 0;
        // explore each possible jump
        for (int j = 1; j <= d; j++) {
            // forwards in the array
            if (i + j < arr.length && arr[i] > arr[i + j]) {
                //  if (memo[i + j] == 0) {
                f(arr, memo, d, i + j);
                //   }
                max = Math.max(max, memo[i + j]);
            }
            // backwards
            if (i - j >= 0 && arr[i] > arr[i - j]) {
                //  if (memo[i - j] == 0) {
                f(arr, memo, d, i - j);
                // }
                max = Math.max(max, memo[i - j]);
            }
        }
        memo[i] = 1 + max;
        //  System.out.println("i=" + i + "\t\t\tarr[i]="+arr[i]+"\t\t\tmemo=" + memo[i]);
        return;
    }
}
