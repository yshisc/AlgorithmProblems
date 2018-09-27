package Leetcode;

import Leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiangfeidong
 *
 * 101.Symmetric Tree
 */
public class No101SymmetricTree {
    /**
     * A tree is symmetric, if its left and right are mirror, which means that
     * 1. both left and right are null, or
     * 2. values of left and right are equal, and
     *      (1)left's left and right's right are mirror, (2)left's right and right's left are mirror
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return check(node1.left, node2.right) && check(node1.right, node2.left);
    }

    /**
     * Solution 2: use queue
     * slower than solution 1.
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root.left != null) {
            if (root.right == null) {
                return false;
            }
            queue.add(root.left);
            queue.add(root.right);
        } else if (root.right != null) {
            return false;
        }

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1.val != node2.val) {
                return false;
            }

            if (node1.left != null) {
                if (node2.right == null) {
                    return false;
                }
                queue.add(node1.left);
                queue.add(node2.right);
            } else if (node2.right != null) {
                return false;
            }

            if (node1.right != null) {
                if (node2.left == null) {
                    return false;
                }
                queue.add(node1.right);
                queue.add(node2.left);
            } else if (node2.left != null) {
                return false;
            }
        }

        return true;
    }
}
