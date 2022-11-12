package my.leetcode.solutions;

import java.util.HashSet;

public class Q0003 {

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            set.add(c);
            count = 1;

            for (int j = i + 1; j < s.length(); j++) {
                c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                } else {
                    set.add(c);
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
            set.clear();
        }
        return max;
    }
}
