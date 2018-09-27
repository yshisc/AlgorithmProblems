package Leetcode;
/**
 * @author xiangfeidong
 *
 * 59.Spiral Matrix II
 *
 * We are traversing matrix layer by layer from outer to inner.
 * A layer can be identified by up row, down row, left col, right col.
 * (1)traverse up row, and decrement it.
 * (2)traverse right col, and decrement it.
 * (3)traverse down row, and increment it. (Check if down row <= up row before traversal)
 * (4)traverse left col, and increment it. (Check if left col <= right col before traversal)
 */
public class No059SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;

        int upRow = 0, downRow = n - 1, leftCol = 0, rightCol = n - 1;
        while (upRow <= downRow) {
            //Traverse up row
            for (int i = leftCol; i <= rightCol; i++) {
                matrix[upRow][i] = value++;
            }
            upRow++;

            //When n is odd, the last iteration only needs to handle one value.
            if (upRow > downRow) {
                break;
            }

            //Traverse right col
            for (int i = upRow; i <= downRow; i++) {
                matrix[i][rightCol] = value++;
            }
            rightCol--;

            //Traverse down row
            for (int i = rightCol; i >= leftCol; i--) {
                matrix[downRow][i] = value++;
            }
            downRow--;

            //Traverse left col
            for (int i = downRow; i >= upRow; i--) {
                matrix[i][leftCol] = value++;
            }
            leftCol++;
        }
        return matrix;
    }
}
