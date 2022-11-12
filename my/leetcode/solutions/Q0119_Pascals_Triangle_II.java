/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.leetcode.solutions;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aleksey
 */
public class Q0119_Pascals_Triangle_II {

    public static void main(String[] args) {
        System.out.println(getRow(3));
//        printPascalsTriangleNicely(getRow(5));
    }

    public static List<BigInteger> getRow(int rowIndex) {
        //The r-th element of the n-th row of Pascal's Triangle can be found
        //with the following formula:
        //   (n,r) = n! / ( r! * (n-r)! )
        List<BigInteger> row = new LinkedList<>();
        BigInteger[] factorial = new BigInteger[rowIndex + 2]; //0!==1, and max r == n + 1
        factorial[0] = BigInteger.ONE;
        for (int i = 1; i < factorial.length; i++) {
            //Populate the factorial array.
            //Can use same values for n!, r!, and (n-r)!
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
        for (int element = 0; element < rowIndex + 1; element++) {
            row.add(factorial[rowIndex].divide((factorial[element].multiply(factorial[rowIndex - element])))); //.intValue());
        }
        return row;
    }

    public static List<Integer> getRow_BAK(int rowIndex) {
        List<Integer> row = new LinkedList<>();
        //   (n,r) = n! / ( r! * (n-r)! )
        int n = rowIndex;
        int[] factorial = new int[n + 2]; //0!==1, and max r == n + 1
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        for (int r = 0; r < n + 1; r++) {
            row.add(factorial[n] / (factorial[r] * factorial[n - r]));
        }
        System.out.println(row.size());
        return row;
    }

}
