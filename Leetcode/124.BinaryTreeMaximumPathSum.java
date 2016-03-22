package Leetcode;
/**
 * @author xiangfeidong
 *
 * 124.Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root).maxPath;
    }

    private TreeInfo helper(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, Integer.MIN_VALUE);
        }

        TreeInfo left = helper(root.left);
        TreeInfo right = helper(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new TreeInfo(singlePath, maxPath);
    }

    private class TreeInfo {
        int singlePath;
        int maxPath;
        TreeInfo(int single, int max) {
            singlePath = single;
            maxPath = max;
        }
    }
}
