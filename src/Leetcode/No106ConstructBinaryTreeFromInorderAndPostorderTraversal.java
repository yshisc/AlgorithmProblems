package Leetcode;

import Leetcode.common.TreeNode;

/**
 * @author xiangfeidong
 *
 * 106.Construct Binary Tree from Inorder and Postorder Traversal
 *
 * postorder: 4  5  2  6  3  1
 * inorder:   4  2  5  1  3  6
 *
 * Last number in postorder is root of current tree, look up it in inorder will get the root position in inorder.
 * Then we can know which part in postorder and inorder belongs to left subtree, which belongs to right subtree.
 * Repeat the process we can reconstruc the tree.
 */
public class No106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        //Value of root of current tree.
        int value = postorder[postEnd];
        TreeNode root = new TreeNode(value);

        //Position of root value in inorder.
        int position = findPosition(inorder, inStart, inEnd, value);
        //Size of left subtree.
        int leftSize = position - inStart;
        //Construct left subtree.
        root.left = buildTree(inorder, inStart, position - 1, postorder, postStart, postStart + leftSize - 1);
        //Construct right subtree.
        root.right = buildTree(inorder, position + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

    private int findPosition(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
