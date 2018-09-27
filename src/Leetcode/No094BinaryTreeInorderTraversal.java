package Leetcode;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiangfeidong
 *
 * 94.Binary Tree Inorder Traversal
 */
public class No094BinaryTreeInorderTraversal {
    //Solution 1: recursion
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(res, root);
        return res;
    }

    private void inorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(res, root.left);
        res.add(root.val);
        inorderTraversal(res, root.right);
    }

    //Solution 2: iteration
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    //Solution 3: Morris Algo.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res  = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null) {
            //Left is null then add current node to path and go to right.
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                //Find the predecessor.
                TreeNode pre = cur.left;
                //To find the predecessor keep going right until right node is cur or null.
                while (pre.right != cur && pre.right != null) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    //If right node is null then go left before establishing link from pre to cur.
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    //Left is already visited. Go right after visiting cur.
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return res;
    }
}

