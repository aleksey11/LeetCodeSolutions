package my.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0017b {

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
        String digits = "2345";
        List<String> list = new LinkedList<String>();

        list = combos(digits);
        System.out.println(list.toString());
    }

    private static List<String> combos(String digits) {
        // return empty list on empty input
        if (digits.isEmpty()) {
            return new LinkedList<String>();
        }

        // calculate size of list
        int listSize = 1;
        for (char digit : digits.toCharArray()) {
            listSize = listSize * map.get(digit).length;
        }

        // create array to store results
        // and fill with empty strings
        String[] list = new String[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = "";
        }

        // fill the array with combinations
        int repeat = 1; //times to repeat each letter
        for (char digit : digits.toCharArray()) {
            Character[] letters = map.get(digit);
            int idx = 0; // index to fill in the array
            while (idx < listSize) {
                for (char letter : letters) {
                    for (int r = 0; r < repeat; r++) {
                        list[idx] = list[idx] + letter;
                        idx++;
                    }
                }
            }
            repeat = repeat * map.get(digit).length;
        }

        return Arrays.asList(list);
    }

    private List<String> combos2(String digits) {
        List<String> list = new LinkedList<String>();
        if (digits.isEmpty()) {
            return list;
        }
        list.add("");
        for (char digit : digits.toCharArray()) {
            int listSize = list.size();
            int lettersLength = map.get(digit).length;
            // multiply the list letters.length times
            for (int i = 0; i < lettersLength; i++) {
                for (int j = 0; j < listSize; j++) {
                    list.add(list.get(j));
                }
            }

            // add each letter listSize times
            int idx = 0;
            for (char c : map.get(digit)) {
                for (int i = 0; i < listSize; i++) {
                    //    list.g
                }
            }

            //   char [] letters = map.get(digit);
        }

        return list;
    }
}
