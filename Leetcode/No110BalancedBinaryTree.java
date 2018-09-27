package Leetcode;

import Leetcode.common.TreeNode;

/**
 * @author xiangfeidong
 *
 * 110.Balanced Binary Tree
 *
 * A tree is balanced iff
 * (1)left subtree is balanced,
 * (2)right subtree is balanced, and
 * (3)|left subtree depth - right subtree depth| <= 1
 */
public class No110BalancedBinaryTree {
    /**
     * Solution 1: create a new type to denotes wheter a tree is balanced and its depth.
     */
    public boolean isBalanced1(TreeNode root) {
        return helper1(root).isBalanced;
    }

    private TreeInfo helper1(TreeNode root) {
        if (root == null) {
            return new TreeInfo(true, -1);
        }

        TreeInfo left = helper1(root.left);
        TreeInfo right = helper1(root.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new TreeInfo(false, 0);
        }

        if (Math.abs(left.depth - right.depth) > 1) {
            return new TreeInfo(false, 0);
        }

        return new TreeInfo(true, Math.max(left.depth, right.depth) + 1);
    }

    private class TreeInfo {
        boolean isBalanced;
        int depth;
        TreeInfo(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }

    /**
     * Solution 2: use a unique number to denotes a tree is not balanced, which can never be a depth. We use -2.
     */
    public boolean isBalanced2(TreeNode root) {
        return helper2(root) != -2;
    }

    private int helper2(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = helper2(root.left);
        int right = helper2(root.right);

        if (left == -2 || right == -2) {
            return -2;
        }

        if (Math.abs(left - right) > 1) {
            return -2;
        }

        return Math.max(left, right) + 1;
    }
}
