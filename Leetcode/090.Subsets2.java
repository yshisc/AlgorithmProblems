package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 90.Subsets II
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));

        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                //Eliminate duplicate.
                continue;
            }
            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
