package Leetcode;

/**
 * 162. Find Peak Element
 *
 * Binary Search. Be careful that when two pointers point to first two elements, mid will be compared with index -1.
 */
public class No162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            final int mid = start + (end - start) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == 0 || nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
