package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 22.Generate Parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, 0, 0, "");
        return res;
    }

    private void dfs(List<String> res, int n, int left, int right, String s) {
        if (right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            dfs(res, n, left + 1, right, s + "(");
        }
        if (left > right) {
            dfs(res, n, left, right + 1, s + ")");
        }
    }
}
