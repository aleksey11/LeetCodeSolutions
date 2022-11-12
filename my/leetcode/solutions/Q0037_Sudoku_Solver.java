/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.leetcode.solutions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aleksey
 */
public class Q0037_Sudoku_Solver {

    public static char[][] board = new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    public static void main(String[] args) {
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        int x = 7;
        int y = 7;
        HashSet<Character> set = getPossileValues(board, x, y);
        System.out.println(set);

//        System.out.println("a");
        //recursive
        // f(board[][], x, y, 
        //
        //find first emptry spot
        //call f(board[], x, y) //board is passed by reference
        //
        // f(board[][], x, y):
        //      create set of possible values
        //      if set is empty, return (backtrack)
        //      for each possible value in set:
        //          create a duplicate board with the value filled in
        //          get the next empty spot x2, y2
        //          if there is no next value, we're finished.  P
        //          call f(boad[][], x2, xy)
        //
    }

    static HashSet<Character> getPossileValues(char[][] board, int x, int y) {
        HashSet<Character> set = new HashSet<>();
        Collections.addAll(set, '1', '2', '3', '4', '5', '6', '7', '8', '9');
        //check local 3x3 grid
        int offsetX = (x / 3) * 3; //top left corner of the 3x3 subgrid
        int offsetY = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + offsetX][j + offsetY] != '.') {
                    set.remove(board[i + offsetX][j + offsetY]);
                }
            }
        }
        //check vertical: keep x same, vary the y
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != '.') {
                set.remove(board[x][i]);
            }
        }
        //check horizontal: vary the x, keep y same
        for (int i = 0; i < 9; i++) {
            if (board[i][y] != '.') {
                set.remove(board[i][y]);
            }
        }
        return set;
    }

}
