package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 78.Subsets
 */
public class Subsets {
    //Solution 1: DFS
    public List<List<Integer>> subsets1(int[] nums) {
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
            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Solution 2
     * For example, an array with length of 3.
     *      0 -> 000 -> []
     *      1 -> 001 -> [0]
     *      2 -> 010 -> [1]
     *      3 -> 011 -> [1,2]
     *      4 -> 100 -> [3]
     *      5 -> 101 -> [1,3]
     *      6 -> 110 -> [2,3]
     *      7 -> 111 -> [1,2,3]
     * Each subset can be represented by a binary int between 0,...,2^n-1
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();
            //Check if jth number should be added to current subset.
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(list));
        }

        return res;
    }
}
