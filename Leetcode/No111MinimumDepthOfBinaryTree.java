package Leetcode;

import Leetcode.common.TreeNode;

/**
 * @author xiangfeidong
 *
 * 111.Minimum Depth of Binary Tree
 *
 * Min depth of a tree = min of left subtree depth and right subtree depth.
 * However a root's subtree may only have one node, we need to set its empty subtree's depth as max_int.
 */
public class No111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(helper(root.left), helper(root.right)) + 1;
    }
}
