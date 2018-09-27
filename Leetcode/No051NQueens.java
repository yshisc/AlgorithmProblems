package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xiangfeidong
 *
 * 51.N-Queens
 */
public class No051NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //Record the column number in each row.
        List<Integer> rows = new ArrayList<>();
        dfs(n, res, rows);
        return res;
    }

    private void dfs(int n, List<List<String>> res, List<Integer> rows) {
        if (rows.size() == n) {
            res.add(drawChessboard(rows));
            return;
        }

        //Try all column number for next row.
        for (int col = 0; col < n; col++) {
            //Check if it is valid after add this position.
            if (!isValid(rows, col)) {
                continue;
            }

            rows.add(col);
            dfs(n, res, rows);
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

    private List<String> drawChessboard(List<Integer> rows) {
        int n = rows.size();
        List<String> board = new ArrayList<String>();
        for (int col : rows) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (col == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }
}
