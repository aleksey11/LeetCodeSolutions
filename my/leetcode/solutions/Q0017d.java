package my.leetcode.solutions;

import java.util.LinkedList;
import java.util.List;

public class Q0017d {

    public static char[][] map = {
        {}, // 0
        {}, // 1
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {

        char c = '0';
        int i = c;
        System.out.println(c + "   " + i);

        String digits = "234"; // "8462";
        List<String> list = combos(digits);
        //   combos(digits, 0, "", list);

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.toString());
    }

    private static List<String> combos(String digits) {
        List<String> list = new LinkedList<String>();
        if (digits.isEmpty()) {
            return list;
        }
        combosR(digits, 0, "", list);
        return list;
    }

    private static void combosR(String digits, int pos, String current, List<String> list) {
        if (pos >= digits.length()) {
            if (!current.isEmpty()) {
                list.add(current);
            }
            return;
        }

        //   String currKey = String.valueOf(digits.charAt(pos)); // .substring(pos, pos + 1);
        int currKey = digits.charAt(pos) - 48;
        char[] currMap = map[currKey];
        // map[Integer.parseInt(currKey)];

        for (int i = 0; i < currMap.length; i++) {
            combosR(digits, pos + 1, current + currMap[i], list);
        }
    }
}
