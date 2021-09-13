/*
-- Rotate Matrix --

Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
write a method to rotate the image by 90 degrees. Can you do this in place?
*/

import java.util.Arrays;

public class RotateMatrix {

    public static boolean rotateMatrix(int[][] matrix) {
        // If the input is empty or if it isn't a perfect square matrix.
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false; // Return false.
        }

        // Grab width of square matrix.
        int n = matrix.length;

        // We go layer by layer. Start at the first layer. Go halfway because layer
        // converge on all sides.
        for (int layer = 0; layer < n / 2; layer++) {
            // Grab the first number in the layer.
            int first = layer;
            // Last number in the layer.
            int last = n - 1 - layer;
            // Cycle around and swap.
            for (int i = first; i < last; i++) {
                // This is the offset for when we want to swap values that are not at the
                // beginning of layer.
                int offset = i - first;
                // Save top.
                int top = matrix[first][i];
                // left -> top.
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left.
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom.
                matrix[last][last - offset] = matrix[i][last];
                // top -> right.
                matrix[i][last] = top;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] sampleOne = new int[][] { { 2, 3, 4 }, { 5, 6, 7 }, { 8, 9, 0 } };
        System.out.println("before " + Arrays.deepToString(sampleOne));
        rotateMatrix(sampleOne);
        System.out.println("after " + Arrays.deepToString(sampleOne));
    }
}
