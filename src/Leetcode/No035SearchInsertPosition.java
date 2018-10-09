package Leetcode;
/**
 * @author xiangfeidong
 *
 * 35.Search Insert Position
 *
 * Binary search. Find the smallest number >= target.
 */
public class No035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            final int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (nums[start] >= target) {
            return start;
        } else {
            return nums.length;
        }
    }
}
