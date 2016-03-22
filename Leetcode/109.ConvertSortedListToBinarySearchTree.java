package Leetcode;
/**
 * @author xiangfeidong
 *
 * 109.Convert Sorted List to Binary Search Tree
 *
 * For a sorted array, it consumes O(1) to find the middle element so the current root. However for list it consumes O(n).
 * Think about in DFS inorder traversal of a BST, we will always visit nodes in sorted order.
 * So we can maintain a pointer which points to current processed node.
 * If we first construct left subtree, then root and right subtree, it is guaranted that we visit the list in order.
 * We can create a recursive function, return root of BST generating from a range of input list.
 * The root will cut range into two parts, first is for left subtree, second is for right subtree.
 * We will first keep cutting left part and reach the first node of list, then start conversion.
 */
public class ConvertSortedListToBinarySearchTree {
    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        cur = head;

        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return generateTree(0, len - 1);
    }

    private TreeNode generateTree(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = generateTree(start, mid - 1);

        TreeNode root = new TreeNode(cur.val);
        root.left = left;
        cur = cur.next;

        root.right = generateTree(mid + 1, end);

        return root;
    }
}
