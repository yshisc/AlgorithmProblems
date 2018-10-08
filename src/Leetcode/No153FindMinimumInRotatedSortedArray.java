package Leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * Find the first element <= last element.
 */
public class No153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            final int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start];
    }
}
