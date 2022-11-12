package my.leetcode.solutions;

public class Q0012 {

    public static int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] roman = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static void main(String[] args) {

        int num = 1994;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < arabic.length; i++) {
            int count = num / arabic[i];
            System.out.println(count);

            for (int k = 0; k < count; k++) {
                out.append(roman[i]);
            }

            num = num % arabic[i];
        }

        System.out.println(out);
    }
}
