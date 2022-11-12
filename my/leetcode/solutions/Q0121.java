package my.leetcode.solutions;

public class Q0121 {

    public static void main(String[] args) {
        int[] p = {7, 1, 5, 3, 6, 4};
        int m = maxProfit(p);
        System.out.println(m);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        int todayProfit;
        for (int day = 1; day < prices.length; day++) {
            todayProfit = prices[day] - minPrice;
            maxProfit = (maxProfit > todayProfit) ? maxProfit : todayProfit;
            minPrice = (minPrice < prices[day]) ? minPrice : prices[day];
        }
        return maxProfit;
    }
}
