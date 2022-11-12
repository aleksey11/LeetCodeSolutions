/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.leetcode.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aleksey
 */
public class Q0118_Pascals_Triangle {

    public static void main(String[] args) {

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();

        list.add(new LinkedList<>());
        list.get(0).add(1);

        for (int row = 1; row < numRows; row++) {
            list.add(new LinkedList<>()); //add new row
            for (int element = 0; element < row + 1; element++) {
                int value = 0;
                if (element - 1 >= 0) { //check left side for out-of-bounds
                    value += list.get(row - 1).get(element - 1);
                }
                if (element < list.get(row - 1).size()) { //check right side for out-of-bounds
                    value += list.get(row - 1).get(element);
                }
                list.get(row).add(value);
            }
        }
        return list;
    }
}
