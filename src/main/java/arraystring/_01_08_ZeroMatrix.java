package arraystring;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zeroHW(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        boolean[] colFlags = new boolean[width];
        boolean[] rowFlags = new boolean[height];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (matrix[row][column] == 0) {
                    colFlags[column] = true;
                    rowFlags[row] = true;
                }
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (colFlags[col] || rowFlags[row]) {
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }

    int[][] zero(int[][] matrix) {
        int width = matrix.length;
        int height = matrix[0].length;
        boolean[] colFlags = new boolean[width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == 0) {
                    colFlags[col] = true;
                }
            }
        }

        for (int row = 0; row < height; row++) {
            // we dont need an array of flags
            boolean isZeroRow = false;
            for (int col = 0; col < width; col++) {
                if (colFlags[col]) {
                    isZeroRow = true;
                    break;
                }
            }
            for (int col = 0; col < width; col++) {
                if (isZeroRow || colFlags[col] ) {
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }
}
