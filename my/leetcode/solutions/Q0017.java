package my.leetcode.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q0017 {

    public static char[][] keypad = {
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

    public static HashMap<String, String[]> map
            = new HashMap<String, String[]>() {
        {
            put("2", new String[]{"a", "b", "c"});
            put("3", new String[]{"d", "e", "f"});
            put("4", new String[]{"g", "h", "i"});
            put("5", new String[]{"j", "k", "l"});
            put("6", new String[]{"m", "n", "o"});
            put("7", new String[]{"p", "q", "r", "s"});
            put("8", new String[]{"t", "u", "v"});
            put("9", new String[]{"w", "x", "y", "z"});
        }
    };

    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();

        //  System.out.println(map.get("2")[2]);
        String digits = "23"; //"8462";

        combos(digits, 0, "", list);

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.toString());
    }

    private static void combos(String digits, int pos, String current, List<String> list) {
        if (pos >= digits.length()) {
            if (!current.isEmpty()) {
                list.add(current);
            }
            return;
        }

        String currKey = digits.substring(pos, pos + 1);
        String[] currMap = map.get(currKey);

        for (int i = 0; i < currMap.length; i++) {
            combos(digits, pos + 1, current + currMap[i], list);
        }
    }
}
