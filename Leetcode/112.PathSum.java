package Leetcode;
/**
 * @author xiangfeidong
 *
 * 112.Path Sum
 *
 * The tree has a path adding up tp target if its left or right subtree has a path adding up to target-root.val.
 * However a root's subtree may only have one node, we need to set its empty subtree's result as false.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val  == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
