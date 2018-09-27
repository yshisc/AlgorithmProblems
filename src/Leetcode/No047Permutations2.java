package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author xiangfeidong
 *
 * 47.Permutation II
 *
 * For example: {1,1,2}
 *                     /    |    \
 *                    1    (1)    2
 *                   / \   / \   / \
 *                  1  2 (1)(2)  1 (1)
 *                  |  |  |  |   |  |
 *                  2  1 (2)(1)  1 (1)
 * () represents duplicate combinations
 */
public class No047Permutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        //Sort array so that we can easy to handle duplicate situations
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, list, visited);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //Skip numbers that have been added to current path
            if (visited[i]) {
                continue;
            }
            //Skip number same as pre number and pre number has not been added to current path.
            //Because the pre number has been added to other path at this position, in this layer of recursion.
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
