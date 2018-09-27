package Leetcode;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @author xiangfeidong
 *
 * 102.Binary Tree Level Order Traversal
 */
public class No102BinaryTreeLevelOrderTraversal {
    //Solution 1: iteration
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevelNodes = 1, nextLevelNodes = 0;

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentLevelNodes--;
            list.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                nextLevelNodes++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) {
                res.add(list);
                list = new ArrayList<>();
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }

        return res;
    }

    //Solution 2: recursive
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        levelOrder(root.left, res, level + 1);
        levelOrder(root.right, res, level + 1);
    }
}
