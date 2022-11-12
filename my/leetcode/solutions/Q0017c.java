package my.leetcode.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q0017c {

    public static HashMap<Character, Character[]> map
            = new HashMap<Character, Character[]>() {
        {
            put('2', new Character[]{'a', 'b', 'c'});
            put('3', new Character[]{'d', 'e', 'f'});
            put('4', new Character[]{'g', 'h', 'i'});
            put('5', new Character[]{'j', 'k', 'l'});
            put('6', new Character[]{'m', 'n', 'o'});
            put('7', new Character[]{'p', 'q', 'r', 's'});
            put('8', new Character[]{'t', 'u', 'v'});
            put('9', new Character[]{'w', 'x', 'y', 'z'});
        }
    };

    public static void main(String[] args) {
        //  List<String> list = new LinkedList<String>();

        String digits = "23"; // "8462";
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

        char currKey = digits.charAt(pos); // .substring(pos, pos + 1);
        Character[] currMap = map.get(currKey);

        for (int i = 0; i < currMap.length; i++) {
            combosR(digits, pos + 1, current + currMap[i], list);
        }
    }
}
