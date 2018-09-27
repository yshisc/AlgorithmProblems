package Leetcode;

import Leetcode.common.TreeNode;

/**
 * @author xiangfeidong
 * 
 * 114.Flatten Binary Tree to Linked List
 */
public class No114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);

        //Record right subtree, change left subtree as right subtree, and set left subtree as null.
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        
        //Find right-most node of current tree, and link previous flattened right subtree.
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = tmp;
    }
}
