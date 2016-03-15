package Leetcode;
/**
 * @author xiangfeidong
 *
 * 73.Set Matrix Zeroes
 *
 * Use first row to store which row will be 0s.
 * Use first col to store which col will be 0s.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        //Record if first row will be 0s.
        boolean isFirstRowZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        //Record if first col will be 0s.
        boolean isFirstColZero = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        //Store information if first row and first col.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Set 0s except first row and first col.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Set first row to 0s.
        if (isFirstRowZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        //Set first col to 0s.
        if (isFirstColZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
