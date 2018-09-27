package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 77.Combinations
 */
public class No077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || n < k) {
            return res;
        }
        dfs(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    private void dfs(int n, int k, List<List<Integer>> res, List<Integer> list, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        //Prune
        if (list.size() + n - start + 1 < k) {
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
