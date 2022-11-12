package my.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class Q0003b {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(f(s));

        s = "bbbbb";
        System.out.println(f(s));

        s = "pwwkew";
        System.out.println(f(s));

        s = "";
        System.out.println(f(s));
    }

    private static int f(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int len = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c); // add all unique letters
                len++; // and update current and max lengths.
                maxLen = Math.max(len, maxLen);
            } else { // if c is repeating
                // remove letters from back
                // till we find and remove c
                for (int j = start; j < i; j++) {
                    char p = s.charAt(j);
                    set.remove(p);
                    len--;
                    if (p == c) { // found
                        set.add(c);
                        len++;
                        start = j;
                        break;
                    }
                }
            }
        }
        return maxLen;
    }
}
