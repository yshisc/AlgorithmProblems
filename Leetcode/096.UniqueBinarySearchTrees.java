package Leetcode;
/**
 * @author xiangfeidong
 *
 * 96.Unique Binary Search Trees
 *
 *  1      1         3     3      2
 *   \      \       /     /      / \
 *    2      3     2     1      1   3
 *     \    /     /       \
 *      3  2     1         2
 * For example n=3.
 * Root can be 1, 2, or 3.
 * When root=k, the count equals (number of unique BSTs with k-1 nodes) * (number of unique BSTs with n-k nodes)
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] count = new int[n + 1];

        count[0] = count[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                count[i] += count[k - 1] * count[i - k];
            }
        }

        return count[n];
    }
}
