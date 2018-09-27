package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 54.Spiral Matrix
 *
 * We are traversing matrix layer by layer from outer to inner.
 * A layer can be identified by up row, down row, left col, right col.
 * (1)traverse up row, and decrement it.
 * (2)traverse right col, and decrement it.
 * (3)traverse down row, and increment it. (Check if down row <= up row before traversal)
 * (4)traverse left col, and increment it. (Check if left col <= right col before traversal)
 */
public class No054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int upRow = 0, downRow = matrix.length - 1, leftCol = 0, rightCol = matrix[0].length - 1;
        while (upRow <= downRow && leftCol <= rightCol) {
            //Traverse up row
            for (int i = leftCol; i <= rightCol; i++) {
                res.add(matrix[upRow][i]);
            }
            upRow++;

            //Traverse right col
            for (int i = upRow; i <= downRow; i++) {
                res.add(matrix[i][rightCol]);
            }
            rightCol--;

            //Traverse down row
            if (downRow >= upRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    res.add(matrix[downRow][i]);
                }
            }
            downRow--;

            //Traverse left col
            if (leftCol <= rightCol) {
                for (int i = downRow; i >= upRow; i--) {
                    res.add(matrix[i][leftCol]);
                }
            }
            leftCol++;
        }

        return res;
    }
}
