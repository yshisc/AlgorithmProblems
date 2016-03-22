package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @author xiangfeidong
 * 
 * 107.Binary Tree Level Order Traversal II
 */
public class BinaryTreeLevelOrderTraversa2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
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
                res.add(0, list);
                list = new ArrayList<>();
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }

        return res;
    }
}
