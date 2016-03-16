package Leetcode;
/**
 * @author xiangfeidong
 *
 * 81.Search in Rotated Sorted Array II
 *
 * The time could be O(n)
 * For example 113111111
 * No need to use binary search
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
