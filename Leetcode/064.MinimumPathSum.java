package Leetcode;
/**
 * @author xiangfeidong
 *
 * 64.Minimum Path Sum
 *
 * State: f[i][j] denotes min path sum to f[i][j]
 * Function: f[i][j] = min{f[i-1][j],f[i][j-1]} + f=grid[i][j]
 * Intialize: f[0][0] = grid[0], f[i][0] = f[i-1][0]+grid[i][0], f[0][j] = f[0][j-1]+grid[0][j]
 * Answer: f[m-1][n-1]
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];

        sum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[m - 1][n - 1];
    }
}
