package Leetcode;
/**
 * @author xiangfeidong
 *
 * 105.Construct Binary Tree from Preorder and Inorder Traversal
 *
 * preorder: 1  2  4  5  3  6
 * inorder:  4  2  5  1  3  6
 *
 * First number in preorder is root of current tree, look up it in inorder will get the root position in inorder.
 * Then we can know which part in preorder and inorder belongs to left subtree, which belongs to right subtree.
 * Repeat the process we can reconstruc the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        //Value of root of current tree.
        int value = preorder[preStart];
        TreeNode root = new TreeNode(value);

        //Position of root value in inorder.
        int position = findPosition(inorder, inStart, inEnd, value);
        //Size of left tree.
        int leftSize = position - inStart;
        //Construct left tree.
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, position - 1);
        //Construct right tree.
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, position + 1, inEnd);

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
