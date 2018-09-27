package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 46.Permutations
 */
public class No046Permutations {
    /**
     * Solution 1: DFS. Use a visited array to record whether a number has been added in current path.
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, list, visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    /**
     * Solutoin 2:
     * Add new number to previous list by inserting to every possible position.
     * For example: input {1,2,3}
     *      (0) start with an empty list {}
     *      (1) insert 1 to position 0: {1}
     *      (2) insert 2 to position 0 or 1: {2,1} {1,2}
     *      (3) insert 3 to position 0 or 1 or 2: {3,2,1} {3,1,2} {2,3,1} {1,3,2} {2,1,3} {1,2,3}
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Start from an empty list. Use linked list to get high insertion performance.
        res.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newRes = new ArrayList<>();

            //Enumerate all possible insertion positions.
            for (int j = 0; j <= i; j++) {
                //Enumerate all lists which already contain numbers nums[0]...nums[i-1].
                for (List<Integer> list : res) {
                    List<Integer> newList = new LinkedList<>(list);
                    newList.add(j, nums[i]);
                    newRes.add(newList);
                }
            }

            res = newRes;
        }

        return res;
    }
}
