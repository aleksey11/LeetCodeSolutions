/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.leetcode.solutions;

import java.util.Random;

/**
 *
 * @author aleksey
 */
public class Q0120_Triangle {

    /*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More
formally, if you are on index i on the current row, you may move to either index
i or index i + 1 on the next row.

Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
  _2_
 _3_4
 6_5_7
4_1_8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10

Constraints:
    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -104 <= triangle[i][j] <= 104
 
Follow up: Could you do this using only O(n) extra space, where n is the total
number of rows in the triangle?
    
     */
    public static void main(String[] args) {
        int[][] t = buildTriangle(3, 1);
        printTriangle(t);
    }

    private static void minPathSum(int[][] triangle) {
    
    }

    private static int[][] buildTriangle(int depth, long seed) {
        int[][] triangle = new int[depth][];
        Random rng = new Random(seed);

        for (int i = 0; i < depth; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = rng.nextInt(9) + 1; //1 to 9.  Explore negative numbers later
            }
        }
        return triangle;
    }

    private static void printTriangle(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            //add spaces
            for (int k = 0; k < (triangle.length - triangle[i].length); k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
