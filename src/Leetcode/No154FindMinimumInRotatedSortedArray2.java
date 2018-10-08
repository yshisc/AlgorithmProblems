package Leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array II
 *
 * In worst case like 1, 1, ..., 1, binary search is impossible.
 */
public class No154FindMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
