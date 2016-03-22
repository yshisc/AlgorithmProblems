package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiangfeidong
 *
 * 103.Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevelNodes = 1, nextLevelNodes = 0;

        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentLevelNodes--;
            if (res.size() % 2 == 0) {
                //Odd level, add to end.
                list.add(node.val);
            } else {
                //Even level, add to head.
                list.add(0, node.val);
            }

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
                list = new LinkedList<>();
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }

        return res;
    }
}
