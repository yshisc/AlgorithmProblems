package Leetcode;

import Leetcode.common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author xiangfeidong
 *
 * 117.Populating Next Right Pointers in Each Node II
 *
 * Solution 1: BFS use a queue, O(n) space
 *
 * Solution 2: Very smart BFS solution, constant space
 * Process the nodes level by level.
 * Keep 3 pointers:
 *      node -> traverse to each node in current level
 *      head -> leftmost node in next level
 *      pre  -> previous node of current processed node in next level
 */
public class No117PopulatingNextRightPointersInEachNode2 {
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
        TreeLinkNode node = root;
        TreeLinkNode head = null, pre = null;

        while (node != null) {
            while (node != null) {
                if (node.left != null) {
                    if (pre != null) {
                        pre.next = node.left;
                    } else {
                        head = node.left;
                    }

                    pre = node.left;
                }

                if (node.right != null) {
                    if (pre != null) {
                        pre.next = node.right;
                    } else {
                        head = node.right;
                    }

                    pre = node.right;
                }

                node = node.next;
            }

            node = head;
            head = null;
            pre = null;
        }
    }
}
