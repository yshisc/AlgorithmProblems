package Leetcode;
/**
 * @author xiangfeidong
 *
 * 99.Recover Binary Search Tree
 */
public class RecoverBinarySearchTree {
    /**
     * Solution 1. O(n) space
     *
     * Since two nodes in BST are swapped, first of the two must be too big in inorder, and second must be too small in inorder.
     * For example, 1 5 3 4 2 6.
     * When we meet 5 >= its next nodes, it is the first.
     * When we meet 2 <= its pre nodes, it is the second.
     *
     * Use a TreeNode array, nodes[0] is previous node in tracerse, nodes[1] is first swapped node, nodes[2] is second swapped node.
     */
    public void recoverTree1(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3];
        traverse(root, nodes);

        int tmp = nodes[1].val;
        nodes[1].val = nodes[2].val;
        nodes[2].val = tmp;
    }

    private void traverse(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return;
        }

        traverse(root.left, nodes);

        if (nodes[0] != null) {
            if (nodes[1] == null && nodes[0].val >= root.val) {
                nodes[1] = nodes[0];
            }
            if (nodes[1] != null && nodes[0].val >= root.val) {
                nodes[2] = root;
            }
        }
        nodes[0] = root;

        traverse(root.right, nodes);
    }

    /**
     * Solution 2: Morris. O(1) space.
     */
    public void recoverTree2(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode previous = null, current = root;
        while (current != null) {
            if (current.left == null) {
                if (previous != null && previous.val >= current.val) {
                    if (first == null) {
                        first = previous;
                    }
                    if (first != null) {
                        second = current;
                    }
                }
                previous = current;
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    if (previous != null && previous.val >= current.val) {
                        if (first == null) {
                            first = previous;
                        }
                        if (first != null) {
                            second = current;
                        }
                    }
                    previous = current;
                    current = current.right;
                }
            }
        }

        //Swap
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
