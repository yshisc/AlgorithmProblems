package Leetcode;
/**
 * @author xiangfeidong
 *
 * 74.Search a 2D Matrix
 */
public class No074SearchA2DMatrix {
    /**
     * Flatten 2D matrix and do binary search. O(log(m*n)).
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start < end) {
            final int mid = start + (end - start) / 2;
            final int value = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (value == target) {
                return true;
            } else if (value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return matrix[start / matrix[0].length][start % matrix[0].length] == target;
    }

    /**
     * Search from top right. Each time if the value is not target, discard a row or a column. O(m+n).
     */
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
