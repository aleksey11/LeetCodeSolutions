package my.leetcode.solutions;

public class Q0221 {

    public static char[][] matrix = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };

    public static void main(String[] args) {
        //   int a;
    }
    /*
  public static int maxSquare(char[][] matrix) {
    int max = 0;

    // first row
    for (int c = 0; c < matrix[0].length; c++) {
      int val = matrix[0][c] - '0';
      max = Math.max(max, val);
    }

    // other rows
    for (int r = 1; r < matrix.length; r++) {
      // 0th element
      int val = matrix[0][c] - '0';
      max = Math.max(max, val);
      // other elements
      for (int c = 0; c < matrix[r].length; c++) {
        if (matrix[r][c] == '1') {
          val = Math.min(Math.min(matrix[r][c - 1], matrix[r - 1][c]), matrix[r - 1][c - 1]);
          // matrix[r][c] =
        }
      }
    }

    return max * max;
  }
     */
}
