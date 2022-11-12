package my.leetcode.solutions;


/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8
 */
public class Q0022 {

    public static void main(String[] args) {
        int n = 5;

        f("(", n, 1, 0);
    }

    private static void f(String s, int n, int open, int closed) {
        // exclude invalid partial solutions
        if (open > n || closed > n || closed > open) {
            return;
        }
        // check if complete solution;;
        if (open == n && closed == n) {
            System.out.println(s);
            return;
        }
        // try other solutions
        f(s + "(", n, open + 1, closed);
        f(s + ")", n, open, closed + 1);
    }
}
