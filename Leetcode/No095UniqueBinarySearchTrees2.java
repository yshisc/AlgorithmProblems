package Leetcode;

import Leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 95.Unique Binary Search Trees II
 */
public class No095UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    //Generate tree list that has nodes start~end.
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        //Root can be start~end.
        for (int i = start; i <= end; i++) {
            //when root is i, generate tree lists of left and right subtrees.
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
