package Leetcode;
/**
 * @author xiangfeidong
 *
 * 34.Search for a Range
 *
 * Binary serach for first index and last index.
 */
public class No034SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{findFirstOrLast(nums, target, true), findFirstOrLast(nums, target, false)};
    }

    private int findFirstOrLast(int[] nums, int target, boolean first) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {    // The condition cannot be `start < end` because of `start = mid` assignment, otherwise infinite loop may happen.
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (first) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target && nums[end] == target) {
            return first ? start : end;
        } else if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
