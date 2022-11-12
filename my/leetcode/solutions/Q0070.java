package my.leetcode.solutions;

/*
70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45

Hint 1:
To reach nth step, what could have been your previous steps? (Think about the step sizes)
 */
public class Q0070 {

    public static void main(String[] args) {
        System.out.println("n = 2: " + climbStairs(2));
        System.out.println("n = 3: " + climbStairs(3));
        System.out.println("n = 4: " + climbStairs(4));
        System.out.println("n = 5: " + climbStairs(5));
        System.out.println("n = 6: " + climbStairs(6));
        System.out.println("n = 45: " + climbStairs(45));
    }

    private static int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
