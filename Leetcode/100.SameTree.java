package Leetcode;
/**
 * @author xiangfeidong
 *
 * 100.Same Tree
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Both are empty
        if (p == null && q == null) {
            return true;
        }

        //Both are not empty
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        //One is empty, another is not.
        return false;
    }
}
