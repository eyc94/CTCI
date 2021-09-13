/*
-- Zero Matrix --

Write an algorithm such that if an element in an MxN matrix is 0, its
entire row and column are set to 0.
*/

import java.util.Arrays;

public class ZeroMatrix {

    public static void zeroMatrix(int[][] matrix) {
        // Row and column arrays to keep track of what rows and columns our 0 is in.
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Mark in our row and column arrays true where we found the zero.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Iterate through our row array.
        for (int i = 0; i < row.length; i++) {
            // If we encounter a true value, the value of 'i' is the row in which we need to
            // nullify.
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        // Iterate through our column array.
        for (int j = 0; j < column.length; j++) {
            // If we encounter a true value, the value of 'j' is the column in which we need
            // to nullify.
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    // Nullify row to 0 helper function.
    // Takes in the row in which it's all zero.
    public static void nullifyRow(int[][] matrix, int row) {
        // Traverse through all columns in our row and make it zero.
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    // Nullify column to 0 helper function.
    // Takes in the column in which it's all zero.
    public static void nullifyColumn(int[][] matrix, int col) {
        // Traverse through all rows in our column and make it zero.
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] sampleOne = new int[][] { { 2, 3, 4, 0 }, { 5, 6, 7, 1 }, { 8, 9, 0, 3 } };
        System.out.println("before " + Arrays.deepToString(sampleOne));
        zeroMatrix(sampleOne);
        System.out.println("after " + Arrays.deepToString(sampleOne));
    }
}
