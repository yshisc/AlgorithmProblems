package Leetcode;

import Leetcode.common.TreeNode;

/**
 * @author xiangfeidong
 *
 * 108.Convert Sorted Array to Binary Search Tree
 */
public class No108ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        //Calculate position of root.
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        //Generate left and right subtree.
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }
}
