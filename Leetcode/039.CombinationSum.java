package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangfeidong
 * 39.Combination Sum
 *
 * Use DFS to try all possible combinations
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Sort array to make result in non-descending order.
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            //Add the copy of list to result.
            res.add(new ArrayList<>(list));
            return;
        }

        for (int candidate : candidates) {
            //Ignore candidate that is smaller than last number in list.
            if (!list.isEmpty() && candidate < list.get(list.size() - 1)) {
                continue;
            }

            list.add(candidate);
            dfs(candidates, target - candidate, res, list);
            list.remove(list.get(list.size() - 1));
        }
    }
}
