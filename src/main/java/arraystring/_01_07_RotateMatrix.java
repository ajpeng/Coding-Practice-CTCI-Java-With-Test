package arraystring;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
class _01_07_RotateMatrix {

     int[][] rotateBruteForce(int[][] m) {
        int length = m.length;
        int[][] transposed = new int[length][length];
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                transposed[column][length - row - 1] = m[row][column];
            }
        }
        return transposed;
    }


    /**
     * Time: O(n^2)
     * Space: O(1)
     * @param m matrix
     * @return matrix after rotation
     */
    int[][] rotate(int[][] m) {
        int length = m.length;
        for (int row = 0; row < length/2 ; row++) {
            // column is bounded by n - i - 1;
            for (int column = row; column < length - row - 1; column++) {
                //Save the top left value to placeholder
                int topLeft = m[row][column];

                //Move left bottom to top left
                m[row][column] = m[length - column - 1][row];

                //Move bottom right to bottom left
                m[length - column - 1][row] = m[length - row - 1][length - column - 1];

                //Move top right to bottom right
                m[length - row - 1][length - column - 1] = m[column][length - row - 1];

                //Move topLeft to top right
                m[column][length - row - 1] = topLeft;
            }
        }
        return m;
    }
}
