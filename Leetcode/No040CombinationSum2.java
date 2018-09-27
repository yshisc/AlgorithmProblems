package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 40.Combination II
 */
public class No040CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        //Avoid duplicates with same index then same combination
        for (int i = start; i < candidates.length; i++) {
            //Avoid duplicates with same value then same combination
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, list, i + 1);
            list.remove(list.get(list.size() - 1));
        }
    }
}
