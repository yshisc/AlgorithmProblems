package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 98.Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {
    //Solution 1: get inorder traversal and check if it's acsending.
    public boolean isValidBST1(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        dfs(inorder, root);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i - 1) >= inorder.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

    //Solution 2: Divide and conquer.
    public boolean isValidBST2(TreeNode root) {
        return helper(root).isValid;
    }

    private TreeInfo helper(TreeNode root) {
        if (root == null) {
            return new TreeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        TreeInfo leftInfo = helper(root.left);
        TreeInfo rightInfo = helper(root.right);

        if (!leftInfo.isValid || !rightInfo.isValid) {
            return new TreeInfo(false, 0, 0);
        }

        if (root.left != null && root.val <= leftInfo.max || root.right != null && root.val >= rightInfo.min) {
            return new TreeInfo(false, 0, 0);
        }

        return new TreeInfo(true, Math.min(leftInfo.min, root.val), Math.max(rightInfo.max, root.val));
    }

    class TreeInfo {
        boolean isValid;
        int min;
        int max;
        TreeInfo(boolean isValid, int min, int max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }
}
