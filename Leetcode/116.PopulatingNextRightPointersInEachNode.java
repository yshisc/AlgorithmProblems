package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiangfeidong
 *
 * Solution 1: BFS use a queue, O(n) space
 *
 * Solution 2: Very smart BFS solution, constant space
 * Process the nodes level by level.
 * Keep two pointers, pre pioints to leftmost node of a level, cur travels to each node at same level with pre.
 */
public class PopulatingNextRightPointersInEachNode {
    //Solution 1
    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevelNodes = 1, nextLevelNodes = 0;

        while (!queue.isEmpty()) {
            TreeLinkNode cur = queue.poll();
            currentLevelNodes--;

            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelNodes++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) {
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            } else {
                cur.next = queue.peek();
            }
        }
    }

    //Solution 2
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode pre = root;
        while (pre.left != null) {
            TreeLinkNode cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
