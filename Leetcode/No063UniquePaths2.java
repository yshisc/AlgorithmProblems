package Leetcode;
/**
 * @author xiangfeidong
 *
 * 63.Unique Paths II
 *
 * State: f[i][j] denotes unique paths to (i,j)
 * Function: (1)if (i,j) is a obstacle, f[i][j] =0
 *           (2)else, f[i][j] = f[i-1][j] + f[i][j-1]
 * Initialize: f[i][0], f[0][j]
 * Answer: f[m-1][n-1]
 */
public class No063UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            paths[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            paths[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }
}
