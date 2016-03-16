package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiangfeidong
 *
 * 94.Binary Tree Inorder Traversal
 */
public class BinaryTreeInorderTraversal {
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
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
