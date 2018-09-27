package Leetcode;
/**
 * @author xiangfeidong
 *
 * 74.Search a 2D Matrix
 *
 * Search from top left. Each time if the value is not target, discard a row or a column.
 */
public class No074SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
