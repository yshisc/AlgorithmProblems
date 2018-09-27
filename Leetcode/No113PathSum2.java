package Leetcode;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xiangfeidong
 *
 * 113.Path Sum II
 */
public class No113PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            return;
        }

        //Current node is leaf
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        //Explore left subtree and right subtree. Backtrack.
        list.add(root.val);
        helper(root.left, sum - root.val, res, list);
        helper(root.right, sum - root.val, res, list);
        list.remove(list.size() - 1);
    }
}
