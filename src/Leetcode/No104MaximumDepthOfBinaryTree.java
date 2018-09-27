package Leetcode;

import Leetcode.common.TreeNode;

/**
 * @author xiangfeidong
 *
 * 104.Maximum Depth of Binary Tree
 */
public class No104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
