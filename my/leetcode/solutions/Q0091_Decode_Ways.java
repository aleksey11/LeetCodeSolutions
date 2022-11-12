/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.leetcode.solutions;

/**
 *
 * @author aleksey
 */
public class Q0091_Decode_Ways {

    /*
A message containing letters from A-Z can be encoded into numbers using the
following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"

To decode an encoded message, all the digits must be grouped then mapped back
into letters using the reverse of the mapping above (there may be multiple
ways). For example, "11106" can be mapped into:

    "AAJF" with the grouping (1 1 10 6)
    "KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into
'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which
start with 0. Hence, there are no valid ways to decode this since all digits
need to be mapped.

Example 4:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is
different from "06").

Constraints:
    1 <= s.length <= 100
    s contains only digits and may contain leading zero(s).
     */
    public static void main(String[] args) {
        System.out.println(encode("ABCDABC"));
//        System.out.println(encode("KFHk"));
//        System.out.println(encode("yrelfx"));
//        System.out.println(isValidEncoding("1"));
//        System.out.println(isValidEncoding("29"));
//        System.out.println(isValidEncoding("27"));
//        System.out.println(isValidEncoding("26"));
//        System.out.println(isValidEncoding("25"));
//        System.out.println(isValidEncoding("09"));

//        System.out.println(decodeWays(encode("ABCA")));
        System.out.println(decodeWays("123123"));

    }

    static private int decodeWays(String code) {
        if (code.length() == 0) {
            return 0;
        }
        int[] numWays = new int[code.length()];

        //process first character separately
        if (numWays.length >= 1 && isValidEncoding(code.substring(0, 1))) {
            System.out.println(code.substring(0, 1));
            numWays[0] = 1;
        } else {
            return 0;
        }

        for (int i = 1; i < numWays.length; i++) {
            String oneString = code.substring(i, i + 1);
            String twoString = code.substring(i - 1, i + 1);
            System.out.println(oneString + ", " + twoString);

            boolean tryOne = isValidEncoding(code.substring(i, i + 1));
            boolean tryTwo = isValidEncoding(code.substring(i - 1, i + 1));

            if (!tryOne && !tryTwo) { //neither works
                return 0; //can't be done
            } else if (tryOne ^ tryTwo) { //XOR, only one is valid.
                numWays[i] = numWays[i - 1]; //= same number of possible decodings as before
            } else if (tryOne && tryTwo) { //both work
                numWays[i] = numWays[i - 1] + 1; //=one more way to decode
            }
        }
        return numWays[numWays.length - 1];
    }

    static private int decodeWays_bak(String code) {
        int[] numWays = new int[code.length() + 1];
        numWays[0] = 0;

        //process n[1] separately
        if (numWays.length >= 1 && isValidEncoding(code.substring(0, 1))) {
            System.out.println(code.substring(0, 1));
            numWays[1] = 1;
        }

        for (int i = 2; i < numWays.length; i++) {
            String oneString = code.substring(i - 1, i);
            String twoString = code.substring(i - 2, i);
            System.out.println(oneString + ", " + twoString);

            boolean tryOne = isValidEncoding(code.substring(i, i + 1));
            boolean tryTwo = isValidEncoding(code.substring(i - 1, i + 1));

            if (!tryOne && !tryTwo) { //neither works
                return 0; //can't be done
            } else if (tryOne ^ tryTwo) { //XOR
                numWays[i] = numWays[i - 1];
            } else if (tryOne && tryTwo) { //both work
                numWays[i] = numWays[i - 1] + 1;
            }
        }

//        if(!isValidEncoding(code.substring(code.length()-1, code.length()))){
//                    }
        return numWays[numWays.length - 1];
    }

    private static boolean isValidEncoding(String code) {
        //1 to 26 is valid, 0x is not valid
        //(assumes input is all numbers)
        int len = code.length();
        int value = Integer.parseInt(code);
        if (len == 1 && !code.equals("0") && value >= 1 && value <= 9) {
            return true;
        } else if (len == 2 && code.charAt(0) != '0' && value >= 10 && value <= 26) {
            return true;
        }
        return false;
    }

    private static String encode(String message) {
        message = message.toUpperCase();
        StringBuilder out = new StringBuilder();
        for (char c : message.toCharArray()) {
            out.append(Integer.toString((int) (c - 64)));
        }
        return out.toString();
    }

    /*
        check 1 and 2 at a time
        have a check() function 
    
     */
}
