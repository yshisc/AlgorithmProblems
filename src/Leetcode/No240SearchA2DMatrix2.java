package Leetcode;

/**
 * 240. Search a 2D Matrix II
 *
 * Search from top right. Each time if the value is not target, discard a row or a column. O(m+n).
 */
public class No240SearchA2DMatrix2 {
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
