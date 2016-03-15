package Leetcode;
/**
 * @author xiangfeidong
 *
 * 62.Unique Paths
 *
 * State: f[i][j] denotes unique paths to (i,j)
 * Function: f[i][j] = f[i-1][j] + f[i][j-1]
 * Initialize: f[i][0] = f[0][j] = 1
 * Answer: f[m-1][n-1]
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            paths[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }
}
