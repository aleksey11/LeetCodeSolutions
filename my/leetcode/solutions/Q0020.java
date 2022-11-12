package my.leetcode.solutions;

import java.util.Stack;

public class Q0020 {

    public static void main(String[] args) {
        String s = "([{}]{})";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else {
                // closing character
                if (stack.empty()) {
                    return false;
                }
                char p = stack.peek();
                if ((p == '(' && c == ')')
                        || (p == '{' && c == '}')
                        || (p == '[' && c == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
