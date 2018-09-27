package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 52.N-Queens II
 */
public class No052NQueens2 {
    public int totalNQueens(int n) {
        int[] sum = new int[1];
        dfs(n, new ArrayList<>(), sum);
        return sum[0];
    }

    private void dfs(int n, List<Integer> rows, int[] sum) {
        if (rows.size() == n) {
            sum[0]++;
        }

        //Try all column number for next row.
        for (int col = 0; col < n; col++) {
            //Check if it is valid after add this position.
            if (!isValid(rows, col)) {
                continue;
            }

            rows.add(col);
            dfs(n, rows, sum);
            rows.remove(rows.size() - 1);
        }
    }

    private boolean isValid(List<Integer> rows, int col) {
        //Get coordinate of to-be-inserted position.
        int x1 = col, y1 = rows.size();

        //Traverse every added position, check if it is on same line with (x1, y1).
        for (int i = 0; i < rows.size(); i++) {
            //Get coordinate of an added position.
            int x2 = rows.get(i), y2 = i;
            //Whether in same column
            if (x1 == x2) {
                return false;
            }
            //Whether in same line from left-bottom to right-top
            if (x2 - x1 == y2 - y1) {
                return false;
            }
            if (x2 - x1 == y1 - y2) {
                return false;
            }
        }

        return true;
    }
}
